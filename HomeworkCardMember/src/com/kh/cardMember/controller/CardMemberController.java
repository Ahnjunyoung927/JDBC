package com.kh.cardMember.controller;

import java.util.List;

import com.kh.cardMember.model.dao.CardMemberDao;
import com.kh.cardMember.model.vo.CardMember;

public class CardMemberController {
	
	
	public int insertCardMember(String name, String residentNo, String phone, String grade) {
		
		CardMember cardMember = new CardMember(name, residentNo, phone, grade);
		
		int result = 0;
		// int result = new CardMemberService().insertCardMember(cardMember);
		
		return result;
	}
		
	public List<CardMember> findAll(){
		List<CardMember> cardMembers = new CardMemberDao().findAll();
		
		return cardMembers;
		
	}
	
	public CardMember findByResidentNo(String residentNo) {
		CardMember cardMember = new CardMemberDao().findByResidentNo(residentNo);
		
		return cardMember;
	}
	
	
	

}