package pl.isa.javaers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.isa.javaers.AlertJSON;
import pl.isa.javaers.Main;
import pl.isa.javaers.configuration.Settings;
import pl.isa.javaers.dto.AlertDTO;
import pl.isa.javaers.model.Alert;
import pl.isa.javaers.model.AlertStr;
import pl.isa.javaers.model.User;
import pl.isa.javaers.service.AlertService;
import pl.isa.javaers.service.UserService;

import java.util.List;

import static pl.isa.javaers.JAVAers.assetCodes;

@Controller
public class MainController {
    private final AlertService alertService;
    private final UserService userService;

    public MainController(AlertService alertService, UserService userService) {
        this.alertService = alertService;
        this.userService = userService;
    }

    @GetMapping("/")
    String welcome(Model model) {
        model.addAttribute("content","_welcome");
        return "index";
    }
    @GetMapping("/regulamin")
    String regulamin(Model model) {
        model.addAttribute("content","_regulamin");
        return "regulamin";
    }
    @GetMapping("/alerts")
    String listaAlertów(Model model) {
        List<AlertJSON> tmpAlertJSONS = Main.alerts.getUserAlerts(Settings.user);
//        UI.showAlerts(tmpAlertJSONS, Main.user);

        AlertStr alertStr = new AlertStr();
        model.addAttribute("alertnew", alertStr);

        model.addAttribute("content", "_alertsList");
        model.addAttribute("alerts", tmpAlertJSONS);
//        List<String> stringList = Assets.listCodes();
        model.addAttribute("assetCodes", assetCodes);
        return "alertsList";
    }
    @PostMapping("/alertsave")
    String ModyfikacjaAlertu(Model model, @ModelAttribute AlertJSON alertJSON) {
//        alertJSON.setUserID(Settings.user);
        Main.alerts.modifyAlert(alertJSON);
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
        AlertJSON alertJSONTmp = alertStr.toAlert();
        if(alertJSONTmp != null) {
            Main.alerts.addToAlerts(alertJSONTmp);
            Main.alerts.saveAlerts();
        }
        return "redirect:/alerts";
    }
    @GetMapping("/alerts/list/{id}")
    String alertListSql(Model model, @PathVariable String id) {
//    List<Alert> alertListSql(Model model, @PathVariable String id) {
//        List<Alert> userAlerts = alertService.getUserAlerts(Long.parseLong(id));
        List<AlertDTO> userAlertsDTO = alertService.getUserAlertsDTO(Long.parseLong(id));

        AlertStr alertStr = new AlertStr();
        model.addAttribute("alertnew", alertStr);

        model.addAttribute("content", "_alertsListSQL");
        model.addAttribute("alerts", userAlertsDTO);
//        List<String> stringList = Assets.listCodes();
        model.addAttribute("assetCodes", assetCodes);
        return "alertsListSQL";
    }

    @PostMapping("/newalertSQL")
    String DodanieAlertuSQL(Model model, @ModelAttribute("alertnew") AlertDTO alertDTO) {
        alertDTO.setUserID("1");
        User user = userService.getUserById(Long.parseLong(alertDTO.getUserID()));
        Alert alert = alertDTO.toAlert(user);
        alertService.saveAlert(alert);
//        alertStr.setUserID(Settings.user);
//        AlertJSON alertJSONTmp = alertStr.toAlert();
//        if(alertJSONTmp != null) {
//            Main.alerts.addToAlerts(alertJSONTmp);
//            Main.alerts.saveAlerts();
        return "redirect:/alerts/list/1";
    }
}
