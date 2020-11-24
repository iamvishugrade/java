package tarique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class NewAccount
{
	String loginname,password,usertype,id,question,answer;

	public String getAnswer() {
		return answer;
	}

	public String getId() {
		return id;
	}

	public String getLoginname() {
		return loginname;
	}

	public String getPassword() {
		return password;
	}

	public String getQuestion() {
		return question;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	Connection con;
	Statement st;
	ResultSet rs;
	public NewAccount()
	{
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    con = DriverManager.getConnection("jdbc:odbc:tarique");
		}catch(Exception e){}
	}
	
	public ArrayList submitNewAccount()
	{
		ArrayList al=new ArrayList();
		
		try
		{
		 st=con.createStatement();
		 con.createStatement();
		 PreparedStatement ps=con.prepareStatement("insert into Login values(?,?,?,?,?,?)");
		 ps.setString(1,loginname);
		 ps.setString(2,password);
		 ps.setString(3,usertype);
		 ps.setString(4,id);
		 ps.setString(5,question);
		 ps.setString(6,answer);
		 ps.executeUpdate();
		 con.close();
		 ps.close();
		}catch(Exception e){}
	return  al;
	}
}
