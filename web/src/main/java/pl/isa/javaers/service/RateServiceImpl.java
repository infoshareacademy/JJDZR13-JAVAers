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
public class RateServiceImpl implements RateService {

    private List<Rate> tmpRates = new ArrayList<>();
    public String rateName;
    private LocalDate tmpDate;
    private List<Rate> filteredRateLIst = new ArrayList<>();

    private List<LocalDate> datesList = new ArrayList<>();

    public List<Rate> readUserRatesFromJSON(UserRateHistoryData userRateHistoryData) {
        try {
            byte[] data = Files.readAllBytes(Paths.get("console/src/main/resources/KursyNBP/" + userRateHistoryData.getUserCurrencyCode() + ".json"));
            ObjectMapper objectMapper = new ObjectMapper();
            KursNBP kursNBP = objectMapper.readValue(data, KursNBP.class);
            tmpRates = kursNBP.getRates().stream().toList();
            rateName = kursNBP.getCurrency();
            return tmpRates;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public List<LocalDate> createData(UserRateHistoryData userRateHistoryData) {

        tmpDate = userRateHistoryData.getStartDate();
        datesList.clear();

        while (!tmpDate.isAfter(userRateHistoryData.getEndDate())) {
            datesList.add(tmpDate);
            tmpDate = tmpDate.plusDays(1);
        }
        return datesList;
    }


    public List<Rate> filterRatesByDate(UserRateHistoryData userRateHistoryData) {
        filteredRateLIst.clear();
        tmpRates = readUserRatesFromJSON(userRateHistoryData);
        List<LocalDate> datesList1 = createData(userRateHistoryData);
        for (Rate rate : tmpRates) {
            if (datesList1.toString().contains(rate.getEffectiveDate())) {
                filteredRateLIst.add(rate);

            }
        }
        return filteredRateLIst;
    }

    public List<Rate> getFilteredRateLIst() {
        return filteredRateLIst;
    }
}

