package com.example.testjdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.testjdbc.model.User;
import com.example.testjdbc.service.UserService;

@SpringBootApplication
public class TestJdbcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TestJdbcApplication.class, args);
	}

	private IUserService usrService;
	
	@Autowired
	public void setUserService(IUserService userService) {
		this.usrService = userService;
	}
	
	@Override
	public void run(String... args) throws Exception {

//		add user
		try {
			User user = new User("testnafdsfmefsdf","stemffailff","testpafssswordfdsf",3);
			usrService.addUser(user);
			System.out.println("user is added");
		}catch(Exception e) {
			System.out.println("user is not added");
			System.out.println(e);
		}

//		update user
		try {
			User user = new User("testnameupdated","stemail","testpassword",1);
			usrService.updateUser(1, user);
			System.out.println("user is updated");
		}catch(Exception e) {
			System.out.println("user is not updated");
			System.out.println(e);
		}

//		delete user
		try {
			usrService.deleteUser(1);
			System.out.println("user is deleted");
		}catch(Exception e) {
			System.out.println("user is not deleted");
			System.out.println(e);
		}
		
//		view all users
		try {
			List<User> users = usrService.getAllUsers();
			
	        if (users != null) {
	            System.out.println("All Users:");
	            for (User user : users) {
	                System.out.println(user);
	            }
	        } else {
	            System.out.println("No users found.");
	        }
			System.out.println("all users");
		}catch(Exception e) {
			System.out.println("users are not in DB");
			System.out.println(e);
		}

//	view a user with and Id
		try {
		User user = usrService.getUserById(2);
        if (user != null) {
        		System.out.println("user is in DB");
        		System.out.println(user);
            }
		}catch(Exception e) {
			System.out.println("users are not in DB");
			System.out.println(e);
		}
		
//	view a user with name like 
		try {
		List<User> users = usrService.getEqualNameUsers("fm");
        if (users != null) {
        		System.out.println("user is in DB");
	            for (User user : users) {
	                System.out.println(user);
	            }
            }
		}catch(Exception e) {
			System.out.println("users are not in DB");
			System.out.println(e);
		}
	
	}
}
