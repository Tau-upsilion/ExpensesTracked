package com.example.ExpensesTracked_Backend.service;

import org.springframework.data.repository.CrudRepository;
import com.example.ExpensesTracked_Backend.service.imp.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
	//public Iterable<Category> findAllBy(String token);
}
