package com.example.demo.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees()
	{
		return ResponseEntity.ok(employeeService.listEmployees());
	}
	@GetMapping("/{employeeId}")
	public ResponseEntity<?> findEmployeeById(@PathVariable("employeeId") int employeeId)
	{
		Optional<Employee> optional=employeeService.getEmployeeById(employeeId);
		
		if(optional.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("employee with "+employeeId+" not found");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.FOUND).body(optional.get());
		}
	}

}