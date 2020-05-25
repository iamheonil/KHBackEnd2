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

	
	/**
	 * Emp 테이블 지정된 사원번호 조회
	 * @param emp - 지정된 사원의 empno가 들어있는 객체
	 * @return Emp - 조회된 사원 정보. 단, 예외가 발생하면 널값을 반환 
	 *
	 */
	public Emp selectByEmpno(Emp emp);


	/**
	 * 사원 정보를 삽입
	 * @param emp - 삽입할 사원 정보
	 */
	public void insert(Emp emp);

}
