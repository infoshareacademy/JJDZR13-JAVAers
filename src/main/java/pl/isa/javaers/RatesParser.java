package pl.isa.javaers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class RatesParser {
    public static List<Rates> listFromJSON(String currCode) {
        try {
            byte[] data = Files.readAllBytes(Paths.get("src/main/resources/KursyNBP/" + currCode + ".json"));
            ObjectMapper objectMapper = new ObjectMapper();
            Rates tmpRates = objectMapper.readValue(data, Rates.class);
            tmpRates.getRates().stream().forEach(rates -> System.out.println());
//            tmpRates.getRates().stream().forEach(rates -> System.out.println());
//            kursBGN.getRates().stream().forEach(rate -> System.out.println(rate.getEffectiveDate()));
        return listFromJSON(currCode);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
//    @JsonIgnoreProperties(ignoreUnknown = true)
//    public static List<CurrRate> listFromJSON(String currCode) throws IOException {
//
//        try {
//            byte[] data = Files.readAllBytes(Paths.get("src/main/resources/KursyNBP/" + currCode + ".json"));
//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
////            List<Rates> listFromJSON = Arrays.asList(objectMapper.readValue(data, Rates[].class));
////            return listFromJSON;
//
////            return Collections.singletonList(objectMapper.readValue(data, CurrRate.class));
////            List<CurrRate> listFromJSON = Arrays.asList(objectMapper.readValue(data, CurrRate.class));
//            CurrRate currRateAfterCCode = objectMapper.readValue(data, CurrRate.class);
//            List<CurrRate> listFromJSON = Arrays.asList(currRateAfterCCode);
//            return listFromJSON;
////            HashMap<Rates, Rate> rateMap = new HashMap<>();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
//        Gson gson = new Gson();
//        BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(Paths.get("src/main/resources/KursyNBP/" + currCode + ".json"))));
//        CurrRate[] objectsArray = gson.fromJson(reader, CurrRate[].class);
//        reader.close();
//        return Arrays.asList(objectsArray);
//    }
//}
