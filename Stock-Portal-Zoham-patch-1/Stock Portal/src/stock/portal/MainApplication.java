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
    }
    
    public static void main(String[] args) {
        launch(args);
        System.out.println("Main");
    }
}
