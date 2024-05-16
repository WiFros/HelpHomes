package com.user.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.mapper.UserMapper;
import com.user.vo.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper mapper;

	@Override
	public User login(String name, String password) throws SQLException {
		return mapper.login(name, password);
	}

	@Override
	public int update(User user) throws SQLException {
		return mapper.update(user);
	}

	@Override
	public User findById(int id) throws SQLException {
		return mapper.findById(id);
	}

	@Override
	public int register(User user) throws SQLException {
		return mapper.register(user);
	}

	@Override
	public User findByName(String name) throws SQLException {
		return mapper.findByName(name);
	}
	
	// ================ ADMIN ================
	
	@Override
	public List<User> findAll() throws SQLException {
		return mapper.findAll();
	}

	@Override
	public int delete(Integer id) throws SQLException {
		return mapper.delete(id);
	}

}
