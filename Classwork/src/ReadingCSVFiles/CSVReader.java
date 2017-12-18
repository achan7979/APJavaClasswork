package ReadingCSVFiles;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.ArrayList; 
import java.util.List; 

public class CSVReader 
{
	public static void main(String[] args)
	{
		List<UhHuh> mmmmmm = readUhHuhFromCSV("Book1.csv"); 
		for (UhHuh b : mmmmmm) 
		{ 
			System.out.println(b); 
		}
	}
	
	private static List<UhHuh> readUhHuhFromCSV(String fileName) 
	{ 
		List<UhHuh> yeeeeeet = new ArrayList<>(); 
		Path pathToFile = Paths.get(fileName);
		try (BufferedReader br = Files.newBufferedReader(pathToFile,StandardCharsets.US_ASCII)) 
		{
			String line = br.readLine();
			while (line != null) 
			{
				String[] things = line.split(",");
				UhHuh yeet = createUhhhhhh(things);
				yeeeeeet.add(yeet);
				line = br.readLine();
			}
		} 
		catch (IOException ioe) 
		{
            ioe.printStackTrace();
        }
		return yeeeeeet;
	}
	
	private static UhHuh createUhhhhhh(String[] metadata) 
	{ 
		String name = metadata[0]; 
		String mhm = metadata[1]; 
		return new UhHuh(name, mhm);
	}
}
