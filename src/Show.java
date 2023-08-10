

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import PP.Person;
import PP.Rdao;

/**
 * Servlet implementation class Show
 */
@WebServlet("/Show")
public class Show extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Rdao r = new Rdao();
		try
		{
		  List<Person> al = r.show();
		  if(al.isEmpty())
		  {
			  out.println("person is not found");
		  }
		  else
		  {
			  out.println("<table align=center border=1px>");
			  for(Person p:al)
			  {
			  out.println("<form action=Update");
			  out.println("<tr>");
			  out.println("<td>");
			  out.println(p.getName());
			  out.println("<input type=hidden name=name value="+p.getName()+"/>");
			  out.println("</td>");
			  out.println("<td>");
			 
			  out.println("<input type=number name=age value="+p.getAge()+ " />");
				 
			  out.println("</td>");
			  out.println("<td>");
			  out.println("<input type=text name=gruop value="+p.getBgroup() +" />");
				 
			  out.println("</td>");
			  out.println("<td>");
			  out.println("<input type=text name=hospital value="+p.getHospital()+" />");
				 
			  out.println("</td>");
			  out.println("<td>");
			  out.println("<input type=submit value=update/>");
			  out.println("</td>");
              out.println("</form>");
			  out.println("<td>");
			  out.println("<a href=Delete?name="+p.getName()+">Delete</a>");
			  out.println("</td>");
						
			  out.println("</tr>");
			  }
			  out.println("</table>");
		  }
		}
		catch(Exception e)
		{
			out.println(e);
		}
		
	}

}
