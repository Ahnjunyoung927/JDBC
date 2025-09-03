package com.kh.run;

import java.util.Scanner;

public class GptRun {


		public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("몇번째 결과를 얻으시겠어요 : ");
	        int n = sc.nextInt();

	        if (n < 1) {
	            System.out.println("n은 1 이상의 정수로 입력하세요.");
	            return;
	        }

	        long r = (1L << n) + 1;    // 2^n + 1  (비트시프트로 정확하고 빠르게)
	        long finalResult = r * r;  // (2^n + 1)^2

	        System.out.println(finalResult);
	    }


}
