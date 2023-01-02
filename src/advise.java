import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
public class advise implements ActionListener// MouseListener,MouseMotionListener
{
JFrame frame;
JPanel main;
JPanel add1,add2;
BorderLayout border;
JButton resume,letter,job,interview,career,salary,benifit,hlp,ext;
GridBagLayout grid;
GridBagConstraints gcons;
JLabel image,tips;
ImageIcon icon;
Color green;
public advise()
{
frame=new JFrame("Expert Advise");
main=new JPanel();

add1=new JPanel();
add2=new JPanel();


border=new BorderLayout();
main.setLayout(border);
grid= new GridBagLayout ();
gcons= new GridBagConstraints();
	

JScrollPane jsp=new JScrollPane(add2);
	
main.add(add1,BorderLayout.WEST);
main.add(jsp,BorderLayout.CENTER);

icon=new ImageIcon("images//expertadvise.gif");
image=new JLabel(icon);

add2.add(image);
green=new Color(173,214,255);
add2.setBorder(new MatteBorder (new ImageIcon("images//contactBorder.jpg")));
add2.setBackground(green);
add1.setBackground(green);

tips=new JLabel(new ImageIcon("images//experthead.jpg"));
resume=new JButton(new ImageIcon("images//r1.gif"));
letter=new JButton(new ImageIcon("images//r2.gif"));
job=new JButton(new ImageIcon("images//r3.gif"));
interview=new JButton(new ImageIcon("images//r7.gif"));
career=new JButton(new ImageIcon("images//r4.gif"));
salary=new JButton(new ImageIcon("images//r5.gif"));
benifit=new JButton(new ImageIcon("images//r6.gif"));
hlp=new JButton(new ImageIcon("images//help.gif"));
ext=new JButton(new ImageIcon("images//mainmenu.gif"));

Border lineb = BorderFactory.createLineBorder(new Color(173,214,255));
resume.setBorder(lineb);
letter.setBorder(lineb);
job.setBorder(lineb);
interview.setBorder(lineb);
career.setBorder(lineb);
salary.setBorder(lineb);
benifit.setBorder(lineb);
hlp.setBorder(lineb);
ext.setBorder(lineb);

resume.setBackground(green);
letter.setBackground(green);
job.setBackground(green);
interview.setBackground(green);
career.setBackground(green);
salary.setBackground(green);
benifit.setBackground(green);
hlp.setBackground(green);
ext.setBackground(green);

resume.addActionListener(this);
letter.addActionListener(this);
job.addActionListener(this);
interview.addActionListener(this);
career.addActionListener(this);
salary.addActionListener(this);
benifit.addActionListener(this);
hlp.addActionListener(this);
ext.addActionListener(this);
add1.setLayout(grid);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(tips,gcons);
add1.add(tips);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(resume,gcons);
add1.add(resume);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(letter,gcons);
add1.add(letter);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(job,gcons);
add1.add(job);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(interview,gcons);
add1.add(interview);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(career,gcons);
add1.add(career);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(salary,gcons);
add1.add(salary);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(benifit,gcons);
add1.add(benifit);


gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(hlp,gcons);
add1.add(hlp);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(ext,gcons);
add1.add(ext);

JLabel ll=new JLabel(new ImageIcon("images//down.jpg"));
gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridwidth=GridBagConstraints.REMAINDER;
grid.setConstraints(ll,gcons);
add1.add(ll);

add1.setBorder(new TitledBorder(new MatteBorder(new ImageIcon("images//contactBorder.jpg"))));

frame.setLocation(0,70);
frame.getContentPane().add(main);
frame.setSize(800,500);
frame.setVisible(true);

}/*
public void mouseMoved(MouseEvent e) {}
public void mouseReleased(MouseEvent e) {}
public void mouseExited(MouseEvent e) {}
public void mouseEntered(MouseEvent e){}
public void mouseDragged(MouseEvent e) {}
public void mousePressed(MouseEvent e) {}
public void mouseClicked(MouseEvent e) */
	public void actionPerformed(ActionEvent e)
	{
		Object obj=e.getSource();
		//if(obj==tips){image.setIcon();}
		if(obj==resume){image.setIcon(new ImageIcon("images//resumeTips.jpg"));}
		if(obj==letter){image.setIcon(new ImageIcon("images//CoverTips.jpg"));}
		if(obj==job){image.setIcon(new ImageIcon("images//jobTips.jpg"));}
		if(obj==interview){image.setIcon(new ImageIcon("images//Interviewing.jpg"));}
		if(obj==career){image.setIcon(new ImageIcon("images//careerPlanning.jpg"));}
		if(obj==salary){image.setIcon(new ImageIcon("images//salarytips.jpg"));}
		if(obj==benifit){image.setIcon(new ImageIcon("images//Benifits.jpg"));}
		if(obj==ext){frame.setVisible(false);}
		
	}

public static void main(String a[])
{
new advise();
}
}