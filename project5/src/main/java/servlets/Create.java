package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Methods.EmpDaoImpl;
import pojoClass.Pojo;


public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public final Gson gson;
	public final EmpDaoImpl daoImpl;
	
    public Create(){
    	gson = new Gson();
    	daoImpl = new EmpDaoImpl();
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Pojo obj  = gson.fromJson(request.getReader(), Pojo.class);
		daoImpl.createEmployee(obj);
		PrintWriter out = response.getWriter();
		String jsonC = gson.toJson(obj);
		response.setContentType("application/JSON");
		out.print(jsonC);
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			
	}

}
