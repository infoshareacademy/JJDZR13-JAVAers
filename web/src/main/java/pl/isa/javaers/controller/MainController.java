package pl.isa.javaers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.isa.javaers.Alert;
import pl.isa.javaers.Main;
import pl.isa.javaers.UI;
import pl.isa.javaers.configuration.Settings;

import java.util.List;

@Controller
public class MainController {
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

    model.addAttribute("content", "_rates")
            .addAttribute("rates", .....)
    }
}
