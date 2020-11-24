package tarique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.Hashtable;
import java.util.*;

public class ExamBean 
{
	String rollno,coursecode,institutecode,selname,selsem,selopaper1,selopaper2,checkcarrypaper,selattempt;

	public void setCheckcarrypaper(String checkcarrypaper) {
		this.checkcarrypaper = checkcarrypaper;
	}


	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}


	public void setInstitutecode(String institutecode) {
		this.institutecode = institutecode;
	}


	public void setRollno(String rollno) {
		this.rollno = rollno;
	}


	public void setSelattempt(String selattempt) {
		this.selattempt = selattempt;
	}


	public void setSelname(String selname) {
		this.selname = selname;
	}


	public void setSelopaper1(String selopaper1) {
		this.selopaper1 = selopaper1;
	}


	public void setSelopaper2(String selopaper2) {
		this.selopaper2 = selopaper2;
	}


	public void setSelsem(String selsem) {
		this.selsem = selsem;
	}

	public String getCheckcarrypaper() {
		return checkcarrypaper;
	}


	public String getCoursecode() {
		return coursecode;
	}


	public String getInstitutecode() {
		return institutecode;
	}


	public String getRollno() {
		return rollno;
	}


	public String getSelattempt() {
		return selattempt;
	}


	public String getSelname() {
		return selname;
	}


	public String getSelopaper1() {
		return selopaper1;
	}


	public String getSelopaper2() {
		return selopaper2;
	}


	public String getSelsem() {
		return selsem;
	}

	public Hashtable getExamData()
    {
    Hashtable entries = new Hashtable();
    try
    {
	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      Connection con = DriverManager.getConnection("jdbc:odbc:tarique");
      Statement st = con.createStatement();
      PreparedStatement ps=con.prepareStatement("insert into Exam values(?,?,?,?,?,?,?,?,?)");
      
    	
     ps.setString(1,rollno);
     ps.setString(2,institutecode);
     ps.setString(3,coursecode);
     ps.setString(4,selname);
     ps.setString(5,selsem);
     ps.setString(6,selopaper1);
     ps.setString(7,selopaper2);
     ps.setString(8,checkcarrypaper);
     ps.setString(9,selattempt);
	ps.executeUpdate();
    ps.close();
 	con.close();
    }catch(Exception e)
    {
    	System.out.println(e);
    }
    return entries;
}
}


	