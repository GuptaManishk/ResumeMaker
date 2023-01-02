
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;
import java.io.*;

public class openCover extends JFrame implements ActionListener,ListSelectionListener
{
	JWindow frame;
	GridBagLayout grid;
	GridBagConstraints gcons;
	JLabel l;
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
new openCover();
}
	public openCover()
	{	
		frame= new JWindow();
		JPanel man= new JPanel();
		down1= new JPanel();
		down2= new JPanel();
		
		green= new Color(173,214,255);
		border= new BorderLayout();
		grid=new GridBagLayout ();
		gcons=new GridBagConstraints ();
			
		l=new JLabel(new ImageIcon("Images//NoPrev.gif"));
		
Font font = new  Font ("Times New Roman",Font.BOLD,13);
String [] newres = {"Advertisement Reply","Broadcast Letter","Cover Letter","Fax Cover Sheet","Follow-up Letter","Networking Letter","Offer Acceptance","Offer Rejection","Referral Letter","Relocation Letter","Resignation Letter","Thank You Letter"};

String [] sampres = {"Advertisement Letter {1}",
"Advertisement Letter {2}",
"Advertisement Letter {3}",
"Advertisement Letter {4}",
"Advertisement Letter {5}",
"Advertisement Letter {6}",
"Advertisement Letter {7}",
"Advertisement Letter {8}",
"Advertisement Letter {9}",
"Advertisement Letter {10}",
"Advertisement Letter {11}",
"Advertisement Letter {12}",
"Advertisement Letter {13}",
"Advertisement Letter {14}",
"Advertisement Letter {15}",
"Advertisement Letter {16}",
"Advertisement Letter {17}",
"Advertisement Letter {18}",
"Advertisement Letter {19}",
"Advertisement Letter {20}",
"Advertisement Letter {21}",
"Advertisement Letter {22}",
"Advertisement Letter {23}",
"Advertisement Letter {24}",
"Advertisement Letter {25}",
"Broadcast Letter {1}",
"Broadcast Letter {2}",
"Broadcast Letter {3}",
"Broadcast Letter {4}",
"Broadcast Letter {5}",
"Broadcast Letter {6}",
"Broadcast Letter {7}",
"Broadcast Letter {8}",
"Broadcast Letter {9}",
"Broadcast Letter {10}",
"Broadcast Letter {11}",
"Broadcast Letter {12}",
"Broadcast Letter {13}",
"Broadcast Letter {14}",
"Broadcast Letter {15}",
"Broadcast Letter {16}",
"Broadcast Letter {17}",
"Broadcast Letter {18}",
"Broadcast Letter {19}",
"Broadcast Letter {20}",
"Broadcast Letter {21}",
"Broadcast Letter {22}",
"Broadcast Letter {23}",
"Broadcast Letter {24}",
"Broadcast Letter {25}",
"Cover Letter {1}",
"Cover Letter {2}",
"Cover Letter {3}",
"Cover Letter {4}",
"Cover Letter {5}",
"Cover Letter {6}",
"Cover Letter {7}",
"Cover Letter {8}",
"Cover Letter {9}",
"Cover Letter {10}",
"Cover Letter {11}",
"Cover Letter {12}",
"Cover Letter {13}",
"Cover Letter {14}",
"Cover Letter {15}",
"Cover Letter {16}",
"Cover Letter {17}",
"Cover Letter {18}",
"Cover Letter {19}",
"Cover Letter {20}",
"Cover Letter {21}",
"Cover Letter {22}",
"Cover Letter {23}",
"Cover Letter {24}",
"Cover Letter {25}",
"Fax Cover Sheet {1}",
"Fax Cover Sheet {2}",
"Fax Cover Sheet {3}",
"Fax Cover Sheet {4}",
"Fax Cover Sheet {5}",
"Fax Cover Sheet {6}",
"Fax Cover Sheet {7}",
"Fax Cover Sheet {8}",
"Fax Cover Sheet {9}",
"Fax Cover Sheet {10}",
"Fax Cover Sheet {11}",
"Fax Cover Sheet {12}",
"Fax Cover Sheet {13}",
"Fax Cover Sheet {14}",
"Fax Cover Sheet {15}",
"Fax Cover Sheet {16}",
"Fax Cover Sheet {17}",
"Fax Cover Sheet {18}",
"Fax Cover Sheet {19}",
"Fax Cover Sheet {20}",
"Fax Cover Sheet {21}",
"Fax Cover Sheet {22}",
"Fax Cover Sheet {23}",
"Fax Cover Sheet {24}",
"Fax Cover Sheet {25}",
"Follow-up Letter {1}",
"Follow-up Letter {2}",
"Follow-up Letter {3}",
"Follow-up Letter {4}",
"Follow-up Letter {5}",
"Follow-up Letter {6}",
"Follow-up Letter {7}",
"Follow-up Letter {8}",
"Follow-up Letter {9}",
"Follow-up Letter {10}",
"Follow-up Letter {11}",
"Follow-up Letter {12}",
"Follow-up Letter {13}",
"Follow-up Letter {14}",
"Follow-up Letter {15}",
"Follow-up Letter {16}",
"Follow-up Letter {17}",
"Follow-up Letter {18}",
"Follow-up Letter {19}",
"Follow-up Letter {20}",
"Follow-up Letter {21}",
"Follow-up Letter {22}",
"Follow-up Letter {23}",
"Follow-up Letter {24}",
"Follow-up Letter {25}",
"Letter of Recommedation {1}",
"Letter of Recommedation {2}",
"Letter of Recommedation {3}",
"Letter of Recommedation ;{4}",
"Letter of Recommedation {5}",
"Networking Letter {1}",
"Networking Letter {2}",
"Networking Letter {3}",
"Networking Letter {4}",
"Networking Letter {5}",
"Networking Letter {6}",
"Networking Letter {7}",
"Networking Letter {8}",
"Networking Letter {9}",
"Networking Letter {10}",
"Offer Acceptance {1}",
"Offer Acceptance {2}",
"Offer Acceptance {3}",
"Offer Acceptance {4}",
"Offer Acceptance {5}",
"Offer Rejection {1}",
"Offer Rejection {2}",
"Offer Rejection {3}",
"Offer Rejection {4}",
"Offer Rejection {5}",
"References",
"Referral Letter {1}",
"Referral Letter {2}",
"Referral Letter {3}",
"Referral Letter {4}",
"Referral Letter {5}",
"Referral Letter {6}",
"Referral Letter {7}",
"Referral Letter {8}",
"Referral Letter {9}",
"Referral Letter {10}",
"Relocation Letter {1}",
"Relocation Letter {2}",
"Relocation Letter {3}",
"Relocation Letter {4}",
"Relocation Letter {5}",
"Resignation Letter {1}",
"Resignation Letter {2}",
"Resignation Letter {3}",
"Resignation Letter {4}",
"Resignation Letter {5}",
"Resignation Letter {6}",
"Resignation Letter {7}",
"Resignation Letter {8}",
"Resignation Letter {9}",
"Resignation Letter {10}",
"Salary History",
"Thank You Letter {1}",
"Thank You Letter {2}",
"Thank You Letter {3}",
"Thank You Letter {4}",
"Thank You Letter {5}"};

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

ok=new JButton(new ImageIcon("images//OK.gif"));
cncl=new JButton(new ImageIcon("images//contClose.gif"));
hlp=new JButton(new ImageIcon("images//conHelp.gif"));
ok1=new JButton(new ImageIcon("images//OK.gif"));
cncl1=new JButton(new ImageIcon("images//contClose.gif"));
hlp1=new JButton(new ImageIcon("images//conHelp.gif"));
ok.setBackground(green);
cncl.setBackground(green);
hlp.setBackground(green);
ok1.setBackground(green);
ok.addActionListener(this);
cncl1.setBackground(green);
hlp1.setBackground(green);
ok1.addActionListener(this);
cncl.addActionListener(this);
cncl1.addActionListener(this);

ok.setBorder(lineb);
cncl.setBorder(lineb);
hlp.setBorder(lineb);
ok1.setBorder(lineb);
cncl1.setBorder(lineb);
hlp1.setBorder(lineb);

lineb = BorderFactory.createLineBorder(green);

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




JLabel space=new JLabel(" ");
gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(space,gcons);
p1.add(space);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.EAST;
grid.setConstraints(down1,gcons);
p1.add(down1);

FlowLayout flow= new FlowLayout();
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


down2.setBackground(Color.red);
p2.setLayout(grid);

down2.add(ok1);
down2.add(cncl1);
down2.add(hlp1);
ImageIcon ic1=new ImageIcon("images/samplecover.jpg");
		t.setPreferredSize(new Dimension(500, 340));
		p2.setBorder(new TitledBorder (new MatteBorder(new ImageIcon("images//blue.jpg")))); 
		p1.setBorder(new TitledBorder (new MatteBorder(new ImageIcon("images//blue.jpg")))); 

		t.addTab("Sample Cover Letter",null,p2,"Sample Resumes");		
		t.addTab("New Cover Letter   ",null,p1," New Resumes ");
		t.setBackgroundAt(0,Color.white);
		t.setBackgroundAt(1,Color.white);
		man.add(t);
		
		lst1.setFixedCellWidth(430);	
		lst.setFixedCellWidth(430);	
		lst.setSelectedIndex(1);
		lst1.setSelectedIndex(1);
		p1.setBackground(green);
		p2.setBackground(green);
		down1.setBackground(green);
		down2.setBackground(green);
		frame.setBackground(green);
		man.setBackground(green);
	
	frame.getContentPane().add(man);
		frame.setVisible(true);
	//	frame.setResizable(false);
		frame.setSize(500,350);
		frame.setBackground(green);
		frame.setLocation(150,100);
		

	}
	
