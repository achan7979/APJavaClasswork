package Lab4three;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameCode extends Application
{
	public static int score = 0;
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
	    long startTime = System.nanoTime();
	    long endTime = System.nanoTime();
	    while(endTime - startTime < 1000000000)
	    {
	    	btn.setOnAction(new EventHandler<ActionEvent>() 
	    	{
	    		@Override
	    		public void handle(ActionEvent event) 
	    		{
	    			score++;
	    			System.out.println(score);
	    			endTime = System.nanoTime();
	    		}
	    	});
	    }
	    StackPane root = new StackPane();
	    root.getChildren().add(btn);
	    primaryStage.setScene(new Scene(root, 300, 250));
	    primaryStage.show();
	 }
}
