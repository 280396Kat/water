package ru.it2g.h2o.controller;

import io.swagger.annotations.Api;
import liquibase.pro.packaged.S;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.it2g.h2o.dto.auth.AuthRequestDto;
import ru.it2g.h2o.jwt.JwtProvider;
import ru.it2g.h2o.service.auth.AuthService;

import java.security.Principal;

@RestController
@RequestMapping("/auth")
@Api(tags = "Авторизация пользователя")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    private final JwtProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequestDto authRequestDto) {
        if (authService.login(authRequestDto.getUsername(), authRequestDto.getPassword())) {
            return ResponseEntity.ok(jwtProvider.generateToken(authRequestDto.getPassword()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/logout")
    public void logout(Principal principal) {
        authService.logOut(principal.getName());
    }
}
