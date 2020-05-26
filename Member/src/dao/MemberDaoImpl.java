package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbutil.DBConn;
import dto.Member;

public class MemberDaoImpl implements MemberDao {

	// OJDBC 관련 객체

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public void joiner(Member member) {

		conn = DBConn.getConnection();

		String sql = "";
		sql += "INSERT INTO member (userno, userid, nick, email)" + " VALUES(member_seq.nextval, ?, ?, ?)";

		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, member.getId());
			ps.setString(2, member.getNickname());
			ps.setString(3, member.getEmail());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
