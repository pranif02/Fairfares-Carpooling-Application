package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignupController {
	@FXML
	private TextField uname;
	@FXML
	private PasswordField pwd;
    @FXML
	private Hyperlink sign;
	@FXML
	private Button buttonlog;
	@FXML
	public Label label;
	@FXML
	public TextField homed;
	@FXML
	private TextField workd;
	@FXML
	private Button signb;

public void loginpage(ActionEvent event)throws Exception {
	Stage primaryStage=new Stage();
	try {
		
		Parent root =FXMLLoader.load(getClass().getResource("/application/login.fxml"));
		Scene scene = new Scene(root,650,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Fair Fares:Carpooling System");
		primaryStage.show();
		
}
catch(Exception e)
{
	e.printStackTrace();
}
}
public void signup(ActionEvent event)throws Exception {
	Stage primaryStage=new Stage();
	try {
		
		Parent root =FXMLLoader.load(getClass().getResource("/application/Signup.fxml"));
		Scene scene = new Scene(root,650,700);
		primaryStage.setScene(scene);
		primaryStage.show();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproj","root","");
		Statement stmt=c.createStatement();
		String sql="insert into details values(' " +uname.getText()+ " ',' " +pwd.getText()+ " ',' " +homed.getText()+ " ',' " +workd.getText()+ " ')";
		int x=stmt.executeUpdate(sql);
		if(x>0)
		{
			//work-->if username already exists then go to login page
        label.setText("Successful registered");
        System.out.println("Successfully registered");
        Parent root1 =FXMLLoader.load(getClass().getResource("/application/Real.fxml"));
		Scene scene1 = new Scene(root1,650,400);
		primaryStage.setScene(scene1);
		primaryStage.show();

		}
		else
		{
			
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}

}