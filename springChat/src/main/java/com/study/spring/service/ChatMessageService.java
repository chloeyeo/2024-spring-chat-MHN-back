package com.study.spring.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.spring.model.Message;
import com.study.spring.repository.ChatMessageRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChatMessageService {
	@Autowired
	private ChatMessageRepository chatMessageRepository;
	
	public Message saveMessage(Message message) {
		message.setDate(LocalDate.now().toString());
		log.info("Saving message: {}", message);
        Message savedMessage = chatMessageRepository.save(message);
        log.info("Message saved with ID: {}", savedMessage.getId());
		return savedMessage;
	}
}
