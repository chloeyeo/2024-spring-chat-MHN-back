package com.study.spring.model;

import java.time.ZonedDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class ChatMessage {
	@Id
	private Long id;
	private String chatId;
	private Long senderId;
	private Long recipientId;
	private String content;
	private ZonedDateTime createdAt;
}
