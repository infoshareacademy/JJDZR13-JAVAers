package pl.isa.javaers.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.isa.javaers.AlertJSON;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static pl.isa.javaers.ErrorCodes.ALERT_MODIFY_ERR;
import static pl.isa.javaers.ErrorCodes.ALERT_REMOVAL_ERR;
import static pl.isa.javaers.Settings.ALERTS_FILE;

public class AlertsJSON {
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


    //  Function getUserAlerts returns ArrayList of AlertsJSON created by user identified by uID
    public List<AlertJSON> getUserAlerts(String uID) {
        List<AlertJSON> tmpAlertJSONS = new ArrayList<>();
        tmpAlertJSONS.addAll(alertJSONS.stream().filter(c -> uID.equals(c.getUserID())).toList());
        return tmpAlertJSONS;
    }

    public static int addToAlerts(AlertJSON alertJSON) {
        int result = Assets.checkCurrencyCode(alertJSON.getCurrCode());
        if (result == 0) alertJSONS.add(alertJSON);
        return result;
    }

    public static int removeFromAlerts(AlertJSON a){
        int result=ALERT_REMOVAL_ERR;
        if (alertJSONS.remove(a)) result=0;
        return result;
    }
    //check if the Asset's code is supported by the Application

    //    Function finds and modifies alert identified by alert.alertID
    public static int modifyAlert(AlertJSON alertJSONNew){
        int result = ALERT_MODIFY_ERR;
        //find current alert with the same allertID and get id as an object (to be removed
        Optional<AlertJSON> alertOld = alertJSONS.stream().filter(c -> alertJSONNew.getAlertID().equals((c.getAlertID()))).findFirst();
        if(alertOld.isEmpty()) return result;
        if(alertJSONS.remove(alertOld)) return ALERT_REMOVAL_ERR;
        alertJSONS.add(alertJSONNew);
        return 0;
        //after removal this object - add new (modified) version of this object
        //alertJSONS.stream().filter(c -> a.getAlertID().equals(c.getAlertID())).findFirst().peek().
    }


    public AlertsJSON() {
    }
}
