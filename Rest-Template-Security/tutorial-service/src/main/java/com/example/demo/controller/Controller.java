package com.example.demo.controller;


import org.springframework.http.HttpStatus;	
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.UserEntity;
import com.example.demo.ui.Login;
import com.example.demo.ui.UserDto;

@RestController
@RequestMapping("/tutorials")
public class Controller {
private final RestTemplate restTemplate;
	

	public Controller(RestTemplate restTemplate) {
	super();
	this.restTemplate = restTemplate;
}
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody UserEntity user){
		UserDto resp =  restTemplate.postForObject("http://localhost:9998/users", user, UserDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(resp);
		
	}

	@GetMapping("/{userId}")
	public UserDto getUserId(@PathVariable String userId) throws UserNotFoundException {
		
		Object user = restTemplate.getForObject("http://localhost:9998/users/"+userId,UserDto.class);
		if (user==null) throw new UserNotFoundException("User "+ userId +"is not in records.");
		UserDto dto = (UserDto) user;
		return dto;
}
	@PostMapping("/login")
	public ResponseEntity<?> createUser(@RequestBody Login loginDetails){
		Login resp =  restTemplate.postForObject("http://localhost:9998/users/login", loginDetails, Login.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(resp);
		
	}
}
