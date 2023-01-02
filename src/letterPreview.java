
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;
import java.io.*;

public class letterPreview
{
JFrame frame;
JPanel panel;
JTextArea ta;
JToolBar tb;
BorderLayout border;
public letterPreview()
{
frame=new JFrame();
panel =new JPanel();
ta=new JTextArea(20,100);
ta.setText("Manish\n\n"+"Kumar\n\n"+"\t\tGupta");
tb=new JToolBar();
border=new BorderLayout();
panel.add(ta);
tb.add(new JButton("mans"));
frame.getContentPane().add(tb, BorderLayout.NORTH);
frame.getContentPane().add(panel, BorderLayout.CENTER);
frame.setVisible(true);
frame.setSize(499,300);
}
public static void main(String a[])
{
	new letterPreview();
}
}