package pl.isa.javaers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;


import static pl.isa.javaers.ErrorCodes.*;
import static pl.isa.javaers.Settings.ALERTS_FILE;

public class Alerts {
    public static List<AlertJSON> alertJSONS = new ArrayList<>();


    public void loadAlerts() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            alertJSONS.addAll(Arrays.asList(objectMapper.readValue(new File(ALERTS_FILE), AlertJSON[].class)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void saveAlerts(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(ALERTS_FILE), alertJSONS);
        } catch (IOException e) { throw new RuntimeException(e);}
    }


    //  Function getUserAlerts returns ArrayList of Alerts created by user identified by uID
    public List<AlertJSON> getUserAlerts(String uID) {
        List<AlertJSON> tmpAlertJSONS = new ArrayList<>();
        tmpAlertJSONS.addAll(alertJSONS.stream().filter(c -> uID.equals(c.getUserID())).toList());
        return tmpAlertJSONS;
    }

    public static int addToAlerts(AlertJSON alertJSON) {
        int result=ALERT_ADD_ERR;
        int res = Assets.checkCurrencyCode(alertJSON.getCurrCode()); //check if the Asset's code is supported by the Application
        if (res == 0) {
            alertJSONS.add(alertJSON);
            result = 0;
        }
        return result;
    }

    public static int removeFromAlerts(AlertJSON a){
        int result=ALERT_REMOVAL_ERR;
        if (alertJSONS.remove(a)) result=0;
        return result;
    }
    public static int removeFromAlerts(String alertID) {
        int result=ALERT_REMOVAL_ERR;
        Iterator<AlertJSON> alertIt = alertJSONS.iterator();
        while(alertIt.hasNext()) {
            AlertJSON alertJSONTemp = alertIt.next();
            if(alertJSONTemp.getAlertID().equals(alertID)) {
                alertIt.remove();
                result=0; }
            }
            return result;
    }
//    Function finds and replaces alert identified by alert.alertID
    public static int modifyAlert(AlertJSON alertJSONNew){
        int result = ALERT_MODIFY_ERR;
        Iterator<AlertJSON> alertIt = alertJSONS.iterator();
        while(alertIt.hasNext()) {
            AlertJSON alertJSONTemp = alertIt.next();
            if(alertJSONTemp.getAlertID().equals(alertJSONNew.getAlertID())) {
                alertIt.remove();
                result = 0;
            }
        }
        alertJSONS.add(alertJSONNew);
        return result;
    }

    public Alerts() {
    }
}
