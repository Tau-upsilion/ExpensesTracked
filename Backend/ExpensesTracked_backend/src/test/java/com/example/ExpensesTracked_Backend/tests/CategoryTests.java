package com.example.ExpensesTracked_Backend.tests;

//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.ExpensesTracked_Backend.service.imp.Category;
import com.example.ExpensesTracked_Backend.service.CategoryRepository;
import com.example.ExpensesTracked_Backend.service.CategoryService;


public class CategoryTests
{
	@InjectMocks
	CategoryService catService;
	
	@Mock
	CategoryRepository repo;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@After
	public void after()
	{
		System.out.println("After");
	}
	
	@Test
	public void getCategoryByIDTest()
	{
		Category cat1 = new Category(1,"category1");
		Category cat2 = new Category(1,"category2");
		Category cat3 = new Category(1,"category3");

		List<Category> c = new ArrayList<Category>();
		c.add(cat1);
		c.add(cat2);
		c.add(cat3);
		
		when(repo.findAllByid(1)).thenReturn(c);
		
		
		List<Category> testList =  catService.getCategoryByID(1);
		Assert.assertEquals(c, testList);
		
	}
	
	@Test
	public void getCategoryByNameTest()
	{
		Category cat1 = new Category(1,"category1");
		Category cat2 = new Category(2,"category1");
		Category cat3 = new Category(3,"category1");

		List<Category> c = new ArrayList<Category>();
		c.add(cat1);
		c.add(cat2);
		c.add(cat3);
		
		when(repo.findAllBycategoryName("category1")).thenReturn(c);
		
		
		List<Category> testList =  catService.getCategoryByName("category1");
		Assert.assertEquals(c, testList);
	}
	
}