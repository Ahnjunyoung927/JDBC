package com.aclass.test.run;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectRun {

	public static void main(String[] args) {
		// 현재 작업중인 DB서버에서 각자 자신이 가지고 있는 TB_STUDENT 테이블의 모든 행을 조회해서 Console에 출력
		// SELECT문
		// ResultSet(조회된 행들의 집합)
		// => ResultSet 타입의 데이터를 받아서 뽑기
		
		// 0) 필요한 변수들 먼저 세팅
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		// 0단계 끝!
		
		// 요청할 SQL문도 미리 완성형태로 준비해두기
		String sql = """
				         SELECT
                               STUDENT_ID
                             , STUDENT_NAME
                             , ENROLL_DATE
                          FROM
                               TB_STUDENT
                         ORDER
                            BY
                               ENROLL_DATE DESC
				     """;
		
	
		try {
			// 1. JDBC Driver 등록
			// 리플렉션을 이용한 드라이버 클래스 로딩
			// 실행시점에 필요한 데이터베이스 드라이버를 동적으로 로드
			// 코드의 변경없이 데이터베이스를 연결할 수 있도록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. Connection 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE", "AJY15", "AJY151234");
			System.out.println("DB서버 접속 성공!");
			
			// 3. 새 SQL편집기 역할을 할 Statement 객체 생성
			stmt = conn.createStatement();
			
			// 4. SQL문을 실행 후 결과 받기
			// 실행할 SQL문이 SELECT문일 경우
			// stmt.executeQuery(sql) : ResultSet
			rset = stmt.executeQuery(sql);
			// System.out.println(rset);
			
			// ResultSet 반환됨
			// next() : 커서를 조작
			
			
			while(rset.next()) {
				// 커서를 조작했을 때 행이 존재한다면 true / 행이 존재하지 않는다 false
				int studentId = rset.getInt("STUDENT_ID");
				String studentName = rset.getString("STUDENT_NAME");
				Date enrollDate = rset.getDate("ENROLL_DATE");
				System.out.println("번호 : " + studentId + ", 이름 : " + studentName + ", 등록일 : " + enrollDate);
			}
			
		} catch(ClassNotFoundException e) {
			System.out.println("ojdbc 추가했나요?");
			System.out.println("oracle.jdbc.driver.OracleDriver 오타없나요? ");
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(rset != null && !rset.isClosed()) {
					rset.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			try {
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/* Statement 사용 시 JDBC 사용 절차
	 * 
	 * 0) JDBC용 변수 선언 및 SQL 준비
	 * 
	 * 1) 실행할 SQL문 (완성된 형태)
	 * 
	 * 2) JDBC Driver 등록 (Oracle)
	 * 
	 * 3) Connection 객체 생성
	 * (URL, username, password)
	 * 
	 * 4) Statement 객체 생성
	 * 
	 * 5_1 DML일 경우) executeUpdate()
	 * 6_1 정수값 확인 후 트랜잭션 처리
	 * 
	 * 5_2 DQL일 경우) executeQuery()
	 * 6_2 행의 존재 유무 확인 후 데이터를 가공
	 * 
	 * 7) 자원반납(생성의 역순으로)
	 */
	
	
	

}
