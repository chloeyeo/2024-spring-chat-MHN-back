package com.study.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.study.spring.model.Message;
import com.study.spring.service.ChatMessageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ChatController {
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	@Autowired
	private ChatMessageService chatMessageService;
	
	@MessageMapping("/message") // this is /app/message
	@SendTo("/chatroom/public")
	public Message receivePublicMessage(@Payload Message message) {
		try {
			log.info("Received public message: {}", message);
	        Message savedMessage = chatMessageService.saveMessage(message);
	        log.info("Saved public message: {}", savedMessage);
	        return savedMessage;
		} catch (Exception e) {
			log.error("Error processing public message: ", e);
	        throw e;
		}
		
	}
	
	@MessageMapping("/private-message")
	public Message receivePrivateMessage(@Payload Message message) {
		try {
			log.info("Received private message: {}", message);
			Message savedMessage = chatMessageService.saveMessage(message);
			simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private", savedMessage); // e.g. /user/David/private
			log.info("Saved private message: {}", savedMessage);
			return savedMessage;
		} catch (Exception e) {
			log.error("Error processing private message: ", e);
	        throw e;
		}
		
	}
}
