package com.example.demo.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.UserEntity;
import com.example.demo.repo.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final ModelMapper modelMapper;

	@Override
	public UserEntity createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
		StringBuffer sb = new StringBuffer();
		sb.append(userDto.getPassword());
		userEntity.setEncryptedPassword(sb.reverse().toString());
		return userRepository.save(userEntity);
	}

	@Override
	public List<UserEntity> listUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public UserEntity findByUserId(String userId) {
		// TODO Auto-generated method stub
		return userRepository.findByUserId(userId);
	}

}