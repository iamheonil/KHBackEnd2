package cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/update")
public class CookieUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cookie c1 = new Cookie("ID", "Boo");
		response.addCookie(c1);
		
		Cookie c2 = new Cookie("PASS", "4175");
		response.addCookie(c2);
		
		Cookie c3 = new Cookie("NAME", "NIRI");
		response.addCookie(c3);
		
		request.getRequestDispatcher("/views/cookie/update.jsp").forward(request, response);
		
		
		
	}
	
}
