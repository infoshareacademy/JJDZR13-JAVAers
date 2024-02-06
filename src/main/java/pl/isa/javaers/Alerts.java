package pl.isa.javaers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static pl.isa.javaers.ErrorCodes.ASSETS_WRONGCCODE;

public class Alerts {
        public static List<Alert> alerts = new ArrayList<>();


        public void loadAlerts() {
            try {
                byte[] data = Files.readAllBytes(Paths.get("src/main/resources/alerts.json"));
                System.out.println(Arrays.toString(data));
                ObjectMapper objectMapper = new ObjectMapper();
                //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); - gubi wszystkie dane
                //ArrayList<Alert> alerts = objectMapper.readValue(data, new TypeReference<ArrayList<Alert>>() {}); - nie działa
                //Alert alert = objectMapper.readValue(data, Alert.class);

                //Alert[] alerts2 = objectMapper.readValue(new File("src/main/resources/alerts1.json"), Alert.class);

                //ArrayList<Alert> alerts = objectMapper.readValue(new File("src/main/resources/alerts2.json"), new TypeReference<ArrayList<Alert>>(){});
                alerts.addAll(Arrays.asList(objectMapper.readValue(new File("src/main/resources/alerts1.json"), Alert[].class)));
                System.out.println("alertstmp : " + alerts);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        public void saveAlerts(){
            try {
                ObjectMapper mapper = new ObjectMapper();

                //  Ten blok chciałbym żeby działał - ale on nie chce

                /*
                StringBuilder jsonAlertsArray=new StringBuilder("[");
                int size=alerts.size();
                Alert tmpAlert = new Alert();
                for(int i=0; i<size; i++) {
                    tmpAlert = alerts.get(i);
                    System.out.println("tmpAlert : " + tmpAlert);
                    String tmpStr=mapper.writeValueAsString(alerts.get(0));
                    System.out.println(tmpStr);
                    jsonAlertsArray.append(tmpStr);
                    if(size-i>1) jsonAlertsArray.append(",");
                }
                jsonAlertsArray.append("]");
                mapper.writeValue(new File("src/main/resources/alerts10.json"),jsonAlertsArray);
                */

                // A jednoczesnie - działa jego uproszczona wersja poniżej :

//                String jsonAlertsArray = "[" + mapper.writeValueAsString(alerts.get(0));
                //jsonAlertsArray += "," + mapper.writeValueAsString(alerts.get(1));
                //jsonAlertsArray += "," + mapper.writeValueAsString(alerts.get(2));
//                jsonAlertsArray += "," + mapper.writeValueAsString(alerts.get(1))+ "]";
//                System.out.println("jsonAlertsArray : " + jsonAlertsArray);
                mapper.writeValue(new File("src/main/resources/alerts10.json"), alerts);
                System.out.println("Alerty zapisane do pliku alerts10.json");

                // Nie rozumiem dlaczego nie można tego wszystkiego zrobić tak jak w linii poniżej:
                //mapper.writeValue(new File("src/main/resources/alerts10.json"),ArrayList.class);

                // Z tego co czytam - to ta moja ArrayList'a jest chyba tak naprawdę LinkedHashMap'ą
                // i pewnie dlatego nie działa nawet coś takiego :
                //for(Alert a:alerts) System.out.println(a.toString());

        } catch (IOException e) { throw new RuntimeException(e);}
        }
        public void showAlerts() {
            System.out.println("alerts : " + alerts);
        }

        public int addToAlerts(Alert alert) {
                alerts.add(alert);
                return 0;
        }
        //check if the Asset's code is supported by the Application


    public Alerts() {
    }
}

