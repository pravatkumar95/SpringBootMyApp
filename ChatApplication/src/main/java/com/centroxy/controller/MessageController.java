package com.centroxy.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.centroxy.model.Message;

@RestController
public class MessageController {
	
	@MessageMapping("/chat")
	@SendTo("/topic/greeting")
	public Message getContent(@RequestBody Message message) {
		
		try {
			
			
			Thread.sleep(2000);
		}
		catch(InterruptedException e) {
			
			e.printStackTrace();
		}
		
		return message;
		
	}

}
