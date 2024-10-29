package com.centroxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import com.centroxy.model.Employee;

@SpringBootApplication
@RestController
public class SpringBootConsumerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConsumerAppApplication.class, args);
	}
	
	@KafkaListener(topics = "topic2", groupId = "my-group")
	@SendTo("/topic/public")
    public Employee listen(Employee employee) {
        System.out.println("Received message: " +employee);
        return employee;
    }

}
