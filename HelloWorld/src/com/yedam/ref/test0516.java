package com.yedam.ref;

import java.util.Scanner;

public class test0516 {
	
	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("----------------------------------------------------");
			System.out.println("1.학생 수 | 2.점수 입력 | 3.점수 리스트 | 4.분석 | 5.종료");
			System.out.println("----------------------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			
			if (selectNo == 1) {
				System.out.print("학생 수> ");
				studentNum = Integer.parseInt(scanner.nextLine());
				
				scores = new int[studentNum];
				
			} else if (selectNo == 2) {
				for (int i = 0; i < studentNum; i++) {
					System.out.printf("scores[%d]> ", i);
					scores[i] = Integer.parseInt(scanner.nextLine());
				}
			} else if (selectNo == 3) {
				for (int i = 0; i < studentNum; i++) {
					System.out.printf("scores[%d]> %d\n", i, scores[i]);
				}
			} else if (selectNo == 4) {
				int max = 0;
				double avg = 0;
				int sum = 0;
				
				for (int i = 0; i < studentNum; i++) {
					sum += scores[i];
					
					if (max < scores[i]) {
						max = scores[i];
					}
				}
				
				avg = (sum * 1.0) / studentNum;
				
				System.out.printf("최고 점수: %d\n", max);
				System.out.printf("평균 점수: %f\n", avg);
				
			} else if (selectNo == 5) {
				run = false;
			}
		}
		
		System.out.println("프로그램 종료");		
	} // main
}
