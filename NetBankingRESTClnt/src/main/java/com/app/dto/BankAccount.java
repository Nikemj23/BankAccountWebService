package com.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BankAccount  {
	
	private AcctType accType;
	private double balance;
	
	@JsonIgnore// to tell jackson (=vendor for marshalling n un marshalling), to ignore this property during serialization n de-serialization
	
	private Customer acctOwner;
	
	public BankAccount() {
		// TODO Auto-generated constructor stub
	}
	
	public BankAccount(AcctType accType, double balance) {
		super();
		this.accType = accType;
		this.balance = balance;	
	}
	

	public AcctType getAccType() {
		return accType;
	}


	public void setAccType(AcctType accType) {
		this.accType = accType;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public Customer getAcctOwner() {
		return acctOwner;
	}


	public void setAcctOwner(Customer acctOwner) {
		this.acctOwner = acctOwner;
	}


	@Override
	public String toString() {
		return "BankAccount [accType=" + accType + ", balance=" + balance + "]";
	}
	
	

}
