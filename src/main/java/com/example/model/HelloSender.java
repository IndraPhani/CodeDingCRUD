package com.example.model;

import com.example.config.JmsConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class HelloSender {

    private final JmsTemplate jmsTemplate;
    @Scheduled(fixedRate = 2000)
    public void sendMessage(){
        HelloWorldMessgae messgae = HelloWorldMessgae
                .builder()
                .id(UUID.randomUUID())
                .message("Hello World!!")
                .build();
        System.out.println("I am Hello sender from scheduling message");
        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE,messgae);
        System.out.println("Java object is converted and sent to ARTIMES QUEEU but did not read from the queue");
        System.out.println("Message sent");
    }
}
