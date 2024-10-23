package com.app.dto;

import com.app.pojos.AcctType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CreateAccountRequest {
// property name :we can write any property name
	//may or may not be same as pojo properties
	
	//validations: for string not empty; for non string : not null
	@NotEmpty(message="customer id must be supplied")
	private String custId;
	@NotNull(message="account type must be supplied")
	private AcctType type;
	@Min(value=5000, message="min balance must be>5000")
	private double balance;
	
	public CreateAccountRequest() {
		
	}
	public CreateAccountRequest(String custId, AcctType type, double balance) {
		super();
		this.custId = custId;
		this.type = type;
		this.balance = balance;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public AcctType getType() {
		return type;
	}
	public void setType(AcctType type) {
		this.type = type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "CreateAccountRequest [custId=" + custId + ", type=" + type + ", balance=" + balance + "]";
	}
	//note: hashcode and equals is needed only if we are adding it in hashing based data structure
}
