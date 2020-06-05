package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.FileUpload;

public interface FileDao {

	/**
	 * 파일업로드 정보 기록하기
	 * 
	 * @param uploadFile - 업로드한 파일의 정보
	 */
	public void insert(FileUpload fileUpload);

	/**
	 * DB전체 조회
	 * 
	 * @return List<UploadFile> - 조회 결과
	 */
	public List<FileUpload> selectAll();
	
	
	/**
	 * 파일 정보 DB 에 Insert 수행
	 * @param conn - DB 연결 객체
	 * @param up - 업로드된 파일 정보
	 * @return int - insert 수행 결과
	 * 0은 실패, 1은 성공
	 */
	
	public int insertFile(Connection conn, FileUpload up);
}













