package com.study.servlet_study.survlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// URL입력시 요청받아 실행되는 메소드는 무조건 GET
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("요청이 들어옴!!!");
		System.out.println(request.getMethod());
		System.out.println(request.getRequestURL()); // 풀 주소 가져옴
		System.out.println(request.getRequestURI()); // 서버주소 빼고 다가져옴
		System.out.println(response.getStatus()); // 상태코드 출력

		response.setContentType("text/plain"); // 응답하는 타입지정 - 보통 JSON사용
		System.out.println(response.getContentType());

		response.getWriter().println("ㅎㅇ");

	}

}
