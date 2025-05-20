package com.yedam.board;

/*
	추가, 수정, 삭제, 목록
*/

public class BoardExe {
	// 필드
	private Board[] boards;
	
	// 생성자
	public BoardExe() {
		boards = new Board[100];
	}
	
	// 메소드
	void execute() {
		boolean run = true;
		while(run) {
			System.out.println("----------------------------------------------");
			System.out.println("");
			System.out.println("----------------------------------------------");
		}
	} // execute;
}