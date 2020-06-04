package cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieController
 */

@WebServlet("/cookie/create")
public class CookieCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("ㅎㅇ");
		
		Cookie c1 = new Cookie("ID", "Ali"); // 쿠키 생성
		response.addCookie(c1); // 쿠키 전송 코드
		
		Cookie c2 = new Cookie("PASS", "1234");
		response.addCookie(c2); // 쿠키 전송 코드
		
		Cookie c3 = new Cookie("NAME", "Alice");
		response.addCookie(c3); // 쿠키 전송 코드
		
		request.getRequestDispatcher("/views/create.jsp").forward(request, response);

		
		
		
	}

}
