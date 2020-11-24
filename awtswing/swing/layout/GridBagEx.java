import java.awt.Container;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridBagEx {
  public static void main(String[] args) {
    String title = "GridBagLayout";
    JFrame frame = new JFrame(title);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contentPane = frame.getContentPane();
    contentPane.setLayout(new GridBagLayout());

    for (int i = 1; i <= 9; i++) {
      contentPane.add(new JButton("Button  " + i));
    }
    frame.pack();
    frame.setVisible(true);
  }
}
