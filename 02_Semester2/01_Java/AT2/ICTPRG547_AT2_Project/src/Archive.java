public class Archive
{
	private CD[] CDs;
	private FileReader fileReader = new FileReader();
	
	public Archive(CD[] data){
		CDs = data;
	}
	
	public Archive(){
		CDs = fileReader.ReadFile();
	}
	
	public String[] GetColumnNames(){
		return new String[]{"Title",
				"Author",
				"Section",
				"X",
				"Y",
				"Barcode",
				"Description",
				"OnLoan"};
	}
	
	public CD[] GetArchive(){
		return CDs;
	}
	
	public int GetArchiveLength(){
		return CDs.length;
	}
	
	public Object[][] GetArchiveArray(){
		Object[][] output = new Object[CDs.length][8];
		for (int i = 0; i < CDs.length; i++)
		{
			output[i] = CDs[i].GetAllFieldsNoId();
		}
		return output;
	}
}
