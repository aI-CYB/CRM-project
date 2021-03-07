package com.company.Controllers;

import com.company.Repositories.Interfaces.InterfaceTransactionRP;

public class TransactionController {
    private final InterfaceTransactionRP itransactionrp;

    public TransactionController (InterfaceTransactionRP itransactionrp){
        this.itransactionrp = itransactionrp;
    }

    public String transactiondataset(){
        String rs = itransactionrp.TransactionDataset().toString();
        return rs;
    }
}
