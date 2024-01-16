package com.study.servlet_study.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletResponse;

/*	filter 전처리 / 후처리
 *  요청 -> 전처리 filter -> doGet() 메서드 -> 후처리 filter -> response()
 */

@WebFilter("/*")
public class ResponseCharactorEncodingFilter extends HttpFilter implements Filter {

	public void destroy() {

	}

	// doGet은 ServletRequest 의 하위인 HttpServletRequest객체를 받음
	// 업캐스팅 되어 들어온 HttpServletRequest/HttpServletResponse 다운캐스팅 되어야 함
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse httpResponse = (HttpServletResponse) response;

		httpResponse.setCharacterEncoding("utf-8"); // charset 지정

		// chain -> 전처리 이후 데이터를 넘길 경로를 지정
		// chain.doFilter 전이 전 처리 영역 / 이후가 후 처리 영역
		// 메소드가 호출되면 servlet이 작동하고 닫히기 때문
		chain.doFilter(request, response);
//		httpResponse.getWriter().println("무조건 후처리함");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
