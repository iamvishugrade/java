<%! String email2=null;%>
<jsp:useBean id="data" class="pack.ProfileBean"/>
<jsp:setProperty name="data" property="*"/>
<table width="100%"><tr><td>
<%@ include file="../html/header.html" %></td></tr></table>
<table style="MARGIN-TOP: 5px" cellspacing=0 cellpadding=0 width=756 border=0>
  <tbody>
    <tr>
      <td height="58" valign=top style="FONT: 12px arial"> <p><b>Choose your mode of payment <br>
          We provide three types of mode of payments <br>
        </b></p>
      <div class=boldgreen style="MARGIN-TOP: 10px"></div></td>
      <td style="BORDER-BOTTOM: #c5ce92 1px solid" valign=top align=right 
    width=203 rowspan=4><img height=129 src="image/pair.jpg" width=203 
  border=0></td>
    </tr>
    <tr>
      <td height="57" valign=top style="FONT: 12px arial"><p class="boldgreen">&nbsp;</p>
          <p class="boldgreen"><b> Your Profile Details</b></p></td>
    </tr>
  </tbody>
</table>
<br><br>
<table width="350" align="center"    border="1" cellspacing="2" cellpadding="2">
  <tr>
<%
 email2=(String)session.getAttribute("email1");
//out.println(email2);
%>
<jsp:setProperty name="data" property="email1"  value="<%=email2%>"/>

<%

if(data.profile())
{
%>
<tr><td align="center">
<a href="makepay.jsp">choose your mode of payment</a></td></tr>
<tr><td align="center">
<a href="home.jsp"> Click her to for home page</a></td></tr>
<%
}
else
out.println(" you profile is not submitted plz try again");
%>
</body></html>


