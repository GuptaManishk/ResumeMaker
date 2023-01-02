import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.undo.UndoManager;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Notes extends JFrame implements ActionListener{
 public static int WIDTH = 600;
 public static int HEIGHT = 700;
 public static String TITLE = "Notes";

JFrame frame= new JFrame();
JPanel panel= new JPanel();
private UndoManager um;
int j2;
    public void undoableEditHappened(UndoableEditEvent undoableeditevent)
    {
        um.addEdit(undoableeditevent.getEdit());
    }

Container frameContainer;
 // Swing components
Color green= new Color(187,200,150);
JToolBar toolBar = new JToolBar();


int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
JTextArea textarea= new JTextArea(18,45);
JLabel linedisplay = new JLabel("manish ", 4);



 JScrollPane jsp= new JScrollPane(textarea,v,h);
 String[] iconFiles = {"new.jpg","open.jpg","save.jpg","cut.jpg",
  "copy.jpg","paste.jpg","undo.jpg","redo.jpg","ucase.jpg","lcase.jpg",
  "go.jpg"};
 String[] buttonLabels = {"New","Open","Save","Cut","Copy","Paste","Undo","Redo","UCASE","lcase","goto",};
 ImageIcon[] icons = new ImageIcon[iconFiles.length];
 JButton[] buttons = new JButton[buttonLabels.length];
 JMenuBar menuBar = new JMenuBar();
 JMenu fileMenu = new JMenu("File");
 JMenuItem fileExit = new JMenuItem("Exit");
 
 public Notes() {
  super(TITLE);
  buildGUI();
  setupEventHandlers();
  setSize(WIDTH,HEIGHT);
//show();
 }
 
 void buildGUI() {
  setupMenuBar();
  layoutComponents();
 }

 void setupMenuBar() {
  fileMenu.add(fileExit); 
  menuBar.add(fileMenu);
  setJMenuBar(menuBar);
 }

 public void layoutComponents() {

frameContainer=getContentPane();
frameContainer.add(jsp);
textarea.setVisible(false);
  frame.getContentPane().add(panel);
panel.setLayout(new BorderLayout());
  for(int i=0;i<buttonLabels.length;++i) {
   icons[i] = new ImageIcon(iconFiles[i]);
   buttons[i] = new JButton(icons[i]);
   buttons[i].setToolTipText(buttonLabels[i]);
   if(i==15) toolBar.addSeparator();
   toolBar.add(buttons[i]);
   buttons[i].addActionListener(this);
textarea.setVisible(true);
   
  }
  frameContainer.add("North",toolBar);
 }

 void setupEventHandlers() {
  addWindowListener(new WindowHandler());
  fileExit.addActionListener(new MenuItemHandler());
 }

 public static void main(String[] args) {
   Notes app = new Notes();
 }

 public class WindowHandler extends WindowAdapter {
  public void windowClosing(WindowEvent e) {
   System.exit(0);
  }
 }

 public class MenuItemHandler implements ActionListener {
  public void actionPerformed(ActionEvent e) {
   String cmd = e.getActionCommand();
   if(cmd.equals("Exit")) System.exit(0);
  }
 }


  public void actionPerformed(ActionEvent ae) 
{
	Object obj=ae.getSource();
	if(obj==buttons[3])
	{
	            textarea.cut();
	}

	if(obj==buttons[4])
	{
	            textarea.copy();
	}
	if(obj==buttons[5])
	{
	            textarea.paste();
	}

if(obj==buttons[6])
	{
	         textarea.selectAll();
	}

if(obj==buttons[7])
	{
                textarea.setLineWrap(true);
                //textarea.setHorizontalScrollBarPolicy(31);
                linedisplay.setVisible(false);
	}
else
  {
                textarea.setLineWrap(false);
                //textarea.setHorizontalScrollBarPolicy(30);
                linedisplay.setVisible(true);
            }

if(obj==buttons[8])
	{
	         
 int k = textarea.getSelectionStart();
            int j1 = textarea.getSelectionEnd();
            try
            {
                textarea.replaceRange(textarea.getText(k, j1 - k).toUpperCase(), k, j1);
            }
            catch(Exception _ex) { }

	}
/////////9999999999999
if(obj==buttons[9])
	{
            int j = textarea.getSelectionStart();
            int i1 = textarea.getSelectionEnd();
            try
            {
                textarea.replaceRange(textarea.getText(j, i1 - j).toLowerCase(), j, i1);
            }
            catch(Exception _ex) { }	            

	}
/////////////10000000
if(obj==buttons[10])
	{
JTextField jtextfield = new JTextField();
            Object aobj[] = new Object[2];
            aobj[0] = new JLabel("Go To line number:", 0);
            aobj[1] = jtextfield;
            String as[] = {
                "OK", "Cancel"
            };
            int k1 = JOptionPane.showOptionDialog(this, ((Object) (aobj)), "Go To", -1, -1, null, as, as[0]);
            if(k1 == 0)
            {
                int i2 = 0;
                boolean flag = false;
                try
                {
                    i2 = Integer.parseInt(jtextfield.getText());
                }
                catch(NumberFormatException _ex)
                {
                    i2 = 1;
                }
                try
                {
                    int j2 = textarea.getLineStartOffset(i2 - 1);
                    textarea.setCaretPosition(j2);
                }
                catch(BadLocationException _ex)
                {
                    JOptionPane.showMessageDialog(this, "Invalid Line Number Entered\n Line  Not Exist.", "ERROR", 0);
                }
            }
	}
////////////////////

	if(obj==buttons[0])
	{
       {
            Date date = new Date();
            GregorianCalendar gregoriancalendar = new GregorianCalendar();
            gregoriancalendar.setTime(date);
            String s2 = gregoriancalendar.get(10) + ":" + gregoriancalendar.get(12) + ":" + gregoriancalendar.get(13) + " - " + gregoriancalendar.get(5) + "/" + gregoriancalendar.get(2) + "/" + gregoriancalendar.get(1);
            textarea.setText(s2);
            
        }
	}
	if(obj==buttons[1])
	{
	try
	
	{
	 JFileChooser jfilechooser = new JFileChooser();
	jfilechooser.setBackground(green);
             int  i = jfilechooser.showOpenDialog(this);
               if(i == 0)
		{
                    setCursor(new Cursor(3));
                    File file2 = jfilechooser.getSelectedFile();
                    RandomAccessFile randomaccessfile1 = new RandomAccessFile(file2, "r");
                    byte abyte1[] = new byte[(int)randomaccessfile1.length()];
                    randomaccessfile1.readFully(abyte1, 0, abyte1.length);
                    String s2 = new String(abyte1);
                    randomaccessfile1.close();
		textarea.setText(s2);
		}
}
	
catch(Exception ex)
{
System.out.println("error" +ex);
}

}
		if(obj==buttons[2])
	{
{
            JFileChooser jfilechooser = new JFileChooser();
		jfilechooser.setBackground(green);
            int l = jfilechooser.showSaveDialog(this);
            if(l == 0)
                try
                {
                    File file = jfilechooser.getSelectedFile();
                    FileOutputStream fileoutputstream = new FileOutputStream(file);
                    fileoutputstream.write(textarea.getText().getBytes());
                    setTitle(file.getPath());
                    fileoutputstream.close();
                }
                catch(Exception exception)
                {
                    JOptionPane.showMessageDialog(this, exception.getMessage(), "Unable to Save File", 0);
                }
}//fd1.setVisible(true);
	}
}
}
