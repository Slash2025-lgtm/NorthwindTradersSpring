package com.pluralsight.NorthWindTradersSpringBoot.util;

import com.pluralsight.NorthWindTradersSpringBoot.ui.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class NorthwindTradersCLI implements CommandLineRunner {

    public UserInterface userInterface;

    @Autowired
    public NorthwindTradersCLI(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Override
    public void run(String... args) throws Exception {
        Display.displayMainMenu();
        int selected = UserOptions.getUserInputInt();

        switch (selected) {
            case 1 -> userInterface.displayAll();
            case 2 -> userInterface.addToList();
        }
    }
}
