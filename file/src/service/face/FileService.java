package service.face;

import java.util.List;

import dto.File;

public interface FileService {
	
	/**
	 * 전체 목록 저장!
	 * @return List<File> - 조회된 결과
	 */
	public List<File> list();
	
}
