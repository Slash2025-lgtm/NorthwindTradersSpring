package com.pluralsight.NorthWindTradersSpringBoot.ui;

import com.pluralsight.NorthWindTradersSpringBoot.data.Product;
import com.pluralsight.NorthWindTradersSpringBoot.data.ProductDao;

import com.pluralsight.NorthWindTradersSpringBoot.util.UserOptions;

public class UserInterface {
    private static ProductDao productDao;

    public void displayAll() {
        productDao.getAll().forEach(System.out::println);
    }

    public void addToList() {
        System.out.println("Please Enter the items Product ID");
        int productID = UserOptions.getUserInputInt();

        System.out.println("Please Enter the items Product Name");
        String productName = UserOptions.getUserInputSting();

        System.out.println("Please Enter the items Category");
        String category = UserOptions.getUserInputSting();

        System.out.println("Please Enter the items Price");
        double price = UserOptions.getUserInputDouble();
        productDao.add(new Product(productID, productName, category, price));
    }
}
