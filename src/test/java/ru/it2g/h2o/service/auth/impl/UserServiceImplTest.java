package ru.it2g.h2o.service.auth.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.it2g.h2o.dto.baseuser.UserDto;
import ru.it2g.h2o.entity.User;
import ru.it2g.h2o.repository.UserRepository;
import ru.it2g.h2o.service.auth.UserService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void cleanUp() {
        userRepository.deleteAll();
    }

    @Test
    void createOrUpdateUser() {
        UserDto user = UserDto.builder()
                .username("string5")
                .password("string5")
                .roles("string5")
                .phoneNumber("123213123123")
                .build();
        Long userId = userService.createOrUpdateUser(user);
        User userPersistence = userRepository.findById(userId).get();
        Assertions.assertEquals(userId, userPersistence.getId());
        Assertions.assertEquals(user.getUsername(), userPersistence.getUsername());
    }
}
