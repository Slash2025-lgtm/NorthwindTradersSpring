package com.pluralsight.NorthWindTradersSpringBoot;

import com.pluralsight.NorthWindTradersSpringBoot.data.ProductDao;
import com.pluralsight.NorthWindTradersSpringBoot.data.SimpleProductDao;
import com.pluralsight.NorthWindTradersSpringBoot.ui.UserInterface;
import com.pluralsight.NorthWindTradersSpringBoot.util.UserOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class NorthWindTradersSpringBootApplication {
	public static void main(String[] args) {
		UserInterface userInterface = new UserInterface();
		userInterface.init();
	}
}
