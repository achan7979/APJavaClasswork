package ReadingCSVFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CSVReader 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		String location = "C:\\Users\\BT_1N3_19\\git\\APJavaClasswork\\Classwork\\Book1.csv";
		File file = new File(location);
		Scanner in = new Scanner(file);
		while (in.hasNext())
		{
			System.out.println(in.next());
		}
		in.close();
	}
}
