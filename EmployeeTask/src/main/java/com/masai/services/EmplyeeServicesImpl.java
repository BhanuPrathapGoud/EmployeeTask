package com.masai.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.EmployeeNotFoundException;
import com.masai.dao.EmployeeDao;
import com.masai.dao.TasksDao;
import com.masai.mdel.Employee;



@Service
public class EmplyeeServicesImpl implements EmployeeServices {
	@Autowired
	private EmployeeDao employeeDao;
	

	@Override
	public Employee createEmployee(Employee employee) throws EmployeeNotFoundException {
		Optional<Employee> opt = employeeDao.findById(employee.getId());
		if(opt.isPresent()) {
			throw new EmployeeNotFoundException("Employee already Excites");
		}else {
			employeeDao.save(employee);
			return employee;
		}
		
	}

	@Override
	public Employee getEmployeeById(Integer id) throws EmployeeNotFoundException {
		Optional<Employee> opt = employeeDao.findById(id);
		if(opt.isPresent()) {
			Employee employeeext = opt.get();
			return employeeext;
		}else {
			throw new EmployeeNotFoundException("Employee not found");
		}
		
	}

	@Override
	public Employee deleteEmployeeById(Integer id) throws EmployeeNotFoundException {
		Optional<Employee> opt = employeeDao.findById(id);
		if(opt.isPresent()) {
			Employee employeeext = opt.get();
			employeeDao.delete(employeeext);
			return employeeext;
		}else {
			throw new EmployeeNotFoundException("Employee not found");
		}
	}
	

}
