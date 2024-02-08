package pl.isa.javaers;

import java.util.ArrayList;
import java.util.List;

import static pl.isa.javaers.Alerts.alerts;

public class UI {

    static public void showAllAlerts() {
        System.out.println("alerts : " + alerts);
    }
    static public void showAlerts(ArrayList<Alert> alertList) {
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
        System.out.println("\n\rWprowadź dane nowego alertu dla użytkownika " + userID + ":\n\r--------------------------------");
    }
}
