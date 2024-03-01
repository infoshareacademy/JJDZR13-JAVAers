package pl.isa.javaers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Rates {
//    "table": "A",
//            "currency": "lew (Bułgaria)",
//            "code": "BGN",
//            "rates": [

    private String table;
    private String currency;
    private String code;
    private static List<Rates> rates;

    private static List<Rates> ratesFromJSON;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static List<Rates> getListOfRatesFromJSON(String currCode) {

        try {
            byte[] data = Files.readAllBytes(Paths.get("src/main/resources/KursyNBP/" + currCode + ".json"));
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            rates = Collections.singletonList(objectMapper.readValue(data, Rates.class));
            return rates;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString(){
        return "Rates for: " +
                getCode();
    }

    public String getTable() {
        return table;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

//    public List<Rates> getRates() {
//        return rates;
//    }
}
