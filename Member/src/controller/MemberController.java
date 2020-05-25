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

	private MemberService memberService = new MemberServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("안녕하세요");

		req.getRequestDispatcher("/WEB-INF/views/member/joinForm.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("클라이언트에서 가입 넘어옴");

		// 요청 파라미터 정보 얻기
		Member member = memberService.getEmpParam(req);
		System.out.println(member);

		// DB에 사원정보 추가
//		memberService.join(member);

	}
}
