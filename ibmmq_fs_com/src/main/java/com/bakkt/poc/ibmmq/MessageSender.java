package com.bakkt.poc.ibmmq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.Random;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageSender {
    private final JmsTemplate jmsTemplate;

    private final Random random = new Random();

    @Value("${ibm.mq.queue}")
    private String destination;


    /*public void sendMessage() {
        jmsTemplate.send(destination, session -> session.createTextMessage("ABC"));
    }*/

    @Scheduled(initialDelay = 5000, fixedDelay = 5000)
    public void sendMessage() {
        try {
            jmsTemplate.convertAndSend(destination, generateRandomText());
            log.info("Message sent successfully");
        } catch (JmsException ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    private String generateRandomText() {
        // letter 'a'
        int leftLimit = 97;
        // letter 'z'
        int rightLimit = 122;
        int targetStringLength = 10;
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
