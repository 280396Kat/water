package ru.it2g.h2o.service.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.it2g.h2o.service.MessageSenderService;

@Service
@RequiredArgsConstructor
public class MailMessageSenderServiceImpl implements MessageSenderService {

    private final JavaMailSender javaMailSender;

    @Override
    public boolean sendMessage(String mail) { // сделали приветственное сообщение
        if (mail == null || mail.equals("")) {
            return false;
        }
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mail);
        message.setSubject("Добро пожаловать!");
        message.setText("Спасибо за регистрацию в нашем сервие.");
        javaMailSender.send(message);
        return true;
    }


}
