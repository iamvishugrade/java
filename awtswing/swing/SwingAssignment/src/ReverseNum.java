import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.javax.swing.IntegerField;

public class ReverseNum {
	public static void main (String[] args) {
		new ReverseNumFrame();
    }
}

class ReverseNumFrame extends JFrame implements ActionListener{
	private IntegerField intField;
	private JTextField reverseNumField;
	private JButton converButton;
	
	public ReverseNumFrame() {
		super("Reverse Number");
		intField = new IntegerField();
		reverseNumField = new JTextField(50);
		reverseNumField.setEditable(false);
		converButton = new JButton("Convert Reverse Now!");
		converButton.addActionListener(this);
		
		JLabel inputLabel = new JLabel("Enter a Number ");
		JLabel outputLabel = new JLabel("Reverser of Number is ");
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.add(inputLabel);
		inputPanel.add(intField);
		
		JPanel outputPanel = new JPanel();
		outputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		outputPanel.add(outputLabel);
		outputPanel.add(reverseNumField);
		
		JPanel northPanel = new JPanel(new GridLayout(2, 1));
		northPanel.setBorder(BorderFactory.createTitledBorder(
			"Converts the Reverse Number "));
		northPanel.add(inputPanel);
		northPanel.add(outputPanel);
		JPanel southPanel = new JPanel();
		southPanel.add(converButton);
		
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		int no = Integer.parseInt(intField.getText());
		reverseNumField.setText(String.valueOf(getReverseNum(no)));
		
	}
	
	protected int getReverseNum(final int no) {
		int rev, dummy;

		for(rev = 0, dummy = no; dummy > 0; dummy /= 10) {
			rev = rev *10 + dummy%10;
		}
		return rev;
	}
}