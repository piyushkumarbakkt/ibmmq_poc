package com.bakkt.poc.ibmmq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageReceiver {


    @JmsListener(destination = "DEV.QUEUE.1")
    public void listener1(String message) {
        log.info("Message received by listener1 {}", message);
    }

    @JmsListener(destination = "DEV.QUEUE.1")
    public void listener2(String message) {

        log.info("Message received by listener2 {}", message);
    }

    @JmsListener(destination = "DEV.QUEUE.1")
    public void listener3(String message) {

        log.info("Message received by listener3 {}", message);
    }
}
