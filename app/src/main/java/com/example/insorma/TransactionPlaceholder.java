package com.example.insorma;

public class TransactionPlaceholder {
    String transactionID, furnitureName, transactionDate;
    Integer boughtQuantity, totalPrice;

    public TransactionPlaceholder(String transactionID, String furnitureName, String transactionDate, Integer boughtQuantity, Integer totalPrice) {
        this.transactionID = transactionID;
        this.furnitureName = furnitureName;
        this.transactionDate = transactionDate;
        this.boughtQuantity = boughtQuantity;
        this.totalPrice = totalPrice;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getFurnitureName() {
        return furnitureName;
    }

    public void setFurnitureName(String furnitureName) {
        this.furnitureName = furnitureName;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Integer getBoughtQuantity() {
        return boughtQuantity;
    }

    public void setBoughtQuantity(Integer boughtQuantity) {
        this.boughtQuantity = boughtQuantity;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
}
