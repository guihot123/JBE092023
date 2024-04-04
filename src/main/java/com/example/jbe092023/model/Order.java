package com.example.jbe092023.model;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="table_orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	@Column(name="col_address")
	private String address;
	
	@Column(name="col_delivertTime")
	private Timestamp deliveryTime;
	
	@Column(name="col_total")
	private Float totalPrice;
	
	@OneToMany(mappedBy = "orders")
	private List<CartLine_Item> cartdetails = new ArrayList<CartLine_Item>();
}
