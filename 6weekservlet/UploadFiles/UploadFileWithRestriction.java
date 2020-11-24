import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.oreilly.servlet.*;
//import com.servlet.upload.*;


public class UploadFileWithRestriction extends HttpServlet
{ 
 public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
 {
  PrintWriter out=response.getWriter();
  response.setContentType("text/html");
  out.println("<html><body>");
  String path=getServletContext().getRealPath("/file");   
  String ext=".txt";
  try
  {
   MultipartRequest mbr=new MultipartRequest(request,path,500*1024*1024,ext);
   out.println("File uploaded successfully");
  }catch(Exception eup){out.println("File can not be upload which have "+ext+" Extension");}

  out.println("</body></html>");
 } 
}