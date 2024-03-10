package pl.isa.javaers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class RatesParser {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static List<CurrRate> listFromJSON(String currCode) {

        try {
            byte[] data = Files.readAllBytes(Paths.get("src/main/resources/KursyNBP/" + currCode + ".json"));
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            List<Rates> listFromJSON = Arrays.asList(objectMapper.readValue(data, Rates[].class));
//            return listFromJSON;

//            return Collections.singletonList(objectMapper.readValue(data, CurrRate.class));
            return Arrays.asList(objectMapper.readValue(data, CurrRate.class));
//            HashMap<Rates, Rate> rateMap = new HashMap<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
