import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader extends Component
{
	public CD[] ReadFile()
	{
		ArrayList<CD> data = new ArrayList<CD>();
		try {
			File myObj = new File("CD_ArchivePrototype_SampleData.txt");
			Scanner myReader = new Scanner(myObj);
			myReader.nextLine();
			while (myReader.hasNextLine())
			{
				String[] row = myReader.nextLine().split(";");
				data.add(new CD(row[0], row[1], row[2], row[3], row[4],row[5],row[6], row[7],
						row[8]));
			} //Store the next line of text that is found.
			myReader.close();
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		CD[] output = new CD[data.size()];
		for (int i = 0; i < output.length; i++)
		{
			output[i] = data.get(i);
		}
		
		return output;
	}
	
	public void FileWriter()
	{
	
	}
}
