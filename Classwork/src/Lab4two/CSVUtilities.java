package Lab4two;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
		ArrayList<String> data = new ArrayList<>(); 
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
		this.CSVData = data;
	}
	
	public void writeHighScoreToCSV (File csv, String name, int score)
	{
		PrintWriter pw = null;
		try
		{
			pw = new PrintWriter(csv);
		}
		catch(FileNotFoundException e)
		{
			System.err.println(e);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(name + "," + score + "\n");
		pw.write(sb.toString());
		pw.close();
	}
	
	public List<String> getColumnHeaders()
	{
		ArrayList<String> columns = this.CSVData;
		return Arrays.asList(columns.get(0).split(","));
	}
	
	public List<String> getDataString(int column)
	{
		List<String> dataString = new ArrayList<String>();
		List<String> data = new ArrayList<String>();
		for(int i = 1; i < this.CSVData.size()-1; i++)
		{
			dataString = Arrays.asList(this.CSVData.get(i).split(","));
			if(column < this.CSVData.get(0).split(",").length)
			{
				data.add(dataString.get(column));
			}
		}
		return data;
	}
	public List<Integer> getDataInt(int column)
	{
		List<String> dataInt = new ArrayList<String>();
		List<Integer> data = new ArrayList<Integer>();
		for(int i = 1; i < this.CSVData.size()-1; i++)
		{
			dataInt = Arrays.asList(this.CSVData.get(i).split(","));
			if(column < this.CSVData.get(0).split(",").length)
			{
				data.add(Integer.parseInt(dataInt.get(column)));
			}
		}
		return data;
	}
	
	public List<Double> getDataDouble(int column)
	{
		List<String> dataDouble = new ArrayList<String>();
		List<Double> data = new ArrayList<Double>();
		for(int i = 1; i < this.CSVData.size() - 1; i++)
		{
			dataDouble = Arrays.asList(this.CSVData.get(i).split(","));
			if(column < this.CSVData.get(0).split(",").length)
			{
				data.add(Double.parseDouble(dataDouble.get(column)));
			}
		}
		return data;
	}
}
