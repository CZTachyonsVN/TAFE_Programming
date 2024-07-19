//import java.awt.event.ActionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.awt.event.ActionEvent;
import javax.swing.*;
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
	private JTextField txtFieldTitleNumber;
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
	
	
	public MainWindow(){
		layout = new SpringLayout();
		setLayout(layout);
		setTitle("ArchiveConsole");
		setSize(1200,800);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
