

// Java AWT API
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Graphics;

// Java API Imports
import java.util.Date;
import java.awt.event.*;

// Swing API Imports
import javax.swing.JFrame;
import javax.swing.JWindow;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.DebugGraphics;



 class Splash extends JWindow implements MouseListener{
      
    int width;
    int height;
    

    public Splash(int w, int h) {
	super();
	width=w;
	height=h;
	this.init();
	this.addMouseListener(this);
    }

    public final void hideSplash() {
	try {
	    // Close and dispose Window in AWT thread
	    SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
			if(isVisible()) {
			    setVisible(false);
			    dispose();
			}
		    }
		});
	} catch(Exception e) {
	    e.printStackTrace();
	}
    }
    private void init() {
	// Set the Look & Feel for the app.
	//WindowsLookAndFeel wf=new WindowsLookAndFeel();
	try {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    //UIManager.setLookAndFeel(wf);
	   // SwingUtilities.updateComponentTreeUI(Splash.this);
	} catch (Exception e) {
	}

	// Setup label params.
JPanel content=new JPanel();
content.add(new JLabel(new ImageIcon("images//Splash.jpg")));
	
	this.setContentPane(content);
	this.setSize(400,225);

	Dimension WindowSize = this.getSize();
	Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
	this.setBounds((ScreenSize.width - WindowSize.width) / 2, (ScreenSize.height - WindowSize.height) / 2, WindowSize.width, WindowSize.height);
    }

    public static void main(String[] args) {
	Splash s = new Splash(400,200);
	s.showSplash();
	
    }
  
    public final void showSplash() {
	if(!this.isVisible()) {
	    this.setVisible(true);
	}
    }
public void mouseMoved(MouseEvent e) {this.setVisible(false);dispose();new profile();}
public void mouseReleased(MouseEvent e) {}
public void mouseExited(MouseEvent e) {this.setVisible(false);dispose();new profile();}
public void mouseEntered(MouseEvent e){this.setVisible(false);dispose();new profile();}
public void mouseDragged(MouseEvent e) {this.setVisible(false);dispose();new profile();}
public void mousePressed(MouseEvent e) {this.setVisible(false);dispose();new profile();}
 public void mouseClicked(MouseEvent e) {this.setVisible(false);dispose();new profile();}
}