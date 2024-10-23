package com.app.dto;

import jakarta.validation.constraints.NotEmpty;

public class LoginRequest {
	@NotEmpty(message="customer id cannot be blank")
 private String customerId;
	@NotEmpty(message="password cannot be blank")
 private String password;
 public LoginRequest() {
	
}
public LoginRequest(String customerId, String password) {
	super();
	this.customerId = customerId;
	this.password = password;
}
public String getCustomerId() {
	return customerId;
}
public void setCustomerId(String customerId) {
	this.customerId = customerId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "LoginRequest [customerId=" + customerId + ", password=" + password + "]";
}
 
 
}
