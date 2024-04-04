package com.example.jbe092023.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Table_roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
	
	@Id
	private int roleId;
	
	@Column(name="col_namerole")
	private String name;
	
	@Column
	private String description;
	
	@OneToMany(mappedBy = "roles")
	private List<UserRole> userroles = new ArrayList<UserRole>();
	
}
