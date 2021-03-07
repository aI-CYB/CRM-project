package com.company.Controllers;

import com.company.Entities.Customer;
import com.company.Repositories.Interfaces.InterfaceCustomerRP;


public class CustomerController {
    private final InterfaceCustomerRP icustomerrp;

    public CustomerController (InterfaceCustomerRP icustomerrp){
        this.icustomerrp = icustomerrp;
    }

    public Customer addFunds(String first_name, String last_name, Double FundsToAdd){
        Customer customer = new Customer();
        customer = icustomerrp.Addfunds(first_name,last_name,FundsToAdd);
        return customer;
    }

    public String favorite_Products(){
        String rs = icustomerrp.Favorite_Products().toString();
        return rs;
    }
}
