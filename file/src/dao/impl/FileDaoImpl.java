package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.FileDao;
import dbutil.JDBCTemplate;
import dto.File;

public class FileDaoImpl implements FileDao {

	// OJDBC 관련 객체

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public List<File> selectAll() {

		// DB 커넥션
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "SELECT * FROM UPLOADFILE ORDER BY fileno";

		// 쿼리 결과 저장할 List 생성
		List<File> list = new ArrayList<>();

		try {
			// SQL 수행
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			// 수행 결과 처리
			while (rs.next()) {
				// 새로운 File 객체 생성
				File file = new File();

				// 조회결과 담기
				file.setFileno(rs.getInt("fileno"));
				file.setOriginName(rs.getString("origin_name"));
				file.setOriginName(rs.getString("stored_name"));

				// 결과 List 에 담기
				list.add(file);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		// 결과 반환
		return list;
	}

}
