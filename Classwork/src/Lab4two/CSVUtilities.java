package Lab4two;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CSVUtilities 
{
	private ArrayList<String> CSVData;
	private int numColumns;
	
	public CSVUtilities(File csv)
	{
		Scanner in = null;
		List<String> data = new ArrayList<>(); 
		try 
		{
			in = new Scanner(csv);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		while(in.hasNextLine())
		{
			data.add(in.nextLine());
		}
		this.CSVData = (ArrayList<String>) data;
		String[] columns = data.get(0).split(",");
		this.numColumns = columns.length;
	}
	
	public List<String> getColumnHeaders()
	{
		ArrayList<String> columns = this.CSVData;
		return Arrays.asList(columns.get(0).split(","));
	}
	
	public List<String> getDataString(int columns)
	{
		List<String> dataString = new ArrayList<String>();
		List<String> data =  new ArrayList<String>();
		for(int i = 0; i < this.CSVData.size(); i++)
		{
			dataString = Arrays.asList(this.CSVData.get(i).split(","));
			data.add(dataString.get(columns));
		}
		return data;
	}
	
	public List<Integer> getDataInt(int column)
	{
		
	}
	
	public List<Double> getDataDouble(int column)
	{
		
	}
}
