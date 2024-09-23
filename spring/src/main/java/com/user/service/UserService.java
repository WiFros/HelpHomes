package com.user.service;

import java.sql.SQLException;
import java.util.List;

import com.user.vo.User;

public interface UserService {
	
	User login(String name, String password) throws SQLException;
	int update(User user) throws SQLException;
	User findById(int id) throws SQLException;
	int register(User user) throws SQLException;
	User findByName(String name) throws SQLException;
	List<User> findAll() throws SQLException;
	int delete(Integer id) throws SQLException;
	User findByEmail(String email) throws SQLException;
}
