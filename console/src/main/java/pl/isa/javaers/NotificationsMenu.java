package pl.isa.javaers;
import java.util.ArrayList;
import java.util.List;

public class NotificationsMenu extends Menu {

    public NotificationsMenu() {
        super("Notification Menu", List.of("Show current notifications"), false);
    }

    public void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                List<AlertJSON> tmpAlertJSONS = new ArrayList<>();
                tmpAlertJSONS = Main.alerts.getUserAlerts(Main.user);
                UI.showAlerts(tmpAlertJSONS, Main.user);
                break;
            default:
                System.out.println("Wrong option. Try again");
        }
    }
}