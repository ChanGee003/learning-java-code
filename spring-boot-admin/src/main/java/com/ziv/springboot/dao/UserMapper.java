package com.ziv.springboot.dao;

import java.util.List;

import com.ziv.springboot.bean.User;

public interface UserMapper {

	public List<User> queryUsers();
	
	public User queryUserInfo(User user);

	public void updateLastLogin(User user);
	
	public User getUserAndRoleById(int userID);
	
	public User queryUserByID(String id);
	
	public void addUser(User user);
	
	public void editUser(User user);

	public void resetUserPassword(User user);
}
