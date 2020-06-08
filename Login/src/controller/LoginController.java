package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("와쓰");

		req.getRequestDispatcher("WEB-INF/views/loginForm.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("포스트 받아쓰");

		String id = "abc";
		String pwd = "123";

		String pid = req.getParameter("uid");
		String ppwd = req.getParameter("upwd");

		System.out.println(pid);
		System.out.println(ppwd);

		// 세션 객체 생성
		HttpSession session = req.getSession();

		if (id.equals(pid) && pwd.equals(ppwd)) {
			req.getRequestDispatcher("WEB-INF/views/loginSuccess.jsp").forward(req, resp);

			// 세션 정보 저장
			session.setAttribute("login", "true");
			session.setAttribute("loginid", "abc");
		} else {
			req.getRequestDispatcher("WEB-INF/views/loginFail.jsp").forward(req, resp);
		}

	}

}
