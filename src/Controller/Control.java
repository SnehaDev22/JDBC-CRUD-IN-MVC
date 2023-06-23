package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

import model.Employee;

public class Control {
	 Employee e=new Employee();
	Scanner s=new Scanner(System.in);
	
	 
	
   public Connection connect() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mypract123","root","abc123");
		return con;
	}
   
	public void add() throws ClassNotFoundException, SQLException
	{
		//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mypract123","root","abc123");
	   Connection con = connect();
		
		System.out.println("Enter id:");
		int id=Integer.parseInt(s.nextLine());
		System.out.println("enter name:");
		String name=s.nextLine();
		System.out.println("enter address:");
		String address=s.nextLine();
		PreparedStatement st=con.prepareStatement("insert into mypract123.pract values (?,?,?)");
		
		st.setInt(1, id);
		st.setString(2, name);
		st.setString(3,address);
		int a=st.executeUpdate();
		
		if(a>0)
		{
			System.out.println("data added");
		}
		else
		{
		System.out.println("data not added");	
		}
	}
	
	public void show() throws ClassNotFoundException, SQLException
	{
		Connection con = connect();
	    
		ResultSet rs=null;
		PreparedStatement st=con.prepareStatement(" select *from mypract123.pract");
		rs=st.executeQuery();
		while(rs.next())
		{
			System.out.println("  "+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}
		
		
	}
	
	public void search() throws ClassNotFoundException, SQLException
	{    System.out.println("Enter name:");
	     String name=s.nextLine();
	     Connection con = connect();
		ResultSet rs=null;
		PreparedStatement st=con.prepareStatement(" select *from mypract123.pract where name like '"+name+"%'");
	   // st.setString(1, name);
		rs=st.executeQuery();
		System.out.println("  Id Name Address  ");
		while(rs.next())
		{   
			System.out.println("  "+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}
	
	}
	
	public void update() throws ClassNotFoundException, SQLException
	{ 
	System.out.println("Enter id:");
	int id=Integer.parseInt(s.nextLine());
	System.out.println("Enter name:");
	String name=s.nextLine();
	System.out.println("Enter address:");
	String address=s.nextLine();
	Connection con = connect();
		PreparedStatement st=con.prepareStatement("update mypract123.pract set name=? , address=? where id=? ");
	    st.setString(1, name);
	    st.setString(2, address);
	    st.setInt(3, id);
	    int b=st.executeUpdate();
	    if (b>0)
	    {
	    	System.out.println("updated");
	    }
	    else
	    {
	    	System.out.println("not updated");
	    }
	}
	
	public void delete() throws ClassNotFoundException, SQLException
	{   System.out.println("Enter id:");
	    int id=Integer.parseInt(s.nextLine());
	    Connection con = connect();
		PreparedStatement st=con.prepareStatement("delete from mypract123.pract where id=?");
		st.setInt(1, id);
		int c=st.executeUpdate();
		if(c>0)
		{
			System.out.println("deleted");
	    }
	    else
	    {
	    	System.out.println("not deleted");
	    }
		
	}
	
	

}
