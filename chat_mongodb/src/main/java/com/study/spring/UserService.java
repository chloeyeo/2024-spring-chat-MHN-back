package com.study.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public void saveUser(User user) {
		repository.save(user);
	}
	
	public User getUser(String email) {
		return repository.findById(email).orElse(null);
	}
	
	public List<User> getAllUsers() {
		return repository.findAll();
	}
	public void deleteUser(String email) {
		repository.deleteById(email);
	}
}
