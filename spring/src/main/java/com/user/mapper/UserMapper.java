package com.user.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.user.vo.User;

@Mapper
public interface UserMapper {

	User login(String name, String password) throws SQLException;
	int update(User user) throws SQLException;
	User findById(int id) throws SQLException;
	
	int register(User user) throws SQLException;
	
	User findByName(String name) throws SQLException;
	List<User> findAll() throws SQLException;
	int delete(Integer id) throws SQLException;
	User findByEmail(String email) throws SQLException;
}
