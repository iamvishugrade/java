import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class ExcelServlet extends HttpServlet
{
PrintWriter out;
public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
 {
 res.setContentType("application/vnd.ms-excel");
out = res.getWriter();
out.println("names\thindi\teng\tmaths\ttotal");
out.println("bhalu\t 35\t 20\t 95\t=sum(b2:d2)");

}

}








