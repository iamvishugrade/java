import java.io.*;
class MyFileWriter
{

public static void main(String s1[])throws IOException
{
FileWriter fw=new FileWriter("ducat11.txt");
String s="india is good country ssss";
char ch[]=s.toCharArray();
for(int i=0;i<ch.length;i++)
fw.write(ch[i]);//fw.write(ch)or fw.write(s)
fw.close();
}
}
class MyFileReader
{

public static void main(String s1[])throws IOException
{
FileReader fr=new FileReader("ducat11.txt");
int i=0;
while((i=fr.read())!=-1)
System.out.print((char)i);
fr.close();
}

}