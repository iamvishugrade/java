/*public String[] split(String regex, int limit)
public String[] split(String regex)*/
 class Split2{
   public static void main(String args[])
{
      
String Str = new String("Welcome   to Tutorials  of String");

      System.out.println("Return Value :" );
String  s[]=Str.split(" ", 2);
      for (int i=0;i<s.length;i++ )
{
         System.out.println(s[i]);
      }
      System.out.println("");
 s=Str.split(" ",3);
      System.out.println("Return Value :" );
      for (int i=0;i<s.length;i++ )
     {
         System.out.println(s[i]);
      }
      System.out.println("");
 s=Str.split(" ",0);
      System.out.println("Return Value :" );
      for (int i=0;i<s.length;i++ )
{
         System.out.println(s[i]);
      }
      System.out.println("");
s=Str.split(" ");
      System.out.println("Return Value :" );
      for (int i=0;i<s.length;i++ )
{
         System.out.println(s[i]);
      }
   }
}