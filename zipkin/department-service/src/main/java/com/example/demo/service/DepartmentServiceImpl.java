package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	private final DepartmentRepository departmentRepository;

	@Override
	public Department findDepartmentByName(String departmentName) {
		// TODO Auto-generated method stub
		return departmentRepository.findByDepartmentName(departmentName);
	}

}