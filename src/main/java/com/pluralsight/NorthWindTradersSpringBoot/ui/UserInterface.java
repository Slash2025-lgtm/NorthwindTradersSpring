package com.pluralsight.NorthWindTradersSpringBoot.ui;

import com.pluralsight.NorthWindTradersSpringBoot.NorthWindTradersSpringBootApplication;
import com.pluralsight.NorthWindTradersSpringBoot.data.Product;
import com.pluralsight.NorthWindTradersSpringBoot.data.ProductDao;
import com.pluralsight.NorthWindTradersSpringBoot.data.SimpleProductDao;
import com.pluralsight.NorthWindTradersSpringBoot.util.UserOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class UserInterface {
    private static Display display = new Display();
    private static ProductDao productDao;

    public void init() {
        while (true) {
         selectPrompt();
        }
    }

    private void selectPrompt() {
        display.displayMainMenu();
        int selected = UserOptions.getUserInputInt();

        switch (selected) {
            case 1 -> displayAll();
            case 2 -> addToList();
        }
    }

    private void displayAll() {
        ApplicationContext context = SpringApplication.run(NorthWindTradersSpringBootApplication.class);

        productDao = context.getBean(SimpleProductDao.class);
        productDao.getAll().stream().forEach(System.out::println);
    }

    private void addToList() {
        System.out.println("Please Enter the items Product ID");
        int productID = UserOptions.getUserInputInt();

        System.out.println("Please Enter the items Product Name");
        String productName = UserOptions.getUserInputSting();

        System.out.println("Please Enter the items Category");
        String category = UserOptions.getUserInputSting();

        System.out.println("Please Enter the items Price");
        double price = UserOptions.getUserInputDouble();

        ApplicationContext context = SpringApplication.run(NorthWindTradersSpringBootApplication.class);

        productDao = context.getBean(SimpleProductDao.class);
        productDao.add(new Product(productID, productName, category, price));
    }
}
