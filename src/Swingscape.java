import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.undo.*;
import javax.swing.text.*;
import javax.swing.text.html.*;
import javax.swing.event.*;

public class Swingscape extends JFrame implements HyperlinkListener 
{
  public static final String TITLE_TEXT = "Resume Maker Internet Zone";
  public static final String HOME_DEFAULT ="file://localhost/d:/Project/career/error.html";

  protected String m_CurrentURL = HOME_DEFAULT;
  
  protected JEditorPane m_HtmlPane;
  protected JToolBar m_toolBar;
  protected JButton m_btnBack, m_btnForward, m_btnReload;
  protected JMenuItem m_mnuBack, m_mnuForward;
  protected JTextField m_txtURL;
  
  protected URLundoManager m_undo = new URLundoManager();

  public Swingscape() {
    super(TITLE_TEXT);

    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    if ( dim.width <= 680 ) {
      setSize(dim.width,dim.height);
    }
    else {
      int initWidth = dim.width - dim.width/10;
      int initHeight = dim.height - dim.height/10;
      setSize( initWidth, initHeight );
      setLocation( dim.width/2-initWidth/2, 
        dim.height/2-initHeight/2 );
    }

    setJMenuBar(createMenuBar());
    getContentPane().add(m_toolBar, BorderLayout.NORTH);

    m_HtmlPane = new JEditorPane();
    m_HtmlPane.setEditorKit(new HTMLEditorKit());
    m_HtmlPane.setEditable(false);
    m_HtmlPane.addHyperlinkListener(this);
    
    JScrollPane mScroller = new JScrollPane();
    mScroller.getViewport().add(m_HtmlPane);
    getContentPane().add(mScroller, BorderLayout.CENTER);
    
    addWindowListener( new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        
      }
    } );
    
    m_btnReload.doClick();
    setVisible(true);
  }

  protected JMenuBar createMenuBar() {
    JMenuBar menuBar = new JMenuBar();
    
    JMenu mFile = new JMenu("File");
    mFile.setMnemonic('f');
    
	ImageIcon isa=new ImageIcon("images//1.jpg");
    JMenuItem item = new JMenuItem("New");
    item.setMnemonic('r');
    
    JMenuItem item1 = new JMenuItem("Open",isa);
    item.setMnemonic('r');
    
    JMenuItem item2 = new JMenuItem("Edit",isa);
    item.setMnemonic('r');
    
    JMenuItem item3 = new JMenuItem("Save");
    item.setMnemonic('r');
    
    JMenuItem item4 = new JMenuItem("Save As");
    item.setMnemonic('r');
    
    JMenuItem item5 = new JMenuItem("Send");
    item.setMnemonic('r');
    
    JMenuItem item6 = new JMenuItem("Import & Export");
    item.setMnemonic('r');

	JMenuItem item7 = new JMenuItem("Properties");
    item.setMnemonic('r');

JMenuItem item8 = new JMenuItem("Close");
    item.setMnemonic('r');

        
Action actionReload = new AbstractAction("Refresh") {
      public void actionPerformed(ActionEvent e) {
        Thread runner = new Thread() {
          public void run() {
            m_HtmlPane.setText("Please Reset & Load Your Page Again");
            m_HtmlPane.setText("Resume Caster Error ID - RES0065");
            DisplayPageDirect(m_CurrentURL);
          }
        };
        runner.start();
      }
    };
    
    item.addActionListener(actionReload);
    mFile.add(item);
    mFile.add(item1);
    mFile.add(item2);
    mFile.add(item3);
    mFile.add(item4);
    mFile.add(item5);
    mFile.add(item6);
    mFile.add(item7);
    mFile.add(item8);
    item = new JMenuItem("Exit");
    item.setMnemonic('x');
    
    item.addActionListener( new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       // System.exit(0);
      }
    });
    
    mFile.add(item);
    menuBar.add(mFile);
    
    JMenu mGo = new JMenu("Go");
    mGo.setMnemonic('g');
    menuBar.add(mGo);
    
    JMenu mEdit = new JMenu("Edit");
    menuBar.add(mEdit);
    mEdit.setMnemonic('E');
    
    JMenu mView = new JMenu("View");
    menuBar.add(mView);
    mView.setMnemonic('V');
    
    JMenu mFavorites = new JMenu("Favorites");
    menuBar.add(mFavorites);
    mFavorites.setMnemonic('F');
    
    JMenu mtool = new JMenu("Tools");
    menuBar.add(mtool);
    mtool.setMnemonic('T');
    
    JMenu mhlp = new JMenu("Help");
    menuBar.add(mhlp);
    mhlp.setMnemonic('H');
    
    m_mnuBack = new JMenuItem("Back");
    m_mnuBack.setMnemonic('b');
    m_mnuBack.setEnabled(false);
    
    Action actionBack = new AbstractAction("Back") {
      public void actionPerformed(ActionEvent e) {
        Thread runner = new Thread() {
          public void run() {
            try {
              String mDoURL = m_undo.swapURL(m_CurrentURL);
              m_undo.undo();  //URL now in redo
              DisplayPageDirect(mDoURL);
            }
            catch (CannotUndoException exc) {}
            finally {
              updateMenu_Buttons();
            }
          }
        };
        runner.start();
      }
    };
    
    m_mnuBack.addActionListener(actionBack);
    mGo.add(m_mnuBack);
    
    m_mnuForward = new JMenuItem("Forward");
    m_mnuForward.setMnemonic('f');
    m_mnuForward.setEnabled(false);
    
    Action actionForward = new AbstractAction("Forward") {
      public void actionPerformed(ActionEvent e) {
        Thread runner = new Thread() {
          public void run() {
            try {
              m_undo.redo();
              DisplayPageDirect(m_undo.swapURL(m_CurrentURL));
            }
            catch (CannotRedoException exc) {}
            finally {
              updateMenu_Buttons();
            }
          }
        };
        runner.start();
      }
    };
    
    m_mnuForward.addActionListener(actionForward);
    mGo.add(m_mnuForward);
    
    item = new JMenuItem("Home");
    item.setMnemonic('h');
    
    Action actionHome = new AbstractAction("Home") {
      public void actionPerformed(ActionEvent e) {
        Thread runner = new Thread() {
          public void run() {
            Display_RecordUndo(HOME_DEFAULT);
          }
        };
        runner.start();
      }
    };
    
    item.addActionListener(actionHome);
    mGo.add(item);
    menuBar.add(mGo);

    m_toolBar = new JToolBar();
    
    m_btnBack = m_toolBar.add(actionBack);
    m_btnBack.setEnabled(false);
    m_btnBack.setBorderPainted(false);
    m_btnBack.setRequestFocusEnabled(false);
    m_btnBack.addMouseListener(new PopButtonListener());
    m_toolBar.addSeparator();
    
    m_btnForward = m_toolBar.add(actionForward);
    m_btnForward.setEnabled(false);
    m_btnForward.setBorderPainted(false);
    m_btnForward.setRequestFocusEnabled(false);
    m_btnForward.addMouseListener(new PopButtonListener());
    m_toolBar.addSeparator();
    
    m_btnReload = m_toolBar.add(actionReload);
    m_btnReload.setToolTipText(HOME_DEFAULT);
    m_btnReload.setBorderPainted(false);
    m_btnReload.setRequestFocusEnabled(false);
    m_btnReload.addMouseListener(new PopButtonListener());
    m_toolBar.addSeparator();
    
    JButton btnHome = m_toolBar.add(actionHome);
    btnHome.setToolTipText(HOME_DEFAULT);
    btnHome.setBorderPainted(false);
    btnHome.setRequestFocusEnabled(false);
    btnHome.addMouseListener(new PopButtonListener());
    m_toolBar.addSeparator();
    
    m_txtURL = new JTextField(HOME_DEFAULT);
    
    m_txtURL.addActionListener( new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Thread runner = new Thread() {
          public void run() {
            String m_URL = m_txtURL.getText().trim();
            if ( m_URL.length() > 0 ) 
            {
              String checkForProtocol = 
                m_URL.substring(0,7).toLowerCase();
              if (!checkForProtocol.equals("http://") &&
                  !checkForProtocol.startsWith("file:/")) 
              {
                if (checkForProtocol.indexOf(':') == 1) 
                { // Drive letter?
                  m_URL = "file:/"+m_URL;
                }
                else 
                { // Assume a website...
                  m_URL = "http://"+m_URL;
                }
              }
              Display_RecordUndo(m_URL);
            }
          }
        };
        runner.start();
      }
    });
    
    m_toolBar.add(m_txtURL);
    m_toolBar.setFloatable(false);

    return menuBar;
  }

  public void hyperlinkUpdate(HyperlinkEvent e) {
    if ( e.getEventType() == HyperlinkEvent.EventType.ACTIVATED ) {
      final String dest =  e.getURL().toString();
      Thread runner = new Thread() {
        public void run() {
          Display_RecordUndo(dest);
        }
      };
      runner.start();
    }
  }

  public void updateMenu_Buttons() {
    boolean mDoState = m_undo.canUndo();
    
    m_mnuBack.setEnabled(mDoState);
    m_btnBack.setEnabled(mDoState);
    
    if ( mDoState ) {
      m_btnBack.setToolTipText(m_undo.getUndoPresentationName());
    }
    else {
      m_btnBack.setToolTipText(null);
    }
    
    mDoState = m_undo.canRedo();
    
    m_mnuForward.setEnabled(mDoState);
    m_btnForward.setEnabled(mDoState);
    
    if ( mDoState ) {
      m_btnForward.setToolTipText(m_undo.getRedoPresentationName());
    }
    else {
      m_btnForward.setToolTipText(null);
    }
  }

  public void Display_RecordUndo(String strURL) {
    String mCompareURL = strURL.intern();
    
    if ( m_CurrentURL != mCompareURL ) {
      m_undo.addURL(m_CurrentURL);
      updateMenu_Buttons();
      DisplayPageDirect(mCompareURL);
    }
  }

  public void DisplayPageDirect(String strURL) {
    m_CurrentURL = strURL;
    m_txtURL.setText(strURL);
    m_btnReload.setToolTipText(strURL);
    
    try {
      // setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));  
      // future feature
      m_HtmlPane.setPage(strURL);
    }
    catch (Exception exc) {
      System.out.println("Problem loading URL...");
    }
    /*  setCursor() expected to work properly in 
        JDK1.1.8 & JDK1.2.2, bug#4160474
    finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
    */
  }

  public static void main(String[] args) {
    new Swingscape();
    JOptionPane.showMessageDialog(null,"Internet Connection Required","Database Error",JOptionPane.WARNING_MESSAGE);
  }

  class PopButtonListener extends MouseAdapter {
    public void mouseEntered(MouseEvent e) {
      ( (JButton)e.getSource() ).setBorderPainted(true);
    }
    
    public void mouseExited(MouseEvent e) {
      ( (JButton)e.getSource() ).setBorderPainted(false);
    }
  }

  class UndoableURL extends AbstractUndoableEdit {
    private String m_URL;
    
    public UndoableURL(String m_URL) {
      this.m_URL = m_URL;
    }
    
    public String getPresentationName() {
      return m_URL;
    }
  }

  class URLundoManager extends CompoundEdit {
    int m_IdxAdd = 0;
    
    public String getUndoPresentationName() {
      return ((UndoableURL)
        edits.elementAt(m_IdxAdd-1)).getPresentationName();
    }
    
    public String getRedoPresentationName() {
      return ((UndoableURL)
        edits.elementAt(m_IdxAdd)).getPresentationName();
    }
    
    public void addURL(String newURL) {
      if ( edits.size()>m_IdxAdd ) {
        edits.setElementAt(new UndoableURL(newURL),m_IdxAdd++);
        for ( int i=m_IdxAdd; i<edits.size(); i++ ) {
          edits.removeElementAt(i);
        }
      }
      else {
        edits.addElement(new UndoableURL(newURL));
        m_IdxAdd++;
      }
    }
    
    public String swapURL(String newURL) {
      String m_oldURL = getUndoPresentationName();
      edits.setElementAt(new UndoableURL(newURL),m_IdxAdd-1);
      return m_oldURL;
    }
    
    public synchronized boolean canUndo() {
      if ( m_IdxAdd > 0 ) {
        UndoableURL edit = (UndoableURL)edits.elementAt(m_IdxAdd-1);
        return edit != null && edit.canUndo();
      }
      return false;
    }
    
    public synchronized boolean canRedo() {
      if ( edits.size()>m_IdxAdd ) {
        UndoableURL edit = (UndoableURL)edits.elementAt(m_IdxAdd);
        return edit != null && edit.canRedo();
      }
      return false;
    }
    
    public synchronized void undo() throws CannotUndoException {
      ( (UndoableURL)edits.elementAt(--m_IdxAdd) ).undo();
    }
    
    public synchronized void redo() throws CannotRedoException {
      ( (UndoableURL)edits.elementAt(m_IdxAdd++) ).redo();
    }
  }
}
