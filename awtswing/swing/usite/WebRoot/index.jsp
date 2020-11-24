
<%@ page language="java" import="java.util.*" import="java.sql.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    
    
    <title>My JSP 'index.jsp' starting page</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  </head>
  
  <body>
   <TABLE>
   <TR></TR>
   <TR><td></TR>
       </td>
      </TR>
       
  
     <TR>
   
   
   <TR></TR>
   </TABLE> <br>
   <table width="975" height="492" border="1">
     <tr>
       <td height="29"><%@include file= "html/header.html" %>
       <a href="registration.jsp">StudentRegistration</a></td>
     </tr>
     <tr>
       <td height="29"><%@include file="html/menu.html" %></td>
     </tr>
     <tr>
       <td height="332"><table width="961" height="317" border="1">
         <tr>
           <td width="141"><% 
String anwer=(String)session.getAttribute("invalid");
if(anwer==null)
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:tarique");
Statement st=con.createStatement();
session.setAttribute("st",st);
session.setAttribute("con",con);
session.setAttribute("session","MEMBER LOGED IN:");
System.out.println("driver successfully loaded:");
}
		%></td>
           <td width="683">
            <jsp:include page="home.jsp" flush="true"/>
		    </td>
           <td width="115"><table width="115" height="234" border="1">
             <tr>
               <td><jsp:include page="login.jsp" flush="true" />
			   </td>
             </tr>
             <tr>
               <td>&nbsp;</td>
             </tr>
           </table></td>
         </tr>
       </table></td>
     </tr>
     <tr>
       <td>FOOTER</td>
     </tr>
   </table>
  </body>
</html>
