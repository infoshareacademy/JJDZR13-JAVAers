package pl.isa.javaers;

import java.util.Scanner;

public class UserAccountManagerMenu {
    private String[] userAccountManagerMenuOptions;

    public UserAccountManagerMenu() {
        this.userAccountManagerMenuOptions = new String[]{"Back to main menu.", "Sign in", "Log in", "Change Password"};
    }

    public void display() {
        System.out.println("User account manager");
        for (int i = 0; i < userAccountManagerMenuOptions.length; i++) {
            System.out.println((i + 1) + ". " + userAccountManagerMenuOptions[i]);
        }
    }

    public void handleUserChoise(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Back to main menu");
                break;
            case 2:
                System.out.println("Sign in chosen.");
                break;
            case 3:
                System.out.println("Log in chosen.");
                break;
            case 4:
                System.out.println("Change password chosen.");
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
            if (choice == 1) {
                break;
            }
        }
    }
}
