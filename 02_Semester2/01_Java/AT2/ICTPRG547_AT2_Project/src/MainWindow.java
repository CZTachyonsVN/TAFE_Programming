import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;

import Archive.Repository;
import Archive.CD;
import LogLinkedList.DList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

public class MainWindow extends JFrame implements ActionListener
{
	private final SpringLayout layout;
	
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
	private final ListSelectionModel selectionModel;
	private final TableModelArchive archiveModel;
	private int selectedCD_Id;
	private DList logList = new DList();
	private Date date = new Date();
	public ArrayList<String> string = new ArrayList<String>();
	

	public MainWindow(){
		layout = new SpringLayout();
		setLayout(layout);
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
		archiveModel = (TableModelArchive)tblArchive.getModel();
		setContentPane(pnlContent);
		
		AddActionListenerToButtons();
		
		
		setVisible(true);
	}

	private void AddActionListenerToButtons(){
		/**
		 * Source: https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/components/SimpleTableSelectionDemoProject/src/components/SimpleTableSelectionDemo.java
		 * Listens to changes in selected rows of the Archive.Archive JTable
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
					System.out.println("Row " + selectedRow + " of Archive.Archive JTable is now selected.");
					ShowCDDetail(tblArchive, selectedRow);
				}
			}
		});
		
		//Update changes to CD details
		btnSaveUpdate.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (ValidateForm())
				{
					
					CD updatedData = new CD();
					updatedData.setId(Integer.parseInt(txtFieldId.getText()));
					updatedData.setTitle(txtFieldTitle.getText());
					updatedData.setAuthor(txtFieldAuthor.getText());
					updatedData.setSection(txtFieldSection.getText().toUpperCase().charAt(0));
					updatedData.setX(Integer.parseInt(txtFieldX.getText()));
					updatedData.setY(Integer.parseInt(txtFieldY.getText()));
					updatedData.setBarcode(Integer.parseInt(txtFieldBarCode.getText()));
					updatedData.setDescription(txtAreaDescription.getText());
					
					Repository.UpdateCDById(selectedCD_Id, updatedData);
					archiveModel.updateModel();
				}
			}
		});
		
		//Sort archive table by Author
		btnByAuthor.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Repository.SortByAuthor();
				archiveModel.updateModel();
			}
		});
		// Sort archive table by Title
		btnByTitle.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent actionEvent)
			{
				Repository.SortByTitle();
				archiveModel.updateModel();
			}
		});
		// Sort archive table by Barcode
		btnByBarcode.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent actionEvent)
			{
				Repository.SortByBarcode();
				archiveModel.updateModel();
			}
		});
		
		btnByBarcode.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent actionEvent)
			{
				Repository.SortByBarcode();
				archiveModel.updateModel();
			}
		});
		
		btnRetrieve.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent actionEvent)
			{
				String dateTime = new Date().toString();
				String action = "SEND";
				String status = "Retrieve Item";
				String item = txtFieldBarCode.getText();
				logList.Add(dateTime + " - " + action + " - " + status + " - " + item);
				logList.Debug();
				txtAreaProcessLog.append(dateTime + " - " + action + " - " + status + " - " + item +
						"\n");
			}
		});
		
		btnRemove.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent actionEvent)
			{
				String dateTime = new Date().toString();
				String action = "SEND";
				String status = "Remove Item";
				String item = txtFieldBarCode.getText();
				logList.Add(dateTime + " - " + action + " - " + status + " - " + item);
				logList.Debug();
				txtAreaProcessLog.append(dateTime + " - " + action + " - " + status + " - " + item +
						"\n");
			}
		});
		
		btnReturn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent actionEvent)
			{
				String dateTime = new Date().toString();
				String action = "SEND";
				String status = "Return Item";
				String item = txtFieldBarCode.getText();
				logList.Add(dateTime + " - " + action + " - " + status + " - " + item);
				logList.Debug();
				txtAreaProcessLog.append(dateTime + " - " + action + " - " + status + " - " + item +
						"\n");
			}
		});
		
		btnAddToCollection.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent actionEvent)
			{
				String dateTime = new Date().toString();
				String action = "SEND";
				String status = "Return Item";
				String item = txtFieldBarCode.getText();
				logList.Add(dateTime + " - " + action + " - " + status + " - " + item);
				logList.Debug();
				txtAreaProcessLog.append(dateTime + " - " + action + " - " + status + " - " + item +
						"\n");
			}
		});
	}
	public boolean ValidateForm(){
		boolean isValid = false;
		if (!txtFieldId.getText().isEmpty())
		{
			try
			{
				Integer.parseInt(txtFieldBarCode.getText());
				Integer.parseInt(txtFieldX.getText());
				Integer.parseInt(txtFieldY.getText());
				isValid = true;
				if (Character.isAlphabetic(txtFieldSection.getText().charAt(0)) && !txtFieldTitle.getText().isEmpty() && !txtFieldAuthor.getText().isEmpty() && !txtAreaDescription.getText().isEmpty())
				{
					isValid = true;
					isValid = JOptionPane.showConfirmDialog(this, "Confirm the changes to the archive", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0;
				} else
				{
					isValid = false;
				}
			} catch (Exception e)
			{
				JOptionPane.showMessageDialog(this, "The form is not filled in correctly. Please " + "double check your inputs.");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Select a CD from the archive table");
		}
		return isValid;
	}
	
	/**
	 * Fills in the Archive.CD Details form when user selects a row in the Archive.Archive JTable
	 * @param table current Jtable to pass the model
	 * @param row selected row
	 */
	public void ShowCDDetail(JTable table, int row)
	{
		TableModel model = table.getModel();
		selectedCD_Id = Integer.parseInt(model.getValueAt(row,0).toString());
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
	 * Invoked when an action occurs.
	 *
	 * @param e the event to be processed
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
	
	}
}
