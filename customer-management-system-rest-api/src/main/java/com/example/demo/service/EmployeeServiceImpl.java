package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub

		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> listEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub

		Optional<Employee> emOptional = employeeRepository.findById(employeeId);
		if (emOptional==null) {
			return null;
		} else {
			return emOptional;
		}
	}

}