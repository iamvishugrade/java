package tarique;

	import java.sql.*;
import java.util.*;
	public class StdResult 
	{
		private String rollno,fsem,secsem,course,sem;

		public String getRollno() {
			return rollno;
		}

		public void setRollno(String rollno) {
			this.rollno = rollno;
		}
		public String getFsem() {
			return fsem;
		}

		public String getSecsem() {
			return secsem;
		}
		public String getCourse() {
			return course;
		}

		public String getSem() {
			return sem;
		}


		public void setFsem(String fsem) {
			this.fsem = fsem;
		}

		public void setSecsem(String secsem) {
			this.secsem = secsem;
		}
		public void setCourse(String course) {
			this.course = course;
		}

		public void setSem(String sem) {
			this.sem = sem;
		}

		
		
	Connection con;
	Statement st;
	Statement st1;
	Statement st2;
	
	
	public StdResult()
	{
	try
	{
		
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    con = DriverManager.getConnection("jdbc:odbc:tarique");
    System.out.println("driver successfully"+course);
	}catch(Exception e){}
	}
	
	
	
	
	
	public ArrayList[] rollNo1()
	{
		ArrayList al[]=new ArrayList[3];
		
		try
		{
			al[0]=new ArrayList();
			al[1]=new ArrayList();
			al[2]=new ArrayList();
		st=con.createStatement();
		st1=con.createStatement();
		st2=con.createStatement();
	    
		ResultSet rs=st.executeQuery("select * from StdRegistration where RollNo="+rollno);
	    ResultSet rs1=st1.executeQuery("select * from InstituteDetails where RollNo="+rollno);
String c="mca";
	    ResultSet rs2=st2.executeQuery("select * from Marks where RollNo="+rollno);
		
		while(rs.next())
		{
			
			StdData sd=new StdData();
			sd.stdname=rs.getString(2);
			sd.fathername=rs.getString(3);
			sd.course=rs.getString(6);
			sd.status=rs.getString(25);
			al[0].add(sd);
		}
		while(rs1.next())
		{
			StdData1 sd1=new StdData1();
			sd1.iname=rs1.getString(3);
			al[1].add(sd1);
		}
		while(rs2.next())
		{
			System.out.println(rs2);
			MarksData md=new MarksData();
			md.subject=rs2.getString(4);
			al[2].add(md);
		}
	
		}catch(Exception e){}
	return  al;
	}

	
	
	
	
	
	

}	
