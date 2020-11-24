import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Swingcal implements ActionListener
{
public String str[]=new String[] {"0","1","2","3","4","5","6","7","8","9",".","+","-","*","/","%","C","CE","root","-x","+x","1/x","="};
JFrame f;
double num,c;
JButton b[]=new JButton[str.length];
JTextField tf;
JLabel l;

int x=40,y=180;

Swingcal(String d)
{
f=new JFrame(d);
l=new JLabel("Enter the number");
l.setBounds(40,40,400,30);
f.add(l);

tf=new JTextField("THANKYOU MANISH SIR TO TEACH ME JAVA");
tf.setBounds(50,90,400,60);

f.add(tf);
int n=0;
int y=180;	

for(int i=0;i<6;i++)
	{
	int x=60;
	for(int j=0;j<5;j++)
	{
int c=str.length-1;
		if(n<c)
		{
			b[n]=new JButton(str[n]);
			b[n].setForeground(Color.RED);
			b[n].setBounds(x,y,55,50);
			f.add(b[n]);
			b[n].addActionListener(this);
			x=x+50+30;
			n++;
		}
			else if(n==str.length-1)
			{
			  b[n]=new JButton(str[n]);
			  b[n].setForeground(Color.RED);
			  b[n].setBounds(x,y,180,50);
			  f.add(b[n]);
			  b[n].addActionListener(this);
			  x=x+50+30;
			  n++;			
			}
		}
	y=y+80;
	System.out.println();
	}

f.setLayout(null);
f.setSize(500,700);
//f.pack();
f.setVisible(true);


f.addWindowListener(new WindowEventListener());

tf.addKeyListener(new KeyEventListener(this));

tf.addMouseListener(new MouseEventListener(this));
}



public void actionPerformed(ActionEvent e)
{

	if(tf.getText().equals("THANKYOU MANISH SIR TO TEACH ME JAVA"))
	{
		tf.setText("");
		tf.setForeground(Color.RED);
	}

for(int i=0;i<str.length;i++)
	{
	b[i].setBackground(null);
	}

	if(e.getSource()==b[0])
	{
		tf.setText(tf.getText()+"0");
		b[0].setBackground(Color.YELLOW);
		
	}
	if(e.getSource()==b[1])
	{
		tf.setText(tf.getText()+"1");
		b[1].setBackground(Color.YELLOW);
	}
	if(e.getSource()==b[2])
	{
		tf.setText(tf.getText()+"2");
		b[2].setBackground(Color.YELLOW);
	}
	if(e.getSource()==b[3])
	{
		tf.setText(tf.getText()+"3");
		b[3].setBackground(Color.YELLOW);
	}
	if(e.getSource()==b[4])
	{
		tf.setText(tf.getText()+"4");
		b[4].setBackground(Color.YELLOW);
	}
	if(e.getSource()==b[5])
	{
		tf.setText(tf.getText()+"5");
		b[5].setBackground(Color.YELLOW);
	}
	if(e.getSource()==b[6])
	{
		tf.setText(tf.getText()+"6");
		b[6].setBackground(Color.YELLOW);
	}
	if(e.getSource()==b[7])
	{
		tf.setText(tf.getText()+"7");
		b[7].setBackground(Color.YELLOW);
	}

	if(e.getSource()==b[8])
	{
		tf.setText(tf.getText()+"8");
		b[8].setBackground(Color.YELLOW);
	}
	if(e.getSource()==b[9])
	{
		tf.setText(tf.getText()+"9");
		b[9].setBackground(Color.YELLOW);
	}


	if(e.getSource()==b[10])
	{ 
		tf.setText(tf.getText()+".");
		b[10].setBackground(Color.YELLOW);
	}


        if(e.getSource()==b[11])
	{ 
		b[11].setBackground(Color.GREEN);
		num=Double.parseDouble(tf.getText());
		tf.setText("");       	
		c=1;
	}

	if(e.getSource()==b[12])
	{ 
		b[12].setBackground(Color.GREEN);
		num=Double.parseDouble(tf.getText());
		tf.setText("");       	
		c=2;
	}
  

	if(e.getSource()==b[13])
	{ 
		b[13].setBackground(Color.GREEN);
		num=Double.parseDouble(tf.getText());
		tf.setText("");       	
		c=3;
	}



	if(e.getSource()==b[14])
	{ 
		b[14].setBackground(Color.GREEN);
		num=Double.parseDouble(tf.getText());     
		tf.setText("");      	
		c=4;
	}


	if(e.getSource()==b[15])
	{ 
		b[15].setBackground(Color.GREEN);
		num=Double.parseDouble(tf.getText());
		tf.setText("");      	
		c=5;
	}

	if(e.getSource()==b[18])
	{ 
		b[18].setBackground(Color.GREEN);
		num=Double.parseDouble(tf.getText());
		tf.setText("Press equal too");      	
		c=6;
	}

		
	if(e.getSource()==b[16])
	{
		b[16].setBackground(Color.LIGHT_GRAY);
		String s=tf.getText();
            	tf.setText("");
            		for(int i=0;i<s.length()-1;i++)
			{
            		tf.setText(tf.getText()+s.charAt(i));
			}
	}

	if(e.getSource()==b[17])
	{
		b[17].setBackground(Color.LIGHT_GRAY);
		tf.setText(" ");
		tf.setText("THANKYOU MANISH SIR TO TEACH ME JAVA");	
	}


	if(e.getSource()==b[19])
	{
		b[19].setBackground(Color.CYAN);
		tf.setText("-"+tf.getText());
	}

	if(e.getSource()==b[20])
	{
		b[20].setBackground(Color.CYAN);
		tf.setText("+"+tf.getText());
	}

	if(e.getSource()==b[21])
	{
		b[21].setBackground(Color.CYAN);
		num=1/Double.parseDouble(tf.getText());
		tf.setText(String.valueOf(num));
	}

  if(e.getSource()==b[22])
  {
	b[22].setBackground(Color.MAGENTA);

	if(c==1)
	{
		num=num+Double.parseDouble(tf.getText());
		tf.setText(String.valueOf(num));
	}

	if(c==2)
	{
		num=num-Double.parseDouble(tf.getText());
		tf.setText(String.valueOf(num));
	}

	if(c==3)
	{
		num=num*Double.parseDouble(tf.getText());
		tf.setText(String.valueOf(num));
	}

	if(c==4)
	{
		num=num/Double.parseDouble(tf.getText());
		tf.setText(String.valueOf(num));
	}
	if(c==5)
	{
    		num=num*Double.parseDouble(tf.getText())/100;
		tf.setText(String.valueOf(num));
	}
	if(c==6)
	{
    		num=Math.sqrt(num);
		tf.setText(String.valueOf(num));
	}
   }
}


public static void main(String...s)
{
new Swingcal("Calculator Designed By Ashok");
}
}


class WindowEventListener extends WindowAdapter
{
public void windowClosing(WindowEvent e)
{
System.exit(0);
}
}


class KeyEventListener extends KeyAdapter
{
Swingcal d;
KeyEventListener(Swingcal u)
{
this.d=u;
}
public void keyPressed(KeyEvent e)
{
if(d.tf.getText().equals("THANKYOU MANISH SIR TO TEACH ME JAVA"))
	{
		d.tf.setText("");
		//d.tf.setForeground(Color.BLUE);
		
	}
d.tf.setForeground(Color.BLUE);
}
public void KeyTyped(KeyEvent e)
{
System.out.println(e.getKeyChar());
}
}



class MouseEventListener extends MouseAdapter
{
Swingcal d;
MouseEventListener(Swingcal u)
{
this.d=u;
}
public void mouseClicked(MouseEvent e1)
{
if(d.tf.getText().equals("THANKYOU MANISH SIR TO TEACH ME JAVA"))
	{
		d.tf.setText("");
			}
d.tf.setForeground(Color.GREEN);

for(int i=0;i<d.str.length;i++)
	{
	d.b[i].setBackground(null);
	}
}
}
