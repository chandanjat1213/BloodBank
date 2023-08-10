

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

@WebServlet("/AddPerson")
public class AddPerson extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String a = request.getParameter("age");
		int age = Integer.parseInt(a);
		String bgroup = request.getParameter("bgroup");
		String hospital = request.getParameter("hospital");
		
		Person p = new Person();  
		
		p.setName(name);
		p.setAge(age);
		p.setBgroup(bgroup);
		p.setHospital(hospital);
		Rdao r = new Rdao();
		try
		{
		   int i = r.addperson(p);
		   RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		   rd.include(request, response);
		   out.println( i+"person donet successfully");
		}
		catch(Exception e)
		{
           out.println(e);		
		}
	}

}
