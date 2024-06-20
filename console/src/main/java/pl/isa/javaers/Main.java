package pl.isa.javaers;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static String user = "user3";
    public static Alerts alerts;

    public static void main(String[] args) {

        List<AlertJSON> tmpAlertJSONS = new ArrayList<>();
        Assets.loadAssets();
        DailyAlertChecker.dailyAlertCheckerFileSaver();
        //new MainMenu().runMenu();
        alerts = new Alerts();
        alerts.loadAlerts();
        new MainMenu().runMenu();
    }
}
