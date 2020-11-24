<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="bean3" scope="request" class="tarique.StdResult"/>
<jsp:setProperty property="bean3" name="*"/>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>

<body>
<table width="348" height="71" border="1">
  <tr>
    <td width="158">Enter Roll Number </td>
    <td width="177"><input name="Input" type="text"></td>
  </tr>
  <tr align="center">
    <td colspan="2"><p>
      <%
      try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:tarique");
				PreparedStatement ps=con.prepareStatement("select FirstName,LastName from StdRegistration where RollNumber=?");
				ps.setInt(1,Integer.parseInt(bean3.getRollno()));
				ResultSet result=ps.executeQuery();
				
				if(result.next())
				{
			
				 System.out.println(result.getString(2));
				}
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
	  %>
      <input name="Input2" type="submit" value="Submit">
    </p>    </td>
  </tr>
</table>
</body>
</html>
