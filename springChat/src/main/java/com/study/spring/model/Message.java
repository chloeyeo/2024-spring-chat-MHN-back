package com.study.spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="chat_messages")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
	private Long id;
	
	@Column(nullable=false)
	private String senderName;
	
	@Column(nullable=false)
	private String receiverName;
	
	@Column(nullable=false, columnDefinition="TEXT")
	private String message;
	
	@Column(nullable=false)
	private String date;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Status status;
}
