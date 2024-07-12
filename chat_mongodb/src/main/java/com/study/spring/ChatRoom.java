package com.study.spring;

import java.util.List;

import org.springframework.data.annotation.Id;

public class ChatRoom {
	@Id
	private Long id;
	private String senderEmail;
	private String receiverEmail;
	private List<Long> messageIds; // References to ChatMessage IDs
}
