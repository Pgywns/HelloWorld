package com.yedam.board;

/*
 	글번호, 제목, 내용, 작성자: 필드
 	getter, setter 작성: 메소드
 	기본생성자, 전체매개값을 갖는 생성자
*/

public class Board {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	
	// 기본생성자
	public Board() {
		
	}
	
	// 전체매개값을 갖는 생성자
	public Board(int boardNo, String title, String content, String writer) {
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	
}