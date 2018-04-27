package com.ziv.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziv.springboot.bean.User;
import com.ziv.springboot.dao.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public List<User> queryUsers(){
		return userMapper.queryUsers();
	}

	public User queryUserByNameAndPwd(String loginname,String password){
		User user = new User();
		user.setLoginname(loginname);
		user.setPassword(password);
		return userMapper.queryUserInfo(user);
	}
	
	public void updateLastLogin(User user){
		userMapper.updateLastLogin(user);
	}
	
	public User getUserAndRoleById(int userID){
		return userMapper.getUserAndRoleById(userID);
	}
	
	public User queryUserByID(String id){
		User user = userMapper.queryUserByID(id);
		return user;
	}
	
	public void editUser(User user){
		userMapper.editUser(user);
	}

	public void resetUserPassword(User user){
		userMapper.resetUserPassword(user);
	}
	
	public void addUser(User user){
		userMapper.addUser(user);
	}
}
