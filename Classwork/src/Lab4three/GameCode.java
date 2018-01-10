package Lab4three;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ReadingCSVFiles.UhHuh;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameCode extends Application
{
	public static int score = 0;
	public static boolean gameOn = true;;
	public static long timer;
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("What is your name player?");
		String playerName = in.next();
		launch(args);
		append("results.csv", playerName + "," + score);
		List<Player> highScores = readScoresFromCSV("results.csv"); 
		selectionSort(highScores);
		for (Player b : highScores) 
		{ 
			System.out.print(b.name + ", "); 
			System.out.println(b.score); 
		}
		
		System.out.println("Your score has been added! Check results.csv for all the scores placed!");
	}
	

	@Override
	public void start(Stage primaryStage) 
	{
		primaryStage.setTitle("Button Clicker");
		Button btn = new Button();
		btn.setText("Click!");
		Text playerScore = new Text("Score: ");
		Text status = new Text("Game On!");

		btn.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event) 
			{
				if(gameOn)
				{
					score++;
				}
			}
		});
	
		timer = System.nanoTime() + 10000000000L;
		new AnimationTimer()
		{
			public void handle(long now)
			{
				if(now > timer)
				{
					timer = now + 10000000000L;
					gameOn = !gameOn;
				}
				if(!gameOn)
				{
					btn.setDisable(true);
					status.setText("Game Over! Close the window");
				}
				
				playerScore.setText("Score: " + Integer.toString(score) + "       ");
			}
		}.start();
		
		StackPane root = new StackPane();
		HBox hbox = new HBox();
		root.getChildren().add(hbox);
		hbox.getChildren().addAll(playerScore);
		hbox.getChildren().addAll(status);
		root.getChildren().add(btn);
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}
	
	public static void append(String fileName, String line) 
	{
		try (FileWriter pw = new FileWriter(Paths.get(fileName).toString(), true);) 
		{
			for (String s : line.split(",")) 
			{
		 		pw.append(s);
		 		pw.append(',');
		 	}
		 	pw.append('\n');
		 	pw.flush();
		 	pw.close();
		} 
		catch (IOException e) 
		{
		 	e.printStackTrace();
		}
	}
	
	private static List<Player> readScoresFromCSV(String fileName) 
	{ 
		List<Player> theScores = new ArrayList<>(); 
		Path pathToFile = Paths.get(fileName);
		try (BufferedReader br = Files.newBufferedReader(pathToFile,StandardCharsets.US_ASCII)) 
		{
			String line = br.readLine();
			while (line != null) 
			{
				String[] things = line.split(",");
				Player thePlayer = createPlayer(things);
				theScores.add(thePlayer);
				line = br.readLine();
			}
		} 
		catch (IOException ioe) 
		{
            ioe.printStackTrace();
        }
		return theScores;
	}
	
	private static Player createPlayer(String[] metadata) 
	{ 
		String name = metadata[0]; 
		String score = metadata[1]; 
		return new Player(name, score);
	}
	
	public static void selectionSort(List<Player> list1)
	{
		for(int i = 1; i < list1.size(); i++)
		{
			for(int j = i+1; j < list1.size(); j++)
			{
				if(list1.get(i).score.compareTo(list1.get(j).score) < 0)
				{
					swap(list1,i,j);
				}
			}
		}
	}
	
	private static void swap(List<Player> a, int i, int j)
	{
	    Player temp = a.get(i);
	    a.set(i,a.get(j));
	    a.set(j,temp);
	}
}
