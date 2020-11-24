import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.javax.swing.IntegerField;

public class PrimeNum {
	public static void main (String[] args) {
		new PrimeNumFrame();
    }
}

class PrimeNumFrame extends JFrame implements ActionListener{
	private IntegerField intField;
	private JTextField primeNumField;
	private JButton findButton;
	
	public PrimeNumFrame() {
		super("Prime Number");
		intField = new IntegerField();
		primeNumField = new JTextField(50);
		primeNumField.setEditable(false);
		findButton = new JButton("Check for Prime Now!");
		findButton.addActionListener(this);
		
		JLabel inputLabel = new JLabel("Enter a Number ");
		JLabel outputLabel = new JLabel("Is Number Prime ");
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.add(inputLabel);
		inputPanel.add(intField);
		
		JPanel outputPanel = new JPanel();
		outputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		outputPanel.add(outputLabel);
		outputPanel.add(primeNumField);
		
		JPanel northPanel = new JPanel(new GridLayout(2, 1));
		northPanel.setBorder(BorderFactory.createTitledBorder(
			"Finds Wether a Number is Prime or Not"));
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
		if(isPrime(no))
			primeNumField.setText("true");
		else
			primeNumField.setText("false");
		
	}
	
	protected boolean isPrime(final int no) {
		int count = 2;
		boolean isPrime = true;
		
		while(count*count <= no)
			if(no%count++ == 0) {
				isPrime = false;
				break;
			}

		return isPrime;
	}
}