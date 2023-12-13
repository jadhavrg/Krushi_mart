package com.qsp.krushimart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.krushimart.dao.UserDao;
import com.qsp.krushimart.dto.User;
import com.qsp.krushimart.exception.IdNotFound;
import com.qsp.krushimart.exception.LoginIsNotDone;
import com.qsp.krushimart.util.ResponseStructure;

@Service
public class UserService 
{
	@Autowired
	private UserDao dao ;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user)
	{
		ResponseStructure<User> structure = new ResponseStructure<>() ;
		structure.setMessage("Account is created..!");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveUser(user));
		
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED) ;
	}
	
	public ResponseEntity<ResponseStructure<User>> getUser(int id)
	{
		User dbUser = dao.getUser(id) ;
		ResponseStructure<User> structure = new ResponseStructure<>() ;
		if (dbUser != null) 
		{
			structure.setMessage("User is Found..!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.FOUND) ;
		}
//		return null ;
		throw new IdNotFound("User is not Present..!") ;
	}
	
	public ResponseEntity<ResponseStructure<List<User>>> getAllUser()
	{
		List<User> list = dao.getAllUser() ;
		ResponseStructure<List<User>> structure = new ResponseStructure<>() ;
		if (list.isEmpty()) 
		{
			return null ;
		}
		structure.setMessage("Users are Available..!");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(list);
		return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.FOUND) ;
	}
	
	public ResponseEntity<ResponseStructure<User>> deleteUser(int id) 
	{
		User user = dao.deleteUser(id) ;
		ResponseStructure<User> structure = new ResponseStructure<>() ;
		if (user != null) 
		{
			structure.setMessage("User is deleted..!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK) ;
		}
		return null ;
	}
	
	public ResponseEntity<ResponseStructure<User>> updateUser(int id, User user)
	{
		User dbUser = dao.updateUser(id,user) ;
		ResponseStructure<User> structure = new ResponseStructure<>() ;
		if (dbUser != null) 
		{
			structure.setMessage("User is updated..!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK) ;
		}
		return null ;
	}
	
	public ResponseEntity<ResponseStructure<User>> loginUser(String email, String password) 
	{
		User user = dao.loginUser(email, password) ;
		ResponseStructure<User> structure = new ResponseStructure<>() ;
		if (user != null) 
		{
			structure.setMessage("Login Successfully..!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK) ;
		}
		
		throw new LoginIsNotDone("Invalid Credentials..!") ;
	}
}
