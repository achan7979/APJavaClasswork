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
		List<Double> col = Data.getDataDouble(1);
		for(Double s : col) 
		{
			System.out.println(s);
		}
	}
}
