import  java.io.*;
import  java.io.*;

class   ThrowsException1
{
void show()throws  ArithmeticException
{
System.out.println("base");
}
ThrowsException1()//throws   IOException
{

}
}

class  Child   extends  ThrowsException1
{
Child()//throws   IOException
{

}
void show()throws  Exception
{
System.out.println("child");
}
public static void main(String...  s)//throws   IOException
{
Child   c=new  Child();

c.show();
}
}