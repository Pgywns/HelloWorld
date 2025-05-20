package com.yedam;

/*
	실행클래스
*/
public class StudentExample {
	public static void main(String[] args) {
		// 클래스	  변수        인스턴스 생성
		Student student = new Student();
		student.setStudentNo(1001);
		student.setStudentName("홍길동");
//		student.engScore = 80; // 속성값에 대입
//		student.mathScore = 85;
		student.setEngScore(80); // 메소드의 매개값
		student.setMathScore(85);
		
		student.study();
		student.introduce();
		System.out.printf("이름: %s, 영어 점수: %d, 수학 점수: %d\n", student.getStudentName(), student.getEngScore(), student.getMathScore());
		
		Student student2 = new Student(1002, "김민규");
//		student2.studentNo = 1002;
//		student2.studentName = "김민규";
//		student2.engScore = -50;
//		student2.mathScore = -80;
		student2.study();
		student2.introduce();
		student2.setEngScore(-50);
		student2.setMathScore(-80);
		student2.setStudentName("박민규");
		student2.introduce();
		
	}
}
