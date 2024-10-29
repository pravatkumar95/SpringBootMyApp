package com.centroxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class SpringBootKafkaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaConsumerApplication.class, args);
	}
	
	@KafkaListener(topics = "topic2", groupId = "my-group")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }

}
