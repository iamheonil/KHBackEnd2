package dao.face;

import java.util.List;

import dto.File;

public interface FileDao {

	/**
	 * DB 전체 조회
	 * @return List<File> - 조회결과
	 */
	
	public List<File> selectAll();

}
