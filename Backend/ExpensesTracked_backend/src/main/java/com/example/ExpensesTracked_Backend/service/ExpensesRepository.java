package com.example.ExpensesTracked_Backend.service;

import org.springframework.data.repository.CrudRepository;

import com.example.ExpensesTracked_Backend.service.imp.Expenses;

public interface ExpensesRepository extends CrudRepository<Expenses, Integer> {
	public Iterable<Expenses> findAllByToken(String token);
}
