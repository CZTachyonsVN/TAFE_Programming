import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AutomationConsole extends JFrame implements ActionListener
{
	private final SpringLayout layout = new SpringLayout();
	private JPanel pnlContent;
	
	JLabel lblRequestedAction;
	JComboBox cmbBoxRequestedAction;
	JLabel lblItemBarCode;
	JTextField txtFieldItemBarCode;
	JLabel lblSection;
	JTextField txtFieldSection;
	JButton btnProcess;
	JButton btnAddItem;
	JLabel lblRandomCollection;
	
	JPanel pnlArchiveCDs;
	JScrollPane scrlPaneArchiveCDs;
	JTable tblArchiveCDs;
	
	JButton btnExit;
	
	public AutomationConsole(){
		setLayout(layout);
		setTitle("AutomationConsole");
		setSize(700,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(pnlContent);
		pack();
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
