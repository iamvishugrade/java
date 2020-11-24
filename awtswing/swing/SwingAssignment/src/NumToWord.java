import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.javax.swing.IntegerField;

public class NumToWord {
	public static void main (String[] args) {
		new NumToWordFrame();
    }
}

class NumToWordFrame extends JFrame implements ActionListener{
	private IntegerField intField;
	private JTextField strNumField;
	private JButton convertButton;
	
	public NumToWordFrame() {
		super("Convert Number to Word");
		intField = new IntegerField();
		strNumField = new JTextField(50);
		strNumField.setEditable(false);
		convertButton = new JButton("Parse Now");
		convertButton.addActionListener(this);
		
		JLabel inputLabel = new JLabel("Enter number in digits ");
		JLabel outputLabel = new JLabel("Number in Words ");
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.add(inputLabel);
		inputPanel.add(intField);
		
		JPanel outputPanel = new JPanel();
		outputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		outputPanel.add(outputLabel);
		outputPanel.add(strNumField);
		
		JPanel northPanel = new JPanel(new GridLayout(2, 1));
		northPanel.setBorder(BorderFactory.createTitledBorder(
			"Converts a Number into Words "));
		northPanel.add(inputPanel);
		northPanel.add(outputPanel);
		JPanel southPanel = new JPanel();
		southPanel.add(convertButton);
		
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		int no = Integer.parseInt(intField.getText());
		strNumField.setText(numberToWord(no));
	}
	
	private String numberToWord(int no) {
		String unitName[] = {
			"", "One", "Two", "Three", "Four",
			"Five", "Six", "Seven", "Eight", "Nine"
		};
		String tensName[] = {
			"Twenty", "Thirty", "Forty",
			"Fifty", "Sixty", "Seventy", "Eighty", "Ninty"
		};
		String teenName[] = {
			"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
			"Fifteen", "Sixteen", "Seventeen", "Eighteen", "Ninteen"
		};
		StringBuffer word = new StringBuffer("");
		int length, quotient, i;
		long divide;
	
		if(no < 0) {
			no = -no;
			word.append("Minus ");
		} else if(no == 0) {
			word.append("Zero");
			return word.toString();
		}
		for(i=1; no/(long)Math.pow(10, i) != 0; i++)
			;
		for(length=i; length > 0 && no > 0;length--) {
			divide = (long)Math.pow(10, length-1);
			quotient = (int)(no / divide);
			no %= divide;
			if(quotient == 0)
				continue;
			switch(length) {
			case 1:
				word.append(unitName[quotient]);
				break;
			case 2:
				// for ten, eleven etc.
				if(quotient == 1) {
					word.append(teenName[no%10]);
					no /= 10;
				} else {
					word.append(tensName[quotient-2]);
					word.append(" ");
				}
				break;
			case 3:
				word.append(unitName[quotient]);
				word.append(" Hundred ");
				break;
			case 4:
				word.append(unitName[quotient]);
				word.append(" Thousand ");
				break;
			case 5:
			case 6:
				int dummy = (int)(quotient*Math.pow(10, length-1)+no);
				word.append(numberToWord(dummy/1000));
				word.append(" Thousand ");
				no %= 1000;
	//			length = 4;
				break;
			case 7:
				word.append(unitName[quotient]);
				word.append(" Million ");
				break;
			}
		}
		return word.toString();
	}
}