package com.emp.crud;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			EmpDao dao=new DaoImpl();
			do {
				System.out.println("-----Choices-----");
				System.out.println("[1].Create New Employee");
				System.out.println("[2].To Display All Employs");
				System.out.println("[3].To Delete an Employee");
				System.out.println("[4].To Update Employee Data");
				System.out.println("[0].To Exit");
				System.out.println("Enter your choice:");
				int ch=sc.nextInt();
				switch(ch) {
				case 1:
					Employee e=new Employee();
					sc.nextLine();
					System.out.println("Enter name of the employee: ");
					String ename=sc.nextLine();
					System.out.println("Enter city of employee");
					String city=sc.nextLine();
					System.out.println("Enter salary of employee");
					int esal=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter employee phone no");
					String ph=sc.nextLine();
					e.setEname(ename);
					e.setCity(city);
					e.setEsal(esal);
					e.setEph(ph);
					dao.createNewEmployee(e);
					break;
				case 2:
					dao.displayAllEmploys();
					break;
				case 3:
					dao.deleteEmployee();
					break;
				case 4:
					dao.updateEmployeeData();
					break;
				case 0:
					System.exit(0);
					break;
				default:
					System.out.println("invalid choice");
				}
			}while(true);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
