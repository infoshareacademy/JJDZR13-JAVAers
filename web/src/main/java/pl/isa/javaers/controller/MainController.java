package pl.isa.javaers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import pl.isa.javaers.AlertJSON;
import pl.isa.javaers.Main;
import pl.isa.javaers.configuration.Settings;
import pl.isa.javaers.dto.CurrentTableDTO;
import pl.isa.javaers.model.CurrRates;
import pl.isa.javaers.model.UserRateHistoryData;
import pl.isa.javaers.rest.RestTemplateService;
import pl.isa.javaers.rest.RestTemplateServiceImpl;
import pl.isa.javaers.service.*;
import pl.isa.javaers.dto.AlertDTO;
import pl.isa.javaers.model.Alert;
import pl.isa.javaers.model.AlertStr;
import pl.isa.javaers.model.User;

import java.util.List;
import java.util.UUID;

import static pl.isa.javaers.JAVAers.assetCodes;


@Controller
public class MainController {

    private final RateService rateService;
    private final RestTemplateService restTemplateService;
    private final AlertService alertService;
    private final UserService userService;

@Autowired
    public MainController(RateServiceImpl rateService, RestTemplateServiceImpl restTemplateServiceImpl, AlertService alertService, UserService userService) {
        this.rateService = rateService;
        this.restTemplateService = restTemplateServiceImpl;
        this.alertService = alertService;
        this.userService = userService;
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
    @GetMapping("/regulamin")
    String regulamin(Model model) {
        boolean isLogged = false;
        if (userService.getLoggedInUsername() != null) isLogged = true;
        model.addAttribute("content","_regulamin")
                .addAttribute("isLogged",isLogged);
        return "regulamin";
    }
    @GetMapping("/loginFault")
    String loginFault(Model model) {
        return "loginFault";
    }
    @GetMapping("/message")
    String message(Model model, @RequestParam(value = "error", required = false) String error) {
        if(error.equals("loginError")) { model
                .addAttribute("messageTitle", "Logowanie nie powiodło się.")
                .addAttribute("messageContent", "Sprawdź czy CapsLock nie jest wciśnięty i ponów próbę starannie wprowadzając nazwę uzytkownika i hasło");
        }
        return "message";
    }
    @GetMapping("/panel")
    String panel(Model model) {
        model.addAttribute("content","_welcome")
        .addAttribute("whoIsThis","Hello " + userService.getLoggedInUsername() + ". Witaj w sekcji dla zalogowanych");
        return "panel";
    }
    @GetMapping("/sandbox/alerts/list")
    String listaAlertów(Model model) {
        List<AlertJSON> tmpAlertJSONS = Main.alerts.getUserAlerts(Settings.user);

        AlertStr alertStr = new AlertStr();
        model.addAttribute("alertnew", alertStr)
        .addAttribute("content", "_alertsList")
        .addAttribute("alerts", tmpAlertJSONS)
        .addAttribute("assetCodes", assetCodes);
        return "alertsList";
    }

    @GetMapping("/rates")
    String listaKursówWalut(Model model) {
        model.addAttribute("content", "_rates")
                .addAttribute("tmpRates", rateService.getFilteredRateLIst())
                .addAttribute("currencyName", rateService.getRateName());
        return "rate-history";
    }
    @GetMapping("/notifications")
    String listNotifications(Model model) {
    StringBuilder headerMessage = new StringBuilder(userService.getLoggedInUsername() + ", niestety obowiązujące dziś kursy walut w NBP nie spełniły żadnego ze zdefiniowanych alertów");
    UserNotificationsService userNotificationsService = new UserNotificationsService(userService, alertService, restTemplateService);
    if(userNotificationsService.fillList() > 0) {
        headerMessage = new StringBuilder(userService.getLoggedInUsername() + ", oto Twoje dzisiejsze powiadomienia:");
        model.addAttribute("notifications", userNotificationsService.getUserNotifications());
    }
    model.addAttribute("content", "_notifications")
        .addAttribute("headerMessage",headerMessage);

    return "notifications";
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
    @PostMapping("/sandbox/alert/save")
    String ModyfikacjaAlertu(Model model, @ModelAttribute AlertJSON alertJSON) {
        alertJSON.setUserID(Settings.user);
        Main.alerts.modifyAlert(alertJSON);
        Main.alerts.saveAlerts();
        return "redirect:/sandbox/alerts/list";
    }
    @PostMapping("/sandbox/alert/delete")
    String UsuniecieAlertu(Model model, @RequestParam(value = "delNameID") String delNameID ) {
//        alert.setUserID(Settings.user);
        System.out.println(delNameID);
        Main.alerts.removeFromAlerts(delNameID);
        Main.alerts.saveAlerts();
        return "redirect:/sandbox/alerts/list";
    }
    @PostMapping("/sandbox/alert/new")
    String DodanieAlertu(Model model, @ModelAttribute("alertnew") AlertStr alertStr) {
        System.out.println(alertStr.toString());
        alertStr.setUserID(Settings.user);
        AlertJSON alertJSONTmp = alertStr.toAlert();
        if(alertJSONTmp != null) {
            Main.alerts.addToAlerts(alertJSONTmp);
            Main.alerts.saveAlerts();
        }
        return "redirect:/sandbox/alerts/list";
    }
    @GetMapping("/alerts/list")
    String alertListSql(Model model) {
        Long sqlID = userService.getUserByUsername(userService.getLoggedInUsername()).getId();
        List<AlertDTO> userAlertsDTO = alertService.getUserAlertsDTO(sqlID);
        AlertStr alertStr = new AlertStr();
        model.addAttribute("alertnew", alertStr)
        .addAttribute("content", "_alertsListSQL")
        .addAttribute("alerts", userAlertsDTO)
        .addAttribute("assetCodes", assetCodes);
        return "alertsListSQL";
    }

    @PostMapping("/alert/new")
    String AddSqlAlert(Model model, @ModelAttribute("alertnew") AlertDTO alertDTO) {
        User user = userService.getUserByUsername(userService.getLoggedInUsername());
        Alert alert = alertDTO.toAlert(user);
        alertService.saveAlert(alert);
        return "redirect:/alerts/list";
    }
    @PostMapping("/alert/save")
    String EditSqlAlert(Model model, @ModelAttribute AlertDTO alertDTO) {
        User user = userService.getUserByUsername(userService.getLoggedInUsername());
        Alert alert = alertDTO.toAlert(alertDTO.getAlertID(), user);
        alertService.saveAlert(alert);
        return "redirect:/alerts/list";
    }
    @PostMapping("/alert/delete")
    String RemoveSqlAlert(Model model, @RequestParam(value = "delNameID") String delNameID ) {
        alertService.deleteAlert(UUID.fromString(delNameID));
        return "redirect:/alerts/list";
    }
}
