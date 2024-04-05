package com.example.jbe092023.request;

import com.example.jbe092023.model.User;

import lombok.Data;

@Data
public class UserRequestDTO {
	private String fullName;
	private String userName;
	private String passWord;
	private String email;
	
	public User toUser() {
		User user = new User();
		user.setFullName(this.fullName);
		user.setUsername(this.userName);
		user.setPassword(this.passWord);
		user.setEmail(this.email);
		
		return user;
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

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
}
