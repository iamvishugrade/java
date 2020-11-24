import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwapImage {
	public static void main (String... args) {
		new SwapImageFrame().setVisible(true);
    }
}

class SwapImageFrame extends JFrame implements ActionListener{
	private ImageIcon img1;
	private ImageIcon img2;	
	private JLabel label1;
	private JLabel label2;
	private JButton swapButton;
	
	SwapImageFrame() {
		super("Swap Images");
		img1 = new ImageIcon("FolderPlus.png");
		img2 = new ImageIcon("FolderMinus.png");
		label1 = new JLabel(img1);
		label2 = new JLabel(img2);
		swapButton = new JButton("Swap Images Now");
		swapButton.addActionListener(this);
		
		JPanel gridPanel = new JPanel(new GridLayout(1, 2));
		gridPanel.add(label1);
		gridPanel.add(label2);
		
		add(gridPanel, BorderLayout.CENTER);
		add(swapButton, BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
	
	public void actionPerformed(ActionEvent event) {
		ImageIcon temp = img1;
		img1 = img2;
		img2 = temp;
		label1.setIcon(img1);
		label2.setIcon(img2);
	}
}