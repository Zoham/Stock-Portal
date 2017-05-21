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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class root implements Initializable{
    
    @FXML TextField studentEmail;
    @FXML TextField studentRoom;
    @FXML TextField studentName;
    @FXML TextField studentMobile;
    @FXML TextField studentRoll;
    @FXML ComboBox studentResidence;
    @FXML ComboBox studentSchool;
    @FXML Button studentUpdate;
    
    @FXML TextField itemBrand;
    @FXML TextField itemName;
    @FXML TextField itemSport;
    @FXML TextField itemCondition;
    @FXML TextField itemVendor;
    @FXML TextField itemInvoice;
    @FXML TextField itemModel;
    @FXML TextField itemQuantity;
    @FXML TextField itemSecretary;
    @FXML TextField itemPrice;
    @FXML TextField itemDate;
    @FXML TextField itemTax;
    @FXML Button itemSubmit;
    
    @FXML TableView itemTable;
    @FXML TableView studentTable;

    
    @FXML 
    private void onStudentUpdateClick(ActionEvent event)throws Exception
    {     
        
    }
    
    @FXML 
    private void onEquipmentUpdateClick(ActionEvent event)throws Exception
    {     
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        studentResidence.getItems().addAll("MHR","SHR");
        studentSchool.getItems().addAll("SES","SBS","SMS","SIF","SMMMS");
        //itemTable.getColumns().addAll(/* edit and order these*/firstNameCol, lastNameCol, emailCol);
        //studentTable.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

    }
}