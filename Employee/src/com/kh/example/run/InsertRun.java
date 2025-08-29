package com.kh.example.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertRun {
	/*
	 * 1. Employee 프로젝트를 생성한 후
	 * 
	 *  실행 클래스를 두 개 만들어서
	 *  하나의 클래스에서는 Employee테이블에 사용자에게 값을 입력받아서 INSERT를 할 수 있는 기능
	 *  하나의 클래스에서는 Employee테이블에 존재하는 모든 행을 SELECT해서 콘솔창에 출력하는 기능
	 *  을 구현하시오
	 *  
	 * 2. DB서버에 접속해서 Plant 테이블을 생성한 후 (알아서 컬럼의 이름, 자료형, 제약조건 만들기)
	 *    Plant테이블에 Insert하는 기능, Plant테이블에 존재하는 모든 행을 SELECT하는 기능을 구현하시오.
	 *    
	 * 3. 나만의 테이블 만드리
	 *    만들고 싶은 주제를 하나 선정해서 최소 6개 이상의 컬럼을 가진 테이블을 구현하시오
	 *    단, 컬럼들은 숫자 자료형, 문자자료형, 날짜자료형이 모두 포함되어있도록 구성하고,
	 *    모든 컬럼에 제약조건을 부여하시오.
	 */
	

	public static void main(String[] args) {
		
		//변수세팅
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		// 값 입력받기
		// 사번, 이름, 주민번호, 이메일, 폰번, 부서코드, 직급코드, 
		// 급여레벨, 급여, 보너스비율, 사수ID, 입사일, 퇴사일, 근무여부
		Scanner sc = new Scanner(System.in);
		System.out.print("사원번호를 입력해주세요 : ");
		int empId = sc.nextInt();
		sc.nextLine();
		
		System.out.print("사원명을 입력해주세요 : ");
		String empName = sc.nextLine();
		
		System.out.print("주민등록번호를 입력해주세요 : ");
		String empNo = sc.nextLine();
		
		System.out.print("이메일을 입력해주세요 : ");
		String email = sc.nextLine();
		
		System.out.print("휴대폰 번호를 입력해주세요 : ");
		String phone = sc.nextLine();
		
		System.out.print("부서코드를 입력해주세요 : ");
		String deptCode = sc.nextLine();
		
		System.out.print("직급코드를 입력해주세요 : ");
		String jobCode = sc.nextLine();
		
		System.out.print("급여레벨을 입력해주세요 : ");
		String salLevel = sc.nextLine();
		
		System.out.print("급여를 입력해주세요 : ");
		int salary = sc.nextInt();
		sc.nextLine();
		
		System.out.print("보너스비율을 입력해주세요 : ");
		double bonus = sc.nextDouble();
		sc.nextLine();
		
		System.out.print("사수의 사원번호를 입력해주세요 : ");
		int managerId = sc.nextInt();
		sc.nextLine();
		
		System.out.print("퇴사일을 입력해주세요 : ");
		String entDate = sc.nextLine();
		
		System.out.print("퇴사여부를 입력해주세요( Y / N ) : ");
		String entYn = sc.nextLine();
		
		
		
			String sql = "INSERT INTO EMPLOYEE VALUES " +
		                      "( '"  + empId + "'"
	                         + ", '" + empName + "'"
	                         + ", '" + empNo + "'"
	                         + ", '" + email + "'"
	                         + ", '" + phone + "'"
	                         + ", '" + deptCode + "'"
	                         + ", '" + jobCode + "'"
	                         + ", '" + salLevel + "'"
	                         + ", '" + salary + "'"
	                         + ", '" + bonus + "'"
	                         + ", '" + managerId + "'"
	                         + ", SYSDATE "
	                         + ", '" + entDate + "'"
	                         + ", '" + entYn + "' )";
			
			
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE", "AJY15", "AJY151234");
			
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(sql);
			
			if(result > 0) {
				conn.commit();
			} 
			
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(stmt != null && !stmt.isClosed()) {
						stmt.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					if(conn != null && !conn.isClosed())
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
	}

}
