//package DOLIST;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.io.*;
import java.util.*;


public class DOLIST  implements ActionListener
  {
	
 	int v;
	int h;
  	
	JFrame fm;	
	JPanel paneltodo;

	JLabel DATE,DESCRIPTION;
	JScrollPane jspc;   	
	JList listDate,listDesc;
	
	String strDate[],strDescription[];
 
   	Connection con;
	Statement st;
	ResultSet rs;
	PreparedStatement stp;
					
	
    
	GridBagLayout grid;    
  	GridBagConstraints gcons;

  public static void main(String args[])
     {
       DOLIST ba =new DOLIST();
	 }

  
  public DOLIST()
	{
      	v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;

	  
	     fm = new JFrame("TO DO LIST");
		   
      	 paneltodo=  new JPanel();
	     

	 
	    jspc = new JScrollPane(paneltodo,v,h);

	    grid = new GridBagLayout ();
	    gcons = new GridBagConstraints ();
	   
	    DATE = new JLabel("Date       ");
		
		DESCRIPTION = new JLabel("Description  ");
        
		strDate=new String[64];
		strDescription=new String[64];
		
			 
		listDate=new JList();
		
		listDesc=new JList();
		
		int i=0;		
		try
		{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con=DriverManager.getConnection("jdbc:odbc:resume","sa","");
                Statement st=con.createStatement();
				PreparedStatement stp;                
				ResultSet rs=st.executeQuery("select * from TODOLIST  ");
				listDate=new JList();
				listDesc=new JList();
				
				String id,name;
                while (rs.next())
						{
							strDate[i]=rs.getString(1);
							strDescription[i]=rs.getString(3);
							
							i=i+1;               
						}

				listDate=new JList(strDate);
				listDate.setFixedCellWidth(250);
				listDesc=new JList(strDescription);
				listDesc.setFixedCellWidth(400);
				
				
				
		}
		catch(Exception e)
		{
			System.out.println("fecting problem "+e);
		}


       
		 gcons.anchor=   GridBagConstraints.NORTHWEST;
         gcons.gridx=1;
         gcons.gridy=1;
         grid.setConstraints(DATE,gcons);
         paneltodo.add(DATE);
		  		  
          gcons.anchor=   GridBagConstraints.NORTHWEST;
         gcons.gridx=2;
         gcons.gridy=1;
         grid.setConstraints(DESCRIPTION,gcons);
         paneltodo.add(DESCRIPTION);
		  		  
       	
		  gcons.anchor=   GridBagConstraints.NORTHWEST;
         gcons.gridx=1;
         gcons.gridy=3;
         grid.setConstraints(listDate,gcons);
         paneltodo.add(listDate);        

         gcons.anchor=   GridBagConstraints.NORTHWEST;
         gcons.gridx=2;
         gcons.gridy=3;
         grid.setConstraints(listDesc,gcons);
         paneltodo.add(listDesc);

         paneltodo.setBackground(Color.white);
         paneltodo.setLayout(grid); 
      
	   fm.getContentPane().add(paneltodo);
	   fm.setSize(800,600);
       fm.setVisible(true);
   }



public void actionPerformed(ActionEvent t)
{
	  }
}
