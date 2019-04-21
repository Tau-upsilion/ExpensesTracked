package com.example.ExpensesTracked_Backend;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ExpensesTracked_Backend.service.imp.Category;
import com.example.ExpensesTracked_Backend.service.imp.Expenses;
import com.example.ExpensesTracked_Backend.service.imp.User;
import com.example.ExpensesTracked_Backend.service.CategoryRepository;
import com.example.ExpensesTracked_Backend.service.ExpensesRepository;
import com.example.ExpensesTracked_Backend.service.UserRepository;


@RestController
@RequestMapping("/secure")
public class SecureController {
	@Autowired
	private ExpensesRepository expenseRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private UserRepository userService;
	
	@GetMapping("/user/users")
	public String loginSucess(@RequestHeader("authorization") String token) {
		return "Login Successful! " + token;
	}
	
	@RequestMapping(value ="/user/email", method = RequestMethod.POST)
	public User findByEmail(@RequestBody String email) {
		return userService.getUserByemail(email);
	}
	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public User updateUser(@RequestBody User user) {
		return userService.save(user);
	}
	@GetMapping(path="/expenses/all")
	public @ResponseBody Iterable<Expenses> getAllExpenses(@RequestHeader("authorization") String token){
		String tk = token.substring(7);
		return expenseRepository.findAllByToken(tk);
	}
	@PostMapping(path="/expenses/add")
	public @ResponseBody String addNewExpense(@RequestHeader("authorization")String token, @RequestBody Expenses n) {
		String tk = token.substring(7);
		n.setToken(tk);
		expenseRepository.save(n);
		return "Saved";
	}
	@GetMapping(path="/expenses/{id}")
	Expenses getExpense(@PathVariable int id) {
		return expenseRepository.findByid(id);
	}
	@GetMapping(path="/expenses/user/{id}")
	public @ResponseBody Iterable<Expenses> getAllExpensesByUser(@PathVariable int id){
		ArrayList<Expenses> l = new ArrayList<Expenses>();
		for(int i = 0; i < expenseRepository.count(); i++) {
			if(expenseRepository.findById(i).get().getUserID() == id) {
				l.add(expenseRepository.findByid(id));
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
	Category getCategory(@PathVariable int id) {
		return categoryRepository.findByid(id);
	}
}
