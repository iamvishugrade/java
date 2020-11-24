package pack;
import java.sql.*;
public class ValidationBean
{
private String name,pass;

public String getPass()
{
return pass;
}
public void setPass(String pass)
{
this.pass=pass;
System.out.println("pass is ........."+pass);
}
public String getName()
{
return name;
}
public void setName(String name)
{

this.name=name;
System.out.println("mail is......."+name);
}

	public boolean validation()
	{
	try
	{
	boolean flag=false;
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection con=DriverManager.getConnection("jdbc:odbc:shaadi");
	System.out.println("driver is loaded:");
	Statement stm=con.createStatement();
	ResultSet rs=stm.executeQuery("select * from login");
	while(rs.next())
	{
	if((rs.getString(4).equals(pass)) && (rs.getString(3).equals(name)))
	{	
	flag= true;
	System.out.println("flag is  ... .."+flag);
	}
	}
	
	con.close();
	return flag;
	}
	catch(Exception e)
	{
	return false;
	}
	}
}
