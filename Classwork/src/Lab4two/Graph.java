package Lab4two;
import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class Graph extends Application
{
	final static String quarter1 = "Q1 09";
	final static String quarter2 = "Q2 09";
	final static String quarter3 = "Q3 09";
	final static String quarter4 = "Q4 09";
	
	@Override
	public void start(Stage stage) throws Exception 
	{
		File CSVData = new File("Quality_Of_Life_Indicators.csv");
		CSVUtilities Data = new CSVUtilities(CSVData);
		Double quar1Data;
		quar1Data = Data.getDataDouble(1).get(1);
		Double quar2Data;
		quar2Data = Data.getDataDouble(2).get(1);
		Double quar3Data;
		quar3Data = Data.getDataDouble(3).get(1);
		Double quar4Data;
		quar4Data = Data.getDataDouble(4).get(1);
		
		
		stage.setTitle("Quality of Life");
		final CategoryAxis xAxis = new CategoryAxis();
	    final NumberAxis yAxis = new NumberAxis();
	    final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
	    bc.setTitle("Quality of Life");
	    xAxis.setLabel("Quarters of 2009");
	    yAxis.setLabel("Percentage");
	    
	    XYChart.Series series1 = new XYChart.Series();
	    series1.setName("Downtown Vacany Rates");
	    series1.getData().add(new XYChart.Data(quarter1, quar1Data));
	    series1.getData().add(new XYChart.Data(quarter2, quar2Data));
	    series1.getData().add(new XYChart.Data(quarter3, quar3Data));
	    series1.getData().add(new XYChart.Data(quarter4, quar4Data));
	    
	    Scene scene = new Scene(bc,1000,1000);
	    bc.getData().addAll(series1);
	    stage.setScene(scene);
	    stage.show();
	}
	public static void main(String[] args) 
	{
		launch(args);
	}
}
