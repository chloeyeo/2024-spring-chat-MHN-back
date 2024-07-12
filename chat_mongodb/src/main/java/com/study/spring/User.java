package com.study.spring;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	private String email;
	private String password;
	private String nickName;
	private String fullName;
	private Status status;
	private Role role;

}
