package com.example.ExpensesTracked_Backend.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ExpensesTracked_Backend.service.imp.Expenses;
@Repository
public interface ExpensesRepository extends CrudRepository<Expenses, Integer> {
	public Iterable<Expenses> findAllByToken(String token);
}
