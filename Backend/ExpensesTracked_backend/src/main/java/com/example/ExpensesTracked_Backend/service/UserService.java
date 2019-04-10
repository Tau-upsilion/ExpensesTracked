package com.example.ExpensesTracked_Backend.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ExpensesTracked_Backend.service.imp.User;

@Service
public class UserService{
	@Autowired
	private UserRepository repo;
	
	public User getUserByID(int id) {
		return repo.getUserByID(id);
	}
	public User getUserByEmail(String email) {
		return repo.getUserByEmail(email);
	}
	public Iterable<User> findAllByName(String name){
		return repo.findAllByname(name);
	}
}
