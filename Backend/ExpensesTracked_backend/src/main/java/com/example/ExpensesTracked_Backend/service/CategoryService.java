package com.example.ExpensesTracked_Backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ExpensesTracked_Backend.service.CategoryRepository;
import com.example.ExpensesTracked_Backend.service.imp.Category;


import java.util.List;

@Service
public class CategoryService
{
	@Autowired
	private CategoryRepository repo;
	
	public List<Category> getCategoryByID(int ID) {
		return (List<Category>) repo.findAllByid(ID);
	}
	
	public List<Category> getCategoryByName(String categoryName) {
		return (List<Category>) repo.findAllBycategoryName(categoryName);
	}
	public Category findByid(int id) {
		return repo.findByid(id);
	}
}
