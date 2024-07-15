package com.study.spring;

import java.util.List;

import org.springframework.data.annotation.Id;

// store everything other than ChatMessage in mysql
public class ChatRoom {
	@Id
	private Long id;
	private String senderEmail;
	private String receiverEmail;
	private List<Long> messageIds; // References to ChatMessage IDs
}
