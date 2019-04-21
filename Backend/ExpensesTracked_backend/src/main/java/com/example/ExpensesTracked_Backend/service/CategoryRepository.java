package com.example.ExpensesTracked_Backend.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ExpensesTracked_Backend.service.imp.Category;
@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
	public Iterable<Category> findAllByid(int ID);
	
	public Iterable<Category> findAllBycategoryName(String categoryName);
	
	public Category findByid(int id);
}
