package pl.isa.javaers;

import java.util.UUID;

public class GeneratorAlertID {
    private static String alertID;
//
//    public  GeneratorAlertID() {
//        UUID uuid = UUID.randomUUID();
//            alertID = String.valueOf(uuid);
//        System.out.println();
//    }
    public static void generatorAlertID() {
        UUID uuid = UUID.randomUUID();
        alertID = String.valueOf(uuid);
        System.out.println(alertID);
    }

//    public static String getAlertID() {
//        return "Generated ID : " + alertID;
//    }
}
