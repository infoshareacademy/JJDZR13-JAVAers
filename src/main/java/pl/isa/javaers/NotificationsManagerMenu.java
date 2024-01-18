package pl.isa.javaers;

import java.util.Scanner;

public class NotificationsManagerMenu {
    private String[] notificationsManagerMenu;

    public NotificationsManagerMenu() {
        this.notificationsManagerMenu = new String[]{"Back to main menu", "Add new notification.", "Delete notification.", "Edit notification."};
    }

    public void display() {
        System.out.println("Notifications Manager");
        for (int i = 0; i < notificationsManagerMenu.length; i++) {
            System.out.println((i + 1) + ". " + notificationsManagerMenu[i]);
        }
    }

    public void handleUserChoise(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Back to main menu");
                break;
            case 2:
                System.out.println("Add new notification.");
                break;
            case 3:
                System.out.println("Delete notification.");
                break;
            case 4:
                System.out.println("Edit notification.");
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