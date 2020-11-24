import java.sql.*;
import java.io.*;
class Sequence
{
	public static void main(String []ss)
	{
		try{
Class.forName("oracle.jdbc.driver.OracleDriver");
	
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mca6");
Statement s = c.createStatement();
//s.executeUpdate("create sequence seq10 increment by 1 start with 100 maxvalue 200");
//s.executeUpdate("drop table emp15");
//s.executeUpdate("create table emp15(id  number)" );
s.executeUpdate("insert into emp15 values(seq10.nextval)");
s.close();
}catch(Exception e){ }
}
}
		
		











