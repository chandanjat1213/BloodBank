

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
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String a = request.getParameter("age");
		int age = Integer.parseInt(a);
		String bgruop = request.getParameter("gruop");
		String hospital = request.getParameter("hospital");
		Person p = new Person();
		p.setName(name);
		p.setAge(age);
		p.setBgroup(bgruop);
		p.setHospital(hospital);
		Rdao r = new Rdao();
		try
		{
			int i = r.update(p);
			RequestDispatcher rd = request.getRequestDispatcher("Show");
			rd.include(request, response);
			if(i>0)
			{
				out.println("<script>window.aleret('successfully update');l</script>");
			}
			else
			{
				out.println("<script>window.aleret('not update');l</script>");

			}
					
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}
