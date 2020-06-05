package service.impl;

import java.sql.Connection;

import dao.face.BoardDao;
import dao.impl.BoardDaoImpl;
import dbutil.JDBCTemplate;
import dto.BoardUpload;
import service.face.BoardService;

public class BoardServiceImpl implements BoardService {
	private BoardDao boardDao = new BoardDaoImpl();

	@Override
	public int insertBoard(BoardUpload board) {
		// DB 연결 객체
		Connection conn = JDBCTemplate.getConnection();

		// DAO 를 통해 Insert 수행
		int result = boardDao.insertBoard(conn, board);

		if (result > 0) {
			// 성공
			JDBCTemplate.commit(conn);
		} else {
			// 실패
			JDBCTemplate.rollback(conn);
		}

		return result;
	}


}
