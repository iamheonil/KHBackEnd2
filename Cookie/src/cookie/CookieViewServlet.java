package cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/view")
public class CookieViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 쿠기 정보 전체 가져오기 (Cookie[])
		Cookie[] cookies = request.getCookies(); // 참조값 출력

		// 쿠키 정보 전체 출력하기
		for (int i = 0; i < cookies.length; i++) {
//			System.out.println(cookies[i]); 참조값이 출력된다.

			System.out.println(cookies[i].getName() + "=" + cookies[i].getValue());
		}

		// View 지정
		request.getRequestDispatcher("/views/cookie/view.jsp").forward(request, response);

	}

}
