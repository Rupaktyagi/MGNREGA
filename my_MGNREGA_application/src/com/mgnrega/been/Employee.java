package com.mgnrega.been;

public class Employee {

	private int id;
	private String name;
	private String address;
	private String phone;
	private int no_of_days;
	private int wages;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String name, String address, String phone, int no_of_days, int wages) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.no_of_days = no_of_days;
		this.wages = wages;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getNo_of_days() {
		return no_of_days;
	}
	public void setNo_of_days(int no_of_days) {
		this.no_of_days = no_of_days;
	}
	public int getWages() {
		return wages;
	}
	public void setWages(int wages) {
		this.wages = wages;
	}
}
