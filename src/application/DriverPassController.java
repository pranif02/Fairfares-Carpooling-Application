package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class DriverPassController extends LoginController{ 

	@FXML
	private TextField homed;
	@FXML
	private TextField workd;
	@FXML
	public Label lab;
	@FXML
	private Button buttonpass;
	CheckBox ch= new CheckBox();
	CheckBox ch1 = new CheckBox();
	CheckBox ch2 = new CheckBox();

	public void match(ActionEvent event)throws Exception {
		try {
		
			System.out.println("\nEnter your home address");
			System.out.println(homed.getText().toString());
			System.out.println("\nEnter your work address");
			System.out.println(workd.getText().toString());

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproj","root","");
			Statement stmt=c.createStatement();
			Statement stmt1=c.createStatement();
			String sql="Select Name from details where Work=' " +workd.getText()+"'";
			 String sql1="Select Home from details where Work=' " +workd.getText()+"'";
			ResultSet rs=stmt.executeQuery(sql);
		    ResultSet rs1=stmt1.executeQuery(sql1);
		    Stage primaryStage=new Stage();
			
			if(rs.next()&&rs1.next())
			{  
				 AnchorPane t=new AnchorPane();
				 AnchorPane t1=new AnchorPane();
			     Pane p=new Pane();
			     Pane p1=new Pane(); 
		        String Name=rs.getString("Name");
		        String Home=rs1.getString("Home");
		        ch=new CheckBox(Name+"\n"+Home);
		        rs.next();
		        rs1.next();
		         String Name1=rs.getString("Name");
		        String Home1=rs1.getString("Home");
		        ch1=new CheckBox(Name1+"\n"+Home1); 
		        if(rs.next()&&rs1.next())
		        {
		        //rs.next();
		        //rs1.next();
		        String Name2=rs.getString("Name");
		        String Home2=rs1.getString("Home");
		        ch2=new CheckBox(Name2+"\n"+Home2); 
		        p.setStyle("-fx-background-color:YELLOWGREEN;");
		        p.setPrefSize(200,600);
		        p1.setStyle("-fx-background-color:YELLOWGREEN;");
		        p1.setPrefSize(200,600);
		        VBox vbox=new VBox(ch,ch1,ch2);
		        
		        Button bt=new Button("ACCEPT");
		   
		        EventHandler<ActionEvent> event1=new EventHandler<ActionEvent>(){
		        	
					public void handle(ActionEvent e) {
		        		if(ch.isSelected()&&ch1.isSelected()&&ch2.isSelected())   //if 1 is selected
		        		{
		        		 Label lab1=new Label();

		        	     lab1.setText("You have got passenger!!\n\n Name is "+Name+"\nAddress is "+Home+"\n\nName is "+Name1+"\nAddress is "+Home1+"\n\nName is "+Name2+"\nAddress is "+Home2);
		        		 
		        		 Button bt2=new Button("EXIT");
		        	      EventHandler<ActionEvent> event2=new EventHandler<ActionEvent>() {
		        	    	 public void handle(ActionEvent e) {
		        	    		 primaryStage.close();
		        	    	 }
		        	      };
		        	      bt2.setOnAction(event2);
		        	      bt2.setLayoutX(100);
		  		          bt2.setLayoutY(200);
		        	      t1.getChildren().add(p1);
		        	      t1.getChildren().add(lab1);
		        	      t1.getChildren().add(bt2);
		        	      Scene sc=new Scene(t1,650,400);
		        	      primaryStage.setScene(sc);
		        	     primaryStage.setUserData(vbox);
		          	      primaryStage.setWidth(650);
		        	      primaryStage.setTitle("Fair Fares:Carpooling System");
		        	      primaryStage.show();
		        	      System.out.println("Well you have got passengers and you are ready to ride!!");
		        	
		        	}
		        		else	if(ch.isSelected()&&ch1.isSelected())   //if 1 is selected
	        		{
		        		 Label lab1=new Label();

		        	     lab1.setText("You have got passenger!!\n\n Name is "+Name+"\nAddress is "+Home+"\n\nName is "+Name1+"\nAddress is "+Home1);
		        		 System.out.println("You have got passenger!!\n\n Name is "+Name+"\nAddress is "+Home+"\n\nName is "+Name1+"\nAddress is "+Home1);
		        		 Button bt2=new Button("EXIT");
		        	      EventHandler<ActionEvent> event2=new EventHandler<ActionEvent>() {
		        	    	 public void handle(ActionEvent e) {
		        	    		 primaryStage.close();
		        	    		
		        	    	 }
		        	      };
		        	      bt2.setOnAction(event2);
		        	      bt2.setLayoutX(100);
		  		          bt2.setLayoutY(200);
		        	      t1.getChildren().add(p1);
		        	      t1.getChildren().add(lab1);
		        	      t1.getChildren().add(bt2);
		        	      Scene sc=new Scene(t1,650,400);
		        	      primaryStage.setScene(sc);
		        	     primaryStage.setUserData(vbox);
		          	      primaryStage.setWidth(650);
		        	      primaryStage.setTitle("Fair Fares:Carpooling System");
		        	      primaryStage.show();
		        	      System.out.println("Well you have got passengers and you are ready to ride!!");
		        	
		        	}
		        	else if(ch1.isSelected()&&ch2.isSelected())   //if 1 is selected
	        		{
	        		 Label lab1=new Label();

	        	     lab1.setText("You have got passenger!!\n\nName is "+Name1+"\nAddress is "+Home1+"\n\nName is "+Name2+"\nAddress is "+Home2);
	        		 System.out.println("You have got passenger!!\n\nName is "+Name1+"\nAddress is "+Home1+"\n\nName is "+Name2+"\nAddress is "+Home2);
	        		 Button bt2=new Button("EXIT");
	        	      EventHandler<ActionEvent> event2=new EventHandler<ActionEvent>() {
	        	    	 public void handle(ActionEvent e) {
	        	    		 primaryStage.close();
	        	    	 }
	        	      };
	        	      bt2.setOnAction(event2);
	        	      bt2.setLayoutX(100);
	  		          bt2.setLayoutY(200);
	        	      t1.getChildren().add(p1);
	        	      t1.getChildren().add(lab1);
	        	      t1.getChildren().add(bt2);
	        	      Scene sc=new Scene(t1,650,400);
	        	      primaryStage.setScene(sc);
	        	     primaryStage.setUserData(vbox);
	          	      primaryStage.setWidth(650);
	        	      primaryStage.setTitle("Fair Fares:Carpooling System");
	        	      primaryStage.show();
	        	      System.out.println("Well you have got passengers and you are ready to ride!!");
	        	
	        	}
		          	else if(ch.isSelected()&&ch2.isSelected())   //if 1 is selected
	        		{
	        		 Label lab1=new Label();

	        	     lab1.setText("You have got passenger!!\n\n Name is "+Name+"\nAddress is "+Home+"\n\nName is "+Name2+"\nAddress is "+Home2);
	        		 System.out.println("You have got passenger!!\n\n Name is "+Name+"\nAddress is "+Home+"\n\nName is "+Name2+"\nAddress is "+Home2);
	        		 Button bt2=new Button("EXIT");
	        	      EventHandler<ActionEvent> event2=new EventHandler<ActionEvent>() {
	        	    	 public void handle(ActionEvent e) {
	        	    		 primaryStage.close();
	        	    	 }
	        	      };
	        	      bt2.setOnAction(event2);
	        	      bt2.setLayoutX(100);
	  		          bt2.setLayoutY(200);
	        	      t1.getChildren().add(p1);
	        	      t1.getChildren().add(lab1);
	        	      t1.getChildren().add(bt2);
	        	      Scene sc=new Scene(t1,650,400);
	        	      primaryStage.setScene(sc);
	        	     primaryStage.setUserData(vbox);
	          	      primaryStage.setWidth(650);
	        	      primaryStage.setTitle("Fair Fares:Carpooling System");
	        	      primaryStage.show();
	        	      System.out.println("Well you have got passengers and you are ready to ride!!");
	        	
	        	}
		        		else
		        		{
		        		
							lab.setText("You didnt select anyone!!");
		        		}
					}
			       };
		        bt.setOnAction(event1);
		        bt.setLayoutX(100);
		        bt.setLayoutY(200);
		        t.getChildren().add(p);
		        t.getChildren().add(vbox);
		        t.getChildren().add(bt);
		    	Scene scene=new Scene(t,650,400); 
				primaryStage.setScene(scene); 
				primaryStage.setTitle("Fair Fares:Carpooling System");
				primaryStage.show();
			}
		        else
		        {
		        	 p.setStyle("-fx-background-color:YELLOWGREEN;");
				        p.setPrefSize(200,600);
				        p1.setStyle("-fx-background-color:YELLOWGREEN;");
				        p1.setPrefSize(200,600);
				        VBox vbox=new VBox(ch,ch1);
				        
				        Button bt=new Button("ACCEPT");
				   
				        EventHandler<ActionEvent> event1=new EventHandler<ActionEvent>(){
				        	
							public void handle(ActionEvent e) {
		        	if(ch.isSelected()&&ch1.isSelected())   //if 1 is selected
	        		{
		        		 Label lab1=new Label();

		        	     lab1.setText("You have got passenger!!\n\n Name is "+Name+"\nAddress is "+Home+"\n\nName is "+Name1+"\nAddress is "+Home1);
		        		 System.out.println("You have got passenger!!\n\n Name is "+Name+"\nAddress is "+Home+"\n\nName is "+Name1+"\nAddress is "+Home1);
		        		 Button bt2=new Button("EXIT");
		        	      EventHandler<ActionEvent> event2=new EventHandler<ActionEvent>() {
		        	    	 public void handle(ActionEvent e) {
		        	    		 primaryStage.close();
		        	    		
		        	    	 }
		        	      };
		        	      bt2.setOnAction(event2);
		        	      bt2.setLayoutX(100);
		  		          bt2.setLayoutY(200);
		        	      t1.getChildren().add(p1);
		        	      t1.getChildren().add(lab1);
		        	      t1.getChildren().add(bt2);
		        	      Scene sc=new Scene(t1,650,400);
		        	      primaryStage.setScene(sc);
		        	     primaryStage.setUserData(vbox);
		          	      primaryStage.setWidth(650);
		        	      primaryStage.setTitle("Fair Fares:Carpooling System");
		        	      primaryStage.show();
		        	      System.out.println("Well you have got passengers and you are ready to ride!!");
	        		}
		        	else if(ch.isSelected())
		        	{Label lab1=new Label();

	        	     lab1.setText("You have got passenger!!\n\n Name is "+Name+"\nAddress is "+Home);
	        		 
	        		 Button bt2=new Button("EXIT");
	        	      EventHandler<ActionEvent> event2=new EventHandler<ActionEvent>() {
	        	    	 public void handle(ActionEvent e) {
	        	    		 primaryStage.close();
	        	    		
	        	    	 }
	        	      };
	        	      bt2.setOnAction(event2);
	        	      bt2.setLayoutX(100);
	  		          bt2.setLayoutY(200);
	        	      t1.getChildren().add(p1);
	        	      t1.getChildren().add(lab1);
	        	      t1.getChildren().add(bt2);
	        	      Scene sc=new Scene(t1,650,400);
	        	      primaryStage.setScene(sc);
	        	     primaryStage.setUserData(vbox);
	          	      primaryStage.setWidth(650);
	        	      primaryStage.setTitle("Fair Fares:Carpooling System");
	        	      primaryStage.show();
	        	      System.out.println("Well you have got passengers and you are ready to ride!!");
		        		
		        	}
		        	else
		        	{  Label lab1=new Label();
		        		lab1.setText("You have got passenger!!\n\n Name is "+Name1+"\nAddress is "+Home1);
	        		   System.out.println("You have got passenger!!\n\n Name is "+Name1+"\nAddress is "+Home1);
	        		 Button bt2=new Button("EXIT");
	        	      EventHandler<ActionEvent> event2=new EventHandler<ActionEvent>() {
	        	    	 public void handle(ActionEvent e) {
	        	    		 primaryStage.close();
	        	    		
	        	    	 }
	        	      };
	        	      bt2.setOnAction(event2);
	        	      bt2.setLayoutX(100);
	  		          bt2.setLayoutY(200);
	        	      t1.getChildren().add(p1);
	        	      t1.getChildren().add(lab1);
	        	      t1.getChildren().add(bt2);
	        	      Scene sc=new Scene(t1,650,400);
	        	      primaryStage.setScene(sc);
	        	     primaryStage.setUserData(vbox);
	          	      primaryStage.setWidth(650);
	        	      primaryStage.setTitle("Fair Fares:Carpooling System");
	        	      primaryStage.show();
	        	      System.out.println("Well you have got passengers and you are ready to ride!!");
		        		
		        	}
		        	}
		        };
		        bt.setOnAction(event1);
		        bt.setLayoutX(100);
		        bt.setLayoutY(200);
		        t.getChildren().add(p);
		        t.getChildren().add(vbox);
		        t.getChildren().add(bt);
		    	Scene scene=new Scene(t,650,400); 
				primaryStage.setScene(scene); 
				primaryStage.setTitle("Fair Fares:Carpooling System");
				primaryStage.show();

			}
			
		}else 
		{
			System.out.println("\n Incorrect address details ");
	    }
		}
			
		catch(Exception e)
		{
			e.printStackTrace();
		}
	 
	}

public void match2(ActionEvent event)throws Exception {
		String Name,Name1,Name2;
		String Home,Home1,Home2;
		
		try {
			System.out.println("\nEnter your home address");
			System.out.println(homed.getText().toString());
			System.out.println("\nEnter your work address");
			System.out.println(workd.getText().toString());

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproj","root","");
			Statement stmt=c.createStatement();
			Statement stmt1=c.createStatement();
			String sql="Select Name from details where Work=' " +workd.getText()+" '";
			 String sql1="Select Home from details where Work=' " +workd.getText()+"'";
			ResultSet rs=stmt.executeQuery(sql);
		    ResultSet rs1=stmt1.executeQuery(sql1);
		    Stage primaryStage=new Stage();
		   
		     if(rs.next()&&rs1.next())
		     {
		    	 AnchorPane b=new AnchorPane();
				 AnchorPane a=new AnchorPane();
			     Pane r=new Pane();
			     Pane s=new Pane();
		         Name=rs.getString("Name");
	             Home=rs1.getString("Home");
	             ch=new CheckBox(Name+"\n"+Home);
	       
	       
		    if(rs.next()&&rs1.next())
			{    Name1=rs.getString("Name");
		        Home1=rs1.getString("Home");
		        ch1=new CheckBox(Name1+"\n"+Home1);
		       
		        if(rs.next()&&rs1.next())
		        {
		             
		          Name2=rs.getString("Name");
		          Home2=rs1.getString("Home");
		         ch2=new CheckBox(Name2+"\n"+Home2); 
		         s.setStyle("-fx-background-color:YELLOWGREEN;");
			        s.setPrefSize(200,400);
			        VBox vbox=new VBox(ch,ch1,ch2);
			        
			        Button bt=new Button("JOIN");
			   
			        EventHandler<ActionEvent> event1=new EventHandler<ActionEvent>(){
			        	
						public void handle(ActionEvent e) {
			        		if(ch.isSelected())
			        		{
			        		 Label lab1=new Label();
			        	     lab1.setText("You have got driver!!\n\nLETS START CARPOOLING!!\n Name is "+Name+"\nAddress is "+Home);
			        	     System.out.println("You have got driver!!\n\nLETS START CARPOOLING!!\n Name is "+Name+"\nAddress is "+Home);
			        	     r.setStyle("-fx-background-color:YELLOWGREEN;");
			 		         r.setPrefSize(200,400);
			        	      Button bt2=new Button("EXIT");
			        	      EventHandler<ActionEvent> event2=new EventHandler<ActionEvent>() {
			        	    	 public void handle(ActionEvent e) {
			        	    		 primaryStage.close();
			        	    	 }
			        	      };
			        	     
			        	      bt2.setOnAction(event2);
			        	      bt2.setLayoutX(80);
				  		      bt2.setLayoutY(125);
			        	      a.getChildren().add(r);
			        	      a.getChildren().add(lab1);
			        	      a.getChildren().add(bt2);
			        	      Scene sc=new Scene(a,650,400);
			        	      primaryStage.setScene(sc);
			        	      primaryStage.setUserData(vbox);
			        	      primaryStage.setWidth(650);
			        	      primaryStage.setHeight(400);
			        	      primaryStage.setTitle("Fair Fares:Carpooling System");
			        	      primaryStage.show();
			        	      System.out.println("Well Congrats, you have got a driver!!");
			        	
			        	     }
			        		else if(ch1.isSelected())
			        		{
			        		 Label lab1=new Label();
			        	     lab1.setText("You have got driver!!\n\nLETS START CARPOOLING!!\n\n Name is "+Name1+"\nAddress is "+Home1);
			        	     System.out.println("You have got driver!!\n\nLETS START CARPOOLING!!\n\n Name is "+Name1+"\nAddress is "+Home1);
			        	      r.setStyle("-fx-background-color:YELLOWGREEN;");
			 		          r.setPrefSize(200,400);
			        	      Button bt2=new Button("EXIT");
			        	      EventHandler<ActionEvent> event2=new EventHandler<ActionEvent>() {
			        	    	 public void handle(ActionEvent e) {
			        	    		 primaryStage.close();
			        	    	 }
			        	      };
			        	     
			        	      bt2.setOnAction(event2);
			        	      bt2.setLayoutX(80);
				  		      bt2.setLayoutY(125);
			        	      a.getChildren().add(r);
			        	      a.getChildren().add(lab1);
			        	      a.getChildren().add(bt2);
			        	      Scene sc=new Scene(a,650,400);
			        	      primaryStage.setScene(sc);
			        	      primaryStage.setUserData(vbox);
			        	      primaryStage.setWidth(650);
			        	      primaryStage.setHeight(400);
			        	      primaryStage.setTitle("Fair Fares:Carpooling System");
			        	      primaryStage.show();
			        	      System.out.println("Well Congrats, you have got a driver!!");
			        	
			        	     }
			        		else if(ch2.isSelected())
			        		{
			        		 Label lab1=new Label();
			        	     lab1.setText("You have got passengers!!\n\nLETS START CARPOOLING!!\n\n Name is "+Name2+"\nAddress is "+Home2);
			        	     System.out.println("You have got passengers!!\n\nLETS START CARPOOLING!!\n\n Name is "+Name2+"\nAddress is "+Home2);
			        	     r.setStyle("-fx-background-color:YELLOWGREEN;");
			 		         r.setPrefSize(200,400);
			        	      Button bt2=new Button("EXIT");
			        	      EventHandler<ActionEvent> event2=new EventHandler<ActionEvent>() {
			        	    	 public void handle(ActionEvent e) {
			        	    		 primaryStage.close();
			        	    		primaryStage.close();
			        	    		primaryStage.close();		 
			        	    	 }
			        	      };
			        	     
			        	      bt2.setOnAction(event2);
			        	      bt2.setLayoutX(80);
				  		      bt2.setLayoutY(125);
			        	      a.getChildren().add(r);
			        	      a.getChildren().add(lab1);
			        	      a.getChildren().add(bt2);
			        	      Scene sc=new Scene(a,650,400);
			        	      primaryStage.setScene(sc);
			        	      primaryStage.setTitle("Welcome to Fair Fares:Carpooling System!");
			        	      primaryStage.setUserData(vbox);
			        	      primaryStage.setWidth(650);
			        	      primaryStage.setHeight(400);
			        	      primaryStage.setTitle("Fair Fares:Carpooling System");
			        	      primaryStage.show();
			        	      System.out.println("Well Congrats, you have got a driver!!");
			        	
			        	}
			        	else
			        		{
			        		
								lab.setText("You didnt select anyone!!");
			        		}         
			       
		            }
			        };
			        bt.setOnAction(event1);
			        bt.setLayoutX(80);
			        bt.setLayoutY(125);
			        b.getChildren().add(s);
			        b.getChildren().add(vbox);
			        b.getChildren().add(bt);
			    	Scene scene=new Scene(b,650,400); 
					primaryStage.setScene(scene); 
					primaryStage.setTitle("Fair Fares:Carpooling System");
					primaryStage.show();
		        }	
		        
		        else
		        {
		        s.setStyle("-fx-background-color:YELLOWGREEN;");
		        s.setPrefSize(200,400);
		        VBox vbox=new VBox(ch,ch1);
		        
		        Button bt=new Button("JOIN");
		   
		        EventHandler<ActionEvent> event1=new EventHandler<ActionEvent>(){
		        	
					public void handle(ActionEvent e) {
		        		if(ch.isSelected())
		        		{
		        		 Label lab1=new Label();
		        	     lab1.setText("You have got driver!!\n\nLETS START CARPOOLING!!\n\n Name is "+Name+"\nAddress is "+Home);
		        	     System.out.println("You have got driver!!\n\nLETS START CARPOOLING!!\n\n Name is "+Name+"\nAddress is "+Home);
		        	     r.setStyle("-fx-background-color:YELLOWGREEN;");
		 		         r.setPrefSize(200,400);
		        	      Button bt2=new Button("EXIT");
		        	      EventHandler<ActionEvent> event2=new EventHandler<ActionEvent>() {
		        	    	 public void handle(ActionEvent e) {
		        	    		 primaryStage.close();
		        	    	 }
		        	      };
		        	     
		        	      bt2.setOnAction(event2);
		        	      bt2.setLayoutX(80);
			  		      bt2.setLayoutY(125);
		        	      a.getChildren().add(r);
		        	      a.getChildren().add(lab1);
		        	      a.getChildren().add(bt2);
		        	      Scene sc=new Scene(a,650,400);
		        	      primaryStage.setScene(sc);
		        	      primaryStage.setUserData(vbox);
		        	      primaryStage.setWidth(650);
		        	      primaryStage.setHeight(400);
		        	      primaryStage.setTitle("Fair Fares:Carpooling System");
		        	      primaryStage.show();
		        	      System.out.println("Well Congrats, you have got a driver!!");
		        	
		        	     }
	
		        		else
		        		{
		        		 Label lab1=new Label();
		        	     lab1.setText("You have got driver!!\n\nLETS START CARPOOLING!!\n\n Name is "+Name1+"\nAddress is "+Home1);
		        	     System.out.println("You have got driver!!\n\nLETS START CARPOOLING!!\n\n Name is "+Name1+"\nAddress is "+Home1);
		        	      r.setStyle("-fx-background-color:YELLOWGREEN;");
		 		          r.setPrefSize(200,400);
		        	      Button bt2=new Button("EXIT");
		        	      EventHandler<ActionEvent> event2=new EventHandler<ActionEvent>() {
		        	    	 public void handle(ActionEvent e) {
		        	    		 primaryStage.close();
		        	    	 }
		        	      };
		        	     
		        	      bt2.setOnAction(event2);
		        	      bt2.setLayoutX(80);
			  		      bt2.setLayoutY(125);
		        	      a.getChildren().add(r);
		        	      a.getChildren().add(lab1);
		        	      a.getChildren().add(bt2);
		        	      Scene sc=new Scene(a,650,400);
		        	      primaryStage.setScene(sc);
		        	      primaryStage.setUserData(vbox);
		        	      primaryStage.setWidth(650);
		        	      primaryStage.setHeight(400);
		        	      primaryStage.setTitle("Fair Fares:Carpooling System");
		        	      primaryStage.show();
		        	      System.out.println("Well Congrats, you have got a driver!!");
		        		}
		        		
		        	}
		        };
		        bt.setOnAction(event1);
		        bt.setLayoutX(80);
		        bt.setLayoutY(125);
		        b.getChildren().add(s);
		        b.getChildren().add(vbox);
		        b.getChildren().add(bt);
		    	Scene scene=new Scene(b,650,400); 
				primaryStage.setScene(scene); 
				primaryStage.setTitle("Fair Fares:Carpooling System");
				primaryStage.show();
		        }
			}
		    
		    else {
		    	s.setStyle("-fx-background-color:YELLOWGREEN;");
		        s.setPrefSize(200,400);
		        VBox vbox2=new VBox(ch);
		        
		        Button bt2=new Button("JOIN");
		   
		        EventHandler<ActionEvent> event1=new EventHandler<ActionEvent>(){
		        	
					public void handle(ActionEvent e) {
		        		if(ch.isSelected())
		        		{
		        		 Label lab1=new Label();
		        	     lab1.setText("You have got driver!!\n\nLETS START CARPOOLING!!\n\n Name is "+Name+"\nAddress is "+Home);
		        	     System.out.println("You have got driver!!\n\nLETS START CARPOOLING!!\n\n Name is "+Name+"\nAddress is "+Home);
		        	     r.setStyle("-fx-background-color:YELLOWGREEN;");
		 		         r.setPrefSize(200,400);
		        	      Button bt2=new Button("EXIT");
		        	      EventHandler<ActionEvent> event2=new EventHandler<ActionEvent>() {
		        	    	 public void handle(ActionEvent e) {
		        	    		 primaryStage.close();
		        	    	 }
		        	      };
		        	     
		        	      bt2.setOnAction(event2);
		        	      bt2.setLayoutX(80);
			  		      bt2.setLayoutY(125);
		        	      a.getChildren().add(r);
		        	      a.getChildren().add(lab1);
		        	      a.getChildren().add(bt2);
		        	      Scene sc=new Scene(a,650,400);
		        	      primaryStage.setScene(sc);
		        	      primaryStage.setUserData(vbox2);
		        	      primaryStage.setWidth(650);
		        	      primaryStage.setHeight(400);
		        	      primaryStage.setTitle("Fair Fares:Carpooling System");
		        	      primaryStage.show();
		        	      System.out.println("Well Congrats, you have got a driver!!");
		        	
		        	     }
                }
		        };
		        bt2.setOnAction(event1);
		        bt2.setLayoutX(80);
		        bt2.setLayoutY(125);
		        b.getChildren().add(s);
		        b.getChildren().add(vbox2);
		        b.getChildren().add(bt2);
		    	Scene scene=new Scene(b,650,400); 
				primaryStage.setScene(scene); 
				primaryStage.setTitle("Fair Fares:Carpooling System");
				primaryStage.show();
				
		     }
         
		     }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
 }
}		        
		 