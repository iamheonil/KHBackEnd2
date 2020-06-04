package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionDeleteServlet
 */
@WebServlet("/session/delete")
public class SessionDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 세션 객체 얻기
		HttpSession session = request.getSession();
		
		// 세션 정보 삭제
		session.invalidate();
		
		// View 지정
		request.getRequestDispatcher("/WEB-INF/views/session/delete.jsp").forward(request, response);
		
				
	}

}
