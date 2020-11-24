<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="bean1" scope="page" class="tarique.RegistrationBean"/>
<jsp:setProperty name="bean1" property="*" />
<%
  String base = (String) application.getAttribute("base");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>

<body>
<p>&nbsp;</p>
<table width="965" height="548" border="1">
  <tr>
    <td width="709">&nbsp;
    <A class=mainLink onclick="validateLogin();return false;"  
     href="login.jsp">Login</A>
    </td>
  </tr>
  <tr>
    <td height="375" align="center"><form name="form1" method="post" action="">
        <table width="786" border="1">
		<% String fn=request.getParameter("fname");
		System.out.println(fn);
		%>
<%
  Hashtable entries = bean1.getData();
  Enumeration record = entries.keys();
  while (record.hasMoreElements()) {
    Object entries1 = record.nextElement();
    out.println("hello");
  }
%>
          <tr>
            <td>First Name </td>
            <td><input name="fname" type="text" ></td>
            <td>High School Marks </td>
            <td><input name="hsmarks" type="text" ></td>
          </tr>
          <tr>
            <td width="183">Last Name</td>
            <td width="209"><input name="lname" type="text" >
        &nbsp;</td>
            <td width="189">Passing Year </td>
            <td width="177"><input name="hsyear" type="text" ></td>
          </tr>
          <tr>
            <td>Father Name </td>
            <td><input name="fathername" type="text" >
            </td>
            <td>Intermediate Marks</td>
            <td><input name="imarks" type="text" ></td>
          </tr>
          <tr>
            <td>Permanent Address </td>
            <td align="left">
              <input name="paddress" type="text" ></td>
            <td align="left">Passing Year </td>
            <td align="left"><input name="iyear" type="text" ></td>
          </tr>
          <tr>
            <td>Correspondence Address </td>
            <td><input name="caddress" type="text" ></td>
            <td>Graduation Marks </td>
            <td><input name="gmarks" type="text" ></td>
          </tr>
          <tr>
            <td>Join Date </td>
            <td><input name="joindate" type="text" ></td>
            <td>Passing Year </td>
            <td><input name="gyear" type="text" ></td>
          </tr>
          <tr>
            <td>Sex</td>
            <td><input name="sex" type="text" ></td>
            <td>Post Graduation </td>
            <td><input name="pgmarks" type="text" ></td>
          </tr>
          <tr>
            <td>Experience</td>
            <td><input name="experience" type="text" ></td>
            <td>Passing Year </td>
            <td><input name="pgyear" type="text" ></td>
          </tr>
          <tr>
            <td>Subject</td>
            <td><input name="subject" type="text" ></td>
            <td>Other</td>
            <td><input name="other" type="text" ></td>
          </tr>
          <tr>
            <td align="left">Phone No </td>
            <td><input name="phoneno" type="text" ></td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td align="left">Mobile</td>
            <td><input name="mobile" type="text" ></td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td colspan="4" align="center"><input name="account" type="submit" value="I accept. Create My Account"></td>
          </tr>
        </table>
    </form></td>
  </tr>
  <tr>
    <td height="140">&nbsp;</td>
  </tr>
</table>
<p>&nbsp;</p>
</body>
</html>
