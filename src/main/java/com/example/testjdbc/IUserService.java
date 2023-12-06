package com.example.testjdbc;

import java.util.List;

import com.example.testjdbc.exception.UserNotFoundException;
import com.example.testjdbc.model.User;

public interface IUserService {

	void addUser(User user);
	void updateUser(int uid,User user);
	void deleteUser(int uid);
	User getUserById(int uid)throws UserNotFoundException;
	
	List<User> getAllUsers()throws UserNotFoundException;
	List<User> getEqualNameUsers(String ename)throws UserNotFoundException;
	
}
