
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
Statement st1=(Statement)session.getAttribute("st");
Connection con1=(Connection)session.getAttribute("con");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
    <br>
<br>
<table width="300" height="135" border="1">
  <tr>
       <td width="464" align="center">
      <form name="form1" method="post">
 <%
try
{
		String name=request.getParameter("username");
		String pass=request.getParameter("password");
	
  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  Connection con = DriverManager.getConnection("jdbc:odbc:tarique");
  
  Statement st = con.createStatement();
 System.out.println(name+" "+pass);
			ResultSet rs=st.executeQuery("select * from User where LoginName='"+name+"'");
		if(rs.next())
		{
		String un=rs.getString(1);
		String up=rs.getString(2);
		
			if(up.equals(pass)&&un.equals(name))
			{
			%>
        <jsp:forward page="StdResult.jsp"></jsp:forward>
        	<%
			}
			else
			{
			%>
        <jsp:forward page="login.jsp"></jsp:forward>
            <%
			}		
		}
	}catch(Exception e){}
	
%>
        <table width="91%" height="101" border="1" bgcolor="#ffffcc">
          <tr>
            <td align="right" width="45%">Login Name</td>
            <td width="55%"><input type="text" name="username">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
          </tr>
          <tr>
            <td align="right" width="45%"> Password</td>
            <td width="55%"><input type="text" name="password"></td>
          </tr>
          <tr>
            <td width="45%" height="28"  align="right" valign="middle"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td width="55%"> <font size="2">
              <input type="submit" name="sub" value="Login">
            </font></td>
          </tr>
        </table>
    </form></td>
  </tr>
</table>
  </body>
</html>
