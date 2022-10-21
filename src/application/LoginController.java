package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;
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


public class LoginController extends Application  {
	@FXML
	public TextField uname;
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
	public TextField workd;
	@FXML
	private Button signb;
	
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
			String sql="INSERT into details VALUES ('" +uname.getText()+ "', '" +pwd.getText()+ "', '" +homed.getText()+ "', '"+workd.getText()+ "')";
			 
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
				System.out.println("Insert failed");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	
	public void login(ActionEvent event)throws Exception{
		Stage primaryStage=new Stage();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproj","root","");
			Statement stmt=c.createStatement();
			
			String sql2="Select * from details where Name=' " +uname.getText()+ "' and Password=' " +pwd.getText()+ "'";
			ResultSet rs=stmt.executeQuery(sql2);
			if(rs.next()) 
			{
	        label.setText("Successful login");
	        System.out.println("Name: "+uname.getText()+"\n Password: "+pwd.getText());
	        System.out.println("Congrats!! Successful Login");
			Parent root =FXMLLoader.load(getClass().getResource("/application/Real.fxml"));	
			Scene scene = new Scene(root,700,400);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Fair Fares:Carpooling System");
			primaryStage.show();
			System.out.println("Do you want to drive or share your ride");
			
			}

			String s="Select * from details where Name !=' " +uname.getText()+ "' and Password =' " +pwd.getText()+ "'";
			ResultSet r2=stmt.executeQuery(s);
			if(r2.next()) 
			{
	        label.setText("Incorrect Username");
	        System.out.println("You have entered an incorrect username..Try again!!");
			}
			
			String sq="Select * from details where Name=' " +uname.getText()+ " ' and Password !=' " +pwd.getText()+ "'";
			ResultSet r1=stmt.executeQuery(sq);
			if(r1.next()) 
			{
	        label.setText("Incorrect Password");
	        System.out.println("You have entered an incorrect password..Try again!!");
			}
				
			
			String sq2="Select * from details where Name!=' " +uname.getText()+ "' and Password !=' " +pwd.getText()+ "'";
			ResultSet r3=stmt.executeQuery(sq2);
			if(r3.next()) 
			{
	         //label.setText("Incorrect details");
	         // System.out.println("You have entered an incorrect details..Try again!!");
			}
				
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	 }
	public void signuppage(ActionEvent event)throws Exception{
		Stage primaryStage=new Stage();
		try {
			
			Parent root =FXMLLoader.load(getClass().getResource("/application/Signup.fxml"));
			Scene scene = new Scene(root,650,590);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Fair Fares:Carpooling System");
			primaryStage.show();
			
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	
	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	

}
