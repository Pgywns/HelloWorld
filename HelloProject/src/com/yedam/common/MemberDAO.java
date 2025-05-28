package com.yedam.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.Member;

/*
 * Database에 insert, update, delete, select
 */

public class MemberDAO extends DAO {

	public int insert(Member member) {
		String sql = "insert into tbl_member(member_id, member_name, phone, point)" + "values(?, ?, ?, ?)";

		// 접속
		getConnect();
		try {
//			stmt = conn.createStatement();
			psmt = conn.prepareStatement(sql);

			// 파라미터에 값 할당
			psmt.setString(1, member.getMemberId());
			psmt.setString(2, member.getMemberName());
			psmt.setString(3, member.getPhone());
			psmt.setInt(4, member.getPoint());

			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0; // 반영 X

	} // insert

	public int update(Member member) {
		String sql = "update tbl_member"
				   + "set    phone = ?"
				   + "     , point = ?"
				   + "where  member_id = ?";
		
		// 접속
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);

			// 파라미터에 값 할당
			psmt.setString(1, member.getPhone());
			psmt.setInt(2, member.getPoint());
			psmt.setString(3, member.getMemberId());

			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0; // 반영

	} // update
	
	public int delete(String memberId) {
		String sql = "delete from tbl_name"
				   + "where  member_id = ?";
		// 접속
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);

			// 파라미터에 값 할당
			psmt.setString(1, memberId);

			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			disConnect();
			
		}
		return 0; // 반영	
	} // delete
	
	public List<Member> select() {
		String sql = "select * from tbl_member";
		
		// 접속
		getConnect();
		List<Member> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setPhone(rs.getString("phone"));
				member.setPoint(rs.getInt("point"));
				
				list.add(member);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			disConnect();
			
		}
		return null; // 반영	
	}
}
