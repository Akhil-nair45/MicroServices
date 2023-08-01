package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.User;

public interface UserService {

	public User saveUser(User user);
	
	public User editUser(User use);
	
	public List<User> getAllUser();
	
	public String deleteUser(String userId);
	
	public User findById(String userId);
}
