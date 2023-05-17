package Methods;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Scanner;

import pojoClass.pojo;


public class EmpDaoImpl {
	Scanner sc=new Scanner(System.in);
	public Connection getDb() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/empdb","root","root");  		
		return con;
		
	}

	DBConnection dbConnection=new DBConnection();
	public void insert(String query, pojo emp) {
			Connection con=DBConnection.creatDBConnection();	
			PreparedStatement pstmt=null;		
				try {
					pstmt=con.prepareStatement(query);
					pstmt.setInt(1, emp.getId());
					pstmt.setString(2, emp.getName());
					pstmt.setDouble(3, emp.getSalary());
					pstmt.setString(4, emp.getType());
					int cnt=pstmt.executeUpdate();
					if(cnt!=0) {
						System.out.println("Updated successfully");
					}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		}
	public void insertType(String query, pojo emp) {
		Connection con=DBConnection.creatDBConnection();	
		PreparedStatement pstmt=null;	
		try {
		
				pstmt=con.prepareStatement(query);
				pstmt.setInt(1, emp.getId());
				pstmt.setString(2, emp.getName());
				int cnt=pstmt.executeUpdate();
				if(cnt!=0) {
					System.out.println("Updated successfully");
				}
		
			}catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					pstmt.close();
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
	public void put(String query,pojo emp) {
		Connection con=DBConnection.creatDBConnection();
		PreparedStatement pstmt=null;
		try {
			 pstmt=con.prepareStatement(query);
			pstmt.setString(1, emp.getName());
			pstmt.setDouble(2, emp.getSalary());
			pstmt.setString(3, emp.getType());
			pstmt.setInt(4, emp.getId());
			int cnt=pstmt.executeUpdate();
			if(cnt!=0) {
				System.out.println("Updated successfully");
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	public void putType(String query,pojo emp) {
		Connection con=DBConnection.creatDBConnection();
		PreparedStatement pstmt=null;
		try {
			 pstmt=con.prepareStatement(query);
			pstmt.setString(1, emp.getName());
			pstmt.setInt(2, emp.getId());
			int cnt=pstmt.executeUpdate();
			if(cnt!=0) {
				System.out.println("Updated successfully");
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	public void remove(String query,int id) {
		Connection con=DBConnection.creatDBConnection();
	
		PreparedStatement pstmt11=null;
		try {
			 pstmt11 = con.prepareStatement(query);
			pstmt11.setInt(1, id);
			int cnt=pstmt11.executeUpdate();
			if(cnt!=0) {
				System.out.println("deleted successfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt11.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

		
	public void createEmployee(pojo emp) {
		String type=emp.getType();
		String query="insert into employee values(?,?,?,?)";
	
		insert(query,emp);		
			String queryp;
			
			switch(type) {			
			case "permanent":
				queryp="insert into permanent values(?,?)";
				insertType(queryp,emp);
				break;
			case "parttime":
				queryp="insert into parttime values(?,?)";
				insertType(queryp,emp);
				break;
			case "contract":
				queryp="insert into contract values(?,?)";
				insertType(queryp,emp);
				break;
				
			}
			}
	
	public void modify(pojo emp) {
				
			String type=emp.getType();
			String query="update employee set name=?,set salary=?,set type=? where id=?";
			put(query, emp);
			switch(type) {			
			case "permanent":
				String queryp="update permanent set name=? where id=?";
				putType(queryp,emp);
				break;
			case "parttime":
				String querypt="update parttime set name=? where id=?";
				putType(querypt,emp);
				break;
			case "contract":
				String queryc="update contract set name=? where id=?";
				putType(queryc,emp);
				break;
			}
			
	}
	
	public void delete(String type,int id) {
		
		String query="delete from employee where id=?";
		remove(query,id);
		switch(type) {			
		case "permanent":
			String queryp="delete from employee where id=?";
			remove(queryp,id);
			break;
		case "parttime":
			String querypt="delete from employee where id=?";
			remove(querypt,id);
			break;
		case "contract":
			String queryc="delete from employee where id=?";
			remove(queryc,id);
			break;
		}
		
	}
	
	public void viewEmp() {
		Connection con=DBConnection.creatDBConnection();
		String query="select * from employee";	
		Statement pstmt15=null;
		ResultSet result = null;
			try {
				pstmt15=con.createStatement();
				result=pstmt15.executeQuery(query);
				while(result.next()) {
					System.out.println("Employee id - "+ result.getInt(1)+" Employee Name - "+result.getString(2)+" Employee Salary- "+result.getDouble(3)+" Employee Type - "+result.getString(4));
				
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					pstmt15.close();
					result.close();
				} catch (SQLException e) {
	
					e.printStackTrace();
				}
			}
							
	}
	public Hashtable<Integer,pojo> viewJSON() {
		Connection con=DBConnection.creatDBConnection();
		PreparedStatement pstmt16=null;
		Hashtable<Integer, pojo> hMap=new Hashtable<Integer, pojo>();
		 ResultSet rs=null;
		try {
			pstmt16 = con.prepareStatement("select * from employee");
		
		   rs=pstmt16.executeQuery();   		 

		   while(rs.next()) {
			   pojo e=new pojo(rs.getInt("id"), rs.getString("name"), rs.getDouble("id"), rs.getString("type"));
			   hMap.put(rs.getInt("id"), e);
  
		   }  	

	}catch (SQLException e) {
		e.printStackTrace();
	}
		finally {
			try {
				pstmt16.close();
				con.close();
				rs.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		return hMap;
		
	
	}
	
	
	public Hashtable<Integer,pojo> viewJSON(int id)  {
		
		PreparedStatement pstmt16=null;
		Hashtable<Integer, pojo> hMap=new Hashtable<Integer, pojo>();
		ResultSet rs=null;
		try {
			Connection con=getDb();
			String q="select * from employee where id=?";
			pstmt16 = con.prepareStatement(q);
			pstmt16.setInt(1, id);		
			rs=pstmt16.executeQuery();   

		   System.out.println("in while");

		   while(rs.next()) {
			   pojo e=new pojo(rs.getInt("id"), rs.getString("name"), rs.getDouble("salary"), rs.getString("type"));
			   hMap.put(rs.getInt("id"), e);
			   

		   }
		   return hMap;

	}catch (SQLException e) {
		e.printStackTrace();
	} catch (Exception e1) {
	
		e1.printStackTrace();
	}
		finally {
			try {
				pstmt16.close();
				rs.close();
			} catch (SQLException e) {
	
				e.printStackTrace();
			}

		}
		return hMap;		
	
	}
	
}
