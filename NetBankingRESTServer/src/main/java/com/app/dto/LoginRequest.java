package com.app.dto;

public class LoginRequest {
 private String customerId;
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
