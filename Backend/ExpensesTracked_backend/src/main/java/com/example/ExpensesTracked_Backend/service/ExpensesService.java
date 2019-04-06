package com.example.ExpensesTracked_Backend.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ExpensesTracked_Backend.service.ExpensesRepository;
import com.example.ExpensesTracked_Backend.service.imp.Expenses;

import java.util.List;

@Service
public class ExpensesService {
	@Autowired
	private ExpensesRepository repo;
	
	public List<Expenses> getExpensesByToken(String token) {
		return (List<Expenses>) repo.findAllByToken(token);
	}
}
