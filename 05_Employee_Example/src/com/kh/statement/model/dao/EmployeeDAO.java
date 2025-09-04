package com.kh.statement.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.statement.model.vo.Employee;

public class EmployeeDAO {
	private Properties prop = new Properties();
	
	
	
	public EmployeeDAO() {
		try {
			prop.loadFromXML(new FileInputStream("resources/employee-mapper.xml"));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public List<Employee> selectAll(Connection conn){
		List<Employee> employees = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				employees.add(new Employee(rset.getString("EMP_ID"), rset.getString("EMP_NAME"), rset.getInt("SALARY")
						                 , rset.getString("DEPT_TITLE"), rset.getString("JOB_NAME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return employees;
	}
	
	public List<Employee> selectByDept(Connection conn, String dept){
		List<Employee> employees = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectByDept");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				employees.add(new Employee(rset.getString("EMP_ID"), rset.getString("EMP_NAME"), rset.getInt("SALARY")
						                 , rset.getString("DEPT_TITLE"), rset.getString("JOB_NAME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return employees;
	}
	
	
	public List<Employee> selectByJob(Connection conn, String job){
		List<Employee> employees = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectByJob");
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, job);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				employees.add(new Employee(rset.getString("EMP_ID"), rset.getString("EMP_NAME"), rset.getInt("SALARY")
						                 , rset.getString("DEPT_TITLE"), rset.getString("JOB_NAME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
	

}
