package com.app.pojos;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
@Entity
@Table(name="bank_customers")
public class Customer {
@NotBlank(message="Customer ID is required")
@Id
@Column
private String customerId;

@NotBlank(message="Name is required")
@Length(min=3, max=15, message="Invalid length of name")
@Column(length=20)
private String name;

@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message = "Blank or Invalid Password")
@Column(length=20, nullable=false)
private String password;

public Customer() {
	// TODO Auto-generated constructor stub
}
public Customer(@NotBlank(message = "Customer ID is required") String customerId,
		@NotBlank(message = "Name is required") String name, String password) {
	super();
	this.customerId = customerId;
	this.name = name;
	this.password = password;
}

public String getCustomerId() {
	return customerId;
}

public void setCustomerId(String customerId) {
	this.customerId = customerId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
public String toString() {
	return "Customer [customerId=" + customerId + ", name=" + name + ", password=" + password + "]";
}



}
