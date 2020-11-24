<%@ page contentType="text/html; charset=iso-8859-1" language="java" errorPage="" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="bean" scope="page" class="tarique.ExamBean"/>
<jsp:setProperty name="bean" property="*" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<style type="text/css">
<!--
.style1 {
	font-size: 24px;
	font-weight: bold;
	color: #FF0000;
}
-->
</style>
</head>

<body>
<table width="995" height="501" border="1">
  <tr>
    <td height="42">HEADER</td>
  </tr>
  <tr>
    <td height="27">MENU</td>
  </tr>
  
  <tr>
  
    <td height="351" align="center">    
      <form name="form2" method="post" action="">
      <%
  Hashtable entries = bean.getExamData();
  Enumeration record = entries.keys();
  while (record.hasMoreElements()) {
    Object entries1 = record.nextElement();
    out.println("hello");
  }
%>
      <table width="457" border="1">
        <tr align="center">
          <td colspan="4"><span class="style1">SEMESTER EXAM FORM </span></td>
        </tr>
        <tr>
          <td>Roll Number </td>
          <td><input name="rollno" type="text" id="rollno"></td>
          <td colspan="2">
            <input name="checkcarrypaper" type="checkbox" id="checkcarrypaper" value="true"> 
            Carry Paper </td>
        </tr>
        <tr>
          <td width="139">Institute Code </td>
          <td width="144"><input name="institutecode" type="text" id="institutecode"></td>
          <td width="75">Attempt</td>
          <td width="75"><select name="selattempt" id="selattempt">
          <OPTION value="1">1</OPTION>
          <OPTION value="2">2</OPTION>
          <OPTION value="3">3</OPTION>

          </select>
          
          </td>
        </tr>
        <tr>
          <td>Course Code </td>
          <td><input name="coursecode" type="text" id="coursecode"></td>
          <td colspan="2">&nbsp;</td>
        </tr>
        <tr>
          <td>Course Name </td>
          <td><select name="selname" id="selname">
			<OPTION value="MCA">MCA</OPTION>
			<OPTION value="MBA">MBA</OPTION>          
			<OPTION value="B.Tech">B.Tech</OPTION>
          </select></td>
          <td colspan="2">&nbsp;</td>
        </tr>
        <tr>
          <td>Sem</td>
          <td><select name="selsem" id="selsem">
          <OPTION value="I">I</OPTION>
          
          </select></td>
          <td colspan="2">&nbsp;</td>
        </tr>
        <tr>
          <td>Optional Paper 1 </td>
          <td><select name="selopaper1" id="selopaper1">
          <OPTION value="clientserver">CLIENTSERVER</OPTION>
          </select></td>
          <td colspan="2">&nbsp;</td>
        </tr>
        <tr>
          <td>Optional Paper 2 </td>
          <td><select name="selopaper2" id="selopaper2">
           <OPTION value="multimedia">MULTIMEDIA</OPTION>
          
          </select></td>
          <td colspan="2"></td>
        </tr>
        <tr>
          <td></td>
          <td><input name="Input" type="submit"></td>
          <td colspan="2">&nbsp;</td>
        </tr>
      </table>
      </form></td>
  </tr>
  <tr>
    <td>FOOTER</td>
  </tr>
</table>
</body>
</html>
