package pl.isa.javaers.model;

import pl.isa.javaers.AlertJSON;

public class AlertStr {
//    private String alertID;             //unique alert identifier
    private String userID;              //unique User identifier
    private String currCode;            //three letters currency code ie. PLN, USD, GBP
    private String course;               // value ie. 16,5643 (four places after comma)
    private boolean higherOrLower;      //True for higher False for lower than course


    public AlertStr() {
    }


//    public AlertStr(String userID, String currCode, String course) {
//        this.alertID = GeneratorAlertID.generatorAlertID();
//        this.userID = userID;
//        this.currCode = currCode;
//        this.course = course;
//    }
//
//    public String getAlertID() {
//        return alertID;
//    }
//
//    public void setAlertID(String alertID) {
//        this.alertID = alertID;
//    }
//
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    public boolean isHigherOrLower() {
        return higherOrLower;
    }

    public void setHigherOrLower(boolean higherOrLower) {
        this.higherOrLower = higherOrLower;
    }

    public AlertJSON toAlert() {
        try {
            float value = Float.parseFloat(this.getCourse());
        }
                catch(Exception e) {
                    System.out.println("Niepoprawny format danych");
                    return null;
                }
//        return new pl.isa.javaers.AlertJSON(
//                this.getUserID(),
//                this.getCurrCode(),
//                Float.parseFloat(this.getCourse()),
//                this.isHigherOrLower());
        return new AlertJSON(
                this.getUserID(),
                this.getCurrCode(),
                Float.parseFloat(this.getCourse()),
                this.isHigherOrLower());
    }
}
