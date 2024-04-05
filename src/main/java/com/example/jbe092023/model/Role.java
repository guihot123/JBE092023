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

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<UserRole> getUserroles() {
		return userroles;
	}

	public void setUserroles(List<UserRole> userroles) {
		this.userroles = userroles;
	}
	
	
	
}
