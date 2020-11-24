package tarique;
import java.sql.*;
import java.util.*;


public class StdRegBean 
{
String collegecode,collegename,collegecity,university,name,fathername,day,month,byear,male,female,selectcourse,selectbranch,selectsem,
        branchcode,year1,tenthmarks,twelthmarks,bdegree,bachelormarks,other,paddress,caddress,city,state,pincode,stdcode,phoneno,mobile,email,status;
 String date,ccode,colcode,frol;
  int rl=0;
public String getBachelormarks() {
	return bachelormarks;
}

public String getDay() {
	return day;
}

public String getMonth() {
	return month;
}

public String getBYear() {
	return byear;
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

public String getYear1() {
	return year1;
}
public String getStatus() {
	return status;
}

public void setBachelormarks(String bachelormarks) {
	this.bachelormarks = bachelormarks;
}

public void setBdegree(String bdegree) {
	this.bdegree = bdegree;
}

public void setEmail(String email){
    this.email=email;
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

/*public void setDateofbirth(String dateofbirth) {
	this.dateofbirth = dateofbirth;
}

public void setEmail(String email) {
	this.email = email;
 }
public void setFemale(String female) {
	this.female = female;
}*/

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

public void setYear1(String year1) {
	this.year1 = year1;
}
public void setStatus(String status) {
	this.status = status;
}
Connection con;
Statement st;
ResultSet rs,rs1,rs2;
public StdRegBean()
{
	try
	{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    con = DriverManager.getConnection("jdbc:odbc:tarique");
    st=con.createStatement(); 
	}catch(Exception e){}       
}


public Hashtable getStdData()
{
Hashtable entries = new Hashtable();
 date=day+"-"+month+"-"+byear;
 try{ 
  
 rs=st.executeQuery("select CollageID from coll_detail where CollageName='"+collegecode+"' ");
while(rs.next())
  {
     colcode=rs.getString(1);
  }
 }catch(Exception fg){}
  
  
  try{
 rs1=st.executeQuery("select CourceID from CourceDetails where CourceName='"+selectcourse+"' ");
 while(rs1.next())
 {
     ccode=rs1.getString(1);
 }
 }catch(Exception hj){}

  try{
 rs2=st.executeQuery("select RollNo from stdenroll");
 while(rs2.next())
 {
     rl=rs2.getInt(0);
 }
  }catch(Exception sd){}
  System.out.println("Enrol data");
 System.out.println(rl);  
 rl=rl+1;
 if(rl<10)
     frol=year1+ccode+"00"+String.valueOf(rl);
 else if(rl<100)
     frol=year1+ccode+"0"+String.valueOf(rl);
 else
     frol=year1+ccode+String.valueOf(rl);
  
    
  System.out.println(frol);

  try{
  PreparedStatement ps=con.prepareStatement("insert into StdRegistration values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");	
  System.out.println("Enter in statement");
  PreparedStatement ps1=con.prepareStatement("insert into InstituteDetails values(?,?,?,?)");
 
  System.out.println("Step 4444444444444444444");
  ps.setString(1,frol);
  ps.setString(2,name);
  ps.setString(3,fathername);
  ps.setString(4,date);
  ps.setString(5,male);
  ps.setString(6,selectcourse);
  ps.setString(7,selectbranch);
  ps.setString(8,selectsem);
  ps.setString(9,branchcode);
  ps.setString(10,year1);
  ps.setString(11,paddress);
  ps.setString(12,caddress);
  ps.setString(13,city);  
  ps.setString(14,state);
  ps.setString(15,pincode);
  ps.setString(16,stdcode);
  ps.setString(17,phoneno);
  ps.setString(18,mobile);
  ps.setString(19,email);
  ps.setString(20,tenthmarks);
  ps.setString(21,twelthmarks);
  ps.setString(22,bdegree);
  ps.setString(23,bachelormarks);
  ps.setString(24,other);
  ps.setString(25,status);
  
  System.out.println("tarique");
  
  ps1.setString(1,collegecode);
  ps1.setString(2,collegename);
  ps1.setString(3,collegecity);
  ps1.setString(4,university);    
 
  PreparedStatement ps2=con.prepareStatement("insert into stdenroll values(?)");
  ps2.setInt(1,rl); 
  ps2.executeUpdate();
  
  ps.executeUpdate(); 
  System.out.println("Last");
  ps1.executeUpdate();
  ps.close();
  ps1.close();

//st.executeUpdate("insert in stdenroll(RollNo)values('"+rl+1+"')");

con.close();
  }
catch(Exception e1)
{
	System.out.println(e1);
}
return entries;
}
}