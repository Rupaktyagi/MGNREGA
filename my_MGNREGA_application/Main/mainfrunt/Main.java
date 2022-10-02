package com.mgnrega.mainfrunt;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.mgnrega.exicute.ExicutionClass;

public class Main {

	public static void mainmanu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("       Select option to Go Future");
		System.out.println("");
		System.out.println("1.  For Login BDO");
		System.out.println("2.  For Login Gram Panchayet member");
		int choice=0;
		try {
			 choice=sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("");
			System.out.println("Invalid input !!!");
			System.out.println("");
			System.out.println("Please select valid option..");
			
			Main.mainmanu();
		}
		
		
		
		switch (choice) {
		
		case 1:
			
			if(ExicutionClass.loginBDO())
			{
				Main.BDOmanu();
			}else {
				ExicutionClass.loginBDO();
				
				Main.mainmanu();
			}
			break;
		case 2:
			if(ExicutionClass.loginGPM())
			{
				Main.GPMmanu();
			}else {
				ExicutionClass.loginGPM();
				
				Main.mainmanu();
			}
			
			break;
		default :
			System.out.println("Invalid Choice !");
			System.out.println("");
			System.out.println("Try Again....");
			Main.mainmanu();
		}
	}
	
	public static void BDOmanu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("Make A Choice ");
		System.out.println("1.  Create New Project");
		System.out.println("2.  List of All Project");
		System.out.println("3.  Create New Gram Panchayat Member");
		System.out.println("4.  List of Gram Panchayat Member");
		System.out.println("5.  Allocate Project to Gram Panchayat Member");
		System.out.println("6.  List of Employee on Project");
		System.out.println("7.  logout");
		System.out.println("");
		int c=0;
		try {
			
			 c=sc.nextInt();
			 
			
		} catch (InputMismatchException e) {

				System.out.println("Invalid Input Type !!");
				System.out.println("");
				System.out.println("Chose a Correct Choice");
				Main.BDOmanu();
		}
		switch(c) {
		
		
		case 1:
			ExicutionClass.createproject();
			System.out.println("Press any key to go back");
			int n=0;
			try {
				 n=sc.nextInt();
			} catch (InputMismatchException e) {
//				System.out.println("Invalid input! Please enter any number ");
				
			}
			if(n==1)
			{
				Main.BDOmanu();
			}else {
				Main.BDOmanu();
			}
			break;
		case 2:
		    ExicutionClass.showallproject();
		    System.out.println("Press any key to go back");
			int m=0;
			try {
				 m=sc.nextInt();
			} catch (InputMismatchException e) {
//				System.out.println("Invalid input! Please enter any number ");
				
			}
			if(m==1)
			{
				Main.BDOmanu();
			}else {
				Main.BDOmanu();
			}
		    break;
		case 3:
			ExicutionClass.createGPM();
			System.out.println("Press any key to go back");
			int o = 0;
			try {
				 o=sc.nextInt();
			} catch (InputMismatchException e) {
//				System.out.println("Invalid input! Please enter any number ");
				
			}
			if(o==1)
			{
				Main.BDOmanu();
			}else {
				Main.BDOmanu();
			}
		   break;
		case 4:
			ExicutionClass.showallGPM();
			System.out.println("Press any key to go back");
			int p=0;
			try {
				 p=sc.nextInt();
			} catch (InputMismatchException e) {
//				System.out.println("Invalid input! Please enter any number ");
				
			}
			if(p==1)
			{
				Main.BDOmanu();
			}else {
				Main.BDOmanu();
			}
			break;
		case 5:
			ExicutionClass.addgpmtoproject();
			System.out.println("Press any key to go back");
			int q=0;
			try {
				 q=sc.nextInt();
			} catch (InputMismatchException e) {
//				System.out.println("Invalid input! Please enter any number ");
				
			}
			if(q==1)
			{
				Main.BDOmanu();
			}else {
				Main.BDOmanu();
			}
			break;
		case 6:
			ExicutionClass.employeelistproject();
			System.out.println("Press any key to go back");
			int r=0;
			try {
				 r=sc.nextInt();
			} catch (InputMismatchException e) {
//				System.out.println("Invalid input! Please enter any number ");
				
			}
			if(r==1)
			{
				Main.BDOmanu();
			}else {
				Main.BDOmanu();
			}
			break;
		case 7:
			Main.mainmanu();
			break;
		default:
			System.out.println("invalid Choice !!");
			System.out.println("");
			System.out.println("try again");
			Main.BDOmanu();
				
		}
		
	}
	public static void GPMmanu() {
		Scanner sc = new Scanner(System.in);
		int c=0;
		System.out.println("");
		System.out.println("Make A Choice ");
		System.out.println("1.  Create New Employee");
		System.out.println("2.  List of All Employee");
		System.out.println("3.  Assign Employee to project");
		System.out.println("4.  Logout");
		System.out.println("");
		try {
			
			 c=sc.nextInt();
			 
			
		} catch (InputMismatchException e) {

				System.out.println("Invalid Input Type !!");
				System.out.println("");
				System.out.println("Chose a Correct Choice");
				Main.GPMmanu();
		}
switch(c) {
		
		
		case 1:
			ExicutionClass.createEmployee();
			System.out.println("Press any key to go back");
			int n=0;
			try {
				 n=sc.nextInt();
			} catch (InputMismatchException e) {
//				System.out.println("Invalid input! Please enter any number ");
				
			}
			if(n==1)
			{
				Main.GPMmanu();
			}else {
				Main.GPMmanu();
			}
			
			break;
		case 2:
		    ExicutionClass.showallemployee();
		    System.out.println("Press any key to go back");
		    int m=0;
			try {
				 m=sc.nextInt();
			} catch (InputMismatchException e) {
//				System.out.println("Invalid input! Please enter any number ");
				
			}
			if(m==1)
			{
				Main.GPMmanu();
			}else {
				Main.GPMmanu();
			}
		    break;
		case 3:
			ExicutionClass.assignemptoproject();
			System.out.println("Press any key to go back");
			int p=0;
			try {
				 p=sc.nextInt();
			} catch (InputMismatchException e) {
//				System.out.println("Invalid input! Please enter any number ");
				
			}
			if(p==1)
			{
				Main.GPMmanu();
			}else {
				Main.GPMmanu();
			}
			
		   break;
		case 4:
			Main.mainmanu();
			break;
		default:
			System.out.println("invalid Choice !!");
			System.out.println("");
			System.out.println("try again");
			Main.BDOmanu();
				
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("::::WELCOME To Mahatma Gandhi National Rural Employment Guarantee Act Application::::");
		System.out.println("");
		System.out.println("");
		mainmanu();
		
		
		
	}

}
