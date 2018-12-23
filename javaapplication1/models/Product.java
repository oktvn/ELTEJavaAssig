package javaapplication1.models;

public class Product {
    private String description;
    private long barcode;
    private String serialNumber;
    private GoldenTicket prizeTicket;
    
    private String boughtbyID;

    public Product(String description,long barcode, String serialNumber, GoldenTicket ticket ) {
        this.description = description;
        this.barcode = barcode;
        this.serialNumber = serialNumber;
        this.prizeTicket = ticket;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getBoughtbyID() {
        return boughtbyID;
    }

    public void setBoughtbyID(String boughtbyID) {
        this.boughtbyID = boughtbyID;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public GoldenTicket getPrizeTicket() {
        return prizeTicket;
    }
    
    public void setPrizeTicket(GoldenTicket prizeTicket) {
        this.prizeTicket = prizeTicket;
    }
    
    public String toString() {
        boolean hasTicket = false;
        if (prizeTicket != null) {
            hasTicket = true;
        } 
        return "Desc:" + description + " Code:" + barcode + " S/N:" + serialNumber + " " + hasTicket;
    }
}
