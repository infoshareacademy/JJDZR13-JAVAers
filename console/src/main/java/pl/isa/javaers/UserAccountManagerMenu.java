package pl.isa.javaers;
import java.util.List;

public class UserAccountManagerMenu extends Menu {

    public UserAccountManagerMenu() {
        super("User Account Manager", List.of("Sign in", "Log in", "Change Password"), false);
    }

    public void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
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
