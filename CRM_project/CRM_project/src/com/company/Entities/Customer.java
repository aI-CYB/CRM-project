package com.company.Entities;

import java.time.LocalDate;

public class Customer {
    private String First_name;
    private String Last_name;
    private int ID;
    private LocalDate  Date_Of_Birth;
    private String Gender;
    private String Phone_Number;
    private String Email;
    private String Country;
    private String Age_group;
    private String Occupancy;
    private double Available_funds;

    public Customer(){}

    public Customer(String first_name, String last_name, double available_funds) {
        this.First_name = first_name;
        this.Last_name = last_name;
        this.Available_funds = available_funds;
    }
    public Customer(String first_name, String last_name, int ID, LocalDate date_Of_Birth, String gender, String phone_Number, String email, String country, String age_group, String occupancy, double available_funds) {
        this.First_name = first_name;
        this.Last_name = last_name;
        this.ID = ID;
        this.Date_Of_Birth = date_Of_Birth;
        this.Gender = gender;
        this.Phone_Number = phone_Number;
        this.Email = email;
        this.Country = country;
        this.Age_group = age_group;
        this.Occupancy = occupancy;
        this.Available_funds = available_funds;
    }

    public String getFirst_name() {
        return this.First_name;
    }

    public void setFirst_name(String first_name) {
        this.First_name = first_name;
    }

    public String getLast_name() {
        return this.Last_name;
    }

    public void setLast_name(String last_name) {
        this.Last_name = last_name;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalDate getDate_Of_Birth() {
        return this.Date_Of_Birth;
    }

    public void setDate_Of_Birth(LocalDate date_Of_Birth) {
        this.Date_Of_Birth = date_Of_Birth;
    }

    public String getGender() {
        return this.Gender;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }

    public String getPhone_Number() {
        return this.Phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        this.Phone_Number = phone_Number;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getCountry() {
        return this.Country;
    }

    public void setCountry(String country) {
        this.Country = country;
    }

    public String getAge_group() {
        return this.Age_group;
    }

    public void setAge_group(String age_group) {
        this.Age_group = age_group;
    }

    public String getOccupancy() {
        return this.Occupancy;
    }

    public void setOccupancy(String occupancy) {
        this.Occupancy = occupancy;
    }

    public double getAvailable_funds() {
        return this.Available_funds;
    }

    public void setAvailable_funds(double available_funds) {
        this.Available_funds = available_funds;
    }

    @Override
    public String toString() {
        return "Customer[" +
                "First_name='" + this.First_name + '\'' +
                ", Last_name='" + this.Last_name + '\'' +
                ", Available_funds=" + this.Available_funds +
                ']';
    }
}
