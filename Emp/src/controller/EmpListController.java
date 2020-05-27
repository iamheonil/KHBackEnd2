package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Emp;
import service.face.EmpService;
import service.impl.EmpServiceImpl;

/**
 * Servlet implementation class EmpListController
 */
@WebServlet("/emp/list")
public class EmpListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmpService empService = new EmpServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("중비왕료");

		// Emp 테이블의 전체 목록을 조회할 것 - EMPService 이용
		List<Emp> empList = empService.list();
		
		// Test 조회 결과 출력 Sysout 이용
		for(Emp e : empList) {
			System.out.println(e);
		}

		// 조회결과(Model 값)를 View 에 전달한다.
		// JSP에 list 라는 이름으로 empList 를 전달한다.
		req.setAttribute("list", empList);
		
		// JSP를 View 로 지정하고 응답으로 사용하기 - 포워딩
		req.getRequestDispatcher("/WEB-INF/views/emp/list.jsp").forward(req, resp);
				
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
