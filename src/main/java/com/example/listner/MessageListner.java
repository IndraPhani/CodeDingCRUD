package com.example.listner;

import com.example.config.JmsConfig;
import com.example.model.HelloWorldMessgae;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessageListner {
@JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessgae hm, @Headers MessageHeaders headers, Message message){
        System.out.println("Hey I got the message!!");
    System.out.println(hm);
    }
}
