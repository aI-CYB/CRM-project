package com.company;

import com.company.Controllers.CustomerController;
import com.company.Controllers.ItemController;
import com.company.Controllers.TransactionController;
import com.company.Data.DataBaseManager;
import com.company.Data.Interfaces.InterfaceDBM;
import com.company.Repositories.CustumerRP;
import com.company.Repositories.Interfaces.InterfaceCustomerRP;
import com.company.Repositories.Interfaces.InterfaceItemRP;
import com.company.Repositories.Interfaces.InterfaceTransactionRP;
import com.company.Repositories.ItemRP;
import com.company.Repositories.TransactionRP;

public class Main {

    public static void main(String[] args) {
        InterfaceDBM dbm = new DataBaseManager();
        InterfaceItemRP itemrp = new ItemRP(dbm);
        InterfaceCustomerRP icustomerrp = new CustumerRP(dbm);
        InterfaceTransactionRP itransactionrp = new TransactionRP(dbm);

        CustomerController customerController = new CustomerController(icustomerrp);
        ItemController itemController = new ItemController (itemrp);
        TransactionController transactionController = new TransactionController(itransactionrp);

        CRM crm = new CRM (itemController,customerController,transactionController);

        crm.begins();
    }
}
