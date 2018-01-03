package Lab4three;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
		Text playerScore = new Text(10,0, "Score: ");
		Text status = new Text(10,50, "Game On!");

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
	
		timer = System.nanoTime() + 1000000000L;
		new AnimationTimer()
		{
			public void handle(long now)
			{
				if(now > timer)
				{
					timer = now + 1000000000L;
					gameOn = !gameOn;
				}
				if(!gameOn)
				{
					btn.setDisable(true);
				}
				
				playerScore.setText("Score: " + Integer.toString(score));
			}
		}.start();
		StackPane root = new StackPane();
		root.getChildren().add(btn);
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}
}