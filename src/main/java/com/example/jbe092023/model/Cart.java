package com.example.jbe092023.model;

import java.util.ArrayList;
import java.util.Date;
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
import lombok.Data;

@Entity
@Table(name="table_carts")
@Data
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartId;
	
	@Column(name="col_createdDate")
	private Date createdDate; 
	
	@ManyToOne
	@JoinColumn(name = "user_id",referencedColumnName = "userId")
	private User users;
	
	@OneToMany(mappedBy = "carts")
	private List<CartLine_Item> cartdetails = new ArrayList<CartLine_Item>();
}
