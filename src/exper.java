import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class exper extends JFrame implements ActionListener


{
JWindow fr;
//JFrame fr;
JPanel main,panel1,panel2,panel3;
JButton canc,add,save;
JScrollPane scr1;
JLabel lab1,lab2,lab3,lab4,lab5,lab6,lab7,lab8,lab9,lab10,lab11,lab12,lab13,lab14;
JTextField text1,text2,text3,text4,text5;
JTextArea textarea;
JComboBox combo1,combo2,combo3,combo4,combo5,combo6;
JScrollPane scr;
GridBagLayout grid;
GridBagConstraints gcons;
BorderLayout border;
JScrollPane jsp;

public exper()
{
fr= new JWindow();
//fr= new JFrame();
int	v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

textarea= new JTextArea(6,30);
scr= new JScrollPane(textarea,v,h);
main= new JPanel();
panel1= new JPanel();
panel2= new JPanel();
panel3= new JPanel();

border= new BorderLayout();
grid= new GridBagLayout ();
gcons= new GridBagConstraints();

main.setLayout(grid);

lab1= new JLabel("Add a new Work Experience");
lab2= new JLabel("Company Name");
lab3= new JLabel("Company Industary");
lab4= new JLabel("Position Title");
lab5= new JLabel("Position Lavel");
lab6= new JLabel("Job Specialization");
lab7= new JLabel("Date Joined");
lab8= new JLabel("Date Left");
lab9= new JLabel("Monthly Salary (Optional)");
lab10= new JLabel("");
lab11= new JLabel("Work Description " );
lab12= new JLabel("");
lab13= new JLabel("Describe your job or projects completed here ");
lab14= new JLabel("Maximum 3500 characters (Optional)");


text1= new JTextField("1",30);
text2= new JTextField("2",30);
text3= new JTextField("3",5);
text4= new JTextField("4",5);
text5= new JTextField("5",15);



canc = new JButton("Cancel");
add= new JButton("Add Another Experience");
save= new JButton("Save & Done");

canc.addActionListener(this);
add.addActionListener(this);
save.addActionListener(this);

String [] compind={"-","Advertising & Marketing & Promotion / PR","Aerospace & Aviation"," Agricultural","Apparel","Arts & Design","Automotive / Automobile / Vehicle","Banking & Financial Services","BioTechnology & Pharmaceutical","Call Center / IT-Enabled Services","Cargo & Freight Services","Chemical","Computer / Information Technology (Hardware)","Computer / Information Technology (Software)","Construction/Building","Consulting (Business & Management)","Consulting (Science, Engineering & Technical)","Consumer Products","Education","Electrical & Electronics","Entertainment / Media","Environment / Health / Safety","Food Service / Catering / Restaurant","General Trading","Government","Grooming & Deportment","Healthcare / Medical","Heavy Industrial / Machinery / Equipment","Hotel / Hospitality","Human Resources Management / Consulting","Insurance","Journalism","Law / Legal","Library/Museum","Management","Manufacturing","Marine / Aquaculture","Mining","Non-Profit Organisation","Oil / Gas / Petroleum","Others","Plantations","Polymer / Plastic / Rubber","Printing","Property / Real Estate","Publishing","R&D","Sales / Business / Trade / Retail / Merchandise","Science & Technology","Semiconductor / Wafer Fabrication","Shipping","Sports","Stockbroking / Securities","Telecommunication","Textiles / Garment","Tobacco","Transportation Services","Travel/Tourism","Utilities","Wood & Fibre"};
String [] poslavel={"-","Senior Manager","Manager","Senior Executive","Junior Executive","Fresh / Entry Level"};
String [] jobspl={"-","Actuarial Science/Statistics","Advertising Client Servicing/Media Planning","Agriculture/Forestry/Fisheries","Architecture/Interior Design","Arts/Creative/Graphics Design","Aviation","Banking/Financial Services","Biotechnology","Chemistry","Clerical/General Administration","Customer Service","Education","Engineering - Chemical","Engineering - Civil/Construction","Engineering - Electrical","Engineering - Electronics/Communication","Engineering - Environmental, Health & Safety","Engineering - Mechanical","Engineering - Oil/Gas","Engineering - Others","Entertainment/Media","Finance - Audit/Taxation/Professional Services","Finance - Corporate Finance/Investment Banking","Finance - General/Cost Accounting","Food Technology/Nutritionist","Food/Beverage/Restaurant Service","Freight/Shipping/Logistics","General Work","Geology/Geophysics","Healthcare - Diagnosis/Others","Healthcare - Pharmacy","Healthcare - Practitioner/Nurses/Medical Asst","Hotel/Tourism","Human Resources","IT/Computer - Hardware","IT/Computer - Network/System/Database Administrator","IT/Computer - Software","Journalist/Editor","Lawyer & Legal Assistants","Maintenance/Repair (Facilities & Machinery)","Manufacturing/Production Operations","Marketing/Business Development","Others","Personal Care/Service","Process Control & Instrumentation","Publishing & Printing","Purchasing/Inventory/Material Management","Quality Control/Assurance/Inspection","Quantity Surveying","Sales-Corporate/Wholesale/Trading/Merchandising","Sales-Engineering/Technical/IT","Sales-Insurance","Sales-Retail/General","Science & Technology/Laboratory","Secretarial","Security/Armed Forces/Protective Services","Social Services","Training & Development"};
String [] djoin={"-","January","Feburary","March","April","May","June","July","August","September","October","November","December"};
String []dleft={"Present","January","Feburary","March","April","May","June","July","August","September","October","November","December"};
String [] sala={"Indian Rupees","Australian Dollar","British Pound","Chinese RenMinBi","Euro","HongKong Dollar","Indonesian Rupiah","Japanese Yen","Malaysian Ringgit","Philippine Peso","Singapore Dollar","Thai Baht","US Dollars"};

combo1= new JComboBox(compind);
combo2= new JComboBox(poslavel);
combo3= new JComboBox(jobspl);
combo4= new JComboBox(djoin);
combo5= new JComboBox(dleft);
combo6= new JComboBox(sala);

panel1.add(combo4);
panel1.add(new JLabel("-"));
panel1.add(text3);
panel1.add(new JLabel("(YYYY)"));


panel2.add(combo5);
panel2.add(new JLabel("-"));
panel2.add(text4);
panel2.add(new JLabel("(YYYY)"));

panel3.add(combo6);
panel3.add(new JLabel("  "));
panel3.add(text5);

gcons.anchor= GridBagConstraints.NORTH;
gcons.gridx=1;
gcons.gridy=0;
grid.setConstraints(lab1,gcons);
main.add(lab1);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=5;
grid.setConstraints(lab2,gcons);
main.add(lab2);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=5;
grid.setConstraints(text1,gcons);
main.add(text1);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=8;
grid.setConstraints(lab3,gcons);
main.add(lab3);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=8;
grid.setConstraints(combo1,gcons);
main.add(combo1);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=11;
grid.setConstraints(lab4,gcons);
main.add(lab4);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=11;
grid.setConstraints(text2,gcons);
main.add(text2);



gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=14;
grid.setConstraints(lab5,gcons);
main.add(lab5);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=14;
grid.setConstraints(combo2,gcons);
main.add(combo2);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=17;
grid.setConstraints(lab6,gcons);
main.add(lab6);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=17;
grid.setConstraints(combo3,gcons);
main.add(combo3);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=20;
grid.setConstraints(lab7,gcons);
main.add(lab7);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=20;
grid.setConstraints(panel1,gcons);
main.add(panel1);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=23;
grid.setConstraints(lab8,gcons);
main.add(lab8);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=23;
grid.setConstraints(panel2,gcons);
main.add(panel2);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=26;
grid.setConstraints(lab9,gcons);
main.add(lab9);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=26;
grid.setConstraints(panel3,gcons);
main.add(panel3);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=30;
grid.setConstraints(lab11,gcons);
main.add(lab11);


gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=30;
grid.setConstraints(lab13,gcons);
main.add(lab13);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=33;
grid.setConstraints(scr,gcons);
main.add(scr);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=36;
grid.setConstraints(lab14,gcons);
main.add(lab14);

JPanel butt= new JPanel();
butt.add(canc);
butt.add(add);
butt.add(save);
gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=40;
grid.setConstraints(butt,gcons);
main.add(butt);
main.setBackground(new Color(173,214,255));

scr1=new JScrollPane(main);
fr.setVisible(true);
fr.setSize(550,450);
fr.getContentPane().add(scr1);
fr.setLocation(200,50);

panel1.setBackground(new Color(173,214,255));
panel2.setBackground(new Color(173,214,255));
panel3.setBackground(new Color(173,214,255));
scr.setBackground(new Color(173,214,255));
butt.setBackground(new Color(173,214,255));
}
public void actionPerformed(ActionEvent t)
{
Object ob=t.getSource();
if (ob==save)
{
fr.setVisible(false);
connect();
}
if(ob==canc)
	{
		fr.setVisible(false);
	}

if(ob==add)
{
fr.setVisible(false);
new exper ();
connect();
}
}

public void connect()
{
	String combine1=combo4.getSelectedItem()+" "+ text3.getText();
String combine2=combo5.getSelectedItem()+" "+ text4.getText();
String combine3=combo6.getSelectedItem()+" "+ text5.getText();
{
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection cn;
			cn=DriverManager.getConnection("jdbc:odbc:resume","sa","");
			PreparedStatement stat=cn.prepareStatement("insert into Experience Values(?,?,?,?,?,?,?,?,?)");
			
			stat.setString(1,text1.getText());
			stat.setString(2,(String)combo1.getSelectedItem());
			stat.setString(3,text2.getText());
			stat.setString(4,(String)combo2.getSelectedItem());
			stat.setString(5,(String)combo3.getSelectedItem());
			stat.setString(6,combine1);
			stat.setString(7,combine2);
			stat.setString(8,combine3);
			stat.setString(9,textarea.getText());
		
			stat.executeUpdate();
			}
		catch(Exception e)
			{
			System.out.print(e);
			JOptionPane.showMessageDialog(null,"Error Occured While data submitted in database","Database Error",JOptionPane.WARNING_MESSAGE);


			}
		};}
public static void main(String a[])
{
new exper ();
}
}		