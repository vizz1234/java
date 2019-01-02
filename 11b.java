<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Faculty</title>
</head>
<body>
<form action="faculty">
enter faculty id:<br>
<input type="text" name="fid"><br>
Update details: <br>
Subject id:<br>
<input type="text" name="sid"><br>
Subject name:<br>
<input type="text" name="sname"><br>
<input type="submit">
</form>
</body>
</html>



import java.io.*;
import java.util.*;
import java.sql.*;
import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class faculty
 */
@WebServlet("/faculty")
public class faculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public faculty() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		int sid=Integer.parseInt(request.getParameter("sid"));
		int fid=Integer.parseInt(request.getParameter("fid"));
		//int c;
		String sname=request.getParameter("sname");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			String sql="update faculty set sid=?,sname=? where fid=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, sid);
			ps.setString(2, sname);
			ps.setInt(3, fid);
			int c=ps.executeUpdate();
			out.println("no. of rows updated : "+c);
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
