package pack;
import java.sql.*;
public class ThankBean
{
private String plan;

public void setPlan(String plan)
{
this.plan=plan;
System.out.println("your plan is......."+plan);
}
public String getPlan()
{
return plan;
}



public boolean thank()
	{
	try
	{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection con=DriverManager.getConnection("jdbc:odbc:shaadi");
	System.out.println("driver is loaded:");
	
	
PreparedStatement stmt=con.prepareStatement("insert into membermode values(?)");
	stmt.setString(1,plan);
	
	System.out.println("value are setted");
	stmt.executeUpdate();
	System.out.println("execute update in thank bean");
		//System.out.println(getDate());	
	con.commit();
	con.close();
	return true;
	}
	catch(Exception e)
	{
	return false;
	}
	}
	
}
