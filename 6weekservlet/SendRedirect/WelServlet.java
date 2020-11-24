import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class WelServlet extends GenericServlet
{

public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
 {

  res.setContentType("text/html");
    PrintWriter out = res.getWriter();
out.println("<html><body>");
out.println("  welcome   to  ducat web   ");
out.println("</body></html>");
}

}





