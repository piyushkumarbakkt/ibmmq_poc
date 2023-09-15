package com.bakkt.poc.ibmmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJms
@EnableScheduling
public class IbmmqFsComApplication {

	public static void main(String[] args) {
		SpringApplication.run(IbmmqFsComApplication.class, args);
	}

}

