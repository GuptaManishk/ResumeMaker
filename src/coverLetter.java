import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;
import java.io.*;


public class coverLetter extends JFrame implements ActionListener
{
	CardLayout card;
	JFrame frame;
	JFrame framemain;
	JPanel main,sub1,sub2;
    JPanel newcontact,heading,address,greeting,openingpara,bodypara;
    JPanel closingpara,closing,enclosure,finalpanel;
	GridBagLayout grid;
	GridBagConstraints gcons;
	BorderLayout border;
	JPanel west;
	//For newcontact panel
	JTextField tcompname,turname,tmailid,tcellu,tphonenum,tfax;	
	JTextArea taddr;
	JButton nxt,clo,prv,last;
	
	JButton sve,clos,print;
//For heading panel
	JTextArea thead,taddress,tgreet,topening,tbody,tclose,tclosing,tenclosure;

public static void main(String arg[])
{
coverLetter cover = new coverLetter();
}	
	public coverLetter()
	{	
	framemain = new JFrame();
	main=new JPanel();
	sub1=new JPanel();
	sub2=new JPanel();
	
	ImageIcon image = new ImageIcon("save.gif");
	west=new JPanel();
	west.add(new JLabel(new ImageIcon("gudletter.jpg")));
	west.setBackground(new Color(66,132,255));
	sub2.setBackground(new Color(66,132,255));	newcontact = new JPanel();
		heading = new JPanel();
		address = new JPanel();
		greeting = new JPanel();
		openingpara = new JPanel();
		bodypara = new JPanel();
		closingpara = new JPanel();
		closing = new JPanel();
		enclosure = new JPanel();
		finalpanel = new JPanel();
		Color colo=new Color(240,240,240);
heading.setBackground(Color.white);
address.setBackground(Color.white);
greeting.setBackground(Color.white);
openingpara.setBackground(Color.white);
bodypara.setBackground(Color.white);
closingpara.setBackground(Color.white);
closing.setBackground(Color.white);
enclosure.setBackground(Color.white);
finalpanel.setBackground(Color.white);
newcontact.setBackground(Color.white);	
		border= new BorderLayout();
		grid=new GridBagLayout ();
		gcons=new GridBagConstraints ();
		
		main.setLayout(border);
		main.add(sub1,BorderLayout.CENTER);
		main.add(west,BorderLayout.WEST);
		main.add(sub2,BorderLayout.SOUTH);

		int	v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;

JScrollPane pn = new JScrollPane(newcontact,v,h);
JScrollPane pn1 = new JScrollPane(heading,v,h);
JScrollPane pn2 = new JScrollPane(address,v,h);
JScrollPane pn3 = new JScrollPane(greeting,v,h);
JScrollPane pn4 = new JScrollPane(openingpara,v,h);
JScrollPane pn5 = new JScrollPane(bodypara,v,h);
JScrollPane pn6 = new JScrollPane(closingpara,v,h);
JScrollPane pn7 = new JScrollPane(closing,v,h);
JScrollPane pn8 = new JScrollPane(enclosure,v,h);


//For newcontact panel
    
    

		tcompname = new JTextField("Prestige Indore",20);
		turname = new JTextField("Manish Kumar",20);
		tmailid = new JTextField("sal_manishkr@yahoo.com",20);
		tcellu = new JTextField("9893349566",20);
		tphonenum = new JTextField("0731-2559625",20);
		tfax = new JTextField("0731-2548845",20);
		taddr = new JTextArea("House No: 11/2, \n Vijay Nager, Indore",4,63);

		
		String ss="_______________ (company) is a world-class leader in _______________ (field), is very well-respected, and known for its great products and services.  Particularly appealing is your strong team structure, cooperation within the firm, and commitment to furthering your employees' education.  ";
		String ss1="With my _______________ (number) year _______________ (field) background, I have the depth of experience it takes to make positive contributions. Of key importance has been my ability to handle day-to-day issues while planning and implementing future programs and systems. Some of my achievements are:";
		String ss2=" \n·	_______________________________________________\n ·	_______________________________________________\n ·	_______________________________________________";
		String ss3="I will contact your office next week to inquire about the possibility of interviewing with you.  In the meantime, please do not hesitate to contact me at _______________ (phone).";



		thead= new JTextArea(20,62);
		taddress= new JTextArea(20,62);
		tgreet= new JTextArea(ss,20,62);
		topening= new JTextArea(ss1,20,62);
		tbody= new JTextArea(ss2,20,62);
		tclose= new JTextArea(ss3,20,62);
		tclosing= new JTextArea("Yours Sincerely,\n\n ",20,62);
		tenclosure= new JTextArea("Enclosures\n\n\n\n",20,62);
		
		
		thead.setLineWrap(true);
		taddress.setLineWrap(true);
		tgreet.setLineWrap(true);
		topening.setLineWrap(true);
		tbody.setLineWrap(true);
		tclose.setLineWrap(true);
		tclosing.setLineWrap(true);
		tenclosure.setLineWrap(true);
		
		
		
Border bb = BorderFactory.createLineBorder(Color.black,1);
  
		taddr.setBorder(bb);
		thead.setBorder(bb);
		taddress.setBorder(bb);
		tgreet.setBorder(bb);
		topening.setBorder(bb);
		tbody.setBorder(bb);
		tclose.setBorder(bb);
		tclosing.setBorder(bb);
		tenclosure.setBorder(bb);
		
		  
newcontact.setLayout(grid);
newcontact.setBorder(new TitledBorder ("Letter Recipient Information")); 


tcompname.setBorder(new TitledBorder ("Company Name")); 
gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.WEST;
grid.setConstraints(tcompname,gcons);
newcontact.add(tcompname);

turname.setBorder(new TitledBorder ("Your Name")); 
gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.WEST;
grid.setConstraints(turname,gcons);
newcontact.add(turname);

taddr.setBorder(new TitledBorder ("Address"));
gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.WEST;
grid.setConstraints(taddr,gcons);
newcontact.add(taddr);

tmailid.setBorder(new TitledBorder ("E-Mail")); 
gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.WEST;
grid.setConstraints(tmailid,gcons);
newcontact.add(tmailid);

tcellu.setBorder(new TitledBorder ("Mobile Number")); 
gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.WEST;
grid.setConstraints(tcellu,gcons);
newcontact.add(tcellu);

tphonenum.setBorder(new TitledBorder ("Phone Number")); 
gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.WEST;
grid.setConstraints(tphonenum,gcons);
newcontact.add(tphonenum);

tfax.setBorder(new TitledBorder ("Fax")); 
gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.WEST;
grid.setConstraints(tfax,gcons);
newcontact.add(tfax);

//newcontact ended


//for heading panel
heading.add(thead);
heading.setBorder(new TitledBorder ("Heading Format")); 


address.add(taddress);
address.setBorder(new TitledBorder ("Address Format")); 


greeting.add(tgreet);
greeting.setBorder(new TitledBorder ("Greeting"));


openingpara.add(topening);
openingpara.setBorder(new TitledBorder ("Opening Paragraph"));


bodypara.add(tbody);
bodypara.setBorder(new TitledBorder ("Body Paragraph"));


closingpara.add(tclose);
closingpara.setBorder(new TitledBorder ("Closing Paragraph"));


closing.add(tclosing);
closing.setBorder(new TitledBorder ("Closing"));


enclosure.add(tenclosure);
enclosure.setBorder(new TitledBorder ("Enclosure"));



JPanel finish=new JPanel();
finish.add(new JLabel(new ImageIcon("images//finish.jpg")));
card=new CardLayout();

prv=new JButton(new ImageIcon("images//bck1.gif"));
nxt=new JButton(new ImageIcon("images//bck2.gif"));
clo=new JButton(new ImageIcon("images//bck4.gif"));
last=new JButton(new ImageIcon("images//bck3.gif"));

Color green1=new Color(68,130,251);
Border lineb = BorderFactory.createLineBorder(green1);
prv.addActionListener(this);
nxt.addActionListener(this);
clo.addActionListener(this);
last.addActionListener(this);

prv.setBackground(green1);
nxt.setBackground(green1);
clo.setBackground(green1);
last.setBackground(green1);

prv.setBorder(lineb);
nxt.setBorder(lineb);
clo.setBorder(lineb);
last.setBorder(lineb);
sub2.add(prv);
sub2.add(nxt);
sub2.add(clo);
sub2.add(last);

finalpanel.add(new JLabel(new ImageIcon("images//Finish.jpg")));
sub1.setLayout(card);
sub1.add(newcontact,"p1");
sub1.add(heading,"p2");
sub1.add(address,"p3");
sub1.add(greeting,"p4");
sub1.add(openingpara,"p5");
sub1.add(bodypara,"p6");
sub1.add(closingpara,"p7");
sub1.add(closing,"p8");
sub1.add(enclosure,"p9");
sub1.add(finalpanel,"p10");
sub1.setBorder(new TitledBorder(new MatteBorder(new ImageIcon("border.jpg"))));
		framemain.getContentPane().add(main);
		
		framemain.setVisible(true);
		framemain.setLocation(0,70);
		framemain.setSize(800,490);
}

void  letterPreview()
{
frame=new JFrame("Cover Letter Preview");
JPanel panel =new JPanel();
JTextArea ta=new JTextArea(30,100);
ta.setLineWrap(true);

JScrollPane ja=new JScrollPane(ta);
ta.setText("Manish Kumar\n"+"<Your Address>\n"+"<City>, <State/Province> <PostalCode>\n"+"<Phone>\n"+"<E-Mail>\n\n\n"+"November 25, 2004\n\n"+turname.getText()+"\n\n"+tcompname .getText()+"\n\n"+taddr.getText()+"\n\n"+"\n\nDear Mr./Miss "+turname.getText()+"\n\n"+thead.getText()+"\n\n"+taddress.getText()+"\n\n"+tgreet.getText()+"\n\n"+topening.getText()+"\n\n"+tbody.getText()+"\n\n"+tclose.getText()+"\n\n"+tclosing.getText()+"\n\n"+tenclosure.getText());
JToolBar tb=new JToolBar();
border=new BorderLayout();
panel.add(ja);
print=new JButton("Print");
clos=new JButton("Close");
sve=new JButton("Save");
print.addActionListener(this);
clos.addActionListener(this);
sve.addActionListener(this);
tb.add(print);
tb.add(sve);
tb.add(clos);
frame.getContentPane().add(tb, BorderLayout.NORTH);
frame.getContentPane().add(panel, BorderLayout.CENTER);
frame.setVisible(true);
frame.setSize(499,300);
}


public void actionPerformed(ActionEvent event)
	 {
    JButton source = (JButton)event.getSource();

    if(source==sve){FileDialog fd=new FileDialog(frame,"Save Cover Letter",FileDialog.SAVE);
		   		fd.setVisible(true);};
    if(source==clos){frame.setVisible(false);};
    if(source==print){new SwingPrinter();};
 	if (source == nxt)
      	card.next(sub1);
    else if (source == prv)card.previous(sub1);
   else if (source == last)
   {
	 card.last(sub1);
    letterPreview();
	}
    else if(source==clo)
    {	int result = JOptionPane.showConfirmDialog(framemain," Do You Really  Want To Exit  ");
	if(result == JOptionPane.YES_OPTION) 
		   	{
			   	framemain.setVisible(false);
			}}
      }
 

	}



