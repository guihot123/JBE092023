package com.example.jbe092023.response;

import java.util.Objects;

import com.example.jbe092023.model.Category;
import com.example.jbe092023.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponseDTO {
	private Integer id;
	private String name;
	private Integer category_id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public ProductResponseDTO(Product product) {
		this.id=product.getProductId();
		this.name=product.getName();
		Category category=product.getCategories();
		if(Objects.nonNull(category)) {
			this.category_id=category.getCategoryId();
		}
	}
}
