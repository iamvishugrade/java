<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.util.*,java.sql.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="bean1" scope="page" class="tarique.EmpIdBean"/>
<jsp:setProperty name="bean1" property="*" />

<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>

<body>
  <%  
  Hashtable idData = bean1.getIdData();
  Enumeration record = idData.keys();
  %>
<p>&nbsp;</p>
<table width="965" height="548" border="1">
  <tr>
    <td width="709">&nbsp;</td>
  </tr>
  <tr>
    <td height="375"><form name="form1" method="post" action="">
        <table width="937" height="251" border="1">
        <tr>
          <td width="118">&nbsp;</td>
          <td width="701"><table width="472" border="1">
           
            <tr>
              <td>Desired Login Name   </td>
              <td><input name="loginname" type="text" id="loginname" ></td>
            </tr>
            <tr>
              <td>Collage Code</td>
              <td><select name="collagecode" id="collagecode" >
              <%
               Connection con;
               Statement st; 
               ResultSet rs;
               String ccode;
              try{
                  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                  con=DriverManager.getConnection("jdbc:odbc:Tarique");
                  st=con.createStatement();
                  rs=st.executeQuery("select CollageName from coll_detail");
                  while(rs.next())
                      {
                        ccode=rs.getString(1);
                        %><Option><%=ccode%></Option><%
                      }
              }catch(Exception gh){}
              %>
              </select>
              </td>
            </tr>
            <tr>
              <td>Choose Password </td>
             
              <%
              	String pas1=request.getParameter("pass");
              	String pas2=request.getParameter("repass");
              	if(pas1==pas2)
              	{
              		
              	}
              	
              %>
              <td><input name="pass" type="text" id="pass" ></td>
            </tr>
            <tr>
              <td>Re-enter Password </td>
              <td><input name="repass" type="text" id="repass" ></td>
            </tr>
            <tr>
              <td>Security Question </td>
              <td><input name="question" type="text" id="question" ></td>
            </tr>
            <tr>
              <td>Answer</td>
              <td><input name="answer" type="text" id="answer" ></td>
            </tr>
            <tr>
              <td>Secondry Mail </td>
              <td><input name="secmail" type="text" id="secmail" ></td>
            </tr>
            <tr>
              <td align="right">&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td align="right">&nbsp;</td>
              <td><input name="account" type="submit" value="I accept. Create My Account"></td>
            </tr>
          </table>

		  </td>
		   
          <td width="96">&nbsp;</td>
        </tr>
      </table>
    </form></td>
  </tr>
  <tr>
    <td height="140">&nbsp;</td>
  </tr>
</table>
<p>&nbsp;</p>
</body>
</html>
