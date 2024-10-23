package com.app.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="bank_accounts")
public class BankAccount extends BaseEntity {
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private AcctType accType;
	private double balance;
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore// to tell jackson (=vendor for marshalling n un marshalling), to ignore this property during serialization n de-serialization
	@JoinColumn(name="cust_id")
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
