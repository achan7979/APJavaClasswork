package Lab4three;

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
		launch(args);
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
					status.setText("Game Over!");
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
}