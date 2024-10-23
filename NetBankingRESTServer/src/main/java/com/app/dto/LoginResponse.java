package com.app.dto;

import java.util.List;

import com.app.pojos.BankAccount;

public class LoginResponse {
 private String customerName;
 private List<BankAccount> accounts;
 
 public LoginResponse() {
	// TODO Auto-generated constructor stub
}

public LoginResponse(String customerName, List<BankAccount> accounts) {
	super();
	this.customerName = customerName;
	this.accounts = accounts;
}

public String getCustomerName() {
	return customerName;
}

public void setCustomerName(String customerName) {
	this.customerName = customerName;
}

public List<BankAccount> getAccounts() {
	return accounts;
}

public void setAccounts(List<BankAccount> accounts) {
	this.accounts = accounts;
}

@Override
public String toString() {
	return "LoginResponse [customerName=" + customerName + "]";
}
 
 
}
