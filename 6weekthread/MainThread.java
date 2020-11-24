
class MainThread
{
public static void main(String s[])
{
Thread t=Thread.currentThread();
System.out.println(t.getName());
t.setName("main changed");
System.out.println(t.getName());
}
}


