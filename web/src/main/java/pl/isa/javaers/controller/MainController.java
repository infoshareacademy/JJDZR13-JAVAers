package pl.isa.javaers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.isa.javaers.Alert;
import pl.isa.javaers.Alerts;
import pl.isa.javaers.Main;
import pl.isa.javaers.UI;
import pl.isa.javaers.configuration.Settings;
import pl.isa.javaers.model.AlertStr;
import pl.isa.javaers.service.Assets;

import java.util.List;

import static pl.isa.javaers.JAVAers.assetCodes;

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

        AlertStr alertStr = new AlertStr();
        model.addAttribute("alertnew", alertStr);

        model.addAttribute("content", "_alertsList");
        model.addAttribute("alerts", tmpAlerts);
//        List<String> stringList = Assets.listCodes();
        model.addAttribute("assetCodes", assetCodes);
        return "alertsList";
    }
    @PostMapping("/alertsave")
    String ModyfikacjaAlertu(Model model, @ModelAttribute Alert alert) {
//        alert.setUserID(Settings.user);
        Main.alerts.modifyAlert(alert);
        Main.alerts.saveAlerts();
        return "redirect:/alerts";
    }
    @PostMapping("/alertdelete")
    String UsuniecieAlertu(Model model, @RequestParam(value = "delNameID") String delNameID ) {
//        alert.setUserID(Settings.user);
        System.out.println(delNameID);
        Main.alerts.removeFromAlerts(delNameID);
        Main.alerts.saveAlerts();
        return "redirect:/alerts";
    }
    @PostMapping("/newalert")
    String DodanieAlertu(Model model, @ModelAttribute("alertnew") AlertStr alertStr) {
        System.out.println(alertStr.toString());
        alertStr.setUserID(Settings.user);
        Alert alertTmp = alertStr.toAlert();
        if(alertTmp != null) {
            Main.alerts.addToAlerts(alertTmp);
            Main.alerts.saveAlerts();
        }
        return "redirect:/alerts";
    }
}
