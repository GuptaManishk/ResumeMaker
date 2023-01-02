//import javax.help.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;


public class mainMenu implements MouseListener,MouseMotionListener
{
JFrame frame;
JPanel main,centerpanel,upper;
JPanel south,west,east;
JPanel cenup,cendown,cenwest,cencenter,centrup;
BorderLayout border;
Border line;
JToolBar toolbar; 
JTextField urlField;
JButton resume,cover,contact,virtual,salary,expert,caster,job,mainmenu,exit;
JButton RESUME,COVER,CONTACT,VIRTUAL,SALARY,EXPERT,CASTER,JOB;
JLabel img;
Color color,color1;
JLabel help,user,exit1,cen;

GridBagLayout grid;
GridBagConstraints gcons;

public mainMenu()
{
frame = new JFrame("Resume Maker [ Main Menu ]");
main= new JPanel();
centerpanel= new JPanel();
upper=new JPanel();
cenup=new JPanel();
cendown=new JPanel();
cenwest=new JPanel();
cencenter=new JPanel();
centrup=new JPanel();
south=new JPanel();
west=new JPanel();
east=new JPanel();
color=new Color(66,140,247);
color1=new Color(128,128,128);
main.setBackground(color1);
centerpanel.setBackground(color1);
upper.setBackground(color1);
south.setBackground(color1);
west.setBackground(color1);
east.setBackground(color1);
cenup.setBackground(color1);
cendown.setBackground(color1);
cenwest.setBackground(color1);
cencenter.setBackground(color1);
centrup.setBackground(color1);

toolbar =new  JToolBar();
border=new BorderLayout();

grid= new GridBagLayout ();
gcons= new GridBagConstraints();



line = BorderFactory.createLineBorder(color1,2);
Border bb = BorderFactory.createLineBorder(Color.white);

main.setLayout(border);
upper.setLayout(new BorderLayout());
centerpanel.setLayout(new BorderLayout());
cencenter.setLayout(new BorderLayout());
cenwest.setLayout(grid);

main.add(upper, BorderLayout.NORTH);
main.add(centerpanel, BorderLayout.CENTER);
main.add(south, BorderLayout.SOUTH);
main.add(east, BorderLayout.EAST);
main.add(west,BorderLayout.WEST);

centerpanel.add(cenup,BorderLayout.NORTH);
centerpanel.add(cencenter,BorderLayout.CENTER);
cencenter.add(cendown,BorderLayout.SOUTH);
cencenter.add(cenwest,BorderLayout.WEST);
cencenter.add(centrup,BorderLayout.NORTH);

//cencenter.setBorder(new MatteBorder (new ImageIcon("images//bord1.jpg")));


centrup.setBackground(Color.white);
cenwest.setBackground(Color.white);

cendown.setBackground(color);
cencenter.setBackground(Color.white);
img=new JLabel("");
cencenter.add(img);

south.setBackground(color1);
west.setBackground(color1);
east.setBackground(color1);
centrup.add(new JLabel(new ImageIcon("images//upperMain.jpg")));

resume=new JButton(new ImageIcon("images//1.jpg"));
cover=new JButton(new ImageIcon("images//2.jpg"));
contact=new JButton(new ImageIcon("images//3.jpg"));
virtual=new JButton(new ImageIcon("images//4.jpg"));
salary=new JButton(new ImageIcon("images//5.jpg"));
expert=new JButton(new ImageIcon("images//6.jpg"));
caster=new JButton(new ImageIcon("images//7.jpg"));
job=new JButton(new ImageIcon("images//8.jpg"));
mainmenu=new JButton(new ImageIcon("images//9.jpg"));
exit=new JButton(new ImageIcon("images//10.jpg"));

toolbar =new  JToolBar();
toolbar.add(resume);

resume.setBorder(line);
cover.setBorder(line);
contact.setBorder(line);
virtual.setBorder(line);
salary.setBorder(line);
expert.setBorder(line);
caster.setBorder(line);
job.setBorder(line);
mainmenu.setBorder(line);
exit.setBorder(line);

toolbar.add(cover);
toolbar.add(contact);
toolbar.add(virtual);
toolbar.add(salary);
toolbar.add(expert);
toolbar.add(caster);
toolbar.add(job);
toolbar.add(mainmenu);
toolbar.add(exit);
toolbar.setBackground(new Color(209,209,206));

upper.add(toolbar,BorderLayout.NORTH);
east.setPreferredSize(new Dimension(100, 60));
west.setPreferredSize(new Dimension(100, 60));
south.setPreferredSize(new Dimension(100, 60));
cenwest.setPreferredSize(new Dimension(150, 80));
cencenter.setPreferredSize(new Dimension(280, 200));
upper.setBorder(new MatteBorder (new ImageIcon("images//bord.jpg")));

RESUME=new JButton(new ImageIcon("images//resume.jpg"));
COVER=new JButton(new ImageIcon("images//cover.jpg"));
CONTACT=new JButton(new ImageIcon("images//contact.jpg"));
VIRTUAL=new JButton(new ImageIcon("images//virtual.jpg"));
SALARY=new JButton(new ImageIcon("images//salary.jpg"));
EXPERT=new JButton(new ImageIcon("images//expert.jpg"));
CASTER=new JButton(new ImageIcon("images//caster.jpg"));
JOB=new JButton(new ImageIcon("images//job.jpg"));

RESUME.setBorder(bb);
COVER.setBorder(bb);
CONTACT.setBorder(bb);
VIRTUAL.setBorder(bb);
SALARY.setBorder(bb);
EXPERT.setBorder(bb);
CASTER.setBorder(bb);
JOB.setBorder(bb);


help=new JLabel(new ImageIcon("images//help.jpg"));
user=new JLabel(new ImageIcon("images//user.jpg"));
exit1=new JLabel(new ImageIcon("images//exit.jpg"));
cen=new JLabel("                                                          ");
cendown.add(help);
cendown.add(user);

cendown.add(exit1);

//cenwest.setBorder(new TitledBorder(new MatteBorder(new ImageIcon("images/border.jpg"))));
help.addMouseListener(this);
user.addMouseListener(this);
exit1.addMouseListener(this);

RESUME.addMouseListener(this);
COVER.addMouseListener(this);
CONTACT.addMouseListener(this);
VIRTUAL.addMouseListener(this);
SALARY.addMouseListener(this);
EXPERT.addMouseListener(this);
CASTER.addMouseListener(this);
JOB.addMouseListener(this);
resume.addMouseListener(this);
cover.addMouseListener(this);
contact.addMouseListener(this);
virtual.addMouseListener(this);
salary.addMouseListener(this);
expert.addMouseListener(this);
caster.addMouseListener(this);
job.addMouseListener(this);
mainmenu.addMouseListener(this);
exit.addMouseListener(this);

 
RESUME.setBackground(Color.white);
COVER.setBackground(Color.white);
CONTACT.setBackground(Color.white);
VIRTUAL.setBackground(Color.white);
SALARY.setBackground(Color.white);
EXPERT.setBackground(Color.white);
CASTER.setBackground(Color.white);
JOB.setBackground(Color.white);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=0;
gcons.gridy=0;
grid.setConstraints(RESUME,gcons);
cenwest.add(RESUME);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=0;
gcons.gridy=1;
grid.setConstraints(COVER,gcons);
cenwest.add(COVER);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=0;
gcons.gridy=2;
grid.setConstraints(CONTACT,gcons);
cenwest.add(CONTACT);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=0;
gcons.gridy=3;
grid.setConstraints(VIRTUAL,gcons);
cenwest.add(VIRTUAL);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=0;
gcons.gridy=4;
grid.setConstraints(SALARY,gcons);
cenwest.add(SALARY);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=0;
gcons.gridy=5;
grid.setConstraints(EXPERT,gcons);
cenwest.add(EXPERT);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=0;
gcons.gridy=6;
grid.setConstraints(CASTER,gcons);
cenwest.add(CASTER);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=0;
gcons.gridy=7;
grid.setConstraints(JOB,gcons);
cenwest.add(JOB);



frame.setVisible(true);
frame.setSize(800,600);
frame.getContentPane().add(main);
//frame.setIcon(new ImageIcon("images//resume1.jpg"));
}

public void out()
{
	int result = JOptionPane.showConfirmDialog(frame," Do You Really  Want To Exit  ");
	if(result == JOptionPane.YES_OPTION) 
		   	{
			   	System.exit(0);
			}
	
}
void wordopen(String filename)
{
Runtime r = Runtime.getRuntime();
Process p = null;
try
	 {

String fi=filename;

String cmd[] = { "C:/Program Files/Internet Explorer/Iexplore", fi };
	    p = r.exec(cmd);
	}
	 catch (Exception e) 
	{
	    System.out.println("error executing " +e);
	}
}
  public void mouseClicked(MouseEvent e)
 {
Object ob=e.getSource();
if(ob==help){wordopen("D:/Project/Help/intro.html");}
if(ob==user){new profile();}
if(ob==exit1){out();}
if(ob==RESUME){new openResume();}
if(ob==COVER){new openCover();}
if(ob==CONTACT){new contactManager();}
if(ob==VIRTUAL){new interview();}
if(ob==SALARY){new salary();}
if(ob==EXPERT){new advise();}
if(ob==CASTER){new resumecaster();}
if(ob==JOB){new Swingscape();}
if(ob==resume){new openResume();}
if(ob==cover){new openCover();}
if(ob==contact){new contactManager();}
if(ob==virtual){new interview();}
if(ob==salary){new salary();}
if(ob==expert){new advise();}
if(ob==caster){new resumecaster();}
if(ob==job){new Swingscape();}
if(ob==mainmenu){frame.setVisible(false);frame.setVisible(true);}
if(ob==exit){out();}
}
public void mouseDragged(MouseEvent e) {}
  public void mouseMoved(MouseEvent e) {}
  public void mousePressed(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {img.setIcon(new ImageIcon("images//main.jpg"));}
  


public void mouseEntered(MouseEvent e) {

Object obj=e.getSource();

if(obj==RESUME){img.setIcon(new ImageIcon("images//resume1.jpg"));}
if(obj==COVER){img.setIcon(new ImageIcon("images//Letter.jpg"));}
if(obj==CONTACT){img.setIcon(new ImageIcon("images//Manag.jpg"));}
if(obj==VIRTUAL){img.setIcon(new ImageIcon("images//Video.jpg"));}
if(obj==SALARY){img.setIcon(new ImageIcon("images//Salary1.jpg"));}
if(obj==EXPERT){img.setIcon(new ImageIcon("images//Expert1.jpg"));}
if(obj==CASTER){img.setIcon(new ImageIcon("images//Poster.jpg"));}
if(obj==JOB){img.setIcon(new ImageIcon("images//Finder.jpg"));}

}


public static void main(String a[])
{
new mainMenu();
}
}


