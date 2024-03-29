package com.study.servlet_study.filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class RequestCharactorEncodingFilter extends HttpFilter implements Filter {
	public RequestCharactorEncodingFilter() {
		super();
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;

		String[] methods = new String[] { "POST", "PUT" };

		if (Arrays.asList(methods).contains(httpRequest.getMethod())) {
			httpRequest.setCharacterEncoding("utf-8");
		}

		System.out.println("요청된 메서드 : " + httpRequest.getMethod() // getMethod()는 대문자로 리턴됨
				.toUpperCase()); // toUpperCase() 소문자도 대문자로 연산해서 리턴해준다

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
