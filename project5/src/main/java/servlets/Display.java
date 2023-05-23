 package servlets;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Dao.DbConnection;
import Dao.EmpDaoImpl;
import pojoClass.Pojo;

/**
 * Servlet implementation class Display
 */
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context = request.getServletContext();
		DbConnection db = (DbConnection)context.getAttribute("Db");
		Connection connection = db.getConnection();
		Gson gson=new Gson();
		Pojo obj = gson.fromJson(request.getReader(), Pojo.class);
		
		EmpDaoImpl emp=new EmpDaoImpl();
		PrintWriter out=response.getWriter();
		Pojo e=emp.viewJSON(obj.getId(),connection);
		
		if(e==null) {
			out.println("Not found in data base");
		}
		
		else {
		String s=gson.toJson(e);
		response.setContentType("application/JSON");
		out.println(s);
		
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
}

