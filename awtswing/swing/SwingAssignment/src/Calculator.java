import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculator {
	public static void main (String[] args) {
		new CalculatorFrame();
    }
}
final class CalculatorFrame extends JFrame{	
	private CalculatorPanel buttonPanel;
	private JTextField display ;	
		
	public CalculatorFrame()	{		
		setTitle("Calculator");
		setSize(200, 200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//setResizable(false);
		display = new JTextField("0");
		display.setEditable(false);
		display.setFont(new Font("Arial", Font.BOLD, 16));
		display.setBorder(BorderFactory.createLineBorder(Color.PINK));
		buttonPanel = new CalculatorPanel();
		
		add(display, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.CENTER);
		setVisible(true);
	}

	class CalculatorPanel extends JPanel implements ActionListener{
		private double arg = 0;
		private String op = "=";
		private boolean start = true;
	
		public CalculatorPanel()	{
			GridLayout layout = new GridLayout(4, 4);
			setLayout(layout);
			layout.setHgap(5);
			layout.setVgap(5);
			
			String buttons = "789/456*123-0.=+";
			for (int i=0; i<buttons.length(); i++) 
	    		addButton(buttons.charAt(i));
		}
		
		private void addButton(char c)	{
			String s;
			if(c >= '0' && c <= '9')
				s = "<html><Font face = 'Times New Roman' size = 5 color=#ff00ff>"+
					c + "</Font></html>";
			else
				s = "<html><Font face = 'Times New Roman' size = 6 color=#8080ff>"+
					c + "</Font></html>";
			JButton b = new JButton(s);
			add(b);
			b.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent ae)	{
			String s = ae.getActionCommand();
			if('0' <= s.charAt(0) && s.charAt(0) <= '9' 
					|| s.equals("."))	{
				if(start)
					display.setText(s);
				else 
					display.setText(display.getText() + s);
				start = false;
			}
			else	{
				if(start)	{
					if(s.equals("-"))	{
						display.setText(s);
						start = false;
					}
					else 
						op = s;
				}
				else	{
					double x = Double.parseDouble(display.getText());
					calculate(x);
					op = s;
					start = true;
				}
			}
		}
		
		public void calculate(double n)	{
			if(op.equals("+")) arg += n;
			else if(op.equals("-")) arg -= n;
			else if(op.equals("*")) arg *= n;
			else if(op.equals("/")) arg /= n;
			else if(op.equals("=")) arg = n;
			display.setText("" + arg);
		}
	}
}