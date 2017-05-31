package stock.portal;

import java.sql.Date;

public class Stock 
{
    String brand;
    String model;
    String item;
    String sport;
    String secretary;
    String condition;
    String status;
    String quantity;
    String vendor;
    String invoice;
    java.sql.Date purchasedate;
    String unitprice;
    String tax;
    String total;

    public String getBrand(){return brand;}
    public String getModel(){return model;}
    public String getItem(){return item;}
    public String getSport(){return sport;}
    public String getSecretary(){return secretary;}
    public String getCondition(){return condition;}
    public String getStatus(){return status;}
    public String getQuantity(){return quantity;}
    public String getVendor(){return vendor;}
    public String getInvoice(){return invoice;}
    public java.sql.Date getPurchase(){return purchasedate;}
    public String getUnit(){return unitprice;}
    public String getTax(){return tax;}
    public String getTotal(){return total;}
    
    public void setBrand(String r){brand=r;}
    public void setModel(String r){model=r;}
    public void setItem(String r){item=r;}
    public void setSport(String r){sport=r;}
    public void setSecretary(String r){secretary=r;}
    public void setCondition(String r){condition=r;}
    public void setStatus(String r){status=r;}
    public void setQuantity(String r){quantity=r;}
    public void setVendor(String r){vendor=r;}
    public void setInvoice(String r){invoice=r;}
    public void setPurchase(java.sql.Date r){purchasedate=r;}
    public void setUnit(String r){unitprice=r;}
    public void setTax(String r){tax=r;}
    public void setTotal(String r){total=r;}
}