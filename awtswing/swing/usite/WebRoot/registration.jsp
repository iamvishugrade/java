<%@ page contentType="text/html; charset=iso-8859-1" language="java" errorPage="" %>
<%@page import ="java.util.*,java.sql.*"%>
<jsp:useBean id="bean3" scope="page" class="tarique.StdRegBean"/>
<jsp:setProperty name="bean3" property="*" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Student Admission</title>
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

<body bgcolor="wheat">
<table width="997" height="441" border="1" style="position:relative;top:-30px;left:-10" align="center">
  <tr>
    <td><IMG src="images/title111.JPG" width="962" height="106"></td>
    <tr><td><TABLE>
    <td><img src="images/titleimage1.jpg" alt="" name="titleimage1" width="169" height="112" border="0" onload=""></td>
    <td><img src="images/ED001204.jpg" width="170" height="112"></td>
    <td><img src="images/ED001032.jpg" width="170" height="112"></td>
    <td><img src="images/images.jpg" width="147" height="112"></td>
    <td><img src="images/FAA023000428.jpg" width="170" height="113"></td>
    <td><img src="images/lib.jpg" width="130" height="112"></td>
    </TABLE> </td></tr>
    <tr></tr>
  </tr>
  <tr><td height=20><marquee scrollamount="3" scrolldelay="10" behaviour="scrolling" ><font color="blue" size="5px" face="bold"><b>Last date of submission of examination form is 30-March-09</b></font></marquee></td></tr>
  <tr>
    <td><table width="975" height="377" border="0">
      <tr>
        <td width="114">
<%
  Hashtable entries = bean3.getStdData();
  Enumeration record = entries.keys();
%></td>
        <td width="831"><form name="form2" method="post" action="">
          <table width="714" height="568" border="0" bgcolor="rgb(200,241,233)">               
            <tr align="center" bgcolor="rgb(254,224,223)">
              <td colspan="4"><span class="style1">STUDENT ADMISSION FORM </span></td>
              </tr>
            <tr align="center">
              <td colspan="4"><strong>INSTITUTIONAL DETAILS </strong></td>
              </tr>
            <tr>
              <td height="27">College Code</td>
              <td>
              <Select name="collegecode" id="collegecode">
              <%
              Connection con;
              Statement st;
              ResultSet rss;
              try
              {
               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
               con=DriverManager.getConnection("jdbc:odbc:tarique");                
               st=con.createStatement();
               rss=st.executeQuery("select CollageName from coll_detail");
               while(rss.next())
               {
               String nm=rss.getString(1);
               %><Option><%=nm%></Option><%
               }  
              }catch(SQLException df){df.printStackTrace();}
              %>
              </Select>
              </td>
              
              
              
              
              <td>College City </td>
              <td><input name="collegecity" type="text" id="collegecity"></td>
            </tr>
            <tr>
              <td>College Name </td>
              <td><input name="collegename" type="text" id="collegename">
              </td>
              <td>Affilated University </td>
              <td><input name="university" type="text" id="university"></td>
            </tr>
            <tr>
              <td colspan="2" align="center"><strong>PERSONAL DETAILS </strong></td>
              <td colspan="2" align="center"><strong>ADDRESS</strong></td>
              </tr>
            <tr>
              <td width="186">Applicant &nbsp;Name</td>
              <td width="182"><input name="name" type="text" id="name"></td>
              <td width="160">Parmanent Address </td>
              <td width="158"><input name="paddress" type="text" id="paddress"></td>
            </tr>
            <tr>
              <td>Father/Guardian Name </td>
              <td><input name="fathername" type="text" id="fathername"></td>
              <td>Correspondence Address </td>
              <td><input name="caddress" type="text" id="caddress"></td>
            </tr>
            <tr>
              <td height="28">Date of Birth </td>
              <td>
              
              <Select name="day" id="day">
              <%
              for(int i=1;i<32;i++)
              {
              %><Option><%=i%></Option><%
              }
              %>
              </Select>
              <Select name="month" id="month">
              <OPTION>Month</OPTION>
              <OPTION>Jan</OPTION>
              <OPTION>Feb</OPTION>
              <OPTION>March</OPTION>
              <OPTION>April</OPTION>
              <OPTION>May</OPTION>
              <OPTION>Jun</OPTION>
              <OPTION>July</OPTION>
              <OPTION>Aug</OPTION>
              <OPTION>Sep</OPTION>
              <OPTION>Oct</OPTION>
              <OPTION>Nov</OPTION>
              <OPTION>Dec</OPTION>
              </Select>
              
              <SELECT name="byear" id="byear">
               <Option>Year</Option>
              <% 
              for(int j=1980;j<2010;j++)
              {
              %><OPTION><%=j%></OPTION><%
              } 
              %>
              </SELECT>
              </td>
              <td>City</td>
              <td><p>
                <input name="city" type="text" id="city">
              </p>                </td>
            </tr>
            <tr>
              <td>Gender</td>
              <td width="182"><input name="male" type="radio" value="radiobutton">
  Male
    <input name="female" type="radio" value="radiobutton" >
  Female</td>
              <td>State</td>
              <td><input name="state" type="text" id="state"></td>
            </tr>
            <tr>
              <td>Course</td>
              <td><select name="selectcourse" id="selectcourse">
                <OPTION value=ba >BA</OPTION>
                <OPTION value=ma >MA</OPTION>
                <OPTION value=bscit >Bsc(IT)</OPTION>
                <OPTION value=mscit >Msc(IT)</OPTION>
                <OPTION value=bit >BIT</OPTION>
                <OPTION value=mit >MIT</OPTION>
                <OPTION value=bca >BCA</OPTION>
                <OPTION value=mca >MCA</OPTION>
                <OPTION value=bba >BBA</OPTION>
                <OPTION value=mba >MBA</OPTION>
                <OPTION value=btech >B.Tech</OPTION>
                <OPTION value=mtech >M.Tech</OPTION>
                <OPTION value=bpharma >B.Pharma</OPTION>
                <OPTION value=mpharma >M.pharma</OPTION>
                
       
              </select></td>
              <td>Pin Code </td>
              <td><p>
                <input name="pincode" type="text" id="pincode">
