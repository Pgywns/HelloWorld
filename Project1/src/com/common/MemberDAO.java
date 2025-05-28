package com.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vo.Member;

public class MemberDAO extends DAO {
	
	public String login(String id, String pw) {
		List<Member> list = memberList();
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(id) && list.get(i).getPw().equals(pw)) {
				if (id.equals("admin") && pw.equals("admin")) {
					return list.get(i).getAdmin();
				} else {
					return list.get(i).getAdmin();				
				}
			}
		} // for
		
		return null;
	} // login
	
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
				
				list.add(member);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			disConnect();		
		}
		
		return null; // 반영
	} // memberList
	
	public int insert(Member member) {
		
		String sql = "insert into tbl_member(member_id, member_name, phone, point)" + "values(?, ?, ?, ?)";

		// 접속
		getConnect();
		try {
//			stmt = conn.createStatement();
			psmt = conn.prepareStatement(sql);

			// 파라미터에 값 할당
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPw());
			psmt.setString(3, member.getPhone());
			psmt.setString(4, member.getEmail());

			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0; // 반영 X
		
	}
	
}
