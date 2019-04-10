package com.example.ExpensesTracked_Backend.service;

import org.springframework.data.repository.CrudRepository;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;

import com.example.ExpensesTracked_Backend.service.imp.Expenses;
=======
>>>>>>> 11-backend-mockito
import com.example.ExpensesTracked_Backend.service.imp.User;
public interface UserRepository extends CrudRepository<User, Integer> {
<<<<<<< HEAD
	public User getUserByemail(String email);
	public User getUserByid(Integer id);
	public Iterable<User> findAllByname(String name);
	public Iterable<User> findAllByemail(String email);
=======
	public User getUserByEmail(String email);
	public User getUserByID(Integer id);
>>>>>>> 11-backend-mockito
}