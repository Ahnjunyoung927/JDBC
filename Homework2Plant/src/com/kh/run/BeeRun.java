package com.kh.run;

import java.util.Scanner;

public class BeeRun {

	public static void main(String[] args) {
		
		int result = 1;
		int number = 0;
		int room = 1;
		
		Scanner sc = new Scanner(System.in);
		
		number = sc.nextInt();
		sc.nextLine();
		
		if(number == 1) {
			System.out.println(result);
		} else {
			while(room < number) {
				room = room + (6 * result);
				result++;
			}
			System.out.println(result);
		}
		
	}
	
}
