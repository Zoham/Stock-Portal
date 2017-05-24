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
            
            studentName.setText("");
            studentEmail.setText("");
            studentRoll.setText("");
            studentMobile.setText("");
            studentRoom.setText("");
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
        boolean submit;
        submit=ConfirmationBox.show("Are you sure that you want to submit?","Confirmation");
        if(submit){ 

        String iB=(String)itemBrand.getText();
        String iN=(String)itemName.getText();
        String iS=(String)itemSport.getText();
        String iC=(String)itemCondition.getText();
        String iV=(String)itemVendor.getText();
        String iI=(String)itemInvoice.getText();
        String iM=(String)itemModel.getText();
        String iQ=(String)itemQuantity.getText();
        String iSec=(String)itemSecretary.getText();
        String iP=(String)itemPrice.getText();
        String iD=(String)itemDate.getText();
        String iT=(String)itemTax.getText();
        //String iSub=(String)itemSubmit.getText();

        if(iB==null)MessageBox.show("All fields are to be filled.","Empty Field Error");
        else if(iN==null)MessageBox.show("All fields are to be filled.","Empty Field Error");
        else if(iS==null)MessageBox.show("All fields are to be filled.","Empty Field Error");
        else if(iC==null)MessageBox.show("All fields are to be filled.","Empty Field Error");
        else if(iV==null)MessageBox.show("All fields are to be filled.","Empty Field Error");
        else if(iI==null)MessageBox.show("All fields are to be filled.","Empty Field Error");
        else if(iM==null)MessageBox.show("All fields are to be filled.","Empty Field Error");
        else if(iQ==null)MessageBox.show("All fields are to be filled.","Empty Field Error");
        else if(iSec==null)MessageBox.show("All fields are to be filled.","Empty Field Error");
        else if(iP==null)MessageBox.show("All fields are to be filled.","Empty Field Error");
        else if(iD==null)MessageBox.show("All fields are to be filled.","Empty Field Error");
        else if(iT==null)MessageBox.show("All fields are to be filled.","Empty Field Error");
        else{try {

            connect();
            
            String query =
                    "INSERT INTO Stock ('Brand','Item','Sport','Condition','Vendor','InvoiceNo','Model','Quantity','Secretary','UnitPrice','PurchaseDate','Tax') "
                    + "VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString (1, iB);
            preparedStmt.setString (2, iN);
            preparedStmt.setString (3, iS);
            preparedStmt.setString (4, iC);
            preparedStmt.setString (5, iV);
            preparedStmt.setString (6, iI);
            preparedStmt.setString (7, iM);
            preparedStmt.setString (8, iQ);
            preparedStmt.setString (9, iSec);
            preparedStmt.setString (10, iP);
            preparedStmt.setString (11, iD);
            preparedStmt.setString (12, iT);
            //preparedStmt.setString (13, iSub);
            preparedStmt.execute();
            //conn.commit();
            conn.close();

            MessageBox.show("Data inserted successfully","Update");
            //System.out.println("Data inserted successfully");
            itemBrand.setText("");
            itemName.setText("");
            itemSport.setText("");
            itemCondition.setText("");
            itemVendor.setText("");
            itemInvoice.setText("");
            itemModel.setText("");
            itemQuantity.setText("");
            itemSecretary.setText("");
            itemPrice.setText("");
            itemDate.setText("");
            itemTax.setText("");
           // itemSubmit.setText("");
        }
        
        catch (SQLException ex) {

         MessageBox.show("Error occured while updating Stock","Error");
//System.out.println("Error occured while updating Stock");
        }
    }
    }}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        studentResidence.getItems().addAll("MHR","SHR");
        studentSchool.getItems().addAll("SES","SBS","SMS","SIF","SMMMS");
        //itemTable.getColumns().addAll(/* edit and order these*/firstNameCol, lastNameCol, emailCol);
        //studentTable.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

    }
}
