import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.text.*;

class Main extends Frame implements ActionListener {
    int curPointSize = 12;
    String filename;
    Vector lines = new Vector();

    Button printBtn = new Button("Print...");
    TextField pointSize = new TextField("" + curPointSize);
    TextField pageNum = new TextField("1");
    Preview preview;

    Main(String filename) {
        super("PrintJob Example");
        // Remember the filename.
        this.filename = filename;

        // Read the file into lines.
        try {
            String line;
            BufferedReader fis = new BufferedReader(
                new InputStreamReader(new FileInputStream(filename)));
            while ((line = fis.readLine()) != null) {
                lines.addElement(line);
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Listen for events.
        pageNum.addActionListener(this);
        pointSize.addActionListener(this);
        printBtn.addActionListener(this);

        // Layout and show components.

        Panel p = new Panel(new FlowLayout());
        p.add(new Label("Page:", Label.RIGHT)); 
        p.add(pageNum); 
        p.add(new Label("Point Size:", Label.RIGHT)); 
        p.add(pointSize); 
        p.add(printBtn);
        add(p, BorderLayout.NORTH);

        // Create and prepare the preview component.
        preview = new Preview(filename, lines);
        add(preview, BorderLayout.CENTER);
        preview.setFont(new Font("Monospaced", Font.PLAIN, curPointSize));

        pack();
        show();
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == pageNum) {
            // Set the page.
            preview.setPage(Integer.parseInt(pageNum.getText())-1);
        } else if (evt.getSource() == pointSize) {
            // Set the point size.
            curPointSize = Integer.parseInt(pointSize.getText());
            preview.setFont(new Font("Monospaced", Font.PLAIN, curPointSize));
        } else if (evt.getSource() == printBtn) {
            // Print the file.
            Properties props = new Properties();
            PrintJob pj = getToolkit().getPrintJob(this, filename, props);

            if (pj != null) {
                // Print out any properties.
                for (Enumeration e = props.propertyNames() ; 
                        e.hasMoreElements() ;) {
                    System.out.println(e.nextElement());
                }

                Graphics pjG = pj.getGraphics();
                int pages = preview.getPageCount(pjG);

                // Always print even number of pages.
                if (pages % 2 == 1) {
                    pages++;
                }
                for (int i=0; i<pages; i += 2) {
                    if (pjG == null) {
                        pjG = pj.getGraphics();
                    }
                    if (pj.lastPageFirst()) {
                        preview.print(pjG, pages-i-2);
                    } else {
                        preview.print(pjG, i);
                    }
                    pjG.dispose();
                    pjG = null;
                }
                pj.end();
            }
        }
    }

    public static void main(String[] args) {
        if (args.length == 1) {
            new Main(args[0]);
        } else {
            System.err.println("Usage: java Main <text file>");
        }
    }
}

class Preview extends Component {
    int page;
    String filename;
    Font headerFont = new Font("Serif", Font.BOLD, 14);
    Font font;
    Vector lines;

    Preview(String filename, Vector lines) {
        this.filename = filename;
        this.lines = lines;
    }

    // Sets the font and repaints the display.
    public void setFont(Font f) {
        font = f;
        repaint();
    }

    // p is 0-based.
    void setPage(int p) {
        page = p;
        repaint();
    }

    // Returns the page count relative to the metrics in g.
    int getPageCount(Graphics g) {
        prepareLayoutValues(g);
        return (brokenLines.size()-1) / linesPerPage + 1;
    }

    // Prints the page p and p+1.
    // p is 0-based.
    public void print(Graphics g, int p) {
        page = p;
        paint(g);
    }

