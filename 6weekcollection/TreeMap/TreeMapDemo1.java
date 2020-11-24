//the key class  must be implementing  the Comparable interface  otherwise  ClassCastException  will be  thrown.

import java.util.*;
class TreeMapDemo1
{
public static void main(String s1[])
{
TreeMap<Temp,String> hm=new TreeMap<Temp,String>();
System.out.println(hm.size());
hm.put(new Temp(10),"dddd");
hm.put(new Temp(5),"cccc");
hm.put(new Temp(4),"bbbb");
hm.put(new Temp(1),"aaaa");
Set s=hm.entrySet();
Iterator i=s.iterator();
while(i.hasNext())
{
Map.Entry e=(Map.Entry)i.next();
Temp k=(Temp)e.getKey();
String v=(String)e.getValue();
System.out.println(k.x+"="+v);
}
}
}
class Temp implements Comparable<Temp>
{
int  x;
Temp(int x)
{
this.x=x;
}
public int compareTo(Temp t)
{
if(this.x>t.x)
return  1;
else if(this.x<t.x)
return  -1;
else
return 0;
}
}
