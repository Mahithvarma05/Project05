package Methods;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection con;
	public static Connection creatDBConnection(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return con;
	
	}

}
