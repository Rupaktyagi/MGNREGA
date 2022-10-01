package com.mgnrega.mainfrunt;

import java.util.Scanner;

import com.mgnrega.exicute.ExicutionClass;

public class Main {

	static Scanner sc=new Scanner(System.in);
	public static void mainmanuofBDO() {
		System.out.println("");
		System.out.println("       Select option do to following");
		System.out.println("");
		System.out.println("1.  Create a Project");
		System.out.println("2.  List of Projects");
		System.out.println("3.  Create New Gram Panchayet member");
		System.out.println("4.  List of Gram Panchayet member");
		System.out.println("5.  Allocate Project to Panchayet member");
	}
	public static void BDOmanucase1() {
		System.out.println("");
		System.out.println("Press 1 to add another Project ");
		System.out.println("Press any number for Main Manu");
		int n=sc.nextInt();
		if(n==1)
		{
			ExicutionClass.createproject();
			BDOmanucase1();
		}else {
			mainmanuofBDO();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("::::WELCOME To Mahatma Gandhi National Rural Employment Guarantee Act Application::::");
		System.out.println("");
		System.out.println("");
		System.out.println("       Select option to Go Future");
		System.out.println("");
		System.out.println("1.  For Login BDO");
		System.out.println("2.  For Login Gram Panchayet member");
		
		
		int choice=sc.nextInt();
		
		switch (choice) {
		
		case 1:
			if(ExicutionClass.loginBDO())
			{
				mainmanuofBDO();
				int bdochoice=sc.nextInt();
				
				switch(bdochoice) {
				
				case 1:
					ExicutionClass.createproject();
					BDOmanucase1();
					
				}
				
				
			}else {
				System.out.println(":...::Retry again::...:");
				ExicutionClass.loginBDO();
			}
			break;
		case 2:
			System.out.println("ksdbb");
			ExicutionClass.showallproject();
		
		
		}
	}

}
