package pl.isa.javaers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExchangeRateHistory {
    private static Scanner uIScanner = new Scanner(System.in);

    private int userCurrencyCode;
    private int userTime;
    private LocalDate startDate;
    private LocalDate endDate;
    private static List<Rate> temporaryKursNBPList;


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
//                uIScanner.nextLine();

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
//                uIScanner.nextLine();
            }
        }
        System.out.println("Your Currency is: " + currCode + " " + temporaryAssets.get(currCode).getFullName() + " And set dates are: " + startDate + " to: " + endDate);


        temporaryKursNBPList = RatesParser.listFromJSON(currCode);
        LocalDate finalStartDate = startDate;
//        Predicate<CurrRate> affectiveDatePredicate = a -> a.getEffectiveDate().equals(finalStartDate);
        Predicate<KursNBP> affectiveDatePredicate = a -> a.getRates().contains(finalStartDate); //getTable().equals(finalStartDate);
//        List<Rate> filteredCurrKursNBPHistoryList = temporaryKursNBPList.stream().filter(affectiveDatePredicate).collect(Collectors.toList());
        return temporaryKursNBPList.toString();
//        temporaryRatesList = new ArrayList<>(RatesParser.listFromJSON(currCode).stream().toList());
//        Predicate<RatesParser> affectiveDatePredicate = a -> a.equals(finalStartDate);
//        List<RatesParser> filteredCurrRateHistoryList = temporaryRatesList.stream().filter(affectiveDatePredicate).collect(Collectors.toList());

        //// TODO: 12.02.2024  fix getting rates


//            ratesAsString.toString();
//            System.out.println(ratesAsString);
//            System.out.println(kursCurrCode.getRates().stream().collect(Collectors.toList()));
//            kursCurrCode.getRates().stream().collect(Collectors.toList());
//            List<Rate> ratesListFromString = objectMapper.readValue(ratesAsString, new TypeReference<List<Rate>>() {
//                @Override
//                public String toString() {
//                    return super.toString();
//                }
//            });
//            System.out.println(kursCurrCode.getRates().stream().toString());
//
//            List<Rate> rateList = new ArrayList<>();
//            System.out.printf("", kursCurrCode.getRates().addAll(rateList));
//            rateList.forEach(System.out::println);
        //// TODO: 12.02.2024 add date validator to method
    }

}