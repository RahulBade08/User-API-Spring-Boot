package com.userManagementSystem.service;
import java.util.List;

import com.userManagementSystem.dto.UserRequest;
import com.userManagementSystem.dto.UserResponse;
import com.userManagementSystem.entity.User;


public interface UserService {

	UserResponse createUser(UserRequest request);
	
	List<UserResponse> getAllUsers();
	
	User getUserByID(Long id);
	
	void deleteUserID(Long id);
	
}
