package pl.isa.javaers;


public class Main {
    public static void main(String[] args) {
        Assets.loadAssets();
        DailyAlertChecker.dailyAlertCheckerFileSaver(true);
    }
}
