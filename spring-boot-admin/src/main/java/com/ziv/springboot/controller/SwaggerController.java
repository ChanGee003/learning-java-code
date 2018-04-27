package com.ziv.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.ApiOperation;
import com.ziv.springboot.bean.User;

@RestController
@RequestMapping("/users")
public class SwaggerController {

	@ApiOperation(value="Get all users",notes="requires noting")
	@RequestMapping(method=RequestMethod.GET)
	public List<User> getUsers(){
		List<User> users = new ArrayList<User>();
		User user1 = new User();
		user1.setUsername("springboot1");
		User user2 = new User();
		user2.setUsername("springboot2");
		users.add(user1);
		users.add(user2);
		return users;
	}
	
	@ApiOperation(value="Get user With id",notes="requires the id of user")
	@RequestMapping(path="/{id}",method=RequestMethod.GET)
	public User getUserById(@PathVariable Integer id){
		User user = new User();
		user.setUsername("userName");
		user.setPassword("352131");
		return user;
	}
}
