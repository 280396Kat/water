package ru.it2g.h2o.service.auth.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.it2g.h2o.dto.baseuser.UserDto;
import ru.it2g.h2o.dto.statisticDto.StatisticDto;
import ru.it2g.h2o.entity.User;
import ru.it2g.h2o.repository.UserRepository;
import ru.it2g.h2o.service.UserEventPublisher;
import ru.it2g.h2o.service.auth.AuthService;
import ru.it2g.h2o.service.auth.UserService;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserEventPublisher userEventPublisher;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Long createOrUpdateUser(UserDto userDto) {
        Optional<User> userEmail = userRepository.findByMail(userDto.getMail());
        if (!userEmail.isPresent()) {
            userEventPublisher.publishUserRegisteredEvent(userDto);
        }
        return Optional.ofNullable(userDto.getUsername())
                .map(username ->
                        userRepository.findByUsername(userDto.getUsername())
                                .map(user -> {
                                    user.setMail(userDto.getMail());
                                    user.setRoles(userDto.getRoles());
                                    Optional.ofNullable(userDto.getPassword())
                                            .ifPresent(password -> {
                                                user.setPassword(password);
                                                user.setPassword(passwordEncoder.encode(password));
                                            });
                                    return userRepository.save(user).getId();
                                }).orElseGet(() -> {
                                    User user = toEntity(userDto);
                                    Optional.ofNullable(userDto.getPassword())
                                            .ifPresentOrElse(password -> user.setPassword(passwordEncoder.encode(password)),
                                                    () -> {
                                                        throw new IllegalArgumentException("Пароль должен быть заполнен");
                                                    });
                                    return userRepository.save(user).getId();
                                })
                )
                .orElseThrow(() -> new IllegalArgumentException("Логин не может быть пустым"));
    }

    private User toEntity(UserDto userDto) {
        return User.builder()
                .username(userDto.getUsername())
                .roles(userDto.getRoles())
                .password(userDto.getPassword())
                .phoneNumber(userDto.getPhoneNumber())
                .mail(userDto.getMail())
                .build();
    }

    @Override
    public boolean login(String username, String password) {
        boolean isLogin =  getByUsername(username)
                .map(user -> passwordEncoder.matches(password, user.getPassword()))
                .orElse(false);
        if(isLogin) {
            StatisticDto statisticDto = new StatisticDto();
            statisticDto.setName(username);
            kafkaTemplate.send("statistic", statisticDto);
        }
        return isLogin;
    }

    @Override
    public void logOut(String username) {
        SecurityContextHolder.getContext().setAuthentication(null);
    }

}
