/*Swing GridBagLayout->

   

The GridBagLayout lays out components in a grid of cells arranged in rows and columns similar to the GridLayout.

All cells of the grid created by GridBagLayout do not have to be of the same size.

A component does not have to be placed exactly in one cell.

A component can span multiple cells horizontally as well as vertically.

We can specify how a component inside its cell should be aligned.

The GridBagLayout and GridBagConstraints classes are used together. Both classes are in the java.awt package.

GridBagLayout class defines a GridBagLayout layout manager. GridBagConstraints class defines constraints for a component in a GridBagLayout.

The following code creates an object of the GridBagLayout class and sets it as the layout manager for a JPanel:

JPanel panel = new JPanel();

GridBagLayout  gridBagLayout = new GridBagLayout(); 
panel.setLayout(gridBagLayout);

GridBagConstraints->

Here is the normal procedure we used to create and use a GridBagConstraints.

First, create a constraint object

GridBagConstraints gbc  = new GridBagConstraints();

Then, set gridx and gridy properties in the constraint object

gbc.gridx = 0;
gbc.gridy = 0;

After that, add a JButton and pass the constraint object as the second argument to the add() method.

container.add(new JButton("B1"), gbc);

We can change the gridx property to 1. The gridy property remains as 0 as set previously.

gbc.gridx = 1;

Then, add another JButton to the container

container.add(new JButton("B2"), gbc);*/



import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridBagEx1 {
  public static void main(String[] args) {
    String title = "GridBagLayout";
    JFrame frame = new JFrame(title);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container contentPane = frame.getContentPane();
    contentPane.setLayout(new GridBagLayout());

    GridBagConstraints gbc = new GridBagConstraints();

    for (int y = 0; y < 3; y++) {
      for (int x = 0; x < 4; x++) {
        gbc.gridx = x;
        gbc.gridy = y;
        String text = "Button (" + x + ", " + y + ")";
        contentPane.add(new JButton(text), gbc);
      }
    }

    frame.pack();
    frame.setVisible(true);
  }
}
