import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.javax.swing.IntegerField;

public class BigNumMultiply {
	public static void main (String... args) {
		new BigNumMultiplyFrame();
    }
}

class BigNumMultiplyFrame extends JFrame implements ActionListener{
	private BigNumField intFieldX;
	private BigNumField intFieldY;
	private BigNumField bigNumMultiplyField; // = X^Y
	private JButton multiplyButton;
	
	public BigNumMultiplyFrame() {
		super("Calculate Multiplication");
		intFieldX = new BigNumField("111");
		intFieldY = new BigNumField("2");
		bigNumMultiplyField = new BigNumField();
		bigNumMultiplyField.setEditable(false);
		multiplyButton = new JButton("Multiply Now!");
		multiplyButton.addActionListener(this);
		
		JLabel inputLabelX = new JLabel("Enter a Number (X)");
		JLabel inputLabelY = new JLabel("Enter a Number (Y)");
		JLabel outputLabel = new JLabel("Multiplication of Number is (X*Y) ");
		
		JPanel inputPanelX = new JPanel();
		inputPanelX.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanelX.add(inputLabelX);
		inputPanelX.add(intFieldX);
		JPanel inputPanelY = new JPanel();
		inputPanelY.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanelY.add(inputLabelY);
		inputPanelY.add(intFieldY);
		
		JPanel outputPanel = new JPanel();
		outputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		outputPanel.add(outputLabel);
		outputPanel.add(bigNumMultiplyField);
		
		JPanel northPanel = new JPanel(new GridLayout(2, 1));
		northPanel.setBorder(BorderFactory.createTitledBorder(
			"Finds X*Y "));
		northPanel.add(inputPanelX);
		northPanel.add(inputPanelY);
		
		JPanel southPanel = new JPanel();
		southPanel.add(multiplyButton);
		
		add(northPanel, BorderLayout.NORTH);
		add(outputPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		bigNumMultiplyField.setText(intFieldX.multiply(intFieldY).getText());
	}
}