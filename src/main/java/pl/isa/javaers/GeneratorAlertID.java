package pl.isa.javaers;

import java.util.UUID;

public class GeneratorAlertID {
    private static String alertID;

    public static void generatorAlertID() {
        UUID uuid = UUID.randomUUID();
        alertID = String.valueOf(uuid);
    }
    public static void showAlertID(){
        System.out.println(alertID);
    }
}
