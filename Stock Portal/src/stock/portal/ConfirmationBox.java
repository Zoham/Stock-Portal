package stock.portal;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmationBox{
    static Stage stage;
    static boolean value=false;
    
    public static boolean show(String msg,String title)
    {
        value = false;
        
        stage=new Stage();
        stage.setTitle(title);
        
        stage.initModality(Modality.APPLICATION_MODAL);
        
        Label lbl2=new Label();
        lbl2.setText(msg);
        
        Button btn2=new Button();
        btn2.setText("Yes");
        btn2.setOnAction(e->YesClick());
        
        Button btn3=new Button();
        btn3.setText("No");
        btn3.setOnAction(e->NoClick());
        
        HBox pane=new HBox(10);
        
        pane.getChildren().addAll(btn2,btn3);
        pane.setAlignment(Pos.CENTER);
        
        VBox pane2=new VBox(10);
        pane2.setAlignment(Pos.CENTER);
        
        pane2.getChildren().addAll(lbl2,pane);
        
        Scene scene2=new Scene(pane2,500,200);
        
        stage.setScene(scene2);
        stage.showAndWait();
        
        return(value);
    }
    
    public static void YesClick()
    {
        value=true;
        stage.close();
    }
    
    public static void NoClick()
    {
        value=false;
        stage.close();
    }        
}