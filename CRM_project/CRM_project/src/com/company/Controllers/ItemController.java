package com.company.Controllers;

import com.company.Entities.Item;
import com.company.Repositories.Interfaces.InterfaceItemRP;


public class ItemController {
    private final InterfaceItemRP iitemrp;

    public ItemController (InterfaceItemRP iitemrp){
       this.iitemrp = iitemrp;
    }

    public String AddInventory (String item_id, String item_name, String category, double price_$, double cost_$, int available_units){

        boolean added = iitemrp.AddInventory(new Item(item_id, item_name, category, price_$, cost_$, available_units));

        if (added){
            return "inventory has been added";
        }

        return "inventory has not been added";
    }

    public String distributeBySeason (String season){
        return iitemrp.distributeBySeason(season).toString();
    }

    public String Top_Seasonal_Products(String season) { return iitemrp.Top_Seasonal_Products(season).toString(); }

    public void InterestingAgeGroup(){
        iitemrp.InterestingAgeGroup();
    }

    public void ProfitabilityOfTheProduct(){
        iitemrp.ProfitabilityOfTheProduct();
    }

    public double Profitabilityofcompany(){
        return iitemrp.Profitabilityofcompany();
    }
}
