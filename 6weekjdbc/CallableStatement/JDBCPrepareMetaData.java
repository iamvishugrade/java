import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class JDBCPrepareMetaData {

    private static final String DBURL ="jdbc:oracle:thin:@localhost:1521:xe";
  
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static Connection getConnection() 
    {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBURL);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void createEmployees()
    {
        Connection con = getConnection();
        Statement stmt =null;
        String createString;
        createString = "CREATE TABLE  employees("+
          "`EmployeeID` int(10),"+
          "`Name` varchar(45),"+
        "`Office` varchar(10),"+
          "`CreateTime` timestamp,"+
          "PRIMARY KEY  (`EmployeeID`)"+
          ") ";            
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(createString);
        } catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }
    }
    private static void dropEmployees()
    {
        Connection con = getConnection();
        Statement stmt =null;
        String createString;
        createString = "DROP TABLE IF EXISTS `xe`.`employees`;";            
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(createString);
        } catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }
    }
    
    private static void insertEmployee() 
    {
        Connection con = getConnection();
        Statement stmt = null;

        try {
            stmt = con.createStatement();  

            stmt.addBatch("INSERT INTO employees(EmployeeID, Name, Office) "  
                   + "VALUES(1001, 'lalu', 'patna')");

            stmt.addBatch("INSERT INTO employees(EmployeeID, Name, Office) "  
                    + "VALUES(1002, 'rabari', 'delhi')");            

            stmt.addBatch("INSERT INTO employees(EmployeeID, Name, Office) "  
                   + "VALUES(1003, 'Mupayam', 'up')");            

            int [] updateCounts = stmt.executeBatch();

        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }
    }
    private    static void dropProcedure() {
        Connection con = getConnection();
        Statement stmt =null;
        try {
            stmt = con.createStatement();
            stmt.execute("DROP PROCEDURE IF EXISTS `mydb`.`WhoAreThey`");
        } catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }
        
    }
    
    private    static void createProcedure() {
        Connection con = getConnection();
        Statement stmt =null;
        try {
            stmt = con.createStatement();
               stmt.execute("CREATE PROCEDURE `WhoAreThey`(" +
                       "OUT error VARCHAR(128)," +
                       "IN office VARCHAR(10)) " +
                       "BEGIN "+
                       "SET error = NULL; "+
                       "IF office IS NULL THEN "+
                       "SET error = 'You need to pass in an office number'; "+
                       "ELSE "+
                       "  SELECT EmployeeID, Name FROM employees " + 
                       " WHERE office = office; "+
                       "END IF; "+
                       "END");

        } catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }
        
    }

    public static void getParameterMetaData() {
        Connection con = getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO " +
                  employees(EmployeeID, Name, Office) " + 
                    "VALUES(?,?,?)");  

            ParameterMetaData pmd = stmt.getParameterMetaData();
            int count = pmd.getParameterCount();
            for (int i = 1; i <= count; i++) {
                System.out.println("Name: " + pmd.getParameterType(i));
                System.out.println("TYPE: " + pmd.getParameterTypeName(i));
                String mode = "";
                switch(pmd.getParameterMode(i)) {
                     case ParameterMetaData.parameterModeIn:
                         mode = "IN";
                         break;
                     case ParameterMetaData.parameterModeInOut:
                         mode = "IN/OUT";
                         break;
                     case ParameterMetaData.parameterModeOut:
                         mode = "OUT";
                         break;
                     case ParameterMetaData.parameterModeUnknown:
                         mode = "UNKNOWN";
                         break;
                
                }
                System.out.println("MODE: " + mode);
            }

        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }
        
    }

    public static void getProcedureParameterMetaData() {
        Connection con = getConnection();
        CallableStatement cs = null;
        try {
            cs = con.prepareCall("{call WhoAreThey(?,?)}");
            ParameterMetaData pmd = cs.getParameterMetaData();
            int count = pmd.getParameterCount();
            for (int i = 1; i <= count; i++) {
                System.out.println("Name: " + pmd.getParameterType(i));
                System.out.println("TYPE: " + pmd.getParameterTypeName(i));
                String mode = "";
                switch(pmd.getParameterMode(i)) {
                     case ParameterMetaData.parameterModeIn:
                         mode = "IN";
                         break;
                     case ParameterMetaData.parameterModeInOut:
                         mode = "IN/OUT";
                         break;
                     case ParameterMetaData.parameterModeOut:
                         mode = "OUT";
                         break;
                     case ParameterMetaData.parameterModeUnknown:
                         mode = "UNKNOWN";
                         break;
                
                }
                System.out.println("MODE: " + mode);
            }
            
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        finally {
            if (cs != null) {
                try {
                    cs.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }
        
    }

    public static void main(String[] args) {
        dropProcedure();
        dropEmployees();
        createEmployees();
        insertEmployee();
        getParameterMetaData();
        System.out.println("Call Procedure.....");
        createProcedure();
        getProcedureParameterMetaData();
    }

}