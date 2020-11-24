import java.io.*;
public class MyClient1
{
ObjectOutputStream dout;
public MyClient1()
{
try
{
			
emp e1=new emp("ducat noida",10,5,20,100);
dout=new ObjectOutputStream(new FileOutputStream("ducat3"));
dout.writeObject(e1);	
dout.flush();
}
catch(Exception  e)
{
System.out.println(e);
}
}
public static void main(String ar[])
{
new MyClient1();
}
}
