package com.kh.cardMember.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.cardMember.model.dto.CardMemberDTO;
import com.kh.cardMember.model.vo.CardMember;

public class CardMemberDao {
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin@115.90.212.20:10000:XE";
	private final String USERNAME = "AJY15";
	private final String PASSWORD = "AJY151234";
	
	// 컬럼값 수정하는 기능(UPDATE)
	// 한행 삭제하는 기능(DELETE)
	
	
	
	public int insertCardMember(CardMember cardMember) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = """
						INSERT
						  INTO
						       TB_CARD_MEMBER
						VALUES     
						       SEQ_MEMBER_NO
						     , ?
						     , ?
						     , ?
						     , ?
						     , SYADATE
				     """;
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cardMember.getName());
			pstmt.setString(2, cardMember.getResidentNo());
			pstmt.setString(3, cardMember.getPhone());
			pstmt.setString(4, cardMember.getGrade());
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public List<CardMember> findAll(){
		List<CardMember> cardMembers = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = """
						SELECT
						       MEMBER_NO
						     , NAME
						     , RESIDENT_NO
						     , PHONE
						     , GRADE
						     , ENROLL_DATE
						  FROM
						       TB_CARD_MEMBER
					 """;
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				cardMembers.add(new CardMember(rset.getInt("MEMBER_NO"), rset.getString("NAME"), rset.getString("RESIDENT_NO")
						, rset.getString("PHONE"), rset.getString("GRADE"), rset.getDate("ENROLL_DATE")));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset != null) {
					rset.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cardMembers;
	}
	
	public CardMember findByResidentNo(String residentNo) {
		CardMember cardMember = new CardMember();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = """
						SELECT
						       MEMBER_NO
						     , NAME
						     , RESIDENT_NO
						     , PHONE
						     , GRADE
						     , ENROLL_DATE
						  FROM
						       TB_CARD_MEMBER
						 WHERE
						       RESIDENT_NO = ?
					 """;
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				cardMember = new CardMember(rset.getInt("MEMBER_NO"), rset.getString("NAME"), rset.getString("RESIDENT_NO")
						, rset.getString("PHONE"), rset.getString("GRADE"), rset.getDate("ENROLL_DATE"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset != null) {
					rset.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cardMember;
	}
	
	public List<CardMember> findByName(String keyword){
		List<CardMember> cardMembers = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = """
						SELECT
						       MEMBER_NO
						     , NAME
						     , RESIDENT_NO
						     , PHONE
						     , GRADE
						     , ENROLL_DATE
						  FROM
						       TB_CARD_MEMBER
						 WHERE
						       NAME LIKE '%'||?||'%'
						 ORDER
						    BY
						       ENROLL_DATE DESC
					 """;
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				cardMembers.add(new CardMember(rset.getInt("MEMBER_NO"), rset.getString("NAME"), rset.getString("RESIDENT_NO")
						, rset.getString("PHONE"), rset.getString("GRADE"), rset.getDate("ENROLLDATE")));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset != null) {
					rset.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cardMembers;
	}
	
	public int changePhone(CardMemberDTO cardMemberDTO) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = """
				  		UPDATE
				  		       TB_CARD_MEMBER
				  		   SET
				  		       PHONE = ?
				  		 WHERE
				  		       RESIDENT_NO = ?
				  		   AND
				  		       PHONE = ?
					 """;
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cardMemberDTO.getNewPhone());
			pstmt.setString(2, cardMemberDTO.getName());
			pstmt.setString(3, cardMemberDTO.getPhone());
			
			result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int delete(CardMember cardMember) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
				
		
		
		
		return result;
	}
	
	
	

}
