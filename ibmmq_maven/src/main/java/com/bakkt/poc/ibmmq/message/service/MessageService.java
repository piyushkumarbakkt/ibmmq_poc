package com.bakkt.poc.ibmmq.message.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageService {

    private final JmsTemplate jmsTemplate;

    @Value("${ibm.mq.queue}")
    private String queue;

    public MessageService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String message) {
        try {
            jmsTemplate.convertAndSend(queue, message);
            log.info("Message sent successfully");
        } catch (JmsException ex) {
            log.error(ex.getMessage(), ex);
        }
    }
}
