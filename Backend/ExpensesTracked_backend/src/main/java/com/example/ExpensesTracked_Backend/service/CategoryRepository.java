package com.example.ExpensesTracked_Backend.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ExpensesTracked_Backend.service.imp.Category;
@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
	public Iterable<Category> findAllByID(int ID);
	
	public Iterable<Category> findAllByName(String categoryName);
}
