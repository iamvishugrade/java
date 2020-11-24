package my;
import java.sql.*;
 public  class MyBean 
{
private String name;
private String  pass;

public void setName(String name)
{
this.name=name;
}
public void setPass(String  pass)
{
this.pass=pass;
}
public String getName()
{
return name;
}
public String  getPass()
{
return pass;
}
public String validate()
{
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
	
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mca6");
Statement s = c.createStatement();
String  s1="select * from emp101  where   name='"+name+"'  and pass='"+pass+"'";
ResultSet rs=s.executeQuery(s1);
if(rs.next())
return  "wel.jsp";
else
return  "err.jsp";
}catch(Exception e){return  "invalid";}     
}
}