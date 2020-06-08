package session;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/view")
public class SessionViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 세션 객체 얻기
		HttpSession session = request.getSession();

		// 세션 정보 출력
		System.out.println("Test : " + session.getAttribute("test"));

		System.out.println("------------------------------------------");

		// 세션의 상세 정보 출력
		// 1. 세션 아이디
		System.out.println("Session ID : " + session.getId());

		// 2. 세션 생성 시간(세션이 언제 만들어 졌는가)
		System.out.println("Session Time : " + new Date(session.getCreationTime()));
		
		// 3. 세션 최근 접속 시간 (마지막 접속 시간)
		System.out.println("Session Last Accessed Time : " + new Date(session.getLastAccessedTime()));
		
		// 4. 세션 유지 시간 
		System.out.println("Session MaxInactiveInterval : " + session.getMaxInactiveInterval());

		// 5. 세션이 새롭게 생성된 것인지 판단
		System.out.println("Session isNew : " + session.isNew());
		
		System.out.println("------------------------------------------");

		// View 지정
		request.getRequestDispatcher("/WEB-INF/views/session/view.jsp").forward(request, response);

	}

}