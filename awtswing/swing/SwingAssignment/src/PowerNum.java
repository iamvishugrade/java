import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.javax.swing.IntegerField;

public class PowerNum {
	public static void main (String[] args) {
		new PowerNumFrame();
    }
}

class PowerNumFrame extends JFrame implements ActionListener{
	private IntegerField intFieldX;
	private IntegerField intFieldY;
	private JTextField powerNumField; // = X^Y
	private JButton converButton;
	
	public PowerNumFrame() {
		super("Calculate Power ");
		intFieldX = new IntegerField();
		intFieldY = new IntegerField();
		powerNumField = new JTextField(50);
		powerNumField.setEditable(false);
		converButton = new JButton("Convert Power Now!");
		converButton.addActionListener(this);
		
		JLabel inputLabelX = new JLabel("Enter a Number (X)");
		JLabel inputLabelY = new JLabel("Enter a Number (Y)");
		JLabel outputLabel = new JLabel("Power of Number is (X^Y) ");
		
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
		outputPanel.add(powerNumField);
		
		JPanel northPanel = new JPanel(new GridLayout(2, 1));
		northPanel.setBorder(BorderFactory.createTitledBorder(
			"Finds X^Y "));
		northPanel.add(inputPanelX);
		northPanel.add(inputPanelY);
		
		JPanel southPanel = new JPanel();
		southPanel.add(converButton);
		
		add(northPanel, BorderLayout.NORTH);
		add(outputPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		int no = Integer.parseInt(intFieldX.getText());
		int y = Integer.parseInt(intFieldY.getText());
		powerNumField.setText(String.valueOf(getPowerNum(no, y)));
		
	}
	
	// calculate x^y
	protected double getPowerNum(final int x, int y) {
		double res = 1;
		if(y > 0) {
			while(y-- > 0)
				res *= x;
		}
		else {
			JOptionPane.showMessageDialog(this, "Number is negative",
				"ERROR", JOptionPane.ERROR_MESSAGE);
			return 0;
		}
		return res;
	}
}