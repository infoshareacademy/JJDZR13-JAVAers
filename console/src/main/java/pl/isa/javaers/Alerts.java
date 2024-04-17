package pl.isa.javaers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;


import static pl.isa.javaers.ErrorCodes.ALERT_MODIFY_ERR;
import static pl.isa.javaers.ErrorCodes.ALERT_REMOVAL_ERR;
import static pl.isa.javaers.Settings.ALERTS_FILE;

public class Alerts {
    public static List<Alert> alerts = new ArrayList<>();


    public void loadAlerts() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            alerts.addAll(Arrays.asList(objectMapper.readValue(new File(ALERTS_FILE), Alert[].class)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void saveAlerts(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(ALERTS_FILE), alerts);
        } catch (IOException e) { throw new RuntimeException(e);}
    }


    //  Function getUserAlerts returns ArrayList of Alerts created by user identified by uID
    public List<Alert> getUserAlerts(String uID) {
        List<Alert> tmpAlerts = new ArrayList<>();
        tmpAlerts.addAll(alerts.stream().filter(c -> uID.equals(c.getUserID())).toList());
        return tmpAlerts;
    }

    public static int addToAlerts(Alert alert) {
        int result = Assets.checkCurrencyCode(alert.getCurrCode()); //check if the Asset's code is supported by the Application
        if (result == 0) alerts.add(alert);
        return result;
    }

    public static int removeFromAlerts(Alert a){
        int result=ALERT_REMOVAL_ERR;
        if (alerts.remove(a)) result=0;
        return result;
    }
    public static int removeFromAlerts(String alertID) {
        int result=ALERT_REMOVAL_ERR;
        Iterator<Alert> alertIt = alerts.iterator();
        while(alertIt.hasNext()) {
            Alert alertTemp = alertIt.next();
            if(alertTemp.getAlertID().equals(alertID)) {
                alertIt.remove();
                result=0; }
            }
            return result;
    }
//    Function finds and modifies alert identified by alert.alertID
    public static int modifyAlert(Alert alertNew){
        int result = ALERT_MODIFY_ERR;
        //find current alert with the same allertID and get id as an object (to be removed
        Iterator<Alert> alertIt = alerts.iterator();
        while(alertIt.hasNext()) {
            Alert alertTemp = alertIt.next();
            if(alertTemp.getAlertID().equals(alertNew.getAlertID()))
                alertIt.remove();
        }
        /*
        Optional<Alert> alertOld = alerts.stream().filter(c -> alertNew.getAlertID().equals((c.getAlertID()))).findFirst();
        if(alertOld.isEmpty()) return result;
        if(alerts.remove(alertOld)) return ALERT_REMOVAL_ERR;
         */
        alerts.add(alertNew);
        System.out.println(alerts.toString());
        return 0;
        //after removal this object - add new (modified) version of this object
        //alerts.stream().filter(c -> a.getAlertID().equals(c.getAlertID())).findFirst().peek().
    }

    public Alerts() {
    }
}
