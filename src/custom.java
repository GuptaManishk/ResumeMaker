import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
public class custom
{
	JFrame frame;
	JPanel main;
	JCheckBox cb1;	
public custom()
{
frame=new JFrame("Custom Resume");
main=new JPanel();
cb1=new JCheckBox("Manish");
main.add(cb1);
main.setBorder(new TitledBorder(new MatteBorder(new ImageIcon("images//contactBorder.jpg"))));

frame.setLocation(0,70);
frame.getContentPane().add(main);
frame.setSize(800,500);
frame.setVisible(true);
}
public static void main(String a[])
{
new custom();
}
}
