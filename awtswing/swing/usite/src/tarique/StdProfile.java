package tarique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class StdProfile 
{
	Connection con;
	Statement st,st1;
	
	
	public StdProfile()
	{
	try
	{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    con = DriverManager.getConnection("jdbc:odbc:tarique");
    //System.out.println("driver successfully");
	}catch(Exception e){}
	}
	public ArrayList[] getStudentDetails()
	{
		ArrayList al[]=new ArrayList[2];
		try
		{
			al[0]=new ArrayList();
			al[1]=new ArrayList();
		st=con.createStatement();
		st1=con.createStatement();
		int r=110;
	    ResultSet rs=st.executeQuery("select * from StdRegistration where rollno="+r);
	    ResultSet rs1=st1.executeQuery("select * from InstituteDetails where rollno="+r);
	    while(rs.next())
		{
			
			StdData sd=new StdData();
			sd.rollno=rs.getInt(1);
			sd.stdname=rs.getString(2);
			sd.fathername=rs.getString(3);
			sd.course=rs.getString(6);
			sd.branch=rs.getString(7);
			sd.paddress=rs.getString(11);
			sd.caddress=rs.getString(12);
			sd.city=rs.getString(13);
			sd.dob=rs.getString(4);
			sd.gender=rs.getString(5);
			sd.mobile=rs.getString(18);
			sd.email=rs.getString(19);
			sd.session=rs.getString(10);
			sd.status=rs.getString(25);
			
			al[0].add(sd);
		}
		while(rs1.next())
		{
			StdData1 sd1=new StdData1();
			sd1.iname=rs1.getString(3);
			sd1.univname=rs1.getString(5);
			al[1].add(sd1);
			System.out.println("**********************"+al[1]);	
		}
		
		//con.close();
		//rs.close();
		//rs1.close();
		}catch(Exception e){e.printStackTrace();}
		return al;
		
	}
	
	
	
}
