import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.javax.swing.IntegerField;

public class SqrtNum {
	public static void main (String[] args) {
		new SqrtNumFrame();
    }
}

class SqrtNumFrame extends JFrame implements ActionListener{
	private IntegerField intField;
	private JTextField sqrtNumField;
	private JButton findButton;
	
	public SqrtNumFrame() {
		super("Finds Square Root of Number");
		intField = new IntegerField();
		sqrtNumField = new JTextField(50);
		sqrtNumField.setEditable(false);
		findButton = new JButton("Find Square Root Now!");
		findButton.addActionListener(this);
		
		JLabel inputLabel = new JLabel("Enter a Number ");
		JLabel outputLabel = new JLabel("Square Root of Number ");
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.add(inputLabel);
		inputPanel.add(intField);
		
		JPanel outputPanel = new JPanel();
		outputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		outputPanel.add(outputLabel);
		outputPanel.add(sqrtNumField);
		
		JPanel northPanel = new JPanel(new GridLayout(2, 1));
		northPanel.setBorder(BorderFactory.createTitledBorder(
			"Finds Root of only Perfact Numbers"));
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
		long no = Long.parseLong(intField.getText());
		sqrtNumField.setText(getNumberRootStr(no));
	}
	
	protected String getNumberRootStr(final long no) {
		long root = (long)Math.sqrt(no);
		String rootStr;
		if(root * root == no)
			rootStr = String.valueOf(root);
		else {
			rootStr = "<ERROR: Not Perfact Number.>";
		}
		return rootStr;
	}
}