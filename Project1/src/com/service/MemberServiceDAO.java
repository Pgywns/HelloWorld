package com.service;

import java.util.List;

import com.common.MemberDAO;
import com.vo.Member;

public class MemberServiceDAO implements MemberService {
	
	MemberDAO dao = new MemberDAO();
	
	@Override
	public String logIn(String id, String pw) {
		return dao.login(id, pw);
	}
	
	@Override
	public boolean addMember() {
		return false;
	}

	@Override
	public boolean modifyMember() {
		return false;
	}

	@Override
	public boolean removeMember() {
		return false;
	}

	@Override
	public List<Member> memberList() {
		return null;
	}

	
}
