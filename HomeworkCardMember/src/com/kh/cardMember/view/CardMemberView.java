package com.kh.cardMember.view;

import java.util.List;
import java.util.Scanner;

import com.kh.cardMember.controller.CardMemberController;
import com.kh.cardMember.model.vo.CardMember;

public class CardMemberView {
	private Scanner sc = new Scanner(System.in);
	CardMemberController cmc = new CardMemberController();

	public void mainMenu() {

		while (true) {
			System.out.println("---- 카드회원 관리 프로그램 ----");
			System.out.println("1. 신규회원 등록");
			System.out.println("2. 회원정보 전체조회");
			System.out.println("3. 주민등록번호로 조회");
			System.out.println("4. 이름으로 조회");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴를 입력해주세요 : ");
			int menuNo = sc.nextInt();
			sc.nextLine();

			switch (menuNo) {
			case 1:
				insertCardMember();
				break;
			case 2:
				findAll();
				break;
			case 3:
				findByResidentNo();
				break;
			case 4:
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}

		}

	}

	private void insertCardMember() {
		System.out.println();
		System.out.println("신규회원 등록 서비스입니다.");
		System.out.println("안내에 따라 정보를 입력해주세요.");
		System.out.print("회원명 : ");
		String name = sc.nextLine();
		System.out.print("주민등록번호 : ");
		String residentNo = sc.nextLine();
		System.out.print("휴대폰 번호 : ");
		String phone = sc.nextLine();
		System.out.print("회원등급(실버, 레드, 퍼플, 블랙) : ");
		String grade = sc.nextLine();
		
		int result = cmc.insertCardMember(name, residentNo, phone, grade);
		
		if(result > 0) {
			System.out.println("신규회원이 성공적으로 등록되었습니다.");
		} else {
			System.out.println("신규회원 등록에 실패했습니다. 입력사항을 다시 한번 확인해주세요.");
		}
	}
	
	private void findAll() {
		System.out.println();
		System.out.println("전체회원 정보 조회 서비스입니다.");
		List<CardMember> cardMembers = cmc.findAll();
		
		if(cardMembers.isEmpty()) {
			System.out.println("등록된 회원 정보가 없습니다.");
		} else {
			System.out.println("등록된 회원은 총 " + cardMembers.size() + "명 입니다.");
			for(CardMember cardMember : cardMembers) {
				System.out.println("=================================================================");
				System.out.println("회원번호 : " + cardMember.getMemberNo());
				System.out.print(", 회원명 : " + cardMember.getName());
				System.out.print(", 주민등록번호 : " + cardMember.getResidentNo());
				System.out.print(", 휴대폰번호 : " + cardMember.getPhone());
				System.out.print(", 회원등급 : " + cardMember.getGrade());
				System.out.println(", 회원가입일 : " + cardMember.getEnrollDate());
				System.out.println("=================================================================");
				System.out.println();
			}
		}
	}
	
	private void findByResidentNo() {
		System.out.println();
		System.out.println("회원정보 조회서비스입니다.");
		System.out.print("주민등록번호를 입력해주세요(-포함) : ");
		String residentNo = sc.nextLine();
		
		CardMember cardMember = cmc.findByResidentNo(residentNo);
		
		if(cardMember != null) {
			System.out.println();
			System.out.println("검색하신 회원의 정보입니다.");
			System.out.print("회원번호 : " + cardMember.getMemberNo());
			System.out.print(", 회원명 : " + cardMember.getName());
			System.out.print(", 주민등록번호 : " + cardMember.getResidentNo());
			System.out.print(", 휴대폰 번호 : " + cardMember.getPhone());
			System.out.print(", 회원등급 : " + cardMember.getGrade());
			System.out.println(", 회원가입일 : " + cardMember.getEnrollDate());
		}
		
	}
	

}