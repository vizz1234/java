<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>insert book details</title>
</head>
<body>
<form action="book.jsp">
book_no:<br>
<input type="number" name="no"><br>
title:<br>
<input type="text" name="title"><br>
author:<br>
<input type="text" name="author"><br>
publication:<br>
<input type="text" name="publication"><br>
price:<br>
<input type="number" name="price"><br>
<input type="submit">
</form>
</body>
</html>





<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.sql.*" %>
 <%@ page import="javax.servlet.*" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserting book details</title>
</head>
<body>
<%
int no=Integer.parseInt(request.getParameter("no"));
String title=request.getParameter("title");
String author=request.getParameter("author");
String publication=request.getParameter("publication");
int price=Integer.parseInt(request.getParameter("price"));
try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
	String sql="insert into books values(?,?,?,?,?)";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setInt(1, no);
	ps.setString(2, title);
	ps.setString(3, author);
	ps.setString(4, publication);
	ps.setInt(5,price);
	ps.executeUpdate();
	out.println("values inserted successfully");
	RequestDispatcher rd=getServletContext().getRequestDispatcher("/seven_b_one.html");
	rd.forward(request, response);
}
catch(Exception e)
{
	out.print(e);
}
%>
</body>
</html>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>get book details</title>
</head>
<body>
<form action="book_two.jsp">
enter title:<br>
<input type="text" name="title"><br>
<input type="submit">
</form>

</body>
</html>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String title=request.getParameter("title");
		/*String author=request.getParameter("author");
		String publication=request.getParameter("publication");
		int price=Integer.parseInt(request.getParameter("price"));*/
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			String sql="select * from books where title=?";
			ResultSet rs;
			PreparedStatement ps=con.prepareStatement(sql);
			//ps.setInt(1, no);
			ps.setString(1, title);
			/*ps.setString(3, author);
			ps.setString(4, publication);
			ps.setInt(5,price);*/
			rs=ps.executeQuery();
			//out.println("values inserted successfully");
			//RequestDispatcher rd=request.getRequestDispatcher("seven_b_two.html");
			//rd.forward(request, response);
			while(rs.next())
			{
				out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5));
			}
			con.close();
		}
		catch(Exception e)
		{
			out.print(e);
		}%>
</body>
</html>
