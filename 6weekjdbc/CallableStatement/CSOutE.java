import java.sql.*;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
 
public class CSOutE {
 
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:xe";
private static final String DB_USER = "system";
private static final String DB_PASSWORD = "mca6";
 public static void main(String[] argv) 
{
 try
 {
outParameter();
 } catch (SQLException e) 
{
System.out.println(e.getMessage());
 }
 }
 private static void outParameter() throws SQLException 
{
Connection dbConnection = null;
CallableStatement callableStatement = null;
 String sql = "{call  getUserById(?,?,?)}";
 try 
{
dbConnection = getDBConnection();
callableStatement =  dbConnection.prepareCall(sql,ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY,
ResultSet.HOLD_CURSORS_OVER_COMMIT);
 callableStatement.setInt(1,4);
callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);
callableStatement.executeUpdate();
 String userName = callableStatement.getString(2);
String salary = callableStatement.getString(3);
System.out.println("UserName : " + userName);
System.out.println("Salary : " + salary);
} 
catch (SQLException e) 
{
System.out.println(e.getMessage());
 }
 finally 
{
 if (callableStatement != null) 
{
callableStatement.close();
}
if (dbConnection != null) 
{
dbConnection.close();
}
}
}
 private static Connection getDBConnection() 
{
Connection dbConnection = null;
try 
{
Class.forName(DB_DRIVER);
 } 
catch (ClassNotFoundException e) 
{
System.out.println(e.getMessage());
 }
 try 
{
 dbConnection = DriverManager.getConnection(
DB_CONNECTION, DB_USER,DB_PASSWORD);
return dbConnection;
 } 
catch (SQLException e) 
{
 System.out.println(e.getMessage());
 }
 return dbConnection;
 }
 }