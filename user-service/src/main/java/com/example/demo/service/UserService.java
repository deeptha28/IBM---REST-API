package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDto;
import com.example.demo.model.UserEntity;

public interface UserService {
	
	UserEntity createUser(UserDto userDto);
	
	 List<UserEntity> listUsers();
	 UserEntity findByUserId(String userId);

}