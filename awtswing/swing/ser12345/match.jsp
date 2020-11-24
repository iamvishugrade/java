

<%@ page import="java.sql.*" %>
<table width="100%"><tr><td>
<%@ include file="../html/header.html" %></td></tr></table>

<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
    <TR>
      <TD width="58%"><B><FONT color="#CC3300">&nbsp; &nbsp;Assamese Matrimonials</FONT></B></TD>
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
</TABLE><br><br>
<hr width="100%" color="#CC3300">
<table><tr><td><table>
<img height=329 src="image/pair.jpg" width=403 
  border=0></table></td><td>
<table border="1" align="center" bgcolor="#99FF00" width="50%" align="right">
<tr>
<% 
   String name,mtongue,profession,bodytype,height,education,caste;
   String bg=request.getParameter("bg");
    int a1=Integer.parseInt(request.getParameter("a1"));
    int a2=Integer.parseInt(request.getParameter("a2"));
   String ct=request.getParameter("ct");

   %>
 <%String g,cmty;
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection con=DriverManager.getConnection("jdbc:odbc:shaadi"); 
	
	if(bg.equals("2"))
	 g="male";
	else 
	 g="female";
	 if(ct.equals("2"))
	 cmty="bengali";
	 	else if(ct.equals("4"))
		cmty="hindi";
				else
						cmty="urdu";
						System.out.print("community..."+cmty);
	
   PreparedStatement stm=con.prepareStatement("select l.name, l.gender,l.age,u.caste,u.mtongue,u.education from  userprofile u,login l where  l.gender=? and l.email1=u.email1  and l.age between ? and ? and");
  stm.setString(1,g);
  stm.setInt(2,a1);
  stm.setInt(3,a2);
System.out.println("hi");
   ResultSet rs= stm.executeQuery();
System.out.println("hi");
    ResultSetMetaData rsmd=stm.getMetaData();
%>
<%int column=rsmd.getColumnCount(),i;
for(i=1;i<=column;i++)
{%>
<td  width="5">
<% 
System.out.println("hi second");
out.println(rsmd.getColumnName(i));
System.out.println("hi second");
}%>
</td>

<%  while(rs.next())
  {
System.out.println("hi third");
%>
<tr height="30">
     <TD width="45"><%=rs.getString("name")%></TD>
  <TD width="45"><%=rs.getString("gender")%></TD>
  <TD width="45"><%=rs.getInt("age")%></TD>
<TD width="45"><%=rs.getString("caste")%></TD>
<TD width="45"><%=rs.getString("mtongue")%></TD>
<TD width="45"><%=rs.getString("education")%></TD>
</tr>
    <%}%>	

</table></td></tr></table>	
