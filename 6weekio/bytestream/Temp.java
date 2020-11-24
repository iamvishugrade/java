import java.io.*;
class Temp
{
public static void main(String s[])throws Exception
{
FileOutputStream fout=new  FileOutputStream("aa.txt");
PrintStream ps =new PrintStream(fout);
System.setOut(ps);
System.out.println("hello ");
System.out.println("hay");

}


}