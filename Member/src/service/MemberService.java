package service;

import javax.servlet.http.HttpServletRequest;

import dto.Member;

public interface MemberService {

	
	/**
	 * 
	 * @param req
	 * @return
	 */
	public Member getParam(HttpServletRequest req);

	
	/**
	 * 전달된 정보를 이용하여 회원가입 처리
	 * @param member - 클라이언트로부터 전달된 회원 정보 객체
	 * @return Member - DB에서 삽입완료 된 회원 정보 객체
	 * (반환객체에는 userno가 포함되어있어야한다.)
	 */
	
	public void join(Member member);

}
