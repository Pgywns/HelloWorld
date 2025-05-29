package com.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vo.Member;

public class MemberDAO extends DAO {
	
	Scanner scn = new Scanner(System.in);
	
	public String login(String id, String pw) {
		List<Member> list = memberList();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(id) && list.get(i).getPw().equals(pw)) {
				if (list.get(i).getAdmin().equals("admin")) {
					return list.get(i).getAdmin();
				} else {
					return list.get(i).getAdmin();				
				}
			}
		} // for
		
		return "";
	} // login
	
	public void findid(String name, String phone) {
		List<Member> list = memberList();
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(name) && list.get(i).getPhone().equals(phone)) {
				System.out.printf("아이디는 %s입니다.\n", list.get(i).getId());
				return;
			}
		}
		
		System.out.println("아이디가 존재하지 않습니다.");
		return;
	}
	
	public String findpw(String id) {
		List<Member> list = memberList();
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				System.out.print("이름>> ");
				String name = scn.nextLine();
				
				System.out.print("전화번호>> ");
				String phone = scn.nextLine();
				
				if (list.get(i).getName().equals(name) && list.get(i).getPhone().equals(phone)) {
					return list.get(i).getPw();
				} else {
					System.out.println("정보가 일치하지 않습니다.");
					return null;
				}
			}
		}

		System.out.println("존재하지 않는 아이디입니다.");
		return null;
	}
	
	public List<Member> memberList() {
		String sql = "select * from member";

		// 접속
		getConnect();
		List<Member> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Member member = new Member();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
				member.setEmail(rs.getString("email"));
				member.setAdmin(rs.getString("admin"));
				
				list.add(member);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			disConnect();		
		}
		
		return null;
		
	} // memberList
	
	public int insert(Member member) {
		
		String sql = "insert into member(id, pw, name, phone, email)" + "values(?, ?, ?, ?, ?)";

		// 접속
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPw());
			psmt.setString(3, member.getName());
			psmt.setString(4, member.getPhone());
			psmt.setString(5, member.getEmail());

			if (member.getId().equals("") || member.getPw().equals("") || member.getName().equals("")) {
				System.out.println("아이디, 비밀번호, 이름은 필수 항목입니다.");
				return 0;
			}
			
			int r = psmt.executeUpdate();
			return r;
			
		} catch (SQLException e) {
			System.out.println("이미 존재하는 아이디이거나 입력하신 정보가 잘못되었습니다.");
			
		} finally {
			disConnect();
		}
		
		return 0;		
	} // insert
	
	public int delete(String id) {
		String sql = "delete from member "
				   + "where  id = ?";
		// 접속
		getConnect();
			
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			System.out.println("존재하지 않는 아이디입니다.");
			
		} finally {
			disConnect();
			
		}
		return 0;
	} // delete
	
	public int update(Member member) {
		String sql = "update member "
				   + "set id = ?";    
	
		if (!member.getPw().equals("")) {
			sql = sql + "     , pw = " + "'" + member.getPw() + "'";
		}
		
		if (!member.getName().equals("")) {
			sql = sql + "     , name = " + "'" + member.getName() + "'";
		}
		
		if (!member.getPhone().equals("")) {
			sql = sql + "     , phone = " + "'" + member.getPhone() + "'";
		}
		
		if (!member.getEmail().equals("")) {
			sql = sql + "     , email = " + "'" + member.getEmail() + "'";
		}
		
		sql = sql + " where  id = ?";
		
		// 접속
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, member.getId());
			psmt.setString(2, member.getId());

			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0;

	} // update
}
