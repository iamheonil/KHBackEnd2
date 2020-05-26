package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
import service.MemberService;
import service.MemberServiceImpl;

/**
 * Servlet implementation class MemberController
 */

@WebServlet("/member/join")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 서비스 객체 생성
	private MemberService memberService = new MemberServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 접속 시 확인
		System.out.println("안녕하세요");

		// View 를 지정하고 응답하기 + 포워딩 작업
		req.getRequestDispatcher("/WEB-INF/views/member/joinForm.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Submit 체크
		System.out.println("클라이언트에서 가입 넘어옴");

		// Post 데이터 한글 인코딩 설정
		req.setCharacterEncoding("utf-8");
		
		// 요청 파라미터 정보 얻기
		Member member = memberService.getParam(req);
		System.out.println(member);

		// DB에 사원정보 추가
		memberService.join(member);
		
		// VIEW 에다가 보내주기
		req.setAttribute("res", member);

		req.getRequestDispatcher("/WEB-INF/views/member/result.jsp").forward(req, resp);
		
	}
}
