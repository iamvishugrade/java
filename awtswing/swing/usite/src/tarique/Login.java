package tarique;
import java.sql.*;
public class Login 
{
	String name,pass;

	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public boolean validateLogin()
	{
		try
		{
		boolean flag=false;
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:odbc:tarique");
		  
  	    Statement st = con.createStatement();
		 
				ResultSet rs=st.executeQuery("select * from Login where loginname='"+name+"'");
				if(rs.next())
				{
				String uname=rs.getString(1);
				String upass=rs.getString(2);
					if(uname.equals(name)&&(upass.equals(pass)))
					{
						System.out.println("right code");
						flag=true;
					}
			
				}
			return flag;
			}catch(Exception e)
			{
				return false;
			}
	}
	
}
