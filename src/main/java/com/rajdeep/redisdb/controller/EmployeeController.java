package com.rajdeep.redisdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajdeep.redisdb.entity.Employee;
import com.rajdeep.redisdb.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/")
	public String saveEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return "Employee Saved";
	}
	
	@GetMapping("/fetch")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return employeeService.getEmployee(id);
	}
	
	@PutMapping("/{id}")
	public String updateEmployees(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
		return "Employee Updated!";
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployees(@PathVariable int id) {
		employeeService.deleteEmployee(id);
		return "Employee Deleted!";
	}
}
