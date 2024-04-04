package com.example.jbe092023.utils;

public enum ResponseCode {

	SUCCESS("success", "success"), 
	USER_ALREADY_EXISTS("user.exists", "user already exists"),
	VALIDATION_EXCEPTION("validation", null),
	USER_NOT_FOUND("user.notfound", "user not found"),
	PRODUCT_NOT_FOUND("product.notfound","product not found"),
	PRODUCT_DETAIL_NOT_FOUND("product.notfound","product not found");
	
	private String code;
	private String message;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	ResponseCode(String string, String string2) {

	}
	
}
