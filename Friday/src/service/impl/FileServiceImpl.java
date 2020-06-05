package service.impl;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.face.FileDao;
import dao.impl.FileDaoImpl;
import dbutil.JDBCTemplate;
import dto.FileUpload;
import dto.ParamData;
import service.face.FileService;

public class FileServiceImpl implements FileService {

	// FileDao 객체
	private FileDao fileDao = new FileDaoImpl();

	@Override
	public void fileupload(HttpServletRequest req, HttpServletResponse resp) {

		// 전달파라미터를 저장할 DTO 객체
		ParamData paramData = new ParamData();

		// 응답 객체 Content-Type 설정
		resp.setContentType("text/html; charset=utf-8");

		// 응답 객체 출력 스트림 얻기
		PrintWriter out = null;
		try {
			out = resp.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 1. 파일업로드 형태가 데이터가 맞는지 검사
		// 요청메시지 Content-Type이 multpart/form-data 가 맞는지 확인한다
		boolean isMultipart = false;
		isMultipart = ServletFileUpload.isMultipartContent(req);

		// 1-1. multipart/form-data 인코딩으로 전송되지 않았을 경우
		// 처리 중단하기
		if (!isMultipart) {
			out.append("<h1>enctype이 multipart/form-data가 아닙니다</h1>");
			out.append("<a href='/commons/fileupload'>업로드페이지로 이동</a>");

			return; // fileupload() 메소드 중단시키기
		}

		// 1-2. 여기 이후부터는 multipart/form-data로 요청된 상황
		// 파일이 전송되었음. 정상적인 흐름으로 처리

		// 2. 업로드된 파일을 처리하는 아이템팩토리 객체 생성

		// ItemFactory : 업로드된 데이터(FileItem)를 처리하는 방식을
		// 설정하는 클래스

		// FileItem : 클라이언트로부터 전송된 데이터를 객체화시킨 것

		// DiskFileItemFactory class
		// -> 디스크(HDD) 기반의 파일아이템 처리 API
		// -> 업로드된 파일을 디스크(HDD)에 임시 저장하고 나중에 처리한다
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 3. 업로드된 파일아이템의 용량이 적당히 작으면 메모리에서
		// 하도록 설정
		int maxMem = 1 * 1024 * 1024; // 1MB
		factory.setSizeThreshold(maxMem);

		// 4. 용량이 적당히 크면 임시파일(HDD) 만들어서 처리하도록 설정
		// -> 임시파일 폴더 설정

		ServletContext context = req.getServletContext();
		String path = context.getRealPath("tmp");

		File repository = new File(path); // 임시 저장 폴더
		System.out.println("repository : " + repository); // 경로 TEST

		factory.setRepository(repository);

		// 5. 업로드 허용 용량 기준을 넘지 않을 경우에만 파일업로드
		// 처리되도록 설정
		// -> 기준을 넘으면 업로드 차단됨
		int maxFile = 10 * 1024 * 1024; // 10MB

		// 파일업로드 수행 객체 생성
		// DiskFileItemFactory 객체 이용해서 생성함
		ServletFileUpload upload = new ServletFileUpload(factory);

		// 파일 업로드 용량제한 설정 : 10MB
		upload.setFileSizeMax(maxFile);

		// ------------------ 파일 업로드 준비 완료 ------------------

		// 6. 업로드된 데이터 추출(파싱)
		// 임시 파일 업로드도 같이 수행된다

		List<FileItem> items = null;
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		// 7. 파싱된 요청정보 데이터 처리하기
		// items 리스트에 요청파라미터(파일 포함)이 파싱되어 들어있음

		// 요청정보의 3가지 형태
		// 1. 빈 파일 (용량이 0인 파일)
		// 2. form-data (전달 파라미터)
		// 3. 파일

		// 파일아이템 반복자
		Iterator<FileItem> iter = items.iterator();

		// 모든 요청정보 처리하는 반복문
		while (iter.hasNext()) {

			// 요청 정보 객체
			FileItem item = iter.next();

			// 1) 빈 파일에 대한 처리
			if (item.getSize() <= 0)
				continue;

			// 2) 기본 전달 파라미터에 대한 처리
			if (item.isFormField()) {

				// ------------------ 파라미터 처리 개요 -------------------

				// form-data (form field) 는 key=value 쌍으로 전달됨

				// key는 item.getFieldName() 으로 얻어옴
				// value는 item.getString() 으로 얻어옴

				// ** 전달값이 한글일 경우 인코딩 설정 방법
				// item.getString("UTF-8") 을 사용한다

				// ** req.setCharacterEncoding("UTF-8") 이 적용되지 않는다

				// ---------------------------------------------------------

				// ------------------ 기본 처리 방식 -----------------------

//				out.println("- - - 폼필드 - - -<br>");
//				out.println(" 키 : " + item.getFieldName() + "<br>");
//				try {
//					out.println(" 값 : " + item.getString("UTF-8") + "<br>");
//				} catch (UnsupportedEncodingException e) {
//					e.printStackTrace();
//				}

				// ---------------------------------------------------------

				// ------------- 키 값에 따라 처리하는 방식 ----------------

				// 키값 꺼내기
				String key = item.getFieldName();

				if ("title".equals(key)) { // 전달파라미터 name이 "title"
					try {
						paramData.setTitle(item.getString("UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}

				} else if ("data1".equals(key)) { // 전달파라미터 name이 "data1"
					try {
						paramData.setData1(item.getString("UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}

				} else if ("data2".equals(key)) { // 전달파라미터 name이 "data2"
					try {
						paramData.setData2(item.getString("UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}

				}
				// ---------------------------------------------------------

			} // if( item.isFormField() ) end

			// 3) 파일에 대한 처리
			if (!item.isFormField()) {

				// 업로드된 파일을 처리하는 방식
				// 1) 파일을 웹 서버의 로컬 디스크에 저장
				// 파일의 정보를 DB에 기록해야한다

				// 2) 테이블의 컬럼으로 파일의 내용을 저장
				// BLOB 타입을 사용한다

				// 1번방식을 사용할 예정

				// ---------------------------------------------

				// 서버에 저장되는 파일명을
				// "년월일시분초밀리초.확장자" 로 변경하기

				// 파일명 - 년월일시분초밀리초
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssS");
				String rename = sdf.format(new Date());

				// 확장자
				String origin = item.getName(); // 원본파일명
				String ext = origin.substring(origin.lastIndexOf(".") + 1);

				// 저장될 이름
				String stored = rename + "." + ext;

				System.out.println("[TEST] stored file name : " + stored);

				// ----- DB에 업로드된 파일에 대한 정보 기록하기 -----
				FileUpload uploadFile = new FileUpload();

				uploadFile.setOriginName(origin);
				uploadFile.setStoredName(stored);

				System.out.println(uploadFile);

				// DB에 기록하기
				fileDao.insert(uploadFile);
				// ---------------------------------------------------

				// 실제 업로드 파일
				File up = new File(context.getRealPath("upload") // 업로드될 폴더
//						, item.getName() //원본 파일의 이름
						, stored // 저장 파일의 이름(변환됨)
				);

				try {
					item.write(up); // 실제 업로드(최종 결과 파일 생성)
					item.delete(); // 임시 파일 삭제

				} catch (Exception e) {
					e.printStackTrace();
				}

			} // if( !item.isFormField() ) end

		} // while( iter.hasNext() ) end

		// 전달파라미터 저장한 DTO 확인
		System.out.println(paramData);

	}

	@Override
	public List<FileUpload> list() {

		// DAO를 통해 테이블 전체 내용(행)을 조회해서 반환하기
		return fileDao.selectAll();
	}

	@Override
	public int insertFile(FileUpload up) {

		// DB 연결 객체
		Connection conn = JDBCTemplate.getConnection();

		// DAO 를 통해 Insert 수행
		int result = fileDao.insertFile(conn, up);

		if (result > 0) {
			// 성공
			JDBCTemplate.commit(conn);
		} else {
			// 실패
			JDBCTemplate.rollback(conn);
		}

		return result;
	}

}
