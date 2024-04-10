package ru.it2g.h2o.service.auth.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.it2g.h2o.dto.auth.CustomUserDetails;
import ru.it2g.h2o.service.auth.UserService;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceImpl(@Lazy UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // ходим в систему и проверяем валидность
        return userService.getByUsername(username)
                .map(user -> CustomUserDetails.builder()
                        .userName(username)
                        .password(user.getPassword())
                        .grantedAuthority(Arrays.stream(user.getRoles().split(";"))
                                .map(SimpleGrantedAuthority::new)
                                .collect(Collectors.toList()))
                                .build()
                        ).orElseThrow(() -> new  IllegalArgumentException("Пользователь не найден"));
    }
}
