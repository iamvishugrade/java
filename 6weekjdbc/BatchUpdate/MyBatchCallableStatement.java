import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class MyBatchCallableStatement {
 
    public static void main(String a[])
{
         
        
        CallableStatement callSt = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
          Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");
Statement s = conn.createStatement();
            callSt = conn.prepareCall("{call recins88(?,?)}");
            callSt.setInt(1,5041);
            callSt.setString(2,"ducatindia1");
            callSt.addBatch();
            callSt.setInt(1,9081);
            callSt.setString(2,"india91");
            callSt.addBatch();
            int[] updateCounts = callSt.executeBatch();
 ResultSet result1=s.executeQuery("select * from emp65");
		while(result1.next())
		{
System.out.println("ID "+result1.getString(1));
System.out.println("name " + result1.getString(2));
		
		}
        } catch (Exception e) {
          
            e.printStackTrace();
        }
    }
}