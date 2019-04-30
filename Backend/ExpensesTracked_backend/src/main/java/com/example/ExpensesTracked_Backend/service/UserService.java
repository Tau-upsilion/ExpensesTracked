package com.example.ExpensesTracked_Backend.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ExpensesTracked_Backend.service.imp.User;

@Service
public class UserService{
	@Autowired
	private UserRepository repo;
	
	/**
	 * finds user by ID
	 * @param id
	 * @return repo.getUserByid(id)
	 */
	public User getUserByID(int id) {
		return repo.getUserByid(id);
	}
	
	/**
	 * finds user by Email
	 * @param email
	 * @return repo.getUserByemail(email)
	 */
	public User getUserByEmail(String email) {
		return repo.getUserByemail(email);
	}
	
	/**
	 * finds all users by name
	 * @param name
	 * @return repo.findAllByname(name)
	 */
	public Iterable<User> findAllByName(String name){
		return repo.findAllByname(name);
	}
	public User findBytoken(String token) {
		return repo.findBytoken(token);
	}
}
