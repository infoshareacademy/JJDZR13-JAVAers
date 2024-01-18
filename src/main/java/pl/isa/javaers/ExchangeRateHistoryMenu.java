package pl.isa.javaers;

import java.util.Scanner;

public class ExchangeRateHistoryMenu {
    private String[] exchangeRateHistoryMenu;

    public ExchangeRateHistoryMenu() {
        this.exchangeRateHistoryMenu = new String[]{"Back to main menu", "Show exchange rate from chosen dates."};
    }
    public void display() {
        System.out.println("Exchange Rate History");
        for (int i = 0; i < exchangeRateHistoryMenu.length; i++) {
            System.out.println((i + 1) + ". " + exchangeRateHistoryMenu[i]);
        }
    }
    public void handleUserChoise(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Back to main menu");
                break;
            case 2:
                System.out.println("Show exchange rate from chosen dates.");
                break;
            default:
                System.out.println("Wrong option. Try again");
        }
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            display();
            int choice = Integer.parseInt(scanner.nextLine());

            handleUserChoise(choice);
            if (choice == 1){
                break;
            }
        }
    }
}