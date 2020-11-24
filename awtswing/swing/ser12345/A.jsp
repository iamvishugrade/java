<html>
<body>
 <table width="110%">
        <tr>
          <td>
            <%@ include file="../html/header.html" %></td>
        </tr>
      </table>
<jsp:useBean id="data" class="pack.RegistrationBean"/>
<jsp:setProperty name="data" property="*"/>

<font size="18">

<br>

<table width="350" align="center"    border="1" cellspacing="2" cellpadding="2">
  <tr>
  <%
String sex=request.getParameter("sex");
System.out.println(sex);
String email1=request.getParameter("email1");
System.out.println("email is........."+email1);
session.setAttribute("email1",email1);
out.println(email1);
if(data.Registration())
%>
   <td  align="center" >You are secessfully registered </td>
    </tr>
 	<td align="center"><a href="home.jsp">login page</a></td>
   </tr>
</tr>
 	<td align="center"><a href="third123.jsp">Profile Submition Page</a></td>
   </tr>
   <%
   else
   %>
    <td >you are not registered try again </td>
   
</table>
</font>
</body></html>
