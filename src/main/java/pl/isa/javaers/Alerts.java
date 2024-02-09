package pl.isa.javaers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        int result = Assets.checkCurrencyCode(alert.getCurrCode());
        if (result == 0) alerts.add(alert);
        return result;
    }
    //check if the Asset's code is supported by the Application


    public Alerts() {
    }
}
