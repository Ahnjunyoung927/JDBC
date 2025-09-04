package com.kh;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesRun {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		prop.setProperty("A", "B");
		
		try {
			
		//prop.store(new FileOutputStream("driver.properties"), "setting for DBMS");
		prop.storeToXML(new FileOutputStream("member-mapper.xml"), "MEMBER SQL");
		// XML <xx>여는 xx태그  </xx> 닫는 xx태그
		//     태그 사이의 내용content
		//     <xx aa> aa = 태그의 속성
		//     <> 가 밖에서 감싸고 있으면 부모요소, 안에 있으면 자식요소, 같은 레벨이면 동위요소
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
