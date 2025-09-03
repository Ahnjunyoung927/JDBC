package com.kh.run;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		int n = 0;
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();
		
		int line = (int)Math.pow(2, n) + 1;
		int result = line * line;
		
		System.out.println(result);
	}
}


