package com.kh.example.run;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectRun {

	public static void main(String[] args) {
		//  하나의 클래스에서는 Employee테이블에 존재하는 모든 행을 SELECT해서 콘솔창에 출력하는 기능
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = """
			   	   SELECT
			              EMP_ID
			            , EMP_NAME
			            , EMP_NO
			            , EMAIL
			            , PHONE
			            , DEPT_CODE
			            , JOB_CODE
			            , SAL_LEVEL
			            , SALARY
			            , BONUS
			            , MANAGER_ID
			            , HIRE_DATE
			            , ENT_DATE
			            , ENT_YN
			         FROM
			              EMPLOYEE
			        ORDER
			           BY
			              HIRE_DATE DESC
			       	 """;
		
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		

		
		
	}

}
