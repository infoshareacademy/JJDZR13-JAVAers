package pl.isa.javaers;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static String user = "user3";
    public static Alerts alerts;

    public static void main(String[] args) {

        List<Alert> tmpAlerts = new ArrayList<>();
        Assets.loadAssets();
        alerts = new Alerts();
        alerts.loadAlerts();
        new MainMenu().runMenu();
        /*
        UI.showAllAlerts();
        if(0!=alerts.addToAlerts(new Alert("user1", "BTC", 180000f, true))) System.out.println("Alert nie został dodany");

        alerts.addToAlerts(new Alert("user2", "GBP", 4.4f, false));
        alerts.addToAlerts(new Alert("user3", "NOK", 3.7f, false));
        alerts.addToAlerts(new Alert("user4", "USD", 4.3f, true));
        alerts.addToAlerts(new Alert("user5", "EUR", 4.25f, false));

        UI.showAllAlerts();
        alerts.saveAlerts();

        tmpAlerts = alerts.getUserAlerts("user4");
        UI.showAlerts(tmpAlerts, "user4");
        System.out.println("Alerty użytkownika user4 : " + tmpAlerts);

        UI.newAlert("user2");
        */
    }
}