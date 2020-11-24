import java.awt.*;
import javax.swing.*;

/** Tiny example showing the main differences in using 
 *  JApplet instead of Applet: using the content pane,
 *  getting Java (Metal) look and feel by default, and
 *  having BorderLayout be the default instead of FlowLayout.
 *  1998-99 Marty Hall, http://www.apl.jhu.edu/~hall/java/
 */

public class JAppletExample extends JApplet {
  public void init() {
    WindowUtilities.setNativeLookAndFeel();
    Container content = getContentPane();
    content.setBackground(Color.white);
    content.setLayout(new FlowLayout()); 
    content.add(new JButton("Button 1"));
    content.add(new JButton("Button 2"));
    content.add(new JButton("Button 3"));
  }
}
