package com.example.testjdbc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.testjdbc.exception.UserNotFoundException;
import com.example.testjdbc.model.User;

@Repository
public class UserRepository implements IUserRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void addUser(User user) {
		String inserUserQuery = "insert into user values(?,?,?,?)";
		Object[] property = {user.getUid(),user.getName(),user.getEmail(),user.getPassword()};
		jdbcTemplate.update(inserUserQuery, property);
	}

	@Override
	public void updateUser(int uid, User user) {
		String updateUserQuery = "update user set name=? where uid=?";
		Object[] propertyArrya = {user.getName(),uid};
		jdbcTemplate.update(updateUserQuery, propertyArrya);
//		or
//		jdbcTemplate.update(updateUserQuery,user.getName(),uid );
	}

	@Override
	public void deleteUser(int uid) {
		String deleteUserQuery = "delete from user where uid=?";
		jdbcTemplate.update(deleteUserQuery,uid);
	}

	@Override
	public User getUserById(int uid) throws UserNotFoundException {
		String query = String.format("SELECT * FROM user WHERE uid = %d", uid);
		return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(User.class));
	}

	@Override
	public List<User> getAllUsers() throws UserNotFoundException {
	    String query = "SELECT * FROM user";
	    List<User> users = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(User.class));
	    return users;
	}

	@Override
	public List<User> getEqualNameUsers(String name) throws UserNotFoundException {
	    String query = String.format("SELECT * FROM user WHERE name LIKE '%%%s%%'", name);
	    List<User> users = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(User.class));
	    return users;
	}

}
