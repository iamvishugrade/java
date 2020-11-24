<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%@page import ="java.util.*"%>
<%@page import ="tarique.StdData"%>
<%@page import ="tarique.StdData1"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:usebean id="bean6" scope="request" class="tarique.StdProfile"/>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<style type="text/css">
.style3 {
	color: #FFFFFF;
	font-weight: bold;
}
</style>
<script language="JavaScript" type="text/JavaScript">
<!--

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_nbGroup(event, grpName) { //v6.0
  var i,img,nbArr,args=MM_nbGroup.arguments;
  if (event == "init" && args.length > 2) {
    if ((img = MM_findObj(args[2])) != null && !img.MM_init) {
      img.MM_init = true; img.MM_up = args[3]; img.MM_dn = img.src;
      if ((nbArr = document[grpName]) == null) nbArr = document[grpName] = new Array();
      nbArr[nbArr.length] = img;
      for (i=4; i < args.length-1; i+=2) if ((img = MM_findObj(args[i])) != null) {
        if (!img.MM_up) img.MM_up = img.src;
        img.src = img.MM_dn = args[i+1];
        nbArr[nbArr.length] = img;
    } }
  } else if (event == "over") {
    document.MM_nbOver = nbArr = new Array();
    for (i=1; i < args.length-1; i+=3) if ((img = MM_findObj(args[i])) != null) {
      if (!img.MM_up) img.MM_up = img.src;
      img.src = (img.MM_dn && args[i+2]) ? args[i+2] : ((args[i+1])? args[i+1] : img.MM_up);
      nbArr[nbArr.length] = img;
    }
  } else if (event == "out" ) {
    for (i=0; i < document.MM_nbOver.length; i++) {
      img = document.MM_nbOver[i]; img.src = (img.MM_dn) ? img.MM_dn : img.MM_up; }
  } else if (event == "down") {
    nbArr = document[grpName];
    if (nbArr)
      for (i=0; i < nbArr.length; i++) { img=nbArr[i]; img.src = img.MM_up; img.MM_dn = 0; }
    document[grpName] = nbArr = new Array();
    for (i=2; i < args.length-1; i+=2) if ((img = MM_findObj(args[i])) != null) {
      if (!img.MM_up) img.MM_up = img.src;
      img.src = img.MM_dn = (args[i+1])? args[i+1] : img.MM_up;
      nbArr[nbArr.length] = img;
  } }
}
//-->
</script>
</head>

