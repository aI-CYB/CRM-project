package com.company.Repositories;

import com.company.Data.Interfaces.InterfaceDBM;
import com.company.Entities.Customer;
import com.company.Entities.Item;
import com.company.Repositories.Interfaces.InterfaceCustomerRP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CustumerRP implements InterfaceCustomerRP {
    private final InterfaceDBM dbm;
    public CustumerRP (InterfaceDBM dbm){
        this.dbm = dbm;
    }
    @Override
    public Customer Addfunds(String First_name, String Last_name,double FundToAdd) {
        Connection con = null;
        try {
            con = dbm.getConnection();
            PreparedStatement prepst = con.prepareStatement("SELECT first_name,last_name,available_funds FROM customer WHERE first_name LIKE '%"+First_name+"%' and last_name like '%"+Last_name+"%'");

            ResultSet rs = prepst.executeQuery();

            Customer customer = new Customer();
            if(rs.next()){
                customer.setFirst_name(rs.getString("first_name"));
                customer.setLast_name(rs.getString("Last_name"));
                customer.setAvailable_funds(rs.getDouble("available_funds") + FundToAdd);
            }
            return customer;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Item> Favorite_Products() {
        Connection con = null;
        try {
            con = dbm.getConnection();
            PreparedStatement prepst = con.prepareStatement("SELECT item_name,price_$,available_units,rating FROM item order by rating desc");

            ResultSet rs = prepst.executeQuery();

            ArrayList<Item> items = new ArrayList<>(5);

            int i=0;

            while(rs.next()){
                Item item = new Item();
                item.setItem_name(rs.getString("item_name"));
                item.setPrice_$(rs.getDouble("price_$"));
                item.setAvailable_units(rs.getInt("available_units"));
                item.setRating(rs.getDouble("rating"));

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

}
