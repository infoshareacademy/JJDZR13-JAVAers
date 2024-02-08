package pl.isa.javaers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Assets.loadAssets();
        Alert alert = new Alert();
        alert.create("user1","USD",4.3f,true);
        System.out.println(Assets.checkCurrencyCode("USD"));
        System.out.println(Assets.checkCurrencyCode("SEK"));
        GeneratorAlertID.generatorAlertID();
        GeneratorAlertID.showAlertID();

        Alerts alerts = new Alerts();
        alerts.showAlerts();
        alerts.loadAlerts();
        alerts.showAlerts();
        alerts.addToAlerts(new Alert("user2", "USD", 3.9f, false));
//        alerts.addToAlerts(new Alert("user2", "EUR", 4.2f, false));
//        alerts.addToAlerts(new Alert("user3", "CHF", 4.4f, false));
//        alerts.addToAlerts(new Alert("user3", "SEK", 3.9f, true));
//        alerts.showAlerts();
        alerts.saveAlerts();
        alerts.deleteAlert();

    }
}
