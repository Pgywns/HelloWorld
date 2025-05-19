package com.yedam.ref;

import java.util.Scanner;

public class test0516 {
	
	static Student[] scores = null;

	public static void main(String[] args) {
		init();
		
		boolean run = true;
		int studentNum = 0;
		Scanner scanner = new Scanner(System.in);

		while (run) {
			System.out.println("-----------------------------------------------");
			System.out.println("1.학생 수 | 2.정보 입력 | 3.점수 리스트(성별) | 4.분석 | 5.종료");
			System.out.println("-----------------------------------------------");
			System.out.print("선택> ");

			int selectNo = Integer.parseInt(scanner.nextLine());

			if (scores == null) {
				if ((selectNo == 2) || (selectNo == 3) || (selectNo == 4)) {
					System.out.println("학생 수를 입력하세요");
					continue;
				}
			}

			if (selectNo == 1) {
				System.out.print("학생 수> ");
				studentNum = Integer.parseInt(scanner.nextLine());

				scores = new Student[studentNum];

			} else if (selectNo == 2) {

				for (int i = 0; i < studentNum; i++) {
					System.out.printf("scores[%d] 이름>> ", i);
					String name = scanner.nextLine();

					System.out.printf("scores[%d] 점수>> ", i);
					int score = Integer.parseInt(scanner.nextLine());
					
					System.out.printf("scores[%d] 키>> ", i);
					double height = Double.parseDouble(scanner.nextLine());
					
					System.out.printf("scores[%d] 성별>> ", i);
					String gender = scanner.nextLine();
					Gender gen = Gender.MALE;
					
					if(gender.equals("남") || gender.equals("남자")) {
						gen = Gender.MALE;
					} else if (gender.equals("여") || gender.equals("여자")) {
						gen = Gender.FEMALE;
					}
					
					
					Student std = new Student();
					std.studentName = name;
					std.score = score;
					std.height = height;
					std.gender = gen;
					
					scores[i] = std;
				}
			} else if (selectNo == 3) {
				if (scores[0] == null) {
					System.out.print("학생을 입력해주세요");
					continue;
				}
				
				System.out.print("남 or 여 >> ");
				String keyword = scanner.nextLine();
				Gender gen = Gender.MALE;
				
				if (keyword.equals("남") || keyword.equals("남자")) {
					gen = Gender.MALE;
				} else if (keyword.equals("여") || keyword.equals("여자")) {
					gen = Gender.FEMALE;
				}
				
				for (int i = 0; i < scores.length; i++) {
					if (keyword.equals("") || gen == scores[i].gender) {
						System.out.printf("scores[%d]> 이름: %s, 점수: %d, 키: %.1f, 성별: %s\n", i, scores[i].studentName, scores[i].score, scores[i].height, scores[i].gender);
					}
				}
				
			} else if (selectNo == 4) {
				if (scores[0] == null) {
					System.out.println("학생을 입력해주세요");
					continue;
				}
				
				int max = 0;
				double avg = 0;
				int sum = 0;

				for (int i = 0; i < studentNum; i++) {
					sum += scores[i].score;

					if (max < scores[i].score) {
						max = scores[i].score;
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

	public static void init() {
		Student s1 = new Student();
		s1.studentName = "홍길동";
		s1.score = 80;
		s1.height = 170.8;
		s1.gender = Gender.MALE;
		
		Student s2 = new Student();
		s2.studentName = "김민규";
		s2.score = 85;
		s2.height = 165.7;
		s2.gender = Gender.FEMALE;
		
		Student s3 = new Student();
		s3.studentName = "박철민";
		s3.score = 90;
		s3.height = 180.8;
		s3.gender = Gender.MALE;
		
		scores = new Student[] { s1, s2, s3};
	} // init
	
}
