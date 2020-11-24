import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class WelServlet extends GenericServlet
{

public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
 {

  res.setContentType("text/html");
    PrintWriter out = res.getWriter();
//String   s=(String)req.getAttribute("name");
out.println("<html><body>");
out.println("  welcom   to  MyWeb of ducat ");
out.println("</body></html>");
}

}





