package ru.it2g.h2o.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ru.it2g.h2o.dto.baseuser.UserDto;
import ru.it2g.h2o.entity.User;

@Getter
public class UserRegisteredEvent extends ApplicationEvent {

    private final UserDto user;
    public UserRegisteredEvent(Object source, UserDto user) {
        super(source);
        this.user = user;
    }
}
