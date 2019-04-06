package com.example.ExpensesTracked_Backend.tests;

import com.example.ExpensesTracked_Backend.service.imp.User;
import com.example.ExpensesTracked_Backend.service.UserRepository;
import com.example.ExpensesTracked_Backend.service.UserService;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.Test;

import com.example.ExpensesTracked_Backend.service.imp.User;


public class UserTest {
	
	@InjectMocks
	UserService userserv;
	@Mock
	UserRepository repo;
	
	@Before
	public void before() {
		System.out.println("Before");
		MockitoAnnotations.initMocks(this);
	}
	@After
	public void after() {
		System.out.println("After");
	}
	@Test
	public void getUserByIdTest() {
		when(repo.getUserByID(1)).thenReturn(new User(1,"TestUser", "TestUser@test.com","password",18,"male"));
		
		User user = userserv.getUserByID(1);
		
		assertEquals("TestUser", user.getName());
		assertEquals("TestUser@test.com",user.getEmail());
		assertEquals("password",user.getPassword());
		assertEquals((Integer)18,user.getAge());
	}

}
