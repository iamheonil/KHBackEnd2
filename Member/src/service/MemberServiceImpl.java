package service;

import javax.servlet.http.HttpServletRequest;

import dto.Member;

public class MemberServiceImpl implements MemberService {

	/**
	 * 사원 정보를 요청객체에서 파싱한다 전달 파라미터로 전달된 사원 전체 정보를 추출하는 메소드
	 * 
	 * @param req - 요청 정보 객체
	 * @return Emp - 전달 파라미터를 저장한 사원 객체
	 */
	public Member getEmpParam(HttpServletRequest req) {
		
		return null;
	}

	/**
	 * 사원 정보 추가
	 * 
	 * @param emp - 추가할 사원 정보
	 */
	public void join(Member member) {
		
	}

}
