import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ToolTipComboBoxExample extends JFrame {

  String[] items    = {"jw"       ,"ja"       ,"la"    };
  String[] tooltips = {"Javanese ","Japanese ","Latin "};
  
  public ToolTipComboBoxExample() {
    super("ToolTip ComboBox Example");  
                      
    JComboBox combo = new JComboBox(items);
  
    getContentPane().setLayout(new FlowLayout());
    getContentPane().add(combo);
  }
      
  

  public static void main (String args[]) {
    ToolTipComboBoxExample frame = new ToolTipComboBoxExample();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    frame.setSize(200, 140);
    frame.setVisible(true);
  }
}



