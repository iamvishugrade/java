import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import com.oreilly.servlet.*;

public class FileUploadServlet1 extends GenericServlet
{

public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
 {
res.setContentType("text/html");
    PrintWriter out = res.getWriter();
String   fname=req.getParameter("file");
out.println(fname);
/*String  z[]=fname.split(".");
if(z[1].equals("exe"))
{
out.println("bavari pooch exe not allowed");
}
else
{
MultipartRequest mpr=new MultipartRequest(req,getServletContext().getRealPath("file"),500*1024*1024);
  
out.println("<html><body>");
out.println("File uploaded successfullyaaaaaaaa");
out.println("</body></html>");
}*/
}

}





