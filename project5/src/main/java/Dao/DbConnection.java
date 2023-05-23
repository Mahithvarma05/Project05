package Dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DbConnection {

	
	public static Connection connection;
	static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(DbConnection.class);
	
	
    public Connection getConnection() {
        try {
        
            Context initContext = new InitialContext();
            Context envContext = (Context)initContext.lookup("java:/comp/env");
            DataSource dataSource = (DataSource)envContext.lookup("jdbc/empdb");
            try {
                connection= dataSource.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
                log.error(" SQLException Error");
                
            }
            return connection;
        } catch (NamingException e) {
            e.printStackTrace();
            log.info(" NamingException Error");
        }
        return connection ;
        
    }
}
