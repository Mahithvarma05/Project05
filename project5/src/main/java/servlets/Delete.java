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

/**
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public final Gson gson;
	public final EmpDaoImpl daoImpl;
	
    public Delete() {
        gson = new Gson();
        daoImpl = new EmpDaoImpl();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pojo obj = gson.fromJson(request.getReader(), Pojo.class);
		daoImpl.delete(obj.getId());
		PrintWriter out = response.getWriter();
		out.println("Deleted");
		
	}
	
	

}
