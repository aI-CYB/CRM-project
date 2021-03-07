package com.company.Data;

import com.company.Data.Interfaces.InterfaceDBM;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseManager implements InterfaceDBM {
    @Override
    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/JDBC", "postgres", "wrongpassword789456");

            return  con;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
