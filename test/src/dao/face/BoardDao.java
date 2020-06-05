package dao.face;

import java.sql.Connection;

import dto.BoardUpload;


public interface BoardDao {
	
	public int insertBoard(Connection conn, BoardUpload board);

}
