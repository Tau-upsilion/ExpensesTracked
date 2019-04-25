package com.example.ExpensesTracked_Backend.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ExpensesTracked_Backend.service.imp.Category;
@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
	/**
	 * Finds all Category based on ID
	 * @param ID
	 */
	public Iterable<Category> findAllByid(int ID);
	
	/**
	 * Finds all categories based on category name
	 * @param categoryName
	 */
	public Iterable<Category> findAllBycategoryName(String categoryName);
	
	/**
	 * finds all categories based on id
	 * @param id
	 */
	public Category findByid(int id);
}
