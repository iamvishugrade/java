
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
public class MyBatchPreparedStmt 
{
 
public static void main(String a[])
{
         
        Connection con = null;
        PreparedStatement pst = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
           con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");
Statement s = con.createStatement();
 pst = con.prepareStatement("update employee set  empsalary=? where id=?");
            pst.setInt(1,5);
            pst.setInt(2,113);
            pst.addBatch();
            pst.setInt(1, 80);
            pst.setInt(2,1111);
            pst.addBatch();
            int count[] = pst.executeBatch();
          ResultSet result1=s.executeQuery("select * from employee");
		while(result1.next())
		{
System.out.println("ID "+result1.getString(1));
System.out.println("salary  " + result1.getString(3));
		
		}
        } catch (Exception e)
	 {
            	e.printStackTrace();
                    }
            
               
               
           
        
    }
}