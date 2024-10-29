package com.centroxy.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import com.centroxy.model.Employee;

@RestController
public class DemoController {
	
	@MessageMapping("/message")
	@SendTo("/topic/public")
	public Employee getMesssage(@Payload Employee emp){
		
			
		return emp;
	}

}
