package pl.isa.javaers;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ExchangeRateHistory {
    private static Scanner uIScanner = new Scanner(System.in);

    private int userCurrencyCode;
    private int userTime;
    private LocalDate startDate;
    private LocalDate endDate;


    public static void showRateHistory(HashMap<String, Asset> assetsHashMap, LocalDate startDate, LocalDate endDate) {
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
                uIScanner.nextLine();

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
                uIScanner.nextLine();
            }
        }
        System.out.println("Your Currency is: " + currCode + " " + temporaryAssets.get(currCode).getFullName() + " And set dates are: " + startDate + " to: " + endDate);
        try {
            byte[] data = Files.readAllBytes(Paths.get("src/main/resources/KursyNBP/"+currCode+".json"));
            ObjectMapper objectMapper = new ObjectMapper();
            KursNBP kursCurrCode = objectMapper.readValue(data, KursNBP.class);
            String ratesAsString = objectMapper.writeValueAsString(data);
            ratesAsString.toString();
            System.out.println(ratesAsString);
//            System.out.println(kursCurrCode.getRates().stream().collect(Collectors.toList()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}