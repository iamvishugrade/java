import java.util.*;
class MyComp implements Comparator 
{
public int compare(Object o1,Object o2)
{
Temp t1=(Temp)o1;
Temp t2=(Temp)o2;
if(t1.salary>t2.salary)
return 1;
else if(t1.salary<t2.salary)
return -1;
else
return 0;

}
}

class MyTree
{
public static void main(String s[])
{
Comparator m= new MyComp();
TreeSet<Temp>  t=new TreeSet<Temp>(m);
t.add(new Temp(10));
t.add(new Temp(5));
t.add(new Temp(1));
t.add(new Temp(3));
t.add(new Temp(2));
t.add(new Temp(4));
t.add(new Temp(15));
Iterator i=t.iterator();
while(i.hasNext())
{
Temp t1=(Temp)i.next();
System.out.println(t1.salary);
}
}
}
class Temp
{
int salary ;
Temp(int salary )
{
this.salary=salary;
}
}