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

@WebServlet("/emp/detail")
public class EmpDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//EmpService 객체 생성
	private EmpService empService = new EmpServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("/emp/detail - GET 요청 완료");

		//전달파라미터 eno 추출
		String param = req.getParameter("eno");
		int empno = 0;
		if(param!=null && !"".equals(param)) {
			empno = Integer.parseInt(param);
		}
		System.out.println("EmpDetailController - empno : " + empno);
		
		//빈 Emp 객체 생성
		Emp emp = new Emp();
		emp.setEmpno(empno); //empno 저장
		
		//사원 정보 상세 조회
		Emp result = empService.detail(emp);
		System.out.println("EmpDetailController - result : " + result);
		
		
		
		//조회결과(MODEL) 값을 VIEW에 전달하기 - request객체 사용
		req.setAttribute("res", result);
		
		//VIEW를 지정하고 응답하기(포워딩) - request객체 사용
		req.getRequestDispatcher("/WEB-INF/views/emp/detail.jsp")
			.forward(req, resp);
		
	}
	
}






//package controller;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import dto.Emp;
//import service.face.EmpService;
//import service.impl.EmpServiceImpl;
//
///**
// * Servlet implementation class EmpDetailController
// */
//@WebServlet("/emp/detail")
//public class EmpDetailController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private EmpService empService = new EmpServiceImpl();
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
////		System.out.println("숫자가 넘어와쏭");
//
//		// 전달 파라미터 eno 추출 -> req는 request, Response 는 resp 까먹지 말기
//		
//
//		
//		String para = req.getParameter("eno");
//		int empno = 0;
//		
////		System.out.println("11" + para);
//
//		if (para != null && !"".equals(para)) {
//			empno = Integer.parseInt(para);
//		}
//		
////		System.out.println(empno);
//		
//		// 빈 Emp 객체 생성		
//		Emp emp = new Emp();
//		
//		// 사원 정보 상세 조회
//		Emp result = empService.detail(emp);
//
//		System.out.println("EmpDetailController - result : " + result);
//		
//		// 조회결과 MODEL 값을 VIEW 에 전달 - Request 객체 사용
//		req.setAttribute("res", result);
//		
//		
//		// VIEW 를 지정하고 응답하기 (포워딩) - Request 객체 사용
//		req.getRequestDispatcher("/WEB-INF/views/emp/detail.jsp").forward(req, resp);
//		
//	}
//
//}
