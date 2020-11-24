import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.tree.*;
import java.io.*;
import javax.swing.JOptionPane;

class MiniExplorer extends JFrame implements ActionListener
{
 public static void main(String...s) { new MiniExplorer(); }            
	
 JLabel l1;
 JTextField t;
 JButton b;
 JPanel p1,p2;
 JTree jt;
 JScrollPane jp,jp1;
 DefaultMutableTreeNode root;
 JTable jtable;
 String[] headings={"S.No.","Name","Size","Readable","Writable","Hidden"};
 String[][] items={};
 File f,tf;
 String tree_root="",drive_path="";
 
 MiniExplorer()
 {
  super("MiniExplorer  ( Ashish , Avadh , Lokendra )");
  this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  this.setLayout(null);
  this.setResizable(false);
  
  l1=new JLabel("ENTER THE DRIVE/DIRECTORY PATH");
  l1.setBounds(80,20,240,30);
  t=new JTextField();
  t.setBounds(310,20,300,30);
  b=new JButton("OK");
  b.setBounds(620,18,60,35);
  b.addActionListener(this);
  p1=new JPanel();
  p1.setLayout(null);
  p1.setBackground(Color.LIGHT_GRAY);
  p1.setBounds(5,70,200,480);
  p2=new JPanel();
  p2.setLayout(null);
  p2.setBackground(Color.LIGHT_GRAY);
  p2.setBounds(250,70,500,480);
  
  
  jtable=new JTable(items,headings);
  jp1=new JScrollPane(jtable);
  jp1.setBounds(5,5,490,470);
  p2.add(jp1);
   
   
  jt=new JTree(root);
  jp=new JScrollPane(jt);
  jp.setBounds(5,5,190,470);
  p1.add(jp);
  
  add(l1);add(t);add(b);add(p1);add(p2);
  this.setBounds(200,50,800,600);
  this.setVisible(true);	
 
 }
 
 public void addChildNode(File f,DefaultMutableTreeNode d)
 {
  String list[]=f.list();
  File fileList[]=new File[list.length];
  DefaultMutableTreeNode dm[]=new DefaultMutableTreeNode[list.length];
  for(int i=0;i<list.length;i++)
  {   	  
   fileList[i]=new File(f.getAbsolutePath()+"/"+list[i]);
   
   
   dm[i]=new DefaultMutableTreeNode(fileList[i].getName());
   //System.out.println(dm[i].getDepth());
   d.add(dm[i]);
      
   if(fileList[i].list()!=null)
   addChildNode(fileList[i],dm[i]);
   
  }
 }
 
 public void makeTable(String[][] items)
 {
  p2.remove(jp1);
  jtable=new JTable(items,headings);
  jtable.addMouseListener(new My1(this));
  jp1=new JScrollPane(jtable);
  jp1.setBounds(5,5,490,470);
  p2.add(jp1);
  this.setVisible(true);
 }
 
 public void makeTree(File f)
 {
   if(f.exists())
   {   	 
    p1.remove(jp);
    String rootName="";
   	this.drive_path=t.getText();
   	if(f.getName().equals(""))
   	{
   		
   		if(t.getText().length()==2)
   		rootName=t.getText();
   		else
   		rootName=t.getText().substring(0,3);
   	}
   	else
   	{
      rootName=f.getName();
   	}
   	
   	this.tree_root=rootName;
   	//System.out.println(rootName);
   	root=new DefaultMutableTreeNode(rootName);
   	if(f.list()!=null)
   	this.addChildNode(f,root);
    	
    jt=new JTree(root);
    jt.addMouseListener(new MyMouseAdapter(this));
    jp=new JScrollPane(jt);
    jp.setBounds(5,5,190,470);
    p1.add(jp);
    this.setVisible(true);
   }
   else 
   {
   	JOptionPane.showMessageDialog(new JFrame(),"FILE OR FOLDER DOES NOT EXIST.","DONE",JOptionPane.INFORMATION_MESSAGE);
   	t.setText("");
   }
 }
 
 
 public void actionPerformed(ActionEvent ae)
 {
  if(ae.getActionCommand().equals("OK"))
  {
   f=new File(t.getText());
   
   makeTree(f);
   
   p2.remove(jp1);
   jtable=new JTable(items,headings);
   jp1=new JScrollPane(jtable);
   jp1.setBounds(5,5,490,470);
   p2.add(jp1);
  }
 }
}


