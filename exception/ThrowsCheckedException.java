import  java.io.*;
import  java.io.*;
import  java.sql.*;
class   ThrowsCheckedException
{
void show()throws  IOException
{
System.out.println("base");
}
}

class  Child   extends  ThrowsCheckedException
{
void show()throws  ArithmeticException
{
System.out.println("child");
}
}