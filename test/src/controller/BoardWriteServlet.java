package controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import dto.BoardUpload;
import service.face.BoardService;
import service.impl.BoardServiceImpl;

@WebServlet("/binsert")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardService boardService = new BoardServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("접속 체크");

		req.getRequestDispatcher("/WEB-INF/views/boardindex.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("POST CHECK");

		/*
		 * HttpServletRequest request, // 요청 객체 String saveDirectory, // 파일 저장 위치 int
		 * maxPostSize, // 업로드 제한 사이즈 String encoding, // 인코딩 FileRenamePolicy policy //
		 * 중복된 파일이름 처리할 정책
		 */

		ServletContext context = getServletContext();
		String saveDirectory = context.getRealPath("/resources/board_upfiles");
		int maxPostSize = 10 * 1024 * 1024;
		String encoding = "UTF-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();

		System.out.println(saveDirectory);

		MultipartRequest mul = new MultipartRequest(req, saveDirectory, maxPostSize, encoding, policy);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String rename = sdf.format(new Date());

		System.out.println(rename);

		String origin = mul.getOriginalFileName("upload");
//		String ext = origin.substring(origin.lastIndexOf(".") + 1);
//		String stored = rename + "." + ext;

		File originFile = new File(saveDirectory, origin);
//		File renameFile = new File(saveDirectory, stored);

//		originFile.renameTo(renameFile);

		// System.out.println(stored);

		BoardUpload boardUpload = new BoardUpload();

		boardUpload.setOriginName(rename);

		int res = boardService.insertBoard(boardUpload);

		if (res > 0) {
			resp.sendRedirect("/file/list");

		} else {
			req.setAttribute("message", "파일 업로드 실패");
			req.getRequestDispatcher("/WEB-INF/common/views/file/error.jsp").forward(req, resp);

		}

	}

}
