package pl.isa.javaers.service;

import pl.isa.javaers.Rate;
import pl.isa.javaers.model.UserRateHistoryData;

import java.time.LocalDate;
import java.util.List;

public interface RateService {
    List<Rate> readRatesFromJSON();
    List<Rate> getFilteredRateLIst(UserRateHistoryData userRateHistoryData);
    List<LocalDate> createData(UserRateHistoryData userRateHistoryData);
}
