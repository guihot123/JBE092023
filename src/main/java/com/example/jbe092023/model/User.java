package com.example.jbe092023.model;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Table_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(name="col_username",unique = true,nullable = false)
	private String username;
	
	@Column(name="col_password")
	private String password;
	
	@Column(name="col_fullName")
	private String fullName;
	
	@Column(name="col_email",unique = true)
	private String email;
	
	@OneToMany(mappedBy = "users")
	private List<UserRole> userroles = new ArrayList<UserRole>();
	
	@OneToMany(mappedBy = "users")
	private List<Address> address = new ArrayList<Address>();
	
	@OneToMany(mappedBy = "users")
	private List<Cart> carts  = new ArrayList<Cart>();
	
}
