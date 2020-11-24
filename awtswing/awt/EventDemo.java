import java.awt.*;
import java.awt.event.*;
class EventDemo  implements ActionListener 
{
Frame f;
Button b,b1;
TextField tf;
	EventDemo()
	{	f=new Frame("aaa");
		b=new Button("ok");
		b1=new Button("cancle");
		Outer o=new Outer(this);
		b.addActionListener(this);
		
		b1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{

tf.setText("InnerListener");
}

});
		
		b.setBounds(20,100,40,40);
		b1.setBounds(20,180,40,40);
		tf=new TextField();
		tf.setBounds(20,40,100,40);
		f.add(tf);
		f.add(b);
		f.add(b1);
		
		f.setLayout(null);
		f.setSize(400,400);
		f.setVisible(true);

	}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b)
tf.setText("ok");
if(e.getSource()==b1)
tf.setText("cancel");
}

public static void main(String s[])
{
new EventDemo();

}

}









class Outer  implements ActionListener
{
EventDemo f;
Outer(EventDemo f)
{
this.f=f;
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==f.b)
f.tf.setText("lalu");
if(e.getSource()==f.b1)
f.tf.setText("rabari");
}

}
class WindowEventListener extends WindowAdapter
{
public void windowClosing(WindowEvent e1)
{
System.exit(0);
}

}



/*b.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
{
tf.setText("inner ok");
}
}
);*/
