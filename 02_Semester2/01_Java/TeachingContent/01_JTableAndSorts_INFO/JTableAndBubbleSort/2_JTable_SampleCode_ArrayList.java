package associatedwords;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.AbstractTableModel;



public class AssociatedWords extends JFrame implements WindowListener, ActionListener
{
    
//<editor-fold defaultstate="collapsed" desc="Declarations, main and Constructor">

    JLabel lblWord1, lblWord2, lblSent;
    JTextField txtWord1, txtWord2;
    JButton btnAdd;
    JCheckBox chkSent;
    
    JTable table;
    MyModel wordModel;


    public static void main(String[] args)
    {
        JFrame myFrame = new AssociatedWords();
        myFrame.setSize(500,250);
        myFrame.setLocation(400, 200);
        myFrame.setResizable(true);
        myFrame.setVisible(true);        
    }

    public AssociatedWords()
    {
        setTitle("Sample JTable");
        setBackground(Color.yellow);

        SpringLayout myLayout = new SpringLayout();
        setLayout(myLayout);
                
        LocateLabels(myLayout);
        LocateTextFields(myLayout);
        LocateButtons(myLayout);
        LocateCheckBoxes(myLayout);
        
        WordAssociationTable(myLayout);
        
        this.addWindowListener(this);
    }

//</editor-fold>

    
//<editor-fold defaultstate="collapsed" desc="GUI Construction">

    //---------------------------------------------------------------------------------------------------
    //  Set up GUI Components
    //---------------------------------------------------------------------------------------------------

    public void LocateLabels(SpringLayout myLabelLayout)
    {
        lblWord1  = LocateALabel(myLabelLayout, lblWord1, "Word 1:", 30, 50);
        lblWord2 = LocateALabel(myLabelLayout, lblWord2, "Word 2:", 30, 75);
        lblSent = LocateALabel(myLabelLayout, lblSent, "Sent:", 30, 100);
    }

    public JLabel LocateALabel(SpringLayout myLabelLayout, JLabel myLabel, String  LabelCaption, int x, int y)
    {
        myLabel = new JLabel(LabelCaption);
        add(myLabel);        
        myLabelLayout.putConstraint(SpringLayout.WEST, myLabel, x, SpringLayout.WEST, this);
        myLabelLayout.putConstraint(SpringLayout.NORTH, myLabel, y, SpringLayout.NORTH, this);
        return myLabel;
    }
   
    public void LocateTextFields(SpringLayout myTextFieldLayout)
    {
        txtWord1  = LocateATextField(myTextFieldLayout, txtWord1, 10, 100, 50);
        txtWord2 = LocateATextField(myTextFieldLayout, txtWord2, 10, 100, 75);
    }

    public void LocateButtons(SpringLayout myButtonLayout)
    {
        btnAdd = LocateAButton(myButtonLayout, btnAdd, "Add", 100, 130, 80, 25);     
    }

    public void LocateCheckBoxes(SpringLayout myLayout)
    {
        chkSent = LocateAJCheckBox(myLayout, 100, 100);     
    }
       
    public JTextField LocateATextField(SpringLayout myTextFieldLayout, JTextField myTextField, int width, int x, int y)
    {
        myTextField = new JTextField(width);
        add(myTextField);        
        myTextFieldLayout.putConstraint(SpringLayout.WEST, myTextField, x, SpringLayout.WEST, this);
        myTextFieldLayout.putConstraint(SpringLayout.NORTH, myTextField, y, SpringLayout.NORTH, this);
        return myTextField;
    }

    public JButton LocateAButton(SpringLayout myButtonLayout, JButton myButton, String  ButtonCaption, int x, int y, int w, int h)
    {    
        myButton = new JButton(ButtonCaption);
        add(myButton);
        myButton.addActionListener(this);
        myButtonLayout.putConstraint(SpringLayout.WEST, myButton, x, SpringLayout.WEST, this);
        myButtonLayout.putConstraint(SpringLayout.NORTH, myButton, y, SpringLayout.NORTH, this);
        myButton.setPreferredSize(new Dimension(w,h));
        return myButton;
    }
    
    public JCheckBox LocateAJCheckBox(SpringLayout myLayout, int x, int y)
    {
        JCheckBox myCheckBox = new JCheckBox();
        add(myCheckBox);        
        myLayout.putConstraint(SpringLayout.WEST, myCheckBox, x, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, myCheckBox, y, SpringLayout.NORTH, this);
        return myCheckBox;
    }

//</editor-fold>
    
    
    //---------------------------------------------------------------------------------------------------
    // Sources: http://www.cs.cf.ac.uk/Dave/HCI/HCI_Handout_CALLER/node167.html
    //     and: http://www.cs.cf.ac.uk/Dave/HCI/HCI_Handout_CALLER/node168.html
    //---------------------------------------------------------------------------------------------------

