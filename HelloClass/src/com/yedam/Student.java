package com.yedam;

/*
	라이브러리 클래스
*/
public class Student {
	// 필드 (속성)
	private int studentNo;
	private String studentName;
	private double height;
	private int engScore;
	private int mathScore;
	
	// 생성자 (객체: instance의 초기화)
	public Student() {
		// 매개값이 없는 생성자 => 기본생성자.
		// 컴파일러가 생성
		
	}
	
	public Student(int studentNo, String studentName) {
		this.studentNo = studentNo; // 첫 번째 매개값은 학생번호를 할당
		this.studentName = studentName; // 두 번째 매개값은 학생이름 할당.
	}
	
	public Student(int studentNo, int engScore, int mathScore) {
		this.studentNo = studentNo;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}
	
	// 메소드(기능)
	// 인스턴스 메소드
	void study() {
		System.out.println("공부를 합니다.");
	}
	
	void introduce() {
		System.out.printf("학번은 %d이고 이름은 %s입니다.\n", studentNo, studentName);
	}
	
	// 영어, 수학
	void setEngScore(int engScore) {
		if (engScore < 0 || engScore > 100) {
			return;
		}
		this.engScore = engScore;
	}
	
	int getEngScore() {
		return engScore;
	}
	
	void setMathScore(int mathScore) {
		if (mathScore < 0 || mathScore > 100) {
			return;
		}
		this.mathScore = mathScore;
	}
	
	int getMathScore() {
		return mathScore;
	}
	
	// 학번, 학생명
	void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	
	int getStudentNo() {
		return studentNo;
	}
	
	void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	String getStudentName() {
		return studentName;
	}
	
}
