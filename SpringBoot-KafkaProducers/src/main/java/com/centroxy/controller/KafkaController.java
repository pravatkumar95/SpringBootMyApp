package com.centroxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.centroxy.producer.KafkaProducer;

@RestController
public class KafkaController {
	
	@Autowired
    private KafkaProducer producer;

    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
    	
    	
    	producer.sendMessage("topic3",message);
    	
    	return "send message to kafka topic:::"+message;

}
}

