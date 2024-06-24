package pl.isa.javaers.model;

import jakarta.persistence.*;
import pl.isa.javaers.dto.AlertDTO;

import java.util.UUID;

@Entity
@Table(name="alerts")
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id", updatable = false, nullable = false)
    private UUID alertID;             //unique alert identifier

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;              //unique User identifier

    @Column(name="curr_code")
    private String currCode;            //three letters currency code ie. PLN, USD, GBP
    private float course;               // value ie. 16,5643 (four places after comma)
    @Column(columnDefinition = "TINYINT(1)")
    private boolean higherOrLower;      //True for higher False for lower than course


    public Alert() {
    }

    public Alert(UUID uuid, User user, String currCode, float course, boolean higherOrLower) {
        this.alertID = uuid;
        this.user = user;
        this.currCode = currCode;
        this.course = course;
        this.higherOrLower = higherOrLower;
    }

    public Alert(User user, String currCode, float course, boolean higherOrLower) {
        this.user = user;
        this.currCode = currCode;
        this.course = course;
        this.higherOrLower = higherOrLower;
    }

    public UUID getAlertID() {
        return alertID;
    }

    public void setAlertID(UUID alertID) {
        this.alertID = alertID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
    public AlertDTO toDTO() {
        return new AlertDTO(this.getAlertID().toString(),
                this.getUser().getId().toString(),
                this.getCurrCode(),
                this.getCourse(),
                this.isHigherOrLower());
    }
}

