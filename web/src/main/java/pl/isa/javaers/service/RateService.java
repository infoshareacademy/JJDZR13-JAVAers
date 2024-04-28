package pl.isa.javaers.service;

import pl.isa.javaers.Rate;
import pl.isa.javaers.model.UserRateHistoryData;

import java.util.List;

public interface RateService {
    List<Rate> readRatesFromJSON();
    List<Rate> getFilteredRateLIst();
    void createData(UserRateHistoryData userRateHistoryData);
}
