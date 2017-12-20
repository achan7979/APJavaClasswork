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
	
	public List<String> getDataString(int column)
	{
		List<String> dataString = new ArrayList<String>();
		List<String> data =  new ArrayList<String>();
		for(int i = 0; i < this.CSVData.size(); i++)
		{
			dataString = Arrays.asList(this.CSVData.get(i).split(","));
			data.add(dataString.get(column));
		}
		return data;
	}
	
	public List<Integer> getDataInt(int column)
	{
		List<String> dataInt = new ArrayList<String>();
		List<Integer> data = new ArrayList<Integer>();
		for(int i = 0; i < this.CSVData.size(); i++)
		{
			dataInt = Arrays.asList(this.CSVData.get(i).split(","));
			data.add(Integer.parseInt(dataInt.get(column)));
		}
		return data;
	}
	
	public List<Double> getDataDouble(int column)
	{
		List<Double> dataDouble = new ArrayList<Double>();
		List<Double> data = new ArrayList<Double>();
		return data;
	}
}
