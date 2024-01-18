package pl.isa.javaers;

import java.util.Scanner;

public class MainMenuApp {
    public static void main(String[] args) {
        String[] mainMenuOptions = {"User Account Manager", "Notifications", "Notification Manager", "Exchange Rate History", "Exit"};
        MainMenu mainMenu = new MainMenu(mainMenuOptions);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            mainMenu.display();
            int choice = Integer.parseInt(scanner.nextLine());
            mainMenu.handleUserChoice(choice);
        }
    }
}

