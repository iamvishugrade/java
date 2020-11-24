import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.javax.swing.IntegerField;

public class PalindromeNum {
	public static void main (String[] args) {
		new PalindromeNumFrame();
    }
}

class PalindromeNumFrame extends JFrame implements ActionListener{
	private IntegerField intField;
	private JTextField palindromNumField;
	private JButton findButton;
	
	public PalindromeNumFrame() {
		super("Palindrome Number");
		intField = new IntegerField();
		palindromNumField = new JTextField(50);
		palindromNumField.setEditable(false);
		findButton = new JButton("Check Palindrome Now!");
		findButton.addActionListener(this);
		
		JLabel inputLabel = new JLabel("Enter a Number ");
		JLabel outputLabel = new JLabel("Is the Number is Palindrome");
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.add(inputLabel);
		inputPanel.add(intField);
		
		JPanel outputPanel = new JPanel();
		outputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		outputPanel.add(outputLabel);
		outputPanel.add(palindromNumField);
		
		JPanel northPanel = new JPanel(new GridLayout(2, 1));
		northPanel.setBorder(BorderFactory.createTitledBorder(
			"Finds Wether a Number is Palindrome or Not"));
		northPanel.add(inputPanel);
		northPanel.add(outputPanel);
		JPanel southPanel = new JPanel();
		southPanel.add(findButton);
		
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		int no = Integer.parseInt(intField.getText());
		if(isPalindrome(no))
			palindromNumField.setText("true");
		else
			palindromNumField.setText("false");
		
	}
	
	protected boolean isPalindrome(final int no) {
		int rev, dummy;

		for(rev = 0, dummy = no; dummy > 0; dummy /= 10) {
			rev = rev *10 + dummy%10;
		}
		return (no == rev);
	}
}