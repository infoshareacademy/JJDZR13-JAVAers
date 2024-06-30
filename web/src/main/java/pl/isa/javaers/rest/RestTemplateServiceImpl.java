package pl.isa.javaers.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.isa.javaers.dto.CurrentTableDTO;

import java.util.List;
@Component
public class RestTemplateServiceImpl implements RestTemplateService {
    private static final String URL1 = "http://api.nbp.pl/api/exchangerates/tables/A/";
    private final RestTemplate restTemplate = new RestTemplate();


//    public RestTemplateServiceImpl() {
//    }

    @Override
    public CurrentTableDTO getCurrentNbpTable(){
        ResponseEntity<CurrentTableDTO[]> response = restTemplate.getForEntity(URL1, CurrentTableDTO[].class);
        return response.getBody()[0];
    }
}
