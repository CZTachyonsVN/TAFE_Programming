//import java.awt.event.ActionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
	private JButton btnAddToCollection;
	private JLabel lblSortSection;
	private JTextField txtFieldSortSection;
	private JButton btnSortRandomCollection;
	private JButton btnSortMostly;
	private JButton btnSortReverseOrder;
	
	private JLabel lblShowMessageLabels;
	private JCheckBox chkBoxShowMessageLabels;
	
	private JButton btnExit;
	private ListSelectionModel selectionModel;
	private TableModelArchive archiveModel;


	public MainWindow(){
//		layout = new SpringLayout();
//		setLayout(layout);
		setTitle("ArchiveConsole");
		setSize(1200,800);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Initialises the table
		tblArchive.setModel(new TableModelArchive());
		//Disable multiple selection
		tblArchive.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		selectionModel = tblArchive.getSelectionModel();
		//Set wrapping style for Description JTextArea
		txtAreaDescription.setWrapStyleWord(true);
		txtFieldId.setEnabled(false);
//		scrlPaneArchive.getColumnHeader().setVisible(false);
		/**
		 * Source: https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/components/SimpleTableSelectionDemoProject/src/components/SimpleTableSelectionDemo.java
		 * Listens to changes in selected rows of the Archive JTable
		 */
		selectionModel.addListSelectionListener(new ListSelectionListener()
		{
			@Override
			public void valueChanged(ListSelectionEvent e)
			{
				if (e.getValueIsAdjusting()) return;

				ListSelectionModel lsm = (ListSelectionModel)e.getSource();
				if (lsm.isSelectionEmpty())
				{
					System.out.println("No rows are selected.");
				} else
				{
					int selectedRow = lsm.getMinSelectionIndex();
					System.out.println("Row " + selectedRow + " of Archive JTable is now selected.");
					ShowCDDetail(tblArchive, selectedRow);
				}
			}
		});

//		tblArchive.addMouseListener(new MouseAdapter()
//		{
//			public void mouseClicked(MouseEvent e)
//			{
//			}
//		});

		setContentPane(pnlContent);
		setVisible(true);
		int[] a = {1,2};
		swap(a);
		System.out.println(a[0] + " "+ a[1]);
	}
	
	public void swap(int[] arr){
		int temp = arr[0];
		arr[0] = arr[1];
		arr[1] = temp;
	}

	/**
	 * Fills in the CD Details form when user selects a row in the Archive JTable
	 * @param table current Jtable to pass the model
	 * @param row selected row
	 */
	public void ShowCDDetail(JTable table, int row)
	{
		TableModel model = table.getModel();
		txtFieldId.setText(String.valueOf(model.getValueAt(row,0)));
		txtFieldTitle.setText(String.valueOf(model.getValueAt(row,1)));
		txtFieldAuthor.setText(String.valueOf(model.getValueAt(row,2)));
		txtFieldSection.setText(String.valueOf(model.getValueAt(row,3)));
		txtFieldX.setText(String.valueOf(model.getValueAt(row,4)));
		txtFieldY.setText(String.valueOf(model.getValueAt(row,5)));
		txtFieldBarCode.setText(String.valueOf(model.getValueAt(row,6)));
		txtAreaDescription.setText(String.valueOf(model.getValueAt(row,7)));
	}

	/**
	 * Invoked when a button click occurs.
	 * @param e the event to be processed
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == btnSearchString)
		{

		}
		if (e.getSource() == btnByTitle)
		{
			archiveModel.fireTableDataChanged();
		}
		if (e.getSource() == btnByAuthor)
		{

		}
		if (e.getSource() == btnByBarcode)
		{

		}
		if (e.getSource() == btnNewItem)
		{

		}
		if (e.getSource() == btnSaveUpdate)
		{

		}
		if (e.getSource() == btnProcessLog)
		{

		}
		if (e.getSource() == btnBinaryTreePreOrder)
		{

		}
		if (e.getSource() == btnBinaryTreeInOrder)
		{

		}
		if (e.getSource() == btnBinaryTreePostOrder)
		{

		}
		if (e.getSource() == btnBinaryTreeGraphical)
		{

		}
		if (e.getSource() == btnHashSave)
		{

		}
		if (e.getSource() == btnHashDisplay)
		{

		}
		if (e.getSource() == btnRetrieve)
		{

		}
		if (e.getSource() == btnRemove)
		{

		}
		if (e.getSource() == btnReturn)
		{

		}
		if (e.getSource() == btnAddToCollection)
		{

		}
		if (e.getSource() == btnSortRandomCollection)
		{

		}
		if (e.getSource() == btnSortMostly)
		{

		}
		if (e.getSource() == btnSortReverseOrder)
		{

		}
	}
}
