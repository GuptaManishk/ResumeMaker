import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;
public class resumeBuilder extends JFrame implements ActionListener
{
	
JFrame swingframe;

JPanel frm,frmpanel1,frmpanel2;

GridBagLayout grid;
GridBagConstraints gcons;
CardLayout card;
Color co1,co2;
JPanel finalpanel;

//Varibels for resume page 1
JPanel panel4,panelmain,panel1,panel2,panel3,paneldob,panelgender,panelmarital,imgpdet;
JPanel lastpanel;
JButton next,back,cncle,finish;
BorderLayout border;
JTextField tfname,tlname,tyear,tpmail,tamail,tmobile,ttele,tadd1,tpostal,tcity;
JComboBox combodate,combomonth,comboNational,combocountry,combostate;
JComboBox chkgender,chkmatrial;

JLabel PerDetails,fname,lname,dob,gender,marital,national,pemail,aemail,mobile,phone,postal,country,state,city,addre;

//varibels for resume page2
JPanel mainPanel,sub1,sub2,sub3;
JTextField  tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;
JTextField subtext1,subtext2,subtext3,subtext4;
JComboBox cb1,cb3,cb4,cb5,cb6,cb8,cb9,cb10;
JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12,lb13,lb14,lb15,lb16,lb17,lb18,lb19,lb20;

//varibels for page3
JPanel pnmain,pn,pn1,pn2,submain;
JLabel lb111,lb21,lb31,lb41,blk,l1,l2,l3,blk1,lb211;
JTextField t1,t2,t3,t4,t5,t6;

//varibels for page 4
ButtonGroup  chkexp;
JTextField first,second;
JButton addexp;
JPanel experiencePanel,subexp,buttonpanel;
JLabel labelexp;
JRadioButton fresh,experienced;
JPanel exmainpan;

//varibels for page5 
JPanel skillMainPanel,skillPanel1,skillPanel2,skillPanel3,skillPanel4;
JLabel skillLabel1,skillLabeskillNoLabel2,skillLabeskillNoLabel3,skillLabeskillNoLabel4,skillBlanklabel,labs1,skillNoLabel2,skillNoLabel3,skillNoLabel4,skillNoLabel5,skillBlanklabel1,skillLabeskillNoLabel21,skillLabeskillNoLabel211,spc1,spc2,spc3,lpro;
JTextField skillText1,skillText2,skillText3,skillText4,skillText5;
JComboBox skillCombo1,skillCombo11,skillCombo12,skillCombo13,skillCombo14;
JComboBox skillCombo2,skillCombo21,skillCombo22,skillCombo23,skillCombo24;


//varibles for page 6
JPanel LanguagesMainPanel,LanguagesPaneLanguagesLabel1,LanguagesPanel2,LanguagesPanel3,LanguagesPanel4;
JLabel LanguagesLabeLanguagesLabel1,LanguagesLabeLanguagesNoLabel2,LanguagesLabeLanguagesNoLabel3,LanguagesLabeLanguagesNoLabel4,LanguagesBlanklabel,LanguagesLabel1,LanguagesNoLabel2,LanguagesNoLabel3,LanguagesNoLabel4,LanguagesNoLabel5,LanguagesBlanklabeLanguagesLabel1,LanguagesLabeLanguagesNoLabel21,LanguagesLabeLanguagesNoLabel211,spcl1,spcl2,spcl3,lpro1;
JTextField LanguagesText1,LanguagesText2,LanguagesText3,LanguagesText4,LanguagesText5;
JComboBox LanguagesCombo1,LanguagesCombo11,LanguagesCombo12,LanguagesCombo13,LanguagesCombo14;
JComboBox LanguagesCombo2,LanguagesCombo21,LanguagesCombo22,LanguagesCombo23,LanguagesCombo24;


//varibels for page 7
JPanel addInfoPanel;
JLabel Info1,Info2,Info3,Info4,Info5,Info6,Info7,Info8,Info9,Info10;
JTextArea infoarea1,infoarea2,infoarea3;

//varibels for page 8
JPanel referpanel;
JTextField reftext1,reftext2,reftext3,reftext4,reftext5,reftext6,reftext7,reftext8,reftext9,reftext10,reftext11,reftext12;
JLabel reflabel1,reflabel2,reflabel3,reflabel4,reflabel5,reflabel6,reflabel7,reflabel8,reflabel9,reflabel10,reflabel11,reflabel12,reflabel13,reflabel14,reflabel15,reflabel16,reflabel17;
JScrollPane textscroll,textscroll1,textscroll2;



//JComboBox skillCombo13,skillCombo23,skillCombo14,skillCombo24;

public resumeBuilder()
{
swingframe= new JFrame("Resume Maker [Resume Wizard] ");
	
border= new BorderLayout();

co2= new Color(221,230,237);
co1= new Color(173,214,255);
Border bb = BorderFactory.createLineBorder(co2);
Border bb1 = BorderFactory.createLineBorder(co1);
int	v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;

frm= new JPanel();
frmpanel1= new JPanel();
frmpanel2= new JPanel();
lastpanel=new JPanel();
frm.setBackground(co1);
frmpanel1.setBackground(co1);
frmpanel2.setBackground(co1);
lastpanel.setBackground(co1);
next=new JButton(new ImageIcon("images//bck6.gif"));
back=new JButton(new ImageIcon("images//bck5.gif"));
cncle=new JButton(new ImageIcon("images//bck8.gif"));
finish=new JButton(new ImageIcon("images//bck7.gif"));

next.setBorder(bb1);
back.setBorder(bb1);
cncle.setBorder(bb1);
finish.setBorder(bb1);

frm.setLayout(border);
frmpanel1.setBorder(new LineBorder (co2));
frmpanel2.setBorder(new LineBorder (co2));

frmpanel1.setBackground(co2);
frmpanel2.setBackground(co2);

JScrollPane mainscroll= new JScrollPane(frmpanel2,v,h);
frm.add(frmpanel1,BorderLayout.WEST);    
frm.add(mainscroll,BorderLayout.CENTER); 
frm.add(lastpanel,BorderLayout.SOUTH); 
lastpanel.add(back);
lastpanel.add(next);
lastpanel.add(finish);
lastpanel.add(cncle);

next.addActionListener(this);
back.addActionListener(this);
cncle.addActionListener(this);
finish.addActionListener(this);
frmpanel1.add(new JLabel(new ImageIcon("images//guidedresume.jpg")));
lastpanel.setBackground(new Color(173,214,255));
frmpanel1.setBackground(new Color(65,129,255));
//resuems

panelmain= new JPanel();panelmain.setBackground(co1);
imgpdet= new JPanel();imgpdet.setBackground(co1);
paneldob= new JPanel();paneldob.setBackground(co1);
panelgender= new JPanel();panelgender.setBackground(co1);
panelmarital= new JPanel();panelmarital.setBackground(co1);


border= new BorderLayout();
grid= new GridBagLayout ();
gcons= new GridBagConstraints();

panelmain.setLayout(grid);
String gen []={"-----","Male","Female"};
chkgender= new JComboBox(gen);
String mar []={"-----","Single","Married"};
chkmatrial= new JComboBox(mar);

tfname=new JTextField("FName",30);
tlname=new JTextField("LName",30);
tyear=new JTextField("Year",5);
tpmail=new JTextField("Mail1",25);
tamail=new JTextField("Mail2",25);
tmobile=new JTextField("Mobile",15);
ttele=new JTextField("tele",15);
tadd1=new JTextField("Address",30);
tpostal=new JTextField("Postal",10);
tcity=new JTextField("city",30);



PerDetails=new JLabel(new ImageIcon("images//p1.gif"));
fname=new JLabel("First Name"); 
lname=new JLabel("Last Name"); 
dob=new JLabel("Date Of Birth"); 
gender=new JLabel("Gender"); 
marital=new JLabel("        Marital Status");
national=new JLabel("Nationallity"); 
JLabel contactinfo=new JLabel(new ImageIcon("images//p2.gif"));
pemail=new JLabel("Primary E-Mail"); 
aemail=new JLabel("Alternate E-Mail"); 
mobile=new JLabel("Mobile No"); 
phone=new JLabel("Phone No"); 
postal=new JLabel("Postal Code"); 
country=new JLabel("Country"); 
state=new JLabel("State / Region"); 
city=new JLabel("City"); 
addre= new JLabel("Address");

fname.setForeground(Color.black);
lname.setForeground(Color.black);
dob.setForeground(Color.black);
gender.setForeground(Color.black);
marital.setForeground(Color.black);
national.setForeground(Color.black);

pemail.setForeground(Color.black);
aemail.setForeground(Color.black);
mobile.setForeground(Color.black);
phone.setForeground(Color.black);
postal.setForeground(Color.black);
country.setForeground(Color.black);
state.setForeground(Color.black);
city.setForeground(Color.black);
addre.setForeground(Color.black);

String dated []={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
combodate=new JComboBox(dated);

String nation []={"-","Afghanistan","Albania","Algeria","American Samoa","Andorra","Angola","Anguilla","Antarctica","Antigua and Barbuda","Argentina","Armenia","Aruba","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bagladesh","Barbados","Belarus","Belgium","Belize","Benin","Bermuda","Bhutan","Bolivia","Bosnia Herzegovina","Botswana","Bouvet Island","Brazil","British Indian Ocean Territory","Brunei Darussalam","Bulgaria","Burkina Faso","Burundi","Cambodia","Cameroon","Canada","Cape Verde","Cayman Islands","Central African Republic","Chad","Chile","China","Christmas Island","Cocoas (Keeling) Islands","Colombia","Comoros","Congo","Cook Islands","Costa Rica","Cote D&#39;ivoire","Croatia","Cuba","Cyprus","Czech Republic","Denmark","Djibouti","Dominica","Dominican Republic","East Timor","Ecuador","Egypt","EL Salvador","Equatorial Guinea","Eritrea","Estonia","Ethiopia","Falkland Islands (Malvinas)","Faroe Islands","Fiji","Finland","France","French Guiana","French Polynesia","French Southern Territories","Gabon","Gambia","Georgia","Germany","Ghana","Gibraltar","Greece","Greenland","Grenada","Guadeloupe","Guam","Guatemala","Guinea","Guinea-Bissau","Guyana","Haiti","Heard and Mc Donald Islands","Honduras","Hong Kong","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Israel","Italy","Jamaica","Japan","Jordan","Kazakhstan","Kenya","Kiribati","Korea (North)","Korea (South)","Kuwait","Kyrgyzstan","Laos","Latvia","Lebanon","Lesotho","Liberia","Libyan Arab Jamahiriya","Liechtenstein","Lithuania","Luxembourg","Macau","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands","Martinique","Mauritania","Mauritius","Mayotte","Mexico","Micronesia","Monaco","Mongolia","Montserrat","Morocco","Mozambique","Myanmar","Namibia","Nauru","Nepal","Netherlands","Netherlands Antilles","New Caledonia","New Zealand","Nicaragua","Niger","Nigeria","Nile","Norfolk Island","Northern Mariana Islands","Norway","Oman","Others","Pakistan","Palau","Palestinian Territory, Occupied","Panama",
"Papua New Guinea","Paraguay","Peru","Philippines","Pitcairn","Poland","Portugal","Puerto Rico","Qatar","Republic Of Moldova","Reunion","Romania","Russia","Rwanda","Saint Kitts And Nevis","Saint Lucia","Saint Vincent and The Grenadines","Samoa","San Marino","Sao Tome and Principe","Saudi Arabia","Senegal","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","Solomon Islands","Somalia","South Africa","South Georgia And South Sandwich Islands","Spain","Sri Lanka","St. Helena","St. Pierre and Miquelon","Sudan","Suriname","Svalbard and Jan Mayan Islands","Swaziland","Sweden","Switzerland","Syrian Arab Republic","Taiwan","Tajikistan","Tanzania","Thailand","TOGO","Tokelau","Tonga","Trinidad and Tobago","Tunisia","Turkey","Turkmenistan","Turks and Calicos Islands","Tuvalu","Uganda","Ukraine","United Arab Emirates","United Kingdom","United States","United States Minor Outlying Islands","Uruguay","Uzbekistan","Vanuatu","Vatican City State (Holy See)","Venezuela","Vietnam","Virgin Islands (British)","Virgin Islands (U.S.)","Wallis and Fortuna Islands","Western Sahara","Yemen","Yugoslavia","Zaire","Zambia","Zimbabwe"};
 comboNational=new JComboBox(nation);

String month []={"January","Feburary","March","April","May","June","July","August","September","October","November","December"};
combomonth=new JComboBox(month);

String cont []={"1","2"};
//combocountry=new JComboBox(cont);
combocountry=new JComboBox(nation);

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
combostate=new JComboBox(stat);



panelgender.add(chkgender);

paneldob.add(combodate);
paneldob.add(new JLabel (" -- "));
paneldob.add(combomonth);
paneldob.add(new JLabel (" -- "));
paneldob.add(tyear);
paneldob.add(new JLabel("(YYYY)"));

panelmarital.add(chkmatrial);


gcons.anchor= GridBagConstraints.CENTER;
gcons.gridx=1;
gcons.gridy=0;
grid.setConstraints(PerDetails,gcons);

gcons.anchor= GridBagConstraints.NORTH;
gcons.gridx=1;
gcons.gridy=5;
grid.setConstraints(imgpdet,gcons);


gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=8;
grid.setConstraints(fname,gcons);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=8;
grid.setConstraints(tfname,gcons);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=11;
grid.setConstraints(lname,gcons);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=11;
grid.setConstraints(tlname,gcons);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=14;
grid.setConstraints(dob,gcons);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=14;
grid.setConstraints(paneldob,gcons);


gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=17;
grid.setConstraints(gender,gcons);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=17;
grid.setConstraints(panelgender,gcons);



gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=5;
gcons.gridy=17;
grid.setConstraints(marital,gcons);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=7;
gcons.gridy=17;
grid.setConstraints(panelmarital,gcons);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=23;
grid.setConstraints(national,gcons);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=23;
grid.setConstraints(comboNational,gcons);


gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=24;
grid.setConstraints(contactinfo,gcons);
panelmain.add(contactinfo);


gcons.gridx=1;
gcons.gridy=26;
grid.setConstraints(pemail,gcons);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=26;
grid.setConstraints(tpmail,gcons);


gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=29;
grid.setConstraints(aemail,gcons);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=29;
grid.setConstraints(tamail,gcons);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=32;
grid.setConstraints(mobile,gcons);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=32;
grid.setConstraints(tmobile,gcons);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=35;
grid.setConstraints(phone,gcons);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=35;
grid.setConstraints(ttele,gcons);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=38;
grid.setConstraints(phone,gcons);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=38;
grid.setConstraints(ttele,gcons);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=41;
grid.setConstraints(addre,gcons);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=41;
grid.setConstraints(tadd1,gcons);


gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=44;
grid.setConstraints(postal,gcons);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=44;
grid.setConstraints(tpostal,gcons);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=47;
grid.setConstraints(country,gcons);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=47;
grid.setConstraints(combocountry,gcons);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=50;
grid.setConstraints(state,gcons);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=50;
grid.setConstraints(combostate,gcons);


gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=53;
grid.setConstraints(city,gcons);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=53;
grid.setConstraints(tcity,gcons);

panelmain.add(imgpdet);
imgpdet.add(new JLabel(new ImageIcon("as.jpg")));

panelmain.add(PerDetails);
panelmain.add(fname);
panelmain.add(lname);
panelmain.add(tfname);
panelmain.add(tlname);

panelmain.add(dob);
panelmain.add(gender);


panelmain.add(national);
panelmain.add(pemail);
panelmain.add(aemail);
panelmain.add(mobile);
panelmain.add(phone);
panelmain.add(postal);
panelmain.add(country);
panelmain.add(state);
panelmain.add(city);



panelmain.add(tpmail);
panelmain.add(tamail);
panelmain.add(tmobile);
panelmain.add(ttele);
panelmain.add(addre);
panelmain.add(tadd1);
panelmain.add(tpostal);
panelmain.add(tcity);
panelmain.add(panelgender);
panelgender.add(marital);
panelgender.add(panelmarital);
panelmain.add(paneldob);

panelmain.add(comboNational);
panelmain.add(combocountry);
panelmain.add(combostate);
panelmain.setSize(200,300);

 JScrollPane jsp= new JScrollPane(panelmain,v,h);   

//page2


mainPanel= new JPanel();
sub1= new JPanel();
sub2= new JPanel();
sub3= new JPanel();
mainPanel.setBackground(co1);
sub1.setBackground(co1);
sub2.setBackground(co1);
sub3.setBackground(co1);
//JScrollPane jsp1= new JScrollPane(sub2,v,h);
mainPanel.setLayout(border);
sub2.setLayout(grid);
sub3.setLayout(grid);
mainPanel.add(sub1,BorderLayout.WEST);    
mainPanel.add(sub2,BorderLayout.CENTER); 
mainPanel.add(sub3,BorderLayout.SOUTH);    

lb1= new JLabel(new ImageIcon("images//p3.gif"));
lb2= new JLabel("Higest Lavel");
lb3= new JLabel("If CGPA/Percentage, please enter score:");
lb4= new JLabel("Major");
lb5= new JLabel("Grade");
lb6= new JLabel("Institute/ University");
lb7= new JLabel("Located In");
lb8= new JLabel("Graduation Date");
lb9= new JLabel("Enter Expected Graduation Date if still pursuing");

lb10= new JLabel(new ImageIcon("images//p4.gif"));
lb11= new JLabel("2nd Higest Lavel");
lb12= new JLabel("If CGPA/Percentage, please enter score:");
lb13= new JLabel("Major");
lb14= new JLabel("Grade");
lb15= new JLabel("Institute / University");
lb16= new JLabel("Located In");
lb17= new JLabel("Graduation Date");
lb18= new JLabel(new ImageIcon("images//p5.gif"));lb18.setBackground(co1);
lb19= new JLabel();
lb20= new JLabel();


lb1.setForeground(Color.black);lb2.setForeground(Color.black);lb3.setForeground(Color.black);lb4.setForeground(Color.black);lb5.setForeground(Color.black);lb6.setForeground(Color.black);lb7.setForeground(Color.black);lb8.setForeground(Color.black);lb9.setForeground(Color.black);lb10.setForeground(Color.black);lb11.setForeground(Color.black);lb12.setForeground(Color.black);lb13.setForeground(Color.black);lb14.setForeground(Color.black);lb15.setForeground(Color.black);lb16.setForeground(Color.black);lb17.setForeground(Color.black);lb18.setForeground(Color.black);lb19.setForeground(Color.black);lb20.setForeground(Color.black);


tf1=new JTextField("1",30);
tf2=new JTextField("2",30);
tf3=new JTextField("3",5);
//tf4=new JTextField("4",25);
tf5=new JTextField("5",25);
tf6=new JTextField("6",15);
tf7=new JTextField("7",15);
//tf8=new JTextField("8",30);
//tf9=new JTextField("9",30);
//tf10=new JTextField("10",10);
subtext1=new JTextField("11",5);
subtext2=new JTextField("12",5);
subtext3=new JTextField("13",5);
subtext4=new JTextField("14",5);


String [] higest={"-","X Standard (Secondary School)","XII Standard (Higher Secondary/Junior College)","Vocational Training/ITI (Professional Certification)","Diploma (3 years)","Advanced Diploma","Bachelor of Art (B.A)","Bachelor of Commerce (B.Com)","Bachelor of Science (B.Sc)","Bachelor of Architecture (B.Arch)","Bachelor of Business Administration (BBA)","Bachelor of Computer Application (BCA)","Bachelor of Dental Surgery (BDS)","Bachelor of Engineering/Technology (B.E/B.Tech) or Equivalent","Bachelor of Hotel Management (BHM)","Bachelor of Law (LLB)","Bachelor of Medicine/Surgery (MBBS)","Bachelor of Pharmacy (B.Pharm)","Master of Art (M.A)","Master of Commerce (M.Com)","Master of Computer Application/Computer Science (MCA/MCS)","Master of Science (M.Sc)","Master of Architecture (M.Arch)","MBA/PGDBA/PGPM or Equivalent","Master of Dentistry (MDS)","Master of Engineering/Techn0ology (M.E/M.Tech) or Equivalent","Master of Law (LLM)","Master of Medicine/Surgery (MD/MS)","Master of Pharmacy (M.Pharm)","Chartered Accountancy (CA)", "Company Secretary (CS)","Institute of Cost Accountancy (ICWA)","Doctorate (PhD)"};

String [] field={"field of study"};

String [] grade={"-","Grade A","Grade B","Grade C","Grade D","1st Class","2nd Class Upper","2nd Class Lower","3rd Class","CGPA/Percentage","Pass/Non-gradable","Fail","Incomplete"};

String [] gdate={"-","January","Feburary","March","April","May","June","July","August","September","October","November","December"};

String [] located={"-","Afghanistan","Albania","Algeria","American 0amoa","Andorra","Angola","Anguilla","Antarctica","Antigua and Barbuda","Argentina","Armenia","Aruba","Australia","Austria","Azerbaijan","Bahamas"};

cb1= new JComboBox(higest);

cb3= new JComboBox(grade);
cb4= new JComboBox(gdate);
cb5= new JComboBox(located);
cb6= new JComboBox(higest);

cb8= new JComboBox(grade);
cb9= new JComboBox(gdate);
cb10= new JComboBox(located);

gcons.anchor= GridBagConstraints.NORTH;
gcons.gridx=1;
gcons.gridy=5;
grid.setConstraints(lb1,gcons);
sub2.add(lb1);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=8;
grid.setConstraints(lb2,gcons);
sub2.add(lb2);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=8;
grid.setConstraints(cb1,gcons);
sub2.add(cb1);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=11;
grid.setConstraints(lb3,gcons);
sub2.add(lb3);
lb3.setBackground(co1);

/*gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=11;
grid.setConstraints(cb2,gcons);
//sub2.add(cb2);
*/
gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=14;
grid.setConstraints(lb4,gcons);
sub2.add(lb4);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=14;
grid.setConstraints(tf1,gcons);
sub2.add(tf1);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=17;
grid.setConstraints(lb5,gcons);
sub2.add(lb5);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=17;
grid.setConstraints(cb3,gcons);
sub2.add(cb3);

JPanel cg= new JPanel();
cg.add(lb3);
cg.add(subtext1);
cg.add(new JLabel("-"));
cg.add(subtext2);
cg.setBackground(co1);
gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=18;
grid.setConstraints(cg,gcons);
sub2.add(cg);



gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=20;
grid.setConstraints(lb6,gcons);
sub2.add(lb6);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=20;
grid.setConstraints(tf2,gcons);
sub2.add(tf2);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=23;
grid.setConstraints(lb7,gcons);
sub2.add(lb7);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=23;
grid.setConstraints(cb5,gcons);
sub2.add(cb5);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=26;
grid.setConstraints(lb8,gcons);
sub2.add(lb8);

//decleartaion for graduation date panel1

JPanel paneldate= new JPanel();
paneldate.setBackground(co1);
paneldate.add(cb4);
paneldate.add(new JLabel("-"));
paneldate.add(tf3);
paneldate.add(new JLabel("(YYYY)"));
//end 



gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=26;
grid.setConstraints(paneldate,gcons);
sub2.add(paneldate);


gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=32;
grid.setConstraints(lb10,gcons);
sub2.add(lb10);


gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=35;
grid.setConstraints(lb11,gcons);
sub2.add(lb11);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=35;
grid.setConstraints(cb6,gcons);
sub2.add(cb6);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=38;
grid.setConstraints(lb12,gcons);
//sub2.add(lb12);

JPanel cg1= new JPanel();
cg1.setBackground(co1);
cg1.add(lb12);
cg1.add(subtext3);
cg1.add(new JLabel("-"));
cg1.add(subtext4);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=38;
grid.setConstraints(cg1,gcons);
sub2.add(cg1);


gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=41;
grid.setConstraints(lb13,gcons);
sub2.add(lb13);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=41;
grid.setConstraints(tf5,gcons);
sub2.add(tf5);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=44;
grid.setConstraints(lb14,gcons);
sub2.add(lb14);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=44;
grid.setConstraints(cb8,gcons);
sub2.add(cb8);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=47;
grid.setConstraints(lb15,gcons);
sub2.add(lb15);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=47;
grid.setConstraints(tf6,gcons);
sub2.add(tf6);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=50;
grid.setConstraints(lb16,gcons);
sub2.add(lb16);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=50;
grid.setConstraints(cb10,gcons);
sub2.add(cb10);



//decleartaion for graduation date panel

JPanel paneldate1= new JPanel();
paneldate1.add(cb9);
paneldate1.add(new JLabel("-"));
paneldate1.add(tf7);
paneldate1.add(new JLabel("(YYYY)"));
paneldate1.setBackground(co1);
//end 

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=53;
grid.setConstraints(lb17,gcons);
sub2.add(lb17);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=53;
grid.setConstraints(paneldate1,gcons);
sub2.add(paneldate1);

//page3
pnmain=new JPanel();
submain=new JPanel();
pn= new JPanel();
pn1=new JPanel();
pn2=new JPanel();
pnmain.setLayout(grid);
submain.setLayout(border);
pn1.setLayout(grid);
pn2.setLayout(grid);
pnmain.setBackground(co1);
submain.setBackground(co1);
pn1.setBackground(co1);
pn2.setBackground(co1);


lb111 = new JLabel(new ImageIcon("images//p5.gif"));
lb21 = new JLabel("e.g. Certified Public Accountant, Chartered Secretary & Administrator,Microsoft Certified Professional,");
lb211= new JLabel(" Sun Certified Java Programmer         ");
lb31 = new JLabel("Certificate Name                                  ");
lb41 = new JLabel("Year Obtained(YYYY)");
blk = new JLabel("  ");
l1 = new JLabel("1.");
l2 = new JLabel("2.");
l3 = new JLabel("3.");

lb21 .setForeground(Color.black);
lb211.setForeground(Color.black);
lb31.setForeground(Color.black);
lb41.setForeground(Color.black);
blk.setForeground(Color.black);
l1.setForeground(Color.black);
l2.setForeground(Color.black);
l3.setForeground(Color.black);


blk1= new JLabel("     ");
t1 = new JTextField(20);
t2 = new JTextField(20);
t3 = new JTextField(20);
t4 = new JTextField(4);
t5 = new JTextField(4);
t6 = new JTextField(4);

pn.add(lb111);
pn.setBackground(co1);
gcons.anchor= GridBagConstraints.CENTER;
gcons.gridx=1;
gcons.gridy=3;
grid.setConstraints(pn,gcons);
pnmain.add(pn);

gcons.anchor= GridBagConstraints.CENTER;
gcons.gridx=1;
gcons.gridy=5;
grid.setConstraints(pn1,gcons);
pnmain.add(pn1);

gcons.anchor= GridBagConstraints.CENTER;
gcons.gridx=1;
gcons.gridy=10;
grid.setConstraints(pn2,gcons);
pnmain.add(pn2);


gcons.anchor= GridBagConstraints.CENTER;
gcons.gridx=1;
gcons.gridy=3;
grid.setConstraints(lb21,gcons);
pn1.add(lb21);

gcons.anchor= GridBagConstraints.CENTER;
gcons.gridx=1;
gcons.gridy=5;
grid.setConstraints(lb211,gcons);
pn1.add(lb211);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=0;
gcons.gridy=5;
grid.setConstraints(blk,gcons);
pn2.add(blk);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=5;
grid.setConstraints(lb31,gcons);
pn2.add(lb31);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=2;
gcons.gridy=5;
grid.setConstraints(blk1,gcons);
pn2.add(blk1);



gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=5;
grid.setConstraints(lb41,gcons);
pn2.add(lb41);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=0;
gcons.gridy=7;
grid.setConstraints(l1,gcons);
pn2.add(l1);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=7;
grid.setConstraints(t1,gcons);
pn2.add(t1);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=7;
grid.setConstraints(t4,gcons);
pn2.add(t4);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=0;
gcons.gridy=9;
grid.setConstraints(l2,gcons);
pn2.add(l2);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=9;
grid.setConstraints(t2,gcons);
pn2.add(t2);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=9;
grid.setConstraints(t5,gcons);
pn2.add(t5);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=0;
gcons.gridy=11;
grid.setConstraints(l3,gcons);
pn2.add(l3);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=11;
grid.setConstraints(t3,gcons);
pn2.add(t3);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=11;
grid.setConstraints(t6,gcons);
pn2.add(t6);

//page 4
experiencePanel= new JPanel();
buttonpanel= new JPanel();
experiencePanel.setLayout(grid);
chkexp= new ButtonGroup();
fresh= new JRadioButton("I am a fresh graduate ",true);
experienced= new JRadioButton("I have been working for ",false);
//chkexp.setBackground(co1);
fresh.setBackground(co1);
experienced.setBackground(co1);
chkexp.add(fresh);
chkexp.add(experienced);
exmainpan= new JPanel();
exmainpan.setLayout(border);
exmainpan.setBackground(co1);
experiencePanel.setBackground(co1);
buttonpanel.setBackground(co1);
exmainpan.add(experiencePanel,BorderLayout.CENTER);  



first= new JTextField(5);
second= new JTextField(5);

subexp= new JPanel();
subexp.add(first);
subexp.setBackground(co1);
subexp.add(new JLabel("year(s) "));
subexp.add(second);
subexp.add(new JLabel("Month(s) "));

addexp= new JButton(new ImageIcon("images//addexp.gif"));
addexp.addActionListener(this);
addexp.setBorder(bb1);
addexp.setBackground(co1);

labelexp= new JLabel(new ImageIcon("images//p6.gif"));

gcons.anchor= GridBagConstraints.NORTH;
gcons.gridx=1;
gcons.gridy=5;
grid.setConstraints(labelexp,gcons);
experiencePanel.add(labelexp);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=8;
grid.setConstraints(fresh,gcons);
experiencePanel.add(fresh);


gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=11;
grid.setConstraints(experienced,gcons);
experiencePanel.add(experienced);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=3;
gcons.gridy=11;
grid.setConstraints(subexp,gcons);
experiencePanel.add(subexp);

buttonpanel.add(addexp);

 
gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=3;
gcons.gridy=14;
grid.setConstraints(buttonpanel,gcons);
experiencePanel.add(buttonpanel);


//page 5

skillMainPanel=new JPanel();
skillPanel1= new JPanel();
skillPanel2=new JPanel();
skillPanel4 = new JPanel();
skillPanel3=new JPanel();

skillMainPanel.setLayout(grid);
skillPanel2.setLayout(grid);
skillPanel4.setLayout(grid);
skillPanel3.setLayout(grid);

skillMainPanel.setBackground(co1);
skillPanel2.setBackground(co1);
skillPanel4.setBackground(co1);
skillPanel3.setBackground(co1);


skillLabel1 = new JLabel(new ImageIcon("images//p7.gif"));skillLabel1.setBackground(co1);
skillLabeskillNoLabel2 = new JLabel("Enter your top skills (e.g. Project Management, Cost Accounting, C++, Oracle8),");
skillLabeskillNoLabel211 =new JLabel(" years of experience and proficiency.");
skillLabeskillNoLabel21= new JLabel("( Maximum 5 skills allowed. ) ");
skillLabeskillNoLabel3 = new JLabel("Skill                                  ");
skillLabeskillNoLabel4 = new JLabel("Years of Experience");
skillBlanklabel = new JLabel("  ");
labs1 = new JLabel("1.");
skillNoLabel2 = new JLabel("2.");
skillNoLabel3 = new JLabel("3.");
skillNoLabel4 = new JLabel("4.");
skillNoLabel5 = new JLabel("5.");
skillBlanklabel1= new JLabel("     ");
spc1 = new JLabel(" ");
spc2 = new JLabel("  ");
spc3 = new JLabel("  ");
lpro = new JLabel("Proficiency");

skillLabeskillNoLabel2.setForeground(Color.black);
skillLabeskillNoLabel211.setForeground(Color.black);
skillLabeskillNoLabel21.setForeground(Color.black);
skillLabeskillNoLabel3 .setForeground(Color.black);
skillLabeskillNoLabel4.setForeground(Color.black);
labs1.setForeground(Color.black);
skillNoLabel2 .setForeground(Color.black);
skillNoLabel3  .setForeground(Color.black);
skillNoLabel4 .setForeground(Color.black);
skillNoLabel5  .setForeground(Color.black);
spc1  .setForeground(Color.black);
spc2 .setForeground(Color.black);
lpro .setForeground(Color.black);



skillText1 = new JTextField(20);
skillText2 = new JTextField(20);
skillText3 = new JTextField(20);
skillText4 = new JTextField(20);
skillText5 = new JTextField(20);

String [] exper = {"             -            ", ">5 years", "5 years", "4 years", "3 years", "2 years", "1 year"};
String [] prof = {"             -            ", "Advanced", "Intermediate", "Beginner"};

skillCombo1 = new JComboBox(exper);
skillCombo11 = new JComboBox(exper);
skillCombo12 = new JComboBox(exper);
skillCombo2 = new JComboBox(prof);
skillCombo21 = new JComboBox(prof);
skillCombo22 = new JComboBox(prof);


skillCombo13 = new JComboBox(exper);
skillCombo23 = new JComboBox(prof);
skillCombo14 = new JComboBox(exper);
skillCombo24 = new JComboBox(prof);

skillPanel1.add(skillLabel1);
skillPanel1.setBackground(co1);
gcons.anchor= GridBagConstraints.CENTER;
gcons.gridx=1;
gcons.gridy=0;
grid.setConstraints(skillPanel1,gcons);
skillMainPanel.add(skillPanel1);


gcons.anchor= GridBagConstraints.CENTER;
gcons.gridx=1;
gcons.gridy=5;
grid.setConstraints(skillPanel2,gcons);
skillMainPanel.add(skillPanel2);

gcons.anchor= GridBagConstraints.CENTER;
gcons.gridx=1;
gcons.gridy=6;
grid.setConstraints(skillPanel4,gcons);
skillMainPanel.add(skillPanel4);

gcons.anchor= GridBagConstraints.CENTER;
gcons.gridx=1;
gcons.gridy=10;
grid.setConstraints(skillPanel3,gcons);
skillMainPanel.add(skillPanel3);


gcons.anchor= GridBagConstraints.CENTER;
gcons.gridx=1;
gcons.gridy=3;
grid.setConstraints(skillLabeskillNoLabel2,gcons);
skillPanel2.add(skillLabeskillNoLabel2);

gcons.anchor= GridBagConstraints.CENTER;
gcons.gridx=1;
gcons.gridy=4;
grid.setConstraints(skillLabeskillNoLabel211,gcons);
skillPanel2.add(skillLabeskillNoLabel211);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=0;
gcons.gridy=5;
grid.setConstraints(skillBlanklabel,gcons);
skillPanel3.add(skillBlanklabel);

gcons.anchor= GridBagConstraints.CENTER;
gcons.gridx=1;
gcons.gridy=5;
grid.setConstraints(skillLabeskillNoLabel21,gcons);
skillPanel2.add(skillLabeskillNoLabel21);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=6;
grid.setConstraints(spc1,gcons);
skillPanel4.add(spc1);


gcons.anchor= GridBagConstraints.CENTER;
gcons.gridx=2;
gcons.gridy=10;
grid.setConstraints(skillLabeskillNoLabel3,gcons);
skillPanel3.add(skillLabeskillNoLabel3);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=2;
gcons.gridy=10;
grid.setConstraints(skillBlanklabel1,gcons);
skillPanel3.add(skillBlanklabel1);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=3;
gcons.gridy=10;
grid.setConstraints(spc2,gcons);
skillPanel3.add(spc2);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=10;
grid.setConstraints(skillLabeskillNoLabel4,gcons);
skillPanel3.add(skillLabeskillNoLabel4);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=5;
gcons.gridy=10;
grid.setConstraints(spc3,gcons);
skillPanel3.add(spc3);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=6;
gcons.gridy=10;
grid.setConstraints(lpro,gcons);
skillPanel3.add(lpro);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=0;
gcons.gridy=11;
grid.setConstraints(labs1,gcons);
skillPanel3.add(labs1);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=2;
gcons.gridy=11;
grid.setConstraints(skillText1,gcons);
skillPanel3.add(skillText1);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=11;
grid.setConstraints(skillCombo1,gcons);
skillPanel3.add(skillCombo1);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=6;
gcons.gridy=11;
grid.setConstraints(skillCombo2,gcons);
skillPanel3.add(skillCombo2);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=0;
gcons.gridy=12;
grid.setConstraints(skillNoLabel2,gcons);
skillPanel3.add(skillNoLabel2);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=2;
gcons.gridy=12;
grid.setConstraints(skillText2,gcons);
skillPanel3.add(skillText2);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=12;
grid.setConstraints(skillCombo11,gcons);
skillPanel3.add(skillCombo11);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=6;
gcons.gridy=12;
grid.setConstraints(skillCombo21,gcons);
skillPanel3.add(skillCombo21);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=0;
gcons.gridy=13;
grid.setConstraints(skillNoLabel3,gcons);
skillPanel3.add(skillNoLabel3);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=2;
gcons.gridy=13;
grid.setConstraints(skillText3,gcons);
skillPanel3.add(skillText3);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=13;
grid.setConstraints(skillCombo12,gcons);
skillPanel3.add(skillCombo12);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=6;
gcons.gridy=13;
grid.setConstraints(skillCombo22,gcons);
skillPanel3.add(skillCombo22);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=0;
gcons.gridy=14;
grid.setConstraints(skillNoLabel4,gcons);
skillPanel3.add(skillNoLabel4);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=2;
gcons.gridy=14;
grid.setConstraints(skillText4,gcons);
skillPanel3.add(skillText4);


gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=14;
grid.setConstraints(skillCombo13,gcons);
skillPanel3.add(skillCombo13);


gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=6;
gcons.gridy=14;
grid.setConstraints(skillCombo23,gcons);
skillPanel3.add(skillCombo23);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=0;
gcons.gridy=15;
grid.setConstraints(skillNoLabel5,gcons);
skillPanel3.add(skillNoLabel5);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=2;
gcons.gridy=15;
grid.setConstraints(skillText5,gcons);
skillPanel3.add(skillText5);



gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=15;
grid.setConstraints(skillCombo14,gcons);
skillPanel3.add(skillCombo14);


gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=6;
gcons.gridy=15;
grid.setConstraints(skillCombo24,gcons);
skillPanel3.add(skillCombo24);


//page 6

LanguagesMainPanel=new JPanel();
LanguagesPaneLanguagesLabel1= new JPanel();
LanguagesPanel2=new JPanel();
LanguagesPanel4 = new JPanel();
LanguagesPanel3=new JPanel();

LanguagesMainPanel.setLayout(grid);
LanguagesPanel2.setLayout(grid);
LanguagesPanel4.setLayout(grid);
LanguagesPanel3.setLayout(grid);

LanguagesMainPanel.setBackground(co1);
LanguagesPanel2.setBackground(co1);
LanguagesPanel4.setBackground(co1);
LanguagesPanel3.setBackground(co1);


LanguagesLabeLanguagesLabel1 = new JLabel(new ImageIcon("images//p8.gif"));LanguagesLabeLanguagesLabel1.setBackground(co1);
LanguagesLabeLanguagesNoLabel2 = new JLabel("Enter Languages Alongwith Proficiencies in them ");
LanguagesLabeLanguagesNoLabel211 =new JLabel("Maximum 5 Languagess allowed.  ");
LanguagesLabeLanguagesNoLabel21= new JLabel("(0=Poor - 10=Excellent) ");
LanguagesLabeLanguagesNoLabel3 = new JLabel("Languages                                  ");
LanguagesLabeLanguagesNoLabel4 = new JLabel("Spoken ");
LanguagesBlanklabel = new JLabel("  ");
LanguagesLabel1 = new JLabel("1.");
LanguagesNoLabel2 = new JLabel("2.");
LanguagesNoLabel3 = new JLabel("3.");
LanguagesNoLabel4 = new JLabel("4.");
LanguagesNoLabel5 = new JLabel("5.");
LanguagesBlanklabeLanguagesLabel1= new JLabel("     ");
spcl1 = new JLabel(" ");
spcl2 = new JLabel("  ");
spcl3 = new JLabel("  ");
lpro1 = new JLabel("Written");

LanguagesLabeLanguagesLabel1.setForeground(Color.black);
LanguagesLabeLanguagesNoLabel2.setForeground(Color.black);
LanguagesLabeLanguagesNoLabel211.setForeground(Color.black);
LanguagesLabeLanguagesNoLabel21.setForeground(Color.black);
LanguagesLabeLanguagesNoLabel3 .setForeground(Color.black);
LanguagesLabeLanguagesNoLabel4.setForeground(Color.black);
LanguagesLabel1.setForeground(Color.black);
LanguagesNoLabel2 .setForeground(Color.black);
LanguagesNoLabel3 .setForeground(Color.black);
LanguagesNoLabel4.setForeground(Color.black);
LanguagesNoLabel5 .setForeground(Color.black);
lpro1 .setForeground(Color.black);



LanguagesText1 = new JTextField(20);
LanguagesText2 = new JTextField(20);
LanguagesText3 = new JTextField(20);
LanguagesText4 = new JTextField(20);
LanguagesText5 = new JTextField(20);

String [] spok = {"             -            ", " 0 (Zero) ","1 (One)","2 (Two )","3 (Three)","4 (Four)","5 (Five)","6 (Six)","7 (Seven)","8 (Eight)","9 (Nine)","10 (Ten)"};
String [] wrii = {"             -            ", " 0 (Zero) ","1 (One)","2 (Two )","3 (Three)","4 (Four)","5 (Five)","6 (Six)","7 (Seven)","8 (Eight)","9 (Nine)","10 (Ten)"};
String ss="Manish";
String aa="Ambar";

LanguagesCombo1 = new JComboBox(spok);
LanguagesCombo11 = new JComboBox(spok);
LanguagesCombo12 = new JComboBox(spok);
LanguagesCombo13 = new JComboBox(spok);
LanguagesCombo14 = new JComboBox(spok);


LanguagesCombo2 = new JComboBox(wrii);
LanguagesCombo21 = new JComboBox(wrii);
LanguagesCombo22 = new JComboBox(wrii);
LanguagesCombo23 = new JComboBox(wrii);
LanguagesCombo24 = new JComboBox(wrii);



LanguagesPaneLanguagesLabel1.add(LanguagesLabeLanguagesLabel1);
gcons.anchor= GridBagConstraints.CENTER;
gcons.gridx=1;
gcons.gridy=3;
grid.setConstraints(LanguagesPaneLanguagesLabel1,gcons);
LanguagesMainPanel.add(LanguagesPaneLanguagesLabel1);
LanguagesPaneLanguagesLabel1.setBackground(co1);

gcons.anchor= GridBagConstraints.CENTER;
gcons.gridx=1;
gcons.gridy=5;
grid.setConstraints(LanguagesPanel2,gcons);
LanguagesMainPanel.add(LanguagesPanel2);

gcons.anchor= GridBagConstraints.CENTER;
gcons.gridx=1;
gcons.gridy=6;
grid.setConstraints(LanguagesPanel4,gcons);
LanguagesMainPanel.add(LanguagesPanel4);

gcons.anchor= GridBagConstraints.CENTER;
gcons.gridx=1;
gcons.gridy=10;
grid.setConstraints(LanguagesPanel3,gcons);
LanguagesMainPanel.add(LanguagesPanel3);


gcons.anchor= GridBagConstraints.CENTER;
gcons.gridx=1;
gcons.gridy=3;
grid.setConstraints(LanguagesLabeLanguagesNoLabel2,gcons);
LanguagesPanel2.add(LanguagesLabeLanguagesNoLabel2);

gcons.anchor= GridBagConstraints.CENTER;
gcons.gridx=1;
gcons.gridy=4;
grid.setConstraints(LanguagesLabeLanguagesNoLabel211,gcons);
LanguagesPanel2.add(LanguagesLabeLanguagesNoLabel211);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=0;
gcons.gridy=5;
grid.setConstraints(LanguagesBlanklabel,gcons);
LanguagesPanel3.add(LanguagesBlanklabel);

gcons.anchor= GridBagConstraints.CENTER;
gcons.gridx=1;
gcons.gridy=5;
grid.setConstraints(LanguagesLabeLanguagesNoLabel21,gcons);
LanguagesPanel2.add(LanguagesLabeLanguagesNoLabel21);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=6;
grid.setConstraints(spcl1,gcons);
LanguagesPanel4.add(spcl1);


gcons.anchor= GridBagConstraints.CENTER;
gcons.gridx=2;
gcons.gridy=10;
grid.setConstraints(LanguagesLabeLanguagesNoLabel3,gcons);
LanguagesPanel3.add(LanguagesLabeLanguagesNoLabel3);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=2;
gcons.gridy=10;
grid.setConstraints(LanguagesBlanklabeLanguagesLabel1,gcons);
LanguagesPanel3.add(LanguagesBlanklabeLanguagesLabel1);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=3;
gcons.gridy=10;
grid.setConstraints(spcl2,gcons);
LanguagesPanel3.add(spcl2);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=10;
grid.setConstraints(LanguagesLabeLanguagesNoLabel4,gcons);
LanguagesPanel3.add(LanguagesLabeLanguagesNoLabel4);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=5;
gcons.gridy=10;
grid.setConstraints(spcl3,gcons);
LanguagesPanel3.add(spcl3);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=6;
gcons.gridy=10;
grid.setConstraints(lpro1,gcons);
LanguagesPanel3.add(lpro1);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=0;
gcons.gridy=11;
grid.setConstraints(LanguagesLabel1,gcons);
LanguagesPanel3.add(LanguagesLabel1);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=2;
gcons.gridy=11;
grid.setConstraints(LanguagesText1,gcons);
LanguagesPanel3.add(LanguagesText1);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=11;
grid.setConstraints(LanguagesCombo1,gcons);
LanguagesPanel3.add(LanguagesCombo1);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=6;
gcons.gridy=11;
grid.setConstraints(LanguagesCombo2,gcons);
LanguagesPanel3.add(LanguagesCombo2);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=0;
gcons.gridy=12;
grid.setConstraints(LanguagesNoLabel2,gcons);
LanguagesPanel3.add(LanguagesNoLabel2);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=2;
gcons.gridy=12;
grid.setConstraints(LanguagesText2,gcons);
LanguagesPanel3.add(LanguagesText2);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=12;
grid.setConstraints(LanguagesCombo11,gcons);
LanguagesPanel3.add(LanguagesCombo11);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=6;
gcons.gridy=12;
grid.setConstraints(LanguagesCombo21,gcons);
LanguagesPanel3.add(LanguagesCombo21);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=0;
gcons.gridy=13;
grid.setConstraints(LanguagesNoLabel3,gcons);
LanguagesPanel3.add(LanguagesNoLabel3);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=2;
gcons.gridy=13;
grid.setConstraints(LanguagesText3,gcons);
LanguagesPanel3.add(LanguagesText3);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=13;
grid.setConstraints(LanguagesCombo12,gcons);
LanguagesPanel3.add(LanguagesCombo12);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=6;
gcons.gridy=13;
grid.setConstraints(LanguagesCombo22,gcons);
LanguagesPanel3.add(LanguagesCombo22);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=0;
gcons.gridy=14;
grid.setConstraints(LanguagesNoLabel4,gcons);
LanguagesPanel3.add(LanguagesNoLabel4);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=2;
gcons.gridy=14;
grid.setConstraints(LanguagesText4,gcons);
LanguagesPanel3.add(LanguagesText4);


gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=14;
grid.setConstraints(LanguagesCombo13,gcons);
LanguagesPanel3.add(LanguagesCombo13);


gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=6;
gcons.gridy=14;
grid.setConstraints(LanguagesCombo23,gcons);
LanguagesPanel3.add(LanguagesCombo23);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=0;
gcons.gridy=15;
grid.setConstraints(LanguagesNoLabel5,gcons);
LanguagesPanel3.add(LanguagesNoLabel5);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=2;
gcons.gridy=15;
grid.setConstraints(LanguagesText5,gcons);
LanguagesPanel3.add(LanguagesText5);


gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=4;
gcons.gridy=15;
grid.setConstraints(LanguagesCombo14,gcons);
LanguagesPanel3.add(LanguagesCombo14);


gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=6;
gcons.gridy=15;
grid.setConstraints(LanguagesCombo24,gcons);
LanguagesPanel3.add(LanguagesCombo24);


//page 7

addInfoPanel= new JPanel();
addInfoPanel.setBackground(co1);
addInfoPanel.setLayout(grid);

JScrollPane jspInfo= new JScrollPane(addInfoPanel,v,h);


Info1= new JLabel(new ImageIcon("images//p9.gif"));
Info2= new JLabel("Give Brief Description " );
Info3= new JLabel("Summer Jobs");
Info4= new JLabel("Describe Your Summer Jobs");
Info5= new JLabel("Project Undertaken ");
Info6= new JLabel("Describe About Your Projects Undertaken");
Info7= new JLabel("Extra Curricular Activities");
Info8= new JLabel("Describe Extra Carricular Activities" );

Info2.setForeground(Color.black);
Info3.setForeground(Color.black);
Info4.setForeground(Color.black);
Info5.setForeground(Color.black);
Info6.setForeground(Color.black);
Info7.setForeground(Color.black);
Info8.setForeground(Color.black);


Info9= new JLabel("  ");
Info10= new JLabel();

infoarea1= new JTextArea(6,30);
infoarea2= new JTextArea(6,30);
infoarea3= new JTextArea(6,30);

textscroll= new JScrollPane(infoarea1,v,h);
textscroll1= new JScrollPane(infoarea2,v,h);
textscroll2= new JScrollPane(infoarea3,v,h);

gcons.anchor= GridBagConstraints.CENTER;
gcons.gridx=1;
gcons.gridy=1;
grid.setConstraints(Info1,gcons);
addInfoPanel.add(Info1);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=2;
grid.setConstraints(Info2,gcons);
addInfoPanel.add(Info2);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=3;
grid.setConstraints(Info9,gcons);
addInfoPanel.add(Info9);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=4;
grid.setConstraints(Info3,gcons);
addInfoPanel.add(Info3);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=3;
gcons.gridy=4;
grid.setConstraints(Info4,gcons);
addInfoPanel.add(Info4);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=3;
gcons.gridy=5;
grid.setConstraints(textscroll,gcons);
addInfoPanel.add(textscroll);


gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=6;
grid.setConstraints(Info5,gcons);
addInfoPanel.add(Info5);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=3;
gcons.gridy=6;
grid.setConstraints(Info6,gcons);
addInfoPanel.add(Info6);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=3;
gcons.gridy=7;
grid.setConstraints(textscroll1,gcons);
addInfoPanel.add(textscroll1);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=8;
grid.setConstraints(Info7,gcons);
addInfoPanel.add(Info7);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=3;
gcons.gridy=8;
grid.setConstraints(Info8,gcons);
addInfoPanel.add(Info8);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=3;
gcons.gridy=9;
grid.setConstraints(textscroll2,gcons);
addInfoPanel.add(textscroll2);

//page 8


referpanel= new JPanel();
referpanel.setBackground(co1);
referpanel.setLayout(grid);


reflabel1=new JLabel(new ImageIcon("images//p10.gif"));reflabel1.setBackground(co1);
reflabel2=new JLabel("Name :");
reflabel3=new JLabel("Relationship:");
reflabel4=new JLabel("e.g. former supervisor, university lecturer");
reflabel5=new JLabel("Telephone No:");
reflabel6=new JLabel("E-mail:");
reflabel7=new JLabel("Position Title :");
reflabel8=new JLabel("Company Name :");
reflabel9=new JLabel(new ImageIcon("images//p11.gif"));reflabel9.setBackground(co1);
reflabel10=new JLabel("Name :");
reflabel11=new JLabel("Relationship:");
reflabel12=new JLabel("e.g. former supervisor, university lecturer");
reflabel13=new JLabel("Telephone No:");
reflabel14=new JLabel("E-mail:");
reflabel15=new JLabel("Position Title:");
reflabel16=new JLabel("Company Name:");
reflabel17=new JLabel(" ");
reflabel2.setForeground(Color.black);
reflabel3.setForeground(Color.black);
reflabel4.setForeground(Color.black);
reflabel5.setForeground(Color.black);
reflabel6.setForeground(Color.black);
reflabel7.setForeground(Color.black);
reflabel8.setForeground(Color.black);
reflabel10.setForeground(Color.black);
reflabel11.setForeground(Color.black);
reflabel12.setForeground(Color.black);
reflabel13.setForeground(Color.black);
reflabel14.setForeground(Color.black);
reflabel15.setForeground(Color.black);
reflabel16.setForeground(Color.black);


reftext1=new JTextField(25);
reftext2=new JTextField(25);
reftext3=new JTextField(25);
reftext4=new JTextField(25);
reftext5=new JTextField(25);
reftext6=new JTextField(25);
reftext7=new JTextField(25);
reftext8=new JTextField(25);
reftext9=new JTextField(25);
reftext10=new JTextField(25);
reftext11=new JTextField(25);
reftext12=new JTextField(25);


gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=0;
gcons.gridy=1;
grid.setConstraints(reflabel1,gcons);
referpanel.add(reflabel1);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=1;
gcons.gridy=2;
grid.setConstraints(reflabel2,gcons);
referpanel.add(reflabel2);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=2;
gcons.gridy=2;
grid.setConstraints(reflabel17,gcons);
referpanel.add(reflabel17);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=3;
gcons.gridy=2;
grid.setConstraints(reftext1,gcons);
referpanel.add(reftext1);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=1;
gcons.gridy=3;
grid.setConstraints(reflabel3,gcons);
referpanel.add(reflabel3);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=3;
gcons.gridy=3;
grid.setConstraints(reftext2,gcons);
referpanel.add(reftext2);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=3;
gcons.gridy=4;
grid.setConstraints(reflabel4,gcons);
referpanel.add(reflabel4);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=1;
gcons.gridy=5;
grid.setConstraints(reflabel5,gcons);
referpanel.add(reflabel5);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=3;
gcons.gridy=5;
grid.setConstraints(reftext3,gcons);
referpanel.add(reftext3);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=1;
gcons.gridy=6;
grid.setConstraints(reflabel6,gcons);
referpanel.add(reflabel6);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=3;
gcons.gridy=6;
grid.setConstraints(reftext4,gcons);
referpanel.add(reftext4);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=1;
gcons.gridy=7;
grid.setConstraints(reflabel7,gcons);
referpanel.add(reflabel7);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=3;
gcons.gridy=7;
grid.setConstraints(reftext5,gcons);
referpanel.add(reftext5);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=1;
gcons.gridy=8;
grid.setConstraints(reflabel8,gcons);
referpanel.add(reflabel8);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=3;
gcons.gridy=8;
grid.setConstraints(reftext6,gcons);
referpanel.add(reftext6);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=0;
gcons.gridy=10;
grid.setConstraints(reflabel9,gcons);
referpanel.add(reflabel9);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=1;
gcons.gridy=11;
grid.setConstraints(reflabel10,gcons);
referpanel.add(reflabel10);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=3;
gcons.gridy=11;
grid.setConstraints(reftext7,gcons);
referpanel.add(reftext7);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=1;
gcons.gridy=12;
grid.setConstraints(reflabel11,gcons);
referpanel.add(reflabel11);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=3;
gcons.gridy=12;
grid.setConstraints(reftext8,gcons);
referpanel.add(reftext8);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=3;
gcons.gridy=13;
grid.setConstraints(reflabel12,gcons);
referpanel.add(reflabel12);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=1;
gcons.gridy=14;
grid.setConstraints(reflabel13,gcons);
referpanel.add(reflabel13);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=3;
gcons.gridy=14;
grid.setConstraints(reftext9,gcons);
referpanel.add(reftext9);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=1;
gcons.gridy=15;
grid.setConstraints(reflabel14,gcons);
referpanel.add(reflabel14);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=3;
gcons.gridy=15;
grid.setConstraints(reftext10,gcons);
referpanel.add(reftext10);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=1;
gcons.gridy=16;
grid.setConstraints(reflabel15,gcons);
referpanel.add(reflabel15);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=3;
gcons.gridy=16;
grid.setConstraints(reftext11,gcons);
referpanel.add(reftext11);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=1;
gcons.gridy=17;
grid.setConstraints(reflabel16,gcons);
referpanel.add(reflabel16);

gcons.anchor= GridBagConstraints.WEST;
gcons.gridx=3;
gcons.gridy=17;
grid.setConstraints(reftext12,gcons);
referpanel.add(reftext12);

JLabel blank= new JLabel("    ");
gcons.anchor= GridBagConstraints.SOUTH;
gcons.gridx=3;
gcons.gridy=20;
grid.setConstraints(blank,gcons);
referpanel.add(blank);


card=new CardLayout();
frmpanel2.setLayout(card);
frmpanel2.setBorder(new TitledBorder(new MatteBorder(new ImageIcon("images//blue.jpg"))));

chkgender.setBackground(Color.white);
chkmatrial.setBackground(Color.white);


combodate.setBackground(Color.white);
combomonth.setBackground(Color.white);
comboNational.setBackground(Color.white);
combocountry.setBackground(Color.white);
combostate.setBackground(Color.white);
cb1.setBackground(Color.white);
//cb2.setBackground(Color.white);
cb3.setBackground(Color.white);
cb4.setBackground(Color.white);
cb5.setBackground(Color.white);
cb6.setBackground(Color.white);
//cb7.setBackground(Color.white);
cb8.setBackground(Color.white);
cb9.setBackground(Color.white);
cb10.setBackground(Color.white);
skillCombo1.setBackground(Color.white);
skillCombo11.setBackground(Color.white);
skillCombo12.setBackground(Color.white);
skillCombo13.setBackground(Color.white);
skillCombo14.setBackground(Color.white);
skillCombo2.setBackground(Color.white);
skillCombo21.setBackground(Color.white);
skillCombo22.setBackground(Color.white);
skillCombo23.setBackground(Color.white);
skillCombo24.setBackground(Color.white);
LanguagesCombo1.setBackground(Color.white);
LanguagesCombo11.setBackground(Color.white);
LanguagesCombo12.setBackground(Color.white);
LanguagesCombo13.setBackground(Color.white);
LanguagesCombo14.setBackground(Color.white);
LanguagesCombo2.setBackground(Color.white);
LanguagesCombo21.setBackground(Color.white);
LanguagesCombo22.setBackground(Color.white);
LanguagesCombo23.setBackground(Color.white);
LanguagesCombo24.setBackground(Color.white);

finalpanel=new JPanel();
finalpanel.add(new JLabel(new ImageIcon("images//finish.gif")));
finalpanel.setBackground(Color.white);

frmpanel2.add(jsp,"p1");
frmpanel2.add(sub2,"p2");
frmpanel2.add(pnmain,"p3");
frmpanel2.add(exmainpan,"p4");
frmpanel2.add(skillMainPanel,"p5");
frmpanel2.add(LanguagesMainPanel,"p6");
frmpanel2.add(jspInfo,"p7");
frmpanel2.add(referpanel,"p8");
frmpanel2.add(finalpanel,"p9");



swingframe.getContentPane().add(frm);
swingframe.setSize(800,600);
swingframe.setLocation(0,70);
swingframe.setVisible(true);
}
public void connect()
{
	{
String comb=combodate.getSelectedItem() +" " + combomonth.getSelectedItem()+" "+ tyear.getText();
String graddate=cb4.getSelectedItem() + " "+ tf3.getText();
String graddate1=cb9.getSelectedItem() + " "+ tf7.getText();
try
	{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection cn;
	cn=DriverManager.getConnection("jdbc:odbc:resume1","sa","");
	PreparedStatement stat=cn.prepareStatement("insert into resumebUILDER Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	
	stat.setString(1,tfname.getText());
	stat.setString(2,tlname.getText());
	stat.setString(3,comb);
	stat.setString(4,(String)chkgender.getSelectedItem());
	stat.setString(5,(String)chkmatrial.getSelectedItem());
	stat.setString(6,(String)comboNational.getSelectedItem());
	stat.setString(7,tpmail.getText());
	stat.setString(8,tamail.getText());
	stat.setString(9,tmobile.getText());
	stat.setString(10,ttele.getText());
	stat.setString(11,tadd1.getText());
	stat.setString(12,tpostal.getText());
	stat.setString(13,(String)combocountry.getSelectedItem());
	stat.setString(14,(String)combostate.getSelectedItem());
	stat.setString(15,tcity.getText());
///
stat.setString(16,(String)cb1.getSelectedItem());
stat.setString(17,tf1.getText());
stat.setString(18,(String)cb3.getSelectedItem());
stat.setString(19,subtext1.getText());
stat.setString(20,subtext2.getText());
stat.setString(21,tf2.getText());
stat.setString(22,(String)cb5.getSelectedItem());
stat.setString(23,graddate);
stat.setString(24,(String)cb6.getSelectedItem());
stat.setString(25,tf5.getText());
stat.setString(26,(String)cb8.getSelectedItem());
stat.setString(27,subtext3.getText());
stat.setString(28,subtext4.getText());
stat.setString(29,tf6.getText());
stat.setString(30,(String)cb10.getSelectedItem());
stat.setString(31,graddate1);
/////////
	stat.setString(32,t1.getText());
	stat.setString(33,t4.getText());
	stat.setString(34,t2.getText());
	stat.setString(35,t5.getText());
	stat.setString(36,t3.getText());
	stat.setString(37,t6.getText());
//////

	stat.setString(38,skillText1.getText());
	stat.setString(39,(String)skillCombo1.getSelectedItem());
	stat.setString(40,(String)skillCombo2.getSelectedItem());

	stat.setString(41,skillText2.getText());
	stat.setString(42,(String)skillCombo11.getSelectedItem());
	stat.setString(43,(String)skillCombo21.getSelectedItem());

	stat.setString(44,skillText3.getText());
	stat.setString(45,(String)skillCombo12.getSelectedItem());
	stat.setString(46,(String)skillCombo22.getSelectedItem());

	stat.setString(47,skillText4.getText());
	stat.setString(48,(String)skillCombo13.getSelectedItem());
	stat.setString(49,(String)skillCombo23.getSelectedItem());

	stat.setString(50,skillText5.getText());
	stat.setString(51,(String)skillCombo14.getSelectedItem());
	stat.setString(52,(String)skillCombo24.getSelectedItem());
/////////
	stat.setString(53,LanguagesText1.getText());
	stat.setString(54,(String)LanguagesCombo1.getSelectedItem());
	stat.setString(55,(String)LanguagesCombo2.getSelectedItem());

	stat.setString(56,LanguagesText2.getText());
	stat.setString(57,(String)LanguagesCombo11.getSelectedItem());
	stat.setString(58,(String)LanguagesCombo21.getSelectedItem());

	stat.setString(59,LanguagesText3.getText());
	stat.setString(60,(String)LanguagesCombo12.getSelectedItem());
	stat.setString(61,(String)LanguagesCombo22.getSelectedItem());

	stat.setString(62,LanguagesText4.getText());
	stat.setString(63,(String)LanguagesCombo13.getSelectedItem());
	stat.setString(64,(String)LanguagesCombo23.getSelectedItem());

	stat.setString(65,LanguagesText5.getText());
	stat.setString(66,(String)LanguagesCombo14.getSelectedItem());
	stat.setString(67,(String)LanguagesCombo24.getSelectedItem());
/////////////
stat.setString(68,infoarea1.getText());
stat.setString(69,infoarea2.getText());
stat.setString(70,infoarea3.getText());

/////////////

	stat.setString(71,reftext1.getText());
	stat.setString(72,reftext2.getText());
	stat.setString(73,reftext3.getText());
	stat.setString(74,reftext4.getText());
	stat.setString(75,reftext5.getText());
	stat.setString(76,reftext6.getText());
	stat.setString(77,reftext7.getText());
	stat.setString(78,reftext8.getText());
	stat.setString(79,reftext9.getText());
	stat.setString(80,reftext10.getText());
	stat.setString(81,reftext11.getText());
	stat.setString(82,reftext12.getText());

			stat.executeUpdate();
			}
		catch(Exception e)
			{
			System.out.print(e);
			JOptionPane.showMessageDialog(null,"Error Occured While data submitted in database","Database Error",JOptionPane.WARNING_MESSAGE);


			}
		};
}

public void actionPerformed(ActionEvent t)
{
Object ob=t.getSource();
if (ob==addexp){new exper();}
if(ob==next){card.next(frmpanel2);}
if(ob==back){ card.previous(frmpanel2);}
if(ob==cncle){int result = JOptionPane.showConfirmDialog(swingframe," Do You Really  Want To Exit  ");
	if(result == JOptionPane.YES_OPTION) 
		   	{
			   	swingframe.setVisible(false);
			}}
if(ob==finish){
	connect();
	new preview();}
}


public static void main(String a[])
{
resumeBuilder resb= new resumeBuilder();
}
}