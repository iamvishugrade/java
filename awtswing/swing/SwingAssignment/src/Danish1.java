import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Danish1 implements ActionListener
{
	JTextField jtf1;
	JTextField jtf2;
	JTextArea txt;
	JScrollPane scrollpane;

//******************************************************************************************************************************************************************
	/*this method will check for decimal point and '-' sign in the two numbers and produce non negative integers for multiplication 
	  send it to "largemultiplication()" as parameters and get the final product with complete decimal and sign and return its as string.*/

	public String getProduct(String a, String b)
	{
		int minus[]={0,0};		
		int decimal1[]=new int[2];
		StringBuffer st[]= {new StringBuffer(a),new StringBuffer(b)};		
		for(int i=0;i<2;i++)
		{
			if(st[i].charAt(0)=='-')
			{
				st[i].deleteCharAt(0);
				minus[i]=1;
			}			
			decimal1[i]=st[i].length();
			for(int j=0;j<st[i].length();j++)
			{
				if(st[i].charAt(j)=='.')
				{
					decimal1[i]=j;
					st[i].deleteCharAt(j);
				}
			}
		}
		int minussum=minus[0]+minus[1];
		int decimal= st[0].length() + st[1].length() - decimal1[0] - decimal1[1];		
		String ans = this.largemultiplication(st[0].toString(),st[1].toString(),minussum,decimal);
		System.out.println(ans);
		return ans;
	}
//******************************************************************************************************************************************************************

	/*this method will calculate the product of the two large integers as given by the method "getProduct()" 
	  and return the product back to "getProduct()".*/

	public  String largemultiplication(String s1, String s2,int minus, int decimal)
	{
		int m = 5;	
		float n1 =s1.length();
		float n2 =s2.length();
		if(n1<=m && n2<=m)
		{
			StringBuffer product;
			product= new StringBuffer(Long.toString(Long.parseLong(s1) * Long.parseLong(s2)));
			if(decimal>product.length()) 
			{
				int z=decimal-product.length(); 
				for(int x =0;x<z;x++){ product= product.insert(0,'0');}
			}
			product.insert(product.length()-decimal,'.');
			if(minus==1){ product.insert(0,'-');}														
			return product.toString();
		}
		else
		{
			int part1=(int)Math.ceil(n1/m);
			int part2=(int)Math.ceil(n2/m);
			//**********************************************************getting no of parts to be made of each string for multiplication.
		
			long number1[] = new long[part1];
			long number2[] = new long[part2];
		
			//*********************************************long variables created ,as many as parts of strings to hold respective values.

			int j = (int)n1 - m;
			int k = 0;
			if(n1<=m)
			{
				number1[0]=Long.parseLong(s1.substring(0));
			}
			else{
		number1:
			for(int i=0;i<part1;i++)
			{
				if(k==0)
				{
					number1[i]=Long.parseLong(s1.substring(j));
				}
				if(k>0)
				{	
					number1[i]=Long.parseLong(s1.substring(j,k));
				}
				k=j;
				j=j-m;
				if(j<0 && j!=-m)
				{
					number1[i+1]= Long.parseLong(s1.substring(0,k));
					break number1;
				}
				
			}
			}
			if(n2<=m)
			{
				number2[0]=Long.parseLong(s2.substring(0));
			}
			else{
			j=(int)n2 - m;
			k=0;
		number2:
			for(int i=0;i<part2;i++)
			{
				if(k==0)
				{
					number2[i]=Long.parseLong(s2.substring(j));
				}
				if(k>0)
				{	number2[i]=Long.parseLong(s2.substring(j,k));
				}
				k=j;
				j=j-m;
				if(j<0 && j != -m)
				{
					number2[i+1]= Long.parseLong(s2.substring(0,k));
					break number2;
				}
			}
			}
			//***************************************************************************now multiplying the two arrays to form a matrix.

			long productmatrix[][]= new long[part1][part2];
			for(j=0;j<part1;j++)
			{
				for(k=0;k<part2;k++)
				{
					productmatrix[j][k]= number1[j] * number2[k];
				}
				
			}
			//*********************************************************************now adding diagonally and keeping sum in  array.
		
			long sum;
			int ds =part1+part2-1;
			StringBuffer diagonalsum[] = new StringBuffer[ds];
			for(int i=0;i<ds;i++)
			{
				sum=0;
				for(j=0;j<part1;j++)
				{
					for(k=0;k<part2;k++)
					{
						if(i==j+k)
						{
							sum=sum + productmatrix[j][k];
						}
					}
				}
				diagonalsum[i]= new StringBuffer(Long.toString(sum));
				System.out.println(diagonalsum[i]);
			}
			//************************************************************************the ans in array form.

			String queue[] = new String[diagonalsum.length];
			for(int i =0;i<diagonalsum.length;i++)
			{
				if(diagonalsum[i].length()==m)
				{
					queue[i]=diagonalsum[i].toString();
				}
				if(diagonalsum[i].length()>m )
				{
					if(i+1==diagonalsum.length)
					{
						queue[i]=diagonalsum[i].toString();
					}
					else
					{
						queue[i]=diagonalsum[i].substring(diagonalsum[i].length()-m).toString();
						long add1 = Long.parseLong(diagonalsum[i].substring(0,diagonalsum[i].length()-m));
						long sum2 = Long.parseLong(diagonalsum[i+1].toString()) + add1;
						diagonalsum[i+1].replace(0,diagonalsum[i+1].length(),Long.toString(sum2));
					}
				}
				if(diagonalsum[i].length()<m)
				{
					int z = m - diagonalsum[i].length() - 1;
					String zero[] = {"0","00","000","0000","00000","000000","0000000","00000000"};
					queue[i]= zero[z] + diagonalsum[i].toString();
				}
			}
			
			//*************************************************************************

			String hold =queue[queue.length-1];
			for(int i=queue.length-2; i>=0;i--)
			{	
				hold =  hold + queue[i];               //this ans is started by unwanted zeroes and space .
			}
			//**************************************************************************

			for(int i =0;i<hold.length();i++)
			{
				if(hold.charAt(i) != '0')
				{	
					StringBuffer product;
					product= new StringBuffer(hold.substring(i));
					if(decimal>product.length())
					{
						int z=decimal-product.length();
						for(int x =0;x<z;x++)
						{
							product= product.insert(0,'0');
						}
					}
					product.insert(product.length()-decimal,'.');
					if(minus==1)
					{
						product.insert(0,'-');
					}														
					return product.toString();
				}			
			}
		}
		return "0";
	}
//******************************************************************************************************************************************************************

	public void create()
	{
		JFrame frame = new JFrame("Large Number Multiplier");
			JPanel jp1 = new JPanel();
				JLabel jl1 = new JLabel("Enter the First Number:");
				JLabel jl2 = new JLabel("Enter the Second Number:");
				jtf1 = new JTextField();
				jtf2 = new JTextField();
			JPanel jp2 = new JPanel();
				JButton button = new JButton("Multiply");
				txt = new JTextArea();
			
			txt.setText("HI-- Feel free to multiply numbers with upto 20000 digits each!!!!!!");
			txt.setEditable(false);
			txt.setLineWrap(true);
			jtf1.setText("0");
			jtf2.setText("0");
			jp2.setLayout(new BorderLayout());
			jp1.setLayout(new GridLayout(4,1));
			button.addActionListener(this);
			jp1.setBorder(BorderFactory.createLineBorder(Color.black));
			jp2.setBorder(BorderFactory.createLineBorder(Color.black));


			jp1.add(jl1);
			jp1.add(jtf1);
			jp1.add(jl2);			
			jp1.add(jtf2);
			scrollpane = new JScrollPane(txt);
			jp2.add(scrollpane, BorderLayout.CENTER);
			jp2.add(button, BorderLayout.SOUTH);
			frame.getContentPane().add(jp1, BorderLayout.NORTH);
			frame.getContentPane().add(jp2, BorderLayout.CENTER);

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(800,500);
			frame.setVisible(true);
	}
//**************************************************************************************************************		

	public void actionPerformed(ActionEvent ae)
	{
			txt.setText(this.getProduct(jtf1.getText(),jtf2.getText()));
	}

//***************************************************************************************************************

	public static void main(String...s)
	{
		Danish1 d = new Danish1();
		d.create();

	}

}