    public void WordAssociationTable(SpringLayout myPanelLayout)
    { 
        // Create a panel to hold all other components
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        add(topPanel);

        // Create column names
        String columnNames[] =
        { "Word 1", "Word 2", "Sent"};

        // Create some data
        ArrayList<Object[]> dataValues = new ArrayList();
        dataValues.add(new Object[] {"Yes","No",true});
        dataValues.add(new Object[] {"Hi","there",true});
        dataValues.add(new Object[] {"True","False",true});
        dataValues.add(new Object[] {"Cat","Dog",false});

        // constructor of JTable model
	wordModel = new MyModel(dataValues, columnNames);
        
        // Create a new table instance
        table = new JTable(wordModel);

        // Configure some of JTable's paramters
        table.isForegroundSet();
        table.setShowHorizontalLines(false);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(true);
        add(table);

        // Change the text and background colours
        table.setSelectionForeground(Color.white);
        table.setSelectionBackground(Color.red);

        // Add the table to a scrolling pane, size and locate
        JScrollPane scrollPane = table.createScrollPaneForTable(table);
        topPanel.add(scrollPane, BorderLayout.CENTER);
        topPanel.setPreferredSize(new Dimension(172, 115));
        myPanelLayout.putConstraint(SpringLayout.WEST, topPanel, 280, SpringLayout.WEST, this);
        myPanelLayout.putConstraint(SpringLayout.NORTH, topPanel, 40, SpringLayout.NORTH, this);
    }

    
    //---------------------------------------------------------------------------------------------------
    // Source: http://www.dreamincode.net/forums/topic/231112-from-basic-jtable-to-a-jtable-with-a-tablemodel/
    // class that extends the AbstractTableModel
    //---------------------------------------------------------------------------------------------------

    class MyModel extends AbstractTableModel
    {
        ArrayList<Object[]> al;

        // the headers
        String[] header;
        
        // to hold the column index for the Sent column
        int col;

        // constructor 
        MyModel(ArrayList<Object[]> obj, String[] header)
        {
            // save the header
            this.header = header;
            // and the data
            al = obj;
            // get the column index for the Sent column
            col = this.findColumn("Sent");
        }

        // method that needs to be overload. The row count is the size of the ArrayList

        public int getRowCount()
        {
            return al.size();
        }

        // method that needs to be overload. The column count is the size of our header
        public int getColumnCount()
        {
            return header.length;
        }

        // method that needs to be overload. The object is in the arrayList at rowIndex
        public Object getValueAt(int rowIndex, int columnIndex)
        {
            return al.get(rowIndex)[columnIndex];
        }

        // a method to return the column name 
        public String getColumnName(int index)
        {
            return header[index];
        }
        
        public Class getColumnClass(int columnIndex) 
        {
            if (columnIndex == col) 
            {
                return Boolean.class; // For every cell in column 7, set its class to Boolean.class
            }
            return super.getColumnClass(columnIndex); // Otherwise, set it to the default class
	}

        // a method to add a new line to the table
        void add(String word1, String word2, boolean sent)
        {
            // make it an array[3] as this is the way it is stored in the ArrayList
            // (not best design but we want simplicity)
            Object[] item = new Object[3];
            item[0] = word1;
            item[1] = word2;
            item[2] = sent;
            al.add(item);
            // inform the GUI that I have change
            fireTableDataChanged();
        }
    }

//<editor-fold defaultstate="collapsed" desc="Listeners">
    
    //---------------------------------------------------------------------------------------------------
    // Action and Window Listener
    //---------------------------------------------------------------------------------------------------

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnAdd)
        {
            wordModel.add(txtWord1.getText(),txtWord2.getText(), chkSent.isSelected());
            table.repaint();
        }
    }

    
    public void windowOpened(WindowEvent e)  {  }
    public void windowClosing(WindowEvent e)  { System.exit(0); }
    public void windowClosed(WindowEvent e)  {  }
    public void windowIconified(WindowEvent e)  {  }
    public void windowDeiconified(WindowEvent e)  {  }
    public void windowActivated(WindowEvent e)  {  }
    public void windowDeactivated(WindowEvent e)  {  }

//</editor-fold>
    
}
