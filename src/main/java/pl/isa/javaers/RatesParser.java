package pl.isa.javaers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class RatesParser {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static List<CurrRate> listFromJSON(String currCode) throws IOException {

        try {
            byte[] data = Files.readAllBytes(Paths.get("src/main/resources/KursyNBP/" + currCode + ".json"));
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            CurrRate currRateAfterCCode = objectMapper.readValue(data, CurrRate.class);
            List<CurrRate> listFromJSON = new ArrayList<>(currRateAfterCCode.hashCode());
            return listFromJSON;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}