package service;

import javax.servlet.http.HttpServletRequest;

import dao.MemberDao;
import dao.MemberDaoImpl;
import dto.Member;

public class MemberServiceImpl implements MemberService {
	
	private MemberDao memberDao = new MemberDaoImpl();

	/**
	 * 사원 정보를 요청객체에서 파싱한다 전달 파라미터로 전달된 사원 전체 정보를 추출하는 메소드
	 * 
	 * @param req - 요청 정보 객체
	 * @return member - 전달 파라미터를 저장한 사원 객체
	 */
	public Member getParam(HttpServletRequest req) {
		
		Member member = new Member();

		member.setId(req.getParameter("uid"));

		member.setNickname(req.getParameter("unick"));

		member.setEmail(req.getParameter("uemail"));
		
		return member;
	}

	/**
	 * 사원 정보 추가
	 * 
	 * @param emp - 추가할 사원 정보
	 */
	public void join(Member member) {
		
		memberDao.joiner(member);
		
	}

}
