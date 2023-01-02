import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.*;
import java.util.*;
import java.io.*;
import java.util.Properties;
import java.awt.print.*;

public class contactManager implements ActionListener,MouseListener
{
JFrame fr;
Properties props = new Properties();
Date date;
DateFormat formatter;
contactTab cn;
Runtime r = Runtime.getRuntime();
Process p = null;
TestPrint tp=new TestPrint();
JLabel clo,ext;

JPanel main,panel1,panel2,panel3,panel4;
JPanel paneltodo,paneldaily,panelweek;
JPanel main1,main2;
JPanel imagepanel;

JLabel add,comp,name,title,email,mobile,phno;
JLabel new11,add1,del1,letter,mail,Viewcalender,print;
JLabel newtodo,edittodo,deltodo;
JLabel newappt,editapt,delappt;
JLabel dateschedule;
JList listSchedule;
JTextField COMPANY,NAME,TITLE,MAIL,PHONE,MOBILE;
JTextArea ADDRESS;

JScrollPane scroll,scroll1;
JLabel contactlist,todolist,daily,weekly;



BorderLayout border;
GridBagLayout grid;
GridBagConstraints gcons;
CardLayout card;
Color green;


//Varibels for TO DO LIST

	String dd;
	JList listDate,listDesc,listid;
	String strDate[],strDescription[],strid[];
   	Connection con;
	Statement st;
	ResultSet rs;
	PreparedStatement stp;
	
