package com.example.jbe092023.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jbe092023.exception.ProductNotFound;
import com.example.jbe092023.exception.ValidateException;
import com.example.jbe092023.model.Product;
import com.example.jbe092023.service.ProductService;
import com.example.jbe092023.utils.ResponseCode;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path="/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(path = "/hello") // /users/hello
	public String hello() {
		return "Hello, World!";
	}
	
	@GetMapping(path="")
	public List<Product> getAll(){
		return this.productService.getAll();
	}
	
	@GetMapping(path="/findByCategoryId")
	public ResponseEntity findByCategoryId(@RequestParam(name="id",required = false ,defaultValue = "") Integer id,
			Pageable pageable) {
		try {
			return BaseResponseController.success(productService.findByCategoryId(id, pageable));
		} catch (ValidateException e) {
			return BaseResponseController.fail(ResponseCode.VALIDATION_EXCEPTION.getCode(), "invalid sort params");
		} catch (ProductNotFound e) {
			return BaseResponseController.fail(ResponseCode.PRODUCT_DETAIL_NOT_FOUND.getCode(), "cant find product");
		}	
	}
	
	@PostMapping("")
	public Product addProduct(@RequestBody Product product) {
		return this.productService.saveProduct(product);
	}
	
	
	
}
