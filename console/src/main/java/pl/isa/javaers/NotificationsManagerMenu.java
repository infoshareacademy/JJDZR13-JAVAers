package pl.isa.javaers;
import java.util.ArrayList;
import java.util.List;

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
                List<AlertJSON> tmpAlertJSONS = new ArrayList<>();
                tmpAlertJSONS = Main.alerts.getUserAlerts(Main.user);
                //UI.showAlerts(tmpAlertJSONS, Main.user);
                UI.removeAlert(tmpAlertJSONS,Main.user);
                break;
            case 3:
                //tu wywołanie funkcji odpowiedniej dla tego wyboru
                break;
            default:
                System.out.println("Wrong option. Try again");
        }
    }
}