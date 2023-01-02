import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import java.net.*;


public class interview implements ActionListener,ListSelectionListener
{
JFrame frame;
JPanel main,panel1,panel2,panel3,panel4;
JPanel subpanel31;
JPanel HELP;
JLabel image;
BorderLayout border;
GridBagLayout grid;
GridBagConstraints gcons;
Font font,font1;
JButton ques,ans,rat;
JButton l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
JButton l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22;
final JList list;
JWindow win;
String str;
JScrollPane scrollPane ;
ImageIcon icimage;
AudioClip testClip;
URL testUrl;
JButton hlp,clz;
Color clo;
   

public static void main(String a[])
{
new interview();
}

 
public interview()
{
frame=new JFrame();
win=new JWindow(frame);
main=new JPanel();
panel1=new JPanel();
panel2=new JPanel();
panel3=new JPanel();
panel4=new JPanel();
subpanel31=new JPanel();
HELP=new JPanel();

font = new  Font ("Times New Roman",Font.PLAIN,12);
font1 = new  Font ("Arial",Font.BOLD,18);

border=new BorderLayout();
grid= new GridBagLayout();
gcons= new GridBagConstraints();
main.setLayout(border);
JScrollPane jsp=new JScrollPane(panel2);

main.add(panel3,BorderLayout.WEST);
main.add(jsp,BorderLayout.CENTER);
main.add(panel1,BorderLayout.NORTH);
main.add(panel4,BorderLayout.SOUTH);


String str[]={"How did you hear about the job opening?","Tell me about yourself?","Why are you leaving your current position?","Tell me about your work history?","Why have you had so many different jobs recently?","Tell me about your specific responsibilities you had in last position?","What are something that motivated you? ","Of the employers you have work for recently, which did you like most? Why?","If I asked your previous manager or co-workers what areas you could most improve, what would they say?","What were some of the problems you encountered in your last job and how did you manage them?","Give me an example of how would solve a problem in the workplace?","What do you know about our company's product & Services?","In what ways do you feel you can contribute to our company's goals?","Describe your ideal job?","What are your expectation of this job?","What do you think is the greatest challenge facing your field today?","What do you consider your greatest strengths and assets?","Of which job accomplishment are you most proud and why?","Tell me some of your weaknesses and how can you improve them?","Tell me about your education?","What work related goals do you have for the next few years?","Would you rather work with others or alone? Are you a follower or a leader?","What makes you unique and why should we hire you over any other candidates?","What salary range are you currently seeking?","Are you looking at any other employers or do you have nay other offers?"};


panel1.add(new JLabel(new ImageIcon("images//virtualinterview.gif")));

ques=new JButton("Question");
ans=new JButton("Answer");
rat=new JButton("Rational");
clo=new Color(173,214,255);


panel4.add(ques);
panel4.add(ans);
panel4.add(rat);


ques.addActionListener(this);
ans.addActionListener(this);
rat.addActionListener(this);


panel2.setLayout(grid);
icimage=new ImageIcon("images//question.jpg");
image=new JLabel(icimage);
JPanel imagepanel=new JPanel();
JPanel areapanel=new JPanel();

main.setBackground(clo);
panel1.setBackground(clo);
panel2.setBackground(clo);
panel3.setBackground(clo);
panel4.setBackground(clo);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(imagepanel,gcons);
panel2.add(imagepanel);
imagepanel.add(image);

JTextArea ta=new JTextArea(7,52);
JScrollPane jsp1=new JScrollPane(ta);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(areapanel,gcons);
panel2.add(areapanel);


areapanel.setLayout(grid);
JLabel ans=new JLabel("Answer");
ans.setFont(font1);
ans.setForeground(Color.black);
gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(ans,gcons);
areapanel.add(ans);

gcons.gridwidth=GridBagConstraints.REMAINDER;
gcons.anchor= GridBagConstraints.NORTHWEST;
grid.setConstraints(jsp1,gcons);
areapanel.add(jsp1);
panel3.setPreferredSize(new Dimension(180, 440));


l1=new JButton("Starting The Interview");
l2=new JButton("About Your Resume");
l3=new JButton("About Your Work Style");
l4=new JButton("Career Goal Question");
l5=new JButton("About Your Experience");
l6=new JButton("About Your Skills");
l7=new JButton("Accomplishment");
l8=new JButton("Eduction & Trening");
l9=new JButton("General Question");
l10=new JButton("Management Question");
l11=new JButton("About The Company");
l12=new JButton("About Position");
l13=new JButton("About Industary");
l14=new JButton("Recent Graduates");
l15=new JButton("Salary & Benifits");
l16=new JButton("Character Question");
l17=new JButton("Situation Question");
l18=new JButton("Special Issues");
l19=new JButton("Thugh Question");
l20=new JButton("Closing Question");
l21=new JButton("Questionable Question");
l22=new JButton("Question You Ask");
l1.addActionListener(this);
l2.addActionListener(this);
l3.addActionListener(this);
l4.addActionListener(this);
l5.addActionListener(this);
l6.addActionListener(this);
l7.addActionListener(this);
l8.addActionListener(this);
l9.addActionListener(this);
l10.addActionListener(this);
l11.addActionListener(this);
l12.addActionListener(this);
l13.addActionListener(this);
l14.addActionListener(this);
l15.addActionListener(this);
l16.addActionListener(this);
l17.addActionListener(this);
l18.addActionListener(this);
l19.addActionListener(this);
l20.addActionListener(this);
l21.addActionListener(this);
l22.addActionListener(this);

l1.setBackground(clo);
l2.setBackground(clo);
l3.setBackground(clo);
l4.setBackground(clo);
l5.setBackground(clo);
l6.setBackground(clo);
l7.setBackground(clo);
l8.setBackground(clo);
l9.setBackground(clo);
l10.setBackground(clo);
l11.setBackground(clo);
l12.setBackground(clo);
l13.setBackground(clo);
l14.setBackground(clo);
l15.setBackground(clo);
l16.setBackground(clo);
l17.setBackground(clo);
l18.setBackground(clo);
l19.setBackground(clo);
l20.setBackground(clo);
l21.setBackground(clo);
l22.setBackground(clo);


GridLayout gg=new GridLayout(23,1);
GridLayout gg1=new GridLayout(1,2);
panel3.setLayout(gg);
HELP.setLayout(gg1);
list=new JList(str);
list.setSelectionForeground(Color.white);
list.setSelectionBackground(Color.black);
list.addListSelectionListener(this);
list.setFont(font);
scrollPane = new JScrollPane(list);
MouseListener mouseListener = new MouseAdapter() {
     public void mouseClicked(MouseEvent e) {
         if (e.getClickCount() == 1) {
             int index = list.locationToIndex(e.getPoint());
             System.out.println("Double clicked on Item " + index);
             win.setVisible(false);

          }
     }
 };
 list.addMouseListener(mouseListener);


panel3.add(l1);panel3.add(l2);panel3.add(l3); panel3.add(l4); panel3.add(l5); panel3.add(l6);
panel3.add(l7); panel3.add(l8); panel3.add(l9); panel3.add(l10);
panel3.add(l11);panel3.add(l12);
panel3.add(l13); panel3.add(l14); panel3.add(l15);  panel3.add(l16); panel3.add(l17);panel3.add(l18);
panel3.add(l19);panel3.add(l20);panel3.add(l21);panel3.add(l22);panel3.add(HELP);
hlp=new JButton("Help");
clz=new JButton("Close");
HELP.add(hlp);
HELP.add(clz);
hlp.setBackground(clo);
clz.setBackground(clo);
hlp.addActionListener(this);
clz.addActionListener(this);
frame.getContentPane().add(main);
frame.setVisible(true);
frame.setSize(800,600);
frame.setLocation(0,70);
}

public void valueChanged(ListSelectionEvent evt)
	{
		SoundTest st=new SoundTest("");
		
		int ind=list.getSelectedIndex();
		if (ind==0){new SoundTest("vi/q01.au");st.stop();}
		if (ind==1){new SoundTest("vi/q02.au");st.stop();}
		if (ind==2){new SoundTest("vi/q03.au");st.stop();}
		if (ind==3){new SoundTest("vi/q04.au");	st.stop();}
		if (ind==4){new SoundTest("vi/q05.au");st.stop();}
		if (ind==5){new SoundTest("vi/q06.au");st.stop();}
		if (ind==6){new SoundTest("vi/q07.au");st.stop();}
		if (ind==7){new SoundTest("vi/q08.au");	st.stop();}
		if (ind==8){new SoundTest("vi/q09.au");st.stop();}
		if (ind==9){new SoundTest("vi/q10.au");st.stop();}
		if (ind==10){new SoundTest("vi/q11.au");st.stop();}
		if (ind==11){new SoundTest("vi/q12.au");st.stop();}
		if (ind==12){new SoundTest("vi/q13.au");st.stop();}
		if (ind==13){new SoundTest("vi/q14.au");st.stop();}
		if (ind==14){new SoundTest("vi/q15.au");st.stop();}
		if (ind==15){new SoundTest("vi/q16.au");st.stop();}
		if (ind==16){new SoundTest("vi/q17.au");st.stop();}
		if (ind==17){new SoundTest("vi/q18.au");st.stop();}
		if (ind==18){new SoundTest("vi/q19.au");st.stop();}
		if (ind==19){new SoundTest("vi/q20.au");st.stop();}
		if (ind==20){new SoundTest("vi/q21.au");st.stop();}
		if (ind==21){new SoundTest("vi/q22.au");st.stop();}
		if (ind==22){new SoundTest("vi/q23.au");st.stop();}
		if (ind==23){new SoundTest("vi/q24.au");st.stop();}
		if (ind==24){new SoundTest("vi/q25.au");st.stop();}
		
	}

public void actionPerformed(ActionEvent e)
	{
Object ob=e.getSource();

if(ob==ques){
	image.setIcon(new ImageIcon("images//question.jpg"));
	win.getContentPane().add(scrollPane);
	
	win.setVisible(true);
	win.setSize(570,250);
	win.setLocation(200,280);
}
	
if (ob==ans)
		{
		int obr=list.getSelectedIndex();
		image.setIcon(new ImageIcon("images//answer.jpg"));
		SoundTest st=new SoundTest("");
		if (obr==0){new SoundTest("vi/a01.au");st.stop();}
		if (obr==1){new SoundTest("vi/a02.au");st.stop();}
		if (obr==2){new SoundTest("vi/a03.au");st.stop();}
		if (obr==3){new SoundTest("vi/a04.au");	st.stop();}
		if (obr==4){new SoundTest("vi/a05.au");st.stop();}
		if (obr==5){new SoundTest("vi/a06.au");st.stop();}
		if (obr==6){new SoundTest("vi/a07.au");st.stop();}
		if (obr==7){new SoundTest("vi/a08.au");	st.stop();}
		if (obr==8){new SoundTest("vi/a09.au");st.stop();}
		if (obr==9){new SoundTest("vi/a10.au");st.stop();}
		if (obr==10){new SoundTest("vi/a11.au");st.stop();}
		if (obr==11){new SoundTest("vi/a12.au");st.stop();}
		if (obr==12){new SoundTest("vi/a13.au");st.stop();}
		if (obr==13){new SoundTest("vi/a14.au");st.stop();}
		if (obr==14){new SoundTest("vi/a15.au");st.stop();}
		if (obr==15){new SoundTest("vi/a16.au");st.stop();}
		if (obr==16){new SoundTest("vi/a17.au");st.stop();}
		if (obr==17){new SoundTest("vi/a18.au");st.stop();}
		if (obr==18){new SoundTest("vi/a19.au");st.stop();}
		if (obr==19){new SoundTest("vi/a20.au");st.stop();}
		if (obr==20){new SoundTest("vi/a21.au");st.stop();}
		if (obr==21){new SoundTest("vi/a22.au");st.stop();}
		if (obr==22){new SoundTest("vi/a23.au");st.stop();}
		if (obr==23){new SoundTest("vi/a24.au");st.stop();}
		if (obr==24){new SoundTest("vi/a25.au");st.stop();}	
		}

		if (ob==rat)
		{
		int obr=list.getSelectedIndex();
		image.setIcon(new ImageIcon("images//RATIONAL.jpg"));
		SoundTest st=new SoundTest("");
		if (obr==0){new SoundTest("vi/r01.au");st.stop();}
		if (obr==1){new SoundTest("vi/r02.au");st.stop();}
		if (obr==2){new SoundTest("vi/r03.au");st.stop();}
		if (obr==3){new SoundTest("vi/r04.au");	st.stop();}
		if (obr==4){new SoundTest("vi/r05.au");st.stop();}
		if (obr==5){new SoundTest("vi/r06.au");st.stop();}
		if (obr==6){new SoundTest("vi/r07.au");st.stop();}
		if (obr==7){new SoundTest("vi/r08.au");	st.stop();}
		if (obr==8){new SoundTest("vi/r09.au");st.stop();}
		if (obr==9){new SoundTest("vi/r10.au");st.stop();}
		if (obr==10){new SoundTest("vi/r11.au");st.stop();}
		if (obr==11){new SoundTest("vi/r12.au");st.stop();}
		if (obr==12){new SoundTest("vi/r13.au");st.stop();}
		if (obr==13){new SoundTest("vi/r14.au");st.stop();}
		if (obr==14){new SoundTest("vi/r15.au");st.stop();}
		if (obr==15){new SoundTest("vi/r16.au");st.stop();}
		if (obr==16){new SoundTest("vi/r17.au");st.stop();}
		if (obr==17){new SoundTest("vi/r18.au");st.stop();}
		if (obr==18){new SoundTest("vi/r19.au");st.stop();}
		if (obr==19){new SoundTest("vi/r20.au");st.stop();}
		if (obr==20){new SoundTest("vi/r21.au");st.stop();}
		if (obr==21){new SoundTest("vi/r22.au");st.stop();}
		if (obr==22){new SoundTest("vi/r23.au");st.stop();}
		if (obr==23){new SoundTest("vi/r24.au");st.stop();}
		if (obr==24){new SoundTest("vi/r25.au");st.stop();}	
		}
if(ob==l1){image.setIcon(new ImageIcon("images/VirtualInterview/GeneralQuestion.jpg"));}
if(ob==l2){image.setIcon(new ImageIcon("images/VirtualInterview/AboutResume.jpg"));}
if(ob==l3){image.setIcon(new ImageIcon("images/VirtualInterview/workStyle.jpg"));}
if(ob==l4){image.setIcon(new ImageIcon("images/VirtualInterview/careerGoal.jpg"));}
if(ob==l5){image.setIcon(new ImageIcon("images/VirtualInterview/aboutExper.jpg"));}
if(ob==l6){image.setIcon(new ImageIcon("images/VirtualInterview/GeneralQuestion.jpg"));}
if(ob==l7){image.setIcon(new ImageIcon("images/VirtualInterview/GeneralQuestion.jpg"));}
if(ob==l8){image.setIcon(new ImageIcon("images/VirtualInterview/GeneralQuestion.jpg"));}
if(ob==l9){image.setIcon(new ImageIcon("images/VirtualInterview/GeneralQuestion.jpg"));}
if(ob==l10){image.setIcon(new ImageIcon("images/VirtualInterview/GeneralQuestion.jpg"));}
if(ob==l11){image.setIcon(new ImageIcon("images/VirtualInterview/GeneralQuestion.jpg"));}
if(ob==l12){image.setIcon(new ImageIcon("images/VirtualInterview/AboutResume.jpg"));}
if(ob==l13){image.setIcon(new ImageIcon("images/VirtualInterview/workStyle.jpg"));}
if(ob==l14){image.setIcon(new ImageIcon("images/VirtualInterview/careerGoal.jpg"));}
if(ob==l15){image.setIcon(new ImageIcon("images/VirtualInterview/aboutExper.jpg"));}
if(ob==l16){image.setIcon(new ImageIcon("images/VirtualInterview/GeneralQuestion.jpg"));}
if(ob==l17){image.setIcon(new ImageIcon("images/VirtualInterview/GeneralQuestion.jpg"));}
if(ob==l18){image.setIcon(new ImageIcon("images/VirtualInterview/GeneralQuestion.jpg"));}
if(ob==l19){image.setIcon(new ImageIcon("images/VirtualInterview/GeneralQuestion.jpg"));}
if(ob==l20){image.setIcon(new ImageIcon("images/VirtualInterview/GeneralQuestion.jpg"));}
if(ob==l21){image.setIcon(new ImageIcon("images/VirtualInterview/aboutExper.jpg"));}
if(ob==l22){image.setIcon(new ImageIcon("images/VirtualInterview/GeneralQuestion.jpg"));}
if(ob==hlp){JOptionPane.showMessageDialog(frame,"Internet Connection Required before submitting Your Resume \nPlease Check Your Internet Connection ","Internet Connection Error..",JOptionPane.WARNING_MESSAGE);};
if(ob==clz){
	JOptionPane.showConfirmDialog(frame,"Are You Sure You Want To Exit ...??","Exit",JOptionPane.WARNING_MESSAGE);frame.setVisible(false);};
		
}

}

