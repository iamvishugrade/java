import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class PMD {
  public static void main(String[] args) throws Exception {
    Connection conn = getConnection();
    Statement st = conn.createStatement();

    st.executeUpdate("create table survey (id int,name varchar(30));");

    String sql = "INSERT INTO survey (id) VALUES(?)";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    ParameterMetaData pmd = pstmt.getParameterMetaData();

    int totalDigits = pmd.getPrecision(1);
    int digitsAfterDecimal = pmd.getScale(1);
    boolean b = pmd.isSigned(1);
    System.out.println("The first parameter ");
    System.out.println("    has precision " + totalDigits);
    System.out.println("    has scale " + digitsAfterDecimal);
    System.out.println("    may be a signed number " + b);

    int count = pmd.getParameterCount();
    System.out.println("count is " + count);

    for (int i = 1; i <= count; i++) {
        int type = pmd.getParameterType(i);
        String typeName = pmd.getParameterTypeName(i);
        System.out.println("Parameter " + i + ":"); 
        System.out.println("    type is " + type); 
        System.out.println("    type name is " + typeName); 
    }



    st.close();
    conn.close();
  }
  private static Connection getConnection() throws Exception {
    Class.forName("org.hsqldb.jdbcDriver");
    String url = "jdbc:hsqldb:mem:data/tutorial";

    return DriverManager.getConnection(url, "sa", "");
  }
}