import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.DateFormat;
public class  ImageServlet extends HttpServlet {
   
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
      String fileName ="baby.jpg";
      ServletOutputStream stream = null;
      BufferedInputStream buf = null;
        stream = response.getOutputStream();
String s1=getServletContext().getRealPath("/files/baby.jpg");
     File doc = new File(s1);
     
     
      response.setContentType("image/jpeg");
      
      response.addHeader(
        "Content-Disposition","attachment; filename="+fileName );

      response.setContentLength( (int) doc.length() );
      
     FileInputStream input = new FileInputStream(doc);
     buf = new BufferedInputStream(input);
     int readBytes = 0;

     while((readBytes = buf.read()) != -1)
        stream.write(readBytes);
   
    }
   
  
}
