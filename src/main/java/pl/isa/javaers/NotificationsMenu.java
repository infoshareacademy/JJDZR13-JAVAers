package pl.isa.javaers;
import java.util.ArrayList;
import java.util.List;

import static pl.isa.javaers.Alerts.alerts;

public class NotificationsMenu extends Menu {

    public NotificationsMenu() {
        super("Notification Menu", List.of("Show current notifications"), false);
    }

    public void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                List<Alert> tmpAlerts = new ArrayList<>();
                tmpAlerts = Main.alerts.getUserAlerts(Main.user);
                UI.showAlerts(tmpAlerts, Main.user);
                break;
            default:
                System.out.println("Wrong option. Try again");
        }
    }
}