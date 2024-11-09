package ru.it2g.h2o.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.it2g.h2o.service.kafka.ProducerService;

@RestController
public class MessageController {

    private final ProducerService producerService;

    public MessageController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/send")
    public void sendMessage(@RequestBody String message) {
        producerService.sendMessage("my-topic", message);
    }
}
