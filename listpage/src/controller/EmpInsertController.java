package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Emp;
import service.face.EmpService;
import service.impl.EmpServiceImpl;

/**
 * Servlet implementation class EmpInsertController
 */
@WebServlet("/emp/insert")
public class EmpInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmpService empService = new EmpServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("EmpInsterController - /emp/insert GET!");

		// View 지정 및 응답(포워딩 작업)
		req.getRequestDispatcher("/WEB-INF/views/emp/insert.jsp").forward(req, resp);

		Emp emp = empService.getEmpParam(req);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("POST");
		// 요청 파라미터 정보 얻기
		Emp emp = empService.getEmpParam(req);
		System.out.println(emp);
		
		// DB에 사원정보 추가
		empService.join(emp);
		
		// 결과 화면 이동 - 목록 페이지로 이동
		resp.sendRedirect("/emp/list");

	}

}
