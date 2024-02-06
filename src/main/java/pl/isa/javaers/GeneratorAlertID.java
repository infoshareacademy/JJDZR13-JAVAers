package pl.isa.javaers;

import java.util.UUID;

public class GeneratorAlertID {
    private static String alertID;

    public static String generatorAlertID() {
        UUID uuid = UUID.randomUUID();
        alertID = String.valueOf(uuid);
        return alertID;
    }
    public static void showAlertID(){
        System.out.println(alertID);
    }
}

