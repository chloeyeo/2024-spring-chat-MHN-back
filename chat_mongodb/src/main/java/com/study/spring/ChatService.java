package com.study.spring;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService {
	private final ChatRoomRepository chatRoomRepository;
	private final ChatMessageRepository chatMessageRepository;
	
	public ChatRoom createChatRoom(ChatRoom chatRoom) {
		return chatRoomRepository.save(chatRoom);
	}
}
