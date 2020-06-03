package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.face.FileDao;
import dbutil.JDBCTemplate;
import dto.UploadFile;

public class FileDaoImpl implements FileDao {

	// OJDBC 관련객체
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public void insert(UploadFile uploadFile) {

		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "INSERT INTO uploadfile (fileno, origin_name, stored_name) VALUES (uploadfile_seq.nextval, ?, ?)";

		try {
			ps = conn.prepareStatement(sql);
			
			// 파일 업로드 정보 삽입
			ps.setString(1, uploadFile.getOriginName());
			ps.setString(2, uploadFile.getStoredName());
			
			// SQL 수행
			ps.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 보다 쉬워진 자원해제
			JDBCTemplate.close(ps);
		}

	}

}
