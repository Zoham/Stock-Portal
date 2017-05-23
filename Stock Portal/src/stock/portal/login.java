package stock.portal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class login implements Initializable{
    
    @FXML Button login;
    @FXML TextField username;
    @FXML PasswordField password;
    @FXML Label invalidLabel;
    
    @FXML 
    private void onLoginClick(ActionEvent event)throws Exception
    {     
        Node  source = (Node)  event.getSource(); 
        Stage stage  = (Stage) source.getScene().getWindow();
        if(username.getText().equals("Admin") && password.getText().equals("12345"))
        {
            System.out.println("Okay! Logging in");
            stage.close();
            
            Parent root;
            root = FXMLLoader.load(getClass().getResource("main.fxml"));
        
            Scene scene = new Scene(root);
        
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            invalidLabel.setText("Invalid Username/Password");
        }
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        invalidLabel.setText("");
    }
}
