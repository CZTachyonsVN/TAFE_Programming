import javax.swing.table.AbstractTableModel;

/**
 * Source: https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/examples/components/TableDemoProject/src/components/TableDemo.java
 * Tutorial: https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/components/table.html#data
 */
class TableModelArchive extends AbstractTableModel
{
	private String[] columnNames = Archive.GetColumnNames();
	private Object[][] data = Archive.GetArchiveArray();
	
	public int getColumnCount()
	{
		return columnNames.length;
	}
	
	public int getRowCount()
	{
		return data.length;
	}
	
	public String getColumnName(int col)
	{
		return columnNames[col];
	}
	
	public Object getValueAt(int row, int col)
	{
		return data[row][col];
	}
	
	public Class getColumnClass(int c)
	{
		return getValueAt(0, c).getClass();
	}
	
	/*
	 * Don't need to implement this method unless your table's
	 * editable.
	 */
//	public boolean isCellEditable(int row, int col) {
//		//Note that the data/cell address is constant,
//		//no matter where the cell appears onscreen.
//		return col >= 2;
//	}

	/*
	 * Don't need to implement this method unless your table's
	 * data can change.
	 */
	
	public void setValueAt(Object value, int row, int col)
	{
		data[row][col] = value;
		fireTableCellUpdated(row, col);
	}
}