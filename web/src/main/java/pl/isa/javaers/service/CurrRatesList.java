package pl.isa.javaers.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.isa.javaers.Alert;
import pl.isa.javaers.dto.CurrentTableDTO;
import pl.isa.javaers.model.CurrRates;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static pl.isa.javaers.Settings.ALERTS_FILE;

public class CurrRatesList {
    public static List<CurrRates> currRatesList = new ArrayList<>();


    public List <CurrRates> loadFromDTO(List<CurrRates> currNbpTable) {
//        List<CurrRates> currNbpTable = new ArrayList<>();
//        currNbpTable = currentTableDTO.getRates();

        Iterator<CurrRates> ratesIterator = currNbpTable.iterator();
        while (ratesIterator.hasNext()) {
            CurrRates rates = ratesIterator.next();
            currRatesList.add(new CurrRates(rates.getCurrency(), rates.getCode(), rates.getMid()));
        }
//        this.currRatesList = currNbpTable.stream().toList();
        return currRatesList;
    }
}
