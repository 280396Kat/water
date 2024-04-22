package ru.it2g.h2o.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.it2g.h2o.dto.baseuser.UserDto;
import ru.it2g.h2o.service.MessageSenderService;

@Component
@RequiredArgsConstructor
public class UserRegisteredEventListener {

    private final MessageSenderService messageSenderService;

    @EventListener
    public void handleUserRegisteredEvent(UserRegisteredEvent event) {
        UserDto user = event.getUser();
        String mail = user.getMail();
        messageSenderService.sendMessage(mail);
    }
}
