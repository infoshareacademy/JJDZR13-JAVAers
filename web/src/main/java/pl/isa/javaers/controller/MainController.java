package pl.isa.javaers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.isa.javaers.*;
import pl.isa.javaers.configuration.Settings;
import pl.isa.javaers.service.RateService;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    RateService rateService;
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
        List<Rate> tmpRates = rateService.readRatesFromJSON();
        String rateName = rateService.rateName;
    model.addAttribute("content", "_rates")
            .addAttribute("tmpRates", tmpRates)
            .addAttribute("currencyName", rateName);
    return "rate-history";
    }
    @GetMapping("/rates-form")
    String ratesForm(Model model) {
        model.addAttribute("content", "_rates-form")
                .addAttribute("kursNBP", new KursNBP());
        return "rateHistoryForm";
    }
    @PostMapping(value = "/rates-form")
        String getRatesParamForm(KursNBP kursNBP, Model model){
        model.addAttribute("content", "_rates-form");
        return "redirect:/rates";
    }
}
