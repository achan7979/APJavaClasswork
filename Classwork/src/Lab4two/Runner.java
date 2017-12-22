package Lab4two;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Runner 
{
	public static void main(String[] args)
	{
		File CSVData = new File("Quality_Of_Life_Indicators.csv");
		CSVUtilities Data = new CSVUtilities(CSVData);
		List<String> col = Data.getColumnHeaders();
		List<String> col1 = Data.getDataString(1);
		//List<Integer> col1 = Data.getDataInt(1);
		//List<Double> col1 = Data.getDataDouble(1);
		for(String s : col) 
		{
			System.out.println(s);
		}
		for(String s : col1) 
		{
			System.out.println(s);
		}
	}
}