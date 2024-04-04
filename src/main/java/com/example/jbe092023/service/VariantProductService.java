package com.example.jbe092023.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jbe092023.exception.ProductDetailNotFound;
import com.example.jbe092023.exception.ValidateException;
import com.example.jbe092023.model.VariantProduct;
import com.example.jbe092023.repository.VariantProductRepository;


@Service
public class VariantProductService {
	@Autowired
	private VariantProductRepository variantproductrepository;
	
	public List<VariantProduct> getAll(){
		return this.variantproductrepository.findAll();
	}
	
	public VariantProduct saveDetail(VariantProduct variantProduct) {
		return this.variantproductrepository.save(variantProduct);
	}
	
	public List<VariantProduct> findAllByProductId(Integer id){
		if(id!=null) {
			return this.variantproductrepository.findAllByProductId(id);
		}
		return this.variantproductrepository.findAll();
	}
	
	public VariantProduct findById(Integer id) throws ValidateException,ProductDetailNotFound {
		Optional<VariantProduct> foundproduct = this.variantproductrepository.findById(id);
		if (Objects.isNull(id) || id <= 0) {
			throw new ValidateException("user.id must be positive");
		}
		if(foundproduct.isEmpty()) {
			throw new ProductDetailNotFound();
		}
		return foundproduct.get();
	}
}
