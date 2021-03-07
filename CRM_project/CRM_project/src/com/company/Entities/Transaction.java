package com.company.Entities;

import java.util.Date;

public class Transaction {
    private int Transaction_ID;
    private Date Date_Of_Transaction;
    private int customer_id;
    private String item_id;
    private String item_name;
    private int Amount;
    private double Total_Price;
    private int Discount_code;
    private int Discount_amount;

    public Transaction(){}

    public Transaction(int customer_id, String item_name,  String item_id, int transaction_ID, Date date_Of_Transaction, int amount, double total_Price, int discount_code,int Discount_amount) {
        this.Transaction_ID = transaction_ID;
        this.Date_Of_Transaction = date_Of_Transaction;
        this.customer_id = customer_id;
        this.item_id = item_id;
        this.item_name = item_name;
        this.Amount = amount;
        this.Total_Price = total_Price;
        this.Discount_code = discount_code;
        this.Discount_amount = Discount_amount;
    }

    public int getTransaction_ID() {
        return this.Transaction_ID;
    }

    public void setTransaction_ID(int transaction_ID) {
        this.Transaction_ID = transaction_ID;
    }

    public Date getDate_Of_Transaction() {
        return this.Date_Of_Transaction;
    }

    public void setDate_Of_Transaction(Date date_Of_Transaction) {
        this.Date_Of_Transaction = date_Of_Transaction;
    }

    public int getAmount() {
        return this.Amount;
    }

    public void setAmount(int amount) {
        this.Amount = amount;
    }

    public double getTotal_Price() {
        return this.Total_Price;
    }

    public void setTotal_Price(double total_Price) {
        this.Total_Price = total_Price;
    }

    public int getDiscount_code() {
        return this.Discount_code;
    }

    public void setDiscount_code(int discount_code) {
        this.Discount_code = discount_code;
    }

    public int getCustomer_id() {
        return this.customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getItem_id() {
        return this.item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getDiscount_amount() {
        return Discount_amount;
    }

    public void setDiscount_amount(int discount_amount) {
        Discount_amount = discount_amount;
    }

    public void Total_Price(double price, int amount, int discount_amount){
        this.Total_Price = price*amount*(100-discount_amount)/100;
    }

    @Override
    public String toString() {
        return "Transaction:" +
                "Transaction_ID='" + this.Transaction_ID + '\'' +
                ", Date_Of_Transaction=" + this.Date_Of_Transaction +
                ", customer_id=" + this.customer_id +
                ", item_id='" + this.item_id + '\'' +
                ", item_name=" + this.item_name +
                ", Amount=" + this.Amount +
                ", Total_Price=" + this.Total_Price +
                ", Discount_code='" + this.Discount_code + '\'' + "\n";
    }
}
