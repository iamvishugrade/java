import java.util.*;
class TreeSetDemo
{
public static void main(String s[])
{
TreeSet<Emp> al=new TreeSet<Emp>();
System.out.println(al.size());
al.add(new Emp(10000));
al.add(new Emp(9000));
al.add(new Emp(5000));
al.add(new Emp(5000));
Iterator<Emp>  i=al.iterator();
while(i.hasNext())
{
Emp e=i.next();
System.out.println(e.salary);
}
}
}
class Emp implements Comparable<Emp>
{
int  salary;
Emp(int salary)
{
this.salary=salary;
}
public int compareTo(Emp  t)
{

if(this.salary>t.salary)
return  1;
else if(this.salary<t.salary)
return  -1;
else
return 0;
}
}



 /*al.add(new Temp(10));
al.add(new Temp(9));
al.add(new Temp(8));
al.add(new Temp(7));*/


