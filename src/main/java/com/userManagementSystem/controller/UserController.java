package com.userManagementSystem.controller;
import java.util.List;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userManagementSystem.dto.UserRequest;
import com.userManagementSystem.dto.UserResponse;
import com.userManagementSystem.entity.User;
import com.userManagementSystem.service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
	}
	@GetMapping("/test")
	public String test() {
	    return "OK";
	}

	@PostMapping
	public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest request) {
	    System.out.println("CONTROLLER HIT");
	    UserResponse response = userService.createUser(request);
	    return ResponseEntity.status(201).body(response);
	}

	@GetMapping
	public ResponseEntity<List<UserResponse>> getAllUsers() {
	    return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserByID(@PathVariable Long id){
		User response = userService.getUserByID(id);
		
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUserByID(@PathVariable Long id) {
		userService.deleteUserID(id);
		return ResponseEntity.noContent().build();
	}
}

