import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Question	{
	public static void main(String... args) {
		final int SIZE = 10;
		
		System.out.println("Starting Question...");
		QueFrame mainFrame = new QueFrame(SIZE);		
		mainFrame.setTitle("Question Frame");		
		mainFrame.addQuestion("Java is",
			new String[]	{
				"OOP based language",
				//"Interesting",
				"Internet Language",
				"All of the above"
			}, 2);
		mainFrame.addQuestion("Which declarations of main() method are valid in order to start the execution of an application?",
			new String[]	{
				"public void main(String[] args)",
				"public void static main(String args[])",
				"public static int main(String[] args)",				
				"public static void main(String[] args)"
			}, 2);
		mainFrame.addQuestion("\nWhich of \nthe followong \nmethod names \nare not \noverloaded?",
			new String[]	{
				"yield in java.lang.Thread",
				"sleep in java.lang.Thread",
				"wait in java.lang.Object",
				"notify in java.lang.Object"
			}, 2);		
		mainFrame.addQuestion("Which is not valid identifiers?",
			new String[]	{
				"_class",
				"$value",
				"zer@",
				" nothing"
			}, 2);
		mainFrame.addQuestion("Which of the following expressions are not valid?\nSelect one correct answers.",
			new String[]	{
				"System.out.hashCode()",
				"\"\".hashCode()",
				"42.hashCode()",
				"\"4\"+2.equals(42)",
				"(new java.util.Vector()).hashCode()"		
			}, 2);
		mainFrame.addQuestion("Java is",
			new String[]	{
				"OOP based language",
				//"Interesting",
				"Internet Language",
				"All of the above"
			}, 2);
		mainFrame.addQuestion("Which declarations of main() method are valid in order to start the execution of an application?",
			new String[]	{
				"public void main(String[] args)",
				"public void static main(String args[])",
				"public static int main(String[] args)",				
				"public static void main(String[] args)"
			}, 2);
		mainFrame.addQuestion("\nWhich of \nthe followong \nmethod names \nare not \noverloaded?",
			new String[]	{
				"yield in java.lang.Thread",
				"sleep in java.lang.Thread",
				"wait in java.lang.Object",
				"notify in java.lang.Object"
			}, 2);		
		mainFrame.addQuestion("Which is not valid identifiers?",
			new String[]	{
				"_class",
				"$value",
				"zer@",
				" nothing"
			}, 2);
		mainFrame.addQuestion("Which of the following expressions are not valid?\nSelect one correct answers.",
			new String[]	{
				"System.out.hashCode()",
				"\"\".hashCode()",
				"42.hashCode()",
				"\"4\"+2.equals(42)",
				"(new java.util.Vector()).hashCode()"		
			}, 2);
		
		mainFrame.setVisible(true);
	}
}

class QueFrame extends JFrame implements ActionListener	{
	public final int MAX_QUE_NO;
	private static int total_que_counter = 0;// total no. of questions
	private String[] questions;		// stores the questions
	private String[] ansOptions[];	// stores the options of the questions
	private int[] correctOptions;		// holds the index of correct option
	private JButton prevButton;		// shows the previous page
	private JButton nextButton;		// shows the next page
	private JButton bookMarkButton;	// tags the book mark on the question
	private JPanel buttonPanel;		// panel for next, prev button
	private QuePanel quePage;		// panel for question display in a page
	//private int[] questions_no;		// stores the sequence of the questions
	private int current_Que;		// active question no.
	private int markedQueNo;		// last marked question no.
	private boolean isMarked;		// shows wether a question is marked 
	private JCheckBox markQueCheck;
	private int correctAns;
	
	public QueFrame(final int SIZE)	{		
		setSize(500, 300);
		//setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MAX_QUE_NO = SIZE;
		questions = new String[SIZE];
		ansOptions = new String[SIZE][];
		correctOptions = new int[SIZE];
		prevButton = new JButton("<<Prev");
		nextButton = new JButton("Next>>");
		bookMarkButton= new JButton("See Last Marked Question");
		prevButton.addActionListener(this);
		nextButton.addActionListener(this);
		bookMarkButton.addActionListener(this);
		buttonPanel = new JPanel();
		quePage = new QuePanel();
		markQueCheck = new JCheckBox("Mark This Question");
		markQueCheck.addActionListener(this);

		Box box = Box.createHorizontalBox();
		box.add(box.createHorizontalStrut(10));
		box.add(prevButton);
		box.add(box.createHorizontalGlue());
		box.add(nextButton);
		box.add(Box.createGlue());
		box.add(bookMarkButton);
		buttonPanel.add(box);

		add(quePage, BorderLayout.CENTER);
		add (markQueCheck, BorderLayout.EAST);
		add(buttonPanel, BorderLayout.SOUTH);
	}
	
