package com.employeePortalApp.employeePortal.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Employee {

	@Id
	private int id;
	
	private String fName;

    private String lName;

    private String gender;

    private String dob;

    private String department;
    
	public Employee() {
		super();
	}
	
	public Employee(int id, String fName, String lName, String gender, String dob, String department) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.gender = gender;
		this.dob = dob;
		this.department = department;
	}

	@JsonProperty(value = "Id")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@JsonProperty(value = "FName")
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	@JsonProperty(value = "LName")
	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	@JsonProperty(value = "Gender")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@JsonProperty(value = "Dob")
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@JsonProperty(value = "Department")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
}
