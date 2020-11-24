 import java.io.*;

class MyFileWriter
{

public static void main(String s1[])throws IOException
{
//FileOutputStream fw=new  FileOutputStream("lalu.txt");//Write Mode
//FileOutputStream fw=new  FileOutputStream("lalu.txt",true);//Append Mode
FileOutputStream fw=new  FileOutputStream(new  File("e:\\f2\\lalu2.txt"));
//FileOutputStream fw=new  FileOutputStream(new  File("e:\\f2\\lalu2.txt"),true);

String s="india is good country in world  and with corrupted leader  ramdev and family babachorex nirmalbabachor/asaram chor/sudhanshu chor/shrishrichor  nityachor   radhay ma/bebo/mayachorni/manmohanurf shadow of sonia,robert damad,kalmari,salman khurshid,sharad pawar,chidambaram,mukesh ambani  gadgarichor/mulayamgunda;sheela lalchi  rahul gandhi  is single and reday to mingle  lal kitab baba,Rampal,ramraheemlove charger,lalu ydav,nitish,moti auntyurf amma";

byte ch[]=s.getBytes();
//fw.write(ch);
for(int i=0;i<ch.length;i++)
fw.write(ch[i]);
fw.close();
System.out.println("file created Successfully");
}

}
class MyFileReader
{

public static void main(String s1[])throws IOException
{
FileInputStream fr=new FileInputStream("lalu.txt");
//FileInputStream fr=new FileInputStream(new  File("e:\\f2\\lalu2.txt"));
int i=0;

while((i=fr.read())!=-1)
System.out.print((char)i);
fr.close();
}

}

class MyFileReader1
{

public static void main(String s1[])throws IOException
{
FileInputStream fr=new FileInputStream("lalu.txt");
byte  b[]=new  byte[fr.available()];
fr.read(b);
String  s=new  String(b);
System.out.print(s);
}

}



//FileOutputStream fw=new  FileOutputStream(new  File("e:\\f2\\lalu.txt"),true);

