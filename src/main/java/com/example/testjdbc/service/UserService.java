package com.example.testjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testjdbc.IUserService;
import com.example.testjdbc.exception.UserNotFoundException;
import com.example.testjdbc.model.User;
import com.example.testjdbc.repository.IUserRepository;

@Service
public class UserService implements IUserService{
	
	private IUserRepository userRepository;

	@Autowired
	public void setUserRepo(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void addUser(User user) {
		userRepository.addUser(user);
	}

	@Override
	public void updateUser(int uid, User user) {
		userRepository.updateUser(uid, user);
	}

	@Override
	public void deleteUser(int uid) {
		userRepository.deleteUser(uid);
	}

	@Override
	public User getUserById(int uid) throws UserNotFoundException {
		return userRepository.getUserById(uid);
	}

	@Override
	public List<User> getAllUsers() throws UserNotFoundException {
		return userRepository.getAllUsers();
	}

	@Override
	public List<User> getEqualNameUsers(String name) throws UserNotFoundException {
		return userRepository.getEqualNameUsers(name);
	}

}
