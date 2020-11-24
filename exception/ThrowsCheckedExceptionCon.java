import  java.io.*;
import  java.io.*;

class   ThrowsCheckedExceptionCon
{
ThrowsCheckedExceptionCon ()throws  IOException
{
System.out.println("base");
}
}

class  Child   extends  ThrowsCheckedExceptionCon
{
Child()throws  Exception
{
System.out.println("child");
}
}