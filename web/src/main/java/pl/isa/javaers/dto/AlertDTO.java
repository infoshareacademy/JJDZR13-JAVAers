package pl.isa.javaers.dto;

import org.springframework.beans.factory.annotation.Autowired;
import pl.isa.javaers.model.Alert;
import pl.isa.javaers.model.User;
import pl.isa.javaers.service.UserService;

import java.util.UUID;

public class AlertDTO {
    private String alertID;             //unique alert identifier
    private String userID;              //unique User identifier
    private String currCode;            //three letters currency code ie. PLN, USD, GBP
    private float course;               // value ie. 16,5643 (four places after comma)
    private boolean higherOrLower;      //True for higher False for lower than course

    private UserService userService;

    public AlertDTO() {
    }

    public AlertDTO(String alertID, String userID, String currCode, float course, boolean higherOrLower) {
        this.alertID = alertID;
        this.userID = userID;
        this.currCode = currCode;
        this.course = course;
        this.higherOrLower = higherOrLower;
    }
    public Alert toAlert(User user) {
//        User user = userService.getUserById(Long.getLong(this.getUserID()));
        return new Alert(user, this.getCurrCode(), this.getCourse(), this.isHigherOrLower());
    }
    public Alert toAlert(String alertID, User user) {
//        User user = userService.getUserById(Long.getLong(this.getUserID()));
        return new Alert(UUID.fromString(alertID), user, this.getCurrCode(), this.getCourse(), this.isHigherOrLower());
    }

    public String getAlertID() {
        return alertID;
    }

    public void setAlertID(String alertID) {
        this.alertID = alertID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getCurrCode() {
        return currCode;
    }

    public void setCurrCode(String currCode) {
        this.currCode = currCode;
    }

    public float getCourse() {
        return course;
    }

    public void setCourse(float course) {
        this.course = course;
    }

    public boolean isHigherOrLower() {
        return higherOrLower;
    }

    public void setHigherOrLower(boolean higherOrLower) {
        this.higherOrLower = higherOrLower;
    }
}
