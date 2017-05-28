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
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class root extends Student implements Initializable {
    String sport="",brand="",model="",item="";
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
    @FXML TableColumn sIssuedItem;
    @FXML TableColumn sQuantity;
    @FXML TableColumn sIssueDate;
    @FXML TableColumn sReturnDate;
    
    @FXML TableColumn iBrand;
    @FXML TableColumn iModel;
    @FXML TableColumn iItem;
    @FXML TableColumn iSport;
    @FXML TableColumn iSecretary;
    @FXML TableColumn iCondition;
    @FXML TableColumn iStatus;
    @FXML TableColumn iQuantity;
    @FXML TableColumn iIssuedTo;
    @FXML TableColumn iIssuedQuantity;
    @FXML TableColumn iIssueDate;
    @FXML TableColumn iReturnDate;
    @FXML TableColumn iVendor;
    @FXML TableColumn iInvoice;
    @FXML TableColumn iPurchaseDate;
    @FXML TableColumn iUnitPrice;
    @FXML TableColumn iTax;
    @FXML TableColumn iTotal;
    @FXML TableColumn UID;
    
    
    Connection conn = null;
    
    @FXML 
    private void showStudent(ActionEvent e) throws Exception
    {
        sRoll.setCellValueFactory(new PropertyValueFactory<>("Roll"));
        sName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        sEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        sMobile.setCellValueFactory(new PropertyValueFactory<>("Mobile"));
        sRoom.setCellValueFactory(new PropertyValueFactory<>("Room"));
        sResidence.setCellValueFactory(new PropertyValueFactory<>("Residence"));
        sIssuedItem.setCellValueFactory(new PropertyValueFactory<>("Issued Item"));
        sQuantity.setCellValueFactory(new PropertyValueFactory<>("Quality"));
        sIssueDate.setCellValueFactory(new PropertyValueFactory<>("Issue Date"));
        sReturnDate.setCellValueFactory(new PropertyValueFactory<>("Return Date"));
    
        
        ObservableList<Student> data = sloadData();
        //studentTable.setItems(data);
        System.out.println(data.get(1).roll);
        System.out.println(data.get(2).roll);
        
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
                    student.setRoll(rs.getString("Roll Number"));
                    student.setName(rs.getString("Name"));
                    student.setEmail(rs.getString("Email Id"));
                    student.setMobile(rs.getString("Mobile Number"));
                    student.setRoom(rs.getString("Room Number"));
                    student.setResidence(rs.getString("Residence"));
                    student.setItemissued(rs.getString("Issued"));
                    student.setQuality(rs.getString("Quantity"));
                    student.setIssuedate(rs.getString("IssueDate"));
                    student.setReturndate(rs.getString("ReturnDate"));
                    data.add(student);
                    System.out.println(data.get(0).roll);
            }
            
            studentTable.setItems(data);
        }
        catch(SQLException e){
            MessageBox.show(e.getMessage(),"Error2");
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
        iIssuedTo.setCellValueFactory(new PropertyValueFactory<>("Issued To"));
        iIssuedQuantity.setCellValueFactory(new PropertyValueFactory<>("Issued Quantity"));
        iIssueDate.setCellValueFactory(new PropertyValueFactory<>("Issue Date"));
        iReturnDate.setCellValueFactory(new PropertyValueFactory<>("Return Date"));
        iVendor.setCellValueFactory(new PropertyValueFactory<>("Vendor"));
        iInvoice.setCellValueFactory(new PropertyValueFactory<>("Invoice Number"));
        iPurchaseDate.setCellValueFactory(new PropertyValueFactory<>("PurchaseDate"));
        iUnitPrice.setCellValueFactory(new PropertyValueFactory<>("UnitPrice"));
        iTax.setCellValueFactory(new PropertyValueFactory<>("Tax"));
        iTotal.setCellValueFactory(new PropertyValueFactory<>("Total"));
        UID.setCellValueFactory(new PropertyValueFactory<>("UID"));
    
        itemTable.setItems(iloadData());
    }
    
    public ObservableList<Stock> iloadData(){
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
                    stock.setIssuedTo(rs.getString("IssuedTo"));
                    stock.setIssuedQuantity(rs.getString("IssuedQuantity"));
                    stock.setIssueDate(rs.getString("IssueDate"));
                    stock.setReturnDate(rs.getString("ReturnDate"));
                    stock.setVendor(rs.getString("Vendor"));
                    stock.setInvoice(rs.getString("InvoiceNo"));
                    stock.setPurchaseDate(rs.getString("PurchaseDate"));
                    stock.setUnitPrice(rs.getString("UnitPrice"));
                    stock.setTax(rs.getString("Tax"));
                    stock.setTotal(rs.getString("Total"));
                    stock.setUID(rs.getString("UID"));
                    
                    data.add(stock);
            }
        }
        catch(SQLException e){
            MessageBox.show(e.getMessage(),"Error");
        }
        return data;
    }
    
    @FXML 
    private void onIssue(ActionEvent event)throws Exception
    {
        
    }
    
    @FXML 
    private void onReturn(ActionEvent event)throws Exception
    {
        boolean submit;
        submit=ConfirmationBox.show("Are you sure that you want to submit?","Confirmation");
        if(sport.equals("")||item.equals("")||model.equals("")||brand.equals(""))
           System.out.println("Error");
        else
        {
            try
            {
                connect();
                String student=(String)returnRoll.getText();
                String quantity=(String)returnQuantity.getText();
                String sql="SELECT * FROM Stock WHERE Sport=? AND Item=? AND Model=? AND Brand=? AND IssuedTo=?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,sport);
                pstmt.setString(2,item);
                pstmt.setString(1,model);
                pstmt.setString(1,brand);
                pstmt.setString(1,student);
                ResultSet rs=pstmt.executeQuery();
                String str=rs.getString("Issuedate");
                
//if(str.substring(0,2)-)
                //TODO: SomeCheckings with returnDate, possible fines
                //TODO: Change Staus to Returned if all conditions are met?
                
            }
            catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
        }
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
            String sissuedUID = "";
            String squantity = "";
            String sissuedate = "";
            String sreturndate = "";
            
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
                            "INSERT INTO Student ('Roll Number','Name','School','Residence','Room Number','Email id','Mobile Number','Issued Item','Quantity','Issue Date','Return Date') "
                            + "VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11)";
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString (1, sroll);
                    preparedStmt.setString (2, sname);
                    preparedStmt.setString (3, sschool);
                    preparedStmt.setString (4, sresidence);
                    preparedStmt.setString (5, sroom);
                    preparedStmt.setString (6, semail);
                    preparedStmt.setString (7, smobile);
                    preparedStmt.setString (8, sissuedUID);
                    preparedStmt.setString (9, squantity);
                    preparedStmt.setString (10, sissuedate);
                    preparedStmt.setString (11, sreturndate);
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
            String iS=itemSport.getText();
            String iC=itemCondition.getText();
            String iV=itemVendor.getText();
            String iI=itemInvoice.getText();
            String iM=itemModel.getText();
            String iQ=itemQuantity.getText();
            String iSec=itemSecretary.getText();
            String iP=itemPrice.getText();
            String iD=itemDate.getText();
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
                    preparedStmt.execute();
                    conn.close();

                    MessageBox.show("Update Sucessful","Update");
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
                }
                catch (SQLException e) {
                 MessageBox.show("Error occured while updating stock","Error");
                }
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        studentResidence.getItems().addAll("MHR","SHR");
        studentSchool.getItems().addAll("SES","SBS","SMS","SIF","SMMMS");
        returnSport.getItems().addAll("Cricket","Badminton","Volleyball","Tennis","Football","Basketball","3");
        returnSport.setEditable(true);
        returnBrand.setEditable(true);
        returnModel.setEditable(true);
        returnItem.setEditable(true);
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
        sport=returnSport.getEditor().getText();
        try
        {
            connect();
            String sql="SELECT Brand FROM Stock WHERE Sport=?";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,sport);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next())
                returnBrand.getItems().addAll(rs.getString("Brand")+"");
                //System.out.println(rs.getString("Brand"));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    @FXML 
    private void rItem(ActionEvent event)throws Exception
    {
        item=returnItem.getEditor().getText();
    }
    
    @FXML 
    private void rBrand(ActionEvent event)throws Exception
    {
        String brand=returnBrand.getEditor().getText();
        
        try
        {
            connect();
            String sql="SELECT Model FROM Stock WHERE Sport=? AND Brand=?";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,sport);
            pstmt.setString(2,brand);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next())
                returnModel.getItems().addAll(rs.getString("Model")+"");
            returnModel.getItems().addAll("Okay");
                //System.out.println(rs.getString("Brand"));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    @FXML 
    private void rModel(ActionEvent event)throws Exception
    {
        String model=returnModel.getEditor().getText();
        
        try
        {
            connect();
            String sql="SELECT Item FROM Stock WHERE Sport=? AND Brand=? AND Model=?";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,sport);
            pstmt.setString(2,brand);
            pstmt.setString(3,model);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next())
                returnItem.getItems().addAll(rs.getString("Item")+"");
                //System.out.println(rs.getString("Brand"));
                returnItem.getItems().addAll("Okay");
                
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
