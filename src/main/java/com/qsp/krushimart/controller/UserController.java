package com.qsp.krushimart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.krushimart.dto.User;
import com.qsp.krushimart.service.UserService;
import com.qsp.krushimart.util.ResponseStructure;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController 
{
	@Autowired
	private UserService service ;
	HttpSession session ;
	
	@PostMapping("/user")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user)
	{
		return service.saveUser(user) ;
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<ResponseStructure<User>> getUser(@PathVariable int id) 
	{
		return service.getUser(id) ;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<ResponseStructure<List<User>>> getAllUser()
	{
		return service.getAllUser() ;
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<ResponseStructure<User>> deleteUser(@PathVariable int id) 
	{
		return service.deleteUser(id) ;
	}
	
	@PutMapping("/user")
	public ResponseEntity<ResponseStructure<User>> updateUser(@PathVariable int id, @RequestBody User user)
	{
		return service.updateUser(id, user) ;
	}
	
	@GetMapping("/loginUser")
	public ResponseEntity<ResponseStructure<User>> loginUser(@RequestParam String email, @RequestParam String password) 
	{
//		this.session.setAttribute("email", email) ;
//		this.session.setAttribute("password", password) ;
//		System.out.println(session.getAttribute(email));
//		System.out.println(session.getAttribute(password));
//		profile() ;
		return service.loginUser(email, password) ;
	}
	
	public User profile() 
	{
		String email = (String) session.getAttribute("email") ;
		String password = (String) session.getAttribute("password") ;
		return service.profile(email,password) ;
	}
	
	
}