public void wordopen(String filename)
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
	    System.out.println("error executing " );
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
			boolean bool=lst1.isSelectionEmpty();
			if(bool==false)
			{
			System.out.println(bool);
			new coverLetter();	
			frame.setVisible(false);
			}
		
	}
		if (ob==ok1)
		{
			int i= lst.getSelectedIndex();
				
if(i==0){wordopen("D:/Project/Cover/A1.rtf");}
if(i==1){wordopen("D:/Project/Cover/A2.rtf");}
if(i==2){wordopen("D:/Project/Cover/A3.rtf");}
if(i==3){wordopen("D:/Project/Cover/A4.rtf");}
if(i==4){wordopen("D:/Project/Cover/A5.rtf");}
if(i==5){wordopen("D:/Project/Cover/A6.rtf");}
if(i==6){wordopen("D:/Project/Cover/A7.rtf");}
if(i==7){wordopen("D:/Project/Cover/A8.rtf");}
if(i==8){wordopen("D:/Project/Cover/A9.rtf");}
if(i==9){wordopen("D:/Project/Cover/A1.rtf");}
if(i==1){wordopen("D:/Project/Cover/A11.rtf");}
if(i==11){wordopen("D:/Project/Cover/A12.rtf");}
if(i==12){wordopen("D:/Project/Cover/A13.rtf");}
if(i==13){wordopen("D:/Project/Cover/A14.rtf");}
if(i==14){wordopen("D:/Project/Cover/A15.rtf");}
if(i==15){wordopen("D:/Project/Cover/A16.rtf");}
if(i==16){wordopen("D:/Project/Cover/A17.rtf");}
if(i==17){wordopen("D:/Project/Cover/A18.rtf");}
if(i==18){wordopen("D:/Project/Cover/A19.rtf");}
if(i==19){wordopen("D:/Project/Cover/2.rtf");}
if(i==2){wordopen("D:/Project/Cover/21.rtf");}
if(i==21){wordopen("D:/Project/Cover/22.rtf");}
if(i==22){wordopen("D:/Project/Cover/23.rtf");}
if(i==23){wordopen("D:/Project/Cover/24.rtf");}
if(i==24){wordopen("D:/Project/Cover/25.rtf");}
if(i==25){wordopen("D:/Project/Cover/26.rtf");}
if(i==26){wordopen("D:/Project/Cover/27.rtf");}
if(i==27){wordopen("D:/Project/Cover/28.rtf");}
if(i==28){wordopen("D:/Project/Cover/29.rtf");}
if(i==29){wordopen("D:/Project/Cover/3.rtf");}
if(i==3){wordopen("D:/Project/Cover/31.rtf");}
if(i==31){wordopen("D:/Project/Cover/32.rtf");}
if(i==32){wordopen("D:/Project/Cover/33.rtf");}
if(i==33){wordopen("D:/Project/Cover/34.rtf");}
if(i==34){wordopen("D:/Project/Cover/35.rtf");}
if(i==35){wordopen("D:/Project/Cover/36.rtf");}
if(i==36){wordopen("D:/Project/Cover/37.rtf");}
if(i==37){wordopen("D:/Project/Cover/38.rtf");}
if(i==38){wordopen("D:/Project/Cover/39.rtf");}
if(i==39){wordopen("D:/Project/Cover/4.rtf");}
if(i==4){wordopen("D:/Project/Cover/41.rtf");}
///////
if(i==41){wordopen("D:/Project/Cover/42.rtf");}
if(i==42){wordopen("D:/Project/Cover/43.rtf");}
if(i==43){wordopen("D:/Project/Cover/44.rtf");}
if(i==44){wordopen("D:/Project/Cover/45.rtf");}
if(i==45){wordopen("D:/Project/Cover/46.rtf");}
if(i==46){wordopen("D:/Project/Cover/47.rtf");}
if(i==47){wordopen("D:/Project/Cover/48.rtf");}
if(i==48){wordopen("D:/Project/Cover/49.rtf");}
if(i==49){wordopen("D:/Project/Cover/5.rtf");}
if(i==5){wordopen("D:/Project/Cover/51.rtf");}
if(i==51){wordopen("D:/Project/Cover/52.rtf");}
if(i==52){wordopen("D:/Project/Cover/53.rtf");}
if(i==53){wordopen("D:/Project/Cover/54.rtf");}
if(i==54){wordopen("D:/Project/Cover/55.rtf");}
if(i==55){wordopen("D:/Project/Cover/56.rtf");}
if(i==56){wordopen("D:/Project/Cover/57.rtf");}
if(i==57){wordopen("D:/Project/Cover/58.rtf");}
if(i==58){wordopen("D:/Project/Cover/59.rtf");}
if(i==59){wordopen("D:/Project/Cover/6.rtf");}
if(i==6){wordopen("D:/Project/Cover/61.rtf");}
if(i==61){wordopen("D:/Project/Cover/62.rtf");}
if(i==62){wordopen("D:/Project/Cover/63.rtf");}
if(i==63){wordopen("D:/Project/Cover/64.rtf");}
if(i==64){wordopen("D:/Project/Cover/65.rtf");}
if(i==65){wordopen("D:/Project/Cover/66.rtf");}
if(i==66){wordopen("D:/Project/Cover/67.rtf");}
if(i==67){wordopen("D:/Project/Cover/68.rtf");}
if(i==68){wordopen("D:/Project/Cover/69.rtf");}
if(i==69){wordopen("D:/Project/Cover/7.rtf");}
if(i==7){wordopen("D:/Project/Cover/71.rtf");}
if(i==71){wordopen("D:/Project/Cover/72.rtf");}
if(i==72){wordopen("D:/Project/Cover/73.rtf");}
if(i==73){wordopen("D:/Project/Cover/74.rtf");}
if(i==74){wordopen("D:/Project/Cover/75.rtf");}
if(i==75){wordopen("D:/Project/Cover/76.rtf");}
if(i==76){wordopen("D:/Project/Cover/77.rtf");}
if(i==77){wordopen("D:/Project/Cover/78.rtf");}
if(i==78){wordopen("D:/Project/Cover/79.rtf");}
if(i==79){wordopen("D:/Project/Cover/8.rtf");}
	frame.setVisible(false);	
		}
	if(ob==cncl)
	{
		frame.setVisible(false);
	}
	if(ob==cncl1)
	{
			frame.setVisible(false);
	}
}
}}
