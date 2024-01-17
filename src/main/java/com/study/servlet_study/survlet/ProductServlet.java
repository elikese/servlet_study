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
		response.setStatus(200);
		response.getWriter().println(product);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productName = request.getParameter("productName");
		String price = request.getParameter("price");
		String size = request.getParameter("size");
		String color = request.getParameter("color");

		Product product = Product.builder().productName(productName).price(price).size(size).color(color).build();
		int body = productservice.addProduct(product);

		switch (body) {

		case 0:
			response.setStatus(400);
			response.getWriter().print(body);
			break;

		case 1:
			response.setStatus(201);
			response.getWriter().print(body);
			break;
		}
	}
}
