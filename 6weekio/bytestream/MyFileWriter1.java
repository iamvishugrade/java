 /*Because the FileOutputStream instance is declared in a try-with-resource statement, it will be closed regardless of whether the try statement completes normally or abruptly (as a result of the method FileOutputStream.write throwing an IOException)*/

import java.io.*;
class MyFileWriter1
{

public static void main(String s1[])
{
try(FileOutputStream fw=new  FileOutputStream("lalu1.txt");FileInputStream fr=new FileInputStream("lalu1.txt"))
{
String s="india is good country in world ";

byte ch[]=s.getBytes();
for(int i=0;i<ch.length;i++)
fw.write(ch[i]);//fw.write(ch)
//fw.close();
System.out.println("file created Successfully");
int i=0;

while((i=fr.read())!=-1)
System.out.print((char)i);
}
catch(IOException  e){ }
}

}
