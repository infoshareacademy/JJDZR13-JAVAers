package pl.isa.javaers;
import java.util.List;

public class ExchangeRateHistoryMenu extends Menu {

    public ExchangeRateHistoryMenu() {
        super("Exchange Rate History", List.of("Show exchange rate from chosen dates."), false);
    }

    public void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                //tu wywołanie funkcji odpowiedniej dla tego wyboru
                break;
            default:
                System.out.println("Wrong option. Try again");
        }
    }
}