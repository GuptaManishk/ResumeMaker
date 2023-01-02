import Notes;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class contactTab extends JFrame 
{
	JFrame frame;
	JPanel panel1,panel2,panel3,panel4,panel5;
	JPanel sub1,sub2;
	JPanel sub21,sub22,sub23;
	JPanel sub31,sub32;
	JPanel sub41,sub42;
	JTextArea ta1,ta2,ta3,ta4,ta5;
	JTextArea benifit, expe,requ,des;
	JTextField t1,t2,t3,t4;
	JTextArea notes;
	JLabel website,size;
	JLabel pos,salary;
	JTabbedPane tab;
	BorderLayout border;
	GridBagLayout grid;
	GridBagConstraints gcons;
	Notes note;
	JScrollPane jsp,jsp1,jsp2,jsp3,jsp4,jsp5,jsp6,jsp7,jsp8,jsp9;
	JButton  chk,apt,newdo,edit,del;
	JButton entry, delete,editentry;
	public contactTab()
	{
	frame = new JFrame();
	panel1 = new JPanel();
	panel2 = new JPanel();
	panel3= new JPanel();
	panel4= new JPanel();
	panel5= new JPanel();
//sub panels for panel 1
	sub1= new JPanel();
	sub2= new JPanel();

//sub panels for panel2

sub21= new JPanel();
sub22= new JPanel();
sub23= new JPanel();

//sub panels for panel3
sub31= new JPanel();
sub32= new JPanel();

//sub panels for 4th panel
sub41= new JPanel();
sub42= new JPanel();

	Color green= new Color(173,214,255);

	panel1.setBackground(green);
	panel2.setBackground(green);
	panel3.setBackground(green);
	panel4.setBackground(green);
	panel5.setBackground(green);
	sub1.setBackground(green);
	sub2.setBackground(green);
	sub21.setBackground(green);
	sub22.setBackground(green);
	sub23.setBackground(green);
	sub31.setBackground(green);
	sub32.setBackground(green);
	sub41.setBackground(green);
	sub42.setBackground(green);
note= new Notes();
panel5.add(note.frameContainer);
	border= new BorderLayout();
	grid= new GridBagLayout ();
	gcons= new  GridBagConstraints();


	sub1.setLayout(grid);
	sub2.setLayout(grid);
	sub21.setLayout(grid);
	sub22.setLayout(grid);
	//sub31.setLayout(grid);
	sub32.setLayout(grid);
//	sub41.setLayout(grid);
	//sub42.setLayout(grid);
	//panel2.setLayout(border);

	chk= new JButton("Check List");
	apt= new JButton("New Appointment");
	newdo= new JButton("New To Do");
	edit= new JButton("Edit");
	del= new JButton("Delete");
entry= new JButton("New Entry");
	 delete= new JButton("Delete");
	editentry= new JButton("Edit");;
//Labels Panels textarea for panel1
	website= new JLabel("Company Website");
	size= new JLabel("Company Size");
	pos= new JLabel("Position Title");
	salary= new JLabel("Salary Range");


	ta1= new JTextArea(6,32);
	ta2= new JTextArea(5,32);
	ta3= new JTextArea(5,32);
	ta4= new JTextArea(5,32);
	ta5= new JTextArea(5,32);
	benifit= new JTextArea(5,32);
	 expe= new JTextArea(5,32);
	 requ= new JTextArea(5,32);
	 des= new JTextArea(5,67);	 
	 notes= new JTextArea(20,52);
	t1= new JTextField(20);
	t2= new JTextField(20);
	t3= new JTextField(20);
	t4= new JTextField(20);


int	v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
jsp= new JScrollPane(panel1,v,h);
jsp1= new JScrollPane(ta1,v,h);
jsp2= new JScrollPane(ta2,v,h);
jsp3= new JScrollPane(ta3,v,h);
jsp4= new JScrollPane(ta4,v,h);
jsp5= new JScrollPane(ta5,v,h);
jsp6= new JScrollPane(benifit,v,h);
jsp7= new JScrollPane(expe,v,h);
jsp8= new JScrollPane(requ,v,h);
jsp9= new JScrollPane(des,v,h);

	panel1.add("East",sub1);
	panel1.add("West",sub2);
	//panel5.add(notes);
	ta1.setBorder(new TitledBorder("Key Personal"));
	ta2.setBorder(new TitledBorder("Additional Location"));
	ta3.setBorder(new TitledBorder("Key Products or Services"));
	ta4.setBorder(new TitledBorder("Company Strength"));
	ta5.setBorder(new TitledBorder("Recent Press or Award"));
	benifit.setBorder(new TitledBorder("Benifits"));
 expe.setBorder(new TitledBorder("Required Experience"));
 requ.setBorder(new TitledBorder("How You Meet Requirements"));
 des.setBorder(new TitledBorder("Description of Position"));
//end of component of panel 1


	tab= new JTabbedPane();
	tab.addTab("  Information    ", null, jsp, "P Details");
    tab.addTab("    Position     ", null, panel2, "G Details");

	tab.addTab("       Notes     ", null, panel5, "P Details");
	tab.setSize(70,100);
final String [] colheds={"    ","Date","Descripation"};
//for(int i=0;i<=10;++i)
//	for (int j=0;j=3;++j )
	final Object[] [] data={{"Man","Manish","Ambar"}};
	


panel2.add("West",sub21);
panel2.add("East",sub22);
panel2.add("South",sub23);
panel3.add("West",sub31);
panel3.add("Center",sub32);
sub31.setBackground(Color.black);
sub32.setBackground(Color.blue);


String[] columns = {"  ","Date","Description"};
 Object[][] cells = {{"zvga-1234","Video Card","$50"},
  {"56m-11","56K Modem","$315"},
  {"dc-10","Net Card","$499"}};
 JTable table = new JTable(cells,columns);
  JScrollPane js=new JScrollPane(table,v,h);
//sub32.add(js);

String[] column = {"  ","Date","Description"};
 Object[][] cell = {{"","",""},
  {"","",""},
  {"","",""}};
 JTable table1 = new JTable(cell,column);
  JScrollPane js1=new JScrollPane(table1,v,h);
//sub42.add(js1);
panel3.add("East",sub32);
panel4.add("Center",sub41);
panel4.add("East",sub42);
//panel1.setBorder(new TitledBorder("Manish"));

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=1;
grid.setConstraints(website,gcons);
sub1.add(website);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=2;
grid.setConstraints(t1,gcons);
sub1.add(t1);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=3;
grid.setConstraints(size,gcons);
sub1.add(size);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=4;
grid.setConstraints(t2,gcons);
sub1.add(t2);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=5;
grid.setConstraints(jsp1,gcons);
sub1.add(jsp1);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=6;
grid.setConstraints(jsp2,gcons);
sub1.add(jsp2);



gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=1;
grid.setConstraints(jsp3,gcons);
sub2.add(jsp3);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=2;
grid.setConstraints(jsp4,gcons);
sub2.add(jsp4);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=3;
grid.setConstraints(jsp5,gcons);
sub2.add(jsp5);


//for panel 2


gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=1;
grid.setConstraints(pos,gcons);
sub21.add(pos);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=2;
grid.setConstraints(t3,gcons);
sub21.add(t3);



gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=3;
grid.setConstraints(salary,gcons);
sub21.add(salary);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=4;
grid.setConstraints(t4,gcons);
sub21.add(t4);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=5;
grid.setConstraints(jsp6,gcons);
sub21.add(jsp6);


gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=1;
grid.setConstraints(jsp7,gcons);
sub22.add(jsp7);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=2;
grid.setConstraints(jsp8,gcons);
sub22.add(jsp8);

sub23.add(jsp9);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=1;
grid.setConstraints(chk,gcons);
sub31.add(chk);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=2;
grid.setConstraints(apt,gcons);
sub31.add(apt);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=3;
grid.setConstraints(newdo,gcons);
sub31.add(newdo);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=4;
grid.setConstraints(edit,gcons);
sub31.add(edit);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=5;
grid.setConstraints(del,gcons);
sub31.add(del);

//sub31.setLayout(grid);
sub32.setLayout(grid);
gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=1;
grid.setConstraints(entry,gcons);
sub41.add(entry);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=2;
grid.setConstraints(editentry,gcons);
sub41.add(editentry);

gcons.anchor= GridBagConstraints.NORTHWEST;
gcons.gridx=1;
gcons.gridy=3;
grid.setConstraints(delete,gcons);
sub41.add(delete);


tab.setPreferredSize(new Dimension(550, 350));
tab.setBackgroundAt(0,new Color(173,214,255));
tab.setBackgroundAt(1,new Color(173,214,255));
tab.setBackgroundAt(2,new Color(173,214,255));
frame.getContentPane().add(tab);
 frame.setSize(550,450);
//      frame.setVisible(true);

}
public static void main(String a[])
	{
	contactTab ct= new contactTab();
	}
}
