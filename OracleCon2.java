import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;  

class OracleCon2 extends JFrame implements ActionListener 
{
    JLabel l1,l2;
	JTextField t1,t2;
	JButton b1,b2;
	
  public OracleCon2()
  {
        setSize(1000,1000);
		setVisible(true);
		setLayout(new GridLayout(4,2));
	    Font f=new Font("Arial",Font.BOLD,50);
        l1=new JLabel("Name");		t1=new JTextField();
		l2=new JLabel("Age");      t2=new JTextField();
		b1 = new JButton("Save");   b2 = new JButton("Display");
		b1.addActionListener(this); b2.addActionListener(this);
		
		l1.setFont(f);t1.setFont(f);
		l2.setFont(f);t2.setFont(f);
		b1.setFont(f);
		b2.setFont(f);
		
		add(l1);add(t1);
		add(l2);add(t2);
		add(b1);add(b2);
		pack();
  }
  
public void actionPerformed(ActionEvent ae)
{
	if (ae.getSource() == b1)
	{
			show1();
    }
	if(ae.getSource() == b2)
	{
		show2(); 
	}
}
void show1()
{
	Connection con;
	Statement stmt;
	ResultSet rs6;
	try{
	Class.forName("oracle.jdbc.driver.OracleDriver");  
  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","teja");  
	  stmt=con.createStatement();  
  
	  rs6=stmt.executeQuery("insert into Teja values('"+t1.getText()+"','"+Integer.parseInt(t2.getText())+"')");
	  t1.setText("");
	  t2.setText("");
	con.close();	
	}
	catch(ClassNotFoundException e){ System.out.println(e);}  
catch(SQLException e){ System.out.println(e);}  
}
void show2()
{
	Connection con1;
	Statement stmt1;
	ResultSet rs;
	try{
	Class.forName("oracle.jdbc.driver.OracleDriver");  
  con1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","teja");  
	  stmt1=con1.createStatement();  
  
	  rs=stmt1.executeQuery("select * from teja where name='"+t1.getText()+"'");  
		while(rs.next())  {
		  t2.setText(rs.getString(2));
		}con1.close();	
	}
	catch(ClassNotFoundException e){ System.out.println(e);}  
catch(SQLException e){ System.out.println(e);}  
}
public static void main(String args[])throws SQLException
{
 new OracleCon2();	
}	
}