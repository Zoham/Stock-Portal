package stock.portal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*; //S (for Sohamm's edit) - to import sqlpackage for java
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class MainApplication  extends Application {
    
    Stage stage;
    boolean loginScreen = true;
    
    Stage primaryStage;
    
    private void screen(boolean b)throws Exception
    {
        Parent root;
        if(b) root = FXMLLoader.load(getClass().getResource("loginFXML.fxml"));
        else root = FXMLLoader.load(getClass().getResource("main.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void start(Stage stg) throws Exception {
        stage=stg;
        screen(loginScreen);
        System.out.println("Here");
        
        primaryStage=stage;
        stage.setOnCloseRequest(e -> 
        {
            e.consume();
            Close_Click ();
        });
    }
    
    private void Close_Click()
    {
            boolean reallyQuit = false;
            reallyQuit = ConfirmationBox.show("Are you sure you want to quit?","Confirmation");
            if (reallyQuit)
            {
                primaryStage.close();
            }
    }
    
    public static void main(String[] args) {
        launch(args);
        System.out.println("Main");
    }
}
