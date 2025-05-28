package com.service;

import java.util.List;

import com.vo.Member;

public interface MemberService {
	public String logIn(String id, String pw); // 로그인
	public boolean addMember(); // 회원가입
	public boolean modifyMember(); // 수정
	public boolean removeMember(); // 삭제
	public List<Member> memberList(); // 목록 (관리자)
}
