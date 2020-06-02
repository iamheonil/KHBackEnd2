package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.face.FileService;
import service.impl.FileServiceImpl;

@WebServlet("/commons/fileupload")
public class CommonsFileUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FileService fileService = new FileServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// View Select - File Upload <form> Foward
		req.getRequestDispatcher("/WEB-INF/views/commons/fileupload.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("commons/fileupload Post - GET !");
		
		// application/x-www-form-urlencoded 인코딩 방식으로 전달된 요청 파라미터는
		// req.getParameter() 메소드를 통해서 얻을 수 있지만!
		// multipart/form-data 인코딩 방식으로 전달된 요청 파라미터는 req.getparameter() 메소드에서 null 값만 반환된다.
		// -> 파일 업로드 라이브러리를 활용해서 처리해야한다.

		System.out.println("");
		System.out.println("title : " + req.getParameter("title"));
		System.out.println("data1 : " + req.getParameter("data1"));
		System.out.println("data2 : " + req.getParameter("data2"));
		System.out.println("upfile : " + req.getParameter("upfile"));
		System.out.println("");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		
		// 서비스객체를 이용한 파일 업로드 처리
		fileService.fileupload(req, resp);
		
		// 결과 페이지로 리다이렉트 - /file/list
		
		
	}
}
