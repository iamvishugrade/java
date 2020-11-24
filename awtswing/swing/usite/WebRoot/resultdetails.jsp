<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="tarique.StdResult" %>
<%@ page import="tarique.StdData" %>
<%@ page import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<jsp:useBean id="bean4" class="tarique.StdResult" scope="request"/>

<jsp:setProperty name="bean4" property="*"/>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>

<body>
<%! StdData sd;%>
<table width="995" height="501" border="1">
  <tr>
    <td height="42">HEADER</td>
  </tr>
  <tr>
  
    <td height="27">MENU</td>
  </tr>
  <tr>
  
 <%ArrayList al =bean4.rollNo1();
 Iterator i=al.iterator();
 while(i.hasNext())
 {
  sd=(StdData)i.next();
 }
 
 %>

    <td height="351" align="center"><table width="822" height="253" border="1">
      <tr>
        <td><table width="790" border="1">
          <tr>
            <td width="381"><strong>Name:</strong></td>
            <td width="393"><%=sd.stdname%></td>
          </tr>
          <tr>
            <td><strong>Father's Name:</strong></td>
            <td><%=sd.fathername%></td>
          </tr>
          <tr>
            <td><strong>Roll Number:</strong></td>
            <td>
            <jsp:getProperty name="bean4" property="rollno"/><td>
          </tr>
          <tr>
            <td><strong>Status:</strong></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td><strong>Course:</strong></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td><strong>Institute:</strong></td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td>FOOTER</td>
  </tr>
</table>
</body>
</html>
