import java.io.*;

public class Matches{
   public static void main(String args[]){
      String Str = new String("Welcome to Tutorials of String");

      System.out.print("Return Value :" );
      System.out.println(Str.matches("(.*)Tutorials(.*)"));

      System.out.print("Return Value :" );
      System.out.println(Str.matches("Tutorials"));

      System.out.print("Return Value :" );
      System.out.println(Str.matches("Welcome(.*)"));
   }
}