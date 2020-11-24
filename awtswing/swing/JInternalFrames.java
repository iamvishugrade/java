import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
  
public class JInternalFrames extends JFrame {
  public static void main(String[] args) {
    new JInternalFrames();
  }

  public JInternalFrames() {
    super("Multiple Document Interface");
    WindowUtilities.setNativeLookAndFeel();
    addWindowListener(new ExitListener());
    Container content = getContentPane();
    content.setBackground(Color.white);
    JDesktopPane desktop = new JDesktopPane();
    desktop.setBackground(Color.GREEN);
    content.add(desktop, BorderLayout.CENTER);
    setSize(450, 400);
Color r[]={Color.red,Color.pink,Color.yellow,Color.blue,Color.black};
    for(int i=0; i<5; i++) {
      JInternalFrame frame
        = new JInternalFrame(("Internal Frame " + i),
                             true,true,false,false);
      frame.setLocation(i*50+10, i*50+10);
      frame.setSize(200, 150);
      frame.setBackground(r[i]);
	frame.setVisible(true);
      desktop.add(frame);
//frame.moveToFront();
frame.moveToBack();
  }
    setVisible(true);
  }
}
