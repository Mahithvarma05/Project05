package Dao;


import java.lang.System.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Scanner;

import pojoClass.Pojo;


public class EmpDaoImpl {
	static Scanner sc=new Scanner(System.in);
	static java.util.logging.Logger log = java.util.logging.Logger.getLogger("EmpDaoImpl");
	
	public void insert(String query, Pojo emp,Connection con) {
		PreparedStatement pstmt=null;		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getName());
			pstmt.setDouble(3, emp.getSalary());
			pstmt.setString(4, emp.getType());
			int cnt=pstmt.executeUpdate();
			if(cnt!=0) {
				log.info("Updated successfully");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void insertType(String query, Pojo emp,Connection con) {
		PreparedStatement pstmt=null;	
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getName());
			int cnt=pstmt.executeUpdate();
			if(cnt!=0) {

				log.info("Updated successfully");
	
			}
		
		}
		catch (SQLException e) {
				e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void put(String query,Pojo emp,Connection con) {
		PreparedStatement pstmt=null;
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, emp.getName());
			pstmt.setDouble(2, emp.getSalary());
			pstmt.setString(3, emp.getType());
			pstmt.setInt(4, emp.getId());
			int cnt=pstmt.executeUpdate();
			if(cnt!=0) {
				log.info("Updated successfully");
			}		
		}catch (SQLException e) {
			e.printStackTrace();
			}
		finally {
			try {
				pstmt.close();
				
				} 
			catch (SQLException e) {
				e.printStackTrace();
				}
		}
	}
	
	public void putType(String query,Pojo emp,Connection con) {
		PreparedStatement pstmt=null;
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, emp.getName());
			pstmt.setInt(2, emp.getId());
			int cnt=pstmt.executeUpdate();
			if(cnt!=0) {
				log.info("Updated successfully");
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
	public void remove(String query,int id,Connection con) {
	
		PreparedStatement pstmt11=null;
		try {
			pstmt11 = con.prepareStatement(query);
			pstmt11.setInt(1, id);
			int cnt=pstmt11.executeUpdate();
			if(cnt!=0) {
				log.info("deleted successfully");
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

		
	public void createEmployee(Pojo emp,Connection c) {
		
		String type=emp.getType();
		String query="insert into employee values(?,?,?,?)";
	
		insert(query,emp,c);
		
			String queryp;
			
			switch(type) {			
			case "permanent":
				queryp="insert into permanent values(?,?)";
				insertType(queryp,emp,c);
				break;
			case "parttime":
				queryp="insert into parttime values(?,?)";
				insertType(queryp,emp,c);
				break;
			case "contract":
				queryp="insert into contract values(?,?)";
				insertType(queryp,emp,c);
				break;
				
			}
	}
	
	public void modify(Pojo emp,Connection con) {
				
			String type=emp.getType();
			String query="update employee set name=?,set salary=?,set type=? where id=?";
			put(query, emp,con);
			switch(type) {			
			case "permanent":
				String queryp="update permanent set name=? where id=?";
				putType(queryp,emp,con);
				break;
			case "parttime":
				String querypt="update parttime set name=? where id=?";
				putType(querypt,emp,con);
				break;
			case "contract":
				String queryc="update contract set name=? where id=?";
				putType(queryc,emp,con);
				break;
			}
			
	}
	
	public void delete(int id,Connection con) {
		String type = viewJSON(id,con).getType();
		String query="delete from employee where id=?";
		remove(query,id,con);
		switch(type) {			
		case "permanent":
			String queryp="delete from permanent where id=?";
			remove(queryp,id,con);
			break;
		case "parttime":
			String querypt="delete from parttime where id=?";
			remove(querypt,id,con);
			break;
		case "contract":
			String queryc="delete from contract where id=?";
			remove(queryc,id,con);
			break;
		}
		
	}
	
	public void viewEmp(Connection con) {
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
	public Hashtable<Integer,Pojo> viewJSON(Connection con) {
		PreparedStatement pstmt16=null;
		Hashtable<Integer, Pojo> hMap=new Hashtable<Integer, Pojo>();
		ResultSet rs=null;
		try {
			
			pstmt16 = con.prepareStatement("select * from employee");
			rs=pstmt16.executeQuery();
			
			while(rs.next()) {
			   Pojo e=new Pojo(rs.getInt("id"), rs.getString("name"), rs.getDouble("id"), rs.getString("type"));
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

	public Pojo viewJSON(int id,Connection con)  {
		
		PreparedStatement pstmt16=null;
		ResultSet rs=null;
		
		try {
			
			String q="select * from employee where id=?";
			pstmt16 = con.prepareStatement(q);
			pstmt16.setInt(1, id);		
			rs=pstmt16.executeQuery();   


		   while(rs.next()) {
			   Pojo e=new Pojo(rs.getInt("id"), rs.getString("name"), rs.getDouble("salary"), rs.getString("type"));
			   return e;

		   }
		   return null;
		   
		}catch (SQLException e) {
			e.printStackTrace();
			}

		finally {
			try {
				pstmt16.close();
				rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
			}

		}
		return null;
		}
	}
