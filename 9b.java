import java.util.*;
import java.sql.*;
import java.io.*;
public class nine_b {
public static void main(String args[])
{
	try
	{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		con.setAutoCommit(false);
		String acc_num,name,branch;
		int balance;
		String sql="insert into account values(?,?,?,?)";
		
		int ch;
		int w;
		while(true)
		{	
			System.out.println("Do you want to insert? 1/0 ");
			ch=Integer.parseInt(br.readLine());
			if(ch==0)
				break;
			else {
				System.out.println("enter acc_num, name, balance, branch");
				PreparedStatement ps=con.prepareStatement(sql);
				acc_num=br.readLine();
				name=br.readLine();
				balance=Integer.parseInt(br.readLine());
				branch=br.readLine();
				ps.setString(1, acc_num);
				ps.setString(2, name);
				ps.setInt(3, balance);
				ps.setString(4, branch);
				ps.executeUpdate();
				con.commit();
				
			}
		}
		Savepoint sp1=con.setSavepoint();
		System.out.println("enter the amount to withdraw and account number");
		sql="update account set balance=balance-? where acc_num=?";
		PreparedStatement ps1=con.prepareStatement(sql);
		w=Integer.parseInt(br.readLine());
		acc_num=br.readLine();
		System.out.println(acc_num);
		ps1.setInt(1, w);
		ps1.setString(2, acc_num);
		ps1.executeUpdate();
		sql="select balance from account where acc_num="+acc_num;
		ResultSet rs;
		rs=st.executeQuery(sql);
		rs.next();
			balance=rs.getInt(1);
			//System.out.println(balance);
			if(balance<500)
			{	
				//System.out.println("hello");
				con.rollback(sp1);
			}
			
		
		con.commit();
		con.close();
		
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
}
