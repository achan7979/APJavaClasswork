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
		/*
		for (Player b : highScores) 
		{ 
			System.out.print(b.name + ", "); 
			System.out.println(b.score); 
		}
		*/
		writeToCSV(highScores);
		System.out.println("Your score has been added! Check results.csv for all the scores placed!");
	}
	

	@Override
	/**
	 * Creates the initial stage with a button and some text that will eventually change
	 * depending on the state of the game. Every time the mouse is clicked, score will
	 * be incremented by one. The timer will disable to button after 10 seconds. After,
	 * the window will need to be closed in order for the scores to be added.
	 */
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
	
	/**
	 * This method access the file through using the relative path of the file and 
	 * splits the data by commas. It splits the line that is passed in and appends 
	 * it to the CSV file and as a result, to the high score list.
	 * 
	 * @param fileName a String representing the file name
	 * @param line a String of data meant to be appended
	 */
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
	
	/**
	 *This method actually writes into the CSV file by creating a new print writer object
	 *and overwrites the file currently in the directory. It takes in the list of players and 
	 *first appends the headers. Then the for loop skips the headers and continues to append
	 *all the data into the CSV file and closes the print writer.
	 *  
	 * @param theScores the List of player objects that have the players name and score.
	 */
	public static void writeToCSV(List<Player> theScores)
	{
		PrintWriter pw = null;
		try
		{
			pw = new PrintWriter(new File("results.csv"));
		}
		catch(FileNotFoundException e)
		{
			System.err.println(e);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("Name,High Score\n");
		for(int i = 1; i < theScores.size(); i++)
		{
			sb.append(theScores.get(i).name + "," + theScores.get(i).score + "\n");
		}
		pw.write(sb.toString());
		pw.close();
	}
	
	/**
	 * This method reads the data from the CSV file by splitting the data by commas and creates a player
	 * based on the data thats being read in. It then adds the player into the list and continues to read 
	 * and returns a list of all the players.
	 * 
	 * @param fileName a String representing the file name
	 */
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
	
	/**
	 * Creates a new player object based on the data that is passed in the String array
	 * 
	 * @param metadata a String array with the data of the player
	 * @return the Player 
	 */
	private static Player createPlayer(String[] metadata) 
	{ 
		String name = metadata[0]; 
		String score = metadata[1]; 
		return new Player(name, score);
	}
	
	/**
	 * This is meant to sort the players based on score. Since the score field of the players
	 * are Strings, this method converts the string into an integer and compares their values
	 * and sorts them in descending order. 
	 * 
	 * @param list1 the List of players that played the game
	 */
	public static void selectionSort(List<Player> list1)
	{
		for(int i = 1; i < list1.size(); i++)
		{
			for(int j = i+1; j < list1.size(); j++)
			{
				if(Integer.parseInt(list1.get(i).score) < Integer.parseInt(list1.get(j).score))
				{
					swap(list1,i,j);
				}
			}
		}
	}
	
	/**
	 * Helper method to swap objects in the List
	 * 
	 * @param a the List of players
	 * @param i the index of the player object to be swapped with j
	 * @param j the index of the player object to be swapped with i
	 */
	private static void swap(List<Player> a, int i, int j)
	{
	    Player temp = a.get(i);
	    a.set(i,a.get(j));
	    a.set(j,temp);
	}
}
