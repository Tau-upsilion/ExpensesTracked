package com.example.ExpensesTracked_Backend.service;

import org.springframework.data.repository.CrudRepository;
import com.example.ExpensesTracked_Backend.service.imp.User;
public interface UserRepository extends CrudRepository<User, Integer> {
	public User getUserByEmail(String email);
	public User getUserByID(Integer id);
}