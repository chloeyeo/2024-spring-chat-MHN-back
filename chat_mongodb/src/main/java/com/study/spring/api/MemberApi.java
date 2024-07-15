package com.study.spring.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.api.request.CreateAndEditMemberRequest;
import com.study.spring.api.response.MemberView;
import com.study.spring.model.MemberEntity;
import com.study.spring.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MemberApi {
	private final MemberService memberService;
	
	@CrossOrigin
	@GetMapping("/members")
	public List<MemberView> getMembers() {
		return memberService.getAllMembers();
	}
	
	@GetMapping("/member/{memberId}")
	public MemberView getMember(@PathVariable("memberId") Long memberId) {
		return memberService.getMember(memberId);
	}
	
	@PostMapping("/member")
	public MemberEntity createMember(@RequestBody CreateAndEditMemberRequest request) {
		return memberService.createMember(request);
	}
	
	@PutMapping("/member/{memberId}")
	public void editMember(@PathVariable("memberId") Long memberId, @RequestBody CreateAndEditMemberRequest request) {
		memberService.editMember(memberId, request);
	}
	
	@DeleteMapping("/member/{memberId}")
	public void deleteMember(@PathVariable("memberId") Long memberId) {
		memberService.deleteMember(memberId);
	}
}
