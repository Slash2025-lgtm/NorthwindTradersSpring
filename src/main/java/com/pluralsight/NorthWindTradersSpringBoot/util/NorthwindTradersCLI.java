package com.pluralsight.NorthWindTradersSpringBoot.util;

import com.pluralsight.NorthWindTradersSpringBoot.data.ProductDao;
import com.pluralsight.NorthWindTradersSpringBoot.ui.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class NorthwindTradersCLI implements CommandLineRunner {

    private final UserInterface userInterface;
    private final ProductDao productDao;

    @Autowired
    public NorthwindTradersCLI(UserInterface userInterface, ProductDao productDao) {
        this.userInterface = userInterface;
        this.productDao = productDao;
    }


    @Override
    public void run(String... args) throws Exception {
        while (true) {
            Display.displayMainMenu();
            int selected = UserOptions.getUserInputInt();
            switch (selected) {
                case 1 -> userInterface.displayAll(productDao);
                case 2 -> userInterface.addToList(productDao);
                default -> System.exit(0);
            }
        }
    }
}
