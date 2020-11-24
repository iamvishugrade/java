import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class RequestServlet extends HttpServlet
{

/*public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
 {

res.setContentType("text/html");
   PrintWriter out = res.getWriter();
out.println("<html><body>");
String name=req.getParameter("name");
  String pass=req.getParameter("pass");

if(name.equals("DUCAT") && pass.equals("DUCAT"))
	    out.println("User is valid through service method");
  else
	out.println("User is invalid through service method");
out.println("</body></html>");
	
}*/
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
 {
  res.setContentType("text/html");
  
  PrintWriter out = res.getWriter();
out.println("<html><body>");
String name=req.getParameter("name");
  String pass=req.getParameter("pass");
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
	
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mca6");

Statement s = c.createStatement();


int x = s.executeUpdate("insert into emp101  values('"+name+"','"+pass+"')");
ResultSet rs=s.executeQuery("select * from emp101");
while(rs.next())
{
out.println(rs.getString(1));
out.println(rs.getString(2));
out.println("<br>");
}
}catch(Exception e){ }
if(name.equals("DUCAT") && pass.equals("DUCAT"))
	    out.println("User is post valid");
  else
	out.println("User is post invalid");
out.println("</body></html>");
	
}
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
 {
  res.setContentType("text/html");
  
  PrintWriter out = res.getWriter();
out.println("<html><body>");
String name=req.getParameter("name");
  String pass=req.getParameter("pass");

if(name.equals("DUCAT") && pass.equals("DUCAT"))
	    out.println("User is valid through get");
  else
	out.println("User is invalid through get");
out.println("</body></html>");
	
}
}











/*public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
 {
res.setContentType("text/html");
   PrintWriter out = res.getWriter();
out.println("<html><body>");
String  s=req.getMethod();
out.println(s);
if(s.equals("POST"))
doPost(req,res);
if(s.equals("GET"))
doGet(req,res);

}*/



