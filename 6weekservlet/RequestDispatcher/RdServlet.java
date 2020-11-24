import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class RdServlet extends HttpServlet
{

public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
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
String  s1="select * from emp101  where   name='"+name+"'  and pass='"+pass+"'";
ResultSet rs=s.executeQuery(s1);
out.println("before dispatcher");
out.println("<br>");
if(rs.next())
{

RequestDispatcher rd=req.getRequestDispatcher("/wel");
//rd.include(req,res);
rd.forward(req,res);
}
else
{
RequestDispatcher rd=req.getRequestDispatcher("/err");
//rd.include(req,res);
rd.forward(req,res);
}
}catch(Exception e){out.println(e);}     
out.println("<br>");
out.println("after  requestDispatcher");
out.println("</body></html>");
}
}


//req.setAttribute("name","ducat");

//res.sendRedirect("http://localhost:9091/s3/wel");

/*  out.println("<HTML> <BODY> "); 	
String name=req.getParameter("name");
  String pass=req.getParameter("pass");

  if(name.equals("DUCAT") && pass.equals("DUCAT"))
	    out.println("User is valid");
  else
	out.println("User is invalid");
	out.println("</body></html>");*/

 