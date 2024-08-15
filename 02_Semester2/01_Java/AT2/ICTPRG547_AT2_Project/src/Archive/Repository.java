package Archive;

import java.util.ArrayList;
import java.util.Arrays;

public final class Repository
{
	private static ArrayList<CD> CDs;
	private static final FileReader fileReader = new FileReader();
	
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
	
	public static int GetArchiveSize()
	{
		return CDs.size();
	}
	
	public static CD GetCDAt(int index){
		return CDs.get(index);
	}
	
	public static Object[][] GetArchive2DArray()
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
	
	public static CD GetCDByBarcode(int barcode)
	{
		return CDs.stream().filter(cd -> cd.getBarcode() == barcode).findFirst().orElse(null);
	}
	
	public static CD[] GetArchiveArray(){
		if (CDs == null)
		{
			NewArchive();
		}
		CD[] output = new CD[CDs.size()];
		for (int i = 0; i < output.length; i++)
		{
			output[i] = CDs.get(i);
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
	
	public static void SortByAuthor()
	{
		CD[] sortedCDs = Sort.QuickSortThree(GetArchiveArray(),0,CDs.size() - 1);
		CDs = new ArrayList<>(Arrays.asList(sortedCDs));
	}
	
	public static void SortByTitle()
	{
		CD[] sortedCDs = Sort.MergeSort(GetArchiveArray());
		CDs = new ArrayList<>(Arrays.asList(sortedCDs));
	}
	
	public static void SortByBarcode()
	{
		CD[] sortedCDs = Sort.RadixSort(GetArchiveArray());
		CDs = new ArrayList<>(Arrays.asList(sortedCDs));
	}
}
