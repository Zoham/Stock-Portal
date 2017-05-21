/*package stock.portal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*; //S (for Sohamm's edit) - to import sqlpackage for java
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class StockPortal extends Application {
    
    Connection conn = null; //S - global variable for connection functions
    Statement stmt = null;
        
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("loginFXML.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        
    }
    
    private void handleButtonAction(ActionEvent e) {
        System.out.println("clicked1");
    }

    public static void main(String[] args) {
        StockPortal obj = new StockPortal();//S- Class object
        //obj.connect(); //S - try connecting
        //obj.insert_stock();
        launch(args);
    }
    
    /*public void connect()//S - connect to sqlite file
    {
        try
        {
            conn=DriverManager.getConnection("jdbc:sqlite:stock portal.sqlite"); //S - to establish connection
            System.out.println("Database opened successfully");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage()); //S - to display error message in std-out
        }
    }
    
    public void insert_stock()//S - insert stuff in stock table
    {
        try
        {
            connect();
            stmt = conn.createStatement();
            String query = "INSERT INTO STOCK (BRAND, ITEM, QUANTITY, SPORT, SECRETARY, CONDITION, STATUS) "+
                    "VALUES ('Head', 'Racquet', 1, 'Tennis', 'Small Area Sports', 'New', 'Not Issued');";
            stmt.executeUpdate(query);
            stmt.close();
            conn.commit();
            conn.close();
            System.out.println("Data inserted successfully");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());          
        }
    }
    
    public void insert_student()//S - insert stuff into students table
    {
        try
        {
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());          
        }
    }
}*/
