package com.ejdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection creatDBConnection(){
		Connection con=null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return con;
	
	}

}
