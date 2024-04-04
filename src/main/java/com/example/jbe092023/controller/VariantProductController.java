package com.example.jbe092023.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jbe092023.exception.ProductDetailNotFound;
import com.example.jbe092023.exception.ValidateException;
import com.example.jbe092023.model.VariantProduct;
import com.example.jbe092023.response.ProductDetailResponseDTO;
import com.example.jbe092023.service.VariantProductService;
import com.example.jbe092023.utils.ResponseCode;

@RestController
@RequestMapping(path="/productdetails")
public class VariantProductController {
	@Autowired
	private VariantProductService variantProductService;
	
	@GetMapping(path="")
	public List<VariantProduct> getAll(){
		return this.variantProductService.getAll();
	}
	
	@GetMapping(path="/findByProductId/{id}")
	public List<VariantProduct> getAll(@PathVariable(name = "id")Integer id){
			if(id!=null) {
				return variantProductService.findAllByProductId(id);
			}
		return this.variantProductService.getAll();
	}
	
	
	@GetMapping(path="/findById")
	public ResponseEntity<?> getByRequestParam(@RequestParam(name = "id")int id){
		try {
			VariantProduct foundProduct = variantProductService.findById(id);
			return BaseResponseController.success(new ProductDetailResponseDTO(foundProduct));
		} catch (ProductDetailNotFound e) {
			return BaseResponseController.fail(ResponseCode.PRODUCT_DETAIL_NOT_FOUND.getCode(),
					ResponseCode.PRODUCT_DETAIL_NOT_FOUND.getMessage());
		} catch (ValidateException e) {
				return BaseResponseController.fail(ResponseCode.VALIDATION_EXCEPTION.getCode(), e.getMessage());
		}
	}

	@PostMapping("")
	public VariantProduct addProductDetails(@RequestBody VariantProduct variantProduct) {
		return variantProductService.saveDetail(variantProduct);
	}
	
	
}
