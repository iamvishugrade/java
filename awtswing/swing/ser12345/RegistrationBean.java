package pack;
import java.sql.*;
public class RegistrationBean
{
private String filledby,email1,email2,pwd1,pwd2,day,month,year,date1,sex,age;
public String getFilledby()
{
return filledby;
}
public void setFilledby(String filledby)
{
this.filledby=filledby;
}
public String getPwd1()
{
return pwd1;
}
public void setPwd1(String pwd1)
{
this.pwd1=pwd1;
}
public String getEmail1()
{
return email1;
}
public void setEmail1(String email1)
{

this.email1=email1;
System.out.println("mail is......."+email1);
}
public String getDay()
{
return day;
}
public void setDay(String day)
{
this.day=day;
System.out.println(day);
}
public String getMonth()
{
return month;
}
public void setMonth(String month)
{
this.month=month;
System.out.println(month);
}
public String getYear()
{
return year;
}
public void setYear(String year)
{
this.year=year;
System.out.println(year);
}
public String getDate()
{
date1=day+"-"+month+"-"+year;
System.out.println(date1);
return date1;
}
/*public void setMale(String male)
{
this.male=male;
System.out.println(male);
}
public String getMale()
{
return male;
}
public void setFemale(String female)
{
this.female=female;
System.out.println(female);
}
public String getFemale()
{
return female;
}*/
public void setSex(String sex)
{
this.sex=sex;
System.out.println("sex............."+sex);
}
public String getSex()
{
return sex;
}
public void setAge(String age)
{
this.age=age;
System.out.println("sex............."+age);
}
public String getAge()
{
return age;
}

	public boolean Registration()
	{
	int ii=email1.indexOf("@");
	String name=email1.substring(0,ii);
	System.out.println("name............"+name);
	try
	{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection con=DriverManager.getConnection("jdbc:odbc:shaadi");
	System.out.println("driver is loaded:");
	String date2=getDate();
	System.out.println(date2);
	//System.out.println("female......."+getFemale());
	System.out.println("male ...."+getSex());
PreparedStatement stmt=con.prepareStatement("insert into login(fillby,email1,pass,gender,age,logindate,name)values(?,?,?,?,?,?,?)");
	stmt.setString(1,filledby);
	stmt.setString(2,email1);
	stmt.setString(3,pwd1);
	stmt.setString(4,sex);
	stmt.setString(5,age);
	stmt.setString(6,date2);
	stmt.setString(7,name);
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
