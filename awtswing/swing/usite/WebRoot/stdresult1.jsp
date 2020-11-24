<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@page import ="tarique.StdData"%>
<%@page import ="tarique.StdResult"%>

<jsp:useBean id="bean5" class="tarique.StdResult" scope="request"/>
<jsp:setProperty name="bean5" property="*" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>

<body>
<%!StdData ds1;%>
<table width="308" height="144" border="1">
  <tr>
    <td><form name="form1" method="post" action="resultdetails.jsp">
      <table width="296" height="76" border="1">
        <tr>        
          <td width="114">Roll Number </td>
          <td width="166"><input name="rollno" type="text" value="">
      &nbsp;</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td>
           <%
                        ArrayList al1=bean5.collegeInfo();
                        Iterator i1=al1.iterator();
                        while(i1.hasNext()) 
                        {
                         sd1=(StdData)i1.next();
                         System.out.println(sd1);
                        }
            %>
          <input name="22" type="submit" value="Submit">
          </td>
          
        </tr>
      </table>
      
      
  
    </form></td>
  </tr>
</table>
</body>
</html>
