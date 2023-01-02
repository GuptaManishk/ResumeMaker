import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
public class salary implements ActionListener
{
JPanel  main,pane1,pane2,pane3,pane4;
JFrame frame;
GridBagLayout grid;
GridBagConstraints gcons;
JComboBox area;
JList list;
JTextField zip;
JLabel ziplab,state,orlab;
BorderLayout border;
JLabel blank;
JButton report,close,help;

public salary()
{
frame=new JFrame();
main=new JPanel();
pane1=new JPanel();
pane2=new JPanel();
pane3=new JPanel();
pane4=new JPanel();
border=new BorderLayout();
grid= new GridBagLayout();
gcons= new GridBagConstraints();

String str []={"1","2"};
int	v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
main.setLayout(border);

main.add(pane1,BorderLayout.NORTH);
main.add(pane2,BorderLayout.WEST);
main.add(pane3,BorderLayout.CENTER);
 main.add(pane4,BorderLayout.SOUTH);
pane3.setPreferredSize(new Dimension(100,150));
pane1.add(new JLabel(new ImageIcon("images/sal1.jpg")));
String stat []={
"Andaman & Nicobar",
"Andhra Pradesh - Hyderabad",
"Andhra Pradesh - Secunderabad",
"Andhra Pradesh - Vishakapatnam",
"Andhra Pradesh - Vijaywada",
"Andhra Pradesh - Other cities",
"Assam - Gauhati",
"Assam - Other cities",
"Arunachal Pradesh",
"Bihar - Patna",
"Bihar - Other cities",
"Chandigarh",
"Chhattisgarh -other Cities",
"Daman & Diu",
"Delhi - Delhi",
"Delhi - Faridabad",
"Delhi - Ghaziabad",
"Delhi - Gurgoan",
"Delhi - Noida",
"Dadra & Nagar Haveli",
"Goa",
"Gujarat - Ahmedabad",
"Gujarat - Vadodara",
"Gujarat - Other cities",
"Haryana - Panipat",
"Haryana - Other cities",
"Himachal Pradesh",
"Jammu & Kashmir",
"Jharkhand - Jamshedpur",
"Jharkhand - Ranchi",
"Jharkhand - Other cities",
"Karnataka - Bangalore",
"Karnataka - Mysore",
"Karnataka - Mangalore",
"Karnataka - Other cities",
"Kerala - Cochin",
"Kerala - Trivandrum",
"Kerala - Other cities",
"Lakshadweep",
"Maharashtra - Aurangabad",
"Maharashtra - Mumbai",
"Maharashtra - Nagpur",
"Maharashtra - Nashik",
"Maharashtra - Pune",
"Maharashtra - Other cities",
"Meghalaya",
"Mizoram",
"Manipur",
"Madhya Pradesh - Bhopal",
"Madhya Pradesh - Indore",
"Madhya Pradesh - Other cities",
"Nagaland",
"Orissa - Bhubaneshwar",
"Orissa - Other cities",
"Pondicherry",
"Punjab - Jalandhar",
"Punjab - Ludhiana",
"Punjab - Other cities",
"Rajasthan - Jaipur",
"Rajasthan - Kota",
"Rajasthan - Other cities",
"Sikkim",
"Tamil Nadu - Chennai",
"Tamil Nadu - Coimbatore",
"Tamil Nadu - Madurai",
"Tamil Nadu - Trichy",
"Tamil Nadu - Salem",
"Tamil Nadu - Hosur",
"Tamil Nadu - Other cities",
"Tripura",
"Uttaranchal",
"Uttar Pradesh - Lucknow",
"Uttar Pradesh - Kanpur", "Uttar Pradesh - Other cities","West Bengal - Kolkata","West Bengal - Other cities" 
};

ziplab=new JLabel("Zip");
state=new JLabel("State / Metro Area");
orlab=new JLabel(" or ");
blank=new JLabel("  ");
zip=new JTextField(6);
report=new JButton("Create Salary Report");
report.addActionListener(this);
close=new JButton("Return To Main Menu");
close.addActionListener(this);
help=new JButton("Help");
pane4.add(report);
pane4.add(help);pane4.add(close);
pane4.setBackground(new Color(70,134,247));
String [] sampres = { "Academic","Accountant","Accountant- Entry level","Accounting Clerk","Accounting Manager","Accounts Payable","Actor","Actuary","Administrative Assistant","Administrative Service Manager","Administrator","Admissions Representative","Advertising Agency Executive","Aerobics Instructor","Airline Manager","Animator","Application Programmer","Architect","Athletic Trainer","Attorney","Auditor","Automotive Mechanic","Bank Teller","Banking Executive","Biochemist","Biomedical Researcher","Business Cunsultant","Buyer","Camera Operator","Cartographer","Cashier","Caterer","Chef","Chemical Engineer","Chief Executive Officer","Chief Financial Officer","Chief","CIO","City Planner","Civil Engineering","Clerical","Clothing Designer","Commercial Artist","Commercial Loan Officer","Communications Administrator","Community Service Worker","Composer","Computer Engineer","Computer Graphic Designer","Computer Programmer","Construction Foreman","Contract Administrator","Copywriter","Counselor","Court Reporter","Credit Manager","Customer Service Agent","Data Analyst","Data Entry","Data Processor","Database Administrator","Daycare Worker","Dental Hygienist","Department Store Manager","Designer","Desktop Publisher","Detective","Developer","Dietician","Director Marketing-sales", "Disc Jockey", "Distribution Manager", "Doctor", "Drafter", "Electrical Engineer", "Emergency Medical Technician", "Environmental Health Inspector", "Exec Recruiter", "Field Technician", "Film Director", "Film Editor", "Financial Advisor", "Fire Chief", "Flight Attendant", "General Manager -sales", "Hair Stylist", "Health Care Provider", "Hotel Manager", "Human Resources Manager", "Industrial Engineer", "Insurance Claim Adjuster", "Insurance Executive", "Interior Designer", "Investment Banker", "IS Project Manager", "Journalist", "Labor Negotiator", "Laboratory Technician", "LAN Administrator", "Landscape Designer", "Legal Aid Worker", "Legal Clerk", "Legal Secretary", "Librarian", "Machine Operator", "Maitre D’", "Management Consultant", "Manager High-Tech", "Master Electrician", "Materials Manager", "Mechanical Engineer", "MIS Analyst", "MIS Manager", "Network Administrator", "Network Specialist", "NT System Administrator", "Nurse", "Office Manager", "Operations Manager", "Outside Sales", "Paralegal", "Pharmacist", "Photographer", "Physical Therapist", "Pilot", "Postal Worker", "Producer", "Product Marketing Manager", "Production Manager", "Programmer Engineer", "Project Lead", "Project Manager", "Property Manager", "Public Administrator", "Public Relations", "Public Relations Manager", "Public Worker", "Purchasing Agent", "Purchasing Manager", "QA Test Engineer", "Quality Control Manager", "Real Estate Broker", "Recent Graduate", "Receptionist", "Recruiter", "Retail Clerk", "Retail Manager", "Sales Manager", "Sales Representative", "Sales Support Administrator", "Senior System Administrator", "Set Designer", "Shipping and Receiving", "Software Development Manager", "Software Engineer", "Staff Journalist", "Statistician", "Superintendent", "Teacher", "Technical Manager", "Technical Support", "Technical Support Representative", "Temp Worker", "Temporary Placement Agency", "Textbook Editor", "Theatre", "Ticket Agent", "Trainer", "Travel Agent", "Vice President Manufacturing", "Visual Basic Developer", "Volunteer Work", "Waiter", "Warehouse Manager", "Web Master", "Wellness Coordinator", "Zoologist"};
area=new JComboBox(stat);
area.setBackground(Color.white);

list=new JList(sampres);
JScrollPane mainscroll= new JScrollPane(list,v,h);
list.setBorder(new TitledBorder("Select Job Catogary"));
list.setPreferredSize(new Dimension(300, 450));
JPanel addi=new JPanel();


pane2.setLayout(grid);
pane3.setLayout(grid);
pane2.setBackground(Color.white);
pane3.setBackground(Color.white);
pane1.setBackground(Color.white);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(mainscroll,gcons);
pane2.add(mainscroll);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(blank,gcons);
pane2.add(blank);

JLabel blank2=new JLabel(" ");
gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(blank2,gcons);
pane2.add(blank2);



gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(addi,gcons);
pane2.add(addi);
addi.setBackground(Color.white);
JLabel blank1=new JLabel(" ");
gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(blank1,gcons);
pane2.add(blank1);





JLabel im=new JLabel();
im.setIcon(new ImageIcon("images//accountent.jpg"));
pane3.add(im);	

addi.add(zip);
addi.add(orlab);
addi.add(area);
zip.setBorder(new TitledBorder("Zip"));
area.setBorder(new TitledBorder("State /Metro Area"));
area.setPreferredSize(new Dimension(200, 50));
main.setBackground(Color.white);
main.setBorder(new TitledBorder (new MatteBorder(new ImageIcon("images//blue.jpg")))); 
frame.setLocation(0,70);
frame.getContentPane().add(main);
frame.setSize(662,500);
frame.setVisible(true);
frame.setLocation(100,65);
frame.setResizable(false);
}
public void actionPerformed(ActionEvent e)
	{
			Object ob=e.getSource();
			{
				if(ob==report){
			JOptionPane.showMessageDialog(frame,"Please Check Your Internet Connection\nor You may Contact to Your ISP","Internet Connection Required",JOptionPane.WARNING_MESSAGE);
			new report();}
			
			if(ob==close)
				{
					frame.setVisible(false);
				}}
			}
public static void main(String a[])
{
new salary();
}
}