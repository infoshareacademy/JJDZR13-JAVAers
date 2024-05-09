package pl.isa.javaers.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import pl.isa.javaers.KursNBP;
import pl.isa.javaers.Rate;
import pl.isa.javaers.model.UserRateHistoryData;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

@Service
public class RateServiceImpl implements RateService {

    public List<Rate> tmpRates = new ArrayList<>();
    private static List<UserRateHistoryData> USER_RATE_HISTORY_DATA_LIST = new ArrayList<>();

    public String rateName;
    private List<Rate> filteredRateLIst = new ArrayList<>();
    private TreeSet<LocalDate> datesSet = new TreeSet<>();
    private UserRateHistoryData userRateHistoryData;

    private List<LocalDate> datesList = new ArrayList<>();

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

//    @Override
//    public List<Rate> getFilteredRateLIst() {
//        return null;
//    }

    public List<LocalDate> createData(UserRateHistoryData userRateHistoryData) {
//        USER_RATE_HISTORY_DATA_LIST.add(userRateHistoryData);
//
//
//        for (Date date : (TreeSet<Date>) datesSet.subSet(Date.from(userRateHistoryData.getStartDate().atStartOfDay(ZoneId.systemDefault()).toInstant()), true, Date.from(userRateHistoryData.getEndDate().atStartOfDay(ZoneId.systemDefault()).toInstant()), true)) {
//        TreeSet<LocalDate> tmpDates = new TreeSet<>();
//        LocalDate temporaryLocalDate = userRateHistoryData.getStartDate();
//        for (; userRateHistoryData.getStartDate().isBefore(userRateHistoryData.getEndDate()); temporaryLocalDate = temporaryLocalDate.plusDays(1)){
//            tmpDates.add(temporaryLocalDate);
//        }
//        datesSet = (TreeSet<Date>) tmpDates.subSet(Date.from(userRateHistoryData.getStartDate().atStartOfDay(ZoneId.systemDefault()).toInstant()), true, Date.from(userRateHistoryData.getEndDate().atStartOfDay(ZoneId.systemDefault()).toInstant()), true);
//        datesSet = (TreeSet<LocalDate>) tmpDates.subSet(userRateHistoryData.getStartDate(), true, userRateHistoryData.getEndDate(), true);
        List<LocalDate> datesList = new ArrayList<>();
        LocalDate tmpDate = userRateHistoryData.getStartDate();

        while (!tmpDate.isAfter(userRateHistoryData.getEndDate())) {
            datesList.add(tmpDate);
            tmpDate = tmpDate.plusDays(1);
        }
        return datesList;
    }


    public List<Rate> getFilteredRateLIst(UserRateHistoryData userRateHistoryData) {
//        filteredRateLIst = readRatesFromJSON();
//        LocalDate temporaryLocalDate = userRateHistoryData.getStartDate();

        tmpRates = readRatesFromJSON();
        List<LocalDate> datesList1 = createData(userRateHistoryData);
//        TreeSet<Date> userDatesRanged = (TreeSet<Date>) datesSet.subSet(Date.from(userRateHistoryData.getStartDate().atStartOfDay(ZoneId.systemDefault()).toInstant()), true, Date.from(userRateHistoryData.getEndDate().atStartOfDay(ZoneId.systemDefault()).toInstant()), true);
//        LocalDate temporaryLocalDate = USER_RATE_HISTORY_DATA_LIST.get(0).getStartDate();
//        for (; USER_RATE_HISTORY_DATA_LIST.get(0).getStartDate().isBefore(USER_RATE_HISTORY_DATA_LIST.get(0).getEndDate()); temporaryLocalDate = temporaryLocalDate.plusDays(1)) {
//            for (Rate rate : tmpRates) {
//                while (rate.getEffectiveDate().contains(temporaryLocalDate.toString())) {
//                    if (rate.getEffectiveDate().equals(temporaryLocalDate.toString())) {
//                        filteredRateLIst.add(rate);
//                        break;
//                    }
//                }
//            }
//        }
//        for (LocalDate localDate : datesList1) {
            for (Rate rate : tmpRates) {
                if (datesList1.toString().contains(rate.getEffectiveDate()))
                    filteredRateLIst.add(rate);

            }
//        }
        return filteredRateLIst;
    }
}

