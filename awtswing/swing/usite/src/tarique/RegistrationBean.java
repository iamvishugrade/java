package tarique;
import java.util.*;
import java.sql.*;

public class RegistrationBean 
{
	public String fname,lname,fathername,paddress,caddress,resigndate,joindate,sex,experience,subject,phoneno,mobile,hsmarks,hsyear,imarks,iyear,gmarks,gyear,pgmarks,pgyear,other,category;

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
public void setcategory(String category) {
		this.category = category;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setGmarks(String gmarks) {
		this.gmarks = gmarks;
	}

	public void setGyear(String gyear) {
		this.gyear = gyear;
	}

	public void setHsmarks(String hsmarks) {
		this.hsmarks = hsmarks;
	}

	public void setHsyear(String hsyear) {
		this.hsyear = hsyear;
	}

	public void setImarks(String imarks) {
		this.imarks = imarks;
	}

	public void setIyear(String iyear) {
		this.iyear = iyear;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	public void setLname(String lname) {
		this.lname = lname;
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

	public void setPgmarks(String pgmarks) {
		this.pgmarks = pgmarks;
	}

	public void setPgyear(String pgyear) {
		this.pgyear = pgyear;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
    public Hashtable getData()
    {
    Hashtable entries = new Hashtable();
    try
    {
    	String staffid="1001";
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      Connection con = DriverManager.getConnection("jdbc:odbc:tarique");
      Statement st = con.createStatement();
PreparedStatement ps=con.prepareStatement("insert into StaffRegistration values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
ps.setString(1,staffid);
ps.setString(2,fname);
ps.setString(3,lname);
ps.setString(4,fathername);
ps.setString(5,paddress);
ps.setString(6,caddress);
ps.setString(7,joindate);
ps.setString(8,"resigndate");
ps.setString(9,sex);
ps.setString(10,experience);
ps.setString(11,subject);
ps.setString(12,phoneno);
ps.setString(13,mobile);
ps.setString(14,hsmarks);
ps.setString(15,hsyear);
ps.setString(16,imarks);
ps.setString(17,iyear);
ps.setString(18,gmarks);
ps.setString(19,gyear);
ps.setString(20,pgmarks);
ps.setString(21,pgyear);




//st.executeUpdate("insert into StaffRegistration(EmployeeID)values('"+t1+"')");


ps.executeUpdate();
//con.commit();
ps.close();
      
      con.close();
    }catch(Exception e) {e.printStackTrace();}
    return entries;
    }
}
