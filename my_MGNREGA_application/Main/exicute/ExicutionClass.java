package com.mgnrega.exicute;

import java.util.List;
import java.util.Scanner;

import com.mgnrega.been.BDO;
import com.mgnrega.been.Employee;
import com.mgnrega.been.GPM;
import com.mgnrega.been.ListofEmployeeUnderProject;
import com.mgnrega.been.Project;
import com.mgnrega.dao.MGNREGA;
import com.mgnrega.dao.MGNREGAimp;
import com.mgnrega.exception.BDOException;
import com.mgnrega.exception.EmployeeException;
import com.mgnrega.exception.GPMException;
import com.mgnrega.exception.ProjectException;

public class ExicutionClass {

	 
	public static  boolean loginBDO()
	{
		Scanner sc = new Scanner(System.in);
		boolean s=false;
		System.out.println("Enter username ");
		String username=sc.next();
		System.out.println("Enter password");
		String pass=sc.next();
		MGNREGA dao= new MGNREGAimp();
		try {
			BDO bdo=null;
			 bdo = dao.loginbdo(username, pass);
			
			if(bdo!=null)
			{
				s=true;
			}
			System.out.println("");
			System.out.println("");
			System.out.println("          :::::   welcome   :::::");
			System.out.println(" ");
			System.out.println("                  "+bdo.getUsername());
			
		} catch (BDOException e) {
			System.out.println(e.getMessage());
		}
		return s;
	}
	
	public static boolean loginGPM() {
		boolean s=false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username");
		String name=sc.next();
		System.out.println("enter password");
		String pass=sc.next();
		MGNREGA obj=new MGNREGAimp();
		try {
			
			GPM gpm=null;
			 gpm=obj.loginGPM(name, pass);
			 if(gpm!=null)
			 {
				 s=true;
			 }
			 System.out.println("");
			 System.out.println("");
			 System.out.println("           :::::     Welcome    :::::");
			 System.out.println("");
			System.out.println("                    "+gpm.getName());
		} catch (GPMException e) {
			
			System.out.println(e.getMessage());
		}
		return s;
	}
	
