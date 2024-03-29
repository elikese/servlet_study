package com.study.servlet_study.survlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.servlet_study.utils.ParamsConverter;

@WebServlet("/http")
public class HttpStudyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 생성자
	public HttpStudyServlet() {
		super();
	}

	// HTTP method()
	// POST요청 -> Crate(추가) : C가 Server에 request -> server가 DB에 저장
	// GET요청 -> Read(조회)
	// PUT요청 -> UPDATE(수정)
	// DELETE요청 -> Delete(삭제)

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request해서 get한 정보들은 String으로 들어온다
		// Map 하나로 모든 정보를 얻을 수 있음
		Map<String, String> paramsMap = ParamsConverter.convertParamsMapToMap(request.getParameterMap());

		System.out.println(paramsMap);

		Map<String, String> paramsMap2 = new HashMap();

		Iterator<String> ir = request.getParameterNames().asIterator();
		while (ir.hasNext()) {
			String key = ir.next();
			paramsMap2.put(key, request.getParameter(key));
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> paramsMap = new HashMap();

		request.getParameterMap().forEach((k, v) -> {
			StringBuilder builder = new StringBuilder();
			Arrays.asList(v).forEach(value -> builder.append(value));
			paramsMap.put(k, builder.toString());
		});

		System.out.println(paramsMap);

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
