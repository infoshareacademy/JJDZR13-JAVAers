package pl.isa.javaers;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static pl.isa.javaers.ErrorCodes.*;

public class Alert {
    private String alertID;             //unique alert identifier
    private String userID;              //unique User identifier
    private String currCode;            //three letters currency code ie. PLN, USD, GBP
    private float course;               // value ie. 16,5643 (four places after comma)
    private boolean higherOrLower;      //True for higher False for lower than course

    public Alert(String userID, String currCode, float course, boolean higherOrLower) {
        this.alertID = GeneratorAlertID.generatorAlertID();
        this.userID = userID;
        this.currCode = currCode;
        this.course = course;
        this.higherOrLower = higherOrLower;
    }
    public Alert(String alertID, String userID, String currCode, float course, boolean higherOrLower) {
        this.alertID = alertID;
        this.userID = userID;
        this.currCode = currCode;
        this.course = course;
        this.higherOrLower = higherOrLower;
    }

    public Alert() {
    }

    @Override
    public String toString() {
        return "Alert{" +
                "alertID='" + alertID + '\'' +
                ", userID='" + userID + '\'' +
                ", currCode='" + currCode + '\'' +
                ", course=" + course +
                ", higherOrLower=" + higherOrLower +
                '}';
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

    //
    public int create(String userID, String cCode, float course, boolean hL) {
        int errCode = 0;            //error code, 0 - means no error, alert created
        this.userID=userID;
        this.currCode=cCode;
        this.course=course;
        this.higherOrLower=hL;

        if(0 != User.checkID(userID)) return(USER_WRONGID);
        if(0 != Assets.checkCurrencyCode(cCode)) return(ASSETS_WRONGCCODE);

        Alert alert = new Alert(userID,cCode,course,hL);
        System.out.println(alert.toString());

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            //bez poniższej komendy - objectMapper nie ma dostępu do prywatnych pól obiektu alert i mamy RunTime Err
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            //objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            objectMapper.writeValue(new File("src/main/resources/alerts.json"),alert);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return(errCode);
    }

}

