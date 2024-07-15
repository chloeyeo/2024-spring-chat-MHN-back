package com.study.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.spring.model.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

}
