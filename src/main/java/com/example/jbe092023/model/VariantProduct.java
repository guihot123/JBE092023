package com.example.jbe092023.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Table_variantProducts")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class VariantProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer variant_productId;
	
	@Column(name="col_color")
	private String color;
	
	@Column(name="col_size")
	private String size;
	
	@Column(name="col_model")
	private String model;
	
	@Column(name="col_price")
	private Float price;
	
	@ManyToOne
	@JoinColumn(name="productId",referencedColumnName = "productId",nullable = false)
	private Product products;
	
	@OneToMany(mappedBy = "productDetails")
	private List<CartLine_Item> cartdetails = new ArrayList<CartLine_Item>();

	public Integer getVariant_productId() {
		return variant_productId;
	}

	public void setVariant_productId(Integer variant_productId) {
		this.variant_productId = variant_productId;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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

	public Product getProducts() {
		return products;
	}

	public void setProducts(Product products) {
		this.products = products;
	}
	
	
}
