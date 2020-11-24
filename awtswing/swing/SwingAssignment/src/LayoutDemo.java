import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LayoutDemo {
	public static void main (String... args) {
		new LayoutDemoFrame().setVisible(true);
    }
}
class LayoutDemoFrame extends JFrame implements ActionListener{

	private JMenu layoutMenu, cardMenu;
	private JMenuItem borderItem, flowItem, gridItem, cardItem;
	private JMenuItem firstItem, nextItem, prevItem, lastItem;
	private JPanel panel;
	private JButton buttonArr[];
	private String borderConstraint[] = {
		"North", "South", "East", "West", "Center"
	};
	private CardLayout cardLayout;
	public LayoutDemoFrame()	{
		setTitle("Layout Demo Frame");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cardLayout = new CardLayout();
		panel = new JPanel(new BorderLayout());
		add(panel, BorderLayout.CENTER);
		buttonArr = new JButton[5];
		for(int i=0 ; i < 5; i++) {
			buttonArr[i] = new JButton("Button "+(i+1));
			panel.add(buttonArr[i], borderConstraint[i]);
		}
		JMenuBar mbar = new JMenuBar();
		setJMenuBar(mbar);
		layoutMenu = new JMenu("Layout");
		layoutMenu.setMnemonic('L');
		
		borderItem	= new JMenuItem("Border", 'B');
		flowItem	= new JMenuItem("Flow", 'F');
		gridItem	= new JMenuItem("Grid", 'G');
		cardItem	= new JMenuItem("Card", 'a');
		layoutMenu.add(borderItem);
		layoutMenu.add(flowItem);
		layoutMenu.add(gridItem);
		layoutMenu.add(cardItem);
		
		borderItem.addActionListener(this);
		flowItem.addActionListener(this);
		gridItem.addActionListener(this);
		cardItem.addActionListener(this);
		
		cardMenu = new JMenu("Card Layout");
		cardMenu.setMnemonic('C');
		firstItem	= new JMenuItem("First");
		nextItem	= new JMenuItem("Next");
		prevItem	= new JMenuItem("Previous");
		lastItem	= new JMenuItem("Last");
		cardMenu.add(firstItem);
		cardMenu.add(nextItem);
		cardMenu.add(prevItem);
		cardMenu.add(lastItem);
		
		firstItem.addActionListener(this);
		nextItem.addActionListener(this);
		prevItem.addActionListener(this);
		lastItem.addActionListener(this);
		
		cardMenu.setEnabled(false);
		mbar.add(layoutMenu);
		mbar.add(cardMenu);
		setJMenuBar(mbar);
	}
	
	public void actionPerformed(ActionEvent event) {
		JMenuItem source = (JMenuItem)event.getSource();
		//panel.setLayout(null);
		if(source == cardItem)	{
			cardMenu.setEnabled(true);
			panel.setLayout(cardLayout);
			for (int i = 0; i<buttonArr.length; i++)
				panel.add(buttonArr[i]);
		}
		else if(source == borderItem)	{
			cardMenu.setEnabled(false);
			panel.setLayout(new BorderLayout());
			for(int i=0 ; i < 5; i++) {
				panel.add(buttonArr[i], borderConstraint[i]);
			}
		}
		else if(source == flowItem)	{
			cardMenu.setEnabled(false);
			panel.setLayout(new FlowLayout());
		}
		else if(source == gridItem)	{
			cardMenu.setEnabled(false);
			panel.setLayout(new GridLayout(3,2));
		}
		else if(source == firstItem)	{
			cardLayout.first(panel);
		}
		else if(source == lastItem)	{
			cardLayout.last(panel);
		}
		else if(source == prevItem)	{
			cardLayout.previous(panel);
		}
		else if(source == nextItem)	{
			cardLayout.next(panel);
		}
		panel.validate();
	}
}
