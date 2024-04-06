package pl.isa.javaers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.function.Predicate;

import static pl.isa.javaers.Main.rate;

public class ExchangeRateHistory {
    private static Scanner uIScanner = new Scanner(System.in);

    private int userCurrencyCode;
    private int userTime;
    private LocalDate startDate;
    private LocalDate endDate;
    private static List<Rate> temporaryKursNBPList;
    private static List<Rate> filteredRateList;


    public static String showRateHistory(HashMap<String, Asset> assetsHashMap, LocalDate startDate, LocalDate endDate) throws IOException {
        char userChoice = '\0';
        boolean validInput = false;
        String key;

        HashMap<String, Asset> assets = Assets.loadAssetCodes();
        HashMap<String, Asset> temporaryAssets = Main.assets.getAllAssets();


        System.out.println("Chose which currency you would like to show from currency codes below");
        temporaryAssets.keySet().stream().forEach(System.out::println);                 //strumień do wyświetlenia kodów do wyboru;

        System.out.println("Enter currency code (3 characters) : ");

        String currCode = uIScanner.nextLine().toUpperCase();   //zadeklarowanie kodu waluty potrzebnego do wyciągnięcia z pliku historii kursów
        int res = Assets.checkCurrencyCode(currCode);           //powinno mieć waluty na tę chwilę dodane ręcznie do hashMapy

        if (res != 0) {
            System.out.println("Wrong code typed. Returning upper Menu.");
        }
        while (!validInput) {
            try {
                System.out.println("Enter expected start date(yyyy-mm-dd): ");
                startDate = LocalDate.parse(uIScanner.nextLine());
                validInput = true;
            } catch (DateTimeParseException dateTimeParseException) {
                System.out.println("Invalid date format. Please try again a valid format");
            }
        }
        validInput = false;
        while (!validInput) {
            try {
                System.out.println("Enter expected end date(yyyy-mm-dd): ");
                endDate = LocalDate.parse(uIScanner.nextLine());
                validInput = true; // If no exception is thrown, input is valid
            } catch (DateTimeParseException dateTimeParseException) {
                System.out.println("Invalid date format. Please try again a valid format");
            }
        }
        System.out.println("Your Currency is: " + currCode + " " + temporaryAssets.get(currCode).getFullName() + " And set dates are: " + startDate + " to: " + endDate);

        filteredRateList = new ArrayList<Rate>();
        temporaryKursNBPList = RatesParser.listFromJSON(currCode);
        LocalDate finalStartDate = startDate;
        for (; finalStartDate.isBefore(endDate); finalStartDate = finalStartDate.plusDays(1)) {
            for (Rate rate : temporaryKursNBPList) {
                while (rate.getEffectiveDate().contains(finalStartDate.toString())) {
                    if (rate.getEffectiveDate().equals(finalStartDate.toString())) {
                        filteredRateList.add(rate);
                        break;
                    }
                }
            }
        }
        return filteredRateList.toString();
    }
}
//// TODO: 12.02.2024 add date validator to method