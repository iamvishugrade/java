import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
public class FileChooser extends JFrame implements ActionListener {
JFileChooser jfc;
   public  FileChooser () {
    super(" FileChooser ");  
 jfc =new JFileChooser("d:\\manish123" );
JButton jb=new JButton("ok");
jb.addActionListener(this);
    getContentPane().add(jb);
setLayout(new FlowLayout());
setSize(200,200);
setVisible(true);
  }
  public void actionPerformed(ActionEvent e)
{

int x=jfc.showOpenDialog(null);//showSaveDialog(null)
if(x==JFileChooser.APPROVE_OPTION)
{
File f=jfc.getSelectedFile();
System.out.println(f.getPath());
String s=jfc.getName(f);
System.out.println(s);
File f1=jfc.getCurrentDirectory();
System.out.println(jfc.getName(f1));

}
if(x==JFileChooser.CANCEL_OPTION)
{
System.out.println("cancel");
}

} 
  

  public static void main (String args[]) 
{
 new FileChooser();
      }
    }
    



