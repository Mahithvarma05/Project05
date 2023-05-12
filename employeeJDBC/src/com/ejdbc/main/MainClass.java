package com.ejdbc.main;
import java.util.logging.*;


import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String empName,empType;
		double empSalary;
		int empId;
		Logger logger=Logger.getLogger("MainClass");
		EmpDaoImpl dao=new EmpDaoImpl();
		Scanner sc=new Scanner(System.in);
		boolean run=true;
		while(run) {
			System.out.println("1.Create\n2.Modify\n3.Delete\n4.View Employee List\n5.JSON\n6.Exit");
			 int n=sc.nextInt();
			 switch(n) {
			    	case 1:			    		
			    	   pojo emp =new pojo();
			    	   System.out.println("Enter Employee Id");
				       empId=sc.nextInt();				      
				       System.out.println("Enter Employee Name");
				       empName=sc.next();
				       System.out.println("Enter Employee Salary");
				       empSalary=sc.nextDouble();
				       System.out.println("Enter Employee Type");
				       empType=sc.next();
				       emp.setId(empId);
				       emp.setName(empName);
				       emp.setSalary(empSalary);
				       emp.setType(empType);
				       dao.createEmployee(emp);
				       logger.log(Level.INFO, "Employee is added");
				       
				       break;
				       
			    	case 2:
			    		pojo empl =new pojo();
				    	System.out.println("Enter Employee Id");
					    empId=sc.nextInt();				      
					    System.out.println("Enter Employee Name");
					    empName=sc.next();
					    System.out.println("Enter Employee Salary");
					    empSalary=sc.nextDouble();
					    System.out.println("Enter Employee Type");
					    empType=sc.next();
					    empl.setId(empId);
					    empl.setName(empName);
					    empl.setSalary(empSalary);
					    empl.setType(empType);
					       				    
			    		dao.modify(empl);
			    		logger.log(Level.INFO, "Employee details are updated");
			    		break;
			    	case 3:
			    		System.out.println("Enter Type of Employee");
			    		empType=sc.next();
			    		System.out.println("Enter Employee Id");
					    empId=sc.nextInt();
					    dao.delete(empType,empId);
					    logger.log(Level.INFO, "Employee deleted from SQL");
			    		break;
			    	case 4:			    		
			    		dao.viewEmp();
			    		break;
			    	case 5:
			    		dao.viewJSON();
			    		break;
			    	case 6:
			    		System.out.println("End");
			    		run=false;
			    		break;
			    	default:
			    		System.out.println("Incorrect Choice");
			    		break;
			    	}
			 }
		}
}
