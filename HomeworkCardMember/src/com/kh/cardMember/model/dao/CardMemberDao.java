package com.kh.cardMember.model.dao;

import java.sql.Connection;
import java.sql.Statement;

import com.kh.cardMember.model.vo.CardMember;

public class CardMemberDao {
	
	public int insertCardMember(CardMember cardMember) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		String sql = "INSET "
				    + "INTO "
		                  + "SEQ_MEMBER_NO.NEXTVAL"
				          
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch() {
			
		}
		
		
		
		
		
		return result;
	}
	
	
	

}
