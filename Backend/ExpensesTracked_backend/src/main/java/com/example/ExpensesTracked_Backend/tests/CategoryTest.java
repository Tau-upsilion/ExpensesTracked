package com.example.ExpensesTracked_Backend.tests;

import com.example.ExpensesTracked_Backend.service.imp.Category;
import com.example.ExpensesTracked_Backend.service.CategoryRepository;
import com.example.ExpensesTracked_Backend.service.CategoryService;


import org.junit.After;
import org.junit.Before;
import org.junit.Assert;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(MockitoJUnitRunner.class)
public class CategoryTest {
	
	@Mock
	CategoryRepository repo;
	
	@Before
	public void before() 
	{
		System.out.println("Before");
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
		
		when(repo.findAllByID(1)).thenReturn(c);
		
		
		//List<Category> testList =  catserv.getCategoryByID(1);
		//Assert.assertEquals(c, testList);
		
	}
	
}
