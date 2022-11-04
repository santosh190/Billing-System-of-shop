import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Bill extends JFrame implements ActionListener
{
	public class Data{
		
		int code;
		String itm;
		int price;
		Data(int code,String itm,int price)
		{
			this.code=code;
			this.itm=itm;
			this.price=price;
		}
	}
  public static void main(String args[])
  {
     new Bill();
  }
  
  JLabel l1,l2,l3;
  JTextField t1,t2,t3;
  JButton b1,b2,b3;
  JTextArea ta;
  Data data[];
  double r=0;
  public Bill()
  {
  setSize(600,500);
  setLayout(null);
  
  
  l1=new JLabel("Item code");
  l1.setBounds(40,50,100,50);
  add(l1);
  
  t1=new JTextField();
  t1.setBounds(120,60,150,30);
  add(t1);
  
  l2=new JLabel("Item Quantity");
  l2.setBounds(40,120,100,50);
  add(l2);
  
  t2=new JTextField();
  t2.setBounds(120,130,150,30);
  add(t2);
  
  b1=new JButton("add");
  b1.setBounds(40,200,60,40);
  b1.addActionListener(this);
  add(b1);
  
  b2=new JButton("cal");
  b2.setBounds(140,200,60,40);
  b2.addActionListener(this);
  add(b2);
  
  ta=new JTextArea();
  ta.setBounds(310,50,250,300);
  ta.setText("Company name: A"+"\n"+"contact: 797999988"+"\n"+"==================="+"\n");
  add(ta);
  
  
  data=new Data[2];
  
  data[0]=new Data(0,"itm-1",10);
  data[1]=new Data(1,"item-2",20);
  
  setVisible(true);
  }
  public void actionPerformed(ActionEvent e)
  {
	  int code=-1,n=0;
	  double price=0;
	  String name="";
	  if(e.getSource() == b1)
	  {
		  
		  code=Integer.parseInt(t1.getText());
		  n=Integer.parseInt(t2.getText());
		  if(code == -1) 
		  {
			  JOptionPane.showMessageDialog(null,"fill item");
			  return;
		  }
		  boolean f=true;
		  for(int i=0;i<data.length;i++)
		  {
			  Data itm=data[i];
			  if(itm.code == code) 
			  {
				 price=itm.price;
				 name=itm.itm;
			  }
			  f=false;
		  }
		  
		  if(f) JOptionPane.showMessageDialog(null,"item is not valid");
		  t1.setText("");
		  t2.setText("");
		  double re=price*n;
		  ta.setText(ta.getText()+"\n"+name+"       "+re+"\n");
		  r+=re;
		  
		  System.out.println(r);
		  
	  }
	  if(e.getSource() == b2)
	  {
		  if(r==0) JOptionPane.showMessageDialog(null,"no bill");
		  
		  ta.setText(ta.getText()+"============================"+"\n"+"total"+"  "+r);
	  }
  }
}