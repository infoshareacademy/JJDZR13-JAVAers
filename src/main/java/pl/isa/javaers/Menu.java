package pl.isa.javaers;

import java.util.*;

public abstract class Menu {
    Scanner scanner = new Scanner(System.in);
    String name;
    List<String> options;
    boolean isMainMenu;

    Menu(String name, List<String> options, boolean isMainMenu) {
        this.options = options;
        this.name = name;
        this.isMainMenu = isMainMenu;
    }

    public abstract void handleUserChoice(int choice);

    public void display() {
        System.out.println(name);
        if (isMainMenu) {
            System.out.println("0. Exit");
        } else {
            System.out.println("0. Back to main menu");
        }
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    public void runMenu() {
        while (true) {
            display();
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 0) {
                    break;
                }
                handleUserChoice(choice);
            } catch (NumberFormatException nfe) {
                System.out.println("Number not typed. Try again.");
            }
        }
    }
}