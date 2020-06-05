package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	private String charset = null;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		charset = filterConfig.getInitParameter("encoding");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// Post 처리시에만
		
		request.setCharacterEncoding(charset);

		response.setCharacterEncoding("text/html;charset=" + charset);

		chain.doFilter(request, response);

	}

}
