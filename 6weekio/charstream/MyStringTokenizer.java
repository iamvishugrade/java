import java.io.*;
import java.util.*;
class MyStringTokenizer
{
public static void main(String s1[])throws IOException
{
String s="country=india;capital=delhi;country=japan;captial=tokyo;";
StringTokenizer st=new StringTokenizer(s,";=");
while(st.hasMoreTokens())
{
System.out.println(st.nextToken());
}
}
}