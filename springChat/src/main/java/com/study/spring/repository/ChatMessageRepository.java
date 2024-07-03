package com.study.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.spring.model.Message;

public interface ChatMessageRepository extends JpaRepository<Message, Long> {

}
