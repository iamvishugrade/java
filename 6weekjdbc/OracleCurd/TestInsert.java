import java.sql.*;

class TestInsert
{
	public static void main(String []ss)
	{
	try{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mca6");
String t1="audiq7";
String  t2="1001";
Statement s = c.createStatement();
int x=s.executeUpdate("insert into emp101 values('"+t1+"','"+t2+"')");
System.out.println(x);
 ResultSet result1=s.executeQuery("select * from emp101");

		while(result1.next())
		{
System.out.println( result1.getString(1));
System.out.println( result1.getString(2));
		
		}

		}catch(SQLException e)
		{
			System.out.println(e);	
		}		
		catch(Exception i){System.out.println(i);}
	}
}





//int x=s.executeUpdate("insert into emp values('"+t1+"',"+t3+")");
//int z1=s.executeUpdate("update emp set name='"+z+"'where id="+t4);
//int a=s.executeUpdate("delete from emp where id="+t5);





//int x=s.executeUpdate("update emp set name='"+t1+"'where id="+t2);

//int x=s.executeUpdate("create table emp7(name varchar(20), salary double)" );
//System.out.println(x);
 //int x=s.executeUpdate("delete from emp where id="+t3);
//System.out.println(x);
//s.executeUpdate("create table emp7(name varchar(20), salary double)" );
//
//DriverManager.getConnection("jdbc:odbc:mydsn","system","mca6");
//
//System.setProperty("jdbc.drivers","sun.jdbc.odbc.JdbcOdbcDriver");
		//Driver d=new sun.jdbc.odbc.JdbcOdbcDriver();
			//Properties dbProp = new Properties();
 
 //dbProp.put("databaseName", "mydsn");
//dbProp.put("user", "system");
//dbProp.put("password", "mca6");
		//Connection c=d.connect("jdbc:odbc:mydsn",dbProp );
 	//Connection c= DriverManager.getConnection("jdbc:odbc:mydsn", dbProp);
//DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
//Connection c=DriverManager.getConnection("jdbc:odbc:mydsn","system","mca6");
//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//dbProp.put("databaseName", "mydsn");




//s.executeUpdate("create table emp11(name varchar(20), id double)" );
//s.executeUpdate("drop table emp12" );
//int x=s.executeUpdate("insert into emp values('"+t1+"',"+t3+")");
//System.out.println(x);
//s.executeUpdate("update emp11 set name='"+t1+"'where id="+t2);
//s.executeUpdate("delete from emp11 where id="+t2);
//int x=s.executeUpdate("update emp set name='"+t2+"'where id='"+t1+"'");
//int x = s.executeUpdate("delete from emp where id='"+t1+"'");
//System.out.println(x);
//int x = s.executeUpdate("delete from emp where id='"+t1+"'");
//int x=s.executeUpdate("update emp set name='"+t2+"'where id='"+t1+"'");

//Driver d=new sun.jdbc.odbc.JdbcOdbcDriver();
//Connection c=d.connect("jdbc:odbc:mydsn",dbProp );

//Properties dbProp = new Properties();
//dbProp.put("user", "system");
//dbProp.put("password", "mca6");
//Connection c= DriverManager.getConnection("jdbc:odbc:mydsn", dbProp);

