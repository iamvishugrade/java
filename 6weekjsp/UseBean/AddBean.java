package my;
import java.sql.*;
 public  class AddBean 
{
private int  firstno;
private int   sencondno;

public void setFirstno(int firstno)
{
this.firstno=firstno;
}
public void setSencondno(int  sencondno)
{
this.sencondno=sencondno;
}
public int getFirstno()
{
return firstno;

}
public int  getSencondno()
{
return sencondno;
}

public int add()
{
return firstno+sencondno;
}
}