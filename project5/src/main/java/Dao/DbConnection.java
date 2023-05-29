package Dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DbConnection {

	
	static Connection connection;
	static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(DbConnection.class);
	static DataSource dataSource;
	public static DataSource DSource() {
		     
            Context initContext;
			try {
				initContext = new InitialContext();
				Context envContext = (Context)initContext.lookup("java:/comp/env");
				dataSource = (DataSource)envContext.lookup("jdbc/empdb");
				} catch (NamingException e) {
				e.printStackTrace();
				}
			return dataSource;
			}

	
    public Connection getConnection() {
     
        
            try {
            	
                connection= DSource().getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
                log.error(" SQLException Error");
                
            }
            return connection;
        
     
        
    }
}
