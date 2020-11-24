import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class ActualService extends HttpServlet
{

public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
 {
super.service(req,res);
res.setContentType("text/html");
   PrintWriter out = res.getWriter();
out.println("<html><body>");
out.println("Actual  service");
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



