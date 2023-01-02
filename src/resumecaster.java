
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class resumecaster implements ActionListener
{
JFrame frame;
JPanel main,panel1,panel2,panel3,panel4;

BorderLayout border;

JButton submit,edit,delete,viewreport,jobsearch,exit;
JLabel sign;

public resumecaster()
{
frame=new JFrame("Resume Caster");

main=new JPanel();
panel1=new JPanel();
panel2=new JPanel();
panel3=new JPanel();
panel4=new JPanel();
border=new BorderLayout();


main.setLayout(border);

main.add(panel1,BorderLayout.CENTER);
main.add(panel2,BorderLayout.SOUTH);
main.add(panel3,BorderLayout.WEST);
main.add(panel4,BorderLayout.NORTH);
panel1.add(new JLabel(new ImageIcon("images//overview.jpg")));
panel4.add(new JLabel(new ImageIcon("images//resumecaster.gif")));

panel1.setBackground(Color.white);
panel2.setBackground(Color.white);
panel3.setBackground(Color.white);
panel4.setBackground(Color.white);


submit=new JButton("Submit Resume");
submit.addActionListener(this);
edit=new JButton("Edit Resume");
delete=new JButton("Delete Resume");
viewreport=new JButton("View Report");
exit=new JButton("Exit");
jobsearch=new JButton("Job Search Agents");
sign=new JLabel("----------------------------");
panel1.setBorder(new MatteBorder (new ImageIcon("images//casterborder.jpg")));

Border lineb = BorderFactory.createLineBorder(Color.white);

submit.setBackground(Color.white);
edit.setBackground(Color.white);
delete.setBackground(Color.white);
viewreport.setBackground(Color.white);
jobsearch.setBackground(Color.white);
exit.setBackground(Color.white);
submit.setEnabled(true);
edit.setEnabled(false);
delete.setEnabled(false);
viewreport.setEnabled(false);
jobsearch.setEnabled(false);
exit.addActionListener(this);

GridLayout gg=new GridLayout(7,1);
panel3.setLayout(gg);
panel3.add(submit);
panel3.add(edit);
panel3.add(delete);
panel3.add(sign);
panel3.add(viewreport);
panel3.add(jobsearch);
panel3.add(exit);

frame.getContentPane().add(main);
frame.setVisible(true);
frame.setSize(800,600);
frame.setLocation(0,70);
}

public void actionPerformed(ActionEvent ev)
{
Object obj=ev.getSource();
if(obj==submit)
		{
		new Swingscape();
		JOptionPane.showMessageDialog(frame,"Please Check Your Internet Connection\nor You may Contact to Your ISP","Internet Connection Required",JOptionPane.WARNING_MESSAGE);
		}
else if(obj==exit)
	{
	int result = JOptionPane.showConfirmDialog(frame," Do You Really  Want To Exit  ");
	if(result == JOptionPane.YES_OPTION) 
		   	{
			   frame.setVisible(false);
			}
	
		}
	}


public static void main(String a[])
{
new resumecaster();
}}