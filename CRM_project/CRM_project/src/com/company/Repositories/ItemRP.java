package com.company.Repositories;

import com.company.Data.Interfaces.InterfaceDBM;
import com.company.Entities.Item;
import com.company.Repositories.Interfaces.InterfaceItemRP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ItemRP implements InterfaceItemRP {
    private final InterfaceDBM dbm;

    public ItemRP (InterfaceDBM dbm){
        this.dbm = dbm;
    }

    @Override
    public boolean AddInventory(Item item) {
        Connection con = null;
        try {
            con = dbm.getConnection();

            PreparedStatement prepst = con.prepareStatement("INSERT INTO item(item_id,item_name,category,price_$,cost_$,available_units) VALUES (?,?,?,?,?,?)");

            prepst.setString(1, item.getItem_ID());
            prepst.setString(2, item.getItem_name());
            prepst.setString(3, item.getCategory());
            prepst.setDouble(4, item.getPrice_$());
            prepst.setDouble(5, item.getCost_$());
            prepst.setInt(6, item.getAvailable_units());

            prepst.execute();

            return true;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList<Item> distributeBySeason(String season) {
        Connection con = null;
        try {
            con = dbm.getConnection();

            PreparedStatement prepst = con.prepareStatement("SELECT * FROM item WHERE category LIKE '%" +season+ "%' ");

            ResultSet rs = prepst.executeQuery();

            ArrayList<Item> items = new ArrayList<>();

            while (rs.next()){
                Item item = new Item (rs.getString("Item_name"),
                                      rs.getDouble("Price_$") ,
                                      rs.getInt("available_units"),
                                      rs.getDouble("rating"));

                items.add(item);
            }
            return items;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Item> Top_Seasonal_Products(String season) {
        Connection con = null;
        try {
            con = dbm.getConnection();

            PreparedStatement prepst = con.prepareStatement("SELECT * FROM item WHERE category LIKE '%" +season+ "%' order by rating desc");

            ResultSet rs = prepst.executeQuery();

            ArrayList<Item> items = new ArrayList<>();

            int i=0;

            while (rs.next()){
                Item item = new Item (rs.getString("Item_name"),
                        rs.getDouble("Price_$") ,
                        rs.getInt("available_units"),
                        rs.getDouble("rating"));

                items.add(item);
                i++;
                if (i==5) break;
            }
            return items;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void InterestingAgeGroup() {
        Connection con = null;
        try {
            con = dbm.getConnection();

            PreparedStatement prepst = con.prepareStatement("SELECT age_group FROM customer;");

            ResultSet rs = prepst.executeQuery();

            int[] ageReport = new int[3];

            while (rs.next()){
                String ageGroup;
                ageGroup = rs.getString("age_group");

                char x = ageGroup.charAt(0);
                char y = ageGroup.charAt(1);
                int age = ((x - '0')*10)  + (y - '0');

                if (age > 17 && age < 25) ageReport[0]++;
                else if (age < 41) ageReport[1]++;
                else ageReport[2]++;
            }
            System.out.println("18-24 (years old)      25-40 (years old)      41-65 (years old)");
            System.out.println("       " + ageReport[0] + "                     " + ageReport[1] + "                     " + ageReport[2]);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void ProfitabilityOfTheProduct() {
        Connection con = null;
        try {
            con = dbm.getConnection();

            PreparedStatement prepst = con.prepareStatement("SELECT item_name,price_$,cost_$ FROM item;");

            ResultSet rs = prepst.executeQuery();

            while (rs.next()){
                String item_name = rs.getString("item_name");
                double price = rs.getDouble("price_$");
                double cost = rs.getDouble("cost_$");
                double profitpercentage = (price - cost)*100/cost;

                System.out.println(  "Profitability of " + item_name + ": " + profitpercentage + "%");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public double Profitabilityofcompany() {
        Connection con = null;
        try {
            con = dbm.getConnection();

            PreparedStatement prepst = con.prepareStatement("SELECT price_$,cost_$,available_units FROM item;");

            ResultSet rs = prepst.executeQuery();

            double profitcompany = 0;

            while (rs.next()){

                double price = rs.getDouble("price_$");
                double cost = rs.getDouble("cost_$");
                int availableunits = rs.getInt("available_units");

                profitcompany += (price - cost) * availableunits;
            }
            return profitcompany;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
