package com.kh.cardMember.view;

import java.util.Scanner;

import com.kh.cardMember.controller.CardMemberController;

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
				break;
			case 3:
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
		
		
		
	}

}
