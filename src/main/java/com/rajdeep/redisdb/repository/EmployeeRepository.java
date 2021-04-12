package com.rajdeep.redisdb.repository;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.rajdeep.redisdb.entity.Employee;

@Repository
public class EmployeeRepository {
	
	private HashOperations hashOperations;
    //private RedisTemplate redisTemplate;

    public EmployeeRepository(RedisTemplate redisTemplate) {
        this.hashOperations=redisTemplate.opsForHash();
    }
    
	public void addEmployee(Employee employee) {
		hashOperations.put("EMPLOYEE", employee.getId(), employee);
	}

	//@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		return hashOperations.values("EMPLOYEE");
		
	}

	//@SuppressWarnings("unchecked")
	public Employee getEmployee(int id) {
		return (Employee)hashOperations.get("EMPLOYEE",id);
	}

	public void updateEmployee(Employee employee) {
		addEmployee(employee);
		
	}

	//@SuppressWarnings("unchecked")
	public void deleteEmployee(int id) {
		hashOperations.delete("EMPLOYEE",id);
		
	}

}
