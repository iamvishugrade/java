import java.awt.*;
import java.awt.event.*;
class MyFrame1 extends Frame 
{

MyFrame1(String s)
{	
super(s);
setSize(400,400);
addWindowListener(new Outer(this));
setVisible(true);
}

public static void main(String s[])
{
new MyFrame1("first frame");
}
}
class Outer extends WindowAdapter
{
MyFrame1 f;
Outer(MyFrame1 f)
{
this.f=f;
}
public void windowClosing(WindowEvent e)
{
f.setVisible(false);

}



}




