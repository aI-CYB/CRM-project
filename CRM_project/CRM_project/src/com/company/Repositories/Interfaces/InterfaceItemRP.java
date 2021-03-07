package com.company.Repositories.Interfaces;

import java.util.ArrayList;
import com.company.Entities.Item;

public interface InterfaceItemRP {
    public boolean AddInventory (Item item);
    public ArrayList<Item> distributeBySeason(String season);
    public ArrayList<Item> Top_Seasonal_Products(String season);
    public  void InterestingAgeGroup();
    public void ProfitabilityOfTheProduct();
    public double Profitabilityofcompany();
}
