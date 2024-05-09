package pl.isa.javaers.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.isa.javaers.*;
import pl.isa.javaers.configuration.Settings;
import pl.isa.javaers.model.UserRateHistoryData;
import pl.isa.javaers.service.RateServiceImpl;

import java.io.IOException;
import java.util.List;

@Controller
public class MainController {

//    @Autowired
//    RateService rateService;
private final RateServiceImpl rateServiceImpl;
public MainController(RateServiceImpl rateServiceImpl){this.rateServiceImpl = rateServiceImpl;}

    @GetMapping("/")
    String welcome(Model model) {
        model.addAttribute("content","_welcome");
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
//        List<Rate> tmpRates = rateService.readRatesFromJSON();
        List<Rate> tmpRates = rateServiceImpl.getFilteredRateLIst(new UserRateHistoryData());
        String rateName = rateServiceImpl.rateName;
    model.addAttribute("content", "_rates")
            .addAttribute("tmpRates", tmpRates)
            .addAttribute("currencyName", rateName);
    return "rate-history";
    }
    @GetMapping("/rates-form")
    String ratesForm(Model model) {
        model.addAttribute("content", "_rates-form")
                .addAttribute("userRateHistoryData", new UserRateHistoryData());
        return "rateHistoryForm";
    }
    @PostMapping(value = "/rates-form")
        String getRatesParamForm(@ModelAttribute UserRateHistoryData userRateHistoryData, Model model){
        model.addAttribute("content", "_rates-form");
        rateServiceImpl.createData(userRateHistoryData);
        rateServiceImpl.getFilteredRateLIst(userRateHistoryData);
        return "redirect:/rates";
    }
}
