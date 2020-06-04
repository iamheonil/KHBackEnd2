package cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieDeleteServlet
 */
@WebServlet("/cookie/delete")
public class CookieDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 쿠키 삭제 방법
		// 쿠키의 maxAge(쿠키 유지시간)를 0으로 설정한다.

		Cookie[] cookise = request.getCookies();

		for (int i = 0; i < cookise.length; i++) {

//			cookise[i].setMaxAge(0); // 즉시 삭제된다.
//			cookise[i].setMaxAge(3); // 3초 뒤에 삭제된다.
			
			cookise[i].setMaxAge(24 * 60 * 60); // 하루동안 유지하도록 설정
			
			response.addCookie(cookise[i]);

		}
		
		request.getRequestDispatcher("/views/cookie/delete.jsp").forward(request, response);

	}

}
