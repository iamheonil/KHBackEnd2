package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/create")
public class SessionCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Session_ID 는 톰캣이 알아서 생성한다.

	// 세션 정보만 생성하면 된다.

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 세션 객체 생성
		HttpSession session = request.getSession();

		// 세션 정보 저장
		session.setAttribute("test", "홍길동");
		
		// 세션 유지시간 변경하기
//		session.setMaxInactiveInterval(0); // 0 은 무한
//		session.setMaxInactiveInterval(5); // 5초
		session.setMaxInactiveInterval(1 * 60 * 60); // 1시간

		// View 지정하기
		request.getRequestDispatcher("/WEB-INF/views/session/view.jsp").forward(request, response);
		
		
	}

}