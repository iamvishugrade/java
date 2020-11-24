<html>
<body>
<%
String s1=application.getInitParameter("name1");
String s2=config.getInitParameter("name");
out.println(s1);
out.println("<br>");
out.println(s2);
%>


</body>
</html>