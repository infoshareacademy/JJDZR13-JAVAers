package pl.isa.javaers;

import java.util.Scanner;

public class NotificationsMenu {
    private String[] notificationsMenu;

    public NotificationsMenu() {
        this.notificationsMenu = new String[]{"Back to main menu", "Show current notifications"};
    }

    public void display() {
        System.out.println("Notifications");
        for (int i = 0; i < notificationsMenu.length; i++) {
            System.out.println((i + 1) + ". " + notificationsMenu[i]);
        }
    }

    public void handleUserChoise(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Back to main menu");
                break;
            case 2:
                System.out.println("Show current notifications.");
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
