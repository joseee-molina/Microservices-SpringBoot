package com.octavio.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	@Autowired
	private UserDaoService service;
	
	@GetMapping(path="/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public User findOne(@PathVariable int id){
		return service.findOne(id);
	}
	
	@PostMapping(path="/users")
	public void createUser(@RequestBody User user) {
		User savedUser = service.save(user);
	}
	
}
