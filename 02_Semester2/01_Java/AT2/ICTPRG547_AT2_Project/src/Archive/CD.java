package Archive;

import java.awt.*;

public class CD extends Component
{
	private int Id;
	
	private String Title;
	private String Author;
	private char Section;
	private int X;
	private int Y;
	private int Barcode;
	private String Description;
	private boolean OnLoan;
	
	public CD(String id, String title, String author, String section, String x, String y, String barcode,
			  String description, String onLoan)
	{
		try
		{
			Id = Integer.parseInt(id);
			Title = title;
			Author = author;
			Section = section.charAt(0);
			X = Integer.parseInt(x);
			Y = Integer.parseInt(y);
			Barcode = Integer.parseInt(barcode);
			Description = description;
			switch (onLoan)
			{
				case "No" -> OnLoan = false;
				case "Yes" -> OnLoan = true;
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public CD(){
	
	}
	
	public CD(CD newCD){
		Id = newCD.getId();
		Title = newCD.getTitle();
		Author = newCD.getAuthor();
		Section = newCD.getSection();
		X = newCD.getX();
		Y = newCD.getY();
		Barcode = newCD.getBarcode();
		Description = newCD.getDescription();
		OnLoan = newCD.isOnLoan();
	}

	public CD(String[] input){
		try
		{

			Id = Integer.parseInt(input[0]);
			Title = input[1];
			Author = input[2];
			Section = input[3].charAt(0);
			X = Integer.parseInt(input[4]);
			Y = Integer.parseInt(input[5]);
			Barcode = Integer.parseInt(input[6]);
			Description = input[7];
			switch (input[8])
			{
				case "No" -> OnLoan = false;
				case "Yes" -> OnLoan = true;
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public String[] GetAllFieldsAsString(){
		return new String[]
			{
					Integer.toString(Id),
					Title,
					Author,
					String.valueOf(Section),
					Integer.toString(X),
					Integer.toString(Y),
					Integer.toString(Barcode),
					Description,
					String.valueOf(OnLoan)
			};
	}
	
	public Object[] GetAllFields(){
		return new Object[]
			{
					Id,
					Title,
					Author,
					Section,
					X,
					Y,
					Barcode,
					Description,
					OnLoan
			};
	}
	
	public void UpdateCD(CD data)
	{
		Title = data.getTitle();
		Author = data.getAuthor();
		Section = data.getSection();
		X = data.getX();
		Y = data.getY();
		Barcode = data.getBarcode();
		Description = data.getDescription();
	}
	
	public int getId()
	{
		return Id;
	}
	
	public void setId(int id)
	{
		Id = id;
	}
	
	public String getTitle()
	{
		return Title;
	}
	
	public void setTitle(String title)
	{
		Title = title;
	}
	
	public String getAuthor()
	{
		return Author;
	}
	
	public void setAuthor(String author)
	{
		Author = author;
	}
	
	public char getSection()
	{
		return Section;
	}
	
	public void setSection(char section)
	{
		Section = section;
	}
	
	public int getX()
	{
		return X;
	}
	
	public void setX(int x)
	{
		X = x;
	}
	
	public int getY()
	{
		return Y;
	}
	
	public void setY(int y)
	{
		Y = y;
	}
	
	public int getBarcode()
	{
		return Barcode;
	}
	
	public void setBarcode(int barcode)
	{
		Barcode = barcode;
	}
	
	public String getDescription()
	{
		return Description;
	}
	
	public void setDescription(String description)
	{
		Description = description;
	}
	
	public boolean isOnLoan()
	{
		return OnLoan;
	}
	
	public void setOnLoan(boolean onLoan)
	{
		OnLoan = onLoan;
	}
	
	
}
