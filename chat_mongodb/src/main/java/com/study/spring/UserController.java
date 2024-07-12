package com.study.spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserRepository userRepository;
	
	@PostMapping("/user")
	public ResponseEntity<String> createUser(@RequestBody User user) {
		User savedUser = userRepository.save(user);
		return ResponseEntity.ok(savedUser.toString());
	}
}