	public static void addgpmtoproject()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id of project");
		int pid=sc.nextInt();
		System.out.println("Enter id of Gram Panchayet member");
		int gpmid=sc.nextInt();
		MGNREGA obj = new MGNREGAimp();
		try {
		String massage=	obj.allocateprojecttoGPM(pid, gpmid);
		System.out.println(massage);
		} catch (ProjectException   e) {
			System.out.println("Project is not there with this id");
			
		}catch (GPMException ep) {
			System.out.println("Gram Panchayat Member is not there with this id");
		}
	}
	
	public static void createproject()
	{
		Scanner sc = new Scanner(System.in);
		int no=0;
		System.out.println("Enter Name of Project");
		String name=sc.next();
		System.out.println("Enter no of Employee required for this Project");
		
			 no=sc.nextInt();
		System.out.println("Enter total budget for this Project");
		String amount=sc.next();
		MGNREGA obj=new MGNREGAimp();
		Project project=new Project();
		project.setName(name);
		project.setNoOfEmployee(no);
		project.setTotalWages(amount);
		String massage=	obj.createproject(project);
		System.out.println(massage);
	}
	
	public static void createGPM() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of Gram Panchayet member");
		String name=sc.next();
		System.out.println("Set Password for Gram Panchayet member");
		String pass=sc.next();
		System.out.println("Enter Address of Gram Panchayet member");
		String add=sc.next();
		System.out.println("Enter Phone number of Gram Panchayet member");
		String phone=sc.next();
		MGNREGA mg=new MGNREGAimp();
		
		GPM obj=new  GPM();
		obj.setName(name);
		obj.setPassword(pass);
		obj.setAddress(add);
		obj.setPhone(phone);
		String massage=mg.createnewGPM(obj);
		System.out.println(massage);
		
	}
	
	public static void showallproject() {
		
		MGNREGA obj=new MGNREGAimp();
		try {
			List<Project> list=obj.listofProject();
			System.out.println(":::  ====List of All Project====  :::");
			list.forEach(p->{
				
				System.out.println("ID of Project                | "+p.getId());
				System.out.println("Name of Project              | "+p.getName());
				System.out.println("No Of Employee for Project   | "+p.getId());
				System.out.println("Project total Budget         | "+p.getId());
				System.out.println("");
				System.out.println("::::  =============================  :::");
				System.out.println("");
				
			});
			
			
		} catch (ProjectException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void showallGPM() {
		
		MGNREGA obj=new MGNREGAimp();
		
		try {
			List<GPM> list=obj.listofGPM();
			System.out.println("  :::  ====List of All Gram Panchayet member====  :::");
			System.out.println(list.size());
			for(GPM g:list) {
				System.out.println("ID of Gram Panchayet member         | "+g.getId());
				System.out.println("Name of Gram Panchayet member       | "+g.getName());
				System.out.println("Address of Gram Panchayet member    | "+g.getAddress());
				System.out.println("Phone No of Gram Panchayet member   | "+g.getPhone());
				System.out.println("");
				System.out.println("::::::::  ==============================================  ::::::");
				System.out.println("");
			};
			
			
			
		} catch (GPMException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public static void createEmployee() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name of Employee");
		String name = sc.next();
		System.out.println("Enter Address of Employee");
		String addresss=sc.next();
		System.out.println("Enter Phone Number of Employee");
		String phone = sc.next();
		System.out.println("Total No of Days Employee work");
		int day=sc.nextInt();
		System.out.println("Enter wage of Employee a Day");
		int wage=sc.nextInt();
		int totalwage=day*wage;
		
		Employee epm=new Employee();
		epm.setName(name);
		epm.setAddress(addresss);
		epm.setPhone(phone);
		epm.setNo_of_days(day);
		epm.setWages(totalwage);
		MGNREGA obj=new MGNREGAimp();
		String massage=obj.createemployee(epm);
		System.out.println(massage);
		}
	
	public static void showallemployee() {

		MGNREGA obj=new MGNREGAimp();
		
		try {
			List<Employee> list=obj.listofEmployee();
			System.out.println("  :::  ====List of All Employee====  :::");
			list.forEach(g->{
				System.out.println("ID of Employee         | "+g.getId());
				System.out.println("Name of Employee       | "+g.getName());
				System.out.println("Address of Employee    | "+g.getAddress());
				System.out.println("Phone No of Employee   | "+g.getPhone());
				System.out.println("");
				System.out.println("::::::::  ==============================================  ::::::");
				System.out.println("");
			});
			
			
			
		} catch (EmployeeException e) {
			
			System.out.println("No Employee exist...");
		}
	}
	public static void employeelistproject() {
		MGNREGA obj=new MGNREGAimp();
		
		try {
			List<ListofEmployeeUnderProject>list=obj.employeeUnderProject();
			
			System.out.println(":::=====List Of Employee working on Project And There Wages =====:::");
			System.out.println("");
			list.forEach(l->{
				System.out.println("Name of Empoyee          | "+l.getEmpname());
				System.out.println("Name of Project          | "+l.getPname());
				System.out.println("Total Wage of Employee   | "+l.getAmount());
				System.out.println("");
				System.out.println("::::::====================================================::::::");
				System.out.println("");
			});
			
		} catch (ProjectException e) {
			
			System.out.println("No Employee alloted to project ");
		}
		
	}
	public static void assignemptoproject()  {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id of project");
		int pid=sc.nextInt();
		System.out.println("Enter id of Employee");
		int empid=sc.nextInt();
		MGNREGA obj = new MGNREGAimp();
		
	
		try {
			String massage = obj.assignemptoproject(pid, empid);
			System.out.println(massage);
		} catch (ProjectException e) {
			System.out.println("Project is not there with this id");
			
		} catch (EmployeeException e) {
			System.out.println("Employee is not there with this id");
		}
		
		
	}
	
}
