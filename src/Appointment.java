import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;
import java.io.*;

public class Appointment implements ActionListener
{
JWindow frame;
JPanel panel;
JLabel date,desc,Notes,time;
JComboBox check;
JTextArea textarea;
JTextField tdate,tdesc,ttime;
JButton ok,cncl;

GridBagLayout grid;
GridBagConstraints gcons;

public Appointment()
{
	frame = new JWindow();	
	grid= new GridBagLayout ();
	gcons= new GridBagConstraints();
	
	Color green= new Color(173,214,255);

	panel=new JPanel();
	panel.setBackground(green);
	panel.setBorder(new TitledBorder (new MatteBorder(new ImageIcon("images//blue.jpg")))); 
	
	JPanel sub= new JPanel();
	
	date=new JLabel("Date");
	desc=new JLabel("Description");
	Notes=new JLabel("Notes");
	time=new JLabel("Time");

	String ss []={"Due","Done"};
	check=new JComboBox(ss);
	textarea=new JTextArea(5,27);

	int	v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
	int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
	JScrollPane jsp=new JScrollPane(textarea,v,h);
	

	ok=new JButton("   OK   ");
	cncl=new JButton("Cancel ");
	
	ok.addActionListener(this);
	cncl.addActionListener(this);

	panel.setLayout(grid);

	tdate =new JTextField(7);
	tdesc=new  JTextField(27);
	ttime=new  JTextField(7);

	sub.add(check);
	sub.add(date);
	sub.add(tdate);
	sub.add(time);
	sub.add(ttime);

	gcons.gridwidth=GridBagConstraints.REMAINDER;
	gcons.anchor= GridBagConstraints.WEST;
	grid.setConstraints(sub,gcons);
	panel.add(sub);
	sub.setBackground(green);

	
	
	gcons.gridwidth=GridBagConstraints.REMAINDER;
	gcons.anchor= GridBagConstraints.NORTHWEST;
	grid.setConstraints(desc,gcons);
	panel.add(desc);

	gcons.gridwidth=GridBagConstraints.REMAINDER;
	gcons.anchor= GridBagConstraints.NORTHWEST;
	grid.setConstraints(tdesc,gcons);
	panel.add(tdesc);

	gcons.gridwidth=GridBagConstraints.REMAINDER;
	gcons.anchor= GridBagConstraints.NORTHWEST;
	grid.setConstraints(Notes,gcons);
	panel.add(Notes);

	gcons.gridwidth=GridBagConstraints.REMAINDER;
	gcons.anchor= GridBagConstraints.NORTHWEST;
	grid.setConstraints(jsp,gcons);
	panel.add(jsp);

	JPanel panel1=new JPanel();
	gcons.gridwidth=GridBagConstraints.REMAINDER;
	gcons.anchor= GridBagConstraints.CENTER;
	grid.setConstraints(panel1,gcons);
	panel.add(panel1);

	panel1.add(ok);
	panel1.add(cncl);
	panel1.setBackground(green);
	check.setBackground(green);

	frame.getContentPane().add(panel);
	frame.setVisible(true);
	//frame.setResizable(false);
	frame.setSize(450,260);
	frame.setLocation(200,150);
	
	}
	
	public void actionPerformed(ActionEvent ee)
	{	
	Object obj=(JButton)ee.getSource();
	
	if(obj==cncl)
		{
		frame.setVisible(false);
		}
	if (obj==ok)
		{
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection cn;
			cn=DriverManager.getConnection("jdbc:odbc:resume","sa","");
			PreparedStatement stat=cn.prepareStatement("insert into schedule(status,cdate,ttime,tdescription,notes )Values(?,?,?,?,?)");
			
			stat.setString(1,(String)check.getSelectedItem());
			stat.setString(2,tdate.getText());
			stat.setString(3,ttime.getText());
			stat.setString(4,tdesc.getText());
			stat.setString(5,textarea.getText());
			stat.executeUpdate();
			}
		catch(Exception e)
			{
			System.out.print(e);
			JOptionPane.showMessageDialog(null,"Error Occured While data submitted in database","Database Error",JOptionPane.WARNING_MESSAGE);


			}
		};
	
		


	


}
	public static void main(String a[])
{
	new Appointment();
}

}

	