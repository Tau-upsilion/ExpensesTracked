package com.example.ExpensesTracked_Backend;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController    // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;
	@Autowired
	private ExpensesRepository expenseRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@PostMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestBody User n) {
		userRepository.save(n);
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
	@GetMapping("/users/{id}")
	User one(@PathVariable Integer id) {
		return userRepository.findById(id)
				.orElseThrow();
	}
	@PostMapping(path="/login")
	public User register(@RequestBody User n) {
		User result = null;
		for(int i = 0; i < userRepository.count(); i++) {
			String givenEmail = n.getEmail();
			String givenPassword = n.getPassword();
			String email = userRepository.findById(i).get().getEmail();
			String password = userRepository.findById(i).get().getPassword();
			if(givenEmail == email && givenPassword == password) {
				result = userRepository.findById(i).get();
				break;
			}
		}
		return result;
	}
	@GetMapping(path="/expenses/all")
	public @ResponseBody Iterable<Expenses> getAllExpenses(){
		return expenseRepository.findAll();
	}
	@PostMapping(path="/expenses/add")
	public @ResponseBody String addNewExpense(@RequestBody Expenses n) {
		expenseRepository.save(n);
		return "Saved";
	}
	@GetMapping(path="/expenses/{id}")
	Expenses getExpense(@PathVariable int id) {
		return expenseRepository.findById(id).orElseThrow();
	}
	@GetMapping(path="/expenses/user/{id}")
	public @ResponseBody Iterable<Expenses> getAllExpensesByUser(@PathVariable int id){
		ArrayList<Expenses> l = new ArrayList<Expenses>();
		for(int i = 0; i < expenseRepository.count(); i++) {
			if(expenseRepository.findById(i).get().getUserID() == id) {
				l.add(expenseRepository.findById(i).orElseThrow());
			}
		}
		return l;
	}
	
	@GetMapping(path="/category/all")
	public @ResponseBody Iterable<Category> getAllCategory(){
		return categoryRepository.findAll();
	}
	
	@PostMapping(path="/category/add")
	public @ResponseBody String addNewCategory(@RequestBody Category n) {
		categoryRepository.save(n);
		return "Saved";
	}
	@GetMapping(path="/category/{id}")
	Expenses getCategory(@PathVariable int id) {
		return categoryRepository.findById(id);
	}


}