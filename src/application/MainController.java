/*package application;

import java.sql.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainController {
	@FXML
	private Label label;
	@FXML
	private TextField homed;
	@FXML
	private TextField workd;
	@FXML
	private TextField uname;
	@FXML
	private PasswordField pwd;
	@FXML
	private Button button;
	@FXML
	private Button log;
	@FXML
	private Button start;
	@FXML
	private Button signb;
	@FXML
	private Hyperlink sign;
	@FXML
	private Button buttonpass;
	@FXML
	private Button buttonlog;
	@FXML
	private Button buttond;
	
	
	
/*	
	public void signup(ActionEvent event)throws Exception {
		Stage primaryStage=new Stage();
		try {
			
			Parent root =FXMLLoader.load(getClass().getResource("/application/Signup.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
			Scene scene1 = new Scene(root1,400,400);
			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
	
public void login(ActionEvent event)throws Exception {
	Stage primaryStage=new Stage();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproj","root","");
		Statement stmt=c.createStatement();
		
		String sql="Select * from details where Name='"+uname.getText()+"' and Password='"+pwd.getText()+"'";
		ResultSet rs=stmt.executeQuery(sql);
		if(rs.next()) 
		{
        label.setText("Successful login");
        System.out.println("Congrats!! Successful Login");
		Parent root =FXMLLoader.load(getClass().getResource("/application/Real.fxml"));	
		Scene scene = new Scene(root,600,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		System.out.println("Do you want to drive or share your ride");
		
		}

		String s="Select * from details where Name!='"+uname.getText()+"' and Password ='"+pwd.getText()+"'";
		ResultSet r2=stmt.executeQuery(s);
		if(r2.next()) 
		{
        label.setText("Incorrect Username");
        System.out.println("You have entered an incorrect username..Try again!!");
		}
		
		String sq="Select * from details where Name='"+uname.getText()+"' and Password !='"+pwd.getText()+"'";
		ResultSet r1=stmt.executeQuery(sq);
		if(r1.next()) 
		{
        label.setText("Incorrect Password");
        System.out.println("You have entered an incorrect password..Try again!!");
		}
			
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
 }
public void loginpage(ActionEvent event)throws Exception {
	Stage primaryStage=new Stage();
	try {
		
		Parent root =FXMLLoader.load(getClass().getResource("/application/login.fxml"));
		Scene scene = new Scene(root,600,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
}
catch(Exception e)
{
	e.printStackTrace();
}
}
public void signuppage(ActionEvent event)throws Exception {
	Stage primaryStage=new Stage();
	try {
		
		Parent root =FXMLLoader.load(getClass().getResource("/application/signup.fxml"));
		Scene scene = new Scene(root,600,600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
}
catch(Exception e)
{
	e.printStackTrace();
}
}


public void driveradd(ActionEvent event)throws Exception {
	Stage primaryStage= new Stage();
	
	Parent root =FXMLLoader.load(getClass().getResource("/application/Driver_details.fxml"));
	Scene scene = new Scene(root);
	System.out.println("DRIVE");
	primaryStage.setScene(scene);
	primaryStage.show();
	
	//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

	}

	
public void passadd(ActionEvent event)throws Exception{
	Stage primaryStage=new Stage();
	Parent root =FXMLLoader.load(getClass().getResource("/application/passengers.fxml"));
	Scene scene = new Scene(root);
	System.out.println("SHARE");
	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	primaryStage.setScene(scene);
	primaryStage.show();
}

public void match(ActionEvent event)throws Exception {

	try {
		// CheckBox ch= new CheckBox();
		// CheckBox ch1 = new CheckBox();
		// CheckBox ch2 = new CheckBox();
       //  CheckBox ch3=new CheckBox();		 

		System.out.println("\nEnter your home address");
		System.out.println(homed.getText().toString());
		System.out.println("\nEnter your work address");
		System.out.println(workd.getText().toString());

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproj","root","");
		Statement stmt=c.createStatement();
		Statement stmt1=c.createStatement();
		String sql="Select Name from details where Work='"+workd.getText()+"'";
		 String sql1="Select Home from details where Work='"+workd.getText()+"'";
		ResultSet rs=stmt.executeQuery(sql);
	    ResultSet rs1=stmt1.executeQuery(sql1);
	    Stage primaryStage=new Stage();
		
		if(rs.next()&&rs1.next())
		{  
	        String Name=rs.getString("Name");
	        String Home=rs1.getString("Home");
	        CheckBox ch=new CheckBox(Name+"\n"+Home);
	        rs.next();
	        rs1.next();
	         String Name1=rs.getString("Name");
	        String Home1=rs1.getString("Home");
	        CheckBox ch1=new CheckBox(Name1+"\n"+Home1); 
	        rs.next();
	        rs1.next();
	        String Name2=rs.getString("Name");
	        String Home2=rs1.getString("Home");
	        CheckBox ch2=new CheckBox(Name2+"\n"+Home2); 
	        AnchorPane t=new AnchorPane();
	        VBox vbox=new VBox(ch,ch1,ch2);
	        
	        Button bt=new Button("ACCEPT");
	   
	        EventHandler<ActionEvent> event1=new EventHandler<ActionEvent>(){
	        	public void handle(ActionEvent e) {
	        	      Label l=new Label("You have got passengers!!\n\nLETS START CARPOOLING!!");
	        	      Scene sc=new Scene(l,400,400);
	        	      primaryStage.setScene(sc);
	        	      primaryStage.setTitle("Welcome to Fair Fares:Carpooling System!");
	        	      primaryStage.setUserData(vbox);
	        	      primaryStage.setWidth(600);
	        	      primaryStage.show();
	        	}
		       };
	        bt.setOnAction(event1);
	        bt.setLayoutX(80);
	        bt.setLayoutY(125);
	        t.getChildren().add(bt);
	        t.getChildren().add(vbox);
	    	Scene scene=new Scene(t,300,200); 
			primaryStage.setScene(scene); 
			primaryStage.show();
		}

		else 
		{
				System.out.println("\n Incorrect address details ");
		}
		
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
 
}
}
*/

