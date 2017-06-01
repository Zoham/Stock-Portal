package stock.portal;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class root extends Student implements Initializable {
    
    @FXML ComboBox issueSport;
    @FXML ComboBox issueBrand;
    @FXML ComboBox issueItem;
    @FXML ComboBox issueModel;
    @FXML TextField IssueRoll;
    @FXML TextField issueQuantity;
    @FXML DatePicker issueDate;
    @FXML Button issueUpdate;
    
    @FXML ComboBox returnSport;
    @FXML ComboBox returnBrand;
    @FXML ComboBox returnItem;
    @FXML ComboBox returnModel;
    @FXML TextField returnRoll;
    @FXML TextField returnQuantity;
    @FXML DatePicker returnDate;
    @FXML Button returnUpdate;
    
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
    @FXML ComboBox itemSport;
    @FXML ComboBox itemCondition;
    @FXML TextField itemVendor;
    @FXML TextField itemInvoice;
    @FXML TextField itemModel;
    @FXML TextField itemQuantity;
    @FXML ComboBox itemSecretary;
    @FXML TextField itemPrice;
    @FXML DatePicker itemDate;
    @FXML TextField itemTax;
    @FXML Button itemSubmit;
    
    
    @FXML ComboBox studentField;
    @FXML TextField studentSearchT;
    @FXML Button studentSearchB;
    @FXML Button studentRefresh;
    
    @FXML ComboBox itemField;
    @FXML TextField itemSearchT;
    @FXML Button itemSearchB;
    @FXML Button itemRefresh;
    
    @FXML TableView itemTable;
    @FXML TableView studentTable;  
    
    @FXML TableColumn sRoll;
    @FXML TableColumn sName;
    @FXML TableColumn sEmail;
    @FXML TableColumn sMobile;
    @FXML TableColumn sRoom;
    @FXML TableColumn sResidence;
     @FXML TableColumn sSchool;
    
    
    @FXML TableColumn iBrand;
    @FXML TableColumn iModel;
    @FXML TableColumn iItem;
    @FXML TableColumn iSport;
    @FXML TableColumn iSecretary;
    @FXML TableColumn iCondition;
    @FXML TableColumn iStatus;
    @FXML TableColumn iQuantity;
    @FXML TableColumn iVendor;
    @FXML TableColumn iInvoice;
    @FXML TableColumn iPurchaseDate;
    @FXML TableColumn iUnitPrice;
    @FXML TableColumn iTax;
    @FXML TableColumn iTotal;
    
    @FXML Button iEdit;
    @FXML Button sEdit;
    
    @FXML ComboBox titleFA;
    @FXML TextField newFA; 
    @FXML ComboBox titleFD;
    @FXML ComboBox listFD;
    
    @FXML TableColumn tRoll;
    @FXML TableColumn tUID;
    @FXML TableColumn tQuantity;
    @FXML TableColumn tIssueDate;
    @FXML TableColumn tReturnDate;
    
    @FXML Button tRefresh;
    @FXML Button tEdit;
    @FXML Button tSearchB;
    @FXML TextField tSearchT;
    @FXML ComboBox tField;
    
    Connection conn = null;
    
    @FXML 
    private void addField(ActionEvent e) throws Exception
    {
        String tfa = (String)titleFA.getValue();
        String nfa = newFA.getText();
            
        String error = "Fill All Fields";
        String errorBox = "Error";
        if((tfa==null) || nfa.equals("")) MessageBox.show(error,errorBox);
        else
        {
            
        }
    }
    
    @FXML 
    private void delField(ActionEvent e) throws Exception
    {
        String tfd = (String)titleFD.getValue();
        String ffd = (String)listFD.getValue();
            
        String error = "Fill All Fields";
        String errorBox = "Error";
        if((tfd==null) || ffd==null) MessageBox.show(error,errorBox);
        else
        {
            
        }
    }
    
    @FXML 
    private void showStudent(ActionEvent e) throws Exception
    {
        sRoll.setCellValueFactory(new PropertyValueFactory<>("Roll"));
        sName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        sEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        sMobile.setCellValueFactory(new PropertyValueFactory<>("Mobile"));
        sRoom.setCellValueFactory(new PropertyValueFactory<>("Room"));
        sResidence.setCellValueFactory(new PropertyValueFactory<>("Residence"));
        sSchool.setCellValueFactory(new PropertyValueFactory<>("School"));
    
        studentTable.setEditable(true);
        
        ObservableList<Student> data = sloadData();
        studentTable.setItems(data);
        
        sRoll.setCellFactory(TextFieldTableCell.forTableColumn());
        sRoll.setOnEditCommit( event -> colRoll_OnEditCommit(event) );
        sName.setCellFactory(TextFieldTableCell.forTableColumn());
        sName.setOnEditCommit( event -> colName_OnEditCommit(event) );
        sEmail.setCellFactory(TextFieldTableCell.forTableColumn());
        sEmail.setOnEditCommit( event -> colEmail_OnEditCommit(event) );
        sMobile.setCellFactory(TextFieldTableCell.forTableColumn());
        sMobile.setOnEditCommit( event -> colMobile_OnEditCommit(event) );
        sRoom.setCellFactory(TextFieldTableCell.forTableColumn());
        sRoom.setOnEditCommit( event -> colRoom_OnEditCommit(event) );
        sResidence.setCellFactory(TextFieldTableCell.forTableColumn());
        sResidence.setOnEditCommit( event -> colResidence_OnEditCommit(event) );
        sSchool.setCellFactory(TextFieldTableCell.forTableColumn());
        sSchool.setOnEditCommit( event -> colSchool_OnEditCommit(event) );
    }
    
    public ObservableList<Student> sloadData()
    {
        ObservableList<Student> data=FXCollections.observableArrayList();
        try
        {
            connect();
            
            String query="SELECT * FROM STUDENT";
            ResultSet rs=conn.createStatement().executeQuery(query);
                      
            while(rs.next())
            {
                    Student student=new Student();  
                    student.setRoll(rs.getString("Roll"));
                    student.setName(rs.getString("Name"));
                    student.setEmail(rs.getString("Email"));
                    student.setMobile(rs.getString("Mobile"));
                    student.setRoom(rs.getString("Room"));
                    student.setResidence(rs.getString("Residence"));
                    student.setSchool(rs.getString("School"));
                    data.add(student);
            }          
        }
        catch(SQLException e){
            MessageBox.show(e.getMessage(),"Error");
        }
        return data;
    }
    
    @FXML 
    private void showItem(ActionEvent e) throws Exception
    {
        iBrand.setCellValueFactory(new PropertyValueFactory<>("Brand"));
        iModel.setCellValueFactory(new PropertyValueFactory<>("Model"));
        iItem.setCellValueFactory(new PropertyValueFactory<>("Item"));
        iSport.setCellValueFactory(new PropertyValueFactory<>("Sport"));
        iSecretary.setCellValueFactory(new PropertyValueFactory<>("Secretary"));
        iCondition.setCellValueFactory(new PropertyValueFactory<>("Condition"));
        iStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
        iQuantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        iVendor.setCellValueFactory(new PropertyValueFactory<>("Vendor"));
        iInvoice.setCellValueFactory(new PropertyValueFactory<>("Invoice"));
        iPurchaseDate.setCellValueFactory(new PropertyValueFactory<>("Purchase"));
        iUnitPrice.setCellValueFactory(new PropertyValueFactory<>("Unit"));
        iTax.setCellValueFactory(new PropertyValueFactory<>("Tax"));
        iTotal.setCellValueFactory(new PropertyValueFactory<>("Total"));
    
        itemTable.setItems(iloadData());
        
        itemTable.setEditable(true);
        
        iBrand.setCellFactory(TextFieldTableCell.forTableColumn());
        iBrand.setOnEditCommit( event -> iBrand_OnEditCommit(event) );
        iModel.setCellFactory(TextFieldTableCell.forTableColumn());
        iModel.setOnEditCommit( event -> iModel_OnEditCommit(event) );
        iItem.setCellFactory(TextFieldTableCell.forTableColumn());
        iItem.setOnEditCommit( event -> iItem_OnEditCommit(event) );
        iSport.setCellFactory(TextFieldTableCell.forTableColumn());
        iSport.setOnEditCommit( event -> iSport_OnEditCommit(event) );
        iSecretary.setCellFactory(TextFieldTableCell.forTableColumn());
        iSecretary.setOnEditCommit( event -> iSecretary_OnEditCommit(event) );
        iCondition.setCellFactory(TextFieldTableCell.forTableColumn());
        iCondition.setOnEditCommit( event -> iCondition_OnEditCommit(event) );
        iStatus.setCellFactory(TextFieldTableCell.forTableColumn());
        iStatus.setOnEditCommit( event -> iStatus_OnEditCommit(event) );
        iQuantity.setCellFactory(TextFieldTableCell.forTableColumn());
        iQuantity.setOnEditCommit( event -> iQuantity_OnEditCommit(event) );
        iVendor.setCellFactory(TextFieldTableCell.forTableColumn());
        iVendor.setOnEditCommit( event -> iVendor_OnEditCommit(event) );
        iInvoice.setCellFactory(TextFieldTableCell.forTableColumn());
        iInvoice.setOnEditCommit( event -> iInvoice_OnEditCommit(event) );
        iPurchaseDate.setCellFactory(TextFieldTableCell.forTableColumn());
        iPurchaseDate.setOnEditCommit( event -> iPurchaseDate_OnEditCommit(event) );
        iUnitPrice.setCellFactory(TextFieldTableCell.forTableColumn());
        iUnitPrice.setOnEditCommit( event -> iUnitPrice_OnEditCommit(event) );
        iTax.setCellFactory(TextFieldTableCell.forTableColumn());
        iTax.setOnEditCommit( event -> iTax_OnEditCommit(event) );
        iTotal.setCellFactory(TextFieldTableCell.forTableColumn());
        iTotal.setOnEditCommit( event -> iTotal_OnEditCommit(event) );
    }
    
    public ObservableList<Stock> iloadData()
    {
        ObservableList<Stock> data=FXCollections.observableArrayList();
        
        try
        {
            connect();
            
            String query="SELECT * FROM STOCK";
            ResultSet rs=conn.createStatement().executeQuery(query);
            
            while(rs.next())
            {
                Stock stock=new Stock();
                    stock.setBrand(rs.getString("Brand"));
                    stock.setModel(rs.getString("Model"));
                    stock.setItem(rs.getString("Item"));
                    stock.setSport(rs.getString("Sport"));
                    stock.setSecretary(rs.getString("Secretary"));
                    stock.setCondition(rs.getString("Condition"));
                    stock.setStatus(rs.getString("Status"));
                    stock.setQuantity(rs.getString("Quantity"));
                    stock.setVendor(rs.getString("Vendor"));
                    stock.setInvoice(rs.getString("Invoice"));
                    stock.setPurchaseDate(rs.getString("Purchase"));
                    stock.setUnitPrice(rs.getString("Unit"));
                    stock.setTax(rs.getString("Tax"));
                    stock.setTotal(rs.getString("Total"));
                    
                    data.add(stock);
            }
        }
        catch(SQLException e){
            MessageBox.show(e.getMessage(),"Error");
        }
        return data;
    }
    
    @FXML 
    private void showTransaction(ActionEvent e) throws Exception
    {
        
    }
    
    @FXML 
    private void onIssue(ActionEvent event)throws Exception
    {
        
    }
    
    @FXML 
    private void onReturn(ActionEvent event)throws Exception
    {
        
    }
    
    @FXML 
    private void onSEdit(ActionEvent event)throws Exception
    {
        
    }
    
    @FXML 
    private void onIEdit(ActionEvent event)throws Exception
    {
        
    }
    
    @FXML 
    private void onTEdit(ActionEvent event)throws Exception
    {
        
    }
    
    @FXML 
    private void onTSearch(ActionEvent event)throws Exception
    {
        
    }
    
    @FXML 
    private void onSSearch(ActionEvent event)throws Exception
    {
        String type=(String)studentField.getValue();
        String search=(String)studentSearchT.getText();
        
        String error = "Fill All Fields";
        String errorBox = "Error";
        if(search.equals("") || type==null) MessageBox.show(error,errorBox);
        else
        {
            sRoll.setCellValueFactory(new PropertyValueFactory<>("Roll"));
            sName.setCellValueFactory(new PropertyValueFactory<>("Name"));
            sEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
            sMobile.setCellValueFactory(new PropertyValueFactory<>("Mobile"));
            sRoom.setCellValueFactory(new PropertyValueFactory<>("Room"));
            sResidence.setCellValueFactory(new PropertyValueFactory<>("Residence"));

            studentTable.setEditable(true);

            ObservableList<Student> data = sloadData2(type,search);
            studentTable.setItems(data);

            sRoll.setCellFactory(TextFieldTableCell.forTableColumn());
            sRoll.setOnEditCommit( ev -> colRoll_OnEditCommit(ev) );
            sName.setCellFactory(TextFieldTableCell.forTableColumn());
            sName.setOnEditCommit( ev -> colName_OnEditCommit(ev) );
            sEmail.setCellFactory(TextFieldTableCell.forTableColumn());
            sEmail.setOnEditCommit( ev -> colEmail_OnEditCommit(ev) );
            sMobile.setCellFactory(TextFieldTableCell.forTableColumn());
            sMobile.setOnEditCommit( ev -> colMobile_OnEditCommit(ev) );
            sRoom.setCellFactory(TextFieldTableCell.forTableColumn());
            sRoom.setOnEditCommit( ev -> colRoom_OnEditCommit(ev) );
            sResidence.setCellFactory(TextFieldTableCell.forTableColumn());
            sResidence.setOnEditCommit( ev -> colResidence_OnEditCommit(ev) );
        }
    }
    
    public ObservableList<Student> sloadData2( String type,String search)
    {
        ObservableList<Student> data=FXCollections.observableArrayList();
        ResultSet rs;
        PreparedStatement ps;
        String query="";
        try
        {
            connect();
            if(type.equals("Roll")) query="SELECT * FROM STUDENT WHERE Roll =?";
            else if(type.equals("Room")) query="SELECT * FROM STUDENT WHERE Room = ?";
            else if(type.equals("Name")) query="SELECT * FROM STUDENT WHERE Name = ?";
            else if(type.equals("Email")) query="SELECT * FROM STUDENT WHERE Email =?";
            else if(type.equals("Mobile")) query="SELECT * FROM STUDENT WHERE Mobile =?";
            else if(type.equals("Residence")) query="SELECT * FROM STUDENT WHERE Residence =?";
            else if(type.equals("School")) query="SELECT * FROM STUDENT WHERE School =?";
            
            ps=conn.prepareStatement(query);
            ps.setString(1,search);
            rs=ps.executeQuery();
            while(rs.next())
            {
                    Student student=new Student();  
                    student.setRoll(rs.getString("Roll"));
                    student.setName(rs.getString("Name"));
                    student.setEmail(rs.getString("Email"));
                    student.setMobile(rs.getString("Mobile"));
                    student.setRoom(rs.getString("Room"));
                    student.setResidence(rs.getString("Residence"));
                    student.setSchool(rs.getString("School"));
                    data.add(student);
            }          
        }
        catch(SQLException e){
            MessageBox.show(e.getMessage(),"Error");
        }
        return data;
    }
    
    @FXML 
    private void onISearch(ActionEvent event)throws Exception
    {
        String type=(String)itemField.getValue();
        String search=(String)itemSearchT.getText();
        
        String error = "Fill All Fields";
        String errorBox = "Error";
        if(type==null || search.equals("")) MessageBox.show(error,errorBox);
        else
        {
        
            iBrand.setCellValueFactory(new PropertyValueFactory<>("Brand"));
            iModel.setCellValueFactory(new PropertyValueFactory<>("Model"));
            iItem.setCellValueFactory(new PropertyValueFactory<>("Item"));
            iSport.setCellValueFactory(new PropertyValueFactory<>("Sport"));
            iSecretary.setCellValueFactory(new PropertyValueFactory<>("Secretary"));
            iCondition.setCellValueFactory(new PropertyValueFactory<>("Condition"));
            iStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
            iQuantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
            iVendor.setCellValueFactory(new PropertyValueFactory<>("Vendor"));
            iInvoice.setCellValueFactory(new PropertyValueFactory<>("Invoice"));
            iPurchaseDate.setCellValueFactory(new PropertyValueFactory<>("Purchase"));
            iUnitPrice.setCellValueFactory(new PropertyValueFactory<>("Unit"));
            iTax.setCellValueFactory(new PropertyValueFactory<>("Tax"));
            iTotal.setCellValueFactory(new PropertyValueFactory<>("Total"));

            itemTable.setItems(iloadData2(type,search));

            itemTable.setEditable(true);

            iBrand.setCellFactory(TextFieldTableCell.forTableColumn());
            iBrand.setOnEditCommit( ev -> iBrand_OnEditCommit(ev) );
            iModel.setCellFactory(TextFieldTableCell.forTableColumn());
            iModel.setOnEditCommit( ev -> iModel_OnEditCommit(ev) );
            iItem.setCellFactory(TextFieldTableCell.forTableColumn());
            iItem.setOnEditCommit( ev -> iItem_OnEditCommit(ev) );
            iSport.setCellFactory(TextFieldTableCell.forTableColumn());
            iSport.setOnEditCommit( ev -> iSport_OnEditCommit(ev) );
            iSecretary.setCellFactory(TextFieldTableCell.forTableColumn());
            iSecretary.setOnEditCommit( ev -> iSecretary_OnEditCommit(ev) );
            iCondition.setCellFactory(TextFieldTableCell.forTableColumn());
            iCondition.setOnEditCommit( ev -> iCondition_OnEditCommit(ev) );
            iStatus.setCellFactory(TextFieldTableCell.forTableColumn());
            iStatus.setOnEditCommit( ev -> iStatus_OnEditCommit(ev) );
            iQuantity.setCellFactory(TextFieldTableCell.forTableColumn());
            iQuantity.setOnEditCommit( ev -> iQuantity_OnEditCommit(ev) );
            iVendor.setCellFactory(TextFieldTableCell.forTableColumn());
            iVendor.setOnEditCommit( ev -> iVendor_OnEditCommit(ev) );
            iInvoice.setCellFactory(TextFieldTableCell.forTableColumn());
            iInvoice.setOnEditCommit( ev -> iInvoice_OnEditCommit(ev) );
            iPurchaseDate.setCellFactory(TextFieldTableCell.forTableColumn());
            iPurchaseDate.setOnEditCommit( ev -> iPurchaseDate_OnEditCommit(ev) );
            iUnitPrice.setCellFactory(TextFieldTableCell.forTableColumn());
            iUnitPrice.setOnEditCommit( ev -> iUnitPrice_OnEditCommit(ev) );
            iTax.setCellFactory(TextFieldTableCell.forTableColumn());
            iTax.setOnEditCommit( ev -> iTax_OnEditCommit(ev) );
            iTotal.setCellFactory(TextFieldTableCell.forTableColumn());
            iTotal.setOnEditCommit( ev -> iTotal_OnEditCommit(ev) );
        }
    }
    
    public ObservableList<Stock> iloadData2(String type,String search){
        ObservableList<Stock> data=FXCollections.observableArrayList();
        
        try
        {
            connect();
            
            ResultSet rs;
            PreparedStatement ps;
            String query="";
            
            if(type.equals("Brand")) query="SELECT * FROM STOCK WHERE Brand=?";
            else if(type.equals("Model")) query="SELECT * FROM STOCK WHERE Model=?";
            else if(type.equals("Item")) query="SELECT * FROM STOCK WHERE Item=?";
            else if(type.equals("Sport")) query="SELECT * FROM STOCK WHERE Sport=?";
            else if(type.equals("Secretary")) query="SELECT * FROM STOCK WHERE Secretary=?";
            else if(type.equals("Condition")) query="SELECT * FROM STOCK WHERE Condition=?";
            else if(type.equals("Status")) query="SELECT * FROM STOCK WHERE Status=?";
            else if(type.equals("Quantity")) query="SELECT * FROM STOCK WHERE Quantity=?";
            else if(type.equals("Vendor")) query="SELECT * FROM STOCK WHERE Vendor=?";
            else if(type.equals("Invoice")) query="SELECT * FROM STOCK WHERE Invoice=?";
            else if(type.equals("Purchase Date")) query="SELECT * FROM STOCK WHERE Purchase=?";
            else if(type.equals("Unit Price")) query="SELECT * FROM STOCK WHERE Unit=?";
            else if(type.equals("Tax")) query="SELECT * FROM STOCK WHERE Tax=?";
            else if(type.equals("Total")) query="SELECT * FROM STOCK WHERE Total=?";
            else if(type.equals("UID")) query="SELECT * FROM STOCK WHERE UID=?";
            
            ps=conn.prepareStatement(query);
            ps.setString(1,search);
            rs=ps.executeQuery();
            while(rs.next())
            {
                Stock stock=new Stock();
                    stock.setBrand(rs.getString("Brand"));
                    stock.setModel(rs.getString("Model"));
                    stock.setItem(rs.getString("Item"));
                    stock.setSport(rs.getString("Sport"));
                    stock.setSecretary(rs.getString("Secretary"));
                    stock.setCondition(rs.getString("Condition"));
                    stock.setStatus(rs.getString("Status"));
                    stock.setQuantity(rs.getString("Quantity"));
                    stock.setVendor(rs.getString("Vendor"));
                    stock.setInvoice(rs.getString("Invoice"));
                    stock.setPurchaseDate(rs.getString("Purchase"));
                    stock.setUnitPrice(rs.getString("Unit"));
                    stock.setTax(rs.getString("Tax"));
                    stock.setTotal(rs.getString("Total"));
                    
                    data.add(stock);
            }
        }
        catch(SQLException e){
            MessageBox.show(e.getMessage(),"Error");
        }
        return data;
    
    }  
    
    @FXML 
    private void onStudentUpdateClick(ActionEvent event)throws Exception
    {   
        boolean update;
        update=ConfirmationBox.show("Are you sure you want to update?","Confirmation");
        
        if(update)
        {
            String sname = studentName.getText();
            String semail = studentEmail.getText();
            String sroll = studentRoll.getText();
            String smobile = studentMobile.getText();
            String sroom = studentRoom.getText();
            String sresidence = (String) studentResidence.getValue();
            String sschool = (String) studentSchool.getValue();
            
            String error = "Fill All Fields";
            String errorBox = "Error";
            if(sname.equals("") || semail.equals("") || sroll.equals("") || smobile.equals("") || sroom.equals("")) MessageBox.show(error,errorBox);
            else if(sresidence==null || sschool==null) MessageBox.show(error,errorBox);
            else
            {
                try 
                {
                    connect();

                    String query =
                            "INSERT INTO Student ('Roll','Name','School','Residence','Room','Email','Mobile') "
                            + "VALUES (?1,?2,?3,?4,?5,?6,?7)";
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString (1, sroll);
                    preparedStmt.setString (2, sname);
                    preparedStmt.setString (3, sschool);
                    preparedStmt.setString (4, sresidence);
                    preparedStmt.setString (5, sroom);
                    preparedStmt.setString (6, semail);
                    preparedStmt.setString (7, smobile);
                    preparedStmt.execute();
                    conn.close();
                    
                    MessageBox.show("Update Sucessful","Update");
                    studentName.setText("");
                    studentEmail.setText("");
                    studentRoll.setText("");
                    studentMobile.setText("");
                    studentRoom.setText("");
                    studentResidence.setValue("Residence");
                    studentSchool.setValue("School");
                }
                catch (SQLException e) {
                    System.out.print(e.getMessage());
                    MessageBox.show("Error occured while updating student","Error");
                }
            }
        }
    }    
    
    @FXML 
    private void onEquipmentUpdateClick(ActionEvent event)throws Exception
    {
        boolean submit;
        submit=ConfirmationBox.show("Are you sure that you want to submit?","Confirmation");
        
        if(submit)
        { 
            String iB=itemBrand.getText();
            String iN=itemName.getText();
            String iS=(String)itemSport.getValue();
            String iC=(String)itemCondition.getValue();
            String iV=itemVendor.getText();
            String iI=itemInvoice.getText();
            String iM=itemModel.getText();
            String iQ=itemQuantity.getText();
            String iSec=(String)itemSecretary.getValue();
            String iP=itemPrice.getText();
            LocalDate iD=itemDate.getValue();
            String iT=itemTax.getText();
        
            String error = "Fill All Fields";
            String errorBox = "Error";
            if(iB.equals("") || iN.equals("") || iS.equals("") || iC.equals("") || iV.equals("") || iI.equals(""))MessageBox.show(error,errorBox);
            else if(iM.equals("") || iQ.equals("") || iSec.equals("") || iP.equals("") || iD.equals("") || iT.equals(""))MessageBox.show(error,errorBox);
            else
            {
                try 
                {
                    connect();

                    String query =
                            "INSERT INTO Stock ('Brand','Item','Sport','Condition','Vendor','Invoice','Model','Quantity','Secretary','Unit','Purchase','Tax') "
                            + "VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?iD,?12)";

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
                    //preparedStmt.setDate (11, iD);
                    preparedStmt.setString (12, iT);
                    preparedStmt.execute();
                    conn.close();

                    MessageBox.show("Update Sucessful","Update");
                    itemBrand.setText("");
                    itemName.setText("");
                    itemVendor.setText("");
                    itemInvoice.setText("");
                    itemModel.setText("");
                    itemQuantity.setText("");
                    itemPrice.setText("");
                    itemTax.setText("");
                }
                catch (SQLException e) {
                    System.out.println(e.getMessage());
                 MessageBox.show("Error occured while updating stock","Error");
                }
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        studentResidence.getItems().addAll("MHR","SHR");
        studentSchool.getItems().addAll("SES","SBS","SMS","SIF","SMMMS");
        
        itemSport.getItems().addAll("Athletics","Badminton","Basketball","Carrom","Chess","Cricket","Football","Lawn Tennis","Swimming","Table Tennis","Volleyball");
        itemSecretary.getItems().addAll("Athletics","Cricket","Football","Indoor Games","Small Area Sports");
        itemCondition.getItems().addAll("New","Not Usable");
        
        titleFA.getItems().addAll("Sport","Secretary","Condition","Residence","School");
        titleFD.getItems().addAll("Sport","Secretary","Condition","Residence","School");
        
        studentField.getItems().addAll("Roll","Name","Email","Mobile","Room","Residence","School");
        itemField.getItems().addAll("Brand","Model","Item","Sport","Secretary","Condition","Status","Quantity","Vendor","Invoice","Purchase","Unit","Tax","Total");
    }
    
    public void connect()
    {
        try{
            conn=DriverManager.getConnection("jdbc:sqlite:stock portal.sqlite"); 
        }
        catch(SQLException e){
            MessageBox.show(e.getMessage(),"Connection error");
        }
    }
    
    @FXML 
    private void iSport(ActionEvent event)throws Exception
    {
        
    }
    
    @FXML 
    private void iItem(ActionEvent event)throws Exception
    {
        
    }
    
    @FXML 
    private void iBrand(ActionEvent event)throws Exception
    {
        
    }
    
    @FXML 
    private void iModel(ActionEvent event)throws Exception
    {
        
    }
    
    @FXML 
    private void rSport(ActionEvent event)throws Exception
    {
        
    }
    
    @FXML 
    private void rItem(ActionEvent event)throws Exception
    {
        
    }
    
    @FXML 
    private void rBrand(ActionEvent event)throws Exception
    {
        
    }
    
    @FXML 
    private void rModel(ActionEvent event)throws Exception
    {
        
    }
    
    
    public void colRoll_OnEditCommit(Event e){
        TableColumn.CellEditEvent<Student,String> ce;
        ce=(TableColumn.CellEditEvent<Student,String>) e;
        Student s=ce.getRowValue();
        s.setRoll(ce.getNewValue());
    }

    public void colName_OnEditCommit(Event e){
        TableColumn.CellEditEvent<Student,String> ce;
        ce=(TableColumn.CellEditEvent<Student,String>) e;
        Student s=ce.getRowValue();
        s.setName(ce.getNewValue());
    }

    public void colEmail_OnEditCommit(Event e){
        TableColumn.CellEditEvent<Student,String> ce;
        ce=(TableColumn.CellEditEvent<Student,String>) e;
        Student s=ce.getRowValue();
        s.setEmail(ce.getNewValue());
    }

    public void colMobile_OnEditCommit(Event e){
        TableColumn.CellEditEvent<Student,String> ce;
        ce=(TableColumn.CellEditEvent<Student,String>) e;
        Student s=ce.getRowValue();
        s.setMobile(ce.getNewValue());
    }

    public void colRoom_OnEditCommit(Event e){
        TableColumn.CellEditEvent<Student,String> ce;
        ce=(TableColumn.CellEditEvent<Student,String>) e;
        Student s=ce.getRowValue();
        s.setRoom(ce.getNewValue());
    }

    public void colResidence_OnEditCommit(Event e){
        TableColumn.CellEditEvent<Student,String> ce;
        ce=(TableColumn.CellEditEvent<Student,String>) e;
        Student s=ce.getRowValue();
        s.setResidence(ce.getNewValue());
    }
    
    public void colSchool_OnEditCommit(Event e){
        TableColumn.CellEditEvent<Student,String> ce;
        ce=(TableColumn.CellEditEvent<Student,String>) e;
        Student s=ce.getRowValue();
        s.setSchool(ce.getNewValue());
    }
    
    
    public void iBrand_OnEditCommit(Event e){
        TableColumn.CellEditEvent<Stock,String> ce;
        ce=(TableColumn.CellEditEvent<Stock,String>) e;
        Stock s=ce.getRowValue();
        s.setBrand(ce.getNewValue());
    }
    
    public void iModel_OnEditCommit(Event e){
        TableColumn.CellEditEvent<Stock,String> ce;
        ce=(TableColumn.CellEditEvent<Stock,String>) e;
        Stock s=ce.getRowValue();
        s.setModel(ce.getNewValue());
    }
    
    public void iItem_OnEditCommit(Event e){
        TableColumn.CellEditEvent<Stock,String> ce;
        ce=(TableColumn.CellEditEvent<Stock,String>) e;
        Stock s=ce.getRowValue();
        s.setItem(ce.getNewValue());
    }
    
    public void iSport_OnEditCommit(Event e){
        TableColumn.CellEditEvent<Stock,String> ce;
        ce=(TableColumn.CellEditEvent<Stock,String>) e;
        Stock s=ce.getRowValue();
        s.setSport(ce.getNewValue());
    }
    
    public void iSecretary_OnEditCommit(Event e){
        TableColumn.CellEditEvent<Stock,String> ce;
        ce=(TableColumn.CellEditEvent<Stock,String>) e;
        Stock s=ce.getRowValue();
        s.setSecretary(ce.getNewValue());
    }
    
    public void iCondition_OnEditCommit(Event e){
        TableColumn.CellEditEvent<Stock,String> ce;
        ce=(TableColumn.CellEditEvent<Stock,String>) e;
        Stock s=ce.getRowValue();
        s.setCondition(ce.getNewValue());
    }
    
    public void iStatus_OnEditCommit(Event e){
        TableColumn.CellEditEvent<Stock,String> ce;
        ce=(TableColumn.CellEditEvent<Stock,String>) e;
        Stock s=ce.getRowValue();
        s.setStatus(ce.getNewValue());
    }
    
    public void iQuantity_OnEditCommit(Event e){
        TableColumn.CellEditEvent<Stock,String> ce;
        ce=(TableColumn.CellEditEvent<Stock,String>) e;
        Stock s=ce.getRowValue();
        s.setQuantity(ce.getNewValue());
    }
    
    public void iVendor_OnEditCommit(Event e){
        TableColumn.CellEditEvent<Stock,String> ce;
        ce=(TableColumn.CellEditEvent<Stock,String>) e;
        Stock s=ce.getRowValue();
        s.setVendor(ce.getNewValue());
    }
    
    public void iInvoice_OnEditCommit(Event e){
        TableColumn.CellEditEvent<Stock,String> ce;
        ce=(TableColumn.CellEditEvent<Stock,String>) e;
        Stock s=ce.getRowValue();
        s.setInvoice(ce.getNewValue());
    }
    
    public void iPurchaseDate_OnEditCommit(Event e){
        TableColumn.CellEditEvent<Stock,String> ce;
        ce=(TableColumn.CellEditEvent<Stock,String>) e;
        Stock s=ce.getRowValue();
        s.setPurchaseDate(ce.getNewValue());
    }
    
    public void iUnitPrice_OnEditCommit(Event e){
        TableColumn.CellEditEvent<Stock,String> ce;
        ce=(TableColumn.CellEditEvent<Stock,String>) e;
        Stock s=ce.getRowValue();
        s.setUnitPrice(ce.getNewValue());
    }
    
    public void iTax_OnEditCommit(Event e){
        TableColumn.CellEditEvent<Stock,String> ce;
        ce=(TableColumn.CellEditEvent<Stock,String>) e;
        Stock s=ce.getRowValue();
        s.setTax(ce.getNewValue());
    }
    
    public void iTotal_OnEditCommit(Event e){
        TableColumn.CellEditEvent<Stock,String> ce;
        ce=(TableColumn.CellEditEvent<Stock,String>) e;
        Stock s=ce.getRowValue();
        s.setTotal(ce.getNewValue());
    }
}
