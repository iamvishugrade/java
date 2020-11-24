package pack;
import java.sql.*;
public class ProfileBean
{
private String relationship,maritalstatus,bodytype,height,email1;
private String mothertongue,caste,educationlevel,occupation;

public void setRelationship(String relationship)
{
this.relationship=relationship;

}
public String getRelationship()
{
return relationship;
}
public void setMaritalstatus(String maritalstatus)
{
this.maritalstatus=maritalstatus;
System.out.println(".........."+maritalstatus);
}
public String getMaritalstatus()
{
return maritalstatus;
}
public void setBodytype(String bodytype)
{
this.bodytype=bodytype;
System.out.println(".........."+bodytype);
}
public String getBodytype()
{
return bodytype;
}
public void setHeight(String height)
{
this.height=height;
System.out.println(".........."+height);
}
public String getHeight()
{
return height;
}
public void setMothertongue(String mothertongue)
{
this.mothertongue=mothertongue;
System.out.println(".........."+mothertongue);
}
public String getMothertongue()
{
return mothertongue;
}
public void setCaste(String caste)
{
this.caste=caste;
System.out.println(".........."+caste);
}
public String getCaste()
{
return caste;
}

public void setEducationlevel(String educationlevel)
{
this.educationlevel=educationlevel;
System.out.println(".........."+educationlevel);
}
public String getEducationlevel()
{
return educationlevel;
}

public void setOccupation(String occupation)
{
this.occupation=occupation;
System.out.println(".........."+occupation);
}
public String getOccupation()
{
return occupation;
}
public void setEmail1(String email1)
{
this.email1=email1;
System.out.println(".........."+email1);
}
public String getEmail1()
{
return email1;
}




public boolean profile()
	{
	try
	{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection con=DriverManager.getConnection("jdbc:odbc:shaadi");
	System.out.println("driver is loaded:");
	
PreparedStatement stmt=con.prepareStatement("insert into userprofile(profile,mstatus,mtongue,education,bodytype,height,caste,profession,email1)values(?,?,?,?,?,?,?,?,?)");
	stmt.setString(1,relationship);
	stmt.setString(2,maritalstatus);
	stmt.setString(3,mothertongue);
	stmt.setString(4,educationlevel);
	stmt.setString(5,bodytype);
	stmt.setString(6,height);
	stmt.setString(7,caste);
	stmt.setString(8,occupation);
	stmt.setString(9,email1);
	System.out.println("value are setted");
	stmt.executeUpdate();
	System.out.println("execute update");
		//System.out.println(getDate());	
	con.commit();
	con.close();
	return true;
	}
	catch(Exception e)
	{
	return false;
	}
	}

	
}
