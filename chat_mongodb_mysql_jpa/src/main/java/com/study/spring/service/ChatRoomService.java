package com.study.spring.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.study.spring.model.ChatRoomEntity;
import com.study.spring.repository.ChatRoomRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ChatRoomService {
	private final ChatRoomRepository chatRoomRepository;
	
	public Optional<String> getChatRoomId(Long senderId, Long recipientId, boolean createNewRoomIfNotExists) {
		return chatRoomRepository.findBySenderIdAndRecipientId(senderId, recipientId)
				.map(ChatRoomEntity::getChatId)
				.or(()->{
					if (createNewRoomIfNotExists) {
						var chatId = createChatId(senderId, recipientId);
						return Optional.of(chatId);
					}
					return Optional.empty();
				});
	}

	private String createChatId(Long senderId, Long recipientId) {
		var chatId = String.format("%s_%s", senderId+"", recipientId+"");
		ChatRoomEntity senderRecipient = ChatRoomEntity.builder()
				.chatId(chatId)
				.senderId(senderId)
				.recipientId(recipientId)
				.build();
		ChatRoomEntity recipientSender = ChatRoomEntity.builder()
				.chatId(chatId)
				.senderId(senderId)
				.recipientId(recipientId)
				.build();
		chatRoomRepository.save(senderRecipient);
		chatRoomRepository.save(recipientSender);
		return chatId;
	}
}
