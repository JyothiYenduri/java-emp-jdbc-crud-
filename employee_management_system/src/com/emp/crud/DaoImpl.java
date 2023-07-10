package com.emp.crud;
import java.sql.*;
import java.util.*;

import com.Student.Manage.Cp;

public class DaoImpl implements EmpDao {
	int empno;
	Scanner sc=new Scanner(System.in);
	Connection con;
	DaoImpl(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","root","root");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void createNewEmployee(Employee e) {
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into Employee(ename,city,eph,esal)values(?,?,?,?)");
			pstmt.setString(1,e.getEname());
			pstmt.setString(2,e.getCity());
			pstmt.setString(3,e.getEph());
			pstmt.setInt(4,e.getEsal());
			int i=pstmt.executeUpdate();
			if(i!=0) {
				System.out.println("Employee added successfully");
			}else {
				System.out.println("Something went wrong please try again");
			}
			//con.close();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	public void displayAllEmploys() {
		try {
			String qry="select * from Employee ";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(qry);
			while(rs.next()) {
				int eno=rs.getInt(1);
				String ename=rs.getString(2);
				String city=rs.getString(3);
				String eph=rs.getString(4);
				int esal=rs.getInt(5);
				System.out.println("Employee ID: "+eno);
				System.out.println("Employee Name: "+ename);
				System.out.println("Employee City: "+city);
				System.out.println("Employee Ph_No: "+eph);
				System.out.println("Employee Sal: "+esal);
				System.out.println("*******************************");
				//con.close();
			}
			}catch(Exception e) {
			e.printStackTrace();
			}
	}
	public void deleteEmployee() {
		System.out.println("Select eno to search: ");
		empno=sc.nextInt();
		try {
			PreparedStatement pstmt=con.prepareStatement("delete from Employee where eno="+empno);
			int i=pstmt.executeUpdate();
			if(i==1) {
				System.out.println("Employee deleted successfully");
			}else {
				System.out.println("Something went wrong try again");
			}
			//con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void updateEmployeeData() {
		System.out.println("Select eno to search: ");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter employee ph_no to update");
		String empph=sc.nextLine();
		try {
			PreparedStatement pstmt=con.prepareStatement("update Employee set eph=? where eno=?");
			pstmt.setString(1, empph);
	        pstmt.setInt(2, id);
			int i=pstmt.executeUpdate();
			if(i>0) {
				System.out.println("Employee name updated successfully");
			}else {
				System.out.println("Something went wrong try again");
			}
			//con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
