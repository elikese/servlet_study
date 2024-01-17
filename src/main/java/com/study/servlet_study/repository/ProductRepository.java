package com.study.servlet_study.repository;

import java.util.ArrayList;
import java.util.List;

import com.study.servlet_study.entity.Product;

public class ProductRepository {

	private List<Product> productList;
	private static ProductRepository instance;

	private ProductRepository() {
		productList = new ArrayList<>();
	}

	public static ProductRepository getInstance() {
		if (instance == null) {
			instance = new ProductRepository();
		}
		return instance;
	}

	public int saveProduct(Product product) {
		if (isSameProductName(product)) {
			return 0;
		}
		productList.add(product);
		return 1;
	}

	public boolean isSameProductName(Product product) {
		for (Product a : productList) {
			if (a.getProductName().equals(product.getProductName())) {
				return true;
			}
		}
		return false;
	}

	public Product findProductByProductName(String productName) {
		Product findProduct = null;
		for (Product product : productList) {
			if (product.getProductName().equals(productName)) {
				findProduct = product;
				break;
			}
		}
		return findProduct;
	}
}
