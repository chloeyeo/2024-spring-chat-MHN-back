package com.study.spring.service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.study.spring.api.request.CreateAndEditMemberRequest;
import com.study.spring.api.response.MemberView;
import com.study.spring.model.MemberEntity;
import com.study.spring.repository.MemberRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {
	private final MemberRepository memberRepository;
	
	@Transactional
	public MemberEntity createMember(CreateAndEditMemberRequest request) {
//		MemberEntity member = new MemberEntity(request.getEmail(), ...);
		MemberEntity member = MemberEntity.builder()
				.email(request.getEmail())
				.fullName(request.getFullName())
				.nickName(request.getNickName())
				.password(request.getPassword())
				.createdAt(ZonedDateTime.now())
				.updatedAt(ZonedDateTime.now())
				.build();
		memberRepository.save(member);
		return member;
	}
	
	@Transactional
	public void editMember(Long memberId, CreateAndEditMemberRequest request) {
		MemberEntity member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("member does not exist"));
		member.changeFullName(request.getFullName());
		member.changeNickName(request.getNickName());
		member.changePassword(request.getPassword());
		member.changeUpdatedAt(ZonedDateTime.now());
		memberRepository.save(member);
	}
	
	public void deleteMember(Long memberId) {
		MemberEntity member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("member does not exist"));
		memberRepository.delete(member);
	}
	
	public List<MemberView> getAllMembers() {
		List<MemberEntity> members = memberRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
		return members.stream().map(member -> MemberView.builder()
				.id(member.getId()).email(member.getEmail())
				.fullName(member.getFullName()).nickName(member.getNickName())
				.password(member.getPassword()).createdAt(member.getCreatedAt())
				.updatedAt(member.getUpdatedAt())
				.build()).collect(Collectors.toList());
	}
	
	public MemberView getMember(Long memberId) {
		MemberEntity member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("member does not exist"));
		return MemberView.builder()
				.id(member.getId()).email(member.getEmail())
				.fullName(member.getFullName()).nickName(member.getNickName())
				.password(member.getPassword()).createdAt(member.getCreatedAt())
				.updatedAt(member.getUpdatedAt())
				.build();
	}
}
