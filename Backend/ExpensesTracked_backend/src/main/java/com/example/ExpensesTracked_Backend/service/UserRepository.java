package com.example.ExpensesTracked_Backend.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ExpensesTracked_Backend.service.imp.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
<<<<<<< Updated upstream
	public User getUserByemail(String email);
	public User getUserByid(Integer id);
=======
	public User getUserByEmail(String email);
	public User getUserByID(int id);
>>>>>>> Stashed changes
}