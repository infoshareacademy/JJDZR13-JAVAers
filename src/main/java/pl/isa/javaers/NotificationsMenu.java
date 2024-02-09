package pl.isa.javaers;
import java.util.List;

public class NotificationsMenu extends Menu {

    public NotificationsMenu() {
        super("Notification Menu", List.of("Show current notifications"), false);
    }

    public void handleUserChoice(int choice) {
        switch (choice) {
            case 2:
                //tu wywołanie funkcji odpowiedniej dla tego wyboru
                break;
            default:
                System.out.println("Wrong option. Try again");
        }
    }
}
