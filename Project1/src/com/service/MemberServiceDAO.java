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
	public boolean addMember(Member member) {
		return dao.insert(member) == 1;
	}

	@Override
	public boolean modifyMember(Member member) {
		return dao.update(member) == 1;
	}

	@Override
	public boolean removeMember(String id) {
		return dao.delete(id) == 1;
	}

	@Override
	public List<Member> memberList() {
		return dao.memberList();
	}

	@Override
	public void findId(String name, String phone) {
		dao.findid(name, phone);
	}

	@Override
	public String findPw(String id) {
		return dao.findpw(id);
	}

	
}
