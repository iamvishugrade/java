import java.util.*;
class ArrayListDemo4
{
public static void main(String s[])
{
ArrayList<ArrayList>  al=new ArrayList<ArrayList>();

System.out.println(al.size());
al.add(al);
al.add(al);
al.add(al);
al.add(al);
System.out.println(al.size());
System.out.println(al);
}
}