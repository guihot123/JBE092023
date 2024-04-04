package com.example.jbe092023.model;

import java.util.Date;

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
@Table(name="table_authorizations")
public class UserRole {
	@EmbeddedId
	private UserRoleId id;
	
	@ManyToOne
	@MapsId(value="user_id")
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	private User users;
	
	@ManyToOne
	@MapsId(value = "role_id")
	@JoinColumn(name = "role_id", referencedColumnName = "roleId")
	private Role roles;
	
	@Column(name="issued_date")
	private Date issuedDate;
}

@Embeddable
@Data
class UserRoleId{
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="role_id")
	private Integer roleId;
}