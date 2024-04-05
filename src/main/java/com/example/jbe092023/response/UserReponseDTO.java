package com.example.jbe092023.response;

import com.example.jbe092023.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReponseDTO {
	private Integer id;
	private String fullName;
	private String userName;
	private String email;
	private Boolean isOnline;
	private String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(Boolean isOnline) {
		this.isOnline = isOnline;
	}
	public UserReponseDTO (User user) {
		this.id=user.getUserId();
		this.email=user.getEmail();
		this.fullName=user.getFullName();
		this.isOnline=user.getIsOnline();
		this.userName=user.getUsername();
		this.password=user.getPassword();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
