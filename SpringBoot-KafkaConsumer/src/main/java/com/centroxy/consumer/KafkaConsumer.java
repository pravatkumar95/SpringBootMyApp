package com.centroxy.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
	
	@KafkaListener(topics = "topic3", groupId = "my-topic")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }

}
