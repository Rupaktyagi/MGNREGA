package com.mgnrega.been;

public class ListofEmployeeUnderProject {

	private String empname;
	private String pname;
	private int amount;
	public ListofEmployeeUnderProject(String empname, String pname, int amount) {
		super();
		this.empname = empname;
		this.pname = pname;
		this.amount = amount;
	}
	public ListofEmployeeUnderProject() {
		// TODO Auto-generated constructor stub
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
