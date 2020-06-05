package controller;

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

import dto.FileUpload;
import service.face.FileService;
import service.impl.FileServiceImpl;


@WebServlet("/file/upload")
public class UploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FileService fileService = new FileServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 접속 체크
		System.out.println("체크");

		// 체크 확인 -> 포워드
		req.getRequestDispatcher("/WEB-INF/views/cos/fileupload.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Post 체크
		System.out.println("Post 체크");

		/*
		HttpServletRequest request, // 요청 객체
    	String saveDirectory, // 파일 저장 위치
    	int maxPostSize, // 업로드 제한 사이즈
    	String encoding, // 인코딩
    	FileRenamePolicy policy // 중복된 파일이름 처리할 정책
		 */
		
		ServletContext context = getServletContext();
		
		String saveDirectory = context.getRealPath("upload");
		
		System.out.println(saveDirectory);
		
		int maxPostSize = 10 * 1024 * 1024;
		
		String encoding = "UTF-8";
		
		FileRenamePolicy policy = new DefaultFileRenamePolicy(); 
		
		MultipartRequest mul = new MultipartRequest(req, saveDirectory, maxPostSize, encoding, policy);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssS");
		String rename = sdf.format(new Date());
		
		String origin = mul.getOriginalFileName("upfile");
		String ext = origin.substring(origin.lastIndexOf(".") + 1);
		
		String stored = rename + "." + ext;
		
		System.out.println("스토어드 파일 네임 첵 : " + stored);
		
		FileUpload up = new FileUpload();
		
		up.setOriginName(origin);
		up.setStoredName(stored);
		
		int res = fileService.insertFile(up);
		
		// ------------------------------
			
			if( res > 0 ) {
				// insert 성공
//				resp.sendRedirect("/file/list");
				System.out.println("성공!");
				
			} else {
				// insert 실패
				req.setAttribute("message", "파일 업로드 실패");
				req.getRequestDispatcher("/WEB-INF/views/file/error.jsp").forward(req, resp);
				
			}
		
		
	}

}
