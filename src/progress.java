import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class progress
{
 JLabel progressLabel;
 JProgressBar progressBar;
 JFrame frame;
 JPanel panel;

 public progress()
 {
 frame= new JFrame("Test");
 panel= new JPanel();

progressLabel= new JLabel("Hi");

progressBar= new JProgressBar();
   progressBar.setStringPainted(true);
        progressLabel.setLabelFor(progressBar);
//        progressBar.setAlignmentX(CENTER_ALIGNMENT);
        progressBar.setMinimum(0);
        progressBar.setValue(0);
		panel.add(progressLabel);
		panel.add(progressBar);

		progressBar.setMaximum(5);   
        progressLabel.setText("Loading Main Menu");
        new mainMenu();
        progressBar.setValue(progressBar.getValue() + 1);
        progressLabel.setText("Loading Resumes...");
        new resumeBuilder();
        progressBar.setValue(progressBar.getValue() + 1);
        progressLabel.setText("Loading All Java Files");
		new advise();new Appointment();new CascadeDemo();new toDoList();
        progressBar.setValue(progressBar.getValue() + 1);

		frame.getContentPane().add(panel);
		frame.setSize(300,400);
		frame.setVisible(true);
		}

		public static void main(String a[])
		{
		new progress();
		}
		}

