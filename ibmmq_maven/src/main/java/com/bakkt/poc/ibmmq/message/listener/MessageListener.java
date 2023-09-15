package com.bakkt.poc.ibmmq.message.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @JmsListener(destination = "DEV.QUEUE.1", containerFactory = "jmsListenerContainerFactory")
    public void listener1(String message) {
        System.out.println("Received message from listener1 \n" + message);
    }

    @JmsListener(destination = "DEV.QUEUE.1", containerFactory = "jmsListenerContainerFactory")
    public void listener2(String message) {
        System.out.println("Received message from listener2 \n" + message);
    }
}
