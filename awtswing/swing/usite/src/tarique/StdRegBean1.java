package tarique;
import java.sql.*;
import java.util.*;

public class StdRegBean1 
{
String collegecode,collegename,collegecity,university,name,fathername,dateofbirth,male,female,selectcourse,selectbranch,selectsem,branchcode,year,tenthmarks,twelthmarks,bdegree,bachelormarks,other,paddress,caddress,city,state,pincode,stdcode,phoneno,mobile,email,status,regid;

public String getBachelormarks() {
	return bachelormarks;
}

public String getBdegree() {
	return bdegree;
}

public String getBranchcode() {
	return branchcode;
}

public String getCaddress() {
	return caddress;
}

public String getCity() {
	return city;
}

public String getCollegecity() {
	return collegecity;
}

public String getCollegecode() {
	return collegecode;
}

public String getCollegename() {
	return collegename;
}

public String getDateofbirth() {
	return dateofbirth;
}

public String getEmail() {
	return email;
}

public String getFemale() {
	return female;
}

public String getName() {
	return name;
}

public String getFathername() {
	return fathername;
}

public String getMale() {
	return male;
}

public String getMobile() {
	return mobile;
}

public String getOther() {
	return other;
}

public String getPaddress() {
	return paddress;
}

public String getPhoneno() {
	return phoneno;
}

public String getPincode() {
	return pincode;
}

public String getSelectbranch() {
	return selectbranch;
}

public String getSelectcourse() {
	return selectcourse;
}

public String getSelectsem() {
	return selectsem;
}

public String getState() {
	return state;
}

public String getStdcode() {
	return stdcode;
}

public String getTenthmarks() {
	return tenthmarks;
}

public String getTwelthmarks() {
	return twelthmarks;
}

public String getUniversity() {
	return university;
}

public String getYear() {
	return year;
}
public String getStatus() {
	return status;
}
public String getRegid() {
	return regid;
}

public void setBachelormarks(String bachelormarks) {
	this.bachelormarks = bachelormarks;
}

public void setBdegree(String bdegree) {
	this.bdegree = bdegree;
}

public void setBranchcode(String branchcode) {
	this.branchcode = branchcode;
}

public void setCaddress(String caddress) {
	this.caddress = caddress;
}

public void setCity(String city) {
	this.city = city;
}

public void setCollegecity(String collegecity) {
	this.collegecity = collegecity;
}

public void setCollegecode(String collegecode) {
	this.collegecode = collegecode;
}

public void setCollegename(String collegename) {
	this.collegename = collegename;
}

public void setDateofbirth(String dateofbirth) {
	this.dateofbirth = dateofbirth;
}

public void setEmail(String email) {
	this.email = email;
}

public void setFemale(String female) {
	this.female = female;
}

public void setName(String name) {
	this.name =name;
}

public void setFathername(String fathername) {
	this.fathername = fathername;
}

public void setMale(String male) {
	this.male = male;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public void setOther(String other) {
	this.other = other;
}

public void setPaddress(String paddress) {
	this.paddress = paddress;
}

public void setPhoneno(String phoneno) {
	this.phoneno = phoneno;
}

public void setPincode(String pincode) {
	this.pincode = pincode;
}

public void setSelectbranch(String selectbranch) {
	this.selectbranch = selectbranch;
}

public void setSelectcourse(String selectcourse) {
	this.selectcourse = selectcourse;
}

public void setSelectsem(String selectsem) {
	this.selectsem = selectsem;
}

public void setState(String state) {
	this.state = state;
}

public void setStdcode(String stdcode) {
	this.stdcode = stdcode;
}

public void setTenthmarks(String tenthmarks) {
	this.tenthmarks = tenthmarks;
}

public void setTwelthmarks(String twelthmarks) {
	this.twelthmarks = twelthmarks;
}

public void setUniversity(String university) {
	this.university = university;
}

public void setYear(String year) {
	this.year = year;
}
public void setStatus(String status) {
	this.status = status;
}
public void setRegid(String regid) {
	this.regid = regid;
}
Connection con;
Statement st;
ResultSet rs;
public StdRegBean1()
{
	try
	{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    con = DriverManager.getConnection("jdbc:odbc:tarique");
	}catch(Exception e){}
}

public Hashtable getStdData()
{
Hashtable entries = new Hashtable();
try
{
  st = con.createStatement();
 System.out.println("my id"+regid);
  PreparedStatement ps=con.prepareStatement("insert into StdRegistration values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");	
  PreparedStatement ps1=con.prepareStatement("insert into InstituteDetails values(?,?,?,?)");	
  ps.setInt(1,22);
  ps.setString(2,name);
  ps.setString(3,fathername);
  ps.setString(4,dateofbirth);
  ps.setString(5,male);
  ps.setString(6,selectcourse);
  ps.setString(7,selectbranch);
  ps.setString(8,selectsem);
  ps.setString(9,branchcode);
  ps.setString(10,year);
  ps.setString(11,tenthmarks);
  ps.setString(12,twelthmarks);
  ps.setString(13,bdegree);
  ps.setString(14,bachelormarks);
  ps.setString(15,other);
  ps.setString(16,paddress);
  ps.setString(17,caddress);
  ps.setString(18,city);
  ps.setString(19,state);
  ps.setString(20,pincode);
  ps.setString(21,stdcode);
  ps.setString(22,phoneno);
  ps.setString(23,mobile);
  ps.setString(24,email);
  ps.setString(25,status);
  ps.setString(26,regid);
  
  
  ps1.setString(1,collegecode);
  ps1.setString(2,collegename);
  ps1.setString(3,collegecity);
  ps1.setString(4,university);
  
ps.executeUpdate();
ps1.executeUpdate();
ps.close();
ps1.close();

con.close();
  }
catch(Exception e1)
{
	System.out.println(e1);
}
return entries;
}

public ArrayList getStdId()
{
	ArrayList al1=new ArrayList();
	try
	{
	
	st = con.createStatement();
	int r=110;
	ResultSet rs2=st.executeQuery("select RegId from StdRegistration");
	while(rs2.next())
	{
		if(rs2.last()==true)
		{
		Integer i=new Integer(rs2.getInt(26));
		System.out.println("myid"+i);
		al1.add(i);
		}
	}	
	}catch(Exception e1)
	{}
	return al1;
}
}