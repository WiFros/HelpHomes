package com.user.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.UserService;
import com.user.vo.User;

import jakarta.servlet.http.HttpSession;

@RestController("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(
			@RequestBody Map<String, String> param,
			HttpSession session) throws SQLException {
		
		User user = userService.login(param.get("name"), param.get("password"));
		
		if(user == null) return ResponseEntity.status(401).body("ID와 password가 일치하지 않습니다.");
		
		session.setAttribute("user", user);
		
		return ResponseEntity.ok("LOGIN SUCCESS!");
	}
	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody User user) throws SQLException {
		userService.update(user);
		return ResponseEntity.ok("UPDATE SUCCESS!");
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") Integer id) throws SQLException {
		return ResponseEntity.ok(userService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<String> register(@RequestBody User user) throws SQLException {
		
		int isRegister = userService.register(user);
		
		if(isRegister == 0) return ResponseEntity.status(400).body("회원가입에 실패하였습니다.");
		
		return ResponseEntity.ok("REGISTER SUCCESS!");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) throws SQLException {
		userService.delete(id);
		return ResponseEntity.ok("DELETE SUCCESS!");
	}
	
	
	// ================ ADMIN ================
	
	@GetMapping
	public ResponseEntity findAll(HttpSession session) throws SQLException {
		User user = (User) session.getAttribute("user");
		if(user == null || !user.getRole().equals("ADMIN")) return ResponseEntity.status(403).body("권한이 없습니다.");
		
		return ResponseEntity.ok(userService.findAll());
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity findByName(
			@PathVariable("name") String name,
			HttpSession session) throws SQLException {
		
		User user = (User) session.getAttribute("user");
		
		if(user == null || !user.getRole().equals("ADMIN")) return ResponseEntity.status(403).body("권한이 없습니다.");
		
		return ResponseEntity.ok(userService.findByName(name));
	}	

}
