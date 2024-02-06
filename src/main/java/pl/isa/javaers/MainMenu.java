package pl.isa.javaers;
import java.util.List;

public class MainMenu extends Menu {
    private UserAccountManagerMenu userAccountManagerMenu;
    private NotificationsMenu notificationsMenu;
    private NotificationsManagerMenu notificationsManagerMenu;
    private ExchangeRateHistoryMenu exchangeRateHistoryMenu;

    public MainMenu() {
        super("main Menu", List.of("User Account Manager", "Notifications", "Notification Manager", "Exchange Rate History"), true);
        userAccountManagerMenu = new UserAccountManagerMenu();
        exchangeRateHistoryMenu = new ExchangeRateHistoryMenu();
        notificationsManagerMenu = new NotificationsManagerMenu();
        notificationsMenu = new NotificationsMenu();
    }

    public void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                userAccountManagerMenu.runMenu();
                break;
            case 2:
                notificationsMenu.runMenu();
                break;
            case 3:
                notificationsManagerMenu.runMenu();
                break;
            case 4:
                exchangeRateHistoryMenu.runMenu();
                break;
            default:
                System.out.println("Wrong choice. Try again.");
        }
    }
}