import java.io.*;
class Ps
{

public static void main(String s[])throws IOException
{
FileOutputStream fout=new FileOutputStream("chachi.txt");
PrintStream ps=new  PrintStream(fout);
FileOutputStream fout1=new FileOutputStream("chacha.txt",true);
PrintStream ps1=new  PrintStream(fout1);
System.out.println("before");
PrintStream  ps4=System.out;
System.setOut(ps);
System.setErr(ps1);
System.out.println("chachi 420");
System.out.println("chachi  840");
System.err.println("chacha 420");
System.err.println("chacha 840");
//System.out=ps4;
System.setOut(ps1);
System.out.println("chacha  240");
System.setOut(ps4);
ps4.println("after");
System.out.println("via actual out");

}
}



/* int x=get();
int get()
{
System.err.println("india");
return 10;
}*/

//System.setOut(ps);
//System.err.println("india");
//System.err.println("hindustan");


//System.setOut(ps);
//System.err.println("india");
//System.err.println("hindustan");
//ps.println("hello");
//ps.println("hay");
//Ps t=new Ps();
//System.err.println(t.x);




//ps.println("lalu");
//ps.println("rabari");
//System.setOut(ps);
//System.err.println("qq");
//System.err.println("aa");
//System.err.println(new Ps().x);