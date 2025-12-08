package com.pluralsight.NorthWindTradersSpringBoot.util;

import java.util.Scanner;

public class UserOptions {
    private static Scanner keyboard = new Scanner(System.in);
    public static String getUserInputSting() {
        System.out.print("User: ");
        String selected = keyboard.nextLine();
        return selected;
    }

    public static int getUserInputInt() {
        System.out.print("User: ");
        int selected = keyboard.nextInt();
        keyboard.nextLine();
        return selected;
    }

    public static double getUserInputDouble() {
        System.out.print("User: ");
        double selected = keyboard.nextDouble();
        keyboard.nextLine();
        return selected;
    }
}
