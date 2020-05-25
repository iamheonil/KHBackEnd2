package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.Emp;

public interface EmpService {
	
	
	/**
	 * 사원의 전체 목록을 조회한다.
	 * @return List<Emp> - 조회된 사원 전체 목록
	 */
	public List<Emp> list();
	
	
	/**
	 * 
	 * @param emp - 조회대상 empno
	 * @return Emp 조회된 결과
	 */
	public Emp detail(Emp emp);
	
	
	/**
	 * 사원 정보를 요청객체에서 파싱한다
	 * 전달 파라미터로 전달된 사원 전체 정보를 추출하는 메소드
	 * 
	 * @param req - 요청 정보 객체
	 * @return Emp - 전달 파라미터를 저장한 사원 객체
	 */
	public Emp getEmpParam(HttpServletRequest req);
	
	
	/**
	 * 사원 정보 추가
	 * @param emp - 추가할 사원 정보
	 */
	public void join(Emp emp);

}
