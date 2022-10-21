package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {           //abstract method of application class
		try {
			Parent root =FXMLLoader.load(getClass().getResource("/application/cover.fxml"));
			Scene scene = new Scene(root,650,400);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Fair Fares:Carpooling System");
			primaryStage.setResizable(true);
			primaryStage.show();
			System.out.println("WELCOME TO FAIR FARES:CARPOOLING SYSTEM \n");
		    }
			catch(Exception e)
			{
				e.printStackTrace();
			}
			}		
	
	public static void main(String[] args) {
		launch(args);
	}
}


