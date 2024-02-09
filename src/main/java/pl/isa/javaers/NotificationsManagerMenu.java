package pl.isa.javaers;
import java.util.ArrayList;
import java.util.List;

import static pl.isa.javaers.Alerts.alerts;

public class NotificationsManagerMenu extends Menu {

    public NotificationsManagerMenu() {
        super("Notifications Manager", List.of("Add new notification.", "Delete notification.", "Edit notification."), false);
    }

    public void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                UI.newAlert(Main.user);
                //tu wywołanie funkcji odpowiedniej dla tego wyboru
                break;
            case 2:
                //tu wywołanie funkcji odpowiedniej dla tego wyboru
                break;
            case 3:
                //tu wywołanie funkcji odpowiedniej dla tego wyboru
                break;
            default:
                System.out.println("Wrong option. Try again");
        }
    }
}