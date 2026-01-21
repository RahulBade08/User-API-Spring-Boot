package com.userManagementSystem.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.userManagementSystem.dto.UserRequest;
import com.userManagementSystem.dto.UserResponse;
import com.userManagementSystem.entity.User;
import com.userManagementSystem.exception.UserNotFoundException;
import com.userManagementSystem.repository.UserRepository;
import com.userManagementSystem.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository=userRepository;
	}

	@Override
	public UserResponse createUser(UserRequest request) {
		// TODO Auto-generated method stub
		
		// DTO → Entity
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        // save to DB
        User savedUser = userRepository.save(user);

        // Entity → DTO
        UserResponse response = new UserResponse();
        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());

        return response;
	}

	@Override
	public List<UserResponse> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = userRepository.findAll();
		List<UserResponse> responseList = new ArrayList<>();

		for (User user : users) {
            UserResponse response = new UserResponse();
            response.setId(user.getId());
            response.setName(user.getName());
            response.setEmail(user.getEmail());
            responseList.add(response);
        }

        return responseList;
	}

	@Override
	public User getUserByID(Long id) {
		
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
	}

	@Override
	public void deleteUserID(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

}

