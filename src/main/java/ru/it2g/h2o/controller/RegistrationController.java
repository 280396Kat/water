package ru.it2g.h2o.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.it2g.h2o.dto.baseuser.UserDto;
import ru.it2g.h2o.service.auth.UserService;

@RestController
@RequestMapping("/registration")
@Api(tags = "Регистрация пользователя")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @PostMapping("/create")
    public Long createOrUpdateUser(@RequestBody UserDto userDto) {
        return userService.createOrUpdateUser(userDto);
    }
}
