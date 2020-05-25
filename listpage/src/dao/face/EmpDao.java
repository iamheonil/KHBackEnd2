package dao.face;

import java.util.List;

import dto.Emp;

public interface EmpDao {

	/**
	 * Emp 테이블 전체 조회
	 * 
	 * @return List<Emp> - 조회된 결과 리스트
	 */
	public List<Emp> selectAll();

}
