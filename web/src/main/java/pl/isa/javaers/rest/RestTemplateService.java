package pl.isa.javaers.rest;

import pl.isa.javaers.dto.CurrentTableDTO;
import pl.isa.javaers.dto.HistoryRateDTO;

public interface RestTemplateService {
    CurrentTableDTO getCurrentNbpTable();
    HistoryRateDTO getHistoryRateTable();
}
