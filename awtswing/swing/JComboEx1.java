import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ItemEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class JComboEx1 extends JFrame {
  public JComboEx1() {
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    String[] sList = new String[] { "Spring", "Summer", "Fall", "Winter" };
    JComboBox<String> seasons = new JComboBox<>(sList);

    seasons.addItemListener((ItemEvent e) -> {
      Object item = e.getItem();
      if (e.getStateChange() == ItemEvent.SELECTED) {
        // Item has been selected
        System.out.println(item + "  has  been  selected");
      } else if (e.getStateChange() == ItemEvent.DESELECTED) {
        // Item has been deselected
        System.out.println(item + "  has  been  deselected");
      }
    });

    Container contentPane = this.getContentPane();
    contentPane.add(seasons, BorderLayout.CENTER);
  }

  public static void main(String[] args) {
    JComboEx1 bf = new JComboEx1();
    bf.pack();
    bf.setVisible(true);
  }
}


