package com.example.jbe092023.model;

import java.security.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="table_cartdetails")
public class CartLine_Item {
	@EmbeddedId
	private CartOrderId id;
	
	@ManyToOne
	@MapsId(value="variant_productId")
	@JoinColumn(name = "variant_productId", referencedColumnName = "variant_productId",nullable = false)
	private VariantProduct productDetails;
	
	@ManyToOne
	@MapsId(value = "cart_id")
	@JoinColumn(name = "cart_id", referencedColumnName = "cartId",nullable = false)
	private Cart carts;
	
	@Column(name="col_quantity")
	private Integer quantity;
	
	@Column(name="col_total")
	private Float totalPrice;
	
	@Column( name = "col_added")
	private Timestamp addedDate;
	
	@Column(name="col_isDeleted")
	private Boolean isDeleted;
	
	@ManyToOne
	@JoinColumn(name="order_Id",referencedColumnName = "orderId",nullable = false)
	private Order orders;
}
@Embeddable
@Data
class CartOrderId{
	@Column(name="variant_productId")
	private Integer variantproductId;
	
	@Column(name="cart_id")
	private Integer cartId;
}