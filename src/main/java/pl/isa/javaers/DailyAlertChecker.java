package pl.isa.javaers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Formatter;
import java.util.Scanner;

public class DailyAlertChecker {
    private String kursNBP = new KursNBP().getTable();                                                           // dane z pliku json pobrane do porównania
    private String rateEffectiveDate = String.valueOf(new Rate().getEffectiveDate());
    private String rateCurrency = new KursNBP().getCode();
    private float rateCourse = new Rate().getMid();//String.valueOf(new Rate().getMid());
    private String alertID = String.valueOf(new Alert().getAlertID());                                          // dane z alertu ustawionego przez uzytkownika pobrane do porownania
    private float userCourse = new Alert().getCourse();  //String.valueOf(new Alert().getCourse());
    private String userCurrency = new Alert().getCurrCode();

    private static boolean isAlertConditionFulfilled = false;
    private String actualDate = String.valueOf(Date.valueOf(LocalDate.now()));

    //metoda sprawdzająca alerty na razie sklejona na szybko, na pewno do dopracowania jeśli chodzi o logikę.
    public static boolean dailyAlertCheckerMethod(String rateEffectiveDate, String actualDate, float rateCourse, String rateCurrency, float userCourse, String userCurrency) {
        do {
            do {
                do isAlertConditionFulfilled = true; while (rateCourse > userCourse);
            } while (rateCurrency.equals(userCurrency));
        } while (rateEffectiveDate.equals(actualDate));
        return isAlertConditionFulfilled;
    }

    public static void dailyAlertCheckerFileSaver() {                                   //metoda zapisująca wynik sprawdzenia alertów do pliku
        Date saveFilaDate = Date.valueOf(LocalDate.now());
        File dailyAlertFile = new File(Settings.ALERT_CHECKER_FILE);
        FileWriter fileWriter = null;
        if (isAlertConditionFulfilled) {
            try {
                if (!dailyAlertFile.exists()) {
                    dailyAlertFile.createNewFile();
                    System.out.println("Daily Alert Checker file Created" + saveFilaDate);

                }
                if (dailyAlertFile.canWrite()) {
                    fileWriter = new FileWriter(dailyAlertFile, true);                 // fileWriter zapisuje w pliku
                    Formatter dailyAlertFileFormatter = new Formatter(fileWriter);                        // formatter pozwala sformatować to co chcemy zapisać do pliku jako parametr przyjmuje obiekt klasy FileWriter
                    Scanner scannerFile = new Scanner(dailyAlertFile);                                    // sprawdza dane w pliku

                    String alertNotification = "cos co chcemy zeby bylo zapisane w pliku po spelnieniu warunkow"; // moze trzeba tu przekazac alert ID a nie tylko string
                    dailyAlertFileFormatter.format("%s \n", alertNotification);
                    System.out.println("Daily Alert Checker file Updated: " + saveFilaDate);

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}