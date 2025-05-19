package com.yedam.ref;

public class ArrayExe3 {

	static Student[] stdAry;

	public static void main(String[] args) {
		
		init();
		int sum = 0;
		double max = 0;
//		String maxName = "";
		Student maxStd = new Student();
		
		for (int i = 0; i < stdAry.length; i++) {
			System.out.printf("이름:%s 점수:%d \n", stdAry[i].studentName, stdAry[i].score);
			sum += stdAry[i].score;
			
			if (stdAry[i].height > max) {
				max = stdAry[i].height;
				
				maxStd.score = stdAry[i].score;
				maxStd.studentName = stdAry[i].studentName;
				maxStd.height = stdAry[i].height;
				maxStd.gender = stdAry[i].gender;
			}
			
		}
		
		double avg = 1.0 * sum / stdAry.length;
		String strFmt = "키 큰 학생: %s, 점수: %d, 키: %.1f, 평균: %.2f";
		System.out.printf(strFmt, maxStd.studentName, maxStd.score, maxStd.height, avg);
		
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
		
		
		stdAry = new Student[] { s1, s2, s3 };

	} // init

	public static void test() {
		int num1 = 90;

		Student s1 = new Student(); // 인스턴스 생성
		s1.studentName = "홍길동";
		s1.score = 80;

		Student s2 = new Student();
		s2.studentName = "김민규";
		s2.score = 85;

		s1.score = 90;

		Student[] students = { s1, s2 };
		students[0].studentName = "홍길동";

		System.out.println(s1.studentName);
	} // test

}
