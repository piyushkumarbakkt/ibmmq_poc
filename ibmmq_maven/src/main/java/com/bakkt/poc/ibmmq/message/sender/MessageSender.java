package com.bakkt.poc.ibmmq.message.sender;

import com.bakkt.poc.ibmmq.message.service.MessageService;
import com.bakkt.poc.ibmmq.message.service.Payload;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
@Slf4j
@RequiredArgsConstructor
public class MessageSender {

    private final Random random = new Random();

    private final MessageService messageService;

    private final ObjectMapper objectMapper;

    @Scheduled(fixedRate = 5000, initialDelay = 10000)
    public void pushMessage() {
        Payload message
                = Payload.builder().text(generateRandomText()).messageTime(LocalDateTime.now()).build();
        try {
            messageService.sendMessage(objectMapper.writeValueAsString(message));
        } catch (Exception ex) {
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
