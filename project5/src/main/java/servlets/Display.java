 package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Methods.EmpDaoImpl;
import pojoClass.pojo;

/**
 * Servlet implementation class Display
 */
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Gson gson=new Gson();
		int id=Integer.parseInt(request.getParameter("id"));
		EmpDaoImpl emp=new EmpDaoImpl();
		PrintWriter out=response.getWriter();
		Hashtable<Integer, pojo> e=emp.viewJSON(id);
		String s=gson.toJson(e);
		response.setContentType("application/JSON");
		out.println(s);
		
		
	}

	
}

