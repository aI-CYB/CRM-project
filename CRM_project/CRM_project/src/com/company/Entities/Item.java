package com.company.Entities;

public class Item {
    private String Item_name;
    private String Item_ID;
    private String Category;
    private double Price_$;
    private double Cost_$;
    private int available_units;
    private double rating;
    public Item(){}

    public Item(String item_ID, String item_name, String category, double price_$, double cost_$, int available_units) {
        this.Item_ID = item_ID;
        this.Item_name = item_name;
        this.Category = category;
        this.Price_$ = price_$;
        this.Cost_$ = cost_$;
        this.available_units = available_units;
    }

    public Item( String item_name, double price_$, int available_units,double rating) {
        this.Item_name = item_name;
        this.Price_$ = price_$;
        this.available_units = available_units;
        this.rating = rating;
    }

    public String getItem_name() {
        return this.Item_name;
    }

    public void setItem_name(String item_name) {
        this.Item_name = item_name;
    }

    public String getItem_ID() {
        return this.Item_ID;
    }

    public void setItem_ID(String item_ID) {
        this.Item_ID = item_ID;
    }

    public String getCategory() {
        return this.Category;
    }

    public void setCategory(String category) {
        this.Category = category;
    }

    public double getPrice_$() {
        return this.Price_$;
    }

    public void setPrice_$(double price_$) {
        this.Price_$ = price_$;
    }

    public double getCost_$() {
        return this.Cost_$;
    }

    public void setCost_$(double cost_$) {
        this.Cost_$ = cost_$;
    }

    public int getAvailable_units() {
        return this.available_units;
    }

    public void setAvailable_units(int available_units) {
        this.available_units = available_units;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return
                "Item_name = " + this.Item_name + " " +
                "Price_$ = " + this.Price_$  + " " +
                "units_available = " + this.available_units + " " +
                "rating = " +this.rating +"\n";
    }
}
