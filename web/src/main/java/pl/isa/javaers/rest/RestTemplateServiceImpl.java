package pl.isa.javaers.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.isa.javaers.dto.CurrentTableDTO;
import pl.isa.javaers.dto.HistoryRateDTO;

import java.util.List;
@Component
public class RestTemplateServiceImpl implements RestTemplateService {
    private static final String URL1 = "http://api.nbp.pl/api/exchangerates/tables/A/";
    private static final String URL2 = "http://api.nbp.pl/api/exchangerates/rates/A/NOK/2024-02-01/2024-02-15/";
    private final RestTemplate restTemplate = new RestTemplate();


//    public RestTemplateServiceImpl() {
//    }

    @Override
    public CurrentTableDTO getCurrentNbpTable(){
        ResponseEntity<CurrentTableDTO[]> response = restTemplate.getForEntity(URL1, CurrentTableDTO[].class);
        return response.getBody()[0];
    }

    @Override
    public HistoryRateDTO getHistoryRateTable() {
        ResponseEntity<HistoryRateDTO> restHistoryRateResponse = restTemplate.getForEntity(URL2, HistoryRateDTO.class);
        return restHistoryRateResponse.getBody();
    }
}
