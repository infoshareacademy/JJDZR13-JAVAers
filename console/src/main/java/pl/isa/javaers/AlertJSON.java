package pl.isa.javaers;

public class AlertJSON {
    private String alertID;             //unique alert identifier
    private String userID;              //unique User identifier
    private String currCode;            //three letters currency code ie. PLN, USD, GBP
    private float course;               // value ie. 16,5643 (four places after comma)
    private boolean higherOrLower;      //True for higher False for lower than course

    public AlertJSON(String userID, String currCode, float course, boolean higherOrLower) {
        this.alertID = GeneratorAlertID.generatorAlertID();
        this.userID = userID;
        this.currCode = currCode;
        this.course = course;
        this.higherOrLower = higherOrLower;
    }
    public AlertJSON(String alertID, String userID, String currCode, float course, boolean higherOrLower) {
        this.alertID = alertID;
        this.userID = userID;
        this.currCode = currCode;
        this.course = course;
        this.higherOrLower = higherOrLower;
    }

    public AlertJSON() {
    }


    @Override
    public String toString() {
        return "AlertJSON{" +
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


}