	private void showQuestion(int queNO)	{
		// show the check status 
		if(isMarked && markedQueNo == queNO)
			markQueCheck.setSelected(true);
		else
			markQueCheck.setSelected(false);
			
		quePage.setQuestion(questions[queNO-1], ansOptions[queNO-1], queNO);
	}
	
	public void addQuestion(String que, String [] opt, int correctAns)	{	
		questions[total_que_counter] = que;
		ansOptions[total_que_counter] = new String [opt.length];
		for (int i=0; i<opt.length; i++) {
			ansOptions[total_que_counter][i] = opt[i];
		}
		correctOptions[total_que_counter] = correctAns;
		total_que_counter++;
		if(current_Que == 0) {
			// now the first question is added 
			// display it
			prevButton.setEnabled(false);
			current_Que = 1;
			showQuestion(current_Que);
		}
	}
	
	public void actionPerformed(ActionEvent ae)	{
		if(ae.getSource() == nextButton)	{
			if(prevButton.isEnabled() == false)
				prevButton.setEnabled(true);
			showQuestion(++current_Que);
	    }
	    else if(ae.getSource() == prevButton)	{
	    	if(nextButton.isEnabled() == false)
				nextButton.setEnabled(true);
			if(bookMarkButton.getText().equals("Finish"))
				bookMarkButton.setText("See Last Marked Question");
			showQuestion(--current_Que);
	    }
	    else if(ae.getSource() == markQueCheck) {
	    	if(markQueCheck.isSelected()) {
				markedQueNo = current_Que;
				isMarked = true;
	    	}
			else {
				markedQueNo = -1; // Deselects the selected
				isMarked = false;
			}
	    }
	    else if(ae.getActionCommand().equals("See Last Marked Question"))	{
	    	if(markedQueNo != -1)
				showQuestion(markedQueNo);
		}
	    else if(ae.getActionCommand().equals("Finish"))	{
	    	showResult();
	    }	    
	    if(current_Que == MAX_QUE_NO)	{
			bookMarkButton.setText("Finish");
			nextButton.setEnabled(false);
		}
		if(current_Que == 1)	{			
			prevButton.setEnabled(false);
		}
	}
	
	public void showResult() {
		JInternalFrame iframe = new JInternalFrame("Result", false, false, false, false);
		JLabel resultLabel = new JLabel("You score "+correctAns);
		remove(quePage);
		remove(markQueCheck);
		remove(buttonPanel);
		
		iframe.setSize(getContentPane().getWidth(), getContentPane().getHeight());
		iframe.add(resultLabel, BorderLayout.CENTER);
		add(iframe, BorderLayout.CENTER);
		iframe.setVisible(true);
		//JOptionPane.showMessageDialog(this, "You score "+correctAns);
	}

	class QuePanel extends JPanel implements ActionListener	{
		private JTextArea quePane;
		private JRadioButton[] option;
		private ButtonGroup group;
		private JLabel que_no_label;
		private JPanel optPane;
		private int queNo;
		
		public QuePanel(){
			quePane = new JTextArea();
			quePane.setLineWrap(false);
			quePane.setEditable(false);
			JScrollPane scrollPane = new JScrollPane(quePane);
			optPane = new JPanel();
			que_no_label = new JLabel();
	
			setLayout(new BorderLayout());
			add (que_no_label, BorderLayout.NORTH);
			add (scrollPane, BorderLayout.CENTER);
			add (optPane, BorderLayout.WEST);
		}
		public void setQuestion(String que, String[] opt, int queNo)	{
			this.queNo = queNo;
			quePane.setText(que);
			option = new JRadioButton[opt.length];
			que_no_label.setText("Qestion NO:- "+queNo);
			
			optPane.removeAll();
			optPane.setLayout(new GridLayout(opt.length, 1));
			group = new ButtonGroup();
			for (int i=0; i<opt.length; i++) {
				option[i] = addRadioButton(optPane, group, opt[i], false);
			}
		}	
			
		public JRadioButton addRadioButton(JPanel panel, ButtonGroup g, 
		String name, boolean v)	{
			JRadioButton button = new JRadioButton(name, v);
			button.addActionListener(this);
			button.setPreferredSize(new Dimension(250, 20));
			g.add(button);
			panel.add(button);
			return button;
		}
	
		public void actionPerformed(ActionEvent ae)	{
			System.out.println ("You Selected " + ae.getActionCommand());
			JRadioButton opt = (JRadioButton)ae.getSource();
			int index = 0;
			while(opt != option[index])
				index++;
			if(index == correctOptions[queNo-1])
				correctAns++;
		}
	}
}