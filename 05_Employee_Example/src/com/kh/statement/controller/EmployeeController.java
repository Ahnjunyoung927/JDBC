package com.kh.statement.controller;

import java.util.List;

import com.kh.statement.model.service.EmployeeService;
import com.kh.statement.model.vo.Employee;

public class EmployeeController {
	
	public List<Employee> selectAll(){
		List<Employee> employees = new EmployeeService().selectAll();
		
		return employees;
	}
	
	public List<Employee> selectByDept(String dept){
		List<Employee> employees = new EmployeeService().selectByDept(dept);
		
		return employees;
	}
	
	public List<Employee> selectByJob(String job){
		List<Employee> employees = new EmployeeService().selectByJob(job);
		
		return employees;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
