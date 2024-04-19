package ru.it2g.h2o.service;

import ru.it2g.h2o.entity.User;

public interface UserEventPublisher {

    void publishUserRegisteredEvent(User user);
}