class MyMouseAdapter extends MouseAdapter
{
 MiniExplorer me;
 MyMouseAdapter(MiniExplorer me)
 {this.me=me;}
 
 String Path;
 public void mouseClicked(MouseEvent event)
 {
 try
 {
 	
  if(event != null)
  {
   Point p = event.getPoint();
   int selRow = me.jt.getRowForLocation(p.x, p.y);
   TreeCellRenderer       r = me.jt.getCellRenderer();
   if(selRow != -1 && r != null) 
   {
    TreePath path = me.jt.getPathForRow(selRow);
    
    String rp="";
    for(int i=0;i<path.getPathCount();i++)
    {
    	if(i==0)
    	{
    		if(path.getPathComponent(i).toString().length()==3&&path.getPathComponent(i).toString().charAt(2)=='\\')
    		{
    	     rp+=path.getPathComponent(i);
    		}
    		
    	}
    	else
    	rp+=path.getPathComponent(i)+"\\";
    }
    if(rp.length()!=0)
    rp=rp.substring(0,rp.length()-1);
    
    if(!path.getPathComponent(0).toString().equals(me.drive_path))
    {
     rp=me.drive_path+"\\"+rp;
    }
    
    if(path.getPathComponent(0).toString().equals(me.drive_path)&&path.getPathCount()==1)
    {
    	rp+="\\";
    }
    
    if((!path.getPathComponent(0).toString().equals(me.drive_path))&&path.getPathCount()==1)
    {
    	if(rp.length()!=0)
    	{
    	 rp=rp.substring(0,rp.length()-1);	
    	}
    }
    //System.out.println("real path is :-"+rp);
        
    File ff=new File(rp);
    me.tf=ff; 
    if(ff.isDirectory())
    {
     String ch[]=ff.list();
     String itmes[][]=new String[ch.length][6];
   
     if(ch!=null)
     {
      for(int i=0;i<itmes.length;i++)
      {
       for(int j=0;j<5;j++)
       {
       	File fc=new File(ff.getAbsolutePath()+"/"+ch[i]);
       	itmes[i][0]=String.valueOf(i+1);
       	itmes[i][1]=fc.getName();itmes[i][2]=fc.length()+"";itmes[i][3]=fc.canRead()+"";itmes[i][4]=fc.canWrite()+"";itmes[i][5]=fc.isHidden()+"";
       }
      }      
     }
     me.makeTable(itmes);
    }
    
    else if(ff.isFile())
    {
     String itmes[][]=new String[1][6];
     File fc=new File(ff.getAbsolutePath());
     itmes[0][0]="1";
     itmes[0][1]=fc.getName();itmes[0][2]=fc.length()+"";itmes[0][3]=fc.canRead()+"";itmes[0][4]=fc.canWrite()+"";itmes[0][5]=fc.isHidden()+"";
     me.makeTable(itmes);
    }
   }
  }
 }
 catch(Exception e)
 {
   JOptionPane.showMessageDialog(new JFrame(),"THIS IS A SYSTEM INFORMATION, YOU CAN NOT OPEN IT.","DONE",JOptionPane.INFORMATION_MESSAGE);
 }
 }
}

class My1 extends MouseAdapter
{
	MiniExplorer mie;
	String data="";
	File f;
	public My1(MiniExplorer mie)
	{this.mie=mie;}
	
	public void mouseClicked(MouseEvent me)
	{
		data=(String)mie.jtable.getValueAt(mie.jtable.getSelectedRow(),mie.jtable.getSelectedColumn());
		f=mie.tf;
		//System.out.println("path "+mie.tf.getAbsolutePath());
		if(f.isDirectory())
		{
			//System.out.println("path from folder"+mie.tf.getAbsolutePath()+"\\"+data);
			if(new File(mie.tf.getAbsolutePath()+"\\"+data).isFile())
			 GoodWindowsExec.exe(mie.tf.getAbsolutePath()+"\\"+data);
		}
		if(f.isFile())
		{
			if(new File(mie.tf.getAbsolutePath()+"").isFile())
			  GoodWindowsExec.exe(mie.tf.getAbsolutePath());
			//System.out.println("path from file"+mie.tf.getAbsolutePath());			
		}
	}
}