	////////End to do list var
	
	
	JList times,listschedule,schid,status;
	String strDate1[],strDescription1[],strid1[],stat[];
	///////weekly Schedule
	JList times1,listschedule1,schid1,status1;
	String strDate2[],strDescription2[],strid2[],stat2[];
	
public contactManager()
	{
		try
			{	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con=DriverManager.getConnection("jdbc:odbc:resume","sa","");
                st=con.createStatement();
				 
				
			}
		catch(Exception ee)
			{
			JOptionPane.showMessageDialog(null,"Could not Connect With Database ","Database Exception",JOptionPane.WARNING_MESSAGE);
			System.out.println(ee);
			}
	
		
		Locale mLocale=null;
	  	Date date = new Date();
		formatter=DateFormat.getDateInstance(DateFormat.FULL);
		dd=formatter.format(date);
	
		
		int	v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		
		Font font = new  Font ("Times New Roman",Font.BOLD,16);
		Font font1 = new  Font ("Times New Roman",Font.BOLD+Font.ITALIC,20);
		Font font2 = new  Font ("Times New Roman",Font.BOLD,22);
		
		grid= new GridBagLayout ();
		gcons= new GridBagConstraints();
		border= new BorderLayout();
		card=new CardLayout();

		fr=new JFrame("Contact Manager");
		main=new JPanel();
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		panel4=new JPanel();
		imagepanel=new JPanel();
		
		imagepanel.setBackground(Color.white);
		imagepanel.add(new JLabel(new ImageIcon("images//CONTECTMANAGER.jpg")));
		imagepanel.setBorder(new MatteBorder (new ImageIcon("images//contactBorder.jpg")));
	
		main1=new JPanel();
		main2=new JPanel();
		paneltodo=new JPanel();
		paneldaily=new JPanel();
		panelweek=new JPanel();


		 green= new Color(173,214,255);
		
		
		main.setBackground(green);
		panel1.setBackground(green);
		paneltodo.setBackground(green);
		panel1.setBorder(new MatteBorder (new ImageIcon("images//contactBorder.jpg")));
		main1.setBackground(green);
		main1.setBorder(new MatteBorder (new ImageIcon("images//contactBorder.jpg")));
		panel2.setBackground(green);
		panel2.setBorder(new MatteBorder (new ImageIcon("images//contactBorder.jpg")));
		panel3.setBackground(green);
		panel4.setBackground(green);
		paneltodo.setBorder(new MatteBorder (new ImageIcon("images//contactBorder.jpg")));
		cn= new contactTab();
	
	
	
		Border lineb = BorderFactory.createLineBorder(Color.white);
	
		scroll=new JScrollPane(panel2,v,h);
		scroll1=new JScrollPane(paneltodo,v,h);
	
		comp=new JLabel("Company");
		add=new JLabel("  Address");
		name=new JLabel("  Name");
		title=new JLabel("  Title");
		email=new JLabel("  E-mail ID");
		phno=new JLabel("  Phone Number");
		mobile=new JLabel("  Mobile No");
		paneltodo.setLayout(grid);
	
	
		COMPANY=new JTextField(40);
		NAME=new JTextField(30);
		TITLE=new JTextField(30);
		MAIL=new JTextField(30);	
		PHONE=new JTextField(30);
		MOBILE=new JTextField(30);
		ADDRESS= new JTextArea(3,40);

		ImageIcon head12=new ImageIcon("images//arrow1.gif");
		contactlist=new JLabel(new ImageIcon("Images//a11.gif"));
		todolist=new JLabel(new ImageIcon("Images//a22.gif"));
		daily=new JLabel(new ImageIcon("Images//a33.gif"));
		weekly=new JLabel(new ImageIcon("Images//a44.gif"));
		
		daily.setFont(font);
		weekly.setFont(font);
		todolist.setFont(font);
		contactlist.setFont(font);
	
		contactlist.setForeground(green);
		todolist.setForeground(green);
		daily	.setForeground(green);
		weekly.setForeground(green);

		new11=new JLabel(new ImageIcon("Images//a111.gif"));
		add1=new JLabel(new ImageIcon("Images//a112.gif"));
		del1=new JLabel(new ImageIcon("Images//a113.gif"));
		letter=new JLabel(new ImageIcon("Images//a114.gif"));
		mail=new JLabel(new ImageIcon("Images//a115.gif"));
		Viewcalender=new JLabel(new ImageIcon("Images//a116.gif"));
		print=new JLabel(new ImageIcon("Images//a117.gif"));
	
		newtodo= new JLabel(new ImageIcon("Images//b1.gif"));
		edittodo= new JLabel(new ImageIcon("Images//b2.gif"));
		deltodo= new JLabel(new ImageIcon("Images//b3.gif"));
		newappt= new JLabel(new ImageIcon("Images//c1.gif"));
		editapt= new JLabel(new ImageIcon("Images//c2.gif"));
		delappt= new JLabel(new ImageIcon("Images//c3.gif"));

		new11.setVisible(false);
		add1.setVisible(false);
		del1.setVisible(false);
		letter.setVisible(false);
		mail.setVisible(false);
		newtodo.setVisible(false);
		edittodo.setVisible(false);
		deltodo.setVisible(false);
		newappt.setVisible(false);
		editapt.setVisible(false);
		delappt.setVisible(false);
	
		contactlist.addMouseListener(this);
		todolist.addMouseListener(this);
		daily.addMouseListener(this);
		weekly.addMouseListener(this);
		new11.addMouseListener(this);
		add1.addMouseListener(this);
		del1.addMouseListener(this);
		letter.addMouseListener(this);
		mail.addMouseListener(this);
		newtodo.addMouseListener(this);
		edittodo.addMouseListener(this);
		deltodo.addMouseListener(this);
		newappt.addMouseListener(this);
		editapt.addMouseListener(this);
		delappt.addMouseListener(this);
	 	Viewcalender.addMouseListener(this);
	 	print.addMouseListener(this);

		gcons.gridwidth=GridBagConstraints.RELATIVE;
		grid.setConstraints(comp,gcons);
		panel3.add(comp);

		gcons.gridwidth=GridBagConstraints.REMAINDER;
		gcons.anchor= GridBagConstraints.NORTHWEST;
		grid.setConstraints(COMPANY,gcons);
		panel3.add(COMPANY);

		gcons.gridwidth=GridBagConstraints.RELATIVE;
		grid.setConstraints(add,gcons);
		panel3.add(add);

		gcons.gridwidth=GridBagConstraints.REMAINDER;
		grid.setConstraints(ADDRESS,gcons);		
		panel3.add(ADDRESS);

		gcons.gridwidth=GridBagConstraints.RELATIVE;
		grid.setConstraints(name,gcons);
		panel3.add(name);
	
		gcons.gridwidth=GridBagConstraints.REMAINDER;
		grid.setConstraints(NAME,gcons);
		panel3.add(NAME);

		gcons.gridwidth=GridBagConstraints.RELATIVE;
		grid.setConstraints(title,gcons);
		panel3.add(title);
	
		gcons.gridwidth=GridBagConstraints.REMAINDER;
		grid.setConstraints(TITLE,gcons);
		panel3.add(TITLE);

		gcons.gridwidth=GridBagConstraints.RELATIVE;
		grid.setConstraints(email,gcons);
		panel3.add(email);
	
		gcons.gridwidth=GridBagConstraints.REMAINDER;
		grid.setConstraints(MAIL,gcons);
		panel3.add(MAIL);
			
		gcons.gridwidth=GridBagConstraints.RELATIVE;
		grid.setConstraints(phno,gcons);
		panel3.add(phno);
	
		gcons.gridwidth=GridBagConstraints.REMAINDER;
		grid.setConstraints(PHONE,gcons);
		panel3.add(PHONE);


		gcons.gridwidth=GridBagConstraints.RELATIVE;
		grid.setConstraints(mobile,gcons);
		panel3.add(mobile);
	
		gcons.gridwidth=GridBagConstraints.REMAINDER;
		grid.setConstraints(MOBILE,gcons);
		panel3.add(MOBILE);
	
		main.setLayout(border);
		main.add(main1,BorderLayout.WEST);
		main.add(main2,BorderLayout.CENTER);
		main2.setLayout(card);

		panel2.setLayout(grid);	
		panel1.setLayout(grid);	
		panel3.setLayout(grid);
		
		main1.add(panel1);
		main2.add(imagepanel,"Image");
		main2.add(scroll,"Panel2");
		main2.add(scroll1,"Panel3");
		main2.add(paneldaily,"Panel4");
		main2.add(panelweek,"Panel5");


	

	gcons.gridwidth=GridBagConstraints.REMAINDER;
	gcons.anchor= GridBagConstraints.NORTHWEST;
	grid.setConstraints(panel3,gcons);
	panel2.add(panel3);

	gcons.gridwidth=GridBagConstraints.REMAINDER;
	gcons.anchor= GridBagConstraints.NORTHWEST;
	grid.setConstraints(panel4,gcons);
	panel2.add(panel4);
	
	gcons.gridwidth=GridBagConstraints.REMAINDER;
	gcons.anchor= GridBagConstraints.NORTHWEST;
	grid.setConstraints(cn.tab,gcons);
	panel4.add(cn.tab);
	cn.tab.setPreferredSize(new Dimension(600, 320));



	
JLabel imagehead=new JLabel(new ImageIcon("images//contacthead.jpg"));
gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(imagehead,gcons);
panel1.add(imagehead);
	

/*	gcons.gridwidth=GridBagConstraints.REMAINDER;
	grid.setConstraints(head12,gcons);
	panel1.add(head12);
	
*/	gcons.gridwidth=GridBagConstraints.REMAINDER;
	grid.setConstraints(contactlist,gcons);
	panel1.add(contactlist);

	gcons.gridwidth=GridBagConstraints.REMAINDER;
	grid.setConstraints(todolist,gcons);
	panel1.add(todolist);

	gcons.gridwidth=GridBagConstraints.REMAINDER;
	grid.setConstraints(daily,gcons);
	panel1.add(daily);

	gcons.gridwidth=GridBagConstraints.REMAINDER;
	grid.setConstraints(weekly,gcons);
	panel1.add(weekly);
	
	
	
JLabel spacer0=new JLabel("  ");
gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(spacer0,gcons);
panel1.add(spacer0);



JLabel ll=new JLabel(new ImageIcon("images//labelupper.jpg"));
gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(ll,gcons);
panel1.add(ll);


JLabel spacer1=new JLabel("  ");
gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(spacer1,gcons);
panel1.add(spacer1);


gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(new11,gcons);
panel1.add(new11);

gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(add1,gcons);
panel1.add(add1);

gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(del1,gcons);
panel1.add(del1);


gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(newtodo,gcons);
panel1.add(newtodo);

gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(edittodo,gcons);
panel1.add(edittodo);

gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(deltodo,gcons);
panel1.add(deltodo);

gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(newappt,gcons);
panel1.add(newappt);

gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(editapt,gcons);
panel1.add(editapt);

gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(delappt,gcons);
panel1.add(delappt);

JLabel spacer2=new JLabel(" ");
gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(spacer2,gcons);
panel1.add(spacer2);

JLabel des=new JLabel(new ImageIcon("images//labelupper.jpg"));
gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(des,gcons);
panel1.add(des);



JLabel spacer4=new JLabel("  ");
gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(spacer4,gcons);
panel1.add(spacer4);


gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(letter,gcons);
panel1.add(letter);

gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(mail,gcons);
panel1.add(mail);


gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(Viewcalender,gcons);
panel1.add(Viewcalender);

gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(print,gcons);
panel1.add(print);

	
JLabel spacer5=new JLabel("  ");
gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(spacer5,gcons);
panel1.add(spacer5);


JLabel pho=new JLabel(new ImageIcon("images//labelupper.jpg"));
gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(pho,gcons);
panel1.add(pho);


JLabel spacer6=new JLabel("  ");
gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(spacer6,gcons);
panel1.add(spacer6);

JLabel spacer7=new JLabel("  ");
gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(spacer7,gcons);
panel1.add(spacer7);



clo=new JLabel(new ImageIcon("images//contClose.gif"));
ext=new JLabel(new ImageIcon("images//conhelp.gif"));
clo.addMouseListener(this);
ext.addMouseListener(this);

gcons.gridwidth=GridBagConstraints.RELATIVE;
grid.setConstraints(clo,gcons);
panel1.add(clo);

gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(ext,gcons);
panel1.add(ext);


 

///////panet to do
  	
        strid=new String[64];
		strDate=new String[64];
		strDescription=new String[64];
					 
	
		
		int i=0;		
		try
		{			               
				ResultSet rs=st.executeQuery("select * from todolist");
				String id,name;
                while (rs.next())
						{
							strid[i]=rs.getString(1);
							strDate[i]=rs.getString(3);
							strDescription[i]=rs.getString(4);
							
							i=i+1;               
						}

				listDate=new JList(strDate);
				listDesc=new JList(strDescription);
				listid=new JList(strid);
							
				listid.setFixedCellWidth(50);
				listDate.setFixedCellWidth(100);
				listDesc.setFixedCellWidth(250);
				listid.setBackground(green);
				listDate.setBackground(green);
				listDesc.setBackground(green);
				listid.setFont(font);
				listDate.setFont(font);
				listDesc.setFont(font);
				listid.addMouseListener(this);
				
		}
		catch(Exception e)
		{
			System.out.println("fecting problem 222 "+e);
		}

		Font font3 = new  Font ("Times New Roman",Font.BOLD,22);
		JLabel head=new JLabel(new ImageIcon("todo.jpg"));
	
		
		gcons.gridwidth=GridBagConstraints.REMAINDER;
		 gcons.anchor=   GridBagConstraints.NORTHWEST;
         gcons.gridx=0;
         gcons.gridy=0;
         grid.setConstraints(head,gcons);
         paneltodo.add(head);
         head.setFont(font3);
         head.setForeground(Color.yellow);
		

   JPanel  pan=new JPanel();
   JPanel  pan1=new JPanel();
   
       	 gcons.gridwidth=GridBagConstraints.RELATIVE;
		 gcons.anchor=   GridBagConstraints.CENTER;
         gcons.gridx=0;
         gcons.gridy=1;
         grid.setConstraints(pan,gcons);
         paneltodo.add(pan);
         	 
         gcons.gridwidth=GridBagConstraints.RELATIVE;
		 gcons.anchor=   GridBagConstraints.CENTER;
         gcons.gridx=0;
         gcons.gridy=1;
         grid.setConstraints(pan1,gcons);
        panelweek.add(pan1);
         
	schid=new JList();
    listschedule=new JList();
	times=new JList();
	status=new JList();
	
	
     	schid1=new JList();
    	listschedule1=new JList();
		times1=new JList();
		status1=new JList();
	
	
     pan.add(listid);
     pan.add(listDate);
     pan.add(listDesc); 
      pan.add(status);   
      
     listDate.setBorder(new TitledBorder ("Date")); 
     listDesc.setBorder(new TitledBorder ("Description ")); 
     listid.setBorder(new TitledBorder ("ID")); 
 

		
		
    paneltodo.setLayout(grid); 
	paneldaily.setLayout(grid); 
    panelweek.setLayout(grid); 
 	
    dateschedule=new JLabel(dd);
    dateschedule.setFont(font2);
	

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor=   GridBagConstraints.NORTHWEST;
gcons.gridx=0;
gcons.gridy=0;
grid.setConstraints(dateschedule,gcons);
paneldaily.add(dateschedule);


	
JLabel line=new JLabel(new ImageIcon("images//Line.gif"));

//gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor=   GridBagConstraints.NORTHWEST;
gcons.gridx=0;
gcons.gridy=1;
grid.setConstraints(line,gcons);
paneldaily.add(line);
paneldaily.setBackground(green);

JPanel listpanel1=new JPanel();

gcons.anchor= GridBagConstraints.CENTER;
gcons.gridx=1;
gcons.gridy=5;
grid.setConstraints(listpanel1,gcons);
paneldaily.add(listpanel1);
///////////
    strid1=new String[64];
		strDate1=new String[64];
		strDescription1=new String[64];
		stat=new String[64];
		int j=0;
		try
		{			               
				ResultSet rst=st.executeQuery("select * from schedule");
				//String id,name;
                while (rst.next())
						{
							strid1[j]=rst.getString(1);
							stat[j]=rst.getString(2);
							strDate1[j]=rst.getString(4);
							strDescription1[j]=rst.getString(5);
							
							
							j=j+1;               
						}

				times=new JList(strDate1);
				listschedule=new JList(strDescription1);
				schid=new JList(strid1);
				status=new JList(stat);
				
				
		}
		catch(Exception e)
		{
			System.out.println("fecting problem 222 "+e);
		}
		//////////////////////
		listpanel1.setBackground(green);
		listpanel1.add(status);		
		listpanel1.add(schid);
		listpanel1.add(listschedule);
		listpanel1.add(times);
	
	listschedule.setFixedCellWidth(300);
	//listschedule.setFixedCellHeight(20);
	listschedule.setBorder(new TitledBorder ("       Description     "));          
  	
	times.setFixedCellWidth(100);
	//times.setFixedCellHeight(30);  
	times.setBorder(new TitledBorder ("  Time :   ")); 
	
	schid.setFixedCellWidth(50);
//	schid.setFixedCellHeight(30);  
	schid.setBorder(new TitledBorder ("   ID  ")); 
	
	status.setBorder(new TitledBorder ("Status")); 
	status.setFixedCellWidth(50);  
	
	
	/////////weekly Schedule
	
			
	 	strid2=new String[64];
		strDate2=new String[64];
		strDescription2=new String[64];
		stat2=new String[64];
		
		int k=0;
		try
		{			               
				ResultSet rstl=st.executeQuery("select * from schedule order by cdate ");
				//String id,name;
                while (rstl.next())
						{
							strid2[k]=rstl.getString(1);
							stat2[k]=rstl.getString(2);
							strDate2[k]=rstl.getString(3);
							strDescription2[k]=rstl.getString(5);
							
							
							k=k+1;               
						}

				times1=new JList(strDate2);
				listschedule1=new JList(strDescription2);
				schid1=new JList(strid2);
				status1=new JList(stat2);
				
				
		}
		catch(Exception e)
		{
			System.out.println("fecting problem 222 "+e);
		}
		
		
		pan1.add(schid1);
		pan1.add(status1);
		pan1.add(times1);
		pan1.add(listschedule1);
		panelweek.setBackground(green);
		pan1.setBackground(green);
	
		
			
	listschedule1.setFixedCellWidth(300);
	listschedule1.setBorder(new TitledBorder ("       Description     "));          
  	
	times1.setFixedCellWidth(100);
	times1.setBorder(new TitledBorder ("  Time :   ")); 
	
	schid1.setFixedCellWidth(50);
	schid1.setBorder(new TitledBorder ("   ID  ")); 
	
	status1.setBorder(new TitledBorder ("Status")); 
	status1.setFixedCellWidth(50);  
	
			listid.setPreferredSize(new Dimension(200, 450));
		listDate.setPreferredSize(new Dimension(200, 450));
		listDesc.setPreferredSize(new Dimension(200, 450));
	
		schid.setPreferredSize(new Dimension(100, 450));
    	listschedule.setPreferredSize(new Dimension(250, 450));
		times.setPreferredSize(new Dimension(100, 450));
		status.setPreferredSize(new Dimension(100, 450));
	   	schid1.setPreferredSize(new Dimension(100, 450));
    	listschedule1.setPreferredSize(new Dimension(250, 450));
		times1.setPreferredSize(new Dimension(100, 450));
		status1.setPreferredSize(new Dimension(100, 450));
		
	fr.getContentPane().add(main);
	fr.setVisible(true);
	fr.setSize(800,600);
	fr.setLocation(0,70);
}


public void actionPerformed(ActionEvent evt)
	{
		
	}
	
public void mouseMoved(MouseEvent e) {card.show(main2,"Image");}
public void mouseReleased(MouseEvent e) {}
public void mouseExited(MouseEvent e) {}
public void mouseEntered(MouseEvent e){}
public void mouseDragged(MouseEvent e) {}
public void mousePressed(MouseEvent e) 
{
Object obj=e.getSource();

if(obj==contactlist){card.show(main2,"Panel2");}
if(obj==todolist){card.show(main2,"Panel3");}
if(obj==daily){card.show(main2,"Panel4");}
if(obj==weekly){card.show(main2,"Panel5");}
//card.next(main2);
}
 public void mouseClicked(MouseEvent e) 
{
Object ob= e.getSource();
if(ob==listid)
	{
	if (e.getClickCount() == 2)
 	{
	int index = listid.locationToIndex(e.getPoint());
	Object it=listid.getSelectedValue();
	System.out.println("Double clicked on Item " + index );
	JOptionPane.showMessageDialog(null, "Double Clicked on Item Index"+index+" Value is "+it); 
	}
	}
if(ob==contactlist)
{
	contactlist.setForeground(Color.red);
	todolist.setForeground(green);
	daily	.setForeground(green);
	weekly.setForeground(green);
	new11.setVisible(true);
	add1.setVisible(true);
	del1.setVisible(true);
	letter.setVisible(true);
	mail.setVisible(true);
	
	newtodo.setVisible(false);
	edittodo.setVisible(false);
	deltodo.setVisible(false);
	newappt.setVisible(false);
	editapt.setVisible(false);
	delappt.setVisible(false);
}
if(ob==todolist)
{	
contactlist.setForeground(green);
	
	
	todolist.setForeground(Color.red);
	daily	.setForeground(green);
	weekly.setForeground(green);
	new11.setVisible(false);
	add1.setVisible(false);
	del1.setVisible(false);
	letter.setVisible(false);
	mail.setVisible(false);
	newtodo.setVisible(true);
	edittodo.setVisible(true);
	deltodo.setVisible(true);
	newappt.setVisible(false);
	editapt.setVisible(false);
	delappt.setVisible(false);

	
		
}

if(ob==daily)
{
	
	
	new11.setVisible(false);
	add1.setVisible(false);
	del1.setVisible(false);
	letter.setVisible(false);
	mail.setVisible(false);
	newtodo.setVisible(false);
	edittodo.setVisible(false);
	deltodo.setVisible(false);
	newappt.setVisible(true);
	editapt.setVisible(true);
	delappt.setVisible(true);
	contactlist.setForeground(green);
	todolist.setForeground(green);
	daily	.setForeground(Color.red);
	weekly.setForeground(green);

	
}
if(ob==new11)
{
	new viewcontact();}
	if(ob==ext){
	}
	if(ob==clo){out();}
if(ob==weekly)
{


	panelweek.setBackground(green);
	contactlist.setForeground(green);
	todolist.setForeground(green);
	daily	.setForeground(green);
	
}
if(ob==mail){
	Runtime r = Runtime.getRuntime();
    Process p = null;
    try {
    p = r.exec("E://Program Files//Outlook Express//msimn.exe");
    }
    catch (Exception eve) 
    {
      System.out.println(eve);
    }
}
if(ob==letter){new openCover();}
if(ob==newtodo)
	{
		new toDoList();
	}
if (ob==edittodo)
	{}
if(ob==deltodo)
	{
		String zz = JOptionPane.showInputDialog("Enter ID \n Which you want to delete");
		del(zz);
	}

if(ob==newappt)
{new Appointment();}
if(ob==editapt){new Appointment();}
if(ob==delappt){String zz = JOptionPane.showInputDialog("Enter ID \n Which you want to delete");}
if(ob==Viewcalender)
{
	try
	 {
	   p = r.exec("Calendar" );
	   //p.waitFor();
	}
	 catch (Exception excep) {}
 }
 /////
 if(ob==print)
 {
	 new SwingPrinter();


	 }
 ///////
	if(ob==del1)
	{
	String zz = JOptionPane.showInputDialog("Enter Contact ID \n Which you want to delete");
	}

	if(ob==add1)
	{
	int result = JOptionPane.showConfirmDialog(null,"Are You Sure You Want To submit New Contact Details "); 
	if(result == JOptionPane.NO_OPTION) 
		{
		JOptionPane.showMessageDialog(null, "The Current Action is Intruppted"); 
		}
    else
		if(result == JOptionPane.YES_OPTION) 
		   	{
			   try
						{   
							Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
							Connection con;
							con=DriverManager.getConnection("jdbc:odbc:resume","sa","");
							PreparedStatement stat=con.prepareStatement("insert into contactlist Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
							
							stat.setString(1,COMPANY.getText());
							stat.setString(2,ADDRESS.getText());
							stat.setString(3,NAME.getText());
							stat.setString(4,TITLE.getText());
							stat.setString(5,MAIL.getText());
							stat.setString(6,PHONE.getText());
							stat.setString(7,MOBILE.getText());
							stat.setString(8,cn.t1.getText());
							stat.setString(9,cn.t2.getText());
							stat.setString(10,cn.ta1.getText());
							stat.setString(11,cn.ta2.getText());
							stat.setString(12,cn.ta3.getText());
							stat.setString(13,cn.ta4.getText());
							stat.setString(14,cn.ta5.getText());
							stat.setString(15,cn.t3.getText());
							stat.setString(16,cn.t4.getText());
							stat.setString(17,cn.benifit.getText());
							stat.setString(18,cn.expe.getText());
							stat.setString(19,cn.requ.getText());
							stat.setString(20,cn.des.getText());
							stat.executeUpdate();
			
					}					
				catch(Exception exc)
					{	
						System.out.println("Error encountered"+exc);
						
					}					
		   					COMPANY.setText("");
							ADDRESS.setText("");
							NAME.setText("");
							TITLE.setText("");
							MAIL.setText("");
							PHONE.setText("");
							MOBILE.setText("");
							cn.t1.setText("");
							cn.t2.setText("");
							cn.ta1.setText("");
							cn.ta2.setText("");
							cn.ta3.setText("");
							cn.ta4.setText("");
							cn.ta5.setText("");
							cn.t3.setText("");
							cn.t4.setText("");
							cn.benifit.setText("");
							cn.expe.setText("");
							cn.requ.setText("");
							cn.des.setText("");
			}

 	}
}


public void del(String st)
{
	try
	{
		
		Statement stp2;
		stp2=con.createStatement();
		stp2.executeUpdate(" delete from todolist where listcode=?");
		
	}
	catch(Exception r)
	{
		System.out.println(" Del :: "+r);
	}
}
 
  public void out()
{
	int result = JOptionPane.showConfirmDialog(fr," Do You Really  Want To Exit  ");
	if(result == JOptionPane.YES_OPTION) 
		   	{
			   	fr.setVisible(false);
			}
	
}
 
public static void main(String args[])
	{
	contactManager cmgr=new contactManager();
	System.out.println("Main Method");
	}
};
	