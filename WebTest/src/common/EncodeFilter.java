package common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodeFilter implements Filter {

	// 인코딩 설정값 멤버변수
	private String charset = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 필터 클래스 초기화
		System.out.println("초기화 확인중");
		
		charset = filterConfig.getInitParameter("enc");
	
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// 요청 전, 후 필터링 처리
		System.out.println("doFilter 호출 전");
		
		// 한글 인코딩 설정하기
		// 1. POST 요청 정보 인코딩 설정
			request.setCharacterEncoding(charset);
			
		// 2. 응답데이터 ContentType 설정
			response.setCharacterEncoding("text/html;charset=" + charset);
		
		// 컨트롤러로 요청처리를 보내는 코드
		chain.doFilter(request, response);

		System.out.println("doFilter 호출 후");
		

	}

}