</p>
                </td>
            </tr>
            <tr>
              <td>Branch</td>
              <td><select name="selectbranch" id="selectbranch">
                <OPTION value=cs >CS</OPTION>
                <OPTION value=it >IT</OPTION>
                <OPTION value=ec >EC</OPTION>
                <OPTION value=en >EN</OPTION>
                <OPTION value=me >ME</OPTION>
                <OPTION value=civil >CIVIL</OPTION>
              </select></td>
              <td>STD code </td>
              <td><input name="stdcode" type="text" id="stdcode"></td>
            </tr>
            <tr>
              <td>Semester</td>
              <td><select name="selectsem" id="selectsem">
			  <OPTION value=I>I</OPTION>
              </select></td>
              <td>Phone Number</td>
              <td><input name="phoneno" type="text" id="phoneno"></td>
            </tr>
            <tr>
              <td>Branch Code </td>
              <td><input name="branchcode" type="text" id="branchcode"></td>
              <td>Mobile Number </td>
              <td><input name="mobile" type="text" id="mobile"></td>
            </tr>
            <tr>
              <td>Year</td>
              <td><input name="year1" type="text" id="year1"></td>
              <td>E-Mail</td>
              <td><input name="email" type="text" id="email"></td>
            </tr>
            <tr>
              <td colspan="2" align="center"><strong>EDUCATIONAL DETAILS </strong></td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td>Tenth Marks (%) </td>
              <td><input name="tenthmarks" type="text" id="tenthmarks"></td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td>Twelth Marks (%) </td>
              <td><input name="twelthmarks" type="text" id="twelthmarks"></td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td>Bachelors Degree Name </td>
              <td><input name="bdegree" type="text" id="bdegree"></td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td>Bachelors Degree Marks (%) </td>
              <td><input name="bachelormarks" type="text" id="bachelormarks"></td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td>Other </td>
              <td><input name="other" type="text" id="other"></td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
            <tr align="center">
              <td colspan="4"><input name="sumit" type="submit" value="Register">&nbsp;</td>
              </tr>
          </table>
        </form></td>
        <td width="8">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    &nbsp;
  </tr>
</table>
</body>
</html>
