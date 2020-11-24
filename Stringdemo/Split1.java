/*public String[] split(String regex, int limit)
public String[] split(String regex)*/
public class Split1{
   public static void main(String args[])
{
     String Str = new String("Welcome-to-Tutorials-of-String");
//String Str = new String("Welcome to Tutorials of String");
//String z[]=Str.split("-");
//String z[]=Str.split(" ");
String z[]=Str.split("-",3);
//String z[]=Str.split(" ",3);
for(int i=0;i<z.length;i++)
System.out.println(z[i]);
System.out.println(z.length);


         
}
}