
<%@ page import="java.sql.*" %>
<html><body><table width="100%"><tr><td>
<%@ include file="../html/header.html" %></td></tr></table>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
    <TR>
      <TD width="58%"><B><FONT color="#CC0033">&nbsp; &nbsp;Assamese Matrimonials</FONT></B></TD>
      <TD align=right width="42%"><B><FONT 
                  color=#ffffff>&raquo;</FONT></B> <A class=Menu2 
                  title="Matrimonial sign in" 
                  href="http://localhost:7001/ser12/second.jsp">Sign In</A>&nbsp; <B><FONT color=#ffffff>&raquo;</FONT></B> <A 
                  class=Menu2 title="Matrimonial partner search" 
                  href="http://www.lifepartnerindia.com/profilesearch/">Partner Search</A>&nbsp; <B><FONT color=#ffffff>&raquo; </FONT></B><A 
                  class=Menu2 title="Customer Care" 
                  onclick="javascript:window.open('/lpihelp/contact.php','_lpicontact','location=no,toolbars=no,scrollbars=yes,resizeable=no,width=505,height=600');return false;" 
                  href="http://www.lifepartnerindia.com/lpihelp/contact.php?contact=1">Customer Care</A> &nbsp;</TD>
    </TR>
  </TBODY>
</TABLE>
<hr width="100%" color="#0000FF">

<TABLE border=1 align="center">
  <BODY>
  <TR>
<%
	 String mail=request.getParameter("id");
	 String img=request.getParameter("img");
	System.out.println(mail);
	System.out.println(img);
                     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection con=DriverManager.getConnection("jdbc:odbc:shaadi"); 
	System.out.println("hi");
	PreparedStatement stm=con.prepareStatement("select l.name,l.gender,u.mtongue,u.education,u.mstatus,u.bodytype,u.height,u.caste,u.profession from login l,userprofile u where  l.email1=? and l.email1=u.email1");
  stm.setString(1,mail);
System.out.println("hi");
   ResultSet rs= stm.executeQuery();
System.out.println("hi");
       ResultSetMetaData rsmd=stm.getMetaData();
	
%><%int column=rsmd.getColumnCount(),i; %>
</TBODY></TABLE>
	
	
	<TABLE cellSpacing=0 cellPadding=0 width=414 border=1 align="center">
  <TBODY><br><br><br>
  <TR>
    <TD Align=center height="30" colSpan=2 bgcolor="#3300FF" bordercolor="#66FF00"><marquee behavior="alternate"><b>User Prpfile</b></marquee></TD></TR>
  <TR>
    <TD vAlign=center align=middle width=209 background="" height=66><IMG 
      height=222 alt=asish73 hspace=3 src=<%=img%> width=222 
      vspace=3 border=0></A></TD>
    <TD vAlign=top width=199>
	  <table width="199" border="1">
	<%  while(rs.next()){
	for(i=1;i<=column;i++){ 
	System.out.print("column........"+rsmd.getColumnName(i)+"          "+i); %>
	<tr> <%  
		
		for(i=1;i<=column;i++){ %>
	      <td width="86"><%=rsmd.getColumnName(i)%></td>
		  
		 
		<td width="95"><%
		out.print(rs.getString(i));
		%>
	  
		  </td>
		</tr>  
		<% }}} %>  
      </table>
    </TD></TR>
	  <tr><td colspan="2" bgcolor="#3333CC" background="red"><b>I look such type of characteristic in my <br>Life Partner
	  <ul><li>Physical Attraction</li><li>Social Skills</li><li>Well Qualified</li>
	  </ul></b></td></tr>
  <TR>
    <TD colSpan=2 height=32 align="center" bgcolor="#33FF33"><A href="home.jsp"><b>Home  Page</b></A></TD></TR></TBODY></TABLE>
	</body>
</html>