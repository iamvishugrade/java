import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.javax.swing.*;

public class ArmstrongNum {
	public static void main (String[] args) {
		new ArmstrongNumFrame();
    }
}

class ArmstrongNumFrame extends JFrame implements ActionListener{
	 //IntegerField intField;
	 JTextField armstrongNumField;
	 JButton findButton;
	
	public ArmstrongNumFrame() {
		super("Armstrong Number");
		//intField = new IntegerField();
		armstrongNumField = new JTextField(50);
		armstrongNumField.setEditable(false);
		findButton = new JButton("Check Armstrong Number Now!");
		findButton.addActionListener(this);
		
		JLabel inputLabel = new JLabel("Enter a Number ");
		JLabel outputLabel = new JLabel("Wether the Number is Armstrong Number? ");
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.add(inputLabel);
		inputPanel.add(intField);
		
		JPanel outputPanel = new JPanel();
		outputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		outputPanel.add(outputLabel);
		outputPanel.add(armstrongNumField);
		
		JPanel northPanel = new JPanel(new GridLayout(2, 1));
		northPanel.setBorder(BorderFactory.createTitledBorder(
			"Finds Wether a Number is Armstrong or Not"));
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
		if(isArmstrongNum(no))
			armstrongNumField.setText("true");
		else
			armstrongNumField.setText("false");
		
	}
	
	protected boolean isArmstrongNum(final int no) {
		int rem, sum, count, dummy;

		for(sum = 0, dummy = no; dummy > 0; dummy /= 10) {
			rem = dummy % 10;
			sum = sum + rem*rem*rem;
		}
		return (no == sum);
	}
}