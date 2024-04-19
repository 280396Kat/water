package ru.it2g.h2o.service.auth.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.it2g.h2o.dto.baseuser.UserDto;
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

    @Override
    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Long createOrUpdateUser(UserDto userDto) {  // регистрация или обновление данных о пользователе
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
                                    User userSave = userRepository.save(user);
                                    userEventPublisher.publishUserRegisteredEvent(userSave);
                                    return userSave.getId();
                                }).orElseGet(() -> {
                                    User createUser = toEntity(userDto);
                                    Optional.ofNullable(userDto.getPassword())
                                            .ifPresentOrElse(password -> createUser.setPassword(passwordEncoder.encode(password)),
                                                    () -> {
                                                        throw new IllegalArgumentException("Пароль должен быть заполнен");
                                                    });
                                    return userRepository.save(createUser).getId();
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
        return getByUsername(username)
                .map(user -> passwordEncoder.matches(password, user.getPassword()))
                .orElse(false);
    }

    @Override
    public void logOut(String username) {
        SecurityContextHolder.getContext().setAuthentication(null);
    }

}
