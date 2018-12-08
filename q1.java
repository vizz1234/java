
import java.util.Date;
import java.io.IOException;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class q1
 */
@WebServlet("/q1")
public class q1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public q1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String p1=request.getParameter("p");
		String p2=request.getParameter("cp");
		String name=request.getParameter("name");
		Date d=new Date();
		String s=d.toString();
		
		if(p1.equals(p2) )
		{
			if(s.charAt(12)<'3') {
				pw.println("<h3> Good Morning </h3> , <h1>"+name+"</h1>");
			}
			else
				pw.println("<h3> welcome </h3> , <h1>"+name+"</h1>");
		}
		pw.println("confirm the password correctly");
		pw.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
