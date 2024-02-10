package pl.isa.javaers;

import java.sql.SQLOutput;
import java.util.*;

import static pl.isa.javaers.Alerts.alerts;

public class UI {
    static Scanner uiscanner = new Scanner(System.in);
    static public void showAllAlerts() {
        System.out.println("alerts : " + alerts);
    }
    static public void showAlerts(List<Alert> alertList) {
        String toDisplay="--------------------------\n\r";
        int i=1;
        for(Alert al:alertList){
            char sign = al.isHigherOrLower()?'>':'<';
            toDisplay += i++ + " " + al.getAlertID() + " " + al.getCurrCode() + " " + sign + " " + al.getCourse() + " \n\r";
        }
        System.out.println(toDisplay);
        return;
    }
    static public void showAlerts(List<Alert> alertList, String userID) {
        String toDisplay="User " + userID + " alerts list:\n\r--------------------------\n\r";
        int i=1;
        for(Alert al:alertList){
            char sign = al.isHigherOrLower()?'>':'<';
            toDisplay += i++ + " " + al.getAlertID() + " " + al.getCurrCode() + " " + sign + " " + al.getCourse() + " \n\r";
        }
        System.out.println(toDisplay);
        return;
    }
    static public void newAlert(String userID){
        boolean validInput = false;
        boolean higherOrLower=true;
        int res=0;
        float value=0.0f;
        char userChoice = '\0'; // Initialize with a default value

        //tu kod do sprawdzenia czy userID istnieje - jeśli nie - to komunikat o błędzie i wyjście

        System.out.println("\n\rDefine new alert/notification fo user " + userID + ":\n\r--------------------------------");
        System.out.println("Enter currency code (3 characters) : ");
        //int choice = Integer.parseInt(uiscanner.nextLine());
        String currCode = uiscanner.nextLine();
        res=Assets.checkCurrencyCode(currCode);
        if(res!=0) {
            System.out.println("Improper currency code " + currCode + ". Returning to the upper menu.");
            return;
        }



        while (!validInput) {
            try {
                System.out.println("Enter currency expected value : ");
                value = uiscanner.nextFloat();
                validInput = true; // If no exception is thrown, input is valid
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid float value.");
                // Clear the invalid input from the buffer
                uiscanner.next();
            }
        }

        validInput = false;
        while (!validInput) {
            System.out.print("Now decided whether you want be informed if the currency code is higher or lower than entered value. Choose '<' or '>': ");
            String inputString = uiscanner.next();

            // Check if the inputString has only one character
            if (inputString.length() == 1) {
                userChoice = inputString.charAt(0);

                // Check if the entered character is either '<' or '>'
                if (userChoice == '<' || userChoice == '>') {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter '<' or '>'.");
                }
            } else {
                System.out.println("Invalid input. Please enter a single character.");
            }
        }
        //System.out.println("You entered: " + userChoice);
        System.out.println("You chose to be informed if the course of "+currCode + " is "+userChoice+" than "+value);
        higherOrLower= userChoice == '>';


        validInput = false;
        while (!validInput) {
            System.out.println("Please press Y to confirm or N to cancel this alert");
            String inputString = uiscanner.next();

            // Check if the inputString has only one character
            if (inputString.length() == 1) {
                userChoice = inputString.charAt(0);

                // Check if the entered character is either '<' or '>'
                if (userChoice == 'y' || userChoice == 'Y') {
                    if(0!=Alerts.addToAlerts(new Alert(Main.user,currCode,value,higherOrLower))) System.out.println("Alert has not been added");
                    else {
                        Alerts.saveAlerts();
                        System.out.println("Alert " + currCode + " " + userChoice + " " + value + "has been added");
                    }
                    validInput=true;
                }
                else if ((userChoice == 'n' || userChoice == 'N')) {
                    System.out.println("Invalid input. Please enter '<' or '>'.");
                    validInput=true;
                }
                else System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            } else {
                System.out.println("Invalid input. Please enter a single character.");
            }
        }
        // Can't close the scanner to prevent resource leaks - it causes runtime error
        //uiscanner.close();


    }
}
