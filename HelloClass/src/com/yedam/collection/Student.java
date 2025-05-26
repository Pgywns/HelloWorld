package com.yedam.collection;

public class Student {
	private int StudentNo; // 1001, 1002, 1003 .... 1010;
	private int score;
	
	public Student(int studentNo, int score) {
		this.StudentNo = studentNo;
		this.score = score;
	}
	
	// getter
	public int getScore() {
		return score;
	}

	public int getStudentNo() {
		return StudentNo;
	}

	// setter
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
