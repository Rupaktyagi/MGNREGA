package com.mgnrega.been;

public class Project {

	private int id;
	private String name;
	private int noOfEmployee;
	private String totalWages;
	public Project(int id, String name, int noOfEmployee, String totalWages) {
		super();
		this.id = id;
		this.name = name;
		this.noOfEmployee = noOfEmployee;
		this.totalWages = totalWages;
	}
	
	public Project() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", noOfEmployee=" + noOfEmployee + ", totalWages=" + totalWages
				+ "]";
	}
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
	public int getNoOfEmployee() {
		return noOfEmployee;
	}
	public void setNoOfEmployee(int noOfEmployee) {
		this.noOfEmployee = noOfEmployee;
	}
	public String getTotalWages() {
		return totalWages;
	}
	public void setTotalWages(String totalWages) {
		this.totalWages = totalWages;
	}
}
