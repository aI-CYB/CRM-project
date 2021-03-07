package com.company;

import com.company.Controllers.CustomerController;
import com.company.Controllers.ItemController;
import com.company.Controllers.TransactionController;

import java.util.Scanner;

public class CRM {
    private final ItemController itemController;
    private final CustomerController customerController;
    private final TransactionController transactionController;
    private final Scanner sc;
    public CRM(ItemController itemController,CustomerController customerController,TransactionController transactionController){
        this.itemController = itemController;
        this.customerController = customerController;
        this.transactionController = transactionController;
        sc = new Scanner(System.in);
    }

    public void begins(){
        while(true){
            System.out.println("Please, choose the one process:");
            System.out.println("    1. Add inventory\n" +
                               "    2. Choose the category:\n" +
                               "    3. Show the interesting age group\n" +
                               "    4. Show the profitability\n" +
                               "    5. Add Funds\n" +
                               "    6. Show Favorite Products\n" +
                               "    7. Show Transaction Dataset\n" +
                               "    8. Profitability of Company\n" +
                               "    9. Top Seasonal Products");
            int n = sc.nextInt();

          if (n==1){
              addInventary();
          }
          else if (n==2){
              System.out.println("   1. winter    " +
                                 "   2. spring    " +
                                 "   3. summer    " +
                                 "   4. autumn");
              distributebySeason();
          }
          else if (n==3){
              interestingagegroup();
          }
          else if (n==4){
              profitability();
          }
          else if (n==5){
              add_fund();
          }
          else if (n==6){
              Favorite_Products();
          }
          else if (n==7){
              DatasetofTransaction();
          }
          else if (n==8){
              profitabilityofcompany();
          }
          else if (n==9){
              System.out.println("   1. winter    " +
                      "   2. spring    " +
                      "   3. summer    " +
                      "   4. autumn");
              top_seasonal_products();
          }
          else break;
            System.out.println("\n"+"----------------"+"\n");
        }
    }
    public void addInventary(){
        System.out.println("Enter the name of item:");
        String item_name = sc.next();
        System.out.println("Enter the ID of item:");
        String item_id = sc.next();
        System.out.println("Enter the category:");
        String category = sc.next();
        System.out.println("Enter the price($):");
        double price_$ = sc.nextDouble();
        System.out.println("Enter the cost($):");
        double cost_$ = sc.nextDouble();
        System.out.println("Enter the available units:");
        int units = sc.nextInt();

        String rs = itemController.AddInventory(item_id, item_name,category,price_$,cost_$,units);
        System.out.println(rs);
    }

    public void distributebySeason(){
        String season;
        int choice = sc.nextInt();
        if(choice == 1) season = "winter";
        else if(choice == 2) season = "spring";
        else if(choice == 3) season = "summer";
        else season = "autumn";
        String rs = itemController.distributeBySeason(season);
        System.out.println(rs);
    }
    public void top_seasonal_products(){
        String season;
        int choice = sc.nextInt();
        if(choice == 1) season = "winter";
        else if(choice == 2) season = "spring";
        else if(choice == 3) season = "summer";
        else season = "autumn";
        String rs = itemController.Top_Seasonal_Products(season);
        System.out.println(rs);
    }
    public void interestingagegroup(){
        itemController.InterestingAgeGroup();
    }

    public void profitability(){
        itemController.ProfitabilityOfTheProduct();
    }

    public void add_fund(){
        System.out.println("Enter your first name:");
        String first_name = sc.next();
        System.out.println("Enter your last name:");
        String last_name = sc.next();
        System.out.println("Enter the funds to add:");
        double funds_to_add = sc.nextDouble();

        String rs = customerController.addFunds(first_name,last_name,funds_to_add).toString();
        System.out.println(rs);
    }

    public void Favorite_Products(){
        String rs = customerController.favorite_Products();
        System.out.println(rs);
    }

    public void DatasetofTransaction(){

        String rs = transactionController.transactiondataset().toString();
        System.out.println(rs);

    }

    public void profitabilityofcompany(){
        Double rs = itemController.Profitabilityofcompany();
        System.out.println("Profitability of Company = " + rs + "$");
    }

}
