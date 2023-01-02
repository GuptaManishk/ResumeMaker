import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;


public class profile implements ActionListener
{
JFrame frame;
JPanel main,panel1,panel2;
BorderLayout border;
JTextField tf1;
JTextField tf2;
JTextField tf3;
GridBagLayout grid;
GridBagConstraints gcons;
JButton bt1,bt2;
int status=0;
	Connection con,cn;
	Statement st;
	ResultSet rs;
	PreparedStatement stp;
	PreparedStatement stat;
public profile()
{
	frame=new JFrame("User Profile");
	
	main=new JPanel();
	panel1=new JPanel();
	panel2=new JPanel();
	
	border=new BorderLayout();
	grid=new GridBagLayout();
	gcons=new GridBagConstraints();
	Border lineb = BorderFactory.createLineBorder(new Color(172,214,254));
	main.setLayout(border);
	main.setBorder(new TitledBorder (new MatteBorder(new ImageIcon("images//blue.jpg")))); 
	Icon ic=new ImageIcon("images//profile.jpg");
	main.add(panel1,BorderLayout.CENTER);
	main.add(panel2,BorderLayout.EAST);
	panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
	panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
	panel1.add(new JLabel("           To Start a new Personal Profile",JLabel.CENTER));
	panel1.add(new JLabel("             1. Please Type Your Name",JLabel.CENTER));
	panel1.add(new JLabel("First"));
	
	
	tf1=new JTextField(20);
	tf2=new JTextField(5);
	tf3=new JTextField(20);
	
	panel1.add(tf1);
	panel1.add(new JLabel("Initials"));
	panel1.add(tf2);
	panel1.add(new JLabel("Last"));
	panel1.add(tf3);
	panel2.add(new JLabel(ic));
	
	bt1=new JButton(new ImageIcon("images//profileok.jpg"));
 	bt2=new JButton(new ImageIcon("images//profcancle.jpg"));
 
	bt1.addActionListener(this);
	bt2.addActionListener(this);
	
	bt1.setBorder(lineb);
	bt2.setBorder(lineb);
	
	panel2.add(bt1);
	panel2.add(bt2);
	
	panel1.setBackground(new Color(172,214,254));
	panel2.setBackground(new Color(172,214,254));
	main.setBackground(Color.white);
	
	frame.getContentPane().add(main);
	frame.setSize(401,195);
	frame.setVisible(true);
	frame.setLocation(200,200);
	frame.setResizable(false);
}

public void verify()
{
	String str1=tf2.getText();
	
	String str2=tf1.getText();
	String str3=tf3.getText();
	
	String veri=tf2.getText()+tf1.getText()+tf3.getText();
	if(veri.length()==0)
	{
		JOptionPane.showMessageDialog(null,"Please Enter First Name, Last Name & Initials To Load Your Profile","Profile Error",JOptionPane.INFORMATION_MESSAGE);
		status =1;
		return;
	}
	else if(veri.length() >5)
	{
	 status=0;
	 return;
 }
}
public void insertData()
{
	
	try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection cn;
			cn=DriverManager.getConnection("jdbc:odbc:resume","sa","");
			stat=cn.prepareStatement("insert into userprofile(fname,initials,lastname)Values(?,?,?)");
			stat.setString(1,tf1.getText());
			stat.setString(2,tf2.getText());
			stat.setString(3,tf3.getText());
			stat.executeUpdate();
			
			String s1=tf2.getText()+" "+tf1.getText()+" " +tf3.getText();
			
			
			JOptionPane.showMessageDialog(null,"Dear User "+s1+"  Your Profile Loaded","Profile Loaded",JOptionPane.INFORMATION_MESSAGE);
			}
			
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null," Error Occured while data submitted in database \n1.) Check Your DNS is working properly.\n2.)DNS Name Should be resume "+e,"Database Connection",JOptionPane.WARNING_MESSAGE);
		}
	}
	
	
public void actionPerformed(ActionEvent e)
	{
		Object ob= e.getSource();
				
		if(ob==bt2){frame.setVisible(false);}
		if(ob==bt1)
		{
			if(status==0)
			verify();
			
	
		else if(status==1)
		{
			
			insertData();
			frame.setVisible(false);
			new mainMenu();
			}
			
	}}

public static void main(String a[])
{
	new profile();
}
}