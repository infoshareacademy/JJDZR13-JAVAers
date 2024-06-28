package pl.isa.javaers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadJSON {
//    public static List<KursNBP> rates = new ArrayList;
    public static void readJSON() {
        try {
            byte[] data = Files.readAllBytes(Paths.get("console/src/main/resources/KursyNBP/BGN.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            KursNBP kursBGN = objectMapper.readValue(data, KursNBP.class);
            System.out.println(kursBGN.getCurrency());
//           kursBGN.getRates().stream().forEach(rate -> System.out.println(rate.getEffectiveDate()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
