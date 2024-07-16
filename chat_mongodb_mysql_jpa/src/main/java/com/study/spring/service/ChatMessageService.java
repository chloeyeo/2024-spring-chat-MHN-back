package com.study.spring.service;

import org.springframework.stereotype.Service;

import com.study.spring.repository.ChatMessageRepository;
import com.study.spring.repository.ChatRoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
	private final ChatRoomRepository chatRoomRepository;
	private final ChatMessageRepository chatMessageRepository;
}
