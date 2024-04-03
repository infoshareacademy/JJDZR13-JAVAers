package pl.isa.javaers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static String user = "user3";
    public static Alerts alerts;
    public static Assets assets;
    public static Rates rates;
    public static CurrRate currRate;

    public static void main(String[] args) {

        HashMap<String, Assets> temporaryAssets = new HashMap<>();
        List<Rates> ratesList = new ArrayList<>();
        assets = new Assets();
        assets.getAllAssets();
        alerts = new Alerts();
        alerts.loadAlerts();
        rates = new Rates();
        rates.getRates();
        currRate = new CurrRate();

        new MainMenu().runMenu();
    }
}
