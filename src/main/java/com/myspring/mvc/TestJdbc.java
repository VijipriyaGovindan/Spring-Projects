package com.myspring.mvc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/hb_student_tracker","hbstudent","hbstudent");  
			System.out.println("Connection " +  con);
			}catch(Exception e){ System.out.println(e);}  
			
	}

}