    public void paint(Graphics g) {
        prepareLayoutValues(g);

        g.setFont(headerFont);
        FontMetrics fm = g.getFontMetrics();

        // Draw the filename.
        g.drawString(filename, boxRect.x, fm.getHeight()/2+fm.getAscent());

        // Draw the date and page number.
        g.drawString(
            DateFormat.getDateTimeInstance().format(new Date()),
            boxRect.x + pageRect.width, fm.getHeight()/2+fm.getAscent());


        for (int p=0; p<2; p++) {
            if (page + p >= (brokenLines.size()-1) / linesPerPage + 1) {
                break;
            }
            
            // Draw page number.
            String s = "" + (page + p + 1);
            g.setFont(headerFont);
            fm = g.getFontMetrics();
            g.drawString(s, 
                boxRect.x + p*pageRect.width + boxRect.width - fm.stringWidth(s),
                fm.getHeight()/2+fm.getAscent());

            g.drawRect(boxRect.x + p*pageRect.width, 
                boxRect.y, boxRect.width-1, boxRect.height-1);


            // Find the starting line on the current page.
            int l = Math.min(brokenLines.size(), (page+p) * linesPerPage);
    
            g.setFont(font);
            fm = g.getFontMetrics();
            int x = listingRect.x + p*pageRect.width;
            int y = listingRect.y + fm.getAscent();
            for (int i=0; i<linesPerPage && l+i < brokenLines.size(); i++) {
                s = (String)brokenLines.elementAt(l + i); 
                
                if (s.length() > charsPerLine) {
                    int charWidth = fm.charWidth('M');
                    s = s.substring(0, charsPerLine);

                    // Draw the continuation symbol.
                    g.drawArc(
                        listingRect.x+charsPerLine*charWidth + p*pageRect.width,
                        y-fm.getAscent()+fm.getHeight()/2,
                        charWidth, fm.getHeight()/2,
                        45, -180);
                }
                g.drawString(s, x, y);
                y += fm.getHeight();
            }
        }
    }

    // External margin in which the printer cannot print.
    int pageMargin;

    // Internal margin between boxes and text.
    int margin = 10;
    Insets margins = new Insets(10, 10, 10, 10);;

    // Bounds which includes the header, box, and listing.
    Rectangle pageRect;

    // The bounds of the box.
    Rectangle boxRect;

    // The bounds of the listing.  This rectangle strictly contains
    // the text and not the continuation character.
    Rectangle listingRect;

    // Number of characters per line.
    int charsPerLine;

    // Number of lines per page.
    int linesPerPage;

    // The lines after they have been broken so they fit within charsPerLine.
    Vector brokenLines;

    // This method calculates and sets up all the fields above
    // based on the metrics in g.
    void prepareLayoutValues(Graphics g) {
        Dimension pageSize;
        int res;

        if (g instanceof PrintGraphics) {
            PrintJob pj = ((PrintGraphics)g).getPrintJob();
            res = pj.getPageResolution();
            pageSize = pj.getPageDimension();

            // getPageDimension() does not return the correct result.
            // The following is a workaround.
            res = getToolkit().getScreenResolution();
            pageSize = new Dimension((int)(8.5 * res), 11 * res);
        } else {
            res = getToolkit().getScreenResolution();
            pageSize = new Dimension((int)(8.5 * res), 11 * res);
        }
        pageMargin = (int)(.75 * res);
        pageSize = new Dimension(pageSize.height-pageMargin, 
            pageSize.width-pageMargin);

        // Reserve space for the header.
        FontMetrics fm = g.getFontMetrics(headerFont);

        pageRect = new Rectangle(0, 0, pageSize.width/2, pageSize.height);
        boxRect = inset(pageRect, margin, 2*fm.getHeight(), margin, 0);
        listingRect = inset(boxRect, margin, margin, margin, margin);

        // Set up listing font.
        fm = g.getFontMetrics(font);

        int lpp = listingRect.height/fm.getHeight();
        int cpp = listingRect.width/fm.charWidth('M');

        // The metrics have changed so recompute the broken lines.
        if (lpp != linesPerPage || cpp != charsPerLine) {
            brokenLines = new Vector();
            for (int i=0; i<lines.size(); i++) {
                String s = (String)lines.elementAt(i);

                while (s.length() > cpp) {
                    brokenLines.addElement(s.substring(0, cpp)+"+");
                    s = s.substring(cpp);
                }
                brokenLines.addElement(s);
            }

            linesPerPage = lpp;
            charsPerLine = cpp;
        }
    }

    Rectangle inset(Rectangle r, int left, int top, int right, int bottom) {
        Rectangle s = new Rectangle(r);
        s.x += left;
        s.y += top;
        s.width -= left+right;
        s.height -= top+bottom;
        return s;
    }
}
