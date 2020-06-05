package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.FileDao;
import dbutil.JDBCTemplate;
import dto.FileUpload;

public class FileDaoImpl implements FileDao {

	// OJDBC 관련 객체
	private Connection conn = null; // DB연결객체
	private PreparedStatement ps = null; // SQL수행객체
	private ResultSet rs = null; // 조회결과 처리객체

	@Override
	public void insert(FileUpload uploadFile) {

		conn = JDBCTemplate.getConnection(); // DB연결

		// SQL 작성
		String sql = "";
		sql += "INSERT INTO uploadfile ( fileno, origin_name, stored_name )";
		sql += " VALUES( uploadfile_seq.nextval, ?, ? )";

		try {
			ps = conn.prepareStatement(sql); // SQL 수행 객체 얻기

			// 파일업로드 정보 삽입
			ps.setString(1, uploadFile.getOriginName());
			ps.setString(2, uploadFile.getStoredName());

			// SQL 수행
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps); // ps 자원 해제
		}

	}

	@Override
	public List<FileUpload> selectAll() {

		conn = JDBCTemplate.getConnection(); // DB연결

		// SQL 작성
		String sql = "";
		sql += "SELECT * FROM uploadfile";
		sql += " ORDER BY fileno DESC";

		// 쿼리 결과 저장할 List 생성
		List<FileUpload> list = new ArrayList<>();

		try {
			// SQL 수행
			ps = conn.prepareStatement(sql); // SQL수행 객체 생성
			rs = ps.executeQuery(); // SQL수행 및 결과 반환

			// SQL 수행 결과 처리
			while (rs.next()) {
				// 새로운 UploadFile 객체 생성
				FileUpload upfile = new FileUpload();

				// 조회 결과 담기
				upfile.setFileno(rs.getInt("fileno"));
				upfile.setOriginName(rs.getString("origin_name"));
				upfile.setStoredName(rs.getString("stored_name"));

				// UploadFile DTO 객체를 List에 담기
				list.add(upfile);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		// 결과 리스트 반환
		return list;
	}

	@Override
	public int insertFile(Connection conn, FileUpload up) {

		// SQL 작성
		String sql = "";
		sql += "INSERT INTO uploadfile ( fileno, origin_name, stored_name )";
		sql += " VALUES( uploadfile_seq.nextval, ?, ? )";

		int result = 0;
		try {
					
			ps = conn.prepareStatement(sql);
			ps.setString(1, up.getOriginName());
			ps.setString(2, up.getStoredName());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 보다 쉬워진 Close
			JDBCTemplate.close(ps);
		}
		
		// 결과 리턴
		return result;
	}

}
