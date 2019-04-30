package com.example.ExpensesTracked_Backend.service;

import org.springframework.data.repository.CrudRepository;
import com.example.ExpensesTracked_Backend.service.imp.User;
public interface UserRepository extends CrudRepository<User, Integer> {
	/**
	 * gets user by email
	 * @param email
	 */
	public User getUserByemail(String email);
	
	/**
	 * gets user by ID
	 * @param id
	 */
	public User getUserByid(Integer id);
	/**
	 * Finds all users by name
	 * @param name
	 */
	public Iterable<User> findAllByname(String name);
	
	/**
	 * finds all users by email
	 * @param email
	 */
	public Iterable<User> findAllByemail(String email);
	public User findBytoken(String token);
}