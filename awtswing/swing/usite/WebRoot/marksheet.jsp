<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%@page import ="java.util.*"%>
<%@page import="tarique.StdResult"%>
<%@page import ="tarique.StdData"%>
<%@page import ="tarique.StdData1"%>
<%@page import ="tarique.MarksData"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:usebean id="bean4" scope="request" class="tarique.StdResult"/>
<jsp:setProperty name="bean4" property="*"/>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<style type="text/css">

</style>
<script language="JavaScript" type="text/JavaScript">

</script>
</head>

<body>
  <%! StdData sd; StdData1 sd1; MarksData md;%>   
 
<table cellspacing=0 cellpadding=0 width=970 align=center border=0>
  <tbody>
    <tr>
      <td>
        <table cellspacing=0 cellpadding=0 width="100%" border=0>
          <tbody>
            <tr>
              <td width=14 
          background="images/index_01.jpg">&nbsp;</td>
              <td>
                <table cellspacing=0 cellpadding=0 width="99%" border=0>
                  <tbody>
                    <tr>
                      <td>
                        <script 
                  src="images/banner_home.js" 
                  type=text/javascript></script>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <script language=JavaScript1.2>mmLoadMenus();</script>
                        <script 
                  src="images/mainmenu.js" 
                  type=text/javascript></script>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        
                        <TABLE width="842" border="0" cellpadding="0" cellspacing="0">
                          <TR align="center">
                            <TD colspan="6"> <A href="javascript:;" target="_top" onclick="MM_nbGroup('down','group1','title111','',1)" onmouseover="MM_nbGroup('over','title111','','',1)" onmouseout="MM_nbGroup('out')"><IMG src="images/title111.JPG" name="title111" width="962" height="106" border="0"></A> </TD>
                          </TR>
                          <TR>
                            <TD>
                              <TABLE width="962" height="141" border="1">
                                <TR>
                                  <TD width="148" height="135"><A href="javascript:;" target="_top" onclick="MM_nbGroup('down','group1','titleimage1','',1)" onmouseover="MM_nbGroup('over','titleimage1','','',1)" onmouseout="MM_nbGroup('out')"><IMG src="images/titleimage1.jpg" alt="" name="titleimage1" width="148" height="112" border="0"></A> </TD>
                                  <TD width="158"><IMG src="images/ED001204.jpg" width="158" height="112"> </TD>
                                  <TD width="170"><IMG src="images/ED001032.jpg" width="170" height="112"> </TD>
                                  <TD width="147"><IMG src="images/images.jpg" width="147" height="112"> </TD>
                                  <TD width="153"><IMG src="images/FAA023000428.jpg" width="153" height="113"> </TD>
                                  <TD width="146"><IMG src="images/lib.jpg" width="141" height="112"> </TD>
                                </TR>
                            </TABLE></TD>
                          </TR>
                          <TR></TR>
                        </TABLE>
                        <%@include file="menu.html"%>
                        </td>
                    </tr>
                    <tr>
                      <td><img height=9 alt="" 
                  src="images/index1_07.jpg" 
                  width=961></td>
                    </tr>
                    <tr>
                      <td align="center" valign=top bgcolor=#ffffff>    
                                    
                      <TABLE width="790" border="1">
                      
                        <TR>
                        <%
                        ArrayList al[] =bean4.rollNo1();
                        System.out.println(".........."+al);
                        Iterator i=al[0].iterator();
                        Iterator i1=al[1].iterator();
                         Iterator i2=al[2].iterator();
                        while(i.hasNext()) 
                        {
                         sd=(StdData)i.next();
                        }
                         while(i1.hasNext()) 
                        {
                         sd1=(StdData1)i1.next();
                        }
                         while(i2.hasNext()) 
                        {
                         md=(MarksData)i2.next();
                        }
                        
                        %>
                          <TD width="381"><STRONG>Name:</STRONG></TD>
                          <TD width="393"><%=sd.stdname%></TD>
                        </TR>
                        <TR>
                        
                          <TD><STRONG>Father's Name:</STRONG></TD>
                          <TD><%=sd.fathername%></TD>
                        </TR>
                        <TR>
                          <TD><STRONG>Roll Number:</STRONG></TD>
                          <TD><jsp:getProperty name="bean4" property="rollno" />                      
                          </TD><TD>                       
                        </TD></TR>
                        <TR>
                          <TD><STRONG>Status:</STRONG>
                        
                          </TD>
                          <TD><%=sd.status%></TD>
                        </TR>
                        <TR>
                          <TD><STRONG>Course:</STRONG></TD>
                          <TD><%=sd.course%></TD>
                        </TR>
                        <TR>
                          <TD><STRONG>Institute:</STRONG></TD>
                          <TD><%=sd1.iname%></TD>
                        </TR>
                      </TABLE>
														<TABLE align="center" border="1" width="200px">
														
															<TR>
																<TD>Subject Name</TD>
																<TD><%=md.subject%></TD>
															</TR>
															<TR>
																<TD></TD>
																<TD></TD>
															</TR>
															<TR>
																<TD></TD>
																<TD></TD>
															</TR>
															<TR>
																<TD></TD>
																<TD></TD>
															</TR>
															<TR>
																<TD></TD>
																<TD></TD>
															</TR>
															<TR>
																<TD></TD>
																<TD></TD>
															</TR>
															<TR>
																<TD></TD>
																<TD></TD>
															</TR>
															<TR>
																<TD></TD>
																<TD></TD>
															</TR>
															<TR>
																<TD></TD>
																<TD></TD>
															</TR>
															<TR>
																<TD></TD>
																<TD></TD>
															</TR>
															<TR>
																<TD></TD>
																<TD></TD>
															</TR>
															<TR>
																<TD></TD>
																<TD></TD>
															</TR>
															<TR>
																<TD></TD>
																<TD></TD>
															</TR>
															<TR>
																<TD></TD>
																<TD></TD>
															</TR>
															<TR>
																<TD></TD>
																<TD></TD>
															</TR>
															<TR>
																<TD></TD>
																<TD></TD>
															</TR>
															<TR>
																<TD></TD>
																<TD></TD>
															</TR>
															<TR>
																<TD></TD>
																<TD></TD>
															</TR>
															<TR>
																<TD></TD>
																<TD></TD>
															</TR>
															<TR>
																<TD></TD>
																<TD></TD>
															</TR>
														</TABLE>
													</td>
                    </tr>
                    <tr>
                      <td 
                height=14 align="center" 
                background="images/index1_11.jpg"></td>
                    </tr>
                    <tr>
                      <td style="BACKGROUND-REPEAT: no-repeat" valign=bottom 
                align=middle background="images/index1_13.jpg" 
                height=8>
                        <div class=dblue align=center>
                          <div align=center></div>
                          <font 
              color=#0099ff></font></div></td>
                    </tr>
                  </tbody>
              </table></td>
              <td width=14 
          background="images/index_03.jpg">&nbsp;</td>
            </tr>
          </tbody>
      </table></td>
    </tr>
    <tr>
      <td>
        <table cellspacing=0 cellpadding=0 width="98%" align=center border=0>
          <tbody>
            <tr>
              <td class=dblue width=299>
                <div align=left>&copy; Tarique Anwer |<a 
            href="http://www.uptu.ac.in/mail.htm">E-mail:mta.anwer@gamil.com </a></div></td>
              <td class=dblue width=418>|<a 
            href="http://www.uptu.ac.in/mail.htm"></a>Mob:9210749008</td>
              <td width=237>
                <table cellspacing=0 cellpadding=0 width="100%" border=0>
                  <tbody>
                    <tr>
                      <td class=dblue>Developed by : Tarique Anwer</td>
                    </tr>
                  </tbody>
              </table></td>
              <td class=dblue 
width=6>&nbsp;</td>
            </tr>
          </tbody>
      </table></td>
    </tr>
  </tbody>
</table>
</body>
</html>
