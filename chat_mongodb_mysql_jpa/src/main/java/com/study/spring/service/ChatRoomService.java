package com.study.spring.service;

import org.springframework.stereotype.Service;

import com.study.spring.repository.ChatRoomRepository;
import com.study.spring.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ChatRoomService {
	private final ChatRoomRepository chatRoomRepository;
}
