package stock.portal;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MessageBox {
    public static void show(String msg,String Title)
    {
        Stage stage=new Stage();
        
        stage.setTitle(Title);
        stage.initModality(Modality.APPLICATION_MODAL);
        
        Label lbl2=new Label();
        lbl2.setText(msg);
        
        Button btn2=new Button();
        btn2.setText("OK");
        
        btn2.setOnAction(e->stage.close());
        
        VBox pane2=new VBox(10);
        pane2.setAlignment(Pos.CENTER);
        
        pane2.getChildren().addAll(lbl2,btn2);
        
        Scene scene2=new Scene(pane2,500,200);
        stage.setScene(scene2);
        stage.showAndWait();
    }   
}