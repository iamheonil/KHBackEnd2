package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.face.BoardDao;
import dbutil.JDBCTemplate;
import dto.BoardUpload;

public class BoardDaoImpl implements BoardDao {

	private PreparedStatement ps = null;

	@Override
	public int insertBoard(Connection conn, BoardUpload board) {

		conn = JDBCTemplate.getConnection();

		String sql = "";
		int res = 0;

		sql += "INSERT INTO member (num ,title, writer, fileno, content)" + " VALUES(board_seq.nextval, ?, ?, ?, ?)";

		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, board.getTitle());
			ps.setString(2, board.getWriter());
			ps.setString(3, board.getFilename());
			ps.setString(4, board.getContent());

			res = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}

		return res;
	}

}
