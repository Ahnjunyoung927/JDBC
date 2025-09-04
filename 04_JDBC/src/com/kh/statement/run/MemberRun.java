package com.kh.statement.run;

import com.kh.common.JDBCTemplate;
import com.kh.statement.view.MemberView;

public class MemberRun {

	public static void main(String[] args) {
		JDBCTemplate.registDriver(); // 드라이브 등록은 프로그램 시작 시 한번만 하면 되므로
		
		MemberView mv = new MemberView();
		mv.mainMenu();
		
		
	}

}
