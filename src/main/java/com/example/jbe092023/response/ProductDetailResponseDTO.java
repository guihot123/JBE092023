package com.example.jbe092023.response;

import java.util.Objects;

import com.example.jbe092023.model.Product;
import com.example.jbe092023.model.VariantProduct;

import lombok.Data;

@Data
public class ProductDetailResponseDTO {
	private Integer id;
	private String size;
	private String model;
	private Float price;
	private Integer productId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public ProductDetailResponseDTO(VariantProduct productDetails) {
		this.id=productDetails.getVariant_productId();
		this.model=productDetails.getModel();
		this.price=productDetails.getPrice();
		this.size=productDetails.getSize();
		Product products = productDetails.getProducts();
		if(Objects.nonNull(products)) {
			this.productId=products.getProductId();
		}
	}
}
