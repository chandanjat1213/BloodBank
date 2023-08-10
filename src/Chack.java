

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Chack
 */
@WebServlet("/Chack")
public class Chack extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String name= request.getParameter("name");
		String health = request.getParameter("health");
		if(health.equals("good"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("Donet.jsp");
			rd.include(request, response);
			out.println("<script>window.alert('your health is good')</script>");
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
			out.println("<script>window.alert('your health is not good')</script>");
	
		}
	}

}
