package ru.it2g.h2o.service;

import ru.it2g.h2o.dto.baseuser.UserDto;

public interface UserEventPublisher {

    void publishUserRegisteredEvent(UserDto user);
}