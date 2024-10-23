package com.app.pojos;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="employees")
public class Employee extends BaseEntity{
	//validation annotation relations:1)In EmployeeController for put and get methods @ valid
	                  //   2)GlobalExceptionHandler
	                  //   3)Error response dto
	
	//server side validation for payload coming from frontend
	//presentation logic validations
	
@NotEmpty(message=" First Name cannot be blank")
@Length(min = 4, max=20, message="Invalid First Name length!!!!")
@Column(length = 30)
private String name;
@Column(length = 20,unique=true)
@NotEmpty(message=" Last Name cannot be blank")
@Length(min = 4, max=20, message="Invalid Last Name length!!!!")
private String lastName;
@NotEmpty(message=" Location must be supplied")
private String location;
@Column(length = 30)
@NotEmpty(message=" Department must be supplied")
@JsonProperty("department")   //to tell SpringBoot while marshalling json key name should be department.
private String dept;
@NotNull(message=" salary must be supplied")
@Min(value=10000, message=" salary < min salary")
@Max(value=50000, message=" salary > max salary")
private double salary;
@Future(message =" Join Date must be in future....")
private LocalDate joinDate;
  public Employee() {
	// TODO Auto-generated constructor stub
}

public Employee(String name, String location, String dept) {
	super();
	this.name = name;
	this.location = location;
	this.dept = dept;
}



public Employee(String name, String lastName) {
	super();
	this.name = name;
	this.lastName = lastName;
}

public Employee(String name, String lastName, String location, String dept, double salary, LocalDate joinDate) {
	super();
	this.name = name;
	this.lastName = lastName;
	this.location = location;
	this.dept = dept;
	this.salary = salary;
	this.joinDate = joinDate;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public String getDept() {
	return dept;
}

public void setDept(String dept) {
	this.dept = dept;
}

public double getSalary() {
	return salary;
}

public void setSalary(double salary) {
	this.salary = salary;
}

public LocalDate getJoinDate() {
	return joinDate;
}

public void setJoinDate(LocalDate joinDate) {
	this.joinDate = joinDate;
}

@Override
public String toString() {
	return "Employee [name=" + name + ", lastName=" + lastName + ", location=" + location + ", dept=" + dept
			+ ", salary=" + salary + ", joinDate=" + joinDate + "]";
}


  
}
