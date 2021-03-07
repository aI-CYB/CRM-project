package com.company.Repositories;

import com.company.Data.Interfaces.InterfaceDBM;
import com.company.Entities.Transaction;
import com.company.Repositories.Interfaces.InterfaceTransactionRP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TransactionRP implements InterfaceTransactionRP {
    private final InterfaceDBM dbm;

    public TransactionRP (InterfaceDBM dbm){
        this.dbm = dbm;
    }

    @Override
    public ArrayList<Transaction> TransactionDataset() {
        Connection con = null;
        try {
            con = dbm.getConnection();
            PreparedStatement prepst = con.prepareStatement("SELECT customer.id, item.item_name, item.item_id,  transaction.transaction_id, transaction.transaction_date, transaction.amount, transaction.total_price, transaction.discount_code, transaction.discount_amount from transaction full JOIN item ON item.item_id=transaction.item_id full JOIN customer ON customer.id=transaction.id;");

            ResultSet rs = prepst.executeQuery();

            ArrayList<Transaction> transactions = new ArrayList<>();

            while (rs.next()){
                Transaction transaction = new Transaction();

                transaction.setCustomer_id(rs.getInt("id"));
                transaction.setItem_name(rs.getString("item_name"));
                transaction.setItem_id(rs.getString("item_id"));
                transaction.setTransaction_ID(rs.getInt("transaction_id"));
                transaction.setDate_Of_Transaction(rs.getDate("transaction_date"));
                transaction.setAmount(rs.getInt("amount"));
                transaction.setTotal_Price(rs.getDouble("total_price"));
                transaction.setDiscount_code(rs.getInt("discount_code"));
                transaction.setDiscount_amount(rs.getInt("discount_amount"));

                transactions.add(transaction);
            }
            return transactions;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
