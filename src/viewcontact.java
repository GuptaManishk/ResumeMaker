import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;

public class viewcontact implements ListSelectionListener,ActionListener
{
JFrame frame;
JPanel panel,panel1,panel2,panel3;
JButton del,exit;
JList contactName,position,mobile,mail;
String strname[],strpos[],strmob[],strmail[];
GridBagLayout grid;
GridBagConstraints gcons;
BorderLayout border;
JScrollPane jsp;
JLabel name,position1,mobile1,mail1;
Color green;
	Object it1;
Connection connn;
PreparedStatement pstate;
Statement statem;
public viewcontact()
{
frame=new JFrame("Resume Maker - View All Contact");
panel=new JPanel();
panel1=new JPanel();
panel2=new JPanel();
panel3=new JPanel();


try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			connn=DriverManager.getConnection("jdbc:odbc:resume","sa","");	
			
}
catch(Exception cc)
{
	JOptionPane.showMessageDialog(null,"Connection With M.S SQL Server 2000 Does Not Support \n User DNS resume \n  ","Valid User",JOptionPane.INFORMATION_MESSAGE);		
}

 	green= new Color(187,200,150);
 	
 	panel.setBackground(green);
	panel1.setBackground(green);
	panel2.setBackground(green);
	panel3.setBackground(green);
	panel3.add(new JLabel(new ImageIcon("images//view.jpg")));
	
	int	v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
	int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
	jsp=new JScrollPane(panel1,v,h);
	
	 name=new JLabel("Name  ");
	 position1=new JLabel("Position Title  ");
	 mobile1=new JLabel(" Mobile No");
	 mail1=new JLabel("E-Mail ID  ");

grid= new GridBagLayout ();
gcons= new GridBagConstraints();
border=new BorderLayout();

	
	
	
        strname=new String[64];
		strpos=new String[64];
		strmob=new String[64];
		strmail=new String[64];
	
		
		int i=0;		
		try
		{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:resume","sa","");
                Statement st=con.createStatement();
				PreparedStatement stp;                
				ResultSet rs=st.executeQuery("select vname,postitle,mobile,email from contactlist");
			
				
				String id,name;
                while (rs.next())
						{
							strname[i]=rs.getString(1);
							strpos[i]=rs.getString(2);
							strmob[i]=rs.getString(3);
							strmail[i]=rs.getString(4);
							i=i+1;               
						}

						
					contactName=new JList(strname);
					position=new JList(strpos);
					mobile=new JList(strmob);
					mail=new JList(strmail);
					contactName.setBackground(green);
					position.setBackground(green);
					mobile.setBackground(green);
					mail.setBackground(green);
					
					contactName.setSelectionBackground(Color.white);
					position.setSelectionBackground(Color.white);
					mobile.setSelectionBackground(Color.white);
					mail.setSelectionBackground(Color.white);
					
					contactName.setSelectionForeground(new Color(64,0,128));
					position.setSelectionForeground(new Color(64,0,128));
					mobile.setSelectionForeground(new Color(64,0,128));
					mail.setSelectionForeground(new Color(64,0,128));
					//contactName.addListSelectionListener(this);
					//position.addListSelectionListener(this);
					//mobile.addListSelectionListener(this);
					//mail.addListSelectionListener(this);
		}
		catch(Exception e)
		{
			System.out.println("fecting problem "+e);
		}

		
		
     
del=new JButton("Delete Contact");
exit=new JButton("Return To Contact Manager");
del.addActionListener(this);
exit.addActionListener(this);

panel.setLayout(border);

panel.add(jsp,BorderLayout.CENTER);
panel.add(panel2,BorderLayout.SOUTH);
panel.add(panel3,BorderLayout.NORTH);
panel1.setLayout(grid);




gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=3;
gcons.gridy=2;
grid.setConstraints(name,gcons);
panel1.add(name);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=2;
grid.setConstraints(position1,gcons);
panel1.add(position1);


gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=5;
gcons.gridy=2;
grid.setConstraints(mobile1,gcons);
panel1.add(mobile1);


gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=6;
gcons.gridy=2;
grid.setConstraints(mail1,gcons);
panel1.add(mail1);



gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=3;
gcons.gridy=4;
grid.setConstraints(contactName,gcons);
panel1.add(contactName);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=4;
grid.setConstraints(position,gcons);
panel1.add(position);


gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=5;
gcons.gridy=4;
grid.setConstraints(mobile,gcons);
panel1.add(mobile);


gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=6;
gcons.gridy=4;
grid.setConstraints(mail,gcons);
panel1.add(mail);

contactName.setFixedCellWidth(200);
position.setFixedCellWidth(163);
mobile.setFixedCellWidth(163);
mail.setFixedCellWidth(163);

panel2.add(del);
panel2.add(exit);

panel1.setBorder(new TitledBorder("List Of Existing Contacts"));
panel2.setBorder(new TitledBorder("Actions Buttons"));
panel3.setBorder(new MatteBorder (new ImageIcon("images//contactBorder.jpg")));
frame.getContentPane().add(panel);
frame.setVisible(true);
frame.setSize(800,600);
//ac=it1.toString();
}

			


 
public void add()
	{
	try
		{
			
			it1=contactName.getSelectedValue();
			String a=(it1.toString());
			pstate=connn.prepareStatement("insert into templ values(?)");
			pstate.setString(1,a);
			pstate.executeUpdate();
		}
		catch(Exception e)
			{
				System.out.println(" Add :: "+e);
			}
	 }
	 
	 public void del()
{
	try
	{


		statem=connn.createStatement();
		statem.executeUpdate("DELETE contactlist FROM contactlist INNER JOIN templ ON contactlist.vname = templ.vname");
		System.out.println(" Table Updated ");
	}
	catch(Exception r)
	{
		System.out.println(" Del :: "+r);
	}
}

public void update()
{
	try
		{

		pstate=connn.prepareStatement("delete from templ");
		pstate.executeUpdate();

		}
	catch(Exception win)
	{
	}
}

public void valueChanged(ListSelectionEvent e)
	{
			Object it=contactName.getSelectedValue();
			
			System.out.println(it);
			
			
	}
	
public void actionPerformed(ActionEvent evt)
	{	
		Object it1=contactName.getSelectedValue();
		Object ob=evt.getSource();
		
		if (ob==del)
			{
				System.out.println(it1);
				add();
				del();
				update();
				frame.setVisible(false);
				new viewcontact();
			}
			
			if(ob==exit);
			{
				frame.setVisible(false);
				//new contactManager();
			}

		
	}
public static void main(String a[])
{
new viewcontact();
}
}