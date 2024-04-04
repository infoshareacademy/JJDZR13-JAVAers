package pl.isa.javaers.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pl.isa.javaers.KursNBP;
import pl.isa.javaers.Rate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RateService {

    public List<Rate> tmpRates = new ArrayList<>();

    public List<Rate> readJSON() {
        try {
            byte[] data = Files.readAllBytes(Paths.get("console/src/main/resources/KursyNBP/BGN.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            KursNBP kursNBP = objectMapper.readValue(data, KursNBP.class);
            tmpRates = kursNBP.getRates().stream().toList();
            return tmpRates;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

