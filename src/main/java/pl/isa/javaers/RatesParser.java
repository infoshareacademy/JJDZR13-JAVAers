package pl.isa.javaers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class RatesParser {
    public static List<Rate> listFromJSON = new ArrayList<>();
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static List<Rate> listFromJSON(String currCode) {

        try {
            byte[] data = Files.readAllBytes(Paths.get("src/main/resources/KursyNBP/" + currCode + ".json"));
            ObjectMapper objectMapper = new ObjectMapper();
            KursNBP currKursNBPAfterCCode = objectMapper.readValue(data, KursNBP.class);
            listFromJSON = currKursNBPAfterCCode.getRates().stream().toList();

            return listFromJSON;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}