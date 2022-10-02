package com.mgnrega.exicute;

import java.util.Scanner;

import com.mgnrega.been.BDO;
import com.mgnrega.been.GPM;
import com.mgnrega.been.Project;
import com.mgnrega.dao.MGNREGA;
import com.mgnrega.dao.MGNREGAimp;
import com.mgnrega.exception.BDOException;
import com.mgnrega.exception.GPMException;
import com.mgnrega.exception.ProjectException;

public class ExicutionClass {

	Scanner sc = new Scanner(System.in);
	public  void loginBDO()
	{
		
		System.out.println("Enter username ");
		String username=sc.next();
		System.out.println("Enter password");
		String pass=sc.next();
		
		MGNREGA dao= new MGNREGAimp();
		
		
		try {
			
			BDO bdo = dao.loginbdo(username, pass);
			System.out.println("welcome "+bdo.getUsername());
			
		} catch (BDOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void loginGPM() {
		System.out.println("Enter username");
		String name=sc.next();
		System.out.println("enter password");
		String pass=sc.next();
		
		MGNREGA obj=new MGNREGAimp();
		try {
			GPM gpm=obj.loginGPM(name, pass);
			System.out.println("welcome "+gpm.getName());
		} catch (GPMException e) {
			
			System.out.println(e.getMessage());
		}
		
	}
	
	public void addgpmtoproject()
	{
		System.out.println("Enter id of project");
		int pid=sc.nextInt();
		System.out.println("Enter id of Gram Panchayet member");
		int gpmid=sc.nextInt();
		MGNREGA obj = new MGNREGAimp();
		try {
		String massage=	obj.allocateprojecttoGPM(pid, gpmid);
		System.out.println(massage);
		} catch (ProjectException | GPMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createproject()
	{
		
		System.out.println("Enter Name of Project");
		String name=sc.next();
		System.out.println("Enter no of Employee required for this Oroject");
		int no=sc.nextInt();
		System.out.println("Enter total budget for this Project");
		String amount=sc.next();
		MGNREGA obj=new MGNREGAimp();
		Project project=new Project();
		project.setName(name);
		project.setNoOfEmployee(no);
		project.setTotalWages(amount);
		String massage=	obj.createproject(project);
	}
	
	
	
	public static void main(String[] args )
	{
		
	}
}
