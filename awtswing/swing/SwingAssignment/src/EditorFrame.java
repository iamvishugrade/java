import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class EditorFrame extends JFrame implements ActionListener{

	private JMenuItem saveAsItem, exitItem;
	private JMenuItem newItem, openItem, saveItem;
	private JTextArea page;
	private boolean saveStatus;
		
	public EditorFrame()	{
		setTitle("EditorFrame");
		setSize(500, 400);
		addWindowListener(new WindowAdapter()	{
			public void windowClosing(WindowEvent we)	{
				System.exit(0);			
			}
		});
		page = new JTextArea();
		add(page, BorderLayout.CENTER);
		
		Action newAction	= new FileAction("New", "Creates New File",
			KeyStroke.getKeyStroke('N', InputEvent.CTRL_MASK));
		Action openAction	= new FileAction("Open", "Open existing File",
			KeyStroke.getKeyStroke('O',InputEvent.CTRL_MASK));
		Action saveAction	= new FileAction("Save", "Save file to Disk",
			KeyStroke.getKeyStroke('S', InputEvent.CTRL_MASK));
		
		JMenuBar mbar = new JMenuBar();
		setJMenuBar(mbar);
		/**
	     * -------- FILE MENU ------------
	     */
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		
		newItem	= new JMenuItem(newAction);
		openItem= new JMenuItem(openAction);
		saveItem= new JMenuItem(saveAction);
		saveAsItem = new JMenuItem("Save As");
		saveAsItem.setDisplayedMnemonicIndex(5);
		exitItem = new JMenuItem("Exit", 'X');
		exitItem.setAccelerator(KeyStroke.getKeyStroke(
			KeyEvent.VK_F4, InputEvent.ALT_MASK));
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		mbar.add(makeMenu(fileMenu, 
			new Object[] {
				newItem,
				openItem,
				null,
				saveItem,
				saveAsItem,
				null
			},
			new boolean[] {
				false, false, // false for not adding listener
				true,	// true also for seperator
				false, true,
				true	// true for adding listener
			},
			this));
		fileMenu.add(exitItem);
	}
	
	public static JMenu makeMenu(Object parent, 
			Object[] items, boolean[] flags, Object target)	{
		JMenu m = null;
		if(parent instanceof JMenu)
			m = (JMenu)parent;
		else if(parent instanceof String)
			m = new JMenu((String)parent);
		else
			return null;
			
		for (int i=0; i<items.length; i++) {
			if(items[i] == null)
				m.addSeparator();
			else
				m.add(makeMenuItem(items[i], flags[i], target));
	    }
	    return m;
	}
	
	public static JMenuItem makeMenuItem(Object item, boolean flag,
	Object target)	{
		JMenuItem r = null;
		if(flag == false) {	// no need to add listener
			if(item instanceof JMenuItem)
				r = (JMenuItem)item;
			return r;
		}
		
		if(item instanceof String)
			r = new JMenuItem((String)item);
		else if(item instanceof JMenuItem)
			r = (JMenuItem)item;
		else
			return null;
		if(target instanceof ActionListener)
			r.addActionListener((ActionListener) target);
		return r;
	}
	
	void createNewFile() {
		page.setText("");
	}
	boolean saveAsFile() {
		JFileChooser chooser = new JFileChooser();

		int r = chooser.showSaveDialog(EditorFrame.this);
		if (r != chooser.APPROVE_OPTION)
			return false;
		File f = chooser.getSelectedFile();
		page.setText("FileName "+ f.getName()+"\nDirectory: "+f.getParent());
		return true;
	}
	/**
     *  -------- ACTIONS FOR TOOLBAR -------------
     */
	class FileAction extends AbstractAction {
		public FileAction(String name, String toolTip, KeyStroke strokeKey)	{
			super(name);
			String iconFileName = name+".gif";
			if(new File(iconFileName).exists()) {
				putValue(SMALL_ICON, new ImageIcon(iconFileName));
			}
			putValue(Action.SHORT_DESCRIPTION, toolTip);
			putValue(Action.ACCELERATOR_KEY, strokeKey);
		}

		public void actionPerformed(ActionEvent event)	{
			Object source = event.getSource();
			if(source == newItem)	{
				createNewFile();
			}
			else if(source == openItem)	{
				createNewFile();
				JFileChooser chooser = new JFileChooser();

				int r = chooser.showOpenDialog(EditorFrame.this);
				if (r != chooser.APPROVE_OPTION)
					return;
				File f = chooser.getSelectedFile();
				page.setText("FileName "+ f.getName()+"\nDirectory: "+f.getParent());
			}
			else if(source == saveItem)	{
				if(!saveStatus) {
					saveStatus = saveAsFile();
				}
			}
		}
	}
	
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if(source == saveAsItem)	{
			saveStatus = saveAsFile();
		}
	}
	
	public static void main (String... args) {
		new EditorFrame().setVisible(true);
    }
}
