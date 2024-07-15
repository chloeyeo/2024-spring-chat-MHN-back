package com.study.spring.api.response;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberView {
	private Long id;
	private String email;
	private String password;
	private String nickName;
	private String fullName;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
}
