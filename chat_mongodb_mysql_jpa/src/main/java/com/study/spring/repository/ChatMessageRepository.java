package com.study.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.study.spring.model.ChatMessage;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, Long> {

}
