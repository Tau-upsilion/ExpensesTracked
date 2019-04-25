package com.example.ExpensesTracked_Backend.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ExpensesTracked_Backend.service.imp.Expenses;
@Repository
public interface ExpensesRepository extends CrudRepository<Expenses, Integer> {
	/**
	 * finds expenses by token 
	 * @param token
	 */
	public Iterable<Expenses> findAllByToken(String token);
	
	/**
	 * finds expenses by ID
	 * @param id
	 */
	public Iterable<Expenses> findAllByid(int id);

	/**
	 * finds expenses by description
	 * @param Description
	 */
	public Iterable<Expenses> findAllByDescription(String Description);
	
	/**
	 * finds expenses by ID
	 * @param id
	 */
	public Expenses findByid(int id);
}
