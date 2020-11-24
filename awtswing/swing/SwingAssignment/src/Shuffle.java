import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Shuffle {
	public static void main (String... args) {
		new ShuffleFrame().setVisible(true);
    }
}

class ShuffleFrame extends JFrame implements ActionListener {
	final public int TOTAL_NO = 8;
	private JButton buttonArr[];
	private final int gridSize;
	private JButton blankButton;
	private JPanel buttonPanel;
	
	public ShuffleFrame() {
		super("Shuffle Game");
		buttonArr = new JButton[TOTAL_NO+1];
		gridSize = (int)Math.sqrt(TOTAL_NO+1);
		
		GridLayout gridLayout = new GridLayout(gridSize, gridSize);
		gridLayout.setHgap(5);
		gridLayout.setVgap(5);
		buttonPanel = new JPanel(gridLayout);
		int[] randomNo = {
			1, 2, 3, 5, 6, 8, 4, 7, 0 // last value can be anything other than these
		};
		
		for (int i = 0; i <= TOTAL_NO; i++) {
			buttonArr[i] = new JButton(randomNo[i]+"");
			buttonArr[i].addActionListener(this);
			buttonArr[i].setName(i+""); // tag the index no
			buttonPanel.add(buttonArr[i]);
		}
		// set Blank Caption to last
		buttonArr[TOTAL_NO].setText("");
		blankButton = buttonArr[TOTAL_NO];
		
		add(buttonPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);
	}
	
	public void actionPerformed(ActionEvent event) {
		JButton source = (JButton)event.getSource();
		if(event.getActionCommand() == "")
			return;
		performShift(source);
		if(isInSequence())
			winGame();
	}
	
	protected void performShift(JButton source) {
		int no = Integer.parseInt(source.getName()); // it is index no
		int x = no / gridSize;
		int y = no % gridSize;
		
		System.out.println ("X: "+x+ " Y: "+y);
		
		// check left side for blank button
		if(y!= 0 && buttonArr[x*gridSize + y-1] == blankButton) {
			blankButton.setName(x*gridSize + y-1 + "");
			source.setName("");
			swap(source);
		}
		
		// check right side for blank button
		if(y!= gridSize-1 && buttonArr[x*gridSize + y+1] == blankButton) {
			blankButton.setName(x*gridSize + y+1 + "");
			source.setName("");
			swap(source);
		}
			
		// check top for blank button
		if(x!= 0 && buttonArr[(x-1)*gridSize + y] == blankButton){
			blankButton.setName((x-1)*gridSize + y + "");
			source.setName("");
			swap(source);
		}
			
		// check bottom for blank button
		if(x!= gridSize-1 && buttonArr[(x+1)*gridSize + y] == blankButton){
			blankButton.setName((x+1)*gridSize + y + "");
			source.setName("");
			swap(source);
		}
	}
	protected boolean isInSequence() {
		int i;
		
		for(i = 0; i < TOTAL_NO; i++) {
			if(buttonArr[i].getText().intern() != (i+1+"").intern())
				break;
		}
		
		if(i == TOTAL_NO)
			return true;
		return false;
	}
	
	protected void winGame() {
		System.out.println ("game won");
		
		JInternalFrame iframe = new JInternalFrame("Congrats!!!", false, false, false, false);
		JLabel resultLabel = new JLabel("<html><Font size=6 color=#00ffff>"+
			"!!Congratulation!!\nYou won the game.</Font></html>");
		ImageIcon winImage = new ImageIcon("WinGame.png");
		JLabel imgLabel = new JLabel(winImage);
		
		remove(buttonPanel);
		iframe.setSize(getContentPane().getWidth(), getContentPane().getHeight());
		iframe.add(resultLabel, BorderLayout.NORTH);
		iframe.add(imgLabel, BorderLayout.CENTER);
		add(iframe, BorderLayout.CENTER);
		iframe.setVisible(true);
	}
	
	private void swap(JButton button) {
		String temp = button.getText();
		button.setText(blankButton.getText());
		blankButton.setText(temp);
		// update blank button reference
		blankButton = button;
	}
}