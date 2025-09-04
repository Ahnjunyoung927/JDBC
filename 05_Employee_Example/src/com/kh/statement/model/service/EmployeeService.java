package com.kh.statement.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.common.JDBCTemplate;
import com.kh.statement.model.dao.EmployeeDAO;
import com.kh.statement.model.vo.Employee;

public class EmployeeService {
	private Connection conn = null;
	
	public EmployeeService() {
		this.conn = JDBCTemplate.getConnection();
	}

	public List<Employee> selectAll(){
		List<Employee> employees = new EmployeeDAO().selectAll(conn);
		
		return employees;
	}
	
	public List<Employee> selectByDept(String dept){
		List<Employee> employees = new EmployeeDAO().selectByDept(conn, dept);
		
		return employees;
	}
	
	public List<Employee> selectByJob(String job){
		List<Employee> employees = new EmployeeDAO().selectByJob(conn, job);
		
		return employees;
	}
	
	
	
	
	
	

}
