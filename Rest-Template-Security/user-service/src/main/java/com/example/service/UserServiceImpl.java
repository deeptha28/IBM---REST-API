package com.example.service;

import java.util.List;	
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.model.UserEntity;
import com.example.repo.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public UserEntity createUser(UserEntity user) {
		// TODO Auto-generated method stub
		user.setUserId(UUID.randomUUID().toString());
		 StringBuilder revPass = new StringBuilder();
	        revPass.append(user.getPassword());
		user.setEncryptedPassword(revPass.reverse().toString());
		return userRepository.save(user);
	}

	@Override
	public List<UserEntity> listUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		UserEntity user = userRepository.findByUserId(userId);
		if (user==null) {
			User tempUser = null;
			return tempUser;
		}
		else {
		User tempUser = new User(user.getUserId(),user.getFirstName(),user.getLastName(),user.getEmail());
		return tempUser;
		}
	}

	@Override
	public User getUserByUserIdAndPassword(String username, String password) {
		UserEntity user = userRepository.findByUserIdAndPassword(username, password);
		if (user==null) {
			User tempUser = null;
			return tempUser;
		}
		else {
		User tempUser = new User(user.getUserId(),user.getFirstName(),user.getLastName(),user.getEmail());
		return tempUser;
		}
	}
}