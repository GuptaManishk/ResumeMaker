import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;
import java.io.*;

public class openResume extends JFrame implements ActionListener,ListSelectionListener
{
	JWindow frame;
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
		Border lineb;
public static void main(String arg[])
{
openResume tab=new openResume();
}
	public openResume()
	{	
		frame= new JWindow();
		JPanel man= new JPanel();
		down1= new JPanel();
		down2= new JPanel();
		
		green= new Color(173,214,255);
		man.setBackground(green);
		border= new BorderLayout();
		grid=new GridBagLayout ();
		gcons=new GridBagConstraints ();
			
		l=new JLabel(new ImageIcon("Images//NoPrev.gif"));
		l1=new JLabel(new ImageIcon("Images//NoPrev.gif"));	

String [] newres = {	"Manish Special Resume", "Chronological Resume",	"Functional Resume",	"Combined resume",	"Performance Resume",	"Targeted Resume",	"Keywords Resume",	"Skills Resume",	"Professional Resume",	"Curriculum Vitae",	"Recent Graduate Resume",	"Recent Military Resume",	"Theatre/Talent Resume",	"Career Change Resume",	"Highlight Resume"};
String [] sampres = { "Academic","Accountant","Accountant- Entry level","Accounting Clerk","Accounting Manager","Accounts Payable","Actor","Actuary","Administrative Assistant","Administrative Service Manager","Administrator","Admissions Representative","Advertising Agency Executive","Aerobics Instructor","Airline Manager","Animator","Application Programmer","Architect","Athletic Trainer","Attorney","Auditor","Automotive Mechanic","Bank Teller","Banking Executive","Biochemist","Biomedical Researcher","Business Cunsultant","Buyer","Camera Operator","Cartographer","Cashier","Caterer","Chef","Chemical Engineer","Chief Executive Officer","Chief Financial Officer","Chief","CIO","City Planner","Civil Engineering","Clerical","Clothing Designer","Commercial Artist","Commercial Loan Officer","Communications Administrator","Community Service Worker","Composer","Computer Engineer","Computer Graphic Designer","Computer Programmer","Construction Foreman","Contract Administrator","Copywriter","Counselor","Court Reporter","Credit Manager","Customer Service Agent","Data Analyst","Data Entry","Data Processor","Database Administrator","Daycare Worker","Dental Hygienist","Department Store Manager",
"Designer","Desktop Publisher","Detective","Developer","Dietician","Director Marketing-sales", "Disc Jockey", "Distribution Manager", "Doctor", "Drafter", "Electrical Engineer", "Emergency Medical Technician", "Environmental Health Inspector", "Exec Recruiter", "Field Technician", "Film Director", "Film Editor", "Financial Advisor", "Fire Chief", "Flight Attendant", "General Manager -sales", "Hair Stylist", "Health Care Provider", "Hotel Manager", "Human Resources Manager", "Industrial Engineer", "Insurance Claim Adjuster", "Insurance Executive", "Interior Designer", "Investment Banker", "IS Project Manager", "Journalist", "Labor Negotiator", "Laboratory Technician", "LAN Administrator", "Landscape Designer", "Legal Aid Worker", "Legal Clerk", "Legal Secretary", "Librarian", "Machine Operator", "Maitre D’", "Management Consultant", "Manager High-Tech", "Master Electrician", "Materials Manager", "Mechanical Engineer", "MIS Analyst", "MIS Manager", "Network Administrator", "Network Specialist", "NT System Administrator", "Nurse", "Office Manager", "Operations Manager", "Outside Sales", "Paralegal", "Pharmacist", "Photographer", "Physical Therapist", "Pilot", "Postal Worker", "Producer", "Product Marketing Manager", "Production Manager", "Programmer Engineer", "Project Lead", "Project Manager", "Property Manager", "Public Administrator", "Public Relations", "Public Relations Manager", "Public Worker", "Purchasing Agent", "Purchasing Manager", "QA Test Engineer", "Quality Control Manager", "Real Estate Broker", "Recent Graduate", "Receptionist", "Recruiter", "Retail Clerk", "Retail Manager", "Sales Manager", "Sales Representative", "Sales Support Administrator", "Senior System Administrator", "Set Designer", "Shipping and Receiving", "Software Development Manager", "Software Engineer", "Staff Journalist", "Statistician", "Superintendent", "Teacher", "Technical Manager", "Technical Support", "Technical Support Representative", "Temp Worker", "Temporary Placement Agency", "Textbook Editor", "Theatre", "Ticket Agent", 







"Trainer", "Travel Agent", "Vice President Manufacturing", "Visual Basic Developer", "Volunteer Work", "Waiter", "Warehouse Manager", "Web Master", "Wellness Coordinator", "Zoologist"};


Font font = new  Font ("Times New Roman",Font.BOLD,13);

lst = new JList(newres);
lst1 = new JList(sampres);

lst.setFont(font);
lst1.setFont(font);

lst.setVisibleRowCount(11);
lst1.setVisibleRowCount(11);

lst.addListSelectionListener(this);
lst1.addListSelectionListener(this);

lst.setSelectionMode(0);
lst1.setSelectionMode(0);
lineb = BorderFactory.createLineBorder(green);
ok=new JButton(new ImageIcon("images//OK.gif"));
cncl=new JButton(new ImageIcon("images//contClose.gif"));
hlp=new JButton(new ImageIcon("images//conHelp.gif"));
ok1=new JButton(new ImageIcon("images//OK.gif"));
cncl1=new JButton(new ImageIcon("images//contClose.gif"));
hlp1=new JButton(new ImageIcon("images//conHelp.gif"));

ok.setBorder(lineb);
cncl.setBorder(lineb);
hlp.setBorder(lineb);
ok1.setBorder(lineb);
cncl1.setBorder(lineb);
hlp1.setBorder(lineb);

ok.setBackground(green);
cncl.setBackground(green);
hlp.setBackground(green);
ok1.setBackground(green);
cncl1.setBackground(green);
hlp1.setBackground(green);

ok1.addActionListener(this);
cncl1.addActionListener(this);
hlp1.addActionListener(this);

ok.addActionListener(this);
cncl.addActionListener(this);
hlp.addActionListener(this);

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
		p2.setBorder(new TitledBorder (new MatteBorder(new ImageIcon("images//blue.jpg")))); 
		p1.setBorder(new TitledBorder (new MatteBorder(new ImageIcon("images//blue.jpg")))); 
		t.addTab("Sample Resume",null,p2,"Sample Resumes");		
		t.addTab("New Resume   ",null,p1," New Resumes ");
		man.add(t);
		t.setBackgroundAt(0,Color.white);
		t.setBackgroundAt(1,Color.white);
		lst1.setFixedCellWidth(420);	
		lst.setFixedCellWidth(250);	
		p1.setBackground(green);
		p2.setBackground(green);
		down1.setBackground(green);
		down2.setBackground(green);
		frame.setBackground(green);

	frame.getContentPane().add(man);
		frame.setVisible(true);
	//	frame.setResizable(false);
		frame.setSize(500,350);
frame.setBackground(green);
frame.setLocation(150,100);
	

	}
	
void wordopen(String filename)
	{
	Runtime r = Runtime.getRuntime();
	Process p = null;
	try
		{

		String fi=filename;
		String cmd[] = { "E:/Program Files/Microsoft Office/Office10/winword", fi };
		p = r.exec(cmd);
	
		}
	 catch (Exception e) 
		{
		//    System.out.println("error executing " + cmd[0]);
		}

	}






public void valueChanged(ListSelectionEvent e) 
	{
	int j= lst.getSelectedIndex();
	if (j==0){l1.setIcon(new ImageIcon("images//Chronological.gif"));}

	if (j==1){l1.setIcon(new ImageIcon("images//Functional.gif"));}

	if (j==2){l1.setIcon(new ImageIcon("images//combined.gif"));}

	if (j==3){l1.setIcon(new ImageIcon("images//Performance.gif"));}

	if (j==4){l1.setIcon(new ImageIcon("images//targeted.gif"));}

	if (j==5){l1.setIcon(new ImageIcon("images//keywords.gif"));}

	if (j==6){l1.setIcon(new ImageIcon("images//Skills.gif"));}

	if (j==7){l1.setIcon(new ImageIcon("images//professional.gif"));}

	if (j==8){l1.setIcon(new ImageIcon("images//Curriculum Vitae.gif"));}

	if (j==9){l1.setIcon(new ImageIcon("images//Recent Graduate.gif"));}

	if (j==10){l1.setIcon(new ImageIcon("images//Recent Military.gif"));}

	if (j==11){l1.setIcon(new ImageIcon("images//Theatre Talent.gif"));}

	if (j==12){l1.setIcon(new ImageIcon("images//Career Change.gif"));}

	if (j==13){l1.setIcon(new ImageIcon("images//Highlight.gif"));}

	}

