package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DriverController  {
	@FXML
	private Button buttond;
	@FXML
	private Button buttons;
	public void driveradd(ActionEvent event) {
		try {
		Stage primaryStage= new Stage();
		Parent root =FXMLLoader.load(getClass().getResource("/application/Driver_details.fxml"));
		Scene scene = new Scene(root,650,400);
		System.out.println("DRIVE");
		primaryStage.setScene(scene);
		primaryStage.setTitle("Fair Fares:Carpooling System");
		primaryStage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void passadd(ActionEvent event)throws Exception{
		try {
		Stage primaryStage=new Stage();
		Parent root =FXMLLoader.load(getClass().getResource("/application/passengers.fxml"));
		Scene scene = new Scene(root,650,400);
		System.out.println("SHARE");
		primaryStage.setScene(scene);
		primaryStage.setTitle("Fair Fares:Carpooling System");
		primaryStage.show();
		}
		catch(Exception e)
		{
				e.printStackTrace();
		}
		}
}
