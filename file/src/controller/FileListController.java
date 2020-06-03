package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.File;
import service.face.FileService;
import service.impl.FileServiceImpl;

/**
 * Servlet implementation class FileListController
 */
@WebServlet("/file/list")
public class FileListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 서비스 객체 생성
	private FileService fileService = new FileServiceImpl();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// GET 확인하기
		System.out.println("GET CHECK");

		// 전체 조회하는 리스트
		List<File> fileList = fileService.list();

		// 리스트 확인
		System.out.println(fileList);

		// 결과를 저장
		req.setAttribute("list", fileList);

		// 결과를 포워드하면서 같이 보내준다.
		req.getRequestDispatcher("/WEB-INF/views/file/list.jsp").forward(req, resp);

	}

}
