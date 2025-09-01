package com.kh.card.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CardMember {

	public static void main(String[] args) {
		
		Connection conn = null; 
		Statement stmt = null;  
		int result = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("고객번호를 입력해주세요 : ");
		int memberNo = sc.nextInt();
		sc.nextLine();
		System.out.print("이름을 입력해주세요 : ");
		String name = sc.nextLine();
		System.out.print("주민등록번호를 입력해주세요 : ");
		String residentNo = sc.nextLine();
		System.out.print("휴대폰 번호를 입력해주세요 : ");
		String phoneNo = sc.nextLine();
		System.out.print("회원등급을 입력해주세요(실버, 레드, 퍼플, 블랙) : ");
		String grade = sc.nextLine();
		
		String sql = sql = "INSERT INTO TB_CARD_MEMBER VALUES("
		       + memberNo + ", " +
		   "'" + name + "' , " + 
	       "'" + residentNo + "' , " +
		   "'" + phoneNo + "' , " + 
	       "'" + grade + "' ,"
	           + "SYSDATE )";
		
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
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
