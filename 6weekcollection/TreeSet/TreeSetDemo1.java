import java.util.*;
class TreeSetDemo1
{
public static void main(String s[])
{
TreeSet<Emp> al=new TreeSet<Emp>();
System.out.println(al.size());
al.add(new Emp(5000));
al.add(new Emp(4000));
al.add(new Emp(3000));
al.add(new Emp(2000));
Iterator i=al.iterator();
while(i.hasNext())
{
Emp e=(Emp)i.next();
System.out.println(e.salary);
}
}
}
class  Emp
{
int  salary;
Emp(int  salary)
{
this.salary=salary;
}

}



