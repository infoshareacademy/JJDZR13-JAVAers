package pl.isa.javaers;

public class MainMenu {
    private String[] mainOptions;
    private UserAccountManagerMenu userAccountManagerMenu;
    private NotificationsMenu notificationsMenu;
    private NotificationsManagerMenu notificationsManagerMenu;
    private ExchangeRateHistoryMenu exchangeRateHistoryMenu;


    public MainMenu(String[] mainOptions) {
        this.mainOptions = mainOptions;
        this.userAccountManagerMenu = new UserAccountManagerMenu();
        this.exchangeRateHistoryMenu = new ExchangeRateHistoryMenu();
        this.notificationsManagerMenu = new NotificationsManagerMenu();
        this.notificationsMenu = new NotificationsMenu();
    }

    public void display() {
        System.out.println("Main Menu:");
        System.out.println("Choose sub menu by typing number.");
        for (int i = 0; i < mainOptions.length; i++) {
            System.out.println((i + 1) + ". " + mainOptions[i]);
        }
    }

    public void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                userAccountManagerMenu.run();
                break;
            case 2:
                notificationsMenu.run();
                break;
            case 3:
                notificationsManagerMenu.run();
                break;
            case 4:
                exchangeRateHistoryMenu.run();
                break;
            case 5:
                System.out.println("Good bye.");
                System.exit(0);
            default:
                System.out.println("Wrong choice. Try again.");
        }
    }
}