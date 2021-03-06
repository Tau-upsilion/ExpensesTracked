package com.example.ExpensesTracked_Backend;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
	
	/**
	 * method to successfully login in a user 
	 * @param token
	 * @return "Login Successful! " + token
	 */
	@GetMapping("/user/users")
	public String loginSucess(@RequestHeader("authorization") String token) {
		return "Login Successful! " + token;
	}
	
	/**
	 * Method to find a user by their email
	 * @param email
	 * @return userService.getUserByemail(email)
	 */
	@RequestMapping(value ="/user/email", method = RequestMethod.POST)
	public User findByEmail(@RequestBody String email) {
		return userService.getUserByemail(email);
	}
	/**
	 * Method to update user
	 * @param user
	 * @return userService.save(user)
	 */
	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public User updateUser(@RequestBody User user) {
		return userService.save(user);
	}
	/**
	 * Method to find all expenses related to a certain token 
	 * @param token
	 * @return all expenses from a token
	 */
	@SuppressWarnings("unchecked")
	@GetMapping(path="/expenses/all")
	public @ResponseBody JSONObject getAllExpenses(@RequestHeader("authorization") String token){
		String tk = token.substring(7);
		User user = userService.findBytoken(tk);
		int userId = user.getId();
		ArrayList<Expenses> list = (ArrayList<Expenses>) expenseRepository.findAllByuserId(userId);
		JSONArray arr = new JSONArray();
		for(Expenses e: list) {
			JSONObject n = new JSONObject();
			n.put("name", e.getExpensesName());
			n.put("description",e.getDescription());
			n.put("amount", e.getAmount());
			arr.add(n);
		}
		JSONObject result = new JSONObject();
		result.put("expenses", arr);
		return result;
	}
	
	/**
	 * Method to add a new expensed related to a certain token 
	 * @param token
	 * @param n
	 * @return "saved"
	 */
	@PostMapping(path="/expenses/add")
	public @ResponseBody Expenses addNewExpense(@RequestBody Expenses n) {
		Expenses result = new Expenses();
		if(n.getAmount() == null | n.getCategory() == null | n.getExpensesName() == null | n.getToken() == null) {
			result.setError(true);
			result.setError_msg("One or more fields is empty");
			return result;
		}
		User user = userService.findBytoken(n.getToken());
		n.setUserID(user.getId());
		expenseRepository.save(n);
		result.setError(false);
		return result;
	}
	
	/**
	 * returns an array list of all expenses from a certain user 
	 * @param id
	 * @return l
	 */
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
	
	/**
	 * Method that returns every category in the category repository 
	 * @return categoryRepository.findAll()
	 */
	@GetMapping(path="/category/all")
	public @ResponseBody Iterable<Category> getAllCategory(){
		return categoryRepository.findAll();
	}
	
	/**
	 * method that adds a new category to the category repository
	 * @param n
	 * @return "saved"
	 */
	@PostMapping(path="/category/add")
	public @ResponseBody String addNewCategory(@RequestHeader("authorization") String token, @RequestBody Category n) {
		categoryRepository.save(n);
		return "Saved";
	}
	@GetMapping(path="/category/{id}")
	Category getCategory(@PathVariable int id) {
		return categoryRepository.findByid(id);
	}
}
