package com.example.ExpensesTracked_Backend;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ExpensesTracked_Backend.*;

@RestController    // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;

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
	@SuppressWarnings("unlikely-arg-type")
	@PostMapping(path="/login")
	public Optional<User> register(@RequestBody User n) {
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
		return (Opitional<User>) result;
	}
}