package com.cg.springboot.bean;

public class Student {

	private int id;
	private String firstName;
	private String lastName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstName;
	}
	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}
	public String getLastname() {
		return lastName;
	}
	public void setLastname(String lastname) {
		this.lastName = lastname;
	}
	public Student(int id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstName = firstname;
		this.lastName = lastname;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
