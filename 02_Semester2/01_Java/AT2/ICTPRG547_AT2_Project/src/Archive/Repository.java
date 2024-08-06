package Archive;

import java.util.ArrayList;

public final class Archive
{
	private static ArrayList<CD> CDs;
	private static FileReader fileReader = new FileReader();
	
	private static void NewArchive()
	{
		CDs = fileReader.ReadFile();
	}
	
	public static String[] GetColumnNames()
	{
		return new String[]
				{
						"Id",
						"Title",
						"Author",
						"Section",
						"X",
						"Y",
						"Barcode",
						"Description",
						"OnLoan"
				};
	}
	
	public static ArrayList<CD> GetArchive()
	{
		return CDs;
	}
	
	public static int GetArchiveLength()
	{
		return CDs.size();
	}
	
	public static Object[][] GetArchiveArray()
	{
		if (CDs == null)
		{
			NewArchive();
		}
		Object[][] output = new Object[CDs.size()][8];
		for (int i = 0; i < CDs.size(); i++)
		{
			output[i] = CDs.get(i).GetAllFields();
		}
		return output;
	}
	
	public static void UpdateCDById(int id, CD newData)
	{
		CD updatedCD = CDs
				.stream()
				.filter(cd -> cd.getId() == id)
				.toList()
				.getFirst();
		updatedCD.UpdateCD(newData);
	}
}
