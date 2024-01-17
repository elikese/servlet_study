package com.study.servlet_study.survlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.servlet_study.entity.Product;
import com.study.servlet_study.service.ProductService;

@WebServlet("/Product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productservice;

	public ProductServlet() {
		super();
		productservice = ProductService.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productName = request.getParameter("productName");
		Product product = productservice.getProduct(productName);
		response.setStatus(200); // 200 201 203 301 302 400 401 403 404 405 415 423 500
		response.getWriter().println(product);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int price = 0;

		try {
			price = Integer.parseInt(request.getParameter("price"));
		} catch (NumberFormatException e) {
			response.setStatus(400);
			response.getWriter().println("숫자만 입력하세요");
			return;
		}

		Product product = Product.builder().productName(request.getParameter("productName")).price(price)
				.size(request.getParameter("size")).color(request.getParameter("color")).build();

		if (productservice.getProduct(product.getProductName()) != null) {
			response.setStatus(400);
			response.getWriter().println("이미 등록된 상품 입니다.");
			return;
		}

		int body = productservice.addProduct(product);

		switch (body) {

		case 0:
			response.setStatus(400);
			response.getWriter().println(body);
			break;

		case 1:
			response.setStatus(201);
			response.getWriter().println("상품등록이 완료되었습니다");
			break;
		}
	}
}
