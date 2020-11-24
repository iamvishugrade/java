import java.sql.*;
class BatchUpdate
{
	public static void main(String []ss)
	{
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mca6");
Statement s = c.createStatement();
String s1="update employee set empname='meesa1' where id=18";
String s2="insert into employee values(113,'ladyfinger1',200)";
String s3="delete from employee where id=111";
s.addBatch(s1);
s.addBatch(s2);
s.addBatch(s3);
s.executeBatch();
ResultSet result1=s.executeQuery("select * from employee");
while(result1.next())
{
System.out.println("ID "+result1.getString(1));
System.out.println("name" + result1.getString(2));
System.out.println("salary " + result1.getString(3));		
}

}catch(Exception e){ System.out.println(e);}

}
}


