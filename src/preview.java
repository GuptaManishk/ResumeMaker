import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class preview implements ActionListener
{
JFrame frame;
JPanel prevMain,prevContact,skillpanel,skillList,languagepanel,LanguagesList;
GridBagLayout grid;
GridBagConstraints gcons;
GridLayout gridlayout,g1;
JScrollPane scroll;
Font font,head; 
Color back;
ResultSet result;
Connection con;
Statement stat;
String str;
//varibels for Contact Info
JPanel supported,supported1;
JTextField  blank,name,address,telephone,mobile,email;
JTextField NAME,ADDRESS,TELEPHONE,MOBILE,EMAIL,CONTACT;

JTextField blank1,personal,age,nationality,maritalstatus,permanentresidence,dateofbirth,gender;
JTextField AGE,NATIONALITY,MARITALSTATUS,PERMANENTRESIDENCE,DATEOFBIRTH,GENDER;

JTextField blank2,EDUCATIONALBACKGROUND,HIGHESTEDUCATION,LEVEL,MAJOR,UNIVERSITY;
JTextField LOCATEDIN,GRADE,GRADUATIONDATE;
JTextField level,major,	university,locatedin,grade,graduationdate;

JTextField blank3,SECONDHIGHESTEDUCATION,LEVEL2,MAJOR2,INSTITUTE,LOCATEDIN2;
JTextField level2,major2,institute,locatedin2,grade2,graduationdate2,GRADE2,GRADUATIONDATE2;

JTextField blank4,PROFESSIONALCERTIFICATION,certName1,cert1,certName2,cert2,certName3,cert3;
JTextField year,certname;

JTextField blank5,EXPERIENCE;
JTextArea description;

JTextField blank6,TOPSKILLS;
//JTextField skillarea,yeararea,proficiencyArea;
JTextField SKILL,YEARS,PROFICIENCY;


JTextField blank8,LANGUAGES, languages,spoken,written;
JTextField languagesarea,languagesarea1,languagesarea2,languagesarea3,languagesarea4;
JTextField spokenarea,spokenarea1,spokenarea2,spokenarea3,spokenarea4;
JTextField writtenarea,writtenarea1,writtenarea2,writtenarea3,writtenarea4;

JTextField skillarea,skillarea1,skillarea2,skillarea3,skillarea4;
JTextField yeararea,yeararea1,yeararea2,yeararea3,yeararea4;
JTextField proficiencyarea,proficiencyarea1,proficiencyarea2,proficiencyarea3,proficiencyarea4;


JTextField blank9,addinfo,summer,project,extra;
JTextArea addArea,summerarea,projctarea;

JTextField blank10,references,references1,RNAME,TELEPHONENO,REMAIL,POSITION,COMPANY,RELATIONSHIP;
JTextField RNAME1,TELEPHONENO1,REMAIL1,POSITION1,COMPANY1,RELATIONSHIP1;
JTextField rname,telephoneno,remail,position,company,relationship;
JTextField rname1,telephoneno1,remail1,position1,company1,relationship1;

JButton Preview,Save,Exit;


public preview()
{
frame = new JFrame ("Resume Preview");

int	v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;

Border bb = BorderFactory.createLineBorder(Color.black,1);
Border wht = BorderFactory.createLineBorder(Color.white,1);

font = new  Font ("Times New Roman",Font.BOLD,12);
head=new  Font ("Times New Roman",Font.BOLD,12);

back= new Color(222,229,235);

grid= new GridBagLayout ();
gcons= new GridBagConstraints();
gridlayout= new GridLayout(4,4);
g1= new GridLayout(6,3);
GridLayout g2= new GridLayout(1,3);
prevMain=new JPanel();
prevContact=new JPanel();
prevMain.setLayout(grid);
prevContact.setLayout(grid);
skillpanel=new JPanel();
skillList=new JPanel();
languagepanel=new JPanel();
LanguagesList=new JPanel();

scroll= new JScrollPane(prevContact,v,h);
supported=new JPanel();
supported1=new JPanel();

supported.setLayout(gridlayout);
skillpanel.setLayout(g2);
skillList.setLayout(g1);
languagepanel.setLayout(g2);
LanguagesList.setLayout(g1);

name=new JTextField(15);

skillarea=new JTextField(15);
skillarea1=new JTextField(15);
skillarea2=new JTextField(15);
skillarea3=new JTextField(15);
skillarea4=new JTextField(15);
yeararea=new JTextField(15);
yeararea1=new JTextField(15);
yeararea2=new JTextField(15);
yeararea3=new JTextField(15);
yeararea4=new JTextField(15);
proficiencyarea=new JTextField(15);
proficiencyarea1=new JTextField(15);
proficiencyarea2=new JTextField(15);
proficiencyarea3=new JTextField(15);
proficiencyarea4=new JTextField(15);


languagesarea=new JTextField(15);
languagesarea1=new JTextField(15);
languagesarea2=new JTextField(15);
languagesarea3=new JTextField(15);
languagesarea4=new JTextField(15);
spokenarea=new JTextField(15);
spokenarea1=new JTextField(15);
spokenarea2=new JTextField(15);
spokenarea3=new JTextField(15);
spokenarea4=new JTextField(15);
writtenarea=new JTextField(15);
writtenarea1=new JTextField(15);
writtenarea2=new JTextField(15);
writtenarea3=new JTextField(15);
writtenarea4=new JTextField(15);



address=new JTextField ("Address",15);
address.setFont(font);
address.setEditable(false);
address.setBackground(Color.white);

telephone=new JTextField ("Telephone",15);
telephone.setFont(font);
telephone.setEditable(false);
telephone.setBackground(Color.white);

mobile=new JTextField ("Mobile No",15);
mobile.setFont(font);
mobile.setEditable(false);
mobile.setBackground(Color.white);

email=new JTextField ("E-Mail",15);
email.setFont(font);
email.setEditable(false);
email.setBackground(Color.white);

blank= new JTextField(60);
blank.setBorder(wht);
CONTACT= new JTextField("                                                                                       Contact Info",66);
CONTACT.setEditable(false);
CONTACT.setBackground(back);
CONTACT.setFont(head);

NAME= new JTextField(44);
NAME.setEditable(false);
NAME.setBackground(Color.white);
NAME.setFont(new Font("Times New Roman",Font.BOLD,20));

ADDRESS= new JTextField(45);
TELEPHONE= new JTextField(45);
MOBILE= new JTextField(45);
EMAIL= new JTextField(45);


blank1= new JTextField(60);
blank1.setBorder(wht);
personal= new JTextField("                                                                                   Personal Particulars",66);
personal.setBackground(back);
personal.setFont(head);
personal.setEditable(false);
age= new JTextField("Age",15);
age.setEditable(false);
age.setBackground(Color.white);
age.setFont(font);

nationality= new JTextField("Nationality",15);
nationality.setFont(font);
nationality.setEditable(false);
nationality.setBackground(Color.white);

maritalstatus= new JTextField("Marital Status",15);
maritalstatus.setEditable(false);
maritalstatus.setBackground(Color.white);
maritalstatus.setFont(font);

permanentresidence= new JTextField("Permanent Residence",15);
permanentresidence.setEditable(false);
permanentresidence.setBackground(Color.white);
permanentresidence.setFont(font);

dateofbirth= new JTextField("Date of Birth",15);
dateofbirth.setEditable(false);
dateofbirth.setBackground(Color.white);
dateofbirth.setFont(font);

gender= new JTextField("Gender",15);
gender.setFont(font);
gender.setEditable(false);
gender.setBackground(Color.white);

AGE= new JTextField(14);
NATIONALITY= new JTextField(14);
MARITALSTATUS= new JTextField(15);
PERMANENTRESIDENCE= new JTextField(15);
DATEOFBIRTH= new JTextField(14);
GENDER= new JTextField(14);


blank2= new JTextField(60);
blank2.setBorder(wht);

EDUCATIONALBACKGROUND= new JTextField("                                                                                  Eductional Background",66);
EDUCATIONALBACKGROUND.setBackground(back);
EDUCATIONALBACKGROUND.setFont(head);
EDUCATIONALBACKGROUND.setEditable(false);

HIGHESTEDUCATION= new JTextField("Higest Eduction",66);
HIGHESTEDUCATION.setFont(font);
HIGHESTEDUCATION.setEditable(false);
HIGHESTEDUCATION.setBackground(Color.white);
level= new JTextField("Level",15);
level.setEditable(false);
level.setBackground(Color.white);

LEVEL= new JTextField(45);
level.setFont(font);

major= new JTextField("Major",15);
major.setBackground(Color.white);
major.setEditable(false);

MAJOR= new JTextField(45);
major.setFont(font);

university= new JTextField("University",15);
university.setBackground(Color.white);
university.setEditable(false);

UNIVERSITY= new JTextField(45);
university.setFont(font);

locatedin= new JTextField("Located In",15);
locatedin.setBackground(Color.white);
locatedin.setEditable(false);
LOCATEDIN= new JTextField(45);
locatedin.setFont(font);

grade= new JTextField("Grade",15);
grade.setBackground(Color.white);
grade.setEditable(false);
GRADE= new JTextField(45);
grade.setFont(font);

graduationdate= new JTextField("Graduation Date",15);
graduationdate.setBackground(Color.white);
graduationdate.setEditable(false);
GRADUATIONDATE= new JTextField(45);
graduationdate.setFont(font);

blank3= new JTextField(60);
blank3.setBorder(wht);

SECONDHIGHESTEDUCATION= new JTextField("Second Higest Eduction",66);
SECONDHIGHESTEDUCATION.setFont(font);
SECONDHIGHESTEDUCATION.setBackground(Color.white);
SECONDHIGHESTEDUCATION.setEditable(false);

LEVEL2= new JTextField(45);
MAJOR2= new JTextField(45);
INSTITUTE= new JTextField(45);
LOCATEDIN2= new JTextField(45);
GRADE2= new JTextField(45);
GRADUATIONDATE2= new JTextField(45);

level2= new JTextField("Level",15);
level2.setFont(font);
level2.setBackground(Color.white);
level2.setEditable(false);

major2= new JTextField("Major",15);
major2.setFont(font);
major2.setBackground(Color.white);
major2.setEditable(false);

institute= new JTextField("Institute",15);
institute.setFont(font);
institute.setBackground(Color.white);
institute.setEditable(false);

locatedin2= new JTextField("Located In",15);
locatedin2.setBackground(Color.white);
locatedin2.setEditable(false);
locatedin2.setFont(font);

grade2= new JTextField("Grade",15);
grade2.setBackground(Color.white);
grade2.setEditable(false);
grade2.setFont(font);

graduationdate2= new JTextField("Graduation Date",15);
graduationdate2.setFont(font);
graduationdate2.setBackground(Color.white);
graduationdate2.setEditable(false);

blank4= new JTextField(60);
blank4.setBorder(wht);

PROFESSIONALCERTIFICATION= new JTextField("                                                                            Professional Certification",66);
PROFESSIONALCERTIFICATION.setBackground(back);
PROFESSIONALCERTIFICATION.setEditable(false);
PROFESSIONALCERTIFICATION.setFont(head);
certName1=new JTextField(15);
cert1=new JTextField(45);
certName2=new JTextField(15);
cert2=new JTextField(45);
certName3=new JTextField(15);
cert3=new JTextField(45);
year=new JTextField("Year Obtained ",17);
year.setFont(font);
year.setBackground(Color.white);
year.setEditable(false);

certname=new JTextField("Certificate Name ",50);
certname.setFont(font);
certname.setBackground(Color.white);
certname.setEditable(false);

blank5=new JTextField(60);
blank5.setBorder(wht);
EXPERIENCE=new JTextField("                                                                                         Experience",66);
EXPERIENCE.setFont(head);
EXPERIENCE.setBackground(back);
EXPERIENCE.setEditable(false);
str="Web Developer -\t\t (October 1997 to Present)\nSoftlabs Incorporated, Phoenix, AZ Creation of company web site for intranet and internet purposes.  Used Microsoft Front Page and HTML text editor tools.\n\nIntranet Development Manager - \t(September 1996 to January 1997)\nGemini Cap, Phoenix, AZ HTML; CGI; Perl; JAVA; Javascript; Photoshop Development of application to page people via intranet server, applets, and communication with Access database.";
description= new JTextArea(str,5,48);
description.setBorder(wht);
description.setLineWrap(true);



gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(NAME,gcons);
prevContact.add(NAME);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(blank,gcons);
prevContact.add(blank);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(CONTACT,gcons);
prevContact.add(CONTACT);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(address,gcons);
prevContact.add(address);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(ADDRESS,gcons);
prevContact.add(ADDRESS);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(telephone,gcons);
prevContact.add(telephone);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(TELEPHONE,gcons);
prevContact.add(TELEPHONE);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(mobile,gcons);
prevContact.add(mobile);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(MOBILE,gcons);
prevContact.add(MOBILE);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(email,gcons);
prevContact.add(email);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(EMAIL,gcons);
prevContact.add(EMAIL);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(blank1,gcons);
prevContact.add(blank1);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(personal,gcons);
prevContact.add(personal);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(supported,gcons);
prevContact.add(supported);

JTextField a1=new JTextField(15);JTextField b1=new JTextField(15);JTextField c1=new JTextField(15);JTextField d1=new JTextField(15);
a1.setBorder(wht);b1.setBorder(wht);c1.setBorder(wht);d1.setBorder(wht);
supported.add(age);
supported.add(AGE);
supported.add(dateofbirth);
supported.add(DATEOFBIRTH);
supported.add(nationality);
supported.add(NATIONALITY);
supported.add(gender);
supported.add(GENDER);
supported.add(maritalstatus);
supported.add(MARITALSTATUS);
supported.add(a1);
supported.add(b1);
supported.add(permanentresidence);
supported.add(PERMANENTRESIDENCE);
supported.add(c1);
supported.add(d1);

blank6=new JTextField(60);
blank6.setBorder(wht);
TOPSKILLS=new JTextField("                                                                                        Top Skills",66);
TOPSKILLS.setBackground(back);
TOPSKILLS.setEditable(false);

SKILL=new JTextField("Skills",15);
SKILL.setBackground(Color.white);
SKILL.setEditable(false);

YEARS=new JTextField("Years",15);
YEARS.setBackground(Color.white);
YEARS.setEditable(false);

PROFICIENCY=new JTextField("Proficiency",15);
PROFICIENCY.setBackground(Color.white);
PROFICIENCY.setEditable(false);

TOPSKILLS.setFont(font);
SKILL.setFont(font);
YEARS.setFont(font);
PROFICIENCY.setFont(font);


gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(blank2,gcons);
prevContact.add(blank2);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(EDUCATIONALBACKGROUND,gcons);
prevContact.add(EDUCATIONALBACKGROUND);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(HIGHESTEDUCATION,gcons);
prevContact.add(HIGHESTEDUCATION);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(level,gcons);
prevContact.add(level);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(LEVEL,gcons);
prevContact.add(LEVEL);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(major,gcons);
prevContact.add(major);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(MAJOR,gcons);
prevContact.add(MAJOR);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(university,gcons);
prevContact.add(university);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(UNIVERSITY,gcons);
prevContact.add(UNIVERSITY);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(locatedin,gcons);
prevContact.add(locatedin);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(LOCATEDIN,gcons);
prevContact.add(LOCATEDIN);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(grade,gcons);
prevContact.add(grade);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(GRADE,gcons);
prevContact.add(GRADE);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(graduationdate,gcons);
prevContact.add(graduationdate);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(GRADUATIONDATE,gcons);
prevContact.add(GRADUATIONDATE);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(blank3,gcons);
prevContact.add(blank3);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(SECONDHIGHESTEDUCATION,gcons);
prevContact.add(SECONDHIGHESTEDUCATION);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(level2,gcons);
prevContact.add(level2);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(LEVEL2,gcons);
prevContact.add(LEVEL2);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(major2,gcons);
prevContact.add(major2);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(MAJOR2,gcons);
prevContact.add(MAJOR2);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(institute,gcons);
prevContact.add(institute);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(INSTITUTE,gcons);
prevContact.add(INSTITUTE);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(locatedin2,gcons);
prevContact.add(locatedin2);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(LOCATEDIN2,gcons);
prevContact.add(LOCATEDIN2);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(grade2,gcons);
prevContact.add(grade2);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(GRADE2,gcons);
prevContact.add(GRADE2);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(graduationdate2,gcons);
prevContact.add(graduationdate2);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(GRADUATIONDATE2,gcons);
prevContact.add(GRADUATIONDATE2);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(blank4,gcons);
prevContact.add(blank4);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(PROFESSIONALCERTIFICATION,gcons);
prevContact.add(PROFESSIONALCERTIFICATION);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(year,gcons);
prevContact.add(year);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(certname,gcons);
prevContact.add(certname);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(certName1,gcons);
prevContact.add(certName1);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(cert1,gcons);
prevContact.add(cert1);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(certName2,gcons);
prevContact.add(certName2);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(cert2,gcons);
prevContact.add(cert2);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(certName3,gcons);
prevContact.add(certName3);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(cert3,gcons);
prevContact.add(cert3);



gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(blank5,gcons);
prevContact.add(blank5);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(EXPERIENCE,gcons);
prevContact.add(EXPERIENCE);

JTextField temp= new JTextField(15);temp.setBorder(wht);
temp.setBorder(wht);
gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(temp,gcons);
prevContact.add(temp);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(description,gcons);
prevContact.add(description);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(blank6,gcons);
prevContact.add(blank6);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(TOPSKILLS,gcons);
prevContact.add(TOPSKILLS);

JTextField temp1=new JTextField(15);
temp1.setBorder(wht);
gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(temp1,gcons);
prevContact.add(temp1);

skillpanel.add(SKILL);
skillpanel.add(YEARS);
skillpanel.add(PROFICIENCY);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(skillpanel,gcons);
prevContact.add(skillpanel);

JTextField temp7=new JTextField(15);
temp7.setBorder(wht);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(temp7,gcons);
prevContact.add(temp7);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(skillList,gcons);
prevContact.add(skillList);



skillList.add(skillarea);skillList.add(yeararea);skillList.add(proficiencyarea);
skillList.add(skillarea1);skillList.add(yeararea1);skillList.add(proficiencyarea1);
skillList.add(skillarea2);skillList.add(yeararea2);skillList.add(proficiencyarea2);
skillList.add(skillarea3);skillList.add(yeararea3);skillList.add(proficiencyarea3);
skillList.add(skillarea4);skillList.add(yeararea4);skillList.add(proficiencyarea4);

LanguagesList.add(languagesarea);LanguagesList.add(spokenarea);LanguagesList.add(writtenarea);
LanguagesList.add(languagesarea1);LanguagesList.add(spokenarea1);LanguagesList.add(writtenarea1);
LanguagesList.add(languagesarea2);LanguagesList.add(spokenarea2);LanguagesList.add(writtenarea2);
LanguagesList.add(languagesarea3);LanguagesList.add(spokenarea3);LanguagesList.add(writtenarea3);
LanguagesList.add(languagesarea4);LanguagesList.add(spokenarea4);LanguagesList.add(writtenarea4);
LanguagesList.setBackground(Color.white);
skillarea.setBorder(wht);
skillarea1.setBorder(wht);
skillarea2.setBorder(wht);
skillarea3.setBorder(wht);
skillarea4.setBorder(wht);
yeararea.setBorder(wht);
yeararea1.setBorder(wht);
yeararea2.setBorder(wht);
yeararea3.setBorder(wht);
yeararea4.setBorder(wht);
proficiencyarea.setBorder(wht);
proficiencyarea1.setBorder(wht);
proficiencyarea2.setBorder(wht);
proficiencyarea3.setBorder(wht);
proficiencyarea4.setBorder(wht);
languagesarea.setBorder(wht);
languagesarea1.setBorder(wht);
languagesarea2.setBorder(wht);
languagesarea3.setBorder(wht);
languagesarea4.setBorder(wht);
spokenarea.setBorder(wht);
spokenarea1.setBorder(wht);
spokenarea2.setBorder(wht);
spokenarea3.setBorder(wht);
spokenarea4.setBorder(wht);
writtenarea.setBorder(wht);
writtenarea1.setBorder(wht);
writtenarea2.setBorder(wht);
writtenarea3.setBorder(wht);
writtenarea4.setBorder(wht);


blank8=new JTextField(60);
blank8.setBorder(wht);
LANGUAGES=new JTextField("                                                                    Languages (Proficiency  0=Poor,10=Excellent) ",66);
LANGUAGES.setBackground(back);
LANGUAGES.setEditable(false);

languages=new JTextField("Languages",15);
languages.setEditable(false);
languages.setBackground(Color.white);

spoken=new JTextField("Spoken",15);
spoken.setEditable(false);
spoken.setBackground(Color.white);

written=new JTextField("Written",15);
written.setEditable(false);
written.setBackground(Color.white);

LANGUAGES.setFont(font);
languages.setFont(font);
spoken.setFont(font);
written.setFont(font);



gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(blank8,gcons);
prevContact.add(blank8);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(LANGUAGES,gcons);
prevContact.add(LANGUAGES);

JTextField temp9=new JTextField(15);
temp9.setBorder(wht);
gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(temp9,gcons);
prevContact.add(temp9);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(languagepanel,gcons);
prevContact.add(languagepanel);

languagepanel.add(languages);
languagepanel.add(spoken);
languagepanel.add(written);

JTextField temp10=new JTextField(15);
temp10.setBorder(wht);
gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(temp10,gcons);
prevContact.add(temp10);


gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(LanguagesList,gcons);
prevContact.add(LanguagesList);

LanguagesList.add(languagesarea);
LanguagesList.add(spokenarea);
LanguagesList.add(writtenarea);


blank9= new JTextField(60);
blank9.setBorder(wht);
addinfo= new JTextField("                                                                              Additional Information",66);
addinfo.setBackground(back);
addinfo.setEditable(false);

summer=new JTextField("Summer Jobs",15);
summer.setBackground(Color.white);
summer.setEditable(false);

project=new JTextField("Project Undertaken",15);
project.setBackground(Color.white);
project.setEditable(false);

extra=new JTextField("Extra Carricular Activities",15);
extra.setBackground(Color.white);
extra.setEditable(false);


addinfo.setFont(font);
summer.setFont(font);
project.setFont(font);
extra.setFont(font);

addArea=new JTextArea(5,48);
projctarea=new JTextArea(5,48);
summerarea=new JTextArea(5,48);
addArea.setBorder(wht);
projctarea.setBorder(wht);
summerarea.setBorder(wht);

addArea.setLineWrap(true);
projctarea.setLineWrap(true);
summerarea.setLineWrap(true);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(blank9,gcons);
prevContact.add(blank9);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(addinfo,gcons);
prevContact.add(addinfo);


gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(summer,gcons);
prevContact.add(summer);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(summerarea,gcons);
prevContact.add(summerarea);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(project,gcons);
prevContact.add(project);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(projctarea,gcons);
prevContact.add(projctarea);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(extra,gcons);
prevContact.add(extra);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(addArea,gcons);
prevContact.add(addArea);


blank10= new JTextField(60);
blank10.setBorder(wht);
references= new JTextField("                                                                                              Reference 1 ",60);
references1= new JTextField("                                                                                              Reference 2 ",60);
references.setBackground(back);
references1.setBackground(back);
references1.setEditable(false);
references.setEditable(false);
references.setFont(font);
references1.setFont(font);
RNAME= new JTextField("Name",15);
RNAME.setBackground(Color.white);
RNAME.setEditable(false);
RNAME.setFont(font);

TELEPHONENO= new JTextField("Telephone No",15);
TELEPHONENO.setFont(font);
TELEPHONENO.setBackground(Color.white);
TELEPHONENO.setEditable(false);

REMAIL= new JTextField("E-Mail",15);
REMAIL.setFont(font);
REMAIL.setBackground(Color.white);
REMAIL.setEditable(false);

POSITION= new JTextField("Position Title",15);
POSITION.setFont(font);
POSITION.setBackground(Color.white);
POSITION.setEditable(false);

COMPANY= new JTextField("Company Name",15);
COMPANY.setFont(font);
COMPANY.setBackground(Color.white);
COMPANY.setEditable(false);

RELATIONSHIP= new JTextField("Relationship",15);
RELATIONSHIP.setFont(font);
RELATIONSHIP.setBackground(Color.white);
RELATIONSHIP.setEditable(false);


RNAME1= new JTextField("Name",15);
RNAME1.setFont(font);
RNAME1.setBackground(Color.white);
RNAME1.setEditable(false);

TELEPHONENO1= new JTextField("Telephone No",15);
TELEPHONENO1.setFont(font);
TELEPHONENO1.setBackground(Color.white);
TELEPHONENO1.setEditable(false);

REMAIL1= new JTextField("E-Mail",15);
REMAIL1.setFont(font);
REMAIL1.setBackground(Color.white);
REMAIL1.setEditable(false);

POSITION1= new JTextField("Position Title",15);
POSITION1.setFont(font);
POSITION1.setBackground(Color.white);
POSITION1.setEditable(false);

COMPANY1= new JTextField("Company Name",15);
COMPANY1.setFont(font);
COMPANY1.setBackground(Color.white);
COMPANY1.setEditable(false);

RELATIONSHIP1= new JTextField("Relationship",15);
RELATIONSHIP1.setFont(font);
RELATIONSHIP1.setBackground(Color.white);
RELATIONSHIP1.setEditable(false);


 rname=new JTextField(45);
telephoneno=new JTextField(45);
remail=new JTextField(45);
position=new JTextField(45);
company=new JTextField(45);
relationship=new JTextField(45);

rname1=new JTextField(45);
telephoneno1=new JTextField(45);
remail1=new JTextField(45);
position1=new JTextField(45);
company1=new JTextField(45);
relationship1=new JTextField(45);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(blank10,gcons);
prevContact.add(blank10);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(references,gcons);
prevContact.add(references);


gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(RNAME,gcons);
prevContact.add(RNAME);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(rname,gcons);
prevContact.add(rname);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(TELEPHONENO,gcons);
prevContact.add(TELEPHONENO);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(telephoneno,gcons);
prevContact.add(telephoneno);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(REMAIL,gcons);
prevContact.add(REMAIL);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(remail,gcons);
prevContact.add(remail);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(POSITION,gcons);
prevContact.add(POSITION);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(position,gcons);
prevContact.add(position);


gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(COMPANY,gcons);
prevContact.add(COMPANY);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(company,gcons);
prevContact.add(company);


gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(RELATIONSHIP,gcons);
prevContact.add(RELATIONSHIP);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(relationship,gcons);
prevContact.add(relationship);


gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(references1,gcons);
prevContact.add(references1);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(RNAME1,gcons);
prevContact.add(RNAME1);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(rname1,gcons);
prevContact.add(rname1);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(TELEPHONENO1,gcons);
prevContact.add(TELEPHONENO1);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(telephoneno1,gcons);
prevContact.add(telephoneno1);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(REMAIL1,gcons);
prevContact.add(REMAIL1);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(remail1,gcons);
prevContact.add(remail1);

gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(POSITION1,gcons);
prevContact.add(POSITION1);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(position1,gcons);
prevContact.add(position1);


gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(COMPANY1,gcons);
prevContact.add(COMPANY1);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(company1,gcons);
prevContact.add(company1);


gcons.gridwidth=GridBagConstraints.RELATIVE;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(RELATIONSHIP1,gcons);
prevContact.add(RELATIONSHIP1);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(relationship1,gcons);
prevContact.add(relationship1);

JPanel buttonpanel=new JPanel();
Preview=new JButton("Print Resume");
Save=new JButton ("Save To Disk");
Exit=new JButton ("Exit");
Exit.addActionListener(this);
Preview.addActionListener(this);
Save.addActionListener(this);
gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.CENTER;
grid.setConstraints(buttonpanel,gcons);
prevContact.add(buttonpanel);
buttonpanel.add(new JLabel("  "));
buttonpanel.setBackground(Color.white);
buttonpanel.add(Preview);
buttonpanel.add(Save);
buttonpanel.add(Exit);

blank.setBorder(wht);
name.setBorder(wht);
address.setBorder(wht);
telephone.setBorder(wht);
mobile.setBorder(wht);
email .setBorder(wht);
NAME.setBorder(wht);
ADDRESS.setBorder(wht);
TELEPHONE.setBorder(wht);
MOBILE.setBorder(wht);
EMAIL.setBorder(wht);
CONTACT.setBorder(wht);
blank1.setBorder(wht);
personal.setBorder(wht);
age.setBorder(wht);
nationality.setBorder(wht);
maritalstatus.setBorder(wht);
permanentresidence.setBorder(wht);
dateofbirth.setBorder(wht);
gender.setBorder(wht);
AGE.setBorder(wht);
NATIONALITY.setBorder(wht);
MARITALSTATUS.setBorder(wht);
PERMANENTRESIDENCE.setBorder(wht);
DATEOFBIRTH.setBorder(wht);
GENDER .setBorder(wht);
blank2.setBorder(wht);
EDUCATIONALBACKGROUND.setBorder(wht);
HIGHESTEDUCATION.setBorder(wht);
LEVEL.setBorder(wht);
MAJOR.setBorder(wht);
UNIVERSITY.setBorder(wht);
LOCATEDIN.setBorder(wht);
GRADE.setBorder(wht);
GRADUATIONDATE.setBorder(wht);
level.setBorder(wht);
major.setBorder(wht);
university.setBorder(wht);
locatedin.setBorder(wht);
grade.setBorder(wht);
graduationdate.setBorder(wht);
blank3.setBorder(wht);
SECONDHIGHESTEDUCATION.setBorder(wht);
LEVEL2.setBorder(wht);
MAJOR2.setBorder(wht);
INSTITUTE.setBorder(wht);
LOCATEDIN2.setBorder(wht);
level2.setBorder(wht);
major2.setBorder(wht);
institute.setBorder(wht);
locatedin2.setBorder(wht);
grade2.setBorder(wht);
graduationdate2.setBorder(wht);
GRADE2.setBorder(wht);
GRADUATIONDATE2.setBorder(wht);
blank4.setBorder(wht);
PROFESSIONALCERTIFICATION.setBorder(wht);
certName1.setBorder(wht);
cert1.setBorder(wht);
certName2 .setBorder(wht);
cert2.setBorder(wht);
certName3 .setBorder(wht);
cert3.setBorder(wht);
year.setBorder(wht);
certname.setBorder(wht);
blank5.setBorder(wht);
EXPERIENCE.setBorder(wht);
blank6.setBorder(wht);
TOPSKILLS.setBorder(wht);
SKILL.setBorder(wht);
YEARS.setBorder(wht);
PROFICIENCY.setBorder(wht);
blank8.setBorder(wht);
LANGUAGES.setBorder(wht);
languages.setBorder(wht);
spoken.setBorder(wht);
written.setBorder(wht);
blank9.setBorder(wht);
addinfo.setBorder(wht);
summer.setBorder(wht);
project.setBorder(wht);
extra.setBorder(wht);
blank10.setBorder(wht);
references.setBorder(wht);
RNAME.setBorder(wht);
TELEPHONENO.setBorder(wht);
REMAIL.setBorder(wht);
POSITION.setBorder(wht);
COMPANY.setBorder(wht);
RELATIONSHIP.setBorder(wht);
RNAME1.setBorder(wht);
TELEPHONENO1.setBorder(wht);
REMAIL1.setBorder(wht);
POSITION1.setBorder(wht);
COMPANY1.setBorder(wht);
RELATIONSHIP1.setBorder(wht);
rname.setBorder(wht);
telephoneno.setBorder(wht);
remail.setBorder(wht);
position.setBorder(wht);
company.setBorder(wht);
relationship.setBorder(wht);
rname1.setBorder(wht);
telephoneno1.setBorder(wht);
remail1.setBorder(wht);
position1.setBorder(wht);
company1.setBorder(wht);
relationship1.setBorder(wht);
references1.setBorder(wht);
skillList.setBackground(Color.white);

prevContact.setBorder(new TitledBorder (new MatteBorder (new ImageIcon("border.jpg")),  "Resume Preview"));
prevContact.setBackground(Color.white);
frame.setVisible(true);
frame.setSize(600,300);
frame.getContentPane().add(scroll);
showrecord();
}
public void showrecord()
{

try
     {
	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	  con=DriverManager.getConnection("jdbc:odbc:resume1","sa","");
	  stat=con.createStatement();
	  result=stat.executeQuery("select * from resumebUILDER");
	  while(result.next())
	  	{
		  	
		  String S1=result.getString(1).trim();
		  	String S2=result.getString(2).trim();
		  	String S3=result.getString(3).trim();
		  	String S4=result.getString(4).trim();
		  	String S5=result.getString(5).trim();
		  	String S6=result.getString(6).trim();
		  	String S7=result.getString(7).trim();
		  	String S8=result.getString(8).trim();
		  	String S9=result.getString(9).trim();
		  	String S10=result.getString(10).trim();
		  	String S11=result.getString(11).trim();
		  	String S12=result.getString(12).trim();
		  	String S13=result.getString(13).trim();
		  	String S14=result.getString(14).trim();
		  	String S15=result.getString(15).trim();
		  	String S16=result.getString(16).trim();
		  	String S17=result.getString(17).trim();
		  	String S18=result.getString(18).trim();
		  	String S19=result.getString(19).trim();
		  	String S20=result.getString(20).trim();
		  	String S21=result.getString(21).trim();
		  	String S22=result.getString(22).trim();
		  	String S23=result.getString(23).trim();
		  	String S24=result.getString(24).trim();
		  	String S25=result.getString(25).trim();
		  	String S26=result.getString(26).trim();
		  	String S27=result.getString(27).trim();
		  	String S28=result.getString(28).trim();
		  	String S29=result.getString(29).trim();
		  	String S30=result.getString(30).trim();
		  	String S31=result.getString(31).trim();
		  	String S32=result.getString(32).trim();
		  	String S33=result.getString(33).trim();
		  	String S34=result.getString(34).trim();
		  	String S35=result.getString(35).trim();
		  	String S36=result.getString(36).trim();
		  	String S37=result.getString(37).trim();
		  	String S38=result.getString(38).trim();
		  	String S39=result.getString(39).trim();
		  	String S40=result.getString(40).trim();
		  	String S41=result.getString(41).trim();
		  	String S42=result.getString(42).trim();
		  	String S43=result.getString(43).trim();
		  	String S44=result.getString(44).trim();
		  	String S45=result.getString(45).trim();
		  	String S46=result.getString(46).trim();
		  	String S47=result.getString(47).trim();
		  	String S48=result.getString(48).trim();
		  	String S49=result.getString(49).trim();
		  	String S50=result.getString(50).trim();
		  	String S51=result.getString(51).trim();
		  	String S52=result.getString(52).trim();
		  	String S53=result.getString(53).trim();
		  	String S54=result.getString(54).trim();
		  	String S55=result.getString(55).trim();
		  	String S56=result.getString(56).trim();
		  	String S57=result.getString(57).trim();
		  	String S58=result.getString(58).trim();
		  	String S59=result.getString(59).trim();
		  	String S60=result.getString(60).trim();
		  	  	
		  	String S61=result.getString(61).trim();
		  
		  		String S62=result.getString(62).trim();
		  	String S63=result.getString(63).trim();
		  	String S64=result.getString(64).trim();
		  	String S65=result.getString(65).trim();
		  	String S66=result.getString(66).trim();
		  	String S67=result.getString(67).trim();
		  	String S68=result.getString(68).trim();
		  	String S69=result.getString(69).trim();
		  	String S70=result.getString(70).trim();
		  	
		  	
		  	String S71=result.getString(71).trim();
		  	String S72=result.getString(72).trim();
		  	String S73=result.getString(73).trim();
		  	String S74=result.getString(74).trim();
		  	String S75=result.getString(75).trim();
		  	String S76=result.getString(76).trim();
		  	String S77=result.getString(77).trim();		  	
		  	String S78=result.getString(78).trim();
		  	String S79=result.getString(79).trim();
		  	String S80=result.getString(80).trim();
		  	String S81=result.getString(81).trim();
		  	String S82=result.getString(82).trim();
		  	
		 // 	NAME.setText("Manish Kumar");
		  	NAME.setText(S1 + " " +S2);
			ADDRESS.setText(S11);
			TELEPHONE.setText(S10);
			MOBILE.setText(S9);
			EMAIL.setText(S7+ " & " + S8);

			AGE.setText("");
			NATIONALITY.setText(S6);
			MARITALSTATUS.setText(S5);
			PERMANENTRESIDENCE.setText(S15);
			DATEOFBIRTH.setText(S3);
			GENDER.setText(S4);
		  	
			
				
LEVEL.setText(S16);
MAJOR.setText(S17);
UNIVERSITY.setText(S21);
LOCATEDIN.setText(S22);
GRADE.setText(S18);
GRADUATIONDATE.setText(S23);

LEVEL2.setText(S24);
MAJOR2.setText(S25);
INSTITUTE.setText(S29);
LOCATEDIN2.setText(S30);
GRADE2.setText(S26);
GRADUATIONDATE2.setText(S31);

certName1.setText(S33);
cert1.setText(S32);
certName2.setText(S35);
cert2.setText(S34);
certName3.setText(S37);
cert3.setText(S36);

description.setText(str);//EXPERIENCE AREA

skillarea.setText(S38);
skillarea1.setText(S41);
skillarea2.setText(S44);
skillarea3.setText(S47);
skillarea4.setText(S50);

yeararea.setText(S39);
yeararea1.setText(S42);
yeararea2.setText(S45);
yeararea3.setText(S48);
yeararea4.setText(S51);

proficiencyarea.setText(S40);
proficiencyarea1.setText(S43);
proficiencyarea2.setText(S46);
proficiencyarea3.setText(S49);
proficiencyarea4.setText(S52);


languagesarea.setText(S53);
languagesarea1.setText(S56);
languagesarea2.setText(S59);
languagesarea3.setText(S62);
languagesarea4.setText(S65);

spokenarea.setText(S54);
spokenarea1.setText(S57);
spokenarea2.setText(S60);
spokenarea3.setText(S63);
spokenarea4.setText(S66);

writtenarea.setText(S55);
writtenarea1.setText(S58);
writtenarea2.setText(S61);
writtenarea3.setText(S64);
writtenarea4.setText(S67);

addArea.setText(S70);
projctarea.setText(S69);
summerarea.setText(S68);

rname.setText(S71);
telephoneno.setText(S73);
remail.setText(S74);
position.setText(S75);
company.setText(S76);
relationship.setText(S72);
rname1.setText(S77);
telephoneno1.setText(S79);
remail1.setText(S80);
position1.setText(S81);
company1.setText(S82);
relationship1.setText(S78);


		  }
	  }
catch(Exception e)
     {
       System.out.println("Error"+e);
     }
     
   }
   public void actionPerformed(ActionEvent evt)
   		{
	   		Object obj=evt.getSource();
	   		if(obj==Save)
	   		{
		   		FileDialog fd=new FileDialog(frame,"Save Resume",FileDialog.SAVE);
		   		fd.setVisible(true);
		   		fd.setLocation(400,500);
	   		}
	   		
	   		if(obj==Preview)
	   			{
		   			new SwingPrinter();
		   		}
	   		if(obj==Exit)
	   		{
		   			try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:resume1","sa","");
		PreparedStatement stat=con.prepareStatement("delete from resumeBuilder");
		stat.executeUpdate();
		frame.setVisible(false);

		}
	catch(Exception win)
	{
	}
	   		}
	   }
public static void main(String a[])
{
new preview();
}
}