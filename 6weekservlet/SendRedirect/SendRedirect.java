import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class SendRedirect extends HttpServlet
{

public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
 {
  res.setContentType("text/html");
  
PrintWriter out = res.getWriter();
out.println("<html><body>");
out.println("before");
String name=req.getParameter("name");
 String pass=req.getParameter("pass");
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
	
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mca6");
Statement s = c.createStatement();
String  s1="select * from emp101  where   name='"+name+"'  and pass='"+pass+"'";
ResultSet rs=s.executeQuery(s1);
if(rs.next())
res.sendRedirect("https://google.com");
//res.sendRedirect("wel");
//res.sendRedirect("http://localhost:9090/tom/wel");
else
res.sendRedirect("err");
}catch(Exception e){out.println(e);}     
out.println("after");
out.println("</body></html>");
}
}
//res.sendRedirect("http://localhost:9091/tom22/wel");






 