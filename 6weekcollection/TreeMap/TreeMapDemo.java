import java.util.*;
class TreeMapDemo
{
public static void main(String s1[])
{
TreeMap<String,String> hm=new TreeMap<String,String>();
System.out.println(hm.size());
hm.put("1004","dddd");
hm.put("1003","cccc");
hm.put("1002","bbbb");
hm.put("1001","aaaa");
Set s=hm.entrySet();
Iterator i=s.iterator();
while(i.hasNext())
{
Map.Entry e=(Map.Entry)i.next();
String k=(String)e.getKey();
String v=(String)e.getValue();
System.out.println(k+"="+v);
}

}


}