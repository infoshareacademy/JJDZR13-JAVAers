package pl.isa.javaers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Handler;

public class RatesParser {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static HashMap<Rates, Rate> getListOfRatesFromJSON(String currCode) {

        try {
            byte[] data = Files.readAllBytes(Paths.get("src/main/resources/KursyNBP/" + currCode + ".json"));
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            return Arrays.asList(objectMapper.readValue(data, Rates[].class));
            HashMap<Rates, Rate> rateMap = new HashMap<>();
rateMap.putAll((Map<? extends Rates, ? extends Rate>) objectMapper.readValue(data, Rates.class));
            return rateMap;
        } catch (IOException e) {
            throw new RuntimeException(e);
//            return new ArrayList<>();
        }
    }
//    public static List<Rate> loadRate(String currCode){
//        List<Rate> rates = getListOfRatesFromJSON(currCode);
//        return rates;
//    }
}
