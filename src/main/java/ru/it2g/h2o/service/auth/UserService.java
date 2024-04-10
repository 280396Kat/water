package ru.it2g.h2o.service.auth;

import ru.it2g.h2o.dto.baseuser.UserDto;
import ru.it2g.h2o.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getByUsername(String username);

    Long createOrUpdateUser(UserDto userDto);
}
