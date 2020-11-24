import java.awt.*;
import java.awt.event.*;
class MyFrame implements ActionListener
{
Frame f;
Button b;
Label l;
TextField tf;
MyFrame(String s)
{	

 f=new Frame(s);
l=new Label("Enter the no.");
l.setBounds(40,40,50,20);
f.add(l);
tf=new TextField();
tf.setBounds(100,40,50,20);
f.add(tf);
 b=new Button("ok");
b.setBounds(40,100,50,50);
b.addActionListener(this);
f.add(b);
f.setLayout(null);
f.setSize(400,400);
f.setVisible(true);
}
public void actionPerformed(ActionEvent e)
{
try
{
Runtime t=Runtime.getRuntime();
t.exec("notepad");
}catch(Exception e1){  }
}

public static void main(String s[])
{
new MyFrame("first frame");
}
}




