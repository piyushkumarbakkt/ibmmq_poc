package com.bakkt.poc.ibmmq.message.service;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
public class Payload {

    private String text;

    private LocalDateTime messageTime;
}
