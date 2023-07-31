package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.EmployeeEntity;
import com.example.demo.repo.EmployeeRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

	private final EmployeeRepository employeeRepository;
	@Override
	public EmployeeEntity createEmployee(EmployeeEntity employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

}