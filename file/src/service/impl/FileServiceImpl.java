package service.impl;

import java.util.List;

import dao.face.FileDao;
import dao.impl.FileDaoImpl;
import dto.File;
import service.face.FileService;

public class FileServiceImpl implements FileService {

	private FileDao fileDao = new FileDaoImpl();
	
	@Override
	public List<File> list() {
		
		// DAO를 통해 테이블 전체 내용을 조회해서 반환하기.
		return fileDao.selectAll();
	}



}
