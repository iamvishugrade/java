<jsp:useBean id="data" class="pack.ValidationBean"/>
<jsp:setProperty name="data" property="*"/>

<table width="100%">
  <tr><td>
<%@ include file="../html/header.html" %></td></tr></table>




<TABLE width="100%" border=0 cellPadding=0 cellSpacing=0>
  <TBODY>
    <TR>
      <TD width="58%"><B><FONT color=#ffecd8>&nbsp; &nbsp;Assamese Matrimonials</FONT></B></TD>
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
<p>&nbsp;</p>
<table style="MARGIN-TOP: 5px" cellspacing=0 cellpadding=0 width=667 border=0>
  <tbody>
    <tr>
      <td height="58" valign=top style="FONT: 12px arial"> <p><strong>Thanks congratulation for visiting the site</strong><b><br>
          <br>
         Choose your profile to get better responses</b>
        </p>
        <div class=boldgreen style="MARGIN-TOP: 10px"></div></td>
      <td style="BORDER-BOTTOM: #c5ce92 1px solid" valign=top align=right 
    width=203 rowspan=4><img height=129 src="image/pair.jpg" width=203 
  border=0></td>
    </tr>
    <tr>
      <td height="57" valign=top style="FONT: 12px arial"><p class="boldgreen">&nbsp;</p>
          <p class="boldgreen"><b> We provide all facilities that will commit with you </b></p></td>
    </tr>
  </tbody>
</table>
<font size="18"><br>

<table width="350" align="center"    border="1" cellspacing="2" cellpadding="2">
  <tr>
  <%
String name=request.getParameter("name");
System.out.println("name is........."+name);
session.setAttribute("name",name);
if(data.validation())
%>
 	<td align="center"><a href="third123.jsp">Choose Your Profile</a></td>
   </tr>
</tr>
 	<td align="center"><a href="home.jsp">Go to home page</a></td>
   </tr>

   <%
   else
   %>
    <td >Registration failed try again..... </td>
   
</table>
</font>
</body></html>

