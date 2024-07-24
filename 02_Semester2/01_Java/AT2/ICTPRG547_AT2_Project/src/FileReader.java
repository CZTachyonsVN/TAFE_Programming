import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader extends Component
{
	public ArrayList<CD> ReadFile(){
		ArrayList<CD> suggestionsFile = new ArrayList<CD>();
		try {
			File myObj = new File("RePurposingSuggestions.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String[] row = myReader.nextLine().split(";");
				suggestionsFile.add(new CD(row[0], row[1], row[2], row[3], row[4],row[5],row[6],
						row[7],row[8]));
			} //Store the next line of text that is found.
			myReader.close();
		}
		catch (IOException e){
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		return suggestionsFile;
	}
}
