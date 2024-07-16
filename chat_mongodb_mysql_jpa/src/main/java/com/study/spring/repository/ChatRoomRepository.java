package com.study.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.spring.model.ChatRoomEntity;

public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, Long> {

}
