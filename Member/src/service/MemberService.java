package service;

import javax.servlet.http.HttpServletRequest;

import dto.Member;

public interface MemberService {

	public Member getEmpParam(HttpServletRequest req);

	public void join(Member member);

}
