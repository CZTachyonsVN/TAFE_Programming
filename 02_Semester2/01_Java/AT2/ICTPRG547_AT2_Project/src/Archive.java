public final class Archive
{
	private static CD[] CDs;
	private static FileReader fileReader = new FileReader();
	
//	public Archive(CD[] data){
//		CDs = data;
//	}
	
	private static void NewArchive()
	{
		CDs = fileReader.ReadFile();
	}
	
	public static String[] GetColumnNames()
	{
		return new String[]{
				"Id",
				"Title",
				"Author",
				"Section",
				"X",
				"Y",
				"Barcode",
				"Description",
				"OnLoan"};
	}
	
	public static CD[] GetArchive()
	{
		return CDs;
	}
	
	public static int GetArchiveLength()
	{
		return CDs.length;
	}
	
	public static Object[][] GetArchiveArray()
	{
		if (CDs == null)
		{
			NewArchive();
		}
		Object[][] output = new Object[CDs.length][8];
		for (int i = 0; i < CDs.length; i++)
		{
			output[i] = CDs[i].GetAllFields();
		}
		return output;
	}

	public static void UpdateCD()
	{

	}
}
