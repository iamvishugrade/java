package tarique;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;

public class EmpIdBean 
{
	String empid,loginname,pass,repass,question,answer,secmail,collagecode;

        public void setCollageCode(String collagecode) {
        this.collagecode=collagecode;
        }
                
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setRepass(String repass) {
		this.repass = repass;
	}

	public void setSecmail(String secmail) {
		this.secmail = secmail;
	}

        public String getCollagecode(){
            return collagecode;
        }
        
	public String getAnswer() {
		return answer;
	}

	public String getEmpid() {
		return empid;
	}

	public String getLoginname() {
		return loginname;
	}

	public String getPass() {
		return pass;
	}

	public String getQuestion() {
		return question;
	}

	public String getRepass() {
		return repass;
	}

	public String getSecmail() {
		return secmail;
	}
	
	
	public Hashtable getIdData()
    {
    Hashtable entries = new Hashtable();
      try
    {
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      Connection con = DriverManager.getConnection("jdbc:odbc:tarique");
      Statement st = con.createStatement();
      PreparedStatement ps=con.prepareStatement("insert into User values(?,?)");
      PreparedStatement ps1=con.prepareStatement("insert into EmpIdInfo values(?,?,?,?)");
      PreparedStatement ps2=con.prepareStatement("select EmployeeID from StaffRegistration where EmployeeID=?");
      System.out.println("Wwellcome");
      ps2.setString(1,empid);
      
       ResultSet rs1=ps2.executeQuery();
      
      System.out.println(question);
      System.out.println(answer);
      System.out.println(secmail);
      System.out.println(loginname);
      
    	
      ps1.setString(1,loginname);
      ps1.setString(2,question);
      ps1.setString(3, answer);
      ps1.setString(4,secmail);
      ps.setString(1,loginname);
      ps.setString(2,pass);
      
	ps.executeUpdate();
	ps1.executeUpdate();
      
	ps.close();
	ps1.close();
    
  /*  else
    {
    	System.out.println("worng user");
    }*/
	con.close();
    }catch(Exception e)
    {
    	System.out.println(e);
    }
    return entries;
}
}