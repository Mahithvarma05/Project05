package com.ejdbc.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class EmpDaoImpl {
	Connection con;
	Scanner sc=new Scanner(System.in);

	
	public void createEmployee(pojo emp) {
	con=DBConnection.creatDBConnection();
	String type=emp.getType();
	String query="insert into employee values(?,?,?,?)";
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
	if(type.equals("permanent")) {
		String queryp="insert into permanent values(?,?)";
		PreparedStatement pstmt2=null;
		try {
			pstmt2=con.prepareStatement(queryp);
			pstmt2.setInt(1, emp.getId());
			pstmt2.setString(2, emp.getName());
			int cnt=pstmt2.executeUpdate();
			if(cnt!=0) {
				System.out.println("Updated successfully");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt2.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	if(type.equals("parttime")) {
		String queryp="insert into parttime values(?,?)";
		PreparedStatement pstmt3=null;
		try {
			pstmt3=con.prepareStatement(queryp);
			pstmt3.setInt(1, emp.getId());
			pstmt3.setString(2, emp.getName());
			int cnt=pstmt3.executeUpdate();
			if(cnt!=0) {
				System.out.println("Updated successfully");
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt3.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}
	if(type.equals("contract")) {
		String queryp="insert into contract values(?,?)";
		PreparedStatement pstmt4=null;
		try {
			pstmt4=con.prepareStatement(queryp);
			pstmt4.setInt(1, emp.getId());
			pstmt4.setString(2, emp.getName());
			int cnt=pstmt4.executeUpdate();
			if(cnt!=0) {
				System.out.println("Updated successfully");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt4.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}
	}
	public void modify(pojo emp) {
		con=DBConnection.creatDBConnection();
		
			int id=emp.getId();
			String type=emp.getType();
			String query="update employee set name=? where id=?";
			PreparedStatement pstmt5=null;
			
			try {
				 pstmt5=con.prepareStatement(query);
				pstmt5.setString(1, emp.getName());
				pstmt5.setInt(2, id);
				int cnt=pstmt5.executeUpdate();
				if(cnt!=0) {
					System.out.println("Updated successfully");
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					pstmt5.close();
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			
	
			String query2="update employee set salary=? where id=?";
			PreparedStatement pstmt6=null;
			try {
				pstmt6=con.prepareStatement(query2);
				pstmt6.setDouble(1, emp.getSalary());
				pstmt6.setInt(2, id);
				int cnt=pstmt6.executeUpdate();
				if(cnt!=0) {
					System.out.println("Updated successfully");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					pstmt6.close();
				
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			 
			String query3="update employee set type=? where id=?";
			PreparedStatement pstmt7=null;
			try {
				 pstmt7=con.prepareStatement(query3);
				pstmt7.setString(1, emp.getType());
				pstmt7.setInt(2, id);
				int cnt=pstmt7.executeUpdate();
				if(cnt!=0) {
					System.out.println("Updated successfully");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					pstmt7.close();
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if(type.equals("permanent")) {
				String queryp="update permanent set name=? where id=?";
				PreparedStatement pstmt8=null;
				try {
					 pstmt8=con.prepareStatement(queryp);
					pstmt8.setString(1, emp.getName());
					pstmt8.setInt(2, emp.getId());
					int cnt=pstmt8.executeUpdate();
					if(cnt!=0) {
						System.out.println("Updated successfully");
					}
					
				}catch (SQLException e) {
					e.printStackTrace();
				}
				finally {
					try {
						pstmt8.close();
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				}
				
				
			}
			if(type.equals("parttime")) {
				String querypt="update parttime set name=? where id=?";
				PreparedStatement pstmt9=null;
				try {
					 pstmt9=con.prepareStatement(querypt);
					pstmt9.setString(1, emp.getName());
					pstmt9.setInt(2, emp.getId());
					int cnt=pstmt9.executeUpdate();
					if(cnt!=0) {
						System.out.println("Updated successfully");
					}
					
				}catch (SQLException e) {
					e.printStackTrace();
				}
				finally {
					try {
						pstmt9.close();
					} catch (SQLException e) {
					
						e.printStackTrace();
					}
				} 
				
			}
			if(type.equals("contract")) {
				String queryc="update contract set name=? where id=?";
				PreparedStatement pstmt10=null;
				try {
					pstmt10=con.prepareStatement(queryc);
					pstmt10.setString(1, emp.getName());
					pstmt10.setInt(2, emp.getId());
					int cnt=pstmt10.executeUpdate();
					if(cnt!=0) {
						System.out.println("Updated successfully");
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}
				finally {
					try {
						pstmt10.close();
						con.close();
					} catch (SQLException e) {
		
						e.printStackTrace();
					}
				}
			}
			
    		
		}		
	

	public void delete(String type,int id) {
		con=DBConnection.creatDBConnection();
		String query="delete from employee where id=?";
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
		if(type.equals("permanent")) {
			String queryp="delete from permanent where id=?";
			PreparedStatement pstmt12=null;
			try {
				pstmt12 = con.prepareStatement(queryp);
				pstmt12.setInt(1, id);
				int cnt=pstmt12.executeUpdate();
				if(cnt!=0) {
					System.out.println("deleted successfully");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					pstmt12.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
						
		}
		if(type.equals("parttime")) {
			String querypt="delete from parttime where id=?";
			PreparedStatement pstmt13=null;
			try {
				pstmt13 = con.prepareStatement(querypt);
				pstmt13.setInt(1, id);
				int cnt=pstmt13.executeUpdate();
				if(cnt!=0) {
					System.out.println("deleted successfully");
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					pstmt13.close();
				} catch (SQLException e) {
	
					e.printStackTrace();
				}
			}
			
			
		}
		if(type.equals("contract")) {
			String queryc="delete from contract where id=?";
			PreparedStatement pstmt14=null;
			try {
				pstmt14 = con.prepareStatement(queryc);
				pstmt14.setInt(1, id);
				int cnt=pstmt14.executeUpdate();
				if(cnt!=0) {
					System.out.println("deleted successfully");
					
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					pstmt14.close();
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
	
		}
		
	}
		
	
	public void viewEmp() {
		con=DBConnection.creatDBConnection();
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
	public void viewJSON() {
		con=DBConnection.creatDBConnection();
		PreparedStatement pstmt16=null;
		 ResultSet rs=null;
		try {
			pstmt16 = con.prepareStatement("select * from employee");
		
		   rs=pstmt16.executeQuery();   		 
		   JSONArray employeeArray=new JSONArray();
		   while(rs.next()) {
			    JSONObject empy=new JSONObject(); 
			     
			    empy.put("empId",rs.getInt("id"));
		        empy.put("empName",rs.getString("name"));
		        empy.put("empSalary",rs.getDouble("salary"));
		        empy.put("empType",rs.getString("type"));
		  
		        employeeArray.put(empy);
		        
		   }  	
		   System.out.println(employeeArray);
	}catch (SQLException e) {
		e.printStackTrace();
	}
		finally {
			try {
				pstmt16.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		
	
	}
	
	
			 
	

	
}
