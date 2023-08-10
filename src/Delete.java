

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import PP.Person;
import PP.Rdao;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("name");
		Person p = new Person();
		p.setName(name);
		Rdao r = new Rdao();
		
	    try
	    {
	    	int i = r.delete(p);
	    	RequestDispatcher rd = request.getRequestDispatcher("Show");
	    	rd.include(request, response);
	    	if(i>0)
	    	{
	    	out.println("<script>window.alert('deleted');</script>");
	    	}
	    	else
	    	{
	    		out.println("not deleted");
	    	}
	     }
	    catch(Exception e)
	    {
	    	out.println(e);
	    }
	}  

}