<body>
<table cellspacing=0 cellpadding=0 width=970 align=center border=0>
  <tbody>
    <tr>
      <td>
        <table cellspacing=0 cellpadding=0 width="100%" border=1>
          <tbody>
            <tr>
              <td width=4 
          background="images/index_01.jpg">&nbsp;</td>
              <td width="962">
                <table cellspacing=0 cellpadding=0 width="100%" border=0>
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
                      <td><a href="javascript:;" target="_top" onClick="MM_nbGroup('down','group1','title111','',1)" onMouseOver="MM_nbGroup('over','title111','','',1)" onMouseOut="MM_nbGroup('out')"><img src="images/title111.JPG" name="title111" width="962" height="106" border="0"></a></td>
                    </tr>
                    <tr>
                      <td><table width="200" border="1">
                        <tr>
                          <td><a href="javascript:;" target="_top" onClick="MM_nbGroup('down','group1','titleimage1','',1)" onMouseOver="MM_nbGroup('over','titleimage1','','',1)" onMouseOut="MM_nbGroup('out')"><img src="images/titleimage1.jpg" alt="" name="titleimage1" width="148" height="112" border="0"></a></td>
                          <td><img src="images/ED001204.jpg" width="158" height="112"></td>
                          <td><img src="images/ED001032.jpg" width="170" height="112"></td>
                          <td><img src="images/images.jpg" width="147" height="112"></td>
                          <td><img src="images/FAA023000428.jpg" width="153" height="113"></td>
                          <td><img src="images/lib.jpg" width="148" height="112"></td>
                        </tr>
                      </table></td>
                    </tr>
                    <tr>
                      <td><a href="javascript:;" target="_top" onClick="MM_nbGroup('down','group1','titleimage1','',1)" onMouseOver="MM_nbGroup('over','titleimage1','','',1)" onMouseOut="MM_nbGroup('out')">
                        <%@include file="menu.html"%>
                      </a></td>
                    </tr>
                    <tr>
                      <td><img height=9 alt="" 
                  src="images/index1_07.jpg" 
                  width=961></td>
                    </tr>
                    <tr>
                      <td align="center" valign=top bgcolor=#ffffff>                        <a href="javascript:;" target="_top" onClick="MM_nbGroup('down','group1','titleimage1','',1)" onMouseOver="MM_nbGroup('over','titleimage1','','',1)" onMouseOut="MM_nbGroup('out')">
                        </a>                      <table width="958" height="77" border="1">
                          <tr>
                            <td width="159"><table width="106%" height="335" cellpadding=1 cellspacing=2>
                                <tbody>
                                  <tr>
                                    <td>&nbsp; </td>
                                    <td>&nbsp; </td>
                                    <td width="2">&nbsp; </td>
                                  </tr>
                                  <tr>
                                    <td> <img height=24 src="images/3.jpg" width=20> </td>
                                    <td align="left" class=textlinks> <a href="#">Student Profile</a></td>
                                    <td>&nbsp; </td>
                                  </tr>
                                  <tr>
                                    <td> <img height=22 src="images/3.jpg" width=18> </td>
                                    <td width=97 align="left" class=textlinks> <a href="http://www.uptu.ac.in/kulgeet.mp3" target=_blank>Faculty Profile </a></td>
                                    <td>&nbsp; </td>
                                  </tr>
                                  <tr>
                                    <td height=12> <img height=22 src="images/3.jpg" width=17> </td>
                                    <td align="left" class=textlinks> <a href="#">Institute News</a></td>
                                    <td>&nbsp; </td>
                                  </tr>
                                  <tr>
                                    <td width=20 height=12> <img src="images/3.jpg" width="16" height="19"> </td>
                                    <td align="left" class=textlinks> <a href="http://www.uptu.ac.in/about/vcs_message.asp">University News </a> </td>
                                    <td>&nbsp; </td>
                                  </tr>
                                  <tr>
                                    <td> <img src="images/3.jpg" width="17" height="21"> </td>
                                    <td align="left" class=textlinks> <a href="http://www.uptu.ac.in/photogallery.htm">Photo Gallery </a> </td>
                                    <td>&nbsp; </td>
                                  </tr>
                                  <tr>
                                    <td> <img src="images/3.jpg" width="20" height="21"> </td>
                                    <td class=textlinks>&nbsp; </td>
                                    <td>&nbsp; </td>
                                  </tr>
                                  <tr>
                                    <td> <img src="images/3.jpg" width="14" height="19"> </td>
                                    <td class=textlinks>&nbsp; </td>
                                    <td>&nbsp; </td>
                                  </tr>
                                  <tr>
                                    <td width=20> <img src="images/3.jpg" width="14" height="17"> </td>
                                    <td class=textlinks>&nbsp;</td>
                                    <td>&nbsp; </td>
                                  </tr>
                                  <tr>
                                    <td> <img src="images/3.jpg" width="16" height="18"> </td>
                                    <td class=textlinks>&nbsp;</td>
                                    <td>&nbsp; </td>
                                  </tr>
                                  <tr>
                                    <td width=20>&nbsp; </td>
                                    <td class=left>&nbsp; </td>
                                    <td>&nbsp; </td>
                                  </tr>
                                </tbody>
                            </table></td>
                            <td width="670" align="center" valign="middle">
                             <%!StdData sd;StdData1 sd1; %>
                            
                            <table width="670" height="334" border="1" cellpadding="0" cellspacing="0" bordercolor="#0000CC">
                              <tr align="center" bgcolor="#000099">
                                <td height="24" colspan="4"><h3><span class="style3">STUDENT PROFILE</span></h3></td>
                              </tr>
                              <tr>
                        <%
                        ArrayList al[] =bean6.getStudentDetails();
                        System.out.println(".............."+al);
                        Iterator i=al[0].iterator();
                        Iterator i1=al[1].iterator();
                        while(i.hasNext()) 
                        {
                         sd=(StdData)i.next();
                         
                        }
                        while(i1.hasNext()) 
                        {
                      
                         sd1=(StdData1)i1.next();
                        }
                        %>
                                <td colspan="2" align="center"><strong>Personal Information: </strong></td>
                                <td colspan="2" align="center"><strong>Professional Information: </strong></td>
                                </tr>
                                <tr>
                                <td width="161" align="left">Roll Number</td>
                                <td width="162" align="left"><%=sd.rollno%></td>
                                <td width="144" align="left">Student ID</td>
                                <td width="175" align="left"></td>
                              </tr>
                              <tr>
                                <td width="161" align="left">Name </td>
                                <td width="162" align="left"><%=sd.stdname%></td>
                                <td width="144" align="left">Course</td>
                                <td width="175" align="left"><%=sd.course%></td>
                              </tr>
                              <tr>
                                <td align="left">Father Name </td>
                                <td align="left"><%=sd.fathername%></td>
                                <td align="left">Branch</td>
                                <td align="left"><%=sd.branch%></td>
                              </tr>
                              <tr>
                                <td align="left">Parmanent Address </td>
                                <td align="left"><%=sd.paddress%></td>
                                <td align="left">Session</td>
                                <td align="left"><%=sd.session%></td>
                              </tr>
                              <tr>
                                <td align="left">Correspondence Address </td>
                                <td align="left"><%=sd.caddress%></td>
                                <td align="left">Status</td>
                                <td align="left"><%=sd.status%></td>
                              </tr>
                              <tr>
                                <td align="left">City</td>
                                <td align="left"><%=sd.city%></td>
                                <td align="left">Institute</td>
                                <td align="left"><%=sd1.iname%></td>
                              </tr>
                              <tr>
                                <td align="left">D.O.B</td>
                                <td align="left"><%=sd.dob%></td>
                                <td align="left">University</td>
                                <td align="left"><%=sd1.univname%></td>
                              </tr>
                              <tr>
                                <td align="left">Gender</td>
                                <td align="left"><%=sd.gender%></td>
                                <td align="left">&nbsp;</td>
                                <td align="left">&nbsp;</td>
                              </tr>
                              <tr>
                                <td align="left">Mobile</td>
                                <td align="left"><%=sd.mobile%></td>
                                <td align="left">&nbsp;</td>
                                <td align="left">&nbsp;</td>
                              </tr>
                              <tr>
                                <td align="left">E-Mail</td>
                                <td align="left"><%=sd.email%></td>
                                <td align="left">&nbsp;</td>
                                <td align="left">&nbsp;</td>
                              </tr>
                            </table>
                            </td>
                            <td width="107">&nbsp;</td>
                          </tr>
                        </table></td>
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
              <td width=186 
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
