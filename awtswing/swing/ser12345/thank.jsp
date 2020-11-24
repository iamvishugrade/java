<jsp:useBean id="data" class="pack.ThankBean"/>
<jsp:setProperty name="data" property="*"/>
<table width="100%"><tr><td>
<%@ include file="../html/header.html" %></td></tr></table>
<br><br><br>
<%
if(data.thank())
{
out.println(" thanks for selection of mode");
out.println("We will call you later for detail");
%>
<br>
<br><br><br>
<a href="home.jsp">Click her for home page</a>
<%
}
else

out.println(" you mode of selection is not valid");
%>
<%

%>

