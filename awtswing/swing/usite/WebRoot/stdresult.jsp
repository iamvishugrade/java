<%@ page contentType="text/html; charset=iso-8859-1" language="java" errorPage="" %>
<%@ page import="java.util.*"%>


<jsp:useBean id="bean5" class="tarique.StdResult" scope="request"/>
<jsp:setProperty name="bean5" property="*" />


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>

<body>
<br>
<br>
<br>
<br>

<table align=center 
cellpadding=0 cellspacing=0 style="FONT-SIZE: 21px; BORDER-COLLAPSE: collapse">
  <tbody>
    <tr>
      <td align=middle><font face=Verdana size=4><u>First Year B.Tech. Result(2007-08)</u></font></td>
    </tr>
  </tbody>
</table>
<br>
<br>
<table width="1012" height="104" border="0">
  <tr>
    <td height="98" align="center">
    <form name="form1" method="post" action="marksheet.jsp">
        <table width="296" height="60" border="0">
          <tr>
<td width="114">Roll No:
<%
ArrayList al[] =bean5.rollNo1();
%>

<%--<%if(bean4==null)
{
%>
<jsp:forward page="error.jsp" />
<%
}%> --%>

</td>
								<td width="166">
									<INPUT name="rollno" type="text" value=""> &nbsp;</td>
								<TD><INPUT name="22" type="submit" value="Submit"></TD>
							</tr>
          
        </table>
    </form></td>
  </tr>
</table>

      <BR>
	  <BR>
<TABLE style="FONT-SIZE: 11px; BORDER-COLLAPSE: collapse" cellSpacing=0 
cellPadding=0 align=center>
  <TBODY>
  <TR>
    <TD style="FONT-SIZE: 12px; FONT-FAMILY: Verdana">
      <BLOCKQUOTE>
        <OL>
          <LI>Although atmost care has been exercised in preparation of marks; 
          yet if at any stage any error is detected based on facts; these marks 
          will be treated as null and void and fresh factual marks would be 
          given. 
          <LI>If it is detected at any stage that a student appeared in the 
          examination in violation of admission /examination rules/norms. The 
          statement of marks given herein will be treated as null and void. 
        </LI></OL></BLOCKQUOTE></TD></TR>
   </TBODY>
</TABLE>
   </BODY>
</HTML>
