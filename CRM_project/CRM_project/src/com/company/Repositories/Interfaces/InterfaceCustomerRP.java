package com.company.Repositories.Interfaces;

import com.company.Entities.Customer;
import com.company.Entities.Item;
import java.util.ArrayList;

public interface InterfaceCustomerRP {
    public Customer Addfunds(String First_Name, String Last_name, double FundToAdd);
    public ArrayList<Item> Favorite_Products();

}
