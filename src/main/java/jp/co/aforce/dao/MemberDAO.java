package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.model.Member;

public class MemberDAO extends DAO {
	
	public Member getMember(int id) throws Exception {
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"select * from Member where id = ?"
			);
		st.setInt(1, id);
		
		ResultSet rs = st.executeQuery();
		
		Member member = null;
		if(rs.next()) {
			member = new Member();
			member.setId(rs.getInt("id"));
			member.setLast_name(rs.getString("last_name"));
			member.setFirst_name(rs.getString("first_name"));
			member.setSex(rs.getString("sex"));
			member.setBirth_day(rs.getDate("birth_day"));
			member.setJob(rs.getString("job"));
			member.setPhone_number(rs.getInt("phone_number"));
			member.setMail_address(rs.getString("mail_address"));
		} else {
			throw new Exception();
		}
		
		st.close();
		con.close();
		
		return member;
	}
	public int createMember(Member member) throws Exception {
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"insert into member values (null, ?, ?, ?, ?, ?, ?, ?)"
			);
		st.setString(1, member.getLast_name());
		st.setString(2, member.getFirst_name());
		st.setString(3, member.getSex());
		st.setDate(4, member.getBirth_day());
		st.setString(5, member.getJob());
		st.setInt(6, member.getPhone_number());
		st.setString(7, member.getMail_address());
		
		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}
	
	public int updateMember(Member member) throws Exception{
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"update member set last_name = ?, first_name = ?, sex = ?,"
				+ "birth_day = ?, job = ?, phone_number = ?, mail_address = ?"
				+ "where id = ?"
			);
		st.setString(1, member.getLast_name());
		st.setString(2, member.getFirst_name());
		st.setString(3, member.getSex());
		st.setDate(4, member.getBirth_day());
		st.setString(5, member.getJob());
		st.setInt(6, member.getPhone_number());
		st.setString(7, member.getMail_address());
		st.setInt(8, member.getId());
		
		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}
	
	public int deleteMember(int id) throws Exception {
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"delete from Member where id = ?"
			);
		st.setInt(1, id);
		
		int line = st.executeUpdate();
		
		st.close();
		con.close();

		return line;
	}
}
