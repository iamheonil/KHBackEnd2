package dao.face;

import dto.UploadFile;

public interface FileDao {
	
	
	/**
	 * 파일 업로드 정보 기록하기
	 * @param uploadFile - 업로드한 파일의 정보
	 */
	public void insert(UploadFile uploadFile);

}
