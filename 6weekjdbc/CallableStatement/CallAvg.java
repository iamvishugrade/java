import java.sql.*;
import java.io.*;

class CallAvg
{

	public static void main(String []ss)
	{
		try{
		
		
Class.forName("oracle.jdbc.driver.OracleDriver");
	
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mca6");

Statement s = c.createStatement();
CallableStatement cs=c.prepareCall("{call  salaryavg}");
ResultSet result1=cs.executeQuery();
		while(result1.next())
		{
System.out.println( result1.getString(1));
System.out.println( result1.getString(2));
		
		}

}catch(Exception e)
{ 
System.out.println(e);
}

}
}


