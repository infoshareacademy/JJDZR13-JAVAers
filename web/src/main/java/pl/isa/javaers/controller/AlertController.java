package pl.isa.javaers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static pl.isa.javaers.JAVAers.assetCodes;

@RestController
@RequestMapping("/alerty")
public class AlertController {
    private final AlertService alertService;
//    private final UserService userService;

    @Autowired
    public AlertController(AlertService alertService, UserService userService) {
        this.alertService = alertService;
//        this.userService = userService;
    }
    @GetMapping
    public List<Alert> getAlerts() {
        return alertService.getAllAlerts();
    }
    @GetMapping("/{id}")
    public Alert getAlertById(@PathVariable UUID id) {
        return alertService.getAlertById(id);
    }

    @PostMapping("/newalertSQL")
    public Alert createAlert(@RequestBody AlertDTO alertDTO) {
        Alert alert = alertDTO.toAlert();
        return alertService.saveAlert(alert);
    }


}
