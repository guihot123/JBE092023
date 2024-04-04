package com.example.jbe092023.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.jbe092023.exception.ProductNotFound;
import com.example.jbe092023.exception.ValidateException;
import com.example.jbe092023.model.Product;
import com.example.jbe092023.repository.ProductRepository;


@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAll(){
		return this.productRepository.findAll();
	}
	
	public Product saveProduct(Product product) {
		return this.productRepository.save(product);
	}
	
	public List<Product> findByCategoryId(Integer id,Pageable pageable)throws ProductNotFound,ValidateException{
		if (Objects.isNull(id)) {
			throw new ValidateException("name cannot be null");
		}

		if (id==null) {
			return productRepository.findAll(pageable).stream().map(x -> x).toList();
		}
		return productRepository.findByCategoryId(id,pageable);

	}
}
