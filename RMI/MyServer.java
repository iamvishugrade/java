//from jdk8 onwords u do not need tu use rmic tool for creating stub and skeleton clases.
package my;
import java.rmi.*;
import java.rmi.server.*;
public class MyServer extends UnicastRemoteObject implements MyRemote 
{
public MyServer()throws RemoteException
{}
public int add(int x,int y)throws RemoteException
{
return(x+y);
}
}