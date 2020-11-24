 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class SFrame1 implements ActionListener
{
JFrame f;
JButton b;
Button b1;
JTextField jt;
Icon i;
SFrame1(String s)
{	
i=new ImageIcon("puccy.gif");
 f=new JFrame(s);
jt=new JTextField();
jt.setBounds(150,40,100,100);
 b=new JButton(i);
b1=new Button("awt");
b.setBounds(40,40,100,100);
b1.setBounds(40,150,50,50);
f.add(b);
b.addActionListener(this);
f.add(b1);
f.add(jt);
f.setLayout(null);//WindowConstants
f.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
f.setSize(400,400);
f.setVisible(true);
}
public  void actionPerformed(ActionEvent e)
{
  jt.setText("swing");
}

public static void main(String s[])
{
new SFrame1("swing frame");

//new SFrame1("swing frame");
}
}







//Container c=f.getContentPane();
//c.add(jt);
//c.add(b);
//c.add(b1);



