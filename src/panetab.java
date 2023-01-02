import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;
import java.io.*;

public class panetab extends JFrame implements ActionListener,ListSelectionListener
{
	JFrame frame;
	GridBagLayout grid;
	GridBagConstraints gcons;
	JLabel l,l1;
	JList lst,lst1;
	JPanel p1,p2;
	JPanel down1,down2;
	JTabbedPane t;
	BorderLayout border;
	JButton ok,cncl,hlp;
	JButton ok1,cncl1,hlp1;
	Color green;

public static void main(String arg[])
{
panetab tab=new panetab();
}
	public panetab()
	{	
		frame= new JFrame();
		JPanel man= new JPanel();
		down1= new JPanel();
		down2= new JPanel();
		
		green= new Color(187,200,150);
		border= new BorderLayout();
		grid=new GridBagLayout ();
		gcons=new GridBagConstraints ();
			
		l=new JLabel(new ImageIcon("Images//NoPrev.gif"));
		l1=new JLabel(new ImageIcon("Images//NoPrev.gif"));	

String [] newres = {	"Chronological Resume",	"Functional Resume",	"Combined resume",	"Performance Resume",	"Targeted Resume",	"Keywords Resume",	"Skills Resume",	"Professional Resume",	"Curriculum Vitae",	"Recent Graduate Resume",	"Recent Military Resume",	"Theatre/Talent Resume",	"Career Change Resume",	"Highlight Resume"};
String [] sampres = { "Academic","Accountant","Accountant- Entry level","Accounting Clerk","Accounting Manager","Accounts Payable","Actor","Actuary","Administrative Assistant","Administrative Service Manager","Administrator","Admissions Representative","Advertising Agency Executive","Aerobics Instructor","Airline Manager","Animator","Application Programmer","Architect","Athletic Trainer","Attorney","Auditor","Automotive Mechanic","Bank Teller","Banking Executive","Biochemist","Biomedical Researcher","Business Cunsultant","Buyer","Camera Operator","Cartographer","Cashier","Caterer","Chef","Chemical Engineer","Chief Executive Officer","Chief Financial Officer","Chief","CIO","City Planner","Civil Engineering","Clerical","Clothing Designer","Commercial Artist","Commercial Loan Officer","Communications Administrator","Community Service Worker","Composer","Computer Engineer","Computer Graphic Designer","Computer Programmer","Construction Foreman","Contract Administrator","Copywriter","Counselor","Court Reporter","Credit Manager","Customer Service Agent","Data Analyst","Data Entry","Data Processor","Database Administrator","Daycare Worker","Dental Hygienist","Department Store Manager",
"Designer","Desktop Publisher","Detective","Developer","Dietician","Director Marketing-sales", "Disc Jockey", "Distribution Manager", "Doctor", "Drafter", "Electrical Engineer", "Emergency Medical Technician", "Environmental Health Inspector", "Exec Recruiter", "Field Technician", "Film Director", "Film Editor", "Financial Advisor", "Fire Chief", "Flight Attendant", "General Manager -sales", "Hair Stylist", "Health Care Provider", "Hotel Manager", "Human Resources Manager", "Industrial Engineer", "Insurance Claim Adjuster", "Insurance Executive", "Interior Designer", "Investment Banker", "IS Project Manager", "Journalist", "Labor Negotiator", "Laboratory Technician", "LAN Administrator", "Landscape Designer", "Legal Aid Worker", "Legal Clerk", "Legal Secretary", "Librarian", "Machine Operator", "Maitre D’", "Management Consultant", "Manager High-Tech", "Master Electrician", "Materials Manager", "Mechanical Engineer", "MIS Analyst", "MIS Manager", "Network Administrator", "Network Specialist", "NT System Administrator", "Nurse", "Office Manager", "Operations Manager", "Outside Sales", "Paralegal", "Pharmacist", "Photographer", "Physical Therapist", "Pilot", "Postal Worker", "Producer", "Product Marketing Manager", "Production Manager", "Programmer Engineer", "Project Lead", "Project Manager", "Property Manager", "Public Administrator", "Public Relations", "Public Relations Manager", "Public Worker", "Purchasing Agent", "Purchasing Manager", "QA Test Engineer", "Quality Control Manager", "Real Estate Broker", "Recent Graduate", "Receptionist", "Recruiter", "Retail Clerk", "Retail Manager", "Sales Manager", "Sales Representative", "Sales Support Administrator", "Senior System Administrator", "Set Designer", "Shipping and Receiving", "Software Development Manager", "Software Engineer", "Staff Journalist", "Statistician", "Superintendent", "Teacher", "Technical Manager", "Technical Support", "Technical Support Representative", "Temp Worker", "Temporary Placement Agency", "Textbook Editor", "Theatre", "Ticket Agent", 
"Trainer", "Travel Agent", "Vice President Manufacturing", "Visual Basic Developer", "Volunteer Work", "Waiter", "Warehouse Manager", "Web Master", "Wellness Coordinator", "Zoologist"};

lst = new JList(newres);
lst1 = new JList(sampres);
lst.setVisibleRowCount(11);
lst1.setVisibleRowCount(11);

lst.addListSelectionListener(this);
lst1.addListSelectionListener(this);

lst.setSelectionMode(0);
lst1.setSelectionMode(0);

ok=new JButton("OK");
cncl=new JButton("Cancel");
hlp=new JButton("Help");
ok1=new JButton("OK");
cncl1=new JButton("Cancel");
hlp1=new JButton("Help");
ok.addActionListener(this);
int	v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
JScrollPane pn = new JScrollPane(lst,v,h);
JScrollPane pn1= new JScrollPane(lst1,v,h);

p1=new JPanel();
p2=new JPanel();
t=new JTabbedPane();
p1.setLayout(grid);


gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.WEST;
grid.setConstraints(pn,gcons);
p1.add(pn);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(l1,gcons);
p1.add(l1);

l1.setBorder(new TitledBorder ("Resume Preview ")); 


JLabel space=new JLabel(" ");
gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(space,gcons);
p1.add(space);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.EAST;
grid.setConstraints(down1,gcons);
p1.add(down1);

GridLayout flow= new GridLayout(1,3);
down1.setLayout(flow);
down1.add(ok);down1.add(cncl);down1.add(hlp);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(pn1,gcons);
p2.add(pn1);


JLabel space1=new JLabel(" ");
gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(space1,gcons);
p2.add(space1);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.EAST;
grid.setConstraints(down2,gcons);
p2.add(down2);


p2.setLayout(grid);

down2.add(ok1);
down2.add(cncl1);
down2.add(hlp1);

		t.setPreferredSize(new Dimension(500, 340));
		p2.setBorder(new TitledBorder ("See Sample Resume ")); 
		p1.setBorder(new TitledBorder ("Select Resume Type")); 
		t.addTab("Sample",null,p2,"Sample Resumes");		
		t.addTab(" New    ",null,p1," New Resumes ");
		man.add(t);
		
		lst1.setFixedCellWidth(450);	
		lst.setFixedCellWidth(250);	
		p1.setBackground(green);
		p2.setBackground(green);
		down1.setBackground(green);
		down2.setBackground(green);
		frame.setBackground(green);

	frame.getContentPane().add(man);
		frame.setVisible(true);
//		frame.setResizable(false);
		frame.setSize(500,360);
	

	}
	
void wordopen(String filename)
{
Runtime r = Runtime.getRuntime();
Process p = null;
try
	 {

String fi=filename;

String cmd[] = { "D:/Program Files/Microsoft Office/Office10/winword", fi };
	    p = r.exec(cmd);
	}
	 catch (Exception e) 
	{
	//    System.out.println("error executing " + cmd[0]);
	}
}



public void valueChanged(ListSelectionEvent e) 
{
//Object obj=e.getSource();
}

public void actionPerformed(ActionEvent t)
{
Object ob=t.getSource();
{
	if (ob==ok)
	{
	int i= lst.getSelectedIndex();
	if(i==0){wordopen("c:/Manish/earth.doc");
	}
}


}
}}