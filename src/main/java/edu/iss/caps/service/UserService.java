package edu.iss.caps.service;

import java.util.ArrayList;

import edu.iss.caps.model.User;

public interface UserService {

	ArrayList<User> findAllUsers();
	
	User findOneById(int id);
	
	User authenticate(String uname, String pwd);
	
	User createUser(User user);
	
	User changeUser(User user);
	
	void removeUser(User user);

}