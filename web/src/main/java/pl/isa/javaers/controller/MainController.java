package pl.isa.javaers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.isa.javaers.Alert;
import pl.isa.javaers.Main;
import pl.isa.javaers.configuration.Settings;
import pl.isa.javaers.dto.CurrentTableDTO;
import pl.isa.javaers.dto.HistoryRateDTO;
import pl.isa.javaers.model.CurrRates;
import pl.isa.javaers.model.Rate;
import pl.isa.javaers.model.UserRateHistoryData;
import pl.isa.javaers.rest.RestTemplateService;
import pl.isa.javaers.rest.RestTemplateServiceImpl;
import pl.isa.javaers.service.RateService;
import pl.isa.javaers.service.RateServiceImpl;

import java.util.List;


@Controller
public class MainController {

    private final RateService rateService;
    private final RestTemplateService restTemplateService;

    public MainController(RateServiceImpl rateService, RestTemplateServiceImpl restTemplateServiceImpl) {
        this.rateService = rateService;
        this.restTemplateService = restTemplateServiceImpl;
    }

    @GetMapping("/")
    String welcome(Model model) {
//        RestTemplateServiceImpl restTemplateServiceImpl = new RestTemplateServiceImpl(new RestTemplate());

        CurrentTableDTO currentTableDTO = restTemplateService.getCurrentNbpTable();
        String tableDetails = "nr " + currentTableDTO.getNo() + " z dnia " + currentTableDTO.getEffectiveDate();
        List<CurrRates> currNbpTable;
        currNbpTable = currentTableDTO.getRates().stream()
                .filter(currRates -> currRates.getCode().matches("^(EUR|USD|HUF|CHF|GBP|JPY|CZK|DKK|NOK|SEK|RON|BGN|TRY|CNY)$"))
                .toList();

        model.addAttribute("content", "_welcome")
                .addAttribute("courses", currNbpTable)
                .addAttribute("tableDetails", tableDetails);
        return "index";
    }

    @GetMapping("/alerts")
    String listaAlertów(Model model) {
        List<Alert> tmpAlerts = Main.alerts.getUserAlerts(Settings.user);
//        UI.showAlerts(tmpAlerts, Main.user);
        model.addAttribute("content", "_alertsList");
        model.addAttribute("alerts", tmpAlerts);
        return "alertsList";
    }

    @GetMapping("/rates")
    String listaKursówWalut(Model model) {
        model.addAttribute("content", "_rates")
                .addAttribute("tmpRates", rateService.getFilteredRateLIst())
                .addAttribute("currencyName", rateService.getRateName());
        return "rate-history";
    }

    @GetMapping("/rates-form")
    String ratesForm(Model model) {
        model.addAttribute("content", "_rates-form")
                .addAttribute("userRateHistoryData", new UserRateHistoryData());
        return "rateHistoryForm";
    }

    @PostMapping(value = "/rates-form")
    String getRatesParamForm(@ModelAttribute UserRateHistoryData userRateHistoryData, Model model) {
        model.addAttribute("content", "_rates-form");
        rateService.createData(userRateHistoryData);
        rateService.filterRatesByDate(userRateHistoryData);
        return "redirect:/rates";
    }

    @GetMapping("/rates-history")
    String getHistoryRatesREST(Model model) {

        HistoryRateDTO historyRateDTO = restTemplateService.getHistoryRateTable();
        String historyDetails = "Kurs " + historyRateDTO.getCurrency();
        List<Rate> historyRates;
        historyRates = historyRateDTO.getRates().stream().toList();

        model.addAttribute("content", "_rates-history-content")
                .addAttribute("tableDetails", historyDetails)
                .addAttribute("historyRates", historyRates);
        return "rate-history-rest";
    }
}
