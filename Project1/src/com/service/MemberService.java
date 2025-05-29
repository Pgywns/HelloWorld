package com.service;

import java.util.List;

import com.vo.Member;

public interface MemberService {
	public String logIn(String id, String pw); // 로그인
	public boolean addMember(Member member); // 회원가입
	public boolean modifyMember(Member member); // 수정
	public boolean removeMember(String id); // 삭제
	public List<Member> memberList(); // 목록 (관리자)
	public void findId(String name, String phone); // 아이디 찾기
	public String findPw(String id); // 비밀번호 찾기
}
