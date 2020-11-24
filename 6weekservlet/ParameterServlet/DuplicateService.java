import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class DuplicateService extends HttpServlet
{


public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
 {
super.service(req,res);
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



