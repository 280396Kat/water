package ru.it2g.h2o.service.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import ru.it2g.h2o.dto.baseuser.UserDto;
import ru.it2g.h2o.entity.User;
import ru.it2g.h2o.event.UserRegisteredEvent;
import ru.it2g.h2o.service.UserEventPublisher;

@Component
@RequiredArgsConstructor
public class UserEventPublisherImpl implements UserEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishUserRegisteredEvent(UserDto user) {
        applicationEventPublisher.publishEvent(new UserRegisteredEvent(this, user));
    }
}
