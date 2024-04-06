package pl.isa.javaers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class ExchangeRateHistoryMenu extends Menu {

    public ExchangeRateHistoryMenu() {
        super("Exchange Rate History", List.of("Show exchange rate from chosen dates."), false);
    }

    public void handleUserChoice(int choice) throws IOException {
        switch (choice) {
            case 1:
                HashMap<String, Asset> temporaryAssets = new HashMap<>();
                temporaryAssets = Main.assets.getAllAssets();
                System.out.println(ExchangeRateHistory.showRateHistory(temporaryAssets, LocalDate.MIN, LocalDate.MAX));
                break;
            default:
                System.out.println("Wrong option. Try again");
        }
    }
}