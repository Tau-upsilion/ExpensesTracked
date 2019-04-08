package com.example.ExpensesTracked_Backend.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ExpensesTracked_Backend.service.imp.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	public User getUserByemail(String email);
	public User getUserByid(Integer id);
}