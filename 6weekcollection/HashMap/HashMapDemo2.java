import java.util.*;
class HashMapDemo2
{
public static void main(String s1[])
{
HashMap<Emp,String> hm=new HashMap<>();
System.out.println(hm.size());
hm.put(new Emp(10),"aaaa");
hm.put(new Emp(20),"bbbb");
hm.put(new Emp(30),"cccc");
hm.put(new Emp(40),"dddd");
Set s=hm.entrySet();
Iterator i=s.iterator();
while(i.hasNext())
{
Map.Entry e=(Map.Entry)i.next();
Emp k=(Emp)e.getKey();
String v=(String)e.getValue();
System.out.println(k.id+"="+v);
}
Emp e=new Emp(40);
String  ss=hm.get(e);
System.out.println(ss);
hm.remove(e);
s=hm.entrySet();
 i=s.iterator();
while(i.hasNext())
{
Map.Entry e1=(Map.Entry)i.next();
Emp k=(Emp)e1.getKey();
String v=(String)e1.getValue();
System.out.println(k.id+"="+v);
}

}
}

class Emp
{
int id;
Emp(int id)
{
this.id=id;
}
public  boolean  equals(Object  o)
{
Emp e=(Emp)o;

if(e.id==this.id)
return true;
else
return false;
}
public int hashCode()
{

return  id*10;
}
}