package stock.portal;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
import java.sql.*;

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
        String name = studentName.getText();
        String email = studentEmail.getText();
        String roll = studentRoll.getText();
        String mobile = studentMobile.getText();
        String room = studentRoom.getText();
        String residence = (String) studentResidence.getValue();
        String school = (String) studentSchool.getValue();
        
        try {
            connect();
            
            String query =
                    "INSERT INTO Student ('Roll Number','Name','School','Residence','Room Number','Email id','Mobile Number') "
                    + "VALUES (?1,?2,?3,?4,?5,?6,?7)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString (1, roll);
            preparedStmt.setString (2, name);
            preparedStmt.setString (3, school);
            preparedStmt.setString (4, residence);
            preparedStmt.setString (5, room);
            preparedStmt.setString (6, email);
            preparedStmt.setString (7, mobile);
            
            preparedStmt.execute();
            //conn.commit();
            conn.close();
            System.out.println("Data inserted successfully");
        }
        
        catch (SQLException ex) {
            System.out.println("Error occured while updating student");
        }
    }
    Connection conn = null;
    public void connect()//S - connect to sqlite file
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