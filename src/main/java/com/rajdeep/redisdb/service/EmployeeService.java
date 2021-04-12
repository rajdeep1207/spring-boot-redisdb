package com.rajdeep.redisdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajdeep.redisdb.entity.Employee;
import com.rajdeep.redisdb.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	public void addEmployee(Employee employee) {
		employeeRepository.addEmployee(employee);
	}

	public List<Employee> getEmployees() {
		return employeeRepository.getAllEmployees();	
	}

	public Employee getEmployee(int id) {
		return employeeRepository.getEmployee(id);
	}

	public void updateEmployee(Employee employee) {
		employeeRepository.updateEmployee(employee);
		
	}

	public void deleteEmployee(int id) {
		employeeRepository.deleteEmployee(id);
		
	}
	
}
