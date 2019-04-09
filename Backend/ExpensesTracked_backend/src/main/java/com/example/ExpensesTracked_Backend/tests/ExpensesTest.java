package com.example.ExpensesTracked_Backend.tests;
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

import com.example.ExpensesTracked_Backend.service.ExpensesRepository;
import com.example.ExpensesTracked_Backend.service.ExpensesService;
import com.example.ExpensesTracked_Backend.service.imp.Category;
import com.example.ExpensesTracked_Backend.service.imp.Expenses;


public class ExpensesTest {
	@InjectMocks
	ExpensesService expenseserv;
	@Mock
	ExpensesRepository repo;
	
	@Before
	public void before() {
		System.out.println("Before");
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getExpensesByToken() {
		Expenses expen1 = new Expenses(1,"random desc","random cat", "name1",1,100,"RANDOMTOKEN");
		Expenses expen2 = new Expenses(1,"random desc","random cat1", "name2",1,101,"RANDOMTOKEN");
		Expenses expen3 = new Expenses(1,"random desc","random cat2", "name3",1,102,"RANDOMTOKEN");
		Expenses expen4 = new Expenses(1,"random desc","random cat3", "name4",1,103,"RANDOMTOKEN");
		List<Expenses> l = new ArrayList<Expenses>();
		l.add(expen1);
		l.add(expen2);
		l.add(expen3);
		l.add(expen3);
		l.add(expen4);
		when(repo.findAllByToken("RANDOMTOKEN")).thenReturn(l);
		
		List<Expenses> testL =  expenseserv.getExpensesByToken("RANDOMTOKEN");
		Assert.assertEquals(l, testL);
		
	}

	// Integer id, String description, String category, String expensesName, int userId, int amount, String token)
	@Test
	public void getExpenseByIDTest()
	{
		Expenses exp1 = new Expenses(1,"desc1", "cat1", "expname1", 1, 10, "token");
		Expenses exp2 = new Expenses(1,"desc2", "cat2", "expname2", 1, 11, "token");
		Expenses exp3 = new Expenses(1,"desc3", "cat3", "expname3", 1, 12, "token");

		List<Expenses> e = new ArrayList<Expenses>();
		e.add(exp1);
		e.add(exp2);
		e.add(exp3);
		
		when(repo.findAllByID(1)).thenReturn(e);
		
		
		List<Expenses> testList =  expenseserv.getExpensesByID(1);
		Assert.assertEquals(e, testList);
		
	}
}
