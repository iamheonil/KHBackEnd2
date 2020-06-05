package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.FileUpload;

public interface FileService {

	/**
	 * 파일 업로드 처리
	 * 	Commons-Fileupload 라이브러리 활용
	 * 
	 * @param req - 요청정보객체
	 * @param resp - 응답정보객체
	 */
	public void fileupload(HttpServletRequest req, HttpServletResponse resp);
	
	/**
	 * 전체 목록 조회
	 * 
	 * @return List<UploadFile> - 조회된 결과
	 */
	public List<FileUpload> list();
	
	
	/**
	 * 
	 * 업로드된 파일 정보 기록하기
	 * @param up - 업로드된 파일의 정보
	 * @return int - DB에서 insert 수행한 결과,<br>
	 * 0 - 실패 1 - 성공
	 */
	public int insertFile(FileUpload up);
	
}















