package com.masai.services;

import com.masai.Exception.EmployeeNotFoundException;
import com.masai.mdel.Employee;

public interface EmployeeServices {
	public Employee createEmployee(Employee employee) throws EmployeeNotFoundException;
	public Employee getEmployeeById(Integer id)throws EmployeeNotFoundException;
	public Employee deleteEmployeeById(Integer id)throws EmployeeNotFoundException;
}
