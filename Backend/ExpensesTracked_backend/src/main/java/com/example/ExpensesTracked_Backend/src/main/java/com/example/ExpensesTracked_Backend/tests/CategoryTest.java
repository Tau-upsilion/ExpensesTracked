package com.example.ExpensesTracked_Backend.tests;
import com.example.ExpensesTracked_Backend.service.imp.Category;
import com.example.ExpensesTracked_Backend.service.CategoryRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class CategoryTest {
	@Mock
	CategoryRepository catRepo;
	
	@InjectMocks
	Category cat;
	
}
