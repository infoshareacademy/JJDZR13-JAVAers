package pl.isa.javaers.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pl.isa.javaers.KursNBP;
import pl.isa.javaers.Rate;
import pl.isa.javaers.model.UserRateHistoryData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RateServiceImpl implements RateService{

    public List<Rate> tmpRates = new ArrayList<>();
    private static List<UserRateHistoryData> USER_RATE_HISTORY_DATA_LIST = new ArrayList<>();

    public String rateName;
    private List<Rate> filteredRateLIst = new ArrayList<>();
    public UserRateHistoryData userRateHistoryData;

    public List<Rate> readRatesFromJSON() {
        try {
            byte[] data = Files.readAllBytes(Paths.get("console/src/main/resources/KursyNBP/BGN.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            KursNBP kursNBP = objectMapper.readValue(data, KursNBP.class);
            tmpRates = kursNBP.getRates().stream().toList();
            rateName = kursNBP.getCurrency();
            return tmpRates;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void createData(UserRateHistoryData userRateHistoryData){
        USER_RATE_HISTORY_DATA_LIST.add(userRateHistoryData);
    }

    public List<Rate> getFilteredRateLIst(){
        filteredRateLIst = readRatesFromJSON();
//        LocalDate temporaryLocalDate = userRateHistoryData.getStartDate();
        LocalDate temporaryLocalDate = USER_RATE_HISTORY_DATA_LIST.get(0).getStartDate();
        for (; USER_RATE_HISTORY_DATA_LIST.get(0).getStartDate().isBefore(USER_RATE_HISTORY_DATA_LIST.get(0).getEndDate()); temporaryLocalDate = temporaryLocalDate.plusDays(1)) {
            for (Rate rate : tmpRates) {
                while (rate.getEffectiveDate().contains(temporaryLocalDate.toString())) {
                    if (rate.getEffectiveDate().equals(temporaryLocalDate.toString())) {
                        filteredRateLIst.add(rate);
                        break;
                    }
                }
            }
        }
        return filteredRateLIst;
    }
}

