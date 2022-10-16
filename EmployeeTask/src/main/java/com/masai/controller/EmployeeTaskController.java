package com.masai.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.mdel.Employee;
import com.masai.services.EmployeeServices;

import io.swagger.v3.oas.annotations.servers.Server;

@RestController
public class EmployeeTaskController {
	private EmployeeServices employeeServices;
	
	
	@PostMapping("/employee")
	public ResponseEntity<Employee>  saveEmployee(@RequestBody Employee employee) {
		 employeeServices.createEmployee(employee);
		return new ResponseEntity<Employee>(employee,HttpStatus.ACCEPTED);
	}
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getCustomerController(@PathVariable Integer id) {
		
		Employee employee = employeeServices.getEmployeeById(id);
		
		return new ResponseEntity<Employee>(employee,HttpStatus.ACCEPTED);
		
	}
}
