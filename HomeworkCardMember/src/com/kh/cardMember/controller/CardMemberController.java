package com.kh.cardMember.controller;

import com.kh.cardMember.model.dao.CardMemberDao;
import com.kh.cardMember.model.vo.CardMember;

public class CardMemberController {
	
	
	public int insertCardMember(String name, String residentNo, String phone, String grade) {
		
		CardMember cardMember = new CardMember(name, residentNo, phone, grade);
		
		// int result = new CardMemberDao.insertCardMember(cardMember);
		
		return 0;
	}
		
	
	
	
	

}
