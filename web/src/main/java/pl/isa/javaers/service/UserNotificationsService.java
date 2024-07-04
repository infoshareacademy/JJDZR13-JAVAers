package pl.isa.javaers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.isa.javaers.AlertJSON;
import pl.isa.javaers.dto.CurrentTableDTO;
import pl.isa.javaers.model.Alert;
import pl.isa.javaers.model.CurrRates;
import pl.isa.javaers.model.User;
import pl.isa.javaers.model.UserNotification;
import pl.isa.javaers.rest.RestTemplateService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserNotificationsService {


    UserService userService;
    AlertService alertService;
    RestTemplateService restTemplateService;
    private List<UserNotification> userNotifications = new ArrayList<>();

    public UserNotificationsService(UserService userService, AlertService alertService, RestTemplateService restTemplateService) {
        this.userService = userService;
        this.alertService = alertService;
        this.restTemplateService = restTemplateService;
    }

    public int fillList(){
        CurrentTableDTO currentTableDTO = restTemplateService.getCurrentNbpTable();
        List<CurrRates> currNbpTable;
        currNbpTable = currentTableDTO.getRates();
        String loggedInUsername = userService.getLoggedInUsername();
        long userID = userService.getUserByUsername(loggedInUsername).getId();
        List<Alert> userAlerts = alertService.getUserAlerts(userID);
        for (Alert alert : userAlerts) {
            String currCode = alert.getCurrCode();
            Double alertCourse = (double) alert.getCourse();
            Optional<Double> currNbpValue = currNbpTable.stream().filter(currRates -> currRates.getCode().equals(currCode)).map(CurrRates::getMid).findFirst();
            if (currNbpValue.isPresent()) {

                Double currMidValue = currNbpValue.get();
                int compareResult = Double.compare(alertCourse, currMidValue);

                if ((compareResult < 0 && alert.isHigherOrLower()) || (compareResult > 0 && !alert.isHigherOrLower())) {
                    this.userNotifications.add(new UserNotification(currCode,alert.isHigherOrLower(),alert.getCourse(), (double) currMidValue));
                }
            }

        }
        return userNotifications.size();
    }


    public List<UserNotification> getUserNotifications() {
        return userNotifications;
    }
}
