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
import java.time.LocalDate;
import java.util.Calendar;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
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

    @FXML Tab studentRegister;
    @FXML Tab studentDisplay;

    @FXML Tab itemUpate;
    @FXML Tab itemDisplay;
    
    Connection conn = null;
    
    TableColumn<Student, String> colRoll =new TableColumn<Student, String>();
    TableColumn<Student, String> colName =new TableColumn<Student, String>();
    TableColumn<Student, String> colEmail =new TableColumn<Student, String>();
    TableColumn<Student, String> colMobile =new TableColumn<Student, String>();
    TableColumn<Student, String> colRoom =new TableColumn<Student, String>();
    TableColumn<Student, String> colResidence =new TableColumn<Student, String>();
    TableColumn<Student, String> colItemissued =new TableColumn<Student, String>();
    TableColumn<Student, String> colQuality =new TableColumn<Student, String>();
    TableColumn<Student, String> colIssuedate =new TableColumn<Student, String>();
    TableColumn<Student, String> colReturndate =new TableColumn<Student, String>();
    
//    @FXML 
//    private void showStudent(ActionEvent e) throws Exception
//    {
//        colRoll.setCellValueFactory(new PropertyValueFactory<Student,String>("Roll"));
//        colName.setCellValueFactory(new PropertyValueFactory<Student,String>("Name"));
//        colEmail.setCellValueFactory(new PropertyValueFactory<Student,String>("Email"));
//        colMobile.setCellValueFactory(new PropertyValueFactory<Student,String>("Mobile"));
//        colRoom.setCellValueFactory(new PropertyValueFactory<Student,String>("Room"));
//        colResidence.setCellValueFactory(new PropertyValueFactory<Student,String>("Residence"));
//        colItemissued.setCellValueFactory(new PropertyValueFactory<Student,String>("Itemissued"));
//        colQuality.setCellValueFactory(new PropertyValueFactory<Student,String>("Quality"));
//        colIssuedate.setCellValueFactory(new PropertyValueFactory<Student,String>("Isuedate"));
//        colReturndate.setCellValueFactory(new PropertyValueFactory<Student,String>("Returndate"));
//    
//        studentTable.getColumns().addAll(colRoll,colName,colEmail,colMobile,colRoom,colResidence,colItemissued,colQuality,colIssuedate,colReturndate);
//        studentTable.setItems(loadData());
//        
//        System.out.println("In table");
//    }
    
    public ObservableList<Student> loadData(){
        ObservableList<Student> data=FXCollections.observableArrayList();
        
        try{
            connect();
            String SQL="SELECT * FROM STUDENT";
            ResultSet rs=conn.createStatement().executeQuery(SQL);
            Student student=new Student();
            while(rs.next()){
                for(int i=0;i<=rs.getMetaData().getColumnCount();i++){
                    student.setRoll(rs.getString("Roll Number"));
                   // MessageBox.show(rs.getString("Roll Number"),"Error");
                    student.setName(rs.getString("Name"));
                    student.setEmail(rs.getString("Email Id"));
                    student.setMobile(rs.getString("Mobile Number"));
                    student.setRoom(rs.getString("Room Number"));
                    student.setResidence(rs.getString("Residence"));
                    //student.setItemissued(rs.getString("Issued Item"));
                    //student.setQuality(rs.getString("Quality"));
                    //student.setIssuedate(rs.getString("Issue Date"));
                    //student.setReturndate(rs.getString("Return Date"));
                    data.add(student);
                }
            }
        }
        catch(Exception e){
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
            String name = studentName.getText();
            String email = studentEmail.getText();
            String roll = studentRoll.getText();
            String mobile = studentMobile.getText();
            String room = studentRoom.getText();
            String residence = (String) studentResidence.getValue();
            String school = (String) studentSchool.getValue();
            
            String error = "Fill All Fields";
            String errorBox = "Error";
            if(name.equals("") || email.equals("") || roll.equals("") || mobile.equals("") || room.equals("")) MessageBox.show(error,errorBox);
            else if(residence==null || school==null) MessageBox.show(error,errorBox);
            else
            {
                try 
                {
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
   
    
    
    /*TabPane t=itemDisplay.getTabPane();
   public void inside()
   {
       t.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
  @Override
  public void changed(ObservableValue<? extends Tab> arg0, Tab arg1, Tab arg2) {
         System.out.println("Eqipment tab clicked");
  }
});
       
   }*/
    
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
        //String sport=returnSport.getEditor().getText();
        //returnBrand.getItems().addAll("Nike","Adidas");
        //returnModel.setValue("Eh?");
        colRoll.setCellValueFactory(new PropertyValueFactory<Student,String>("Roll"));
        colName.setCellValueFactory(new PropertyValueFactory<Student,String>("Name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<Student,String>("Email"));
        colMobile.setCellValueFactory(new PropertyValueFactory<Student,String>("Mobile"));
        colRoom.setCellValueFactory(new PropertyValueFactory<Student,String>("Room"));
        colResidence.setCellValueFactory(new PropertyValueFactory<Student,String>("Residence"));
        colItemissued.setCellValueFactory(new PropertyValueFactory<Student,String>("Itemissued"));
        colQuality.setCellValueFactory(new PropertyValueFactory<Student,String>("Quality"));
        colIssuedate.setCellValueFactory(new PropertyValueFactory<Student,String>("Isuedate"));
        colReturndate.setCellValueFactory(new PropertyValueFactory<Student,String>("Returndate"));
    
        studentTable.getColumns().addAll(colRoll,colName,colEmail,colMobile,colRoom,colResidence,colItemissued,colQuality,colIssuedate,colReturndate);
        studentTable.setItems(loadData());
    }
    
    public void connect()
    {
        try{
            conn=DriverManager.getConnection("jdbc:sqlite:stock portal.sqlite"); 
        }
        catch(Exception e){
            MessageBox.show(e.getMessage(),"Connection error");
        }
    }
    public void returnSportItem()
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
    public void returnBrandItem()
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
    public void returnModelItem()
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
    public void returnItemItem()
    {
        item=returnItem.getEditor().getText();
        //returnItem.setValue("Okay");
    }
}