	public void actionPerformed(ActionEvent t)
	{
	Object ob=t.getSource();
	int i= lst1.getSelectedIndex();
	int j= lst.getSelectedIndex();
	{
	if(ob==cncl){frame.setVisible(false);};
	if(ob==ok)
	{
	if(j==0)new resumeBuilder();frame.setVisible(false);
	if(i==1){wordopen("d:/Project/Resume/002.doc");}
if(j==2){wordopen("d:/Project/Resume/003.doc");}
if(j==3){wordopen("d:/Project/Resume/004.doc");}
if(j==4){wordopen("d:/Project/Resume/005.doc");}
if(j==5){wordopen("d:/Project/Resume/006.doc");}
if(j==6){wordopen("d:/Project/Resume/007.doc");}
if(j==7){wordopen("d:/Project/Resume/008.doc");}
if(j==8){wordopen("d:/Project/Resume/009.doc");}
if(j==9){wordopen("d:/Project/Resume/010.doc");}
if(j==10){wordopen("d:/Project/Resume/011.doc");}
if(j==11){wordopen("d:/Project/Resume/012.doc");}
if(j==12){wordopen("d:/Project/Resume/013.doc");}
if(j==13){wordopen("d:/Project/Resume/014.doc");}
if(j==14){wordopen("d:/Project/Resume/015.doc");}
	};
	if(ob==hlp){};
	
	if(ob==hlp){};
	if(ob==cncl1){frame.setVisible(false);}
	if (ob==ok1)
	{
		
if(i==0){wordopen("d:/Project/Resume/001.doc");}
if(i==1){wordopen("d:/Project/Resume/002.doc");}
if(i==2){wordopen("d:/Project/Resume/003.doc");}
if(i==3){wordopen("d:/Project/Resume/004.doc");}
if(i==4){wordopen("d:/Project/Resume/005.doc");}
if(i==5){wordopen("d:/Project/Resume/006.doc");}
if(i==6){wordopen("d:/Project/Resume/007.doc");}
if(i==7){wordopen("d:/Project/Resume/008.doc");}
if(i==8){wordopen("d:/Project/Resume/009.doc");}
if(i==9){wordopen("d:/Project/Resume/010.doc");}
if(i==10){wordopen("d:/Project/Resume/011.doc");}
if(i==11){wordopen("d:/Project/Resume/012.doc");}
if(i==12){wordopen("d:/Project/Resume/013.doc");}
if(i==13){wordopen("d:/Project/Resume/014.doc");}
if(i==14){wordopen("d:/Project/Resume/015.doc");}
if(i==15){wordopen("d:/Project/Resume/016.doc");}
if(i==16){wordopen("d:/Project/Resume/017.doc");}
if(i==17){wordopen("d:/Project/Resume/018.doc");}
if(i==18){wordopen("d:/Project/Resume/019.doc");}
if(i==19){wordopen("d:/Project/Resume/020.doc");}
if(i==20){wordopen("d:/Project/Resume/021.doc");}
if(i==21){wordopen("d:/Project/Resume/022.doc");}
if(i==22){wordopen("d:/Project/Resume/023.doc");}
if(i==23){wordopen("d:/Project/Resume/024.doc");}
if(i==24){wordopen("d:/Project/Resume/025.doc");}
if(i==25){wordopen("d:/Project/Resume/026.doc");}
if(i==26){wordopen("d:/Project/Resume/027.doc");}
if(i==27){wordopen("d:/Project/Resume/028.doc");}
if(i==28){wordopen("d:/Project/Resume/029.doc");}
if(i==29){wordopen("d:/Project/Resume/030.doc");}
if(i==30){wordopen("d:/Project/Resume/031.doc");}
if(i==31){wordopen("d:/Project/Resume/032.doc");}
if(i==32){wordopen("d:/Project/Resume/033.doc");}
if(i==33){wordopen("d:/Project/Resume/034.doc");}
if(i==34){wordopen("d:/Project/Resume/035.doc");}
if(i==35){wordopen("d:/Project/Resume/036.doc");}
if(i==36){wordopen("d:/Project/Resume/037.doc");}
if(i==37){wordopen("d:/Project/Resume/038.doc");}
if(i==38){wordopen("d:/Project/Resume/039.doc");}
if(i==39){wordopen("d:/Project/Resume/040.doc");}
if(i==40){wordopen("d:/Project/Resume/041.doc");}
///////
if(i==41){wordopen("d:/Project/Resume/042.doc");}
if(i==42){wordopen("d:/Project/Resume/043.doc");}
if(i==43){wordopen("d:/Project/Resume/044.doc");}
if(i==44){wordopen("d:/Project/Resume/045.doc");}
if(i==45){wordopen("d:/Project/Resume/046.doc");}
if(i==46){wordopen("d:/Project/Resume/047.doc");}
if(i==47){wordopen("d:/Project/Resume/048.doc");}
if(i==48){wordopen("d:/Project/Resume/049.doc");}
if(i==49){wordopen("d:/Project/Resume/050.doc");}
if(i==50){wordopen("d:/Project/Resume/051.doc");}
if(i==51){wordopen("d:/Project/Resume/052.doc");}
if(i==52){wordopen("d:/Project/Resume/053.doc");}
if(i==53){wordopen("d:/Project/Resume/054.doc");}
if(i==54){wordopen("d:/Project/Resume/055.doc");}
if(i==55){wordopen("d:/Project/Resume/056.doc");}
if(i==56){wordopen("d:/Project/Resume/057.doc");}
if(i==57){wordopen("d:/Project/Resume/058.doc");}
if(i==58){wordopen("d:/Project/Resume/059.doc");}
if(i==59){wordopen("d:/Project/Resume/060.doc");}
if(i==60){wordopen("d:/Project/Resume/061.doc");}
if(i==61){wordopen("d:/Project/Resume/062.doc");}
if(i==62){wordopen("d:/Project/Resume/063.doc");}
if(i==63){wordopen("d:/Project/Resume/064.doc");}
if(i==64){wordopen("d:/Project/Resume/065.doc");}
if(i==65){wordopen("d:/Project/Resume/066.doc");}
if(i==66){wordopen("d:/Project/Resume/067.doc");}
if(i==67){wordopen("d:/Project/Resume/068.doc");}
if(i==68){wordopen("d:/Project/Resume/069.doc");}
if(i==69){wordopen("d:/Project/Resume/070.doc");}
if(i==70){wordopen("d:/Project/Resume/071.doc");}
if(i==71){wordopen("d:/Project/Resume/072.doc");}
if(i==72){wordopen("d:/Project/Resume/073.doc");}
if(i==73){wordopen("d:/Project/Resume/074.doc");}
if(i==74){wordopen("d:/Project/Resume/075.doc");}
if(i==75){wordopen("d:/Project/Resume/076.doc");}
if(i==76){wordopen("d:/Project/Resume/077.doc");}
if(i==77){wordopen("d:/Project/Resume/078.doc");}
if(i==78){wordopen("d:/Project/Resume/079.doc");}
if(i==79){wordopen("d:/Project/Resume/080.doc");}
frame.setVisible(false);
	}

	}
	}
	}