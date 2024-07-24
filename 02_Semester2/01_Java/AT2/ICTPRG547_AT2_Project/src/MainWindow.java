//import java.awt.event.ActionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.*;

public class MainWindow extends JFrame implements ActionListener
{
	private SpringLayout layout;
	
	private JPanel pnlContent;
	
	private JTextField TxtFieldSearchString;
	private JLabel lblSearchString;
	private JButton btnSearchString;
	
	private JPanel pnlArchiveCDs;
	private JScrollPane scrlPaneArchive;
	private JTable tblArchive;
	private JLabel lblSort;
	private JButton btnByTitle;
	private JButton btnByAuthor;
	private JButton btnByBarcode;
	
	private JPanel pnlProcessLog;
	private JButton btnProcessLog;
	private JScrollPane scrlPaneProcessLog;
	private JTextArea txtAreaProcessLog;
	private JLabel lblBinaryTree;
	private JButton btnBinaryTreePreOrder;
	private JButton btnBinaryTreeInOrder;
	private JButton btnBinaryTreePostOrder;
	private JButton btnBinaryTreeGraphical;
	private JLabel lblGraphicalPopup;
	private JLabel lblHashMapSet;
	private JButton btnHashSave;
	private JButton btnHashDisplay;
	private JLabel lblFindBarCode;
	private JTextField txtFieldFindBarCode;
	
	private JPanel pnlCDInfo;
	private JLabel lblTitle;
	private JTextField txtFieldId;
	private JTextField txtFieldTitle;
	private JLabel lblAuthor;
	private JTextField txtFieldAuthor;
	private JLabel lblSection;
	private JTextField txtFieldSection;
	private JLabel lblX;
	private JTextField txtFieldX;
	private JLabel lblY;
	private JTextField txtFieldY;
	private JLabel lblBarCode;
	private JTextField txtFieldBarCode;
	private JLabel lblDescription;
	private JScrollPane scrlPaneDescription;
	private JTextArea txtAreaDescription;
	private JButton btnNewItem;
	private JButton btnSaveUpdate;
	
	private JPanel pnlAutomationActions;
	private JButton btnRetrieve;
	private JButton btnRemove;
	private JButton btnReturn;
	private JButton btnAddToCollectionl;
	private JLabel lblSortSection;
	private JTextField txtFieldSortSection;
	private JButton btnSortRandomCollection;
	private JButton btnSortMostly;
	private JButton btnSortReverseOrder;
	
	private JLabel lblShowMessageLabels;
	private JCheckBox chkBoxShowMessageLabels;
	
	private JButton btnExit;
	
	private TableModel tableModel;
	

	
	public MainWindow(){
		layout = new SpringLayout();
		setLayout(layout);
		setTitle("ArchiveConsole");
		setSize(1200,800);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tblArchive.setModel(new TableModelArchive());
		
		setContentPane(pnlContent);
		setVisible(true);
	}
	
	/**
	 * Invoked when an action occurs.
	 *
	 * @param e the event to be processed
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
	
	}
}

///**
// * Source: https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/examples/components/TableDemoProject/src/components/TableDemo.java
// * Tutorial: https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/components/table.html#data
// */
//class TableModelArchive extends AbstractTableModel {
//	private Archive archive = new Archive();
//	private String[] archiveColumnNames;
//
//	private String[] columnNames = archive.GetColumnNames();
//	private Object[][] data = archive.GetArchiveArray();
//
//	public int getColumnCount() {
//		return columnNames.length;
//	}
//
//	public int getRowCount() {
//		return data.length;
//	}
//
//	public String getColumnName(int col) {
//		return columnNames[col];
//	}
//
//	public Object getValueAt(int row, int col) {
//		return data[row][col];
//	}
//
//	public Class getColumnClass(int c) {
//		return getValueAt(0, c).getClass();
//	}
//
//	/*
//	 * Don't need to implement this method unless your table's
//	 * editable.
//	 */
//	public boolean isCellEditable(int row, int col) {
//		//Note that the data/cell address is constant,
//		//no matter where the cell appears onscreen.
//		if (col < 2) {
//			return false;
//		} else {
//			return true;
//		}
//	}
//
//	/*
//	 * Don't need to implement this method unless your table's
//	 * data can change.
//	 */
//	public void setValueAt(Object value, int row, int col) {
//		data[row][col] = value;
//		fireTableCellUpdated(row, col);
//	}
